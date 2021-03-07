package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 双端队列。每次插入的时候，把前面小于的全部先删除，在插入
 */
public class offer59_2a {
    class MaxQueue {

        Deque<Integer> q;
        Queue<Integer> q1;
        public MaxQueue() {
            q = new LinkedList<>();
            q1 = new LinkedList<>();
        }

        public int max_value() {
            return q.peekFirst();
        }

        public void push_back(int value) {
            while(!q.isEmpty() && q.peekLast()>value) {
                q.removeLast();
            }
            q.addLast(value);
            q1.add(value);
        }

        public int pop_front() {
            if(q1.peek().equals(q.peekFirst())) {
                q.removeFirst();
            }
            int ans = q1.remove();
            return ans;
        }
    }
}
