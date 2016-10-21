import java.util.LinkedList;
import java.util.Arrays;

public class ConvertBinTreeToDLList {
    public static class TreeNode {
        public TreeNode root, left, right;
        public int val;

        public TreeNode(int val) {
            this(val, null, null);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class DLListNode {
        public DLListNode next, prev;
        public int val;

        public DLListNode(int val) {
            this(val, null, null);
            this.next = this;
            this.prev = this;
        }

        public DLListNode(int val, DLListNode prev, DLListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        // In reality, better to use an iterator, but that's ok
        public LinkedList<Integer> getForwardOrder() {
            LinkedList<Integer> res = new LinkedList<Integer>();
            res.add(this.val);

            DLListNode next = this.next;
            while (next != this) {
                res.add(next.val);
                next = this.next;
            }

            return res;
        }

        public LinkedList<Integer> getBackwardOrder() {
            LinkedList<Integer> res = new LinkedList<Integer>();
            res.add(this.val);

            DLListNode prev = this.prev;
            while (prev != this) {
                res.add(prev.val);
                prev = prev.prev;
            }

            return res;
        }
    }

    public static  DLListNode convertBTToDLL(TreeNode root) {
        DLListNode leftStart, leftEnd, rightStart, rightEnd, rootRes;
        
        if (root == null)
            return null;

        rootRes = new DLListNode(root.val);
        leftStart = convertBTToDLL(root.left);
        rightStart = convertBTToDLL(root.right);
        
        if (leftStart == null) {
            leftStart = rootRes;
            leftEnd = rootRes;
        }
        else
            leftEnd = leftStart.prev;
        if (rightStart == null) {
            rightStart = rootRes;
            rightEnd = rootRes;
        }
        else
            rightEnd = rightStart.prev;

        leftEnd.next = rootRes;
        rootRes.prev = leftEnd;

        rootRes.next = rightStart;
        rightStart.prev = rootRes;

        rightEnd.next = leftStart;
        leftStart.prev = rightEnd;
        
        return leftStart;
    }
    
    public static void main(String[] args) {
        TreeNode caseNull = null;
        TreeNode caseSingle = new TreeNode(10);
        TreeNode caseLeft = new TreeNode(10, new TreeNode(1), null);
        TreeNode caseRight = new TreeNode(10, null, new TreeNode(20));
        TreeNode caseNormal = new TreeNode(10, new TreeNode(12, new TreeNode(25), new TreeNode(30)), new TreeNode(15, new TreeNode(36), null));

        // other things to consider : very large trees; how do I make sure this works on them
        
        assert convertBTToDLL(caseNull) == null;
        System.out.print(".");
        assert convertBTToDLL(caseSingle).getForwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 10 )));
        System.out.print(".");
        assert convertBTToDLL(caseSingle).getBackwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 10 )));
        System.out.print(".");
        assert convertBTToDLL(caseLeft).getForwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 1, 10 )));
        System.out.print(".");
        assert convertBTToDLL(caseLeft).getBackwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 10, 1 )));
        System.out.print(".");
        assert convertBTToDLL(caseRight).getForwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 10, 20 )));
        System.out.print(".");
        assert convertBTToDLL(caseRight).getBackwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 20, 10 )));
        System.out.print(".");
        assert convertBTToDLL(caseNormal).getForwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 25, 12, 30, 10, 36, 15 )));
        System.out.print(".");
        assert convertBTToDLL(caseNormal).getBackwardOrder().equals(new LinkedList<Integer>(Arrays.asList( 15, 36, 10, 30, 12, 25 )));
        System.out.print("Finished!");
        
    }
}


