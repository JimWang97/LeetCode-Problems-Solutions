package offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class offer30 {
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minstack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minstack = new Stack<>();
            minstack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            if(x<=minstack.peek()) {
                minstack.push(x);
            }
        }

        public void pop() {
            int tmp = stack.peek();
            if(tmp==minstack.peek()) {
                minstack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minstack.peek();
        }
    }
}
