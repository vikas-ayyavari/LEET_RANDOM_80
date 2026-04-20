//2078. Two Furthest Houses With Different Colors
class Solution {
    public int maxDistance(int[] colors) {
        int i = colors.length-1;
        int m = colors.length;
        int x = 0;
        int k = 0;
        int l = 0;
        while(i>0){
            if(colors[i] != colors[0]) {
                k = i;
                break;
            }
            else i--;
        }
        while(x < m){
            if(colors[x] != colors[m-1]) {
                l = m-1-x;
                break;
            }
            else x++;
        }
        
        return Math.max(l,k);
    }
}
