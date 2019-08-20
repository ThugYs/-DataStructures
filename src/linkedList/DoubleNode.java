package linkedList;


public class DoubleNode {
    public String name;
    public int value;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode(DoubleNode next, DoubleNode pre, int value){
        this.pre = pre;
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
