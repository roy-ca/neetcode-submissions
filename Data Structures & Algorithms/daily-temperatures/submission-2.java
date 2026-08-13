class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> tp = new Stack<>();
        int[] res = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(!tp.isEmpty() && temperatures[i] >= temperatures[tp.peek()]) {
                tp.pop();
            }

            if(tp.isEmpty()) {
                res[i] = 0;
            }
            else {
                res[i] = tp.peek() - i;
            }
            tp.push(i);
        }
        return res;
    }
}
