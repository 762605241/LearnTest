package com.lxl.leetcode.test;

import java.util.Date;
import java.util.Stack;

/**
 * @author 刘晓亮
 * @date 2020/7/24 15:39
 */
public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.err.println(isPalindrome(2131928378));
        long end = System.currentTimeMillis();
        System.err.println("执行时间：" + (end - start) + "ms");
    }


    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }
    public static boolean isPalindrome(int x) {
        /**
         * 方法一：利用栈和队列 的性质， 栈先进后出，队列先进先出。依次遍历x每一位，入栈入队列。同时出栈出队列，判断栈顶和对头元素是否相等，都相等则是回文。
         if (x < 0) {
         return false;
         }
         Queue<Integer> queue = new LinkedList<>();
         Stack<Integer> stack = new Stack<>();
         while (x != 0) {
         queue.offer(x % 10);
         stack.push(x % 10);
         x = x / 10;
         }
         while (!stack.isEmpty()) {
         if (queue.poll() != stack.pop()) {
         return false;
         }
         }
         return true;
         **/
        /**
         * 方法二：利用数组，将x每一位依次存进数组中，若是回文则 x[0] = x[length - 1],依次相等。
         if (x < 0) {
         return false;
         }
         ArrayList<Integer> temp = new ArrayList<>();
         while (x != 0) {
         temp.add(x % 10);
         x = x / 10;
         }
         int i = 0;
         int j = temp.size() - 1;
         while (i <= j) {
         if (temp.get(i) != temp.get(j)) {
         return false;
         }
         i++;
         j--;
         }
         return true;
         */
        /**
         * 方法三：直接计算。将x倒过来 与 x比较
         */
//        if (x < 0) {
//            return false;
//        }
//        int temp = x;
//        int reverseNum = 0;
//        while (x != 0) {
//            reverseNum = reverseNum * 10 + x % 10;
//            x = x / 10;
//
//            System.out.println("1");
//        }
//        return temp == reverseNum;
        /**
         * 方法四：直接计算。将x倒过来 与 x比较
         * 优化方法三
         */
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
