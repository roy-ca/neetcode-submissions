class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n: nums) {
            set.add(n);
        }

        int maxLength = 0;

        for(int n: nums) {
            int currentNum = n;
            int currentStreak = 1;

            if(!set.contains(n-1)) {
                while(set.contains(currentNum+1)) {
                    currentNum++;
                    currentStreak++;
                }
            }

            maxLength = Math.max(maxLength, currentStreak);
        }
        return maxLength;
    }
}
