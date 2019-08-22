package binaryTree;

import java.util.Stack;

public class Traversal {
    /**
     * simulate the recusion with stack,
     * mid left right
     */
    public static void preorderTranversal(TreeNode root){
        //define a stack to store temp node
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp != null || !nodeStack.isEmpty() ){
            // first tranversal all left child tree, until temp = temp.left =null;
            while(temp !=null){
                System.out.println(temp.val);// mid
                //push temp into stack cuz, they will be poped later, for find previous root and root.right
                nodeStack.push(temp);//push root
                temp = temp.left;// internal loop left to left.left
                //done left
            }
            if(!nodeStack.isEmpty()){
                temp = nodeStack.pop();// pop left
                //only pop one node pre loop
                // not only  pop right , but also temp = temp.right,
                // next loop, the new case "root = temp.right, and find root.left and root.right,
                // loop until all left child tree have done
                // until pop root and root.right will lead to tranversal right child tree.
                temp = temp.right;//left.right will be nect loop temp
                //mid left right
            }
        }
    }

    /***
     * left mid right
     * @param root
     */
    public static void inorderTranversal(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp !=null || ! nodeStack.isEmpty()){
            while(temp !=null){
                 nodeStack.push(temp);
                 temp = temp.left;
            }
            if(! nodeStack.isEmpty()){
                temp = nodeStack.pop();
                System.out.println(temp.val);
                temp = temp.right;
            }
        }
    }

    /**
     * postorderTranversal
     * left right mid
     * problem: When determin whether print current node.val,
     * have to consider "have left and right child tree has been transversal? " cuz left child tree, then right, finally mid
     *
     */
    public static void postorderTranversal(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode temp = root;
        TreeNode lastVisit = root;
        while(temp !=null || ! nodeStack.isEmpty()) {
            while (temp != null) {
                //left.left until null, then
                nodeStack.push(temp);
                temp = temp.left;
            }
            // get peek element/ father of temp
            temp = nodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问,则可以直接输出当前节点的值
            if (temp.right == null || temp.right == lastVisit) {

                System.out.println(temp.val);
                nodeStack.pop();
                temp = nodeStack.pop();
                lastVisit = temp;
                temp = null;// tranveral all yet, so ship the left child,
                //it's time to find right
            } else {//else go to tranversal right
                temp = temp.right;
            }
        }
    }
}
