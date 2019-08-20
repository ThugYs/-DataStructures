package queue;

public class ArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public ArrayQueue( int maxSize){
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
    }
    public boolean isFull(){
        return this.rear == this.maxSize - 1;
    }
    public boolean isEmpty(){
        return this.front == this.rear;

    }
    public void add(int n){
        if (this.isFull()) {
            System.out.println("queue is full~");
            return;
        }
        this.arr[++rear] = n;
//        if (this.isFull()) {
//            System.out.println("队列满，不能加入数据~");
//        } else {
//            ++this.rear;
//            this.arr[this.rear] = n;
//        }
    }
    public int pop(){
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[++front];
    }
    public int get(){
        if (this.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front+1];
    }
    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        for (int i = 0; i < this.arr.length; ++i) {
            System.out.printf("arr[%d]=%d\n", i, this.arr[i]);

        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        System.out.println(queue.arr.length);
        queue.showQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
//        queue.showQueue();

        int front = queue.get();
        System.out.println(front);
        queue.pop();
        int res = queue.pop();
        System.out.println(res);
    }
}
