package 程序员代码面试指南.栈和队列;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 栈的最小值 {
    class MinStack {

        /**
         * initialize your data structure here.
         */
        private Stack<Integer> inStack;
        private Stack<Integer> mStack;

        public MinStack() {
            inStack = new Stack();
            mStack = new Stack();
        }

        public void push(int x) {
            inStack.push(x);
            if (mStack.isEmpty()) {
                mStack.push(x);
            } else {
                mStack.push(Math.min(x, mStack.peek()));
            }
        }

        public void pop() {
            inStack.pop();
            mStack.pop();
        }

        public int top() {
            return inStack.peek();
        }

        public int getMin() {
            return mStack.peek();
        }
    }


    class MinStackV2 {

        /**
         * initialize your data structure here.
         */
        private Stack<Integer> inStack;
        private Stack<Integer> mStack;

        public MinStackV2() {
            inStack = new Stack();
            mStack = new Stack();
        }

        public void push(int x) {
            inStack.push(x);
            if (mStack.isEmpty()) {
                mStack.push(x);
            } else {
                if (mStack.peek() >= x) {
                    mStack.push(x);
                }
            }
        }

        public void pop() {
            int value = inStack.pop();
            if (value == mStack.peek()) {
                mStack.pop();
            }
        }

        public int top() {
            return inStack.peek();
        }

        public int getMin() {
            return mStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
