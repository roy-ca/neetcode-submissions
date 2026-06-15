class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int result = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) +1);
            if(map.get(ch) > maxFreq) {
                maxFreq = map.get(ch);
            }

            while((right - left +1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if(map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    left++;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
