package recusion;

public class Queen8 {
    /***
     * define array queue[length] and,
     * index of queue will be row/ num of queue -1, but queue[index] will be column/ where queen put.
     * ex: queen[8] =  [0,4,2,6,3,7,1,5]
     */
    /***
     * 第一次进来，row=0，意思是要在第一行摆皇后，只要传进来的row参数不是8，表明还没出结果，就都不会走if里面的return，那么就进入到for循环里面，column从0开始，即第一列。此时第一行第一列肯定合乎要求（即check方法肯定通过），能放下皇后，因为还没有任何其他皇后来干扰。
     * 关键是check方法通过了之后，在if里面又会调用一下自己（即递归），row加了1，表示摆第二行的皇后了。第二行的皇后在走for循环的时候，分两种情况，第一种情况：for循环没走到头时就有通过check方法的了，那么这样就顺理成章地往下走再调用一下自己（即再往下递归），row再加1（即摆第三行的皇后了，以此类推）。第二种情况：for循环走到头了都没有通过check方法的，说明第二行根本一个皇后都摆不了，也触发不了递归，下面的第三行等等后面的就更不用提了，此时控制第一行皇后位置的for循环column加1，即第一行的皇后往后移一格，即摆在第一行第二列的位置上，然后再往下走，重复上述逻辑。
     * 注意，一定要添加清零的代码，它只有在皇后摆不下去的时候会执行清0的动作（避免脏数据干扰），如果皇后摆放很顺利的话从头到尾是不会走这个请0的动作的，因为已经提前走if里面的return方法结束了。
     */
    public  static int [][] queen = new int[8][8];
    static int map = 0 ;
    public static void findQueen(int row){
        if( row > 7 ){
            // 找到8个皇后的位置了
            //print and return
            map++;
            printQueens();
            return;
        }
        for( int column = 0; column <8; column++){
            if(check(row, column)){
                queen[row][column]=1;
                findQueen(row+1);
                System.out.print("row"+","+row);
                queen[row][column]=0;
            }
        }
    }
    public static void printQueens(){
        System.out.print("方案"+map+":"+"\n");
        for(int i=0;i<8;i++){
            for(int m=0;m<8;m++){
                if(queen[i][m]==1){
                    //System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");
                    System.out.print("o ");
                }
                else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean check(int row, int column){
        /***
         * check if the position meet the rules.
         */
        //check column
        for(int i =0 ;i <row; i++){
            if(queen[i][column]==1){
                return false;
            }
        }
        //check left duijiaoxian
        for(int i=row-1,j = column-1;j >=0 && i>=0; j--, i--){
            if(queen[i][j] ==1){
                return false;
            }

        }
        //check right duijiaoxian
        for(int i=row-1,j=column+1;i>=0&&j<=7 ;i--,j++){
            if(queen[i][j] == 1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("八皇后问题");
        findQueen(0);
        System.out.println("八皇后问题共有："+map+"种可能");
    }
}
