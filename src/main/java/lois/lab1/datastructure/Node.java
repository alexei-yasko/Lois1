package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class Node {

    public static final String AND_TYPE = "and";
    public static final String OR_TYPE = "or";

    private String type;

    private Node parent;

    private List<Node> children = new ArrayList<Node>();

    private List<AtomSign> constList = new ArrayList<AtomSign>();

    public Node(String type, Node parent) {
        this.type = type;
        this.parent = parent;
    }

    public void addConst(Constant constant) {
        constList.add(constant);
    }

    public List<AtomSign> getConstList() {
        return constList;
    }

    public void setConstList(List<AtomSign> constList) {
        this.constList = constList;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
