package String;

public class StringToInt {
    /***
     *实现 Integer.valueOf的功能
     * 常规思路，先判断第一位是不是符号位，如果有符号，有flag 做标记。
     * 遍历字符串中的每个字符，如果存在非数字的字符，直接返回 0，否则，用当前字符减去’0’得到当前的数字，再进行运算。
     */
    public Integer stringToint(String str){
        //check null
        if(str == null){
            return null;
        }
        int flag = 0;
        if(str.charAt(0) =='+'){
            flag =1;
        }
        if(str.charAt(0) == '-'){
            flag =2;
        }
        //check if there is sign, define a point "start"
        int start = flag > 0 ? 1 : 0;
        int res = 0;
        while(start < str.length()){
            if(str.charAt(start) > '9' || str.charAt(start) < '0'){
                return 0;}
            //char 转int 用当前字符减去’0’得到当前的数字
            int value = str.charAt(start)- '0';
            //优化if的用法
            res = value + res * 10 ;
            start ++;
        }
        return flag == 2 ? -(int)res : (int)res;
    }
}
