package String;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/5-11:47 AM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class ReplaceSpace {
    /***
     * input: We are happy,
     * output: We20%are%happy
     */
    public static String replaceSpace(String str){
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < str.length();i++){
            if(str.charAt(i)== ' '){
                buffer.append("20%");
            }else{
                buffer.append(str.charAt(i));
            }

        }
        return buffer.toString();

    }
    public static String replaceSpaceReverse(String str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
            if(str.charAt(i) == ' ') {
                res.append("02%");
            }
            else{
                res.append(str.charAt(i));

            }
        }
        return res.reverse().toString();
    }

    /***
     * str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
     * @param str       基本类型：不会影响实际参数的值
     *                 引用类型：会影响实际参数的值
     * @return
     */
    public static String replaceSpaceFinal(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
            {spacenum++;}
        }

        int indexold = str.length()-1; //indexold为为替换前的str下标

        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("We are happy");
        String result = replaceSpaceFinal(sb1);
        System.out.println(result);
    }

}
