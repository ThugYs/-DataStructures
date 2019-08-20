package linkedList;

public class SingleLinkedList {
    // head node
    private Node head;

    public SingleLinkedList(Node head){
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /***
     * add node as last
     * @param newNode
     */
    public void addNode(Node newNode){
        if(head == null){return;}
        Node temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    /***
     *  traverse
     */
    public void traverse() {
        //临时节点，从首节点开始
        Node temp = head;
        while (temp != null) {
            System.out.println(+ temp.data);
            //继续下一个
            temp = temp.next;
        }
    }
    /***
     * remove node based on value first traverse
     * @param
     */
    public void removeValue(Integer value){
        Node temp = head.next;
        while(temp.next != null){
            if(temp.next.data.equals(value)){
                temp.next=temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /***
     *  remove node with index
     */
    public void removeNode(int index){
        Node temp = this.head.next;
        //check if index is correct
        if(index < 1 || index > linkedListlength()+1){
            System.out.println("index is valid");
            return;
        }
        //loop for index-- until index =0 remove
        while (--index !=0){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        }

    /***
     * get length
     * @return
     */
    public int linkedListlength() {
        int length = 0;
        //begin from head.next node
        Node temp = head;
        // find last node
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    /***
     * insert newNode with index
     * @param newNode
     * @param index
     */

    public void insertNode(Node newNode, int index){
        //首先需要判断指定位置是否合法，
        if (index < 1 || index > linkedListlength() + 1) {
            System.out.println("插入位置不合法。");
            return;
        }
        Node temp = head.next;
        while( --index != 0){
            temp = temp.next;
        }
        newNode.next= temp.next;
        temp.next = newNode;
    }

   
    public static void main(String[] args) {
        Node head = new Node();
        SingleLinkedList list = new SingleLinkedList(head);

        list.addNode(new Node(3));
        list.addNode(new Node(2));
        list.addNode(new Node(4));
        list.addNode(new Node(5));
        list.addNode(new Node(2));

        System.out.println(list.linkedListlength());
        System.out.println("------traverse-----");
        list.traverse();
        System.out.println("----insert----");
        list.insertNode(new Node(6), 2);
        list.traverse();
        System.out.println("------remove-----");
        //list.removeNode(23);
//        list.removeNode(list.linkedListlength()-1);
//        System.out.println("------remove-----");
//        list.removeValue(2);
//        list.traverse();
//        list.removeValue(2);
//        list.traverse();
        Node head2 =SingleLinkedListUtil.reversedList(head);
        System.out.println(head2);
        head = head2;
        System.out.println(head);
        list.traverse();
    }
}


