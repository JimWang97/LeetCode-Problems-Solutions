package offer;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class offer25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode node = head;
        while(l1!=null&&l2!=null) {
            if(l1.val<l2.val) {
                node.next = l1;
                l1=l1.next;
                node = node.next;
            } else {
                node.next= l2;
                l2=l2.next;
                node = node.next;
            }
        }
        while(l1!=null) {
            node.next = l1;
            l1=l1.next;
            node = node.next;
        }
        while(l2!=null) {
            node.next = l2;
            l2=l2.next;
            node = node.next;
        }
        return head.next;
    }
}
