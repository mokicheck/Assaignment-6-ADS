public class test {
    public static void main(String[] args) {
        WeightedGraph<Vertex<Integer>> graph = new WeightedGraph<>();
        BreadthFirstSearch<Vertex<Integer>> bfs = new BreadthFirstSearch<>();
        DijkstraSearch<Vertex<Integer>> ds = new DijkstraSearch<>();

        Vertex<Integer> vertex1 = createVertex(1);
        Vertex<Integer> vertex2 = createVertex(2);
        Vertex<Integer> vertex3 = createVertex(3);
        Vertex<Integer> vertex4 = createVertex(4);
        Vertex<Integer> vertex5 = createVertex(5);
        Vertex<Integer> vertex6 = createVertex(6);

        addVertices(graph, vertex1, vertex2, vertex3, vertex4, vertex5, vertex6);

        addEdge(graph, vertex1, vertex2, 2);
        addEdge(graph, vertex3, vertex4, 1);
        addEdge(graph, vertex5, vertex3, 3);
        addEdge(graph, vertex1, vertex5, 4);

        System.out.println("Edges for vertex " + vertex1 + ": " + graph.getEdges(vertex1));
        System.out.println("Graph:");
        graph.printGraph();

        System.out.println("Breadth-First Search traversal from vertex " + vertex1 + ":");
        System.out.println(bfs.traverse(graph, vertex1));

        System.out.println("DijkstraSearch traversal from vertex " + vertex1 + ":");
        System.out.println(ds.traverse(graph, vertex1));

        System.out.println("DijkstraSearch traversal from vertex " + vertex3 + ":");
        System.out.println(ds.traverse(graph, vertex3));
    }

    private static <V> Vertex<V> createVertex(V value) {
        return new Vertex<>(value);
    }

    private static <V> void addVertices(WeightedGraph<Vertex<V>> graph, Vertex<V>... vertices) {
        for (Vertex<V> vertex : vertices) {
            graph.addVertex(vertex);
        }
    }

    private static <V> void addEdge(WeightedGraph<Vertex<V>> graph, Vertex<V> source, Vertex<V> destination, double weight) {
        graph.addEdge(source, destination, weight);
    }
}
