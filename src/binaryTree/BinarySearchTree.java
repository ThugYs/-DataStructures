package binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/***
 *  recursive means ,the method applyed to root, then the left child will be a new child tree and apply same method
 * @param <E>
 */

public class BinarySearchTree <E extends Comparable<E>>{
    /***
     * define tree node, with left& child
     */
    class Node{
        public  E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    // have to define a Node root,
    // to record the new root after BinarySearchTree change
    // the size will be change with newNode added or node deleted
    private Node root;
    private int size;

    /***
     * the intiatal BinarySearchTree is null root and size = 0;
     */
    public BinarySearchTree(){
        this.root =null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0 ;
    }
    public int getSize(){
        return size;
    }


    /***
     * define a public method. within method ,
     * call the add(new root, E e) to recusive
     * return the new root after insert.
     * @param e newNode will be added to tree
     */
    public void add(E e) {
            //if root = null, root =add(null, e) = e
          root = add(root, e);
    }

    /***
     * the base line of recusive: node is null,
     * means already find the right location, cuz as the definded flow, the null
     * @param root the "root" of child tree
     * @param e newNode will be added
     * @return
     */

    public Node add(Node root, E e) {
        // meet base line, add newNode to the tree, and return the Node to previous root.left or root.right
        if (root == null) {
            size++;
            return new Node(e);
        }
         /*
        Step 1 temp = root
        Step 2 and compare the temp root with the newNode,
        step 3 if newNode is greater than root, go recurively to call step 1 and temp = root.right, call add(root.left, E e)
        step 4 if newNode is smaller than root, go recurively to call step 1 and temp = root.left, call add(root.right, E e)
        step 5 until the temp == root == null, end recursive process. insert

        /***
         * if the newNode is smaller than root, go recusicely to left child tree.
         * if(node.e.compareTo(e) > 0) {
         *  /*
         *   *the recusive add method is add newNode, and return new root
         *   *node.left = add(node.left, e)  receive return of the recusive method
         * }
         */

        if (root.e.compareTo(e) > 0) {
            root.left = add(root.left, e);
        } else if (root.e.compareTo(e) < 0) {
            //same as left
            root.right = add(root.right, e);
        }
        //if e = root.e, return e, cuz repeat e can not be added
        return root;
    }


    public boolean search(E e) {
        // same flow as "add"
        return search(root, e);
    }
    public boolean search(Node temp, E e){

        if (temp == null) {
            return false;
        }
        if(temp.e.compareTo(e) == 0){
            return true;
        }else if(temp.e.compareTo(e) > 0){
             return search(temp.left, e);
        }else {
            return search(temp.right, e);
        }
    }

    /***
     * remove is complex
     * , have to consider serveral conditions
     * @param node
     * @return
     */
    /**
     * find minimum e
     * @return
     */
    public E minimumE(){
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return minimumNode(root).e;
    }
    /**
     * 查找以node为根节点的最小元素, 递归方法
     * @param node
     * @return
     */
    private Node minimumNode(Node node){
        if (node.left == null) {
            return node;
        }
        return minimumNode(node.left);
    }
    /**
     * remove minimum e node
     * @return
     */
    public E removeMin(){
        E min = minimumE();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node){
        // base line
        if (node.left == null) {
            // temp = node.right, return the right to last call method,
            // cuz we will delete his parent,and parent.right will be the parent. means
            Node right = node.right;
            /***
             *                 5
             *          *    /   \
             *          *   3    6
             *          *  / \    \
             *          * 1  4     8
             *          *  \  \
             *             2  5
             *  in this case, recurively loop, 2.left==null, meet base line, stop recusive, and will remove 1,
             *  means, 3.left=2 and 1.right=null, so before return last call,
             *  in this call, node = 1 and node.right =2, return will be 1.right is 2, temp = 2 then, 1.right =0, return 2
             *  last call node.left = 2 end
             *                                5
             *              *          *    /   \
             *              *          *   3    6
             *              *          *  / \    \
             *              *          * 2  4     8
             *              *         1      \
             *              *                 5
             */

            size --;
            node.right = null;
            return right;
        }

        node.left = removeMin(node.left);
        //return this root(is node) to last call.only final call, run the base line code
        return node;
    }



/**
 *  用递归解决了，要记住上一个节点的问题，不需要多定义一个指针，学到这个思想

//    public E removeMin(Node root, E e){
//
//        /*
//        recursive loo pto find the minimum one,
//        there are two case:root.right ==null  || root.left==null
//
//        step 1 root.left != null root= root.left
//        step 2 root.left !=null
//         */
//        Node temp = root.left;
//        while(temp.left != null){
//            root = temp.left;
//            root = root.left;
//        }
//        return temp;
//        root.left = temp.right;
//
//
//    }

    public E maximumE(){
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return maximumNode(root).e;
    }
    public Node maximumNode(Node root){
        if(root.right ==null){
                //实际上这个递归就返回了这个，当root.right=null的时候
            return root;

        }
        return maximumNode(root.right);
    }

    public E removeMax(){
        E max = maximumE();
        root = removeMax(root);
        return max;

    }
    public Node removeMax(Node root){
        if(root.right == null){
            Node left = root.left;
            size --;
            root.left = null;
            return left;
        }
        root.right = removeMax(root.right);
        return root;
    }

    /***
     * remove random node in the BTS
     * @param e target node will be removed
     */
    public void remove(E e){
        //return the new Root after return
        root = remove(root, e);
    }
    public Node remove(Node root, E e){
        /***
         * if remove leaf, direct remove, simply.
         *
         * But if remove the node who has right node, put right child into the root location,and size--
         *
         * But if remove the node who has left node, put left child into the root location,and size--
         *
         * However, if remove the node who has left and right, have to check which is max and re-arrange
         */
        if (root == null) {
            return null;
        }
        if (root.e.compareTo(e) > 0) {
            root.left =remove(root.left, e);
            return root;
            // node.e < e
        }else if (root.e.compareTo(e) < 0) {
            root.right = remove(root.right, e);
            return root;
        }else {
            //pending to remove this node
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                size --;
                return rightNode;
            }
            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                size --;
                return leftNode;
            }
            // pending remove node.left && right !=null cuz all the right child node wil greater than left child node

            // As the current node as root.right, and find minimumNode, loop for following child tree

            Node successor = minimumNode(root.right);
            /*
             *  successor will the miniNode of rightNode, and
             *  需要注意的是, 这里removeMin中进行了size--操作,
             *  但是实际上最小的元素变成了successor, 并没有删除
             *  所以按照逻辑的话, 这里应该有一个size++
             *  但是后面删除了元素之后,需要再进行一次size--, 所以这里就不对size进行操作了
             */
            successor.right = removeMin(root.right);
            //left keep  previous, right will be new child tree after remove min,
            successor.left = root.left;
            // after replace. delete the current node, by set the left and right is null, and parents has been reset the child
            // no linked to this root, means, it has been deleted.
            root.left = root.right = null;
            return successor;
        }
    }

    /***
     * depth traversal with queue
     */
    public void levelOrder(){
        // LinkedList实现了Queue接口
        Queue<Node> queue = new LinkedList<>();
        /*
         * traversal process:
         * 1. firstly, root into queue
         * 2. When each pop, push their child (in order right->left into queue first
         * 3. until if queue is empty, means the traversal is done.
         *      5
         *    /   \
         *   3    6
         *  / \    \
         * 2  4     8
         * 针对上面的二分搜索树, 详细描述一下层序遍历步骤
         * 1. 5入队, 队列元素 : head->[5]<-tail
         * 2. 5出队, 5的左子树3, 6入队, 由于队列是先入先出(FIFO), 所以先左后右, 队列元素 : head->[3, 6]<-tail
         * 3. 3出队, 2, 4入队, 队列元素  : head->[6, 2, 4]<-tail
         * 4. 6出队, 左孩子为空,所以8入队, 队列元素  : head->[2, 4, 8]<-tail
         * 5. 2,4,8依次出队, 由于这三个节点都是叶子节点, 无子节点, 所以这三个节点出队后队列为空, 层序遍历完成
         * 6. 按照出队的顺序演示的遍历结果为 : 5 3 6 2 4 8
         */
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }



}
