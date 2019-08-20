package linkedList;

public class DoubleLinkedList {
    private DoubleNode head;
    public DoubleLinkedList(){

    }
    public DoubleNode getNode() {
        return head;
    }
    public void setNode(DoubleNode node) {
        this.head = node;
    }
    public void list(){
        if(this.head.next == null){
            System.out.println("empty");
        }
        for( DoubleNode temp = this.head.next; temp != null; temp = temp.next){
            System.out.println(temp);
        }
    }
    public void add(DoubleNode node){
        DoubleNode temp;
        for(temp = this.head; temp.next != null; temp=temp.next){

        }
        temp.next = node;
        node.pre = temp;
    }
    public void del(int value) {
        if (this.head.next == null) {
            System.out.println("empty");
        }
        DoubleNode temp = this.head.next;
        boolean flag;
        for(flag = false; temp != null; temp = temp.next) {
            if (temp.value == value) {
                flag = true;
                break;
                }
            }

            if (flag) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.printf("no value\n", value);
            }

        }



}
