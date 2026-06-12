class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length < 1) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String str = String.valueOf(chars);

            if (map.containsKey(str)) {
                map.get(str).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(str, list);
            }
        }

        List<List<String>> out = new ArrayList<>();
        for(String s: map.keySet()) {
            out.add(map.get(s));
        }
        return out;
    }
}
