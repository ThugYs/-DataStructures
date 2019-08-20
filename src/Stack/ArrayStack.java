package Stack;

import java.util.Scanner;

public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }
    public int peek() {
        return this.stack[this.top];
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }
    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (this.isFull()) {
            System.out.println("stack full");
            return;
        }
        this.stack[++this.top] = value;
    }
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("stack empty!!!");
        }
        int value = this.stack[this.top];
        --this.top;
        return value;
    }
    public void listPrint(){
        if(this.isEmpty()){
            System.out.println("empoty");
            return;
        }
        for(int i =this.top; i>=0; --i){
            System.out.printf("stack[%d] = %d\n", i, this.stack[i]);
        }

    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            System.out.println(key);
            System.out.println(key.hashCode());
            switch(key.hashCode()) {
                case 111185:
                    if (key.equals("pop")) {
                        int res = stack.pop();

                    }
//                        try {
//                            int res = stack.pop();
//                            System.out.printf("出栈的数据是 %d\n", res);
//                        } catch (Exception var8) {
//                            System.out.println(var8.getMessage());
//                        }
//                    }
                    break;
                case 3127582:
                    if (key.equals("exit")) {
                        scanner.close();
                        loop = false;
                    }
                    break;
                case 3452698:
                    if (key.equals("push")) {
                        System.out.println("请输入一个数");
                        int value = scanner.nextInt();
                        stack.push(value);
                    }
                    break;
                case 3529469:
                    if (key.equals("show")) {
                        stack.listPrint();
                    }
            }
        }
        System.out.println("程序退出~~~");
    }
}
