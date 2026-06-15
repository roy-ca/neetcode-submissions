class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }

        String shrString = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        //X-1 Y-1 Z-1

        int left = 0;
        int start = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();
        int minimumLength = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            windowFreq.put(ch, windowFreq.getOrDefault(ch, 0) + 1);

            while(matches(windowFreq, tMap)) {

                if(right - left + 1 < minimumLength) {
                    minimumLength = right - left + 1;
                    start = left;
                }

                char ch1 = s.charAt(left);
                windowFreq.put(ch1, windowFreq.get(ch1) -1);
                if (windowFreq.get(ch1) == 0) {
                    windowFreq.remove(ch1);
                }
                left++;
            }
        }
        return minimumLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minimumLength);
    }

    public boolean matches(Map<Character, Integer> a, Map<Character, Integer> b) {
        for(char ch: b.keySet()) {
            if(!a.containsKey(ch) || a.get(ch) < b.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
