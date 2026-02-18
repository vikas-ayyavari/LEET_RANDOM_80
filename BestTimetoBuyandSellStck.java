// 121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        int price_min = Integer.MAX_VALUE;
       
        for(int price: prices){
            if(price < price_min){
                price_min = price;
            }
            else{
                maxi = Math.max(maxi, price - price_min);
            }
        }
        return maxi;
        
    }
}
