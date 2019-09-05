package String;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/5-2:32 PM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class StringAPIDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

//      1 字面量创建字符串对象的方式  iterals   推荐使用方式
        String str1 = "hello";
//      2 传统的创建方式
//      从内存分析：参数"hello" 是匿名字符对象，在下面代码执行完毕之后依旧会被回收
        String str2 = new String("hello").intern();

        String str3 = str1;

//      如果字符串常量池中之前有hello字符串对象，则str4直接指向这个字符串对象。
//      不用重新开辟新的内存空间，如此，可节省内存资源。
        String str4 = "hello";//str4 = str1;

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);

//      "laosun" 匿名字符串  执行完毕下面一条代码，laosun字符串对象就会当做垃圾被GC回收。
        System.out.println("laosun");


//      intern()
//      A pool of strings, initially empty, is maintained privately by the class String.



//      3 避免nullPointerException
        String str5 = null;

//      str5.equals("laosun");
//      字符串常量会放在前面，调用方法。
        "laosun".equals(str5);

//      4 接下来字符串的API方法  API  看类的结构，看类中有哪些属性和方法供调用
//      Application Program Interface
//      应用程序接口

//      charAt(index) 根据索引获得对应的字符
        String str6 = "hello world";
        char char1 = str6.charAt(str6.length() - 1);
        System.out.println(char1);

//      5 indexOf(char) 返回某个字符的索引值
        int index = str6.indexOf('w');
        System.out.println(index);

//      6 前缀 后缀  返回值为boolean
        boolean isStart = str6.startsWith("heli");
        boolean isEnd   = str6.endsWith("orld");
        System.out.println(isStart + "==="+isEnd);

//      7 拼接  concat
//      String str7 = "laosun" + " is a handsome man";
        String str7 = str6.concat(" this is a java ");
        System.out.println(str7);

//      8 截取 substring
        String subStr1 = str7.substring(5);
        String subStr2 = str7.substring(5, 15);
        System.out.println(subStr1+"---"+subStr2);

//      9 替换  replace  返回一个String
        String replaceStr = str7.replace("java", "C++");
        System.out.println(replaceStr);

//      10 分割  split  String[]
//      开发过程中：分割URL，文件地址C:/zhiyou/java/a.txt
        String[] splitArr = str7.split(" ");
        for (String string : splitArr) {
            System.out.println(string);
        }

        String packageStr = "com.zhiyou.string.laosun.demo";
//      \\. 代表.符号
        String[] array = packageStr.split("\\.");
        System.out.println(array.length);
        for (String string : array) {
            System.out.println("----"+string);
        }

//      11 trim 去除字符串两边的空格
        System.out.println("  lao  sun ".trim());

//      注意：trim去除的是半角的空格，对于全角的空格（Unicode为12288）是无效的，
//      解决 方法是先用半角的空格替换，然后再用trim方法

//      12 向上向下取整
        System.out.println(str7.toUpperCase());
        System.out.println(str7.toLowerCase());

        char spaceCh = 12288;//全角空格
        char spaceCh1 = 32;  //半角空格
        String laosunStr = spaceCh +"laosun"+spaceCh1;
        System.out.println(laosunStr.length());

        System.out.println("++++"+laosunStr.trim()+"++++");

        String newLaosunStr = laosunStr.replace(spaceCh, spaceCh1);
        System.out.println("++++"+newLaosunStr.trim()+"++++");
        // 测试ASCII
        byte[] b = {66,1,67};
        String s = new String(b);
        System.out.println("s="+s);
        System.out.println("s的长度是："+s.length());
    }
}
