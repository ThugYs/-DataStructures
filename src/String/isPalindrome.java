package String;

public class isPalindrome {
    /***
     * 判断一个字符串是否是回文串，只考虑字母和数字，并且忽略大小写
     */
    public boolean isPalindrome(String str){
        if(str.length() == 0){
            return true;
        }
        int len = str.length();
        str  = str.toLowerCase();
        //when point i and point j meet, process end and return true.
        int i =0,j = len-1;
        while (i<j){
            while (!isAlphanumeric(str.charAt(i))){
                i++;
                // 如果最后几个全是非法字符，然后string的结尾还是/0，防止下次循环报错误 String index out of range
                if(i == len){
                    return true;
                }
            }
            while (!isAlphanumeric(str.charAt(j))){
                //  这边不会出现i那里，开始都是非法字符的情况，如果一直非法字符，不会走到j这个循环里面，所以这里不需要判断j==0
                j--;
            }
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    private boolean isAlphanumeric(char c){
        if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9') {
            return true;
        }
        return false;
    }
    public boolean isPalindrome2(String s) {
        if(s.length() == 0)
        {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else{
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    //两个不想等就不需要判断了
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    /***
     * 这里用一个技巧，把 '0' 到 '10' 映射到 1 到 10，'a' 到 'z' 映射到 11 到 36 ，
     * 'A' 到 'Z' 也映射到 11 到 36 。然后把所有数字和字母用一个 char 数组存起来，没存的字符就默认映射到 0 了。
     *
     * 这样只需要判断字符串中每个字母映射过去的数字是否相等，如果是 0 就意味着它是非法字符。
     */
    private static final char[] charMap = new char[256];

    static {
        // 映射 '0' 到 '9'
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char) (1 + i); // numeric
        }
        // 映射 'a' 到 'z' 和 映射 'A' 到 'Z'
        for (int i = 0; i < 26; i++) {
            //疑问11怎么转为char
            charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);
        }
    }

    public boolean isPalindromeTrick(String s) {
        char[] pChars = s.toCharArray();
        int start = 0, end = pChars.length - 1;
        char cS, cE;
        while (start < end) {
            // 得到映射后的数字
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if (cS != 0 && cE != 0) {
                if (cS != cE) {
                    return false;
                }
                start++;
                end--;
            } else {
                if (cS == 0){
                    start++;}
                if (cE == 0) {
                    end--;
                }
            }
        }
        return true;
    }
}
