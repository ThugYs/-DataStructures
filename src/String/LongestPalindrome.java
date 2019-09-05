package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangshu
 * LeetCode: 最长回文串 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * A: 统计字母出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，所以如果最后有字母落单，总长度可以加 1。
 */
public class LongestPalindrome {
    /***
     * step 1 init a hashmap, key: char, value: num of char in String
     * step 2 tranversal string to set all key:value
     * if more than one char(n) occurs odds time,
     * n-1 char will be romoved, cuz only allow one char occurs odd time
     */
    public static int longestPalindrome(String str){
        int length = 0;
        //map 的key value只能是引用类型吗
        Map<Character, Integer> map = new HashMap<>(128);
        int i =0;
        Character key =null ;
        while(i<str.length()){
            key = str.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,0);
            }
        }
        Set<Character> keySet = map.keySet();
        int numOdd =0;
        for(char ch : keySet){
            if(map.get(ch)%2 ==1){
                numOdd++;
            }
        }
        length = str.length()-numOdd+1;
        return length;
    }

    /**
     *
     */
    public static int longestPalindromeLeetcode(String s) {
        HashSet<Character> hs = new HashSet<>();
        int len = s.length();
        int count = 0;
        if(len == 0) {
            return 0;
        }
        for(int i = 0; i<len; i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        return hs.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        String str = "aabbbeeessrrtfdfsfsd";
        System.out.println(longestPalindrome(str));
    }
}
