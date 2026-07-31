class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int st: stones) {
            pq.add(st);
        }

        while(pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if(x != y) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
