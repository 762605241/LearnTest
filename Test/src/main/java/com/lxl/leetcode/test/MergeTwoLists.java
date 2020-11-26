package com.lxl.leetcode.test;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoLists {
//
//    public static void main(String[] args) {
////			测试用例:[1,2,4]
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(4);
//        l1.next = l2;
//        l2.next = l3;
//        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(3);
//        ListNode l6 = new ListNode(4);
//        l4.next = l5;
//        l5.next = l6;
//        ListNode listNode = mergeTwoLists(l1, l4);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//
//    }
//
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            return null;
//        } else if (l1 == null && l2 != null) {
//            return l2;
//        } else if (l1 != null && l2 == null) {
//            return l1;
//        }
//        /**
//         * 方法一：将两个链表合并 转换成集合，然后调用排序方法。在构建成链表
//         * 			执行耗时:3 ms,击败了62.65% 的Java用户
//         * 			内存消耗:39.7 MB,击败了10.53% 的Java用户
//
//         ArrayList<ListNode> list = new ArrayList<>();
//         while (l1 != null) {
//         list.add(l1);
//         l1 = l1.next;
//         }
//         while (l2 != null) {
//         list.add(l2);
//         l2 = l2.next;
//         }
//         // 排序
//         list.sort(new Comparator<ListNode>() {
//        @Override
//        public int compare(ListNode o1, ListNode o2) {
//        return o1.val - o2.val;
//        }
//        });
//         ListNode startNode = list.get(0);
//         ListNode tempNode = list.get(0);
//         for (int i = 1; i < list.size(); i++) {
//         tempNode.next = list.get(i);
//         tempNode = tempNode.next;
//         }
//         return startNode;
//         */
//        /**
//         * 方法二：因为两个链表本身就是升序的，所以只要遍历 每次同时取出两个链表的头节点 作比较， 然后按顺插入。
//         * 直到链表结束
//         * 			执行耗时:1 ms,击败了62.65% 的Java用户
//         * 			内存消耗:39.5 MB,击败了39.94% 的Java用户
//
//
//         ListNode listNode = null;
//         ListNode temp = null;
//         if (l1.val < l2.val) {
//         temp = new ListNode(l1.val);
//         listNode = temp;
//         l1 = l1.next;
//         } else {
//         temp = new ListNode(l2.val);
//         listNode = temp;
//         l2 = l2.next;
//         }
//         while (l1 != null && l2 != null) {
//         if (l1.val < l2.val) {
//         temp.next = new ListNode(l1.val);
//         l1 = l1.next;
//         } else {
//         temp.next = new ListNode(l2.val);
//         l2 = l2.next;
//         }
//         temp = temp.next;
//         }
//         while (l1 != null) {
//         temp.next = new ListNode(l1.val);
//         l1 = l1.next;
//         temp = temp.next;
//         }
//         while (l2 != null) {
//         temp.next = new ListNode(l2.val);
//         l2 = l2.next;
//         temp = temp.next;
//         }
//         return listNode;
//         */
//        /**
//         * 方法三：原理同方法二，只是通过递归实现
//         */
//        if (l1 == null) {
//            return l2;
//        }
//        else if (l2 == null) {
//            return l1;
//        }
//        else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//        else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
