package String;

/***
 * 刚开始的思路是从头到尾遍历，对遇到的不同情况进行分析，但很容易出错。
 * 因此采用《剑指OFFER》一书的方法：将数字的形式总结为：(A.B E/e A) ,按顺序进行判断（A代表带符号整数，B代表不带符号整数）。
 */

public class IsNumeric {
    /***
    * Numbers 0-9,Exponent - "e" or "E",Positive/negative sign - "+"/"-", Decimal point - ".
     * 数字的基本格式为：(A.B E/e A)  +/-1.234E-10   //A代表带符号整数，B代表不带符号整数
     */
    public boolean isNumericRegex(char[] str) {
        String string = String.valueOf(str);
        //+/  0-9 *
        return string.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    /***
     * decimal，sign，hasE分别作为判断小数点，符号，e/E是否出现出现过的标志
     */
    public boolean isNumeric(char [] str){
        if(str.length == 0 || str == null){
            return false;
        }
        int [] index = new int[1];
        index[0] = 0; // 用于记录当前字符位置
        // 先判断A signed int
        boolean isNumeric;//
        isNumeric = isInteger(str, index);
        //判断B 小数点.后面的B
        if(index[0] < str.length && (str[index[0]] == '.')){
            index[0]++;
            isNumeric = isUnsignedInteger(str, index)|| isNumeric;
        }
        //判断e后面的A
        if(index[0]<str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')){
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length) {
            return true;
        }
        return false;
    }

    /**
     * @param str
     * @param index  // 用int[]才能传值，int的话需要定义index为全局变量
     * @return
     */
    private boolean isInteger(char [] str, int [] index ){
        if(index[0] < str.length && (str[index[0]] == '+' || str[index[0]] =='-')){
            index[0]++;
        }
        return isUnsignedInteger(str,index);
    }
    private boolean isUnsignedInteger(char [] str, int [] index){
        int start = index[0];
        while (index[0] < str.length && str[index[0]]-'0' <=9 && str[index[0]]-'0' >=0){
            index[0]++;
        }
        if(index[0] > start){
            return true;
        }
        return false;
    }


    public boolean isNumeric_3(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1){
                    return false; // e后面一定要接数字
                }
                if (hasE) {
                    return false; // 不能同时存在两个e
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal){
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') { // 不合法字符
                return false;
            }
        }
        return true;
    }


    /**
     * 系统自身的校验机制
     * @param str
     * @return
     */
    public boolean isNumeric_2 (char[] string) {
        try {
            double number = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }



}
