package com.clark.lu.demo.algorithm;

import com.clark.lu.demo.structure.ListNode;

/**
 * created by LuChang
 * 2019/7/29 19:49
 */
public class MergeListNode {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        ListNode listNode1 = new ListNode(2,new ListNode(4,new ListNode(5,null)));
        ListNode listNode3 = new ListNode(2,new ListNode(4,new ListNode(5,null)));
        ListNode listNode4 = new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,null))));
        ListNode listNode2 = mergeListNode(new ListNode[]{listNode,listNode1,listNode3,listNode4});
        do {
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }while (listNode2 != null);
    }


    public static ListNode mergeListNode(ListNode[] listNodes){
        ListNode result = new ListNode();
        ListNode[] sortedNode = new ListNode[listNodes.length];
        for (int i = 0; i < listNodes.length; i++) {
            insertNode(sortedNode,listNodes[i]);
        }
        boolean hasMore = true;
        ListNode current = result;
        while (hasMore){
            ListNode node = null;
            ListNode next;
            for (int i = 0; i < sortedNode.length; i++) {
                if (sortedNode[i] != null){
                    if (node == null) {
                        node = sortedNode[i];
                        sortedNode[i] = null;
                        current.next = new ListNode(node.val,null);
                        current = current.next;
                        if (node.next != null) {
                            next = node.next;
                            insertNode(sortedNode,next);
                            break;
                        }
                    }
                }else if (i == sortedNode.length - 1){
                    hasMore = false;
                }
            }

        }
        return result.next;
    }

    private static void insertNode(ListNode[] sortedNode,ListNode node){
        for (int i = sortedNode.length - 1; i >= 0; i--) {
            if (sortedNode[i] == null){
                sortedNode[i] = node;
                break;
            }else if (node.val >= sortedNode[i].val){
                moveForward(sortedNode,i);
                sortedNode[i] = node;
                break;
            }
        }
    }

    private static void moveForward(ListNode[] sortedNode, int i){
        for (int j = 0; j < i; j++) {
            sortedNode[j] = sortedNode[j+1];
        }
    }



}
