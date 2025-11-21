class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;                  // start pointer
        int right = numbers.length - 1; // end pointer

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because the problem requires 1-indexed positions
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;   // move left pointer forward to increase sum
            } else {
                right--;  // move right pointer backward to decrease sum
            }
        }

        // Problem guarantees exactly one solution, so this line is never reached
        return new int[] {-1, -1};
    }
}
