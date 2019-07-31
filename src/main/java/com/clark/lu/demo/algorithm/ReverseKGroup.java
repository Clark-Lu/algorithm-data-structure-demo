package com.clark.lu.demo.algorithm;

import com.clark.lu.demo.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by LuChang
 * 2019/7/31 15:47
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode list = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        System.out.println(reverseKGroup(list,3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = null;
        List<ListNode> list = new ArrayList<>(k);
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            list.add(node);
            if (list.size() == k) {
                list.get(0).next = list.get(k-1).next;
                if (pre != null) {
                    pre.next = list.get(k - 1);
                }
                if (result == null){
                    result = list.get(k - 1);
                }
                for (int i = k - 1; i > 0; i--) {
                    list.get(i).next = list.get(i - 1);
                }
                pre = list.get(0);
                node = pre.next;
                list.clear();
            }else {
                node = node.next;
            }
        }

        if (list.size() > 0){
            if (pre != null){
                pre.next = list.get(0);
            }
            if (result == null){
                result = list.get(0);
            }
        }
        return result;
    }

}
