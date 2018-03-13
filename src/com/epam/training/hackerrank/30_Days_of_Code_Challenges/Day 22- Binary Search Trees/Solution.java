class Solution {
    public static int getHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + getHeight(root.right);
        }
        if (root.right == null) {
            return 1 + getHeight(root.left);
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
