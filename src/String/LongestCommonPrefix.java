package String;

import java.util.Arrays;

/**
 * @author yangshu
 * Q: 最长公共前缀 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * A: 首先对字符串数组进行排序，然后拿数组中的第一个和最后一个字符串进行比较，从第 0 位开始，如果相同，把它加入 res 中，不同则退出。最后返回 res
 */

public class LongestCommonPrefix {
    public static void ArraySort(){
        String[] strs = new String[]{"abfds1", "advesd2", "dasfdsa3", "cdsaew1", "abbdsa3", "abbdsa2", "abbdsa"};
        Arrays.sort(strs);
        for(String str : strs) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abfds1", "abvesd2", "absfdsa3", "abcdsaew1", "abbdsa3", "abbdsa2", "abbdsa"};

        String res = longestCommonPrefix(strs);
        String res2 = longestCommonPrefix(strs);

        System.out.println(res);
        System.out.println(res2);

    }



    public static String longestCommonPrefix(String [] strs){
        Arrays.sort(strs);
        int len = strs.length;
        //养成习惯以后拼字符串都用StringBuffer
        StringBuffer prefix = new StringBuffer();
        //定规个扫描指针
        int i = 0;
        while(i< strs[0].length()&& i< strs[len-1].length()){
            if(strs[0].charAt(i) == strs[len-1].charAt(i)){
                prefix.append(strs[0].charAt(i));
                i++;
            } else{
                break;
            }
        }
        return prefix.toString();
    }

    public String longestCommonPrefixLeetcode(String [] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        char [] first = strs[0].toCharArray();
        char [] last = strs[strs.length - 1].toCharArray();
        StringBuffer res = new StringBuffer();
        int len = first.length < last.length ? first.length : last.length;
        int i = 0;
        while(i < len){
            if(first[i] == last[i]){
                res.append(first[i]);
                i++;
            }
            else {
                break;
            }
        }
        return res.toString();
    }
}
