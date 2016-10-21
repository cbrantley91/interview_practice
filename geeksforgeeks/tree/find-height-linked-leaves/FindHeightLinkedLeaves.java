public class FindHeightLinkedLeaves {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this(val, null, null);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int getHeight(TreeNode specTree) {
        if (specTree == null) return 0;
        if (isLeaf(specTree)) return 1;

        int leftHeight = getHeight(specTree.left);
        int rightHeight = getHeight(specTree.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public static boolean isLeaf(TreeNode current) {
        if (current.left == null || current.right == null) return false;
        return current.left.right == current && current.right.left == current;
    }

    public static void main(String[] args) {
        TreeNode nullCase = null;
        TreeNode singleCase = new TreeNode(0);
        singleCase.left = singleCase;
        singleCase.right = singleCase;

        TreeNode leftCase = new TreeNode(-1, singleCase, null);
        TreeNode rightCase = new TreeNode(-1, null, singleCase);

        TreeNode leaf1 = new TreeNode(6);
        TreeNode leaf2 = new TreeNode(5);
        TreeNode leaf3 = new TreeNode(3);

        // Could also do a test to see if malformed tree, aka one w/o the specified linkage, is good
        
        leaf1.left = leaf3;
        leaf1.right = leaf2;

        leaf2.left = leaf1;
        leaf2.right = leaf3;

        leaf3.left = leaf2;
        leaf3.right = leaf1;

        TreeNode baseCaseRoot = new TreeNode(1, new TreeNode(2, new TreeNode(4, leaf1, null), leaf2), leaf3);

        assert getHeight(nullCase) == 0;
        assert getHeight(singleCase) == 1;
        assert getHeight(leftCase) == 2;
        assert getHeight(rightCase) == 2;
        assert getHeight(baseCaseRoot) == 4;
    }
}
