package String;

import java.util.ArrayList;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/6-8:38 PM
 */

public class StringPermutation {
    ArrayList<String> res = new ArrayList<String>();

    public ArrayList<String> permutationString(String str){
        //first to check all conditions
        if(str == null){
            return res;
        }
        StringBuffer sb=new StringBuffer();
        permutationHelper(str,sb);
    }
    public static void permutationHelper(String str, StringBuffer prefix){

        prefix.append();
        permutationHelper(str,prefix);


    }


    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
