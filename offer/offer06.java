package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class offer06 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public int[] reversePrint(ListNode head) {
        List<Integer> ans = reverse(head);
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    public List<Integer> reverse(ListNode head) {
        if(head==null) {
            return new ArrayList<Integer>();
        }
        List<Integer> ls = reverse(head.next);
        ls.add(head.val);
        return ls;
    }
}
