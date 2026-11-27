class Solution {
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
