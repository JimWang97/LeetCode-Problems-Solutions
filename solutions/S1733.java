package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1733. 需要教语言的最少人数
 * 在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
 *
 * 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
 *
 * 总共有 n 种语言，编号从 1 到 n 。
 * languages[i] 是第 i 位用户掌握的语言集合。
 * friendships[i] = [u​​​​​​i​​​, v​​​​​​i] 表示 u​​​​​​​​​​​i​​​​​ 和 vi 为好友关系。
 * 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
 *
 * 请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
 * 输出：1
 * 解释：你可以选择教用户 1 第二门语言，也可以选择教用户 2 第一门语言。
 *
 * 对所有没有共同语言的，选一门最多人的共同语言，让他们学
 */
public class S1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int[] arr = new int[n + 1];
        int m = languages.length;//用户数
        Set<Integer> set = new HashSet<>();
        for (int[] friendship : friendships) {
            int person1 = friendship[0] - 1;
            int person2 = friendship[1] - 1;
            if (!haveSameLanguage(person1, person2, languages)) {
                set.add(person1);
                set.add(person2);
            }
        }
        for (int person : set) {
            for (int lang : languages[person]) {
                arr[lang]++;
            }
        }
        int most = 0;
        for (int i = 1; i <= n; i++) {
            most = Math.max(most, arr[i]);//统计set中使用人数最多的语言
        }
        return set.size() - most;
    }

    private boolean haveSameLanguage(int person1, int person2, int[][] languages) {
        for (int x : languages[person1]) {
            for (int y : languages[person2]) {
                if (x == y) {
                    return true;
                }
            }
        }
        return false;
    }
}
