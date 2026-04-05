//   657. Robot Return to Origin
class Solution {
    public boolean judgeCircle(String moves) {
       int s1 =0;
       int s2 =0;
       for(char c : moves.toCharArray()){
        if(c == 'L') s1++;
        else if(c == 'R') s1--;
        else if(c == 'U') s2++;
        else s2--;
       } 
       return s1 == 0 && s2 == 0;
    }
}
