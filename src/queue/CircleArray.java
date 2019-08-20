package queue;

/***
 * 队列的思想就是这些了，在用数组实现时，有以下几个地方需要注意：
 * 队列的长度就是数组的长度
 * 没有成员时，队头队尾都指向第一个位置，即下标为0
 * 队头始终指向队列中最先进队的成员，队尾始终指向队列中最后进队的成员的后面下一个位置
 * 当队头与队尾的下标相同时，队列为空，因此队尾在指向第四个位置即下标为3时，就应该算队满，否则当队头下标为0时，最后一个位置即第五个位置也有成员，此时队尾下标为0，按照上面的思想应该算队列为空，与实际不符。因此队列的实际容量始终为数组容量减一。
 * 按照上面的思想，队头和队尾下标表示应该为（当前下标+1）%数组容量，在第一圈为0，1，2，3，4，第二圈时继续自加明显不合适，因为下标因该为0，因此在自加后对数组容量取余
 */
public class CircleArray {
    private int maxSize;
    public int front;
    public int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[this.maxSize];
    }

    public boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("队列满add，不能加入数据~");
        } else {
            this.arr[this.rear] = n;
            this.rear = (this.rear + 1) % this.maxSize;
        }
    }

    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        } else {
            int value = this.arr[this.front];
            this.front = (this.front + 1) % this.maxSize;
            return value;
        }
    }
    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("队列空的，没有数据~~");
        } else {
            for(int i = this.front; i < this.front + this.size(); ++i) {
                System.out.printf("arr[%d]=%d\n", i % this.maxSize, this.arr[i % this.maxSize]);
            }
        }
    }
    public int size() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }
    public int headQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return this.arr[this.front];
        }
    }
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(10);
        System.out.println(queue.arr.length);
        System.out.println(queue.front+"-----"+queue.rear);
        for(int i =0; i<9; i++){
            queue.addQueue(i);
        }
        queue.showQueue();
        System.out.println(queue.front+"-----"+queue.rear);
        for(int j =0; j<10; j++){
            queue.getQueue();
        }
        System.out.println(queue.front+"-----"+queue.rear);
    }
}
