package com.lxl.test.innerclass;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        System.out.println(test());
//
//        Integer i1 = -100;
//        Integer i2 = -100;
//        Integer i3 = -200;
//        Integer i4 = -200;
//        System.out.println(i1 == i2);
//        System.out.println(i3 == i4);

//        Double d1 = 1.0;
//        Double d2 = 1.0;
//        Double d3 = 2.0;
//        Double d4 = 2.0;
//        System.out.println(d1 == d2);
//        System.out.println(d3 == d4);
        /**
         * 原因：将基本数据类型赋值给时触发自动装箱，会调用XXX.valueOf方法，XXX为基本类型对应的包装类。通过包装类的valueOf方法装箱。
         * 产生不同结果的原因是Double的valueOf方法是始终new一个Double对象来包装double基本类型变量，所以都为false；
         * 而Integer的valueOf方法是先做判断如果缓存范围中包括传入值，则放回缓存的Integer对象作为传入基本类型的包装类，如果不在范围内
         * 则new一个Integer作为包装类，因为Java默认Integer范围为-127到128之间，所以当超过这个范围时，new一个新的Integer对象返回，导致结果为false
         *问题：如何修改Integer缓存范围？最大值最小值都可以修改么？
         */

//        String b = new String("abc");
//        String a = "abc";
//        b = b.intern();
//        System.out.println(a == b);
//        String a = "abcdef";
//        String b = "abc";
//        String c = "def";
//        String d = b + c;
//        String f = "abc" + "def";
//        System.out.println(a == d);
//        System.out.println(a == f);


    }

    private static int test() {
        int num = 10;
        try{
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num > 20:" + num);
            }
            System.out.println("finally");
            num += 10;
            return num;
        }
    }
}
