class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxLength = 0;
       Set<Character> subString = new HashSet<>();

       int left = 0;

       for(int right = 0; right < s.length(); right++) {

        char ch = s.charAt(right);

        while(subString.contains(ch)) {
            char leftChar = s.charAt(left);
            subString.remove(leftChar);
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);

        subString.add(ch);
       }
       return maxLength;
    }
}
