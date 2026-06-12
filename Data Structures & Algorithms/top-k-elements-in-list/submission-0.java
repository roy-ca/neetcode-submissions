class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];

        for(int key: map.keySet()) {
            int f = map.get(key);
            if(freq[f] == null) {
                freq[f] = new ArrayList<>();
            }
            freq[f].add(key);
        }

        int[] res = new int[k];
        int c=0;

        for(int j=freq.length-1; j>=0 && c<k; j--) {
            if(freq[j]!=null) {
               for (int num : freq[j]) {
                    res[c++] = num;
                    if (c == k) 
                        return res;
                }
            }
        }
        return res;
    }
}
