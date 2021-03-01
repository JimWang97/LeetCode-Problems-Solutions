package offer;

import java.util.Stack;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 *
 *
 *
 *
 *
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 *
 *
 *
 *
 *
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * 中序遍历，一个一个转换
 */
public class offer36a {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        Node node = root;
        Stack<Node> stack = new Stack<>();
        Node head = null;
        Node prev = null;
        do{
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            //当前遍历到的节点
            node = stack.pop();

            if(head == null){
                head = node;
            }else{
                prev.right = node;
            }

            //链表转换, 左指针指向前一个节点
            node.left = prev;
            prev = node;

            node = node.right;
        }while(!stack.isEmpty() || node != null);

        //处理头节点与尾节点
        head.left = prev;
        prev.right = head;
        return head;
    }
}
