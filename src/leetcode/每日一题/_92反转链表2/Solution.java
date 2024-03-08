package leetcode.每日一题._92反转链表2;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur;
        ListNode pre = dummy;
        int dis = right - left + 1;
        while (left > 1) {
            pre = pre.next;
            left--;
        }
        ListNode before = pre;
        cur = pre.next;
        ListNode after = pre.next;
        ListNode next = null;
        while (dis > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            dis--;
        }

        before.next = pre;
        after.next = next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);

        ListNode one = new ListNode(1, two);
        new Solution().reverseBetween(one, 2, 4);
    }
}

class ListNode {
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
