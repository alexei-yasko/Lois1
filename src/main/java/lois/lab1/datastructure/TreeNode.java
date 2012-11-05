package lois.lab1.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Q-YAA
 */
public class TreeNode {

    public static final String AND_TYPE = "and";
    public static final String OR_TYPE = "or";

    private String type;

    private TreeNode parent;

    private List<TreeNode> children = new ArrayList<TreeNode>();

    private List<AtomSign> valueList = new ArrayList<AtomSign>();

    public TreeNode(String type, TreeNode parent) {
        this.type = type;
        this.parent = parent;
    }

    public void addValue(AtomSign value) {
        valueList.add(value);
    }

    public void addValueList(List<AtomSign> valueList) {
        this.valueList.addAll(valueList);
    }

    public List<AtomSign> getValueList() {
        return valueList;
    }

    public void setValueList(List<AtomSign> valueList) {
        this.valueList = valueList;
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
