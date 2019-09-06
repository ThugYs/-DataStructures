package String;

/**
 * @author yangshu
 */

/***
 * /** 动态规划解题思路
 *  * No1 状态
 *      f[i][j] 表示s的第i个字符到第j个字符组成的子串中，最长的回文序列长度是
*  * No2 转移方程
 *      if s[i] == s[j]; f[i][j] = f[i+1][j-1] +2
 *      if s[i] != s[j] f[i][j] = max(f[i+1][j], f[i][j-1])
 *     Note: 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，
 *     这样可以保证每个子问题都已经算好了。
 *  * No3 初始化
 *      f[i][i] = 1 单个字符的最长回文序列是 1
 *  * No4 结果
 *      f[0][s.length - 1]
 */

public class LongestPalinSubseq {
    public int longestPalinSubseq(String s){
        int n = s.length();
        int [][] f = new int [n][n];
        for(int i = n-1; i>=0; i--){
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n-1];
    }
}
