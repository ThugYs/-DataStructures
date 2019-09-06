package Algorithm;

/** 动态规划解题思路
 * No1 状态
 * No2 转移方程
 * No3 初始化
 * No4 结果
 */
public class DynamicProgramming {
    /***
     * table[n][w]
     * @param n  golden No
     * @param w  the number of worker
     * @param g  the golden array
     * @param p  the person array store the number of person, required by int [] g
     * @return
     */
    int getMostGold(int n, int w, int [] g, int [] p){
        //row of table ,pre row, n = i, loop w from 0-w
        int [] preResult = new int [p.length];
        //row of table, cur row, n = i+1, loop w from 0 -w
        int [] curResult = new int[p.length];
        //external tranversal, loop w in begining
        // First row = 1, p[0] =5,
        // Condition1:if  w= i< p[0], preResult[0] = 0;
        //Condition2:else, preResult[0] = g[0]
        for(int i =0; i<w; i++){
            if(i < p[0]){
                preResult[i] = 0;
            }else {
                preResult[i] = g[0];
            }
        }
        // external tranveral from Second row = 2
        for(int i = 0; i <=n; i++){
            //when row =2 , tranversal w from 0- w
            //condition1:if w< p[i] curResult[j] = preResult[j]
            //condition2: else curResult[j] = max(preResult[j], preResult[j-p[i]]+g[i])
            for(int j =0; j<w;j++){
                if(j < p[i]){
                    curResult[j] = preResult[j];
                }else{
                    curResult[j] = Math.max(preResult[j],preResult[j-p[i]]+g[i]);
                }
            }
            // loop for transveral
            preResult = curResult;
        }
        return curResult[n];
    }
}
