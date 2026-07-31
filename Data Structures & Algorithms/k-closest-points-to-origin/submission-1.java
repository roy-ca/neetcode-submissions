class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] kClosest = new int[k][2];
        PriorityQueue<int[]> queue  = new PriorityQueue<>(
            (x ,y) -> (y[0] * y[0] + y[1] * y[1]) - (x[0] * x[0] + x[1] * x[1]) 
        );

        for(int[] point: points) {
            queue.add(point);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        for(int i = 0; i < k; i++) {
            kClosest[i] = queue.poll();
        }
        return kClosest;
    }
}
