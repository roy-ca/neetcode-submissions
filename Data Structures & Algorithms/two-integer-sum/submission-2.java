class Solution {
    public int[] twoSum(int[] nums, int target) {
     Map<Integer, Integer> numIndex = new HashMap<>();

     for(int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if(numIndex.containsKey(complement)) {
        return new int[] {numIndex.get(complement), i};
      }

      numIndex.put(nums[i], i);
     }
     return new int[] {};
    }
}
