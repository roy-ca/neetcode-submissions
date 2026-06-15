class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }


        int windowSize = s1.length();
        Map<Character, Integer> windowFreq = new HashMap<>();

        for(int i = 0; i < windowSize; i++) {
            char ch = s2.charAt(i);
            windowFreq.put(ch, windowFreq.getOrDefault(ch,0) + 1);
        }

        if(matches(s1Map, windowFreq)) {
            return true;
        }

        for(int i = windowSize; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            windowFreq.put(ch, windowFreq.getOrDefault(ch, 0) + 1);
            windowFreq.put(s2.charAt(i - windowSize), windowFreq.get(s2.charAt(i - windowSize)) - 1);

            if(matches(s1Map, windowFreq)) {
                return true;
            }
        }

        return false;

    }

    private boolean matches(Map<Character,Integer> a, Map<Character,Integer> b) {
        for(char ch: a.keySet()) {
            if(a.get(ch) != b.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
