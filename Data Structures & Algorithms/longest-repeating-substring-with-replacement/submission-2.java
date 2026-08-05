class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int maxLength = 0;

        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(ch));

            while((right - left + 1) - maxFrequency > k) {
                char leftCh = s.charAt(left);
                map.put(leftCh, map.get(leftCh) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
