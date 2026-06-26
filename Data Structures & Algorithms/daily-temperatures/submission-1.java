class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> helperStack = new Stack<>();
        int len = temperatures.length;
        int[] temp = new int[len];

        for(int i = 0; i < len; i++) {
           while(!helperStack.isEmpty() && 
                    temperatures[i] > temperatures[helperStack.peek()]) {

                        int previous = helperStack.pop();

                        temp[previous] = i - previous;
            }
            helperStack.push(i);
        }

        return temp;
    }
}
