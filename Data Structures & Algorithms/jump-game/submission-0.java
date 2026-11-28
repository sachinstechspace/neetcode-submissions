class Solution {
    public boolean canJump(int[] nums) {
        int bird = 0; // Bird hops from tree to tree
        for (int i = 0; i < nums.length; i++) {
            if (i > bird) { // Bird cannot fallback
                return false;
            }
            bird = Integer.max(bird, nums[i] + i);
        }
        return bird >= nums.length - 1;
    }
}
