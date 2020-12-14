package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import sun.util.locale.provider.HostLocaleProviderAdapter;


/**
 * 1079. 活字印刷 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * 
 * 注意：本题中，每个活字字模只能使用一次。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："AAB" 输出：8 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 */
public class S1079 {
    Map<Character, Integer> map;
    int ans=0;
    public int numTilePossibilities(String tiles) {
        map = new HashMap<>();
        char[] str = tiles.toCharArray();
        for(char c : str){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        helper(new String(), 0, tiles.length());
        return ans;
    }

    public void helper(String s, int num, int len){
        if(num<=len && num!=0){
            ans++;
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int tmp = entry.getValue();
            if(tmp!=0){
                entry.setValue(tmp-1);
                helper(s+entry.getKey(), num+1, len);
                entry.setValue(tmp);
            }
        }
    }
}