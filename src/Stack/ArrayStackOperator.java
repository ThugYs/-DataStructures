package Stack;

public class ArrayStackOperator {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStackOperator(int maxSize) {
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
            throw new RuntimeException("stack empty");
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
//    public int priority(int oper){
//        if(oper != 42 && oper != 47){
//            return oper != 43 && oper!=45 ? -1 : 0;
//        }else {
//            return 1;
//        }
//    }
    public int priority(int oper){
        if(oper =='*' || oper == '/'){
            return 1;
        }else if( oper =='+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    public boolean isOper(char val) {
        return val =='+' || val == '-' || val == '*' || val =='/';
    }
    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
        case '*':
            res = num1 * num2;
            break;
        case '+':
            res = num1 + num2;
            break;
        case '-':
            res = num2 -num1;//order
            break;
        case '/':
            res = num2 / num1;
            break;
        default:
            break;
        }
        return res;
    }

}
