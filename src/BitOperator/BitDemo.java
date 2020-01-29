package BitOperator;

import java.util.HashMap;
import java.util.Map;


/**
 * 通过异或运算，两个相同的元素结果为 0，而 任何数 与 0 进行异或操作，结果都为其本身。
 * 而 任何数 与 0 进行异或操作，结果都为其本身。负数按补码形式参加按位与运算。-->取一个数的指定位
 * 或运算”特殊作用 --->取一个数的指定位
 * 位运算通常用来降低包含排列，计数等复杂度比较高的操作，当然也可以用来代替乘 2 除 2，判断素数，偶数，倍数等基本操作，
 * 但是我认为其意义在于前者，即用计数器来降低设计到排列或者计数的问题的复杂度。
 */

/**
 * /***
 *  * 按位取反	~  按位异或 (相同为零不同为一)	^
 *  * 一个十六进制的色值来举例子比如0xffa131我们要转换就要先理解其组成
 *  * 0xffa131
 *  * 0x或者0X：十六进制的标识符
 *  */

public class BitDemo {


    /***
     * /**
     * #136 根据题目描述，由于加上了时间复杂度必须是 O(n) ，并且空间复杂度为 O(1) 的条件，
     *  因此不能用排序方法，也不能使用 map 数据结构。答案是使用 位操作Bit Operation 来解此题。
     *    * 将所有元素做异或运算，即a[1] ⊕ a[2] ⊕ a[3] ⊕ …⊕ a[n]，所得的结果就是那个只出现一次的数字，时间复杂度为O(n)。
     *    * 根据异或的性质 任何一个数字异或它自己都等于 0
     *    * 负数按补码形式参加按位与运算。
     *    */

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map);
        return map.entrySet().iterator().next().getKey();
    }

    /**
     * 任何整数 n 与 0 异或总等于其本身 n，一个数与其本身异或那么结果肯定是 0。
     * ！！！！ 多个数异或操作，遵循交换律和结合律。 ！！！
     * 所以对于任何排列的数组，如果只有一个数只出现了奇数次，其他的数都出现了欧数次，那么最终异或的结果肯定为出现奇数次的那个数。
     * @param arr
     * @return
     */
    public int oddTimesNum(int[] arr) {
        int eO = 0;
        for (int cur : arr) {
            eO = eO ^ cur;
        }

        return eO;
    }

    boolean IsOdd(int num)
    {
        int res = (num & 1);
        return res != 0;
    }
    public static void main(String[] args) {
        int [] arr = {4,2,1,3};
        int res = solution(arr);
        System.out.println(res);
        System.out.println(10 | -10);
        //  10 补码0000 0000 0000 1010
        // -10 补码 1111 1111 1111 0110
        //10 | -10 = 1111 1111 1111 1110
        //现在是补码和补码运算得出补码，我要知道他的数值意义，
        //我要转回去源码，进行补码-1忽略符号位取反 1111 1111 1111 1110 -1 = 1111 1111 1111 1101 取反 1000 0000 0000 0010 =-2
        System.out.println(~10);
        //10 补码 0000 0000 0000 1010
        //---------------------
        //取反 ~10 = 1111 1111 1111 0101 现在对其求源码
        // ~10 = 1111 1111 1111 0101 -1 = 1111 1111 1111 0100 忽略符号位取反，1000 0000 0000 1011
        int number1 = 5;
        System.out.println("左移前的十进制数为：" + number1);// 0000 0000 0000 0101
        System.out.println("左移前的二进制数为：" + Integer.toBinaryString(number1));
        int number2 = number1 << 2; //5 * 2* 2 =20
        System.out.println("左移后的十进制数为：" + number2); //0000 0000 0001 0100
        System.out.println("左移后的二进制数为：" + Integer.toBinaryString(number2));
        System.out.println();
        int number3 = -5;
        System.out.println("you移前的十进制数为：" + number3); // 1111 1111 1111 1011
        System.out.println("you移前的二进制数为：" + Integer.toBinaryString(number3));
        int number4 = number3 >> 2; //-5 * 2* 2 =-20
        // 补码1111 1111 1111 1110 ，转源码 1111 1111 1111 1110-1 =1111 1111 1111 1101 取反= 1000 0000 0000 0010 =-2
        System.out.println("you移后的十进制数为：" + number4);
        System.out.println("you移后的二进制数为：" + Integer.toBinaryString(number4));

        System.out.println(">>>无符号，符号位也移动");

        int c = -15;
        System.out.println("逻辑右移前的十进制数为：" + c); // 1111 1111 1111 0001

        System.out.println("逻辑右移前的二进制数为：" + Integer.toBinaryString(c));
        int d = c >>> 2;   //0011 1111 1111 1100 符号为移动了现在变为正数 1073741820
        System.out.println("逻辑右移后的十进制数为：" + d);
        System.out.println("逻辑右移后的二进制数为：" + Integer.toBinaryString(d));
        d = -2147483648; // 1000 0000 0000 0000
        System.out.println("1000000：" + Integer.toBinaryString(d));

    }

}
