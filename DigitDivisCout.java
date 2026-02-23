// 2520. Count the Digits That Divide a Number

class Solution {
    public int countDigits(int num) {
        int res =0;
        int test = num;
        while( test != 0){
            int temp = test%10;
            if(num%temp == 0) res++;
            test /= 10;
        }
        return res;
    }
}
