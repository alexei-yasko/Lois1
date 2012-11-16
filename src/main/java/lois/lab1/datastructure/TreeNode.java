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

    private RelationTable relationTable = new RelationTable();

    public TreeNode(String type, TreeNode parent, Predicate nodePredicate) {
        this.type = type;
        this.parent = parent;
        this.nodePredicate = nodePredicate;
    }

    public RelationTable calculateRelationTable() {
        RelationTable resultRelationTable = new RelationTable();

        if (children.size() == 0) {
            return relationTable;
        }
        else if (type.equals(OR_TYPE)) {
            resultRelationTable = children.get(0).calculateRelationTable();

            for (int i = 1; i < children.size(); i++) {
                resultRelationTable = resultRelationTable.union(children.get(i).calculateRelationTable());
            }
        }
        else if (type.equals(AND_TYPE)) {
            resultRelationTable = children.get(0).calculateRelationTable();

            for (int i = 1; i < children.size(); i++) {
                resultRelationTable = resultRelationTable.join(children.get(i).calculateRelationTable());
            }
        }

        relationTable = resultRelationTable.projectTo(getNodePredicateVariableList());
        return relationTable;
    }

    /**
     * Prints tree of the logical inference.
     */
    public void printInferenceTree() {
        printInferenceTreeRec(this, 0);
    }

    /**
     * Recursive function that prints tree of the logical inference.
     *
     * @param currentNode current node of the tree
     * @param treeLevel level of the current node in the tree
     */
    private void printInferenceTreeRec(TreeNode currentNode, int treeLevel) {
        String levelIntend = "";
        for (int i = 0; i < treeLevel; i++) {
            levelIntend = levelIntend + "\t\t";
        }

        System.out.println(levelIntend + "^" + currentNode.getNodePredicate());
        System.out.println(levelIntend + "values: " + currentNode.getRelationTable());
        System.out.println(levelIntend + "similarity relation: " + currentNode.getSimilarityName());
        System.out.println(levelIntend + "node type: " + currentNode.getType());
        System.out.println();

        for (TreeNode childNode : currentNode.getChildren()) {
            printInferenceTreeRec(childNode, treeLevel + 1);
        }
    }

    public RelationTable getRelationTable() {
        return relationTable;
    }

    public void setRelationTable(RelationTable relationTable) {
        this.relationTable = relationTable;
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

    public List<Variable> getNodePredicateVariableList() {
        List<Variable> variableList = new ArrayList<Variable>();

        for (AtomSign atomSign : nodePredicate.getArgumentList()) {

            if (atomSign.getType() == AtomSignType.VAR) {
                variableList.add((Variable) atomSign);
            }
        }

        return variableList;
    }
}
