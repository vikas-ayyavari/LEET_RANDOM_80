// 66. Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length-1;
         while(true){
            if(l == 0 && digits[l] == 9){
                int[] res = new int[digits.length+1];
                res[0] = 1;
                digits[l] = 0;
                for(int i = 0;i < digits.length;i++){
                    res[i+1]=digits[i];
                }
                return res;
            }
            if(digits[l] == 9){
                digits[l] = 0;
                l--;
                continue;
            }
            else{
                digits[l]++;
                return digits;
            }
         }
         
    }
}
