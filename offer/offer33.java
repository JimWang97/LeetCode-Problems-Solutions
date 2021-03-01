package offer;

import java.util.Arrays;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 */
public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if(len<=1) {
            return true;
        }
        int mid = postorder[len-1];
        int ind = -1;
        for(int i = len-1; i >=0; i--) {
            if(postorder[i]<mid) {
                ind=i;
                break;
            }
        }
        for(int i = ind; i >=0; i--) {
            if(postorder[i]>mid) {
                return false;
            }
        }
        return verifyPostorder(Arrays.copyOfRange(postorder,0,ind+1)) && verifyPostorder(Arrays.copyOfRange(postorder, ind+1, len-1));
    }
}
