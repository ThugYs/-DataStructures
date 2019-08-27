package binaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <E extends Comparable<E>>{

    class Node{
        public  E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;
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
     * define a public method. within method , call the add(Integer value, int [] arr) to recusive
     * return the new root after insert.
     * @param e
     */

    public void add(E e) {
          /*
        Step 1 temp = root
        Step 2 and compare root with the newNode, if newNode is greater than root,
         if right child is null, insert, if not null, compare the right child of root with the newNode, recursively loop to step 2 and temp =right child
         Step 3 in step 2, if newNode is smaller than root, if left child is null,insert, if not null, compare the left child of root with newNode,
         Step 4 recursively loop to step 2 and temp =right child
         */
          root = add(root, e);
    }

    /***
     * the base line of recusive: node is null,
     * means already find the right location, cuz as the definded flow, the null
     * @param root
     * @param e
     * @return
     */

    public Node add(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        /***
         * if the newNode is smaller than root, go recusicely to left child tree.
         * if(node.e.compareTo(e) > 0) {
         *  /*
         *   *the recusive add method is add newNode, and return new root
         *   *node.left = add(node.left, e)  receive return of the recusive method
         * }
         */
           /*
        Step 1 temp = root
        Step 2 and compare root with the newNode, if newNode is greater than root,
         if right child is null, insert, if not null, compare the right child of root with the newNode, recursively loop to step 2 and temp =right child
         Step 3 in step 2, if newNode is smaller than root, if left child is null,insert, if not null, compare the left child of root with newNode,
         Step 4 recursively loop to step 2 and temp =right child
         */
        if (root.e.compareTo(e) > 0) {
            root.left = add(root.left, e);
        } else if (root.e.compareTo(e) < 0) {
            //same as left
            root.right = add(root.right, e);
        }
        return root;
    }

    public boolean search(E e) {
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

    public E removeMax(E e){
        return e;
    }

    public void remove(E e){
        //return the new Root after return
        root = remove(root, e);
    }
    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        // 递归终止条件
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }
    /**
     * 查找树中最小元素
     * @return
     */
    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return minimum(root).e;
    }

    /**
     * 查找以node为根节点的最小元素, 递归方法
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除二分搜索树中的最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根节点的树的最小值
     * @param node
     * @return 返回删除后的新的二分搜索树的根
     */
    private Node removeMin(Node node){
        // 递归终止条件
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public Node  remove(Node temp, E e){
        /***
         * 删除叶子节点, 直接删除即可
         *
         * 删除只有右子树的节点, 逻辑同删除最小值, 虽然这个节点不一定是最小值, 但是删除逻辑是一样的
         *
         * 删除只有左子树的节点, 逻辑同删除最大值
         *
         * 删除同时具有左右子树的节点, 这个时候删除节点的步骤稍微复杂一些
         */
        if (temp == null) {
            return null;
        }
        if (temp.e.compareTo(e) > 0) {
            temp.left =remove(temp.left, e);
            return temp;
            // node.e < e
        }else if (temp.e.compareTo(e) < 0) {
            temp.right = remove(temp.right, e);
            return temp;
        }else {
            //pending to remove this node
            if (temp.left == null) {
                Node rightNode = temp.right;
                temp.right = null;
                size --;
                return rightNode;
            }
            if (temp.right == null) {
                Node leftNode = temp.left;
                temp.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况

            // 查找待删除节点的后继节点
            // 用后继节点替换当前待删除节点

            // 查找后继节点, 从待删除节点的右子树,查找最小值
            Node successor = minimum(temp.right);
            /*
             *  需要注意的是, 这里removeMin中进行了size--操作,
             *  但是实际上最小的元素变成了successor, 并没有删除
             *  所以按照逻辑的话, 这里应该有一个size++
             *  但是后面删除了元素之后,需要再进行一次size--, 所以这里就不对size进行操作了
             */
            successor.right = removeMin(temp.right);
            successor.left = temp.left;
            // 后继节点完成替换, 删除当前节点
            temp.left = temp.right = null;
            return successor;


        }

    }


    public void levelOrder(){
        // LinkedList实现了Queue接口
        Queue<Node> queue = new LinkedList<>();
        /*
         * 遍历过程:
         * 1. 首先根节点入队
         * 2. 每次出队时, 都将当前节点的左右孩子先后入队
         * 3. 如果队列为空的话, 则表示层序遍历结束
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
