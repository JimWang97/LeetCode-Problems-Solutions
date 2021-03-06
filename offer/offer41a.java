package offer;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 两个堆，一个大顶堆一个小顶堆。维持两个堆的大小平衡。就可以理解为把一个数组
 * 分成两堆，左边是小的，右边是大的，求中位数的时候，小的最右边 和 大的最左边
 * 就是候选中位数，奇数就取小的最右。偶数就求平均
 */
public class offer41a {

    PriorityQueue<Integer> left;//大顶
    PriorityQueue<Integer> right;//小顶
    public MedianFinder() {
        left=new PriorityQueue<>((n1,n2)->n2-n1);
        right=new PriorityQueue<>();
    }
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(left.size()+1<right.size())
            left.add(right.poll());
    }
    public double findMedian() {
        if(right.size()>left.size())return right.peek();
        return (double)(left.peek()+right.peek())/2;
    }
}
