package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为
 * '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 */
public class S0752 {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> ds = new HashSet<>();
            for(String dead : deadends) {
                ds.add(dead);
            }
            Set<String> visited = new HashSet<>();
            int step = 0;
            Queue<String> q = new LinkedList<>();
            q.offer("0000");
            if(ds.contains("0000")) return -1;
            while(!q.isEmpty()) {
                int sz = q.size();
                for(int i = 0; i < sz; i++) {
                    String tmp = q.poll();
                    visited.add(tmp);
                    if(target.equals(tmp)) {
                        return step;
                    }
                    for(int j = 0; j < 4; j++) {
                        String up = plus(tmp, j);
                        String down = mins(tmp, j);
                        if(!ds.contains(up)&&!visited.contains(up)) {
                            q.add(up);
                            visited.add(up);
                        }
                        if(!ds.contains(down)&&!visited.contains(down)) {
                            q.add(down);
                            visited.add(down);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private String plus(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '9')
                ch[j] = '0';
            else
                ch[j] += 1;
            return new String(ch);
        }

        private String mins(String s, int j) {
            char[] ch = s.toCharArray();
            if (ch[j] == '0')
                ch[j] = '9';
            else
                ch[j] -= 1;
            return new String(ch);
        }
    }
}
