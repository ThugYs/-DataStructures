package String;

public class KMP {
    public static int KMPSearch(String txt, String pat, int [] next) {
        int M = txt.length();
        int N = pat.length();
        int i = 0;
        int j = 0;
        while (i < M && j < N) {
            if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j == N){
            return i - j;
        }
        return -1;
    }
    public static void getNext(String pattern, int [] next){
        int length = pattern.length();
        next[0] =-1;
        int j = -1;
        int k =0;
        while (j < length-1){
            if(j==-1 || pattern.charAt(j) == pattern.charAt(k)){
                next[++j] = ++k;
            } else{
                j =next[k];
            }
        }
    }
}
