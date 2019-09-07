package String;
/***
 * 方法三：动态规划(pending)
 * 为了改进暴力法，我们首先观察如何避免在验证回文时进行不必要的重复计算。
 * 考虑“ababa” 这个示例。如果我们已经知道 “bab” 是回文，那么很明显“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的。
 * 我们给出 P(i,j) 的定义如下：
 * 这产生了一个直观的动态规划解法，我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推…
 * 复杂度分析
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)，该方法使用 O(n^2)的空间来存储表。
 */
public class LongestPalindromeSubstring {

    /**
     * 事实上，只需使用恒定的空间，我们就可以在 O(n^2)的时间内解决这个问题。
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
     * 你可能会问，为什么会是 2n - 12n−1 个，而不是 nn 个中心？
     * 原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba” 的中心在两个‘b’ 之间）
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        //end - start = array.length
        int start = 0, end = 0;//define two point, fowards to opponent direction
        for (int i = 0; i < s.length();i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            //len和之前的最长相等也更新一下 不然end-start+1
            if (len > end - start) {
                end = i + len / 2;
                // i  i+1举个例子，比如 1 1 i i+1 1 1， len = 6, len-1/2 =2, len/2 = 3;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, end+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // if str[left] = str[right], left--&&right++
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //因为上面循环多加了一次l&&r，相当于（right-1）-（left+1）+1
        return right - left - 1;
    }

    /***
     * 共享变量的思想，和之前有一点差别
     */
//    private int index, len;
//
//    public String longestPalindrome(String s) {
//        if(s.length() < 2)
//            return s;
//        for(int i = 0; i < s.length()-1; i++){
//            PalindromeHelper(s, i, i);
//            PalindromeHelper(s, i, i+1);
//        }
//        return s.substring(index, index+len);
//    }
//    public void PalindromeHelper(String s, int l, int r){
//        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
//            l--;
//            r++;
//        }
//        if(len < r - l - 1){
//            index = l + 1;
//            len = r - l - 1;
//        }
//    }


}
