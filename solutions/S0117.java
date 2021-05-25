package solutions;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class S0117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        Node nextStart, last;
        public Node connect(Node root) {
            if(root==null) return null;
            Node start = root;
            while(start!=null) {
                last = null;
                nextStart = null;
                for(Node p = start; p != null; p = p.next) {
                    if(p.left!=null) {
                        handle(p.left);
                    }
                    if(p.right!=null) {
                        handle(p.right);
                    }
                }
                start = nextStart;
            }
            return root;
        }

        private void handle(Node node) {
            if(last!=null) {
                last.next = node;
            }
            if(nextStart==null) {
                nextStart = node;
            }
            last = node;
        }
    }
}
