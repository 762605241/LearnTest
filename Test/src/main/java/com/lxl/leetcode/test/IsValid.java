package com.lxl.leetcode.test;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1740 👎 0


import java.util.ArrayList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class IsValid {
    public static void main(String[] args) {
        System.err.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        /**
         * 方法一：通过栈 存储左括号，若遇到右括号 则判断栈顶是否是 对应的 左括号，是继续，不是 返回false，
         * 直到s遍历结束，遍历结束后，若栈为空 则表示全部括号匹配，否则存在未匹配的括号，返回false
         */
        Stack<Character> stack = new Stack<>();
        char temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                temp = stack.peek();
                if ((s.charAt(i) == ')' && temp == '(') || (s.charAt(i) == ']' && temp == '[') || (s.charAt(i) == '}' && temp == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
