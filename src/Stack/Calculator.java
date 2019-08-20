package Stack;

public class Calculator {
    public Calculator(){
    }
    /***
     * 改进了一下，需要支持两位数运算
     * @param args
     */
    public static void main(String[] args) {
//        String expression = "7*2*2-5+1-5+3-4";
        String expression = "702+2*6-4";

        ArrayStackOperator stack = new ArrayStackOperator(10);
        ArrayStackOperator operator = new ArrayStackOperator(10);
        // define value
        //scan index， (index, index+1), (index+1, index+2)
        int index = 0;
        //define two value for nums 7*8
        int num1 =0;
        int num2 =0;
        // define for opertor
        int oper = 0;
        //define for temp result
        int res = 0;
        String keepNum = "";
        //因为键盘键入的是string然后切割了以后是char，define char for input and 拼接string
        char ch = ' ';

        do{
            // traverse all index, index+1
            ch = expression.substring(index, index+1).charAt(0);// transfer string to char
            // check ch whether oper or not, if oper, check priority.
            if(operator.isOper(ch)){
                //check isempty,then pop,otherwise push newNode as fist one
                if(!operator.isEmpty()){
                    //if nowNode is priority than peek, push newNode into operStack,
                    //otherwise, pop oper and cal, get result and push into numStack
                    if(operator.priority(ch) <= operator.priority(operator.peek())){
                        //pop two nums, and oper
                        num1 = stack.pop();
                        num2 = stack.pop();
                        oper = operator.pop();
                        res = stack.cal(num1, num2, oper);
                        //push res
                        stack.push(res);
                        //after pop oper and cal, then push newOper
                        operator.push(ch);
                    }else {
                        operator.push(ch);
                    }
                }else {
                    operator.push(ch) ;
                }
            }else {
                //push num = ch-48 into numStack
                keepNum = keepNum +ch;
                //consider the case, if last ch for String,just push keepNum right now, otherwise,append.
                if(index == expression.length()-1){
                    stack.push(Integer.parseInt(keepNum));
                    break;
                }
                //check index+1, if nums, index++ then, loop the process. Otherwise, it will  push keepNum and redefine
                if(operator.isOper(expression.substring(index+1 ,index+2).charAt(0))){
                    stack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }
            //INDEX +1 and check whether index = end
            index ++ ;
            //if index = length, break, otherwise go back loop, until ,all nums and opers in stack

        }while(index < expression.length());

        while(!operator.isEmpty()){
            //oper and num stack pop ,and calculate all until last one as result.
            if(operator.isEmpty()){
                break;
            }
            num1 = stack.pop();
            num2 = stack.pop();
            oper = operator.pop();
            res = stack.cal(num1, num2, oper);
            stack.push(res);
        }
        int res2 = stack.pop();
        System.out.printf("expression %s = %d", expression, res2);
    }
}
