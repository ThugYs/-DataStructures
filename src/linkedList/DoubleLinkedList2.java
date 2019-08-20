package linkedList;

public class DoubleLinkedList2 {
    private Node head;
    public DoubleLinkedList2(){
        /***
         * inital linkedlist, only one node is headnode , head.prev = head, head.next = head;
         */
        head = new Node(0,null,null);
        head.prev = head;
        head.next = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    public void list(){
        if(this.head.next == head){
            System.out.println("empty");
        }
        for(Node temp = this.head.next; temp !=head; temp = temp.next){
            System.out.println(temp);
        }
    }
    public void add(Node node){
        Node temp = this.head;
        while(temp.next != head){
           temp  = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = head;
    }
    public void remove(Integer value){
        if(this.head.next == head){
            System.out.println("empty");
        }
        Node temp = head.next;
        /***
         * flag if value exist in  this linkedlist, flag true and break, target = temp.
         * temp.prev.next = temp.next;
         * temp.next.pre = temp.prev
         */
        boolean flag;
        for(flag = false; temp !=head; temp = temp.next){
            if(temp.data.equals(value)){
                flag = true;
                break;
            }
        }
        if(flag){
           temp.prev.next = temp.next;
           temp.next.prev = temp.prev;
        }else {
            System.out.println("no exists");
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList2 list = new DoubleLinkedList2();
        list.list();
        list.add(new Node(2));
        list.list();

    }
}
