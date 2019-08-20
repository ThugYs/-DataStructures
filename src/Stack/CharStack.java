package Stack;

public class CharStack {
    private int maxSize;
    private char [] arr;
    private int top;
    public CharStack(int maxSize){
        this.maxSize = maxSize;
        this.arr = new char[maxSize];
        top = -1;
    }
    public boolean isEmpty(){
        return top == -1 ;
    }
    public boolean isFull(){
        return top == maxSize -1;
    }
    public void printStack(){
        System.out.println("Stack(bottom-->top):");
        if(isEmpty()){
            return;
        }
        //define new value i, top can be point
        for(int i = 0;i< top+1; i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.println("");
    }
    public char peek(){
        if(isEmpty()){
            System.out.printf("empty");
            throw new RuntimeException("empty");
        }
        return arr[top-1];

    }
    public char peekN(int n){
        return arr[n];
    }
    public char pop(){

        return arr[top--];
    }
    public void push(char ch){
        if(isFull()){
            System.out.printf("full");
            return;
        }
        top++;
        arr[top] = ch;
    }

}
