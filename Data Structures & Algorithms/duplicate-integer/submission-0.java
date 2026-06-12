class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int n: nums) {
            if(map.containsKey(n)) {
                return true;
            }

            map.put(n,1);
        }
        return false;
    }
}