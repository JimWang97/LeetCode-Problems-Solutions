package offer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
public class offer09 {
    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack<Integer> ();
            stack2 = new Stack<Integer> ();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack1.isEmpty()) {
                return -1;
            }
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int ans = stack2.pop();
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return ans;
        }
    }
}
