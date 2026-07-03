class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();

       int maxLength = 0;
       int left = 0;

       for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while(set.contains(ch)) {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            //set does not contain
            set.add(ch);
       }
       return maxLength;
    }
}
