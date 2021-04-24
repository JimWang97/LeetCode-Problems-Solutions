package solutions;

/**
 * 390. 消除游戏
 * 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 *
 * 示例：
 *
 * 输入:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * 输出:
 * 6
 *
 * 我们的目标是要寻找最后只剩下一个元素的列表的第一个元素。假设first是消除过程中列表的第一个元素，count为消除后剩下的元素个数，diff为列表的公差。我们可以发现以下几个规律：
 *
 * 消除过程中的列表必定是一个等差数列，且diff是不断翻倍的。我们可以用first和diff来表征一个列表；
 * 每轮消除之后，count变成原来的1/21/2；
 * 每轮消除之后的first跟当前消除的方向以及count的奇偶性有关。
 * 如果从左往右消除，则新列表的first就是当前消除列表的第二个元素，即为first + diff，其中diff是当前要消除的列表的diff；
 * 如果是从右往左消除，则新列表的first值会受count的奇偶性所影响，举个例子，如果count是奇数，如[1,2,3,4,5][1,2,3,4,5]，那么从右开始消除，则会消掉1, 3, 51,3,5, 剩下[2, 4][2,
 * 4]。如果count是偶数, 如[1,2,3,4][1,2,3,4]，则从右开始消除之后，剩下[1, 3][1,3]。可以发现，如果count是奇数，新列表的first即为first + diff，否则新列表first不变。
 *
 * 作者：yuruiyin
 * 链接：https://leetcode-cn.com/problems/elimination-game/solution/zhao-gui-lu-by-yuruiyin/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class S0390a {
    class Solution {
        public int lastRemaining(int n) {
            int count = n;
            int first = 1;
            int diff = 1;
            boolean isFromLeft = true;
            while (count > 1) {
                if (isFromLeft) {
                    first += diff;
                } else {
                    if ((count & 1) == 1) {
                        first += diff;
                    }
                }

                count >>>= 1;
                diff <<= 1;
                isFromLeft = !isFromLeft;
            }

            return first;
        }
    }
}
