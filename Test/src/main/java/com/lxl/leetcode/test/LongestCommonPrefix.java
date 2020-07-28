package com.lxl.leetcode.test;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1184 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class LongestCommonPrefix {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.err.println(longestCommonPrefix(new String[]{"a","b"}));
        long end = System.currentTimeMillis();
        System.err.println("执行时间：" + (end - start) + "ms");
    }

    public static String longestCommonPrefix(String[] strs) {
        /**
         * 方法一：调用String的startWith方法
         */
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int mixLenthIndex = 0;
        int mixLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            if (strs[i].length() < mixLength) {
                mixLenthIndex = i;
                mixLength = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        if (strs[mixLenthIndex].length() == 0) {
            return "";
        }
        sb.append(strs[mixLenthIndex].charAt(0));
        boolean breakCondition = true;
        int j = 1;
        while (breakCondition) {
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(sb.toString())) {
                    breakCondition = false;
                    break;
                }
            }

            if (breakCondition) {
                if (j >= strs[mixLenthIndex].length()) {
                    return sb.toString();
                }
                sb.append(strs[mixLenthIndex].charAt(j));
                j++;
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
