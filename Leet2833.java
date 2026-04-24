//2833. Furthest Point From Origin

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int c = 0;
        int d = 0;
        for(char x: moves.toCharArray()){
            if(x == 'L') c--;
            else if(x == 'R') c++;
            else d++;
        }
        return Math.abs(c)+d;
    }
}
