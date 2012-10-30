package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class Graph {

    private List<Node> nodeList = new ArrayList<Node>();
    private List<Edge> edgeList = new ArrayList<Edge>();

    public Node createNode(String name) {
        Node node = new Node(name);
        nodeList.add(node);

        return node;
    }

    public Edge createEdge(Node firstNode, Node secondNode) {
        Edge edge = new Edge(firstNode, secondNode);
        edgeList.add(edge);

        return edge;
    }

    public Node getNodeByName(String name) {
        for (Node node : nodeList) {

            if (node.getName().equals(name)) {
                return node;
            }
        }

        return null;
    }

    public List<Edge> getAdjacentEdges(Node node) {
        List<Edge> adjacentEdges = new ArrayList<Edge>();

        for (Edge edge : edgeList) {
            if (edge.isConnectedTo(node)) {
                adjacentEdges.add(edge);
            }
        }

        return adjacentEdges;
    }

    public Edge getEdge(Node node1, Node node2) {
        for (Edge edge : edgeList) {

            if (edge.isConnectedTo(node1, node2)) {
                return edge;
            }
        }

        return null;
    }

    private class Node {

        private String name;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }

            Node node = (Node) o;

            if (name != null ? !name.equals(node.name) : node.name != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    private class Edge {

        private Node firstNode;
        private Node secondNode;

        public Edge(Node firstNode, Node secondNode) {
            this.firstNode = firstNode;
            this.secondNode = secondNode;
        }

        public Node getSecondNode() {
            return secondNode;
        }

        public Node getFirstNode() {
            return firstNode;
        }

        public boolean isConnectedTo(Node node) {
            return firstNode.equals(node) || secondNode.equals(node);
        }

        public boolean isConnectedTo(Node node1, Node node2) {
            return (firstNode.equals(node1) && secondNode.equals(node2))||
                (firstNode.equals(node2) && secondNode.equals(node1));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Edge)) {
                return false;
            }

            Edge edge = (Edge) o;

            if (firstNode != null ? !firstNode.equals(edge.firstNode) : edge.firstNode != null) {
                return false;
            }
            if (secondNode != null ? !secondNode.equals(edge.secondNode) : edge.secondNode != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = firstNode != null ? firstNode.hashCode() : 0;
            result = 31 * result + (secondNode != null ? secondNode.hashCode() : 0);
            return result;
        }
    }
}