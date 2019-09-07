package String;

import java.util.HashMap;
import java.util.Map;

public class NewCoderString {
    public static int  FirstNotRepeatingChar(String str){
        int len = str.length();
        if(len<1 || str == null){
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< len; i++){
            if(map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
         for(int j=0; j<len;j++){
            if(map.get(str.charAt(j))==1){
                return j;
            }
         }
         return -1;
    }
    public static String reverseSentence(String str) {
        if (str.trim().length() == 0)
        {
            return str;
        }
        String[] temp = str.split(" ");
        StringBuffer res= new StringBuffer("");
        for (int i = temp.length - 1; i >= 0; i--) {
            res.append(temp[i]);
            if (i != 0)
            {
                res.append(" ");
            }
        }
        return res.toString();
    }

    /***
     * 在第 n 个字符后面将切一刀，将字符串分为两部分，再重新并接起来即可。注意字符串长度为 0 的情况。
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString(String str,int n){
        int len = str.length();
        if(len == 0) {
            return "";
        }
        n = n % len;
        String s1 = str.substring(n, len);
        String s2 = str.substring(0, n);
        return s1+s2;
    }

    public static void main(String[] args) {
        reverseSentence("the sky is blue");
        System.out.println(reverseSentence("the sky is blue"));
    }
}
