package String;

import java.util.ArrayList;

/**
 * @author yangshu
 * 题目：{a,b,c}要求输出{abc,acb,bac,bca,cab,cba}
 */

public class StringPermutation {
    private int count =0;
    public void permutationString(String str){
        //first to check all conditions
        if(str == null){
            return;
        }
        helper(str.toCharArray(), 0);
        System.out.println(count);
    }
    public void helper(char[] array, int cur){
        //goal:  cur == array.length - 1

        if ( cur == array.length - 1 ) {
            count++;
            System.out.println(array);
        }
        else {
            for ( int i = cur; i < array.length ; i++ ){
                swap(array,cur,i);
                //推进
                helper(array,cur+1);  //固定第一个字符cur，对后面所有字符全排列,后面的后面继续递归
                swap(array,i,cur);
            }
        }
    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        sp.permutationString("boat");
    }
}
