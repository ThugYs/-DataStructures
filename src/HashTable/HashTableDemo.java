package HashTable;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/8/22-1:38 PM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class HashTableDemo {
    /**
     * hashtable is a key&value datastructure and comprise array and list.
     * define list [] array to store lists, and list[index] = head of list and has a filed to point list
     * list can be curd and curd has to locate the index of arr  before check in list.
     * index = hashcode(key) % size. then node will be added in the following of list.
     */
    class HashTable{
        private int size;
        private ElementList [] list;
        HashTable(int size){
            this.size = size;
            for(int i =0 ;i < list.length; i++){
                list[i] = new ElementList(new Node());
            }
        }
        void add(Node newNode){
            int index = locate(newNode.key);

            list[index].add(newNode);

        }
        void delete(Integer key){

        }
        Node select(Integer key){
            Node element = null;
            return element;
        }
        boolean update(Integer key){
            return true;
        }
        int locate(Integer key){
            return (int)key % this.size;
        }

    }
    class ElementList{
        private Node head;
        ElementList(Node head){
            this.head = head;
        }
        void add(Node newNode){
           if(isEmpty(head)){
                head.next = newNode;
                return;
           }
           Node point = head.next;
           while(point.next != null){
               point = point.next;
           }
           point.next = newNode;

        }
        void remove(Integer key){
            if(head.next.next == null ){
                if(head.next.key == key){
                    head.next = null;
                }
            }
            if(isEmpty(head)){
                return;
            }
            Node point = head.next;
            Node pre = head;
            while(point.next!= null){
                if(point.key == key){
                    pre.next = point.next;
                }
                point = point.next;
            }

        }
        Node select(int key, Node head){
            if(isEmpty(head)){
                return null;
            }
            Node point = head.next;
            while(point.next != null){
                if(key == point.key){
                    return point;
                }
            }
            return null;
        }
        boolean update(Integer key, Integer value, Node head){

            Node point = head;
            while(point.next != null){
                if(point == head){
                    continue;
                }
                if(point.key == key){
                    point.value = value;
                    return true;
                }
                point = point.next;
            }
            return false;

        }

        boolean isEmpty(Node head){
            if(head.next == null){
                return true;
            }
            return false;
        }



    }
    class Node{
        private Integer key;
        private int value;
        private Node next;

    }
}
