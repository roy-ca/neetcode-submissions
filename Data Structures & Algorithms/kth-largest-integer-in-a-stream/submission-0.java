class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);

        for(int n: nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k) {
            minHeap.offer(val);
        } else if(val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
