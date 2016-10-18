import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LevelLLCreator {
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
        
    }

    public Map<Integer, LinkedList<Integer>> createLinkedListEachLevel(Node root) {
        return createLinkedListAtDepth(root, 0, new HashMap<Integer, LinkedList<Integer>>());
    }

    public static Map<Integer, LinkedList<Integer>> createLinkedListAtDepth(Node root, int currLevel, Map<Integer, LinkedList<Integer>> depthMap) {
        if (root == null) return depthMap;

        if (!depthMap.containsKey(currLevel))
            depthMap.put(currLevel, new LinkedList<Integer>());
        depthMap.get(currLevel).add(root.val);
        createLinkedListAtDepth(root.left, currLevel + 1, depthMap);
        createLinkedListAtDepth(root.right, currLevel + 1, depthMap);
        return depthMap;
    }

    // Quick utilities from another practice to facilitate quick testing
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
