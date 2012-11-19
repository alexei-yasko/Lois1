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
        List<TreeNode> resultChildList = getChildNodeList(false);
        List<TreeNode> similarChildList = getChildNodeList(true);

        if (similarChildList.isEmpty()) {
            relationTable = calculateRelationTable(resultChildList);
        }
        else if (resultChildList.isEmpty()) {
            relationTable = calculateRelationTable(similarChildList);
        }
        else {
            relationTable = processSimilarResults(
                calculateRelationTable(resultChildList), calculateRelationTable(similarChildList), getUsedSimilarityName());
        }

        return relationTable;
    }

    /**
     * Prints tree of the logical inference.
     */
    public String printInferenceTree() {
        return printInferenceTreeRec(this, 0);
    }

    public RelationTable getRelationTable() {
        return relationTable;
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public TreeNode getParent() {
        return parent;
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

    public List<AtomSign> getNodePredicateVariableList() {
        List<AtomSign> variableList = new ArrayList<AtomSign>();

        for (AtomSign atomSign : nodePredicate.getArgumentList()) {

            if (atomSign.getType() == AtomSignType.VAR) {
                variableList.add(atomSign);
            }
        }

        return variableList;
    }

    private List<TreeNode> getChildNodeList(boolean isForSimilar) {
        List<TreeNode> resultNodeList = new ArrayList<TreeNode>();

        for (TreeNode child : children) {
            if (isForSimilar) {
                if (!child.getSimilarityName().equals("")) {
                    resultNodeList.add(child);
                }
            }
            else {
                if (child.getSimilarityName().equals("")) {
                    resultNodeList.add(child);
                }
            }
        }

        return resultNodeList;
    }

    /**
     * Recursive function that prints tree of the logical inference.
     *
     * @param currentNode current node of the tree
     * @param treeLevel level of the current node in the tree
     */
    private String printInferenceTreeRec(TreeNode currentNode, int treeLevel) {
        StringBuilder resultBuilder = new StringBuilder();

        String levelIntend = "";
        for (int i = 0; i < treeLevel; i++) {
            levelIntend = levelIntend + "\t\t";
        }

        resultBuilder.append(levelIntend).append("^").append(currentNode.getNodePredicate()).append("\n");
        resultBuilder.append(levelIntend).append("values: ").append(currentNode.getRelationTable()).append("\n");
        resultBuilder.append(levelIntend).append("similarity relation: ").append(currentNode.getSimilarityName()).append("\n");
        resultBuilder.append(levelIntend).append("node type: ").append(currentNode.getType()).append("\n");
        resultBuilder.append("\n");

        for (TreeNode childNode : currentNode.getChildren()) {
            resultBuilder.append(printInferenceTreeRec(childNode, treeLevel + 1));
        }

        return resultBuilder.toString();
    }

    private RelationTable calculateRelationTable(List<TreeNode> childrenList) {
        RelationTable resultRelationTable = new RelationTable();

        if (childrenList.size() == 0) {
            return relationTable;
        }
        else if (type.equals(OR_TYPE)) {
            resultRelationTable = childrenList.get(0).calculateRelationTable();
            for (int i = 1; i < childrenList.size(); i++) {
                RelationTable childRelationTable = childrenList.get(i).calculateRelationTable();
                resultRelationTable = resultRelationTable.union(childRelationTable);
            }
        }
        else if (type.equals(AND_TYPE)) {
            resultRelationTable = childrenList.get(0).calculateRelationTable();

            for (int i = 1; i < childrenList.size(); i++) {
                resultRelationTable = resultRelationTable.join(childrenList.get(i).calculateRelationTable());
            }
        }

        return resultRelationTable.projectTo(getNodePredicateVariableList());
    }

    private RelationTable processSimilarResults(RelationTable resultsTable, RelationTable similarTable, String similarityName) {

        RelationTable processedTable = new RelationTable(resultsTable.getTitleList());

        for (List<AtomSign> resultRow : resultsTable.getAllRows()) {
            for (List<AtomSign> similarRow : similarTable.getAllRows()) {

                List<AtomSign> row = processSimilarRow(resultRow, similarRow, similarityName);

                if (row != null) {
                    processedTable.addRow(resultsTable.getTitleList(), row);
                }
            }
        }

        return processedTable;
    }

    private List<AtomSign> processSimilarRow(List<AtomSign> resultRow, List<AtomSign> similarRow, String similarityName) {
        boolean isSimilar = true;

        for (int i = 0; i < resultRow.size(); i++) {
            if (!KnowledgeBase.getInstance().isSignSimilar(resultRow.get(i), similarRow.get(i), similarityName)) {
                isSimilar = false;
            }
        }

        if (isSimilar) {
            return resultRow;
        }
        else {
            return null;
        }
    }

    private String getUsedSimilarityName() {
        String nodeSimilarityName = "";

        for (TreeNode child : children) {

            if (!child.getSimilarityName().equals("")) {
                nodeSimilarityName = child.getSimilarityName();
            }
        }

        return nodeSimilarityName;
    }
}
