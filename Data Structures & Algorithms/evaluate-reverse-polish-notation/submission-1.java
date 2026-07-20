class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> helperStack = new Stack<>();

       for(String token: tokens) {
            if(!(token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/"))) {
                helperStack.push(Integer.parseInt(token));
            }
            else {
                if(!helperStack.isEmpty()) {
                    int result = 0;
                    int second = helperStack.pop();
                    int first = helperStack.pop();

                    if(token.equals("+"))
                        result = first + second;
                    else  if(token.equals("-"))
                        result = first - second;
                    else  if(token.equals("*"))
                        result = first * second;
                    else
                        result = first / second;

                        helperStack.push(result);
                }
            }
       }
       return helperStack.pop();
    }
}
