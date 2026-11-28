class Solution {
    public int reverseBits(int n) {
        int rotN = 0;
        int N = 32;
        while(N > 0) {
            rotN = rotN | ((1&n) << (N-1));
            n = n >> 1;
            N--;
            // System.out.println(rotN);
        }
        return rotN;
    }

    // private int findN(int n) {
    //     int big = Math.pow(2, 32);
    //     int N = 32; // Number of times to circular rotate right
    //     while((big & n) == 0) {
    //         N--;
    //         big = big >> 1;
    //     }
    //     return N;
    // }
}
