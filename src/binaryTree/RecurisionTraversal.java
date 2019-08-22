package binaryTree;

public class RecurisionTraversal {
    /***
     * mid left right, means tranversal left child tree first of root, then right child tree
     * @param root
     */
    public static void preorderTranversal(TreeNode root){
        if(root != null){
            //first into stack is root = root.left, and until root.left = null,
            // all left branch has been tranversaled and print.
            System.out.println(root.val+ "");
            //pop from stack until,  root, in this process, all left child tree has been tranveral
            preorderTranversal(root.left);
            preorderTranversal(root.right);
        }
    }
    /***
     * left mid right
     * @param root
     */
    public static void midorderTranversal(TreeNode root){
        if(root !=null){
            midorderTranversal(root.left);
            System.out.println(root.val+" ");
            midorderTranversal(root.right);
        }
    }

    /***
     * left right mid
     * @param root
     */
    public static void postorderTranversal(TreeNode root){
        if(root !=null){
            postorderTranversal(root.left);
            postorderTranversal(root.right);
            System.out.println(root.val);
        }
    }
}
