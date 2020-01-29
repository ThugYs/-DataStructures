package BitOperator;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/8-10:27 AM
 */
public class CountBit {
    /***
     * 给定一个整数，请写一个函数判断该整数的二进制表示中1的个数（✭✭✩✩✩）
     * ps 对于正数右移和无符号右移得到结果一样，
     * !!!!!! 如果是负数，右移操作将在二进制补码左边添加追加1，而无符号右移则是补 0 !!!!!
     * @param n
     * 这个方法不是最优，最坏的情况可能需要循环32次
     */

    public static int count1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    /**
     * improve
     * 每次与比自己小1的数与那么该数的二进制表示最后一个为1位上的1将将会被抹去。
     * 其实这是一个知道有这种原理才能想到的方法，所以大家也不用哀叹说我怎么想不到，
     * 通过这次记住有这个规律下次就多一个思路也不是很么坏事。
     * @param n
     */
    public int countA(int n){
        int res = 0;
        while(n != 0){
            n &= (n - 1);
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int c = -15;
        System.out.println(count1(c));
    }


}
