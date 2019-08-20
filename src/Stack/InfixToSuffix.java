package Stack;

import java.awt.*;
import java.util.Scanner;

public class InfixToSuffix {
    /*** oper: + - * % ( ) nums 0-----9
     * 1. initial two stack:operStack:os and numStack:ns
     * 2. scan from left to right. if nums, push ns
     * 3. else, if compare its prority with peek of os
     *      3.1 if os is empty, or peek is 'left('. push it into os
     *      3.2 if else, it is prority. push it into os
     *      3.3 otherwise, pop oper from os and push it into num,  then go back 3.1
     *      end loop
     * 4. else it is ( )
     *      if left ( push into directly
     *      else right ),  pop all oper in os and push them ns until find first left(. then remove()
     * 5. go back step 2, go through 2-5 . scan string until last
     * 6. pop all oper from os, and push them into ns.
     * 7. pop s2 and output, result will be end- expression from mid- expression
     */
    private CharStack os1;// define oper
    private CharStack ns2;// define num
    private String input; //define length
    public InfixToSuffix(String in) {
        input = in;
        os1 = new CharStack(input.length());
        ns2 = new CharStack(input.length());
    }
        public CharStack transfer() {
            for (int j = 0; j < input.length(); j++) {
                System.out.print("s1栈元素为：");
                os1.printStack();
                System.out.print("s2栈元素为: ");
                ns2.printStack();
                char ch = input.charAt(j);
                System.out.println("当前解析的字符：" + ch);
                switch (ch) {
                    case '+':
                    case '-':
                        goOper(ch, 1);
                        break;
                    case '*':
                    case '/':
                        goOper(ch, 2);
                        break;
                    case '(':
                        os1.push(ch); // 如果当前字符是'(',则将其入栈
                        break;
                    case ')':
                        gotParen(ch);
                        break;
                    default:
                        ns2.push(ch);
                        break;
                }
            }
                while (!os1.isEmpty()) {
                    ns2.push(os1.pop());
                }
                return ns2;
        }
        public void goOper(char opThis, int prec1){
        while (!os1.isEmpty()){
            char opTop = os1.pop();
            if(opTop =='('){
                os1.push(opTop);
                break;
            }else {
                int prec2;
                if(opTop =='+' || opTop =='-'){
                    prec2 =  2;

                }else {
                    prec2 = 2;
                }
                if(prec2 <prec1 ){
                    os1.push(opTop);
                    break;
                }else{
                    ns2.push(opTop);
                }
            }

        }//end while
            os1.push(opThis);
        }
//if scan right ), check os1 pop all oper and push them into sn1 until find left );
            public void gotParen(char ch) {
                while (!os1.isEmpty()) {
                    char chx = os1.pop();
                    if (chx == '(') {
                        //find ( pop it and break; ,() will be removed
                        break;
                    } else {
                        ns2.push(chx);
                    }
                }
            }

        public static void main(String[] args) {
            String input;
            System.out.println("enter infix:");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            InfixToSuffix in = new InfixToSuffix(input);
            CharStack my = in.transfer();
            my.printStack();
        }
}
