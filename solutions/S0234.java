package solutions;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class S0234 {
    public class ListNode {
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

    class Solution {
        private ListNode left;
        public boolean isPalindrome(ListNode head) {
            left = head;
            return helper(head);
        }

        public boolean helper(ListNode node) {
            if(node==null) return true;
            boolean ans = helper(node.next);
            ans = ans && (left.val==node.val);
            left = left.next;
            return ans;
        }
    }
}
