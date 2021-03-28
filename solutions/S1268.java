package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1268. 搜索推荐系统
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 *
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 *
 * https://leetcode-cn.com/problems/search-suggestions-system/solution/zi-dian-shu-dfsjava-by-chopinxbp/
 *
 * 字典树
 */
public class S1268 {
    class Solution {
        class Node {
            boolean end = false;
            String str = null;
            int count = 0;
            Node[] children = new Node[26];
        }

        class DictTree {
            Node root = new Node();
            public void insert(String[] products) {
                for(String p : products) {
                    insertWord(p);
                }
            }
            public void insertWord(String word) {
                Node node = root;
                for(char c : word.toCharArray()) {
                    if(node.children[c-'a']==null) {
                        node.children[c-'a'] = new Node();
                    }
                    node = node.children[c-'a'];
                }
                if(!node.end) {
                    node.end = true;
                    node.str = word;
                }
                node.count++;
            }
            public List<List<String>> searchWord(String searchWord) {
                List<List<String>> ans = new ArrayList<>();
                int len = searchWord.length();
                for(int i = 1; i <= len; i++) {
                    ans.add(search(searchWord.substring(0,i)));
                }
                return ans;
            }

            private List<String> search(String substring) {
                List<String> ans = new ArrayList<>();
                Node node = root;
                for(char c : substring.toCharArray()) {
                    if(node.children[c-'a']==null) {
                        return ans;
                    }
                    node = node.children[c-'a'];
                }
                solution(node, ans);
                return ans;
            }

            private void solution(Node node, List<String> ans) {
                if(node.end) {
                    for(int i = 0; i < node.count; i++) {
                        ans.add(node.str);
                        if(ans.size()==3) return;
                    }
                }
                for(Node n:node.children) {
                    if(n!=null) {
                        solution(n, ans);
                    }
                    if(ans.size()==3) return;
                }
            }
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            DictTree dt = new DictTree();
            dt.insert(products);
            List<List<String>> lists = dt.searchWord(searchWord);
            return lists;
        }
    }
}
