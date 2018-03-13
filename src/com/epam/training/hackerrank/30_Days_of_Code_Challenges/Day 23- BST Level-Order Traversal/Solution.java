class Solution {
    static void levelOrder(Node root) {
        int h = height(root);
        for (int i = 1; i <= h; i++)
            levelOrder(root, i);

    }

    static void levelOrder(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            levelOrder(root.left, level - 1);
            levelOrder(root.right, level - 1);
        }
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }
}
