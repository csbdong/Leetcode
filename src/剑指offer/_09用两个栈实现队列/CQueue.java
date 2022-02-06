package 剑指offer._09用两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public CQueue() {
        first = new Stack();
        second = new Stack();
    }

    public void appendTail(int value) {
        first.push(value);
    }

    public int deleteHead() {
        if (second.size() > 0) {
            return second.pop();
        }
        while (first.size() > 0) {
            second.push(first.pop());
        }
        if (second.size() > 0) {
            return second.pop();
        }
        return -1;

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */