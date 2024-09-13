package _122BestTimeToBuyAndSellStockII;

public class Solution {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1]>prices[i]){
                maxProfit += prices[i+1] - prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,2};
        System.out.println(maxProfit(arr));
    }

}
