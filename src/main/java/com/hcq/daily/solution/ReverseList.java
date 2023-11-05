package com.hcq.daily.solution;

import com.hcq.daily.structure.ListNode;

public class ReverseList {

    /**
     * 反转链表
     * @param head 头
     * @return 反转后的值
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (head != null) {
            head = head.next;
            node.next = pre;
            pre = node;
            node = head;
        }
        return pre;
    }

}
