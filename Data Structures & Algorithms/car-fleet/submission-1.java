class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int len = position.length;

        int[][] cars = new int[len][2];

        for(int i = 0; i < len;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        int fleets = 0;
        double lastFleetTime = 0.0;
        Arrays.sort(cars, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i = len - 1; i >= 0; i--) {
            double currentFleetTime = (double)(target - cars[i][0]) / cars[i][1];

            // if(currentFleetTime > lastFleetTime){
            //      fleets++;
            //      lastFleetTime = currentFleetTime;
            // }
            if(stack.isEmpty())
                stack.push(currentFleetTime);
            else {
                if(currentFleetTime > stack.peek()) {
                    stack.push(currentFleetTime);
                }
            }
            
        }
        return stack.size();
    }
}
