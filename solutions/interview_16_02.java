package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 */
public class interview_16_02 {
    class WordsFrequency {

        Map<String, Integer> map;
        public WordsFrequency(String[] book) {
            map = new HashMap<>();
            for(String word : book) {
                Integer num = map.getOrDefault(word, 0) + 1;
                map.put(word, num);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }
}
