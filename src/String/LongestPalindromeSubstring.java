package String;
/***
 * 方法三：动态规划
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
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0; //
        for (int i = 0; i < s.length(); i++) {
            // 一个奇数的为核心，abcba
            int len1 = expandAroundCenter(s, i, i);
            //偶数的cc当核心 abccba
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
