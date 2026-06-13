class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            //Character found in set, there is duplicate character
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            //Character not found in set
            set.add(ch);

            maxLength = Math.max(maxLength, (right - left) + 1);
        }
        return maxLength;
    }
}
