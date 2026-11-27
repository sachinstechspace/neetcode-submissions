class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            res[i] = hammingWeight(i);
        }
        return res;
    }

    public int hammingWeight(int n) {
        int n1s = 0;
        while (n > 0) {
            if ((n & 1) > 0) {
                n1s++;
            }
            n = n >> 1;
        }
        return n1s;
    }
}
