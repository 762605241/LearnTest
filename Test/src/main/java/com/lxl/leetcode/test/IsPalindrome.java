package com.lxl.leetcode.test;//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1161 👎 0


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class IsPalindrome {
    public boolean isPalindrome(int x) {
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
        if (x < 0) {
            return false;
        }
        int temp = x;
        int reverseNum = 0;
        while (x != 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return temp == reverseNum;
        /**
         * 方法四：直接计算。将x倒过来 与 x比较
         * 优化方法三
         */
//        if (x < 0 || (x != 0 && x % 10 == 0)) {
//            return false;
//        }
//        int reverseNum = 0;
//        while (x > reverseNum) {
//            reverseNum = reverseNum * 10 + x % 10;
//            x = x / 10;
//        }
//        return x == reverseNum || x == reverseNum / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
