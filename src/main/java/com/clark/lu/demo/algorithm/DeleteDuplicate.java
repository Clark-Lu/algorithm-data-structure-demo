package com.clark.lu.demo.algorithm;

import com.clark.lu.demo.structure.ListNode;

/**
 * created by LuChang
 * 2019/8/13 15:38
 */
public class DeleteDuplicate {

    public static void main(String[] args) {
        System.out.println(deleteDuplicate(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null))))))));
    }

    public static ListNode deleteDuplicate(ListNode head) {
        ListNode result = new ListNode();
        ListNode temp = result;
        ListNode pre = head;
        ListNode cur = pre.next;
        if (pre.val != cur.val) {
            temp.next = new ListNode(pre.val);
            temp = temp.next;
        }
        while (cur != null) {
            if (pre.val != cur.val) {
                if (cur.next != null) {
                    if (cur.next.val != cur.val) {
                        temp.next = new ListNode(cur.val);
                        temp = temp.next;
                    }
                } else {
                    temp.next = new ListNode(cur.val);
                    temp = temp.next;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return result.next;
    }


}
