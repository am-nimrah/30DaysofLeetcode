public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); 
            } else {
                if (stack.isEmpty() || !isMatchingPair(c, stack.pop())) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isMatchingPair(char closing, char opening) {
        return (closing == ')' && opening == '(') ||
               (closing == '}' && opening == '{') ||
               (closing == ']' && opening == '[');
    }
}
