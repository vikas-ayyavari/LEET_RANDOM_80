//20. Valid Parentheses

class Solution {
    public boolean isValid(String s) {
        char[] res = new char[s.length()];
        int top = -1;
        for(char c : s.toCharArray()){
            if((c == '{') || ( c == '(') || (c == '[')){
                res[++top] = c;
            }else{
                if (top == -1) {
                    return false;
                }
                char compare = res[top];
                top--;
                if (( c == ')' && compare != '(') ||
                    ( c == '}' && compare != '{') ||
                    ( c == ']' && compare != '[')){
                        return false;
                    }  
            }
        }
        return top == -1;

    }
}
