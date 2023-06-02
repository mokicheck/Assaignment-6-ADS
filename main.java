import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static WeightedGraph<Vertex<Integer>> graph = new WeightedGraph<>();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addVertex();
                    break;
                case 2:
                    addEdge();
                    break;
                case 3:
                    printGraph();
                    break;
                case 4:
                    breadthFirstSearch();
                    break;
                case 5:
                    dijkstraSearch();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        System.out.println("BYE BYE!");
    }

    private static void printMenu() {
        System.out.println("Enter your choice:");
        System.out.println("1. Add vertex");
        System.out.println("2. Add edge");
        System.out.println("3. Print graph");
        System.out.println("4. Breadth-First Search");
        System.out.println("5. Dijkstra's Algorithm");
        System.out.println("6. Exit");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void addVertex() {
        System.out.println("Enter vertex value:");
        int vertexValue = scanner.nextInt();
        Vertex<Integer> vertex = new Vertex<>(vertexValue);
        graph.addVertex(vertex);
        System.out.println("Vertex added.");
    }

    private static void addEdge() {
        System.out.println("Enter source vertex value:");
        int sourceValue = scanner.nextInt();
        System.out.println("Enter destination vertex value:");
        int destinationValue = scanner.nextInt();
        System.out.println("Enter edge weight:");
        double weight = scanner.nextDouble();

        Vertex<Integer> source = new Vertex<>(sourceValue);
        Vertex<Integer> destination = new Vertex<>(destinationValue);
        graph.addEdge(source, destination, weight);

        System.out.println("Edge added.");
    }

    private static void printGraph() {
        System.out.println("Graph:");
        graph.printGraph();
    }

    private static void breadthFirstSearch() {
        System.out.println("Enter starting vertex value for Breadth-First Search:");
        int startBFSValue = scanner.nextInt();
        Vertex<Integer> startBFS = new Vertex<>(startBFSValue);

        BreadthFirstSearch<Vertex<Integer>> bfs = new BreadthFirstSearch<>();
        System.out.println("Breadth-First Search traversal:");
        System.out.println(bfs.traverse(graph, startBFS));
    }

    private static void dijkstraSearch() {
        System.out.println("Enter starting vertex value for Dijkstra's Algorithm:");
        int startDijkstraValue = scanner.nextInt();
        Vertex<Integer> startDijkstra = new Vertex<>(startDijkstraValue);

        DijkstraSearch<Vertex<Integer>> dijkstra = new DijkstraSearch<>();
        System.out.println("Dijkstra's Algorithm traversal:");
        System.out.println(dijkstra.traverse(graph, startDijkstra));
    }
}
