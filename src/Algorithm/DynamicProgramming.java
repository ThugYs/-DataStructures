package Algorithm;

public class DynamicProgramming {
    int getMostGold(int n, int w, int [] g, int [] p){
        int [] preResult = new int [p.length];
        int [] curResult = new int[p.length];
        for(int i =0; i<w; i++){
            if(i < p[0]){
                preResult[i] = 0;
            }else {
                preResult[i] = g[0];
            }
        }
        for(int i = 0; i <=n; i++){
            for(int j =0; j<w;j++){
                if(j < p[i]){
                    curResult[j] = preResult[j];
                }else{
                    curResult[j] = Math.max(preResult[j],preResult[j-p[i]]+g[i]);
                }
            }
            preResult = curResult;
        }
        return curResult[n];
    }
}
