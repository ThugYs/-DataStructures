package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/4-5:52 PM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
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
                if(allUnique(str,i,j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }

        return maxLength;
    }


    public boolean allUnique(String str, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = str.charAt(i);
            if (set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
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
}
