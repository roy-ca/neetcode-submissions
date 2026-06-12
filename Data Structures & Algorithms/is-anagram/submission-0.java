class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int j=0; j<t.length(); j++) {
            char ch = t.charAt(j);
            if(map.containsKey(ch)) {
                if(map.get(ch) !=0) {
                    map.put(ch, map.get(ch) -1);
                }
                else if(map.get(ch) == 0) {
                        map.remove(ch);
                        return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}
