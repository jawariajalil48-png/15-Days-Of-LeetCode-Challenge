import java.util.*;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        // Base case: if equal
        if (s1.equals(s2)) return true;
        
        // Quick pruning: if sorted chars differ, not scramble
        if (!haveSameChars(s1, s2)) return false;
        
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);
        
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Case 2: Swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }
        
        memo.put(key, false);
        return false;
    }
    
    private boolean haveSameChars(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
