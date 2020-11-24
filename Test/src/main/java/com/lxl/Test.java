package com.lxl;

/**
 * @author 刘晓亮
 * @date 2020/8/10 10:26
 */
public class Test {
    public static void main(String[] args) {
        String s1 = new String("a") + new String("bc");
        String s2 = new String("abc");
        System.out.println(System.identityHashCode(s1));// s1 指向 堆中 new String("abc) 的一个对象.值 是字符串"abc"
        System.out.println(System.identityHashCode(s2));// s2 指向 堆中 new String("abc) 的一个对象 值 指向 常量池中 "abc" 常量
        System.out.println(System.identityHashCode(s1.intern()));// s1.intern() 与 s3 相同
        System.out.println(System.identityHashCode(s2.intern()));// s1.intern() 与 s3 相同
        String s3 = "abc";
        System.out.println(System.identityHashCode(s3));// s3 指向 常量池中 "abc"常量
        System.out.println(System.identityHashCode(s3.intern()));// s2.intern() 与 s3 相同
        /**
         * 证明：
         * 1、包含对象拼接创建String 不会在常量池中创建最终拼接结果的常量对象
         * 2、new String("abc") 在常量池中创建常量
         */

    }
}
