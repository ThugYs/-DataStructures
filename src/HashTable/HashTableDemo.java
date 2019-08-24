package HashTable;

import java.util.Scanner;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/8/22-1:38 PM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class HashTableDemo {
    public static void main(String[] args) {

        //创建哈希表
        HashTable hashTab = new HashTable(7);

        //写一个简单的菜单
        String key = " ";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("delete: 删除雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = 0;
                    int value =0 ;
                    try{
                        id = scanner.nextInt();
                        System.out.println("输入value");
                        value = scanner.nextInt();
                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                    finally {
                        System.out.println("value:"+value);
                    }
                    //创建 雇员
                    Node emp = new Node(id,value,null);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.select(id);
                    break;
                case "remove":
                System.out.println("请输入要删除的的id");
                    id = scanner.nextInt();
                    hashTab.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}

/**
 * hashtable is a key&value datastructure and comprise array and list.
 * define list [] array to store lists, and list[index] = head of list and has a filed to point list
 * list can be curd and curd has to locate the index of arr  before check in list.
 * index = hashcode(key) % size. then keyde will be added in the following of list.
 */
class HashTable{
    /***
     * define a hashtable
     * filed: size, Array[] store all Node head, and head has a next filed to point at the list
     *
     */
    private int size;
    private ElementList [] list;

    /***
     * get size and define a set of Node head, and set in Array[index]
     * @param size
     */
    HashTable(int size){
        this.size = size;
        list = new ElementList[this.size];
        for(int i =0 ;i < size; i++){
            list[i] = new ElementList(new Node(111));
        }
    }

    /***
     * add new keyde to hashtable, and will call the add method from array class.
     * @param newNode
     */
    void add(Node newNode){
        int index = locate(newNode.key);

        list[index].add(newNode);

    }
    void delete(Integer key){
        int index = locate(key);

        list[index].remove(key);

    }
    Node select(Integer key){
        Node result = list[locate(key)].select(key);
        if(result != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", ( locate(key)+ 1), key);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
        return result;
    }

    public void list() {
        for(int i = 0; i < size; i++) {
            list[i].printList(i);
        }
    }

    boolean update(Integer key){
        return true;
    }

    int locate(Integer key){
        return (int)key % this.size;
    }

}

class Node{
    public Integer key;
    public int value;
    public Node next;
    public Node(){

    }
    public Node(int key){this.key = key;}
    public Node(Integer key, int value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class ElementList{
    private Node head;
    ElementList(Node head){
        this.head = head;
    }
    void add(Node newNode){
        if(isEmpty()){
            head.next = newNode;
            return;
        }
        Node point = head.next;
        while(point.next != null){
            if(point.key == newNode.key){
                point.value = newNode.value;
                return;
            }
            point = point.next;
        }
        point.next = newNode;
    }

    void remove(Integer key){

        if(isEmpty()){
            return;
        }
        Node point = head.next;
        Node pre = head;
        while(true){
            //loop until last one, del all the key Node,
            //find key, and
            if(point.key == key){
                pre.next = point.next;
                System.out.println("remove key:"+key);
                return;

            }
            if(point.next == null){
                System.out.println("none");
                return;
            }
            point = point.next;
            pre = pre.next;
        }
    }
    Node select(int key){
        if(isEmpty()){
            System.out.println("链表为空");

            return null;
        }
        Node point = head.next;
        while(point != null){
            if(key == point.key){
                return point;
            }
            point = point.next;
        }
        return null;
    }
    boolean update(Integer key, Integer value){

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

    boolean isEmpty(){
        if(head.next == null){
            return true;
        }
        return false;
    }
    public void printList(int key) {
        if(this.head.next == null) { //说明链表为空
            System.out.println("第 "+(key+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(key+1)+" 链表的信息为");
        Node curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d value=%d\t", curEmp.key,curEmp.value);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }



}
