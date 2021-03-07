package offer;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B
 * 中，相交节点前有 3 个节点。
 *
 * a b两个节点，a走完了换成b， b走完了换成a。然后两个相遇的地方就是了
 */
public class offer52a {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while(a!=b) {
            if(a==null) {
                a = headB;
                continue;
            }
            if(b==null) {
                b = headA;
                continue;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
