package leetcode.每日一题._23合并k个升序链表;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            pq.offer(node);
        }
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode f_1 = new ListNode(4);
        ListNode f_2 = new ListNode(5);
        first.next = f_1;
        f_1.next = f_2;
        ListNode second = new ListNode(1);
        ListNode s_1 = new ListNode(3);
        ListNode s_2 = new ListNode(4);
        second.next = s_1;
        s_1.next = s_2;
        ListNode third = new ListNode(2);
        ListNode t_1 = new ListNode(6);
        third.next = t_1;
        new Solution().mergeKLists(new ListNode[]{first, second, third});
    }

}