class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap();
        for (char c : s.toCharArray()) {
            countMap.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            countMap.merge(c, -1, Integer::sum);
        }
        for (int i : countMap.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
