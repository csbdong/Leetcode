package 剑指offer._35复杂链表的复制;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random == null) ? null : node.random.next;
        }
        Node result = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = nodeNew.next == null ? null : nodeNew.next.next;
        }
        return result;

    }
}


/**
 * class Solution {
 *     private Map<Node,Node> map=new HashMap<Node,Node>();
 *     public Node copyRandomList(Node head) {
 *         if(head==null){
 *             return null;
 *         }
 *         Node newHead;
 *         if(!map.containsKey(head)){
 *             newHead=new Node(head.val);
 *             map.put(head,newHead);
 *         newHead.next=copyRandomList(head.next);
 *         newHead.random=copyRandomList(head.random);
 *         }
 *         return map.get(head);
 *     }
 * }
 */