// BFS: Shortest Reach In A Graph
// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        private Node[] nodes;
        private static int EDGE_DISTANCE = 6;

        public Graph(int size) {
            this.nodes = new Node[size];
            for(int i = 0; i < size; i++){
                this.nodes[i] = new Node(i);
            }
        }

        private class Node{
            private int id;
            private LinkedList<Integer> neighbors = new LinkedList<Integer>();

            private Node(int id){
                this.id = id;
            }
        }

        public void addEdge(int first, int second) {
            nodes[first].neighbors.add(second);
            nodes[second].neighbors.add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(startId);

            int[] distances = new int[nodes.length];
            Arrays.fill(distances, -1);
            distances[startId] = 0;

            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int neighbor : nodes[node].neighbors){
                    if(distances[neighbor] == -1){
                        distances[neighbor] = distances[node] + EDGE_DISTANCE;
                        queue.add(neighbor);
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
