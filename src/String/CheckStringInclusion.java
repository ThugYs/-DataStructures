package String;

/**
 * @author yangshu
 * 这个题开始理解错了，应该是等长滑动比较
 */

import java.util.Arrays;

/**
 * hashmap做一个key：value，和一个int [] ascii 数组一样的，
 * 因为int [] ascii = new ascii[128];，所以数组做统计更简单
 *
 */
public class CheckStringInclusion {
    public static boolean checkStringInclusion(String pattern, String str){
        int plen = pattern.length();
        int slen = str.length();
        if(slen>plen){
            return false;
        }
        int [] pmap = new int[128];


        //s1.charAt(i) - 'a' ,因为'a'=65
        for(int i =0; i< plen; i++){
            pmap[pattern.charAt(i)- 'a']++;
        }
        for(int i=0;i< slen-plen+1; i++ ){
            int[] smap = new int[128];
            for(int j =0; j<plen; j++){
                smap[str.charAt(i+j-'a')]++;
            }
            if(match(pmap,smap)){
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusionLeetcode(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(s1map, s2map)){
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return match(s1map, s2map);
    }


    private static boolean match(int [] s1map, int [] s2map){
        for (int i = 0; i < 128; i++) {
            if (s1map[i] != s2map[i]){
                return false;}
        }

        return true;

    }

    /***
     * 比较trick
     *用了Arrays的很多api, Arrays.sort, String.subString
     *
     */
    public static boolean checkInclusionTrick(String pattern, String str){
        int plen = pattern.length();//3, 0-2
        int slen = str.length();// 6, 0-5
        //先排序，把字符串传进去，先转成char数组，然后arrays.sort 排序，再转回字符串
        pattern = sort(pattern);
        for(int i= 0; i< slen-plen+1;i++){
            if(pattern.equals(sort(str.substring(i,i+plen)))){
                return true;
            }
        }
        return false;
    }
    public static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
