package linkedList;

import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Node temp;
        Node head =new Node(2);
        head.next = new Node(3);
        temp = head;
        head.next.next = new Node(4);
        System.out.println(temp);
        temp.next.next.next =  new Node(2);
        System.out.println(head);
        System.out.println(temp);
        String str = "7*2*2-5+1-5+3-4";
        char ch = str.substring(1,2).charAt(0);
        System.out.println(ch);

    }
}
