package com.clark.lu.demo.algorithm;

import com.clark.lu.demo.structure.ListNode;

/**
 * created by LuChang
 * 2019/7/31 14:53
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode list = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode node = swapPairs(list);
        do {
            System.out.println(node.val);
            node = node.next;
        }while (node != null);
    }


    public  static ListNode swapPairs(ListNode head){
        ListNode node1 = head,node2,node3 = null;
        ListNode result = head;
        if (head.next != null){
            result = head.next;
        }
        while (node1 != null){
            //swap node1 and node2
            if (node1.next != null) {
                node2 = node1.next;
                if (node3 != null) {
                    node3.next = node2;
                }
                node1.next = node2.next;
                node2.next = node1;
            }
            //move back
            node3 = node1;
            node1 = node1.next;
        }
        return result;
    }

}
