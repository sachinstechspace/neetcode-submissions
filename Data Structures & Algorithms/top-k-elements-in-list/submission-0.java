class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        for(int i : nums) {
            countMap.merge(i, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            Map.Entry.comparingByValue(Comparator.reverseOrder())
        );
        pq.addAll(new ArrayList(countMap.entrySet()));
        int[] res = new int[k];
        int idx = 0;
        while(k > 0) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res[idx] = entry.getKey();
            k--;
            idx++;
        }
        return res;
    }
}
