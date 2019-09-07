package String;

public class ReverseString {
    public String reverseString(String s) {
        if(s.length() < 2) {
            return s;
        }
        int l = 0, r = s.length() - 1;
        char [] strs = s.toCharArray();
        while(l < r){
            char temp = strs[l];
            strs[l] = strs[r];
            strs[r] = temp;
            l++;
            r--;
        }
        return new String(strs);
    }
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A+A).contains(B);
    }
}
