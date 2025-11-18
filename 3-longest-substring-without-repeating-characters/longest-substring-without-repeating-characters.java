import java.util.HashSet;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current window
        HashSet<Character> set = new HashSet<>();
        
        int left = 0;   // left pointer of the window
        int maxLength = 0;
        
        // Expand the window with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If duplicate found, shrink window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to the set
            set.add(currentChar);
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    // Testing with examples
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}
