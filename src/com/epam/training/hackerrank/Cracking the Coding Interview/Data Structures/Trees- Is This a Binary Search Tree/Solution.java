public class Solution {
    boolean checkBST(Node root) {
        return checkBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    boolean checkBSTUtil(Node node, int min, int max) {

        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;


        return (checkBSTUtil(node.left, min, node.data - 1) &&
                checkBSTUtil(node.right, node.data + 1, max));
    }
}
