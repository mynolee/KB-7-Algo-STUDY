import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char left = s.charAt(i);
            if (left == '(' || left == '{' || left == '[') {
                st.push(left);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char right = st.pop();
                if (left == ')' && right != '(') {
                    return false;
                }
                if (left == '}' && right != '{') {
                    return false;
                }
                if (left == ']' && right != '[') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
