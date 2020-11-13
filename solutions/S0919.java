package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * 
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * 
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构； CBTInserter.insert(int
 * v) 向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * 
 * 
 * 示例 1：
 * 
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]] 示例 2：
 * 
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs =
 * [[[1,2,3,4,5,6]],[7],[8],[]] 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 */
public class S0919 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.peek();
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right !=null){
                queue.offer(root.right);
            } else {
                break;
            }
            queue.poll();
        }
    }
    
    public int insert(int v) {
        TreeNode t = new TreeNode(v);
        TreeNode tmp = queue.peek();
        if(tmp.left==null){
            tmp.left = t;
        } else {
            tmp.right = t;
            queue.poll();
        }
        queue.offer(t);
        return tmp.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}