package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1487. 保证文件名唯一
 * 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *
 * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 *
 *
 *
 * 示例 1：
 *
 * 输入：names = ["pes","fifa","gta","pes(2019)"]
 * 输出：["pes","fifa","gta","pes(2019)"]
 * 解释：文件系统将会这样创建文件名：
 * "pes" --> 之前未分配，仍为 "pes"
 * "fifa" --> 之前未分配，仍为 "fifa"
 * "gta" --> 之前未分配，仍为 "gta"
 * "pes(2019)" --> 之前未分配，仍为 "pes(2019)"
 */
public class S1487 {
    class Solution {
        public String[] getFolderNames(String[] names) {
            if (names == null || names.length == 0) {
                return null;
            }
            // 结果字符串数组
            String[] re = new String[names.length];
            // 保存文件出现的次数
            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<names.length; i++) {
                // 如果没有出现过，直接赋值即可
                if (!map.containsKey(names[i])) {
                    re[i] = names[i];
                    map.put(names[i], 1);
                } else {
                    // 如果出现过，先取出之前出现的次数，再判断后序的有没有出现过
                    int count=map.get(names[i]);
                    while (map.containsKey(names[i] + "(" + count + ")")) {
                        count++;
                    }
                    // 细节：记得更新
                    map.put(names[i] + "(" + count + ")", 1);
                    map.put(names[i], map.get(names[i])+1);
                    // 本次的结果
                    re[i] = names[i] + "(" + count + ")";
                }
            }
            return re;
        }
    }
}
