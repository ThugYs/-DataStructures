package recusion;

public class QueenArray8 {
    int max = 8;
    int[] array;
    static int count = 0;
    static int judgeCount = 0;
    public QueenArray8(){
        this.array = new int[this.max];
    }
    public void findQueen(int row){
        if( row == this.max){
            this.print();
            return;
        }
        for(int column = 0; column<8; column++){
            this.array[row] = column;
            if(this.check(row)){
                this.findQueen(row+1);
            }
        }
    }
    public void print() {
        ++count;
        for(int i = 0; i < this.array.length; ++i) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
    public boolean check(int row){
        //check left duijiaoxian, column -i&&row-i
        //check right duijioxian, column +i && row -i
        //check column column&& row-i
        for(int i=0; i< row;i++){
            //wsm
            if(this.array[i]==this.array[row] ||array[row-i-1]==(array[row]-i-1)||array[row-i-1]==(array[row]+i+1) ){
                return false;
            }
//            if (this.array[i] == this.array[row] || Math.abs(row - i) == Math.abs(this.array[row] - this.array[i])) {
//                return false;
//            }
        }
        return true;
    }
    public static void main(String[] args) {
        QueenArray8 queue8 = new QueenArray8();
        queue8.findQueen(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount);
    }

}
