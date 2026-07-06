class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();

            Arrays.sort(chars);
            String key = new String(chars);

            if(map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(s);
                map.remove(key);

                map.put(key, list);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        
        List<List<String>> finalList = new ArrayList<>();
        for(String key: map.keySet()) {
            finalList.add(map.get(key));
        }
        return finalList;
    }
}
