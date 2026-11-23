class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> iMap = new HashMap();
        int idx = 0;
        for (String s : strs) {
            String[] chars = s.split("");
            Arrays.sort(chars);
            iMap.computeIfAbsent(String.join("", chars), k -> new ArrayList()).add(idx);
            idx++;
        }
        List<List<String>> res = new ArrayList();
        for (List<Integer> iList : iMap.values()) {
            res.add(iList.stream().map(i -> strs[i]).collect(Collectors.toList()));
        }
        return res;
    }
}
