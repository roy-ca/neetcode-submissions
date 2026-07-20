class Solution {
    public boolean isValid(String s) {
       Stack<Character> charStack = new Stack<>();
       for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if(ch == '(') {
            charStack.push(')');
        }
        else  if(ch == '{') {
            charStack.push('}');
        }
        else if(ch == '['){
            charStack.push(']');
        }

        if(ch == ')' || ch == '}' || ch == ']') {
           if(charStack.isEmpty()) {
            return false;
           }

           if(ch != charStack.pop()) {
            return false;
           }
        }
       }
       return charStack.isEmpty();
    }
}

