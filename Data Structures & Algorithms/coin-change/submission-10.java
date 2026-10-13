class Solution {
    public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    return dfs(coins, new Integer[amount + 1], amount);
}

int dfs(int[] coins, Integer[] dp, int amount) {
    if (amount == 0) return 0;
    if (dp[amount] != null) return dp[amount];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
        if (coin > amount) break;          // sorted, so no later coin fits either
        int res = dfs(coins, dp, amount - coin);
        if (res != -1) min = Math.min(min, res + 1);
    }
    return dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
}
}
