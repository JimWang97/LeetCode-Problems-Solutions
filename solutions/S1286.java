package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1286. Iterator for Combination Design an Iterator class, which has:
 * 
 * A constructor that takes a string characters of sorted distinct lowercase
 * English letters and a number combinationLength as arguments. A function
 * next() that returns the next combination of length combinationLength in
 * lexicographical order. A function hasNext() that returns True if and only if
 * there exists a next combination.
 * 
 * 
 * Example:
 * 
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates
 * the iterator.
 * 
 * iterator.next(); // returns "ab" iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac" iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc" iterator.hasNext(); // returns false
 */
public class S1286 {
    List<String> ls;
    StringBuffer sb = new StringBuffer();
    int i =-1;
    public CombinationIterator(String characters, int combinationLength) {
        ls = new ArrayList<>();
        helper(characters, combinationLength, 0, 0);
    }
    
    public String next() {
        ++i;
        return ls.get(i);
    }
    
    public boolean hasNext() {
        if(i<ls.size()-1) return true;
        else return false;
    }
    public void helper(String characters,int combinationLength, int currentLength, int currentC){
        if(currentLength==combinationLength) {
            ls.add(sb.toString());
            return;
        }
        for(int i = currentC ; i < characters.length(); i++){
            char c = characters.charAt(i);
            sb.append(c);
            helper(characters, combinationLength, ++currentLength, i+1);
            sb.deleteCharAt(--currentLength);
        }
    }
}