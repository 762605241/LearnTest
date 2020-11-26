package com.lxl.leetcode.test;

public class deleteDuplicates {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode head = deleteDuplicates(a);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val == pre.val) {
                pre.next = next.next;
            } else {
                pre = next;
            }
            next = next.next;
        }
        return head;
    }
}
class ListNode {
    int val;
    com.lxl.leetcode.test.ListNode next;
    ListNode(int x) { val = x; }
}
