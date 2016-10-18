public class SortedBSTCreator {
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

        public int getDepth() {
            int leftDepth = left == null ? 0 : left.getDepth();
            int rightDepth = right == null ? 0 : right.getDepth();

            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }

        public boolean isBST() {
            if (left != null && (val <= left.val || !left.isBST()))
                return false;
            else if (right != null && (val >= right.val || !right.isBST()))
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        int[] sortedArr1 = new int[0];
        int[] sortedArr2 = new int[1];
        
        int numNodes = 16;
        int[] sortedArr3 = new int[numNodes];
        for (int ndx = 0; ndx < numNodes; ndx++)
            sortedArr3[ndx] = ndx;

        Node node1 = createTreeFromSorted(sortedArr3);
        Node node2 = createTreeFromSorted(sortedArr3, 0, 14);
        Node node3 = createTreeFromSorted(sortedArr1);
        Node node4 = createTreeFromSorted(sortedArr2);
        
        assert node1.getDepth() == 5;
        assert node2.getDepth() == 4;

        assert node1.isBST();
        assert node2.isBST();
        assert node3 == null;
        assert node4.getDepth() == 1;
        assert node4.val == 0;
        
    }


    public static Node createTreeFromSorted(int[] sortedArr) {
        return createTreeFromSorted(sortedArr, 0, sortedArr.length - 1);
    }

    public static Node createTreeFromSorted(int[] sortedArr, int leftNdx, int rightNdx) {
        if (rightNdx < leftNdx) return null;
        if (leftNdx == rightNdx) return new Node(sortedArr[leftNdx]);

        int midNdx = (leftNdx + rightNdx) / 2; 
        return new Node(sortedArr[midNdx], createTreeFromSorted(sortedArr, leftNdx, midNdx - 1), createTreeFromSorted(sortedArr, midNdx + 1, rightNdx));
    }
}
