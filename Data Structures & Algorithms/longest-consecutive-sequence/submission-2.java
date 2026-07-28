class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int maxLength = 0;

        for(int num: nums) {
            set.add(num);
        }

        for(int num: set) {
            if(!set.contains(num - 1)) {
                int startNum = num;
                int seqCount = 1;

                while(set.contains(num + 1)) {
                    num = num + 1;
                    seqCount++;
                }

                maxLength = Math.max(maxLength, seqCount);
            } 
        }
        return maxLength;
    }
}
