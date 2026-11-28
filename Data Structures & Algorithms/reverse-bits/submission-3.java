class Solution {
    public int reverseBits(int n) {
        int rotN = 0;
        int N = 32;
        while(N > 0) {
            rotN = rotN | ((1&n) << (N-1));
            n = n >> 1;
            N--;
        }
        return rotN;
    }
}
