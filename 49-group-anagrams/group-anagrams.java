import java.util.*;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            // Convert word to char array, sort it, then make it back to string
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add word to the correct group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        
        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    // Example usage
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}
