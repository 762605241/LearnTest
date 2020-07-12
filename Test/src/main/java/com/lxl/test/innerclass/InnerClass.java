package com.lxl.test.innerclass;

import lombok.Data;

@Data
public class InnerClass {
    private String name;
    private String email;

    @Data
    class InnerClassTest{
        private String innerName;
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass(); // 创建public class 对象
        InnerClassTest innerClassTest = new InnerClass().new InnerClassTest(); // 创建内部类对象

    }


    public void test(final int a) {
        class innerClass{
            public void test2() {
                System.out.println(a);
            }
        }
    }

}
