

public class MaxTreePath {
    public static class Node {
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        int val;
        Node left, right;
    }

    public class MaxPathResult {
        Node resultStart;
        int pathLength;
    }

    public static void main(String[] args) {
        Node testNode0 = new Node(0);
        Node testNode1 = new Node(1, new Node(2), null);
        Node testNode3 = new Node(1, null, new Node(2, null, new Node(4)));
        Node testNode4 = new Node(1, null, new Node(3, new Node(4), null));
        Node testNode5 = new Node(0, new Node(1, new Node(0, new Node(1, new Node(2), new Node(1)), null), null), new Node(1));

        assert findMaxConsecPath(testNode0) == 1;
        assert findMaxConsecPath(testNode1) == 2;
        assert findMaxConsecPath(null) == 0;
        assert findMaxConsecPath(testNode3) == 2;
        assert findMaxConsecPath(testNode4) == 2;
        assert findMaxConsecPath(testNode5) == 3;
    }

    public static int findMaxConsecPath(Node root) {
        if (root == null) return 0;
        int left = findMaxConsecPath(root.left, root.val, 1);
        int right = findMaxConsecPath(root.right, root.val, 1);

        return left > right ? left : right;
    }

    public static int findMaxConsecPath(Node root, int prevVal, int prevLeng) {
        if (root == null) return prevLeng;
        int currChain = root.val == prevVal + 1 ? prevLeng + 1 : 1;
        int leftVal = findMaxConsecPath(root.left, root.val, currChain);
        int rightVal = findMaxConsecPath(root.right, root.val, currChain);

        return leftVal > rightVal ? leftVal : rightVal;
    }
}
