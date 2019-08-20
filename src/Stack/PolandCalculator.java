package Stack;

public class PolandCalculator {
    /*** oper: + - * % ( ) nums 0-----9
     * 1. initial two stack:operStack:os and numStack:ns
     * 2. scan from left to right. if nums, push ns
     * 3. else, if compare its prority with peek of os
     *      3.1 if os is empty, or peek is 'left('. push it into os
     *      3.2 otherwise, it is prority. push it into os
     *      3.3 otherwise, pop oper from os and push it into num,  then go back 3.1
     *      end loop
     * 4. else it is ( )
     *      if left ( push into directly
     *      else right ),  pop all oper in os and push them ns until find first left(. then remove()
     * 5. go back step 2, go through 2-5 . scan string until last
     * 6. pop all oper from os, and push them into ns.
     * 7. pop s2 and output, result will be end- expression from mid- expression
     */


    public static void main(String[] args) {

    }
}
