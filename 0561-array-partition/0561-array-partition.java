import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // Step 1: Sort the array to group close numbers together
        Arrays.sort(nums);
        
        int maxSum = 0;
        
        // Step 2: Sum up every alternate element starting from index 0
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        
        return maxSum;
    }
}