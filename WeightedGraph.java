import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public void addVertex(Vertex vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public Set<Vertex> getVertices() {
        return map.keySet();
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        Edge<Vertex> edge = new Edge<>(source, destination, weight);
        map.computeIfAbsent(source, key -> new ArrayList<>()).add(edge);
        map.computeIfAbsent(destination, key -> new ArrayList<>()).add(edge);
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge<Vertex>>> entry : map.entrySet()) {
            Vertex vertex = entry.getKey();
            List<Edge<Vertex>> edges = entry.getValue();
            System.out.print("Vertex: " + vertex + " Edges: ");
            edges.forEach(edge -> System.out.print(edge + " "));
            System.out.println();
        }
    }

    public void removeVertex(Vertex vertex) {
        map.remove(vertex);
        map.values().forEach(edges -> edges.removeIf(edge -> edge.getDes().equals(vertex)));
    }

    public void removeEdge(Vertex source, Vertex destination) {
        List<Edge<Vertex>> edges = map.get(source);
        edges.removeIf(edge -> edge.getDes().equals(destination));
    }

    public List<Vertex> getNeighbors(Vertex vertex) {
        List<Vertex> neighbors = new ArrayList<>();
        List<Edge<Vertex>> edges = map.getOrDefault(vertex, new ArrayList<>());
        for (Edge<Vertex> edge : edges) {
            if (!edge.getDes().equals(vertex)) {
                neighbors.add(edge.getDes());
            }
        }
        return neighbors;
    }

    public double getWeight(Vertex source, Vertex destination) {
        List<Edge<Vertex>> edges = map.get(source);
        for (Edge<Vertex> edge : edges) {
            if (edge.getDes().equals(destination)) {
                return edge.getWeight();
            }
        }
        return Double.POSITIVE_INFINITY;
    }
}
