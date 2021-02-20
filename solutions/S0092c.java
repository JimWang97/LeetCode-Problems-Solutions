package solutions;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class S0092c {
    public ListNode next;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reverseBetween_1(head, left, right-left+1);
    }
    public ListNode reverseBetween_1(ListNode head, int m, int n) {
        // m表示开头, 表示需要反转几个
        if(m==1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween_1(head.next, m-1, n);
        return head;
    }
    public ListNode reverseN(ListNode head, int n) {
        if(n==1) {
            next = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = next;
        return last;
    }
}
