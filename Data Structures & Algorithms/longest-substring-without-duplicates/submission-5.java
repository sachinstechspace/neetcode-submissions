class Solution {
    public int lengthOfLongestSubstring(String s) {
        int p1 = 0, p2 = 0;
        int max = 0;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> charSet = new HashSet();
        while (p2 < s.length()) {
            while (charSet.contains(s.charAt(p2))) { // Duplicate exists - reset
                charSet.remove(s.charAt(p1));
                p1++;
            }
            max = Integer.max(p2 - p1 + 1, max);
            charSet.add(s.charAt(p2));
            p2++;
        }
        return max;
    }
}
