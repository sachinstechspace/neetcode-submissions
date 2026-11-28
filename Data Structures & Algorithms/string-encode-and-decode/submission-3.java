class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return null;
        }
        String st = String.join("😀", strs.stream().map(s -> s.equals("") ? "<es>" : s).collect(Collectors.toList()));
        System.out.println(st);
        return st;
    }

    public List<String> decode(String str) {
        if (str == null) {
            return new ArrayList();
        }
        return Arrays.asList(str.split("😀")).stream().map(s -> s.equals("<es>") ? "" : s).collect(Collectors.toList());
    }
}
