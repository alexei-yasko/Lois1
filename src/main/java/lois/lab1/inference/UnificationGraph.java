package lois.lab1.inference;

import java.util.ArrayList;
import java.util.List;

import lois.lab1.datastructure.AtomSign;
import lois.lab1.datastructure.AtomSignType;
import lois.lab1.datastructure.Pair;
import lois.lab1.datastructure.Predicate;

/**
 * @author Q-YAA
 */
public class UnificationGraph {

    private List<Node> nodeList = new ArrayList<Node>();
    private List<Edge> edgeList = new ArrayList<Edge>();

    /**
     * Create unification graph for two predicates.
     *
     * @param predicate1 first predicate
     * @param predicate2 second predicate
     * @return result unification graph
     */
    public static UnificationGraph create(Predicate predicate1, Predicate predicate2) {
        UnificationGraph unificationGraph = new UnificationGraph();

        int minArgumentSize = Math.min(predicate1.getArgumentList().size(), predicate2.getArgumentList().size());

        for (int i = 0; i < minArgumentSize; i++) {
            UnificationGraph.Node node1 = unificationGraph.createNode(predicate1.getArgumentList().get(i));
            UnificationGraph.Node node2 = unificationGraph.createNode(predicate2.getArgumentList().get(i));
            unificationGraph.createEdge(node1, node2);

            if (node1.getSign().getType() == AtomSignType.CONST) {
                unificationGraph.createEdge(node1, node1);
            }

            if (node2.getSign().getType() == AtomSignType.CONST) {
                unificationGraph.createEdge(node2, node2);
            }
        }

        return unificationGraph;
    }

    /**
     * Create graph node. If this node doesn't contains in graph adds them.
     *
     * @param sign node sign
     * @return created node
     */
    public Node createNode(AtomSign sign) {
        Node node = new Node(sign);

        if (!nodeList.contains(node)) {
            nodeList.add(node);
        }

        return node;
    }

    /**
     * Create edge between nodes.
     *
     * @param firstNode first node
     * @param secondNode second node
     * @return created edge
     */
    public Edge createEdge(Node firstNode, Node secondNode) {
        Edge edge = new Edge(firstNode, secondNode);

        if (!edgeList.contains(edge)) {
            edgeList.add(edge);
        }

        return edge;
    }

    /**
     * Return node by the given sign.
     *
     * @param sign sign to find
     * @return found node or null
     */
    public Node getNodeBySign(AtomSign sign) {
        for (Node node : nodeList) {

            if (node.getSign().equals(sign)) {
                return node;
            }
        }

        return null;
    }

    /**
     * Return all edges that adjacent for given node.
     *
     * @param node node to find
     * @return result edge list
     */
    public List<Edge> getAdjacentEdges(Node node) {
        List<Edge> adjacentEdges = new ArrayList<Edge>();

        for (Edge edge : edgeList) {
            if (edge.isConnectedTo(node)) {
                adjacentEdges.add(edge);
            }
        }

        return adjacentEdges;
    }

    /**
     * Return edge that connect two given nodes.
     *
     * @param node1 first node
     * @param node2 second node
     * @return found edge or null
     */
    public Edge getEdge(Node node1, Node node2) {
        for (Edge edge : edgeList) {

            if (edge.isConnectedTo(node1, node2)) {
                return edge;
            }
        }

        return null;
    }

    /**
     * Build unificator from the created unification graph.
     *
     * @return created unificator
     */
    public Unificator buildUnificator() {
        Unificator unificator = new Unificator();

        for (Edge edge : edgeList) {
            Node connectedToFirstConstNode = getConnectedConstNode(edge.getFirstNode());
            Node connectedToSecondConstNode = getConnectedConstNode(edge.getSecondNode());

            if (connectedToFirstConstNode != null) {
                unificator.addElement(
                    new Pair<AtomSign, AtomSign>(edge.getFirstNode().getSign(), connectedToFirstConstNode.getSign()));
            }
            else if (connectedToSecondConstNode != null) {
                unificator.addElement(
                    new Pair<AtomSign, AtomSign>(edge.getSecondNode().getSign(), connectedToSecondConstNode.getSign()));
            }
            else {
                unificator.addElement(
                    new Pair<AtomSign, AtomSign>(edge.getFirstNode().getSign(), edge.getSecondNode().getSign()));
            }
        }

        return unificator;
    }

    private Node getConnectedConstNode(Node node) {
        return getConnectedConstNodeRec(node, new ArrayList<Node>());
    }

    private Node getConnectedConstNodeRec(Node node, List<Node> passedNodeList) {

        for (Edge edge : getAdjacentEdges(node)) {
            Node otherNode = edge.getOther(node);

            if (passedNodeList.contains(otherNode)) {
                continue;
            }

            passedNodeList.add(node);

            if (otherNode.getSign().getType() == AtomSignType.CONST) {
                return otherNode;
            }
            else {
                return getConnectedConstNodeRec(otherNode, passedNodeList);
            }
        }

        return null;
    }

    public class Node {

        private AtomSign sign;

        public Node(AtomSign sign) {
            this.sign = sign;
        }

        public AtomSign getSign() {
            return sign;
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

            if (sign != null ? !sign.equals(node.sign) : node.sign != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return sign != null ? sign.hashCode() : 0;
        }
    }

    public class Edge {

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

        public Node getOther(Node node) {
            return firstNode.equals(node) ? secondNode : firstNode;
        }

        public boolean isConnectedTo(Node node) {
            return firstNode.equals(node) || secondNode.equals(node);
        }

        public boolean isConnectedTo(Node node1, Node node2) {
            return (firstNode.equals(node1) && secondNode.equals(node2)) ||
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