class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> subMap = new HashMap<>();
        Map<Character, Integer> mainMap = new HashMap<>();

        if(s1.length() > s2.length())
            return false;

        int n = s1.length();

        //Create map of usbstring
        for(int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            subMap.put(ch, subMap.getOrDefault(ch, 0) + 1);
        }

        int ptr = 0;
        for(ptr = 0; ptr < n; ptr++) {
            char ch = s2.charAt(ptr);
            mainMap.put(ch, mainMap.getOrDefault(ch, 0) + 1);
        }

        if(matches(mainMap, subMap))
            return true;

        while(ptr < s2.length()) {
            char ch = s2.charAt(ptr);
            mainMap.put(ch, mainMap.getOrDefault(ch, 0) + 1);

            char removedChar = s2.charAt(ptr - n);
            mainMap.put(removedChar, mainMap.get(removedChar) - 1);

            if(matches(mainMap, subMap))
                return true;

            ptr++;
        }

        return false;
    }

    private boolean matches(Map<Character, Integer> main, Map<Character, Integer> sub) {
        for(char ch : sub.keySet()) {
            if(main.containsKey(ch) && main.get(ch) == sub.get(ch))
                continue;
            return false;
        }
        return true;
    }
}
