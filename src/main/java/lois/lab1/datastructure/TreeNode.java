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

    private Predicate nodePredicate;

    private String similarityName = "";

    //private List<AtomSign> valueList = new ArrayList<AtomSign>();

    private RelationsTable relationsTable = new RelationsTable();

    public TreeNode(String type, TreeNode parent, Predicate nodePredicate) {
        this.type = type;
        this.parent = parent;
        this.nodePredicate = nodePredicate;
    }

    public RelationsTable getRelationsTable() {
        return relationsTable;
    }

    public void setRelationsTable(RelationsTable relationsTable) {
        this.relationsTable = relationsTable;
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

    public String getSimilarityName() {
        return similarityName;
    }

    public void setSimilarityName(String similarityName) {
        this.similarityName = similarityName;
    }

    public Predicate getNodePredicate() {
        return nodePredicate;
    }

    public void setNodePredicate(Predicate nodePredicate) {
        this.nodePredicate = nodePredicate;
    }
}
