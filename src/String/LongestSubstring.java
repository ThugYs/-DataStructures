package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/4-5:52 PM
 * Given a string, find the length of the longest substring without repeating characters
 */
public class LongestSubstring {
    /***
     * 暴力遍历
     * @param str
     * @return
     */
    public int LengthOfLongestSubstring(String str){
        int maxLength = 0;
        for(int i =0; i<str.length(); i++){
            for(int j =i+1; j<=str.length(); j++){
                if(allUniqueSet(str,i,j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    public boolean allUniqueSet(String str, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i= start; i<end; i++){
            Character ch = str.charAt(i);
            if(set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }
        return true;
    }

    /***
     * two point
     */
    public int LengthOfLongestSubstringPoint(String str){
        //right point j, left point i
        int leftPoint = 0;
        int maxLength = 0;
        int rightPoint = 0;
        Set<Character> set = new HashSet<>();
        int length = str.length();
        Character ch = null;

//        for(int rightPoint =1; rightPoint<str.length(); rightPoint++){
//            ch = str.charAt(rightPoint);
//            if(! set.contains(ch)) {
//                set.add(ch);
//                maxLength = Math.max(maxLength,rightPoint-leftPoint);
//            }else{
//                leftPoint = str.indexOf(ch)+1;
//                set.clear();
//            }
//        }
        while( leftPoint < length && rightPoint < length){
            if(!set.contains(str.charAt(rightPoint))){
                set.add(str.charAt(rightPoint++));
            //++
                maxLength = Math.max(maxLength, rightPoint - leftPoint);
            }else{
                set.remove(str.charAt(leftPoint++));
            }
        }
        return maxLength;
    }
    /***
     * 上面的滑动窗口算法最多需要2n的步骤，但这其实是能被优化为只需要n步。
     * 我们可以使用HashMap定义字符到索引之间的映射，
     * 然后，当我们发现子字符串中的重复字符时，可以直接跳过遍历过的字符了。
     */
    public int lengthOfLongestSubstringImproved(String str){
        int length =str.length(), maxLength = 0;
        //使用hashmap记录遍历过的字符的索引，当发现重复的字符时
        // 可以将窗口的左边直接跳到该重复字符的索引处
        Map<Character, Integer> map = new HashMap<>();
        for(int rightPoint = 0, leftPoint=0; rightPoint < length; rightPoint++){
            if(map.containsKey(str.charAt(rightPoint))){
                leftPoint = Math.max(map.get(str.charAt(rightPoint)), leftPoint);
            }
            maxLength = Math.max(maxLength, rightPoint - leftPoint + 1);
            map.put(str.charAt(rightPoint), rightPoint + 1);
        }
        return maxLength;
    }
    /**
     * 审题错误+考虑不周吧，子串可能是从i=0-length任何一个位置开始，所以子串的负责度要多一层循环
     * @param str
     * @return
     */
    //最长连续无重复
    public int ContinuousLongestSubstring(String str) {
        //暴力遍历
        char [] cha = str.toCharArray();
        int maxLength = 0;
        for(int i =1; i<cha.length; i++){
            // !! error cha[i] == cha[i--], loop forever
            if(cha[i] != cha[i-1]){
                maxLength++;
                continue;
            }
            maxLength = 1;
        }
        return maxLength;
    }

    /***
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringFinal(String s) {
        int n = s.length(), ans = 0;
        // 桶的思想，有的话就是索引 ，没有就是
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
