class Solution {
    public boolean isValid(String s) {
        Stack<Character> helperStack = new Stack<Character>();

        for(char ch: s.toCharArray()) {
            if(ch == '(')
                helperStack.push(')');
            else if(ch == '{')
                helperStack.push('}');
            else if(ch == '[')
                helperStack.push(']');
            else if(helperStack.isEmpty() || helperStack.pop() != ch)
                return false;
        }
        return helperStack.isEmpty();
    }
}

