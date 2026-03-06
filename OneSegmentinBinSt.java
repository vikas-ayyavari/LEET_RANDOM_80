//1784. Check if Binary String Has at Most One Segment of Ones
class Solution {
    public boolean checkOnesSegment(String s) {
        if (s.length()==1 || s.length()==2) return s.charAt(0) == '1' ? true : false;
        int x = 0;
        for(char c : s.toCharArray()){
             if(c == '1' && x == 0) continue;
             else if( c == '0' && x == 0) x++;
             else if(c == '0' && x == 1 ) continue;
             else return false; 
        }
        return true;
    }
}


// alternative

// return !s.contains('01');
