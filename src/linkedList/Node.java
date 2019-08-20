package linkedList;

import java.util.LinkedList;

public class Node {
    public Integer data;
    public Node next;
    public Node prev;

    public Node(){}
    public Node(Node next, Integer data){
        this.next =  next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node next, Node pre) {
        this.data = data;
        this.next = next;
        this.prev = pre;
    }

    public Node(Integer data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        Node node = new Node(null, 12);
        System.out.println(node);

        LinkedList list = new LinkedList();
    }
}
