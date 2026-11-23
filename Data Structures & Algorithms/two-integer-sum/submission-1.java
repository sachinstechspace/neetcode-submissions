class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> posMap = new HashMap();
        int idx = 0;
        for (int i : nums) {
            posMap.put(i, idx);
            idx++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (posMap.containsKey(target - nums[i]) && i != posMap.get(target - nums[i])) {
                return new int[]{i, posMap.get(target - nums[i])};
            }
        }
        return new int[]{0, 0};
    }
}
