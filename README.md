# Assaignment-6-ADS

Certainly! Here's the information about each class in your code:

## `main` class [Link](Main.java)
- This class contains the main method and serves as the entry point for the program.
- It provides a menu-driven interface for interacting with the graph and running different graph algorithms.
- The user can choose options to add vertices, add edges, print the graph, perform breadth-first search, perform Dijkstra's algorithm, or exit the program.

## `DijkstraSearch` class [Link](DijkstraSearch.java)
- This class implements the Dijkstra's algorithm for finding the shortest path from a given starting vertex to all other vertices in a weighted graph.
- It uses a priority queue to process the vertices based on their distances from the starting vertex.
- The `traverse` method takes a weighted graph and a starting vertex as input and returns a list of vertices representing the shortest path from the starting vertex to each vertex in the graph.

## `BreadthFirstSearch` class [Link](BreadthFirstSearch.java)
- This class implements the breadth-first search algorithm for traversing a graph.
- It uses a queue to process the vertices in a breadth-first order.
- The `traverse` method takes a weighted graph and a starting vertex as input and returns a list of vertices representing the order in which the vertices are visited during the breadth-first search traversal.

## `Search` interface [Link](Search.java)
- This interface defines a generic search algorithm for traversing a weighted graph.
- It includes a single method, `traverse`, which takes a weighted graph and a starting vertex as input and returns a list of vertices representing the traversal order.

## `Vertex` class [Link](Vertex.java)
- This class represents a vertex in the graph.
- It contains a data value and a map of adjacent vertices with their corresponding edge weights.
- The `addAdjacentVertex` method allows adding an adjacent vertex with the associated edge weight to the current vertex.
- The `getAdjacentVertices` method returns a map of the adjacent vertices and their weights.

## `test` class [Link](test.java)
- This class provides a test scenario for demonstrating the usage of the graph and algorithms.
- It creates a weighted graph and performs operations such as adding vertices, adding edges, printing the graph, and running breadth-first search and Dijkstra's algorithm.

Please note that the information provided here is a summary and may not cover all the details of each class.
