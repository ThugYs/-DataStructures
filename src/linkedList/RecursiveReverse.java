package linkedList;

import com.sun.org.apache.bcel.internal.generic.RET;

public class RecursiveReverse {


    public static Node recursiveReverse(Node head){
        //cant check in while(node!=null),
        //only can be checked by node.next!-=null
        //1->2->3->4
        if(head== null || head.next == null){
            return head;
        }
        // 1.next = temp = 2
        Node temp = head.next;
        System.out.println(temp);
        //recursiveReverse(2);---into recursive process 2.next = 3-->.....4.next = null return 4
        //newHead =4, temp =4 head =3  //head = 2 tmp =3// head=1 tmp=2
        Node newHead = recursiveReverse(head.next);
        //4->3->2->1  || 3->4-->>>>>4->3->2->1
        temp.next = head;
        // head.next = null;
        head.next = null;
        return newHead; //4
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        System.out.println(head);
        SingleLinkedList list = new SingleLinkedList(head);
        list.addNode(new Node(2));
        list.addNode(new Node(3));
        list.addNode(new Node(4));
        list.addNode(new Node(5));
        list.addNode(new Node(6));
//        System.out.println(head);
//        System.out.println(list.linkedListlength());
        //list.traverse();
        head = recursiveReverse(head.next);
        list.setHead(head);
        System.out.println(list.linkedListlength());
        list.traverse();
    }


}
