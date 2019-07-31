package com.clark.lu.demo.structure;

/**
 * created by LuChang
 * 2019/7/31 15:48
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        ListNode node = this;
        while (node != null){
            s.append(node.val).append("  ");
            node = node.next;
        }
        return s.toString();
    }
}
