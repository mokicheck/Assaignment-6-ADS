import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Map<V, Double> distance;
    private Map<V, V> parentMap;
    private Set<V> visited;

    public List<V> traverse(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        distance = new HashMap<>();
        parentMap = new HashMap<>();
        visited = new HashSet<>();

        for (V vertex : graph.getVertices()) {
            distance.put(vertex, Double.POSITIVE_INFINITY);
        }
        distance.put(start, 0.0);

        dijkstra(start);

        return getPath(start);
    }

    private void dijkstra(V start) {
        PriorityQueue<Node<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(Node::getDistance));
        queue.offer(new Node<>(start, 0.0));

        while (!queue.isEmpty()) {
            Node<V> node = queue.poll();
            V current = node.getElement();

            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            List<V> neighbors = graph.getNeighbors(current);
            for (V destination : neighbors) {
                double newDistance = distance.get(current) + graph.getWeight(current, destination);
                if (newDistance < distance.get(destination)) {
                    distance.put(destination, newDistance);
                    parentMap.put(destination, current);
                    queue.offer(new Node<>(destination, newDistance));
                }
            }
        }
    }

    private List<V> getPath(V start) {
        List<V> path = new ArrayList<>();
        V current = start;

        while (parentMap.containsKey(current)) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    private static class Node<V> {
        private V element;
        private double distance;

        public Node(V element, double distance) {
            this.element = element;
            this.distance = distance;
        }

        public V getElement() {
            return element;
        }

        public double getDistance() {
            return distance;
        }
    }
}
