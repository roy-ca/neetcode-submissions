class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       // Stack<Integer> helperStack = new Stack<>();
        int len = temperatures.length;

        int[] temp = new int[len];

        for(int i = 0; i < len; i++) {
            int days = 0;
            for(int j = i + 1; j < len; j++) {
                if(temperatures[i] < temperatures[j]) {
                    temp[i] = j - i;
                    break;
                }
            }
        }

        return temp;
    }
}
