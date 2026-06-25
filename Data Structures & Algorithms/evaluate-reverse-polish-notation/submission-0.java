class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            String str = tokens[i];

            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.parseInt(str));
            }
            else {
                if(!stack.isEmpty() && stack.size() >=2) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();

                    if(str.equals("+")) {
                        stack.push(num1+num2);
                    }
                    else if(str.equals("-")) {
                        stack.push(num2 - num1);
                    }
                    else if(str.equals("*")) {
                        stack.push(num1*num2);
                    }
                    else {
                        stack.push(num2/num1);
                    }
                }
                else {
                    return -1;
                } 
            }
        }
        return stack.peek();
    }
}
