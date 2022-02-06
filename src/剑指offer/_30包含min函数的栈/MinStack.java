package 剑指offer._30包含min函数的栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minValue;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList();
        minValue = new LinkedList();
    }

    public void push(int x) {
        stack.push(x);
        if (minValue.isEmpty() || minValue.peek() >= x) {
            minValue.push(x);
        }


    }

    public void pop() {
        int p = stack.pop();
        if (minValue.peek().equals(p)) {
            minValue.pop();
        }


    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */