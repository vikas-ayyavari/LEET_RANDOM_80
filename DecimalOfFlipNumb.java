//1009. Complement of Base 10 Integer
class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int x =0,t = n;
        while(t > 0){
            x = (x << 1) | 1;
            t >>= 1;
        }
        return x ^ n;
    }
}
