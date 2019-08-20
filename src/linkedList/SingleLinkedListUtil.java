package linkedList;

public class SingleLinkedListUtil {
    /**
     * @param head
     */
    public static Node reversedList(Node head){
        /**
         * check if linkedList length <3
         * 这个反转遍历node吗，一个个反向接上去
         */

        Node current = head;
        Node pre = null;
        Node next;
        while(current !=null){
            //1->2->3 ->4
            //next 当临时变量，递归传递
            //next = 2  cur =1
            next = current.next;
            // 1->
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    public int getlength(Node head) {
        int length = 0;
        //begin from head.next node
        Node temp = head.next;
        // find last node
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }



}
