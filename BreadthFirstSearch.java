import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<V> implements Search<V> {
    private List<V> visit;

    public List<V> traverse(WeightedGraph<V> graph, V start) {
        visit = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        queue.offer(start);
        visit.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            List<V> neighbors = graph.getNeighbors(current);
            for (V neighbor : neighbors) {
                if (!visit.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.offer(neighbor);
                    visit.add(neighbor);
                }
            }
        }

        return visit;
    }
}
