class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();

       for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }

                //Check if correct bracket is present
                char k = stack.pop();
                if(ch == ')') {
                    if(k != '(') {
                        return false;
                    }
                }
                else if(ch == ']') {
                    if(k != '[') {
                        return false;
                    }
                }
                else {
                    if(k != '{') {
                        return false;
                    }
                }
            }
       }
       return stack.isEmpty();
    }
}

