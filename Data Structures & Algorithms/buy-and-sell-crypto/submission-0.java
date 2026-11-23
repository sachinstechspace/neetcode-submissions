class Solution {
    public int maxProfit(int[] prices) {
        int[] maxArray = new int[prices.length];
        int[] minArray = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                minArray[i] = Math.min(Integer.MAX_VALUE, prices[i]);
            } else {
                minArray[i] = Math.min(minArray[i - 1], prices[i]);
            }
        }
        for (int i = prices.length - 1; i >= 0; i--) {
            if (i == prices.length - 1) {
                maxArray[i] = Math.max(Integer.MIN_VALUE, prices[i]);
            } else {
                maxArray[i] = Math.max(maxArray[i + 1], prices[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < minArray.length; i++) {
            System.out.println(minArray[i] + " " + maxArray[i]);
            res = Math.max(res, maxArray[i] - minArray[i]);
        }
        return res;

    }
}
