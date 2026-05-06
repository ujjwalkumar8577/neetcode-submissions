class Solution {
    HashMap<String, Integer> map;
    public int maxProfit(int[] prices) {
        map = new HashMap<>();
        return maxProfitHelper(prices, 0, -1);
    }

    public int maxProfitHelper(int[] prices, int i, int cp) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "#" + cp;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        // not holding
        if (cp == -1) {
            int tmp = Math.max(
                maxProfitHelper(prices, i+1, prices[i]),
                maxProfitHelper(prices, i+1, -1)
            );
            map.put(key, tmp);
            return tmp;
        }
        // holding
        int tmp = Math.max(
            (prices[i] - cp) + maxProfitHelper(prices, i+2, -1),
            maxProfitHelper(prices, i+1, cp)
        );
        map.put(key, tmp);
        return tmp;
    }
}
