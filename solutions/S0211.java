package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 211. 添加与搜索单词 - 数据结构设计 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 
 * 实现词典类 WordDictionary ：
 * 
 * WordDictionary() 初始化词典对象 void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 bool
 * search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.'
 * ，每个 . 都可以表示任何一个字母。
 * 
 * 
 * 示例：
 * 
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]] 输出：
 * [null,null,null,null,false,true,true,true]
 * 
 * 解释： WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad"); wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad"); wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True wordDictionary.search(".ad"); //
 * return True wordDictionary.search("b.."); // return True
 */
public class S0211 {
    Map<Integer, Set<String>> dic;
    /** Initialize your data structure here. */
    public WordDictionary() {
        dic = new HashMap<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        if(dic.get(len)!=null){
            dic.get(len).add(word);
        } else {
            Set<String> s = new HashSet<>();
            s.add(word);
            dic.put(len, s);
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Set<String> set = dic.get(word.length());
        if(set==null) return false;
        if(set.contains(word)) return true;
        for(String s : set){
            int i=0;
            int len = word.length();
            for(i = 0;i<len;i++){
                if(s.charAt(i)!=word.charAt(i) && word.charAt(i)!='.') break;
            }
            if(i==len) return true;
        }
        return false;
    }
}