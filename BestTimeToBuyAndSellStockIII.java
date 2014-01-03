public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] record = new int[prices.length][2];
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < 2; j++) {
                record[i][j] = 0;
            }
        }
        int min = prices[0];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            maxValue = Math.max(maxValue, prices[i] - min);
            record[i][0] = maxValue;
            min = Math.min(prices[i], min);
        }
        int max = prices[prices.length - 1];
        maxValue = Integer.MIN_VALUE;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxValue = Math.max(maxValue, max - prices[i]);
            record[i][1] = maxValue;
            max = Math.max(max, prices[i]);
        }
        max = 0;
        for (int i = 0; i < record.length; i++) {
            max = Math.max(max, record[i][0] + record[i][1]);
        }
        return max;
    }
}
