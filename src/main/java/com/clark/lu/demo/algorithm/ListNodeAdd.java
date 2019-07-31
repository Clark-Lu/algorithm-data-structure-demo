package com.clark.lu.demo.algorithm;

import com.clark.lu.demo.structure.ListNode;

/**
 * created by LuChang
 * 2019/6/12 16:29
 */
public class ListNodeAdd {
    /**
     *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        System.out.println(addTwoListNode(l1,l2));
    }

    public static ListNode addTwoListNode(ListNode l1, ListNode l2) {
        int l1Val = l1.val;
        int l2Val = l2.val;
        int sum = l1Val + l2Val;
        int val = sum%10;
        int add = sum/10;
        ListNode result = new ListNode(val);
        l1 = l1.next;
        l2 = l2.next;
        ListNode next = result;
        while(l1 != null || l2 != null || add != 0){
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }else{
                l1Val = 0;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }else{
                l2Val = 0;
            }
            sum = l1Val + l2Val + add;
            val = sum%10;
            add = sum/10;
            next.next = new ListNode(val);
            next = next.next;
        }
        return result;
    }

}
