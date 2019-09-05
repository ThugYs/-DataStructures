package String;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/5-2:56 PM
 */
public class StringDemo {
    /***
     * 总结
     * String s1 = "hello"+"world",
     * 过程，先进行拼接，然后会检查静态区有没有helloworld，没有的话就创建一个新的，有的话就是指向老的,
     * 所以String 在方法里面的操作，只会改变方法里面变量指针的移动和赋值，根本不会改变方法外的变量指向和值
     * String s1, s2 ="hello" "world"
     * String s1= s1+s2
     * 过程中反编译可以看到，其实是Stringbuffer在调用append方法，也就是会新new一个堆地址，所以false
     *
     * Stringbuffer  的append方法不会向String那样去检查Stirng pool里面有没有helloworld，他只会在原来的指针上操作，
     * String buffer
     * @param args
     */

    public static void main(String[] args) {
        //字符串的特点：1、一旦被赋值，就不能改变
        /***
         * 首先String s = “hello”; 在方法区中寻找常量”hello”，找不到直接新建，
         * s += “world”;先在方法区找”world”找不到直接新建，
         * 在执行+=时，把”hello” 与 “world”拼接成新的常量为”helloworld”
         * 然后把”helloworld”的地址赋给String的引用
         */
        String s = "hello";
        s += "world";
        System.out.println("s="+s);//s=helloworld
        /**
         * 面试题：
         * String s = “hello”;和String s = new String(“hello”);的区别：
         * 因为new是作用在堆上，所以，new String(“hello”);
         * 的时候会先在方法区中的常量区寻找”hello”字符串常量，然后接着在堆内存中新建字符串对象,申请的是内存块给对象。
         *
         * 而s = “hello”就mei有在堆内存上新建对象的步骤！
         */
        //s1 -->堆一个内存块--> String pool 里面
//        String s1 = new String("hello");
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        System.out.println(s3 == s2 + "hello");//false
        System.out.println(s3 == s2 + s1);//false
        System.out.println(s3.equals(s1+s2));
        System.out.println(s3 == "hello"+"world");
        System.out.println(s3.equals("hello"+"world"));
        //StringBuffer
        System.out.println("StringBuffer");
        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("world");
        System.out.println("s1:" + sb1 + "\ns2:" + sb2 );
        change(sb1, sb2);
        System.out.println("s1:" + sb1 + "\ns2:" + sb2);

    }
    public void StringInitTwomethod(){
        //
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));//true

        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));//true

        String s5 = "hello";
        String s6 = "hello";
        System.out.println(s5 == s6); //true
        System.out.println(s5.equals(s6));//true
    }
    public void concat(){
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        System.out.println(s3 == s2 + s1);
        System.out.println(s3.equals(s1+s2));
        System.out.println(s3 == "hello"+"world");
        System.out.println(s3.equals("hello"+"world"));
    }


    public static void change(StringBuffer str1, StringBuffer str2) {

        str1 = str2;
        //两个buffer都指向同一个地址，所以，值改变都改变，而且影响方法外的变量，因为Stringbuffer.append的时候不会去检查区域里面没有有"helloworld"
        str2.append(str1);
        System.out.println("change内部str1"+str1);
        System.out.println("change内部str2"+str2);
    }
}
