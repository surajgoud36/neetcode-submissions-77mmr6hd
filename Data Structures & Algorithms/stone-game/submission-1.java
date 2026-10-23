public class Solution {
    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int total = 0;
        for (int pile : piles) {
            total += pile;
        }

        int aliceScore = dfs(0, n - 1, piles);
        return aliceScore > 0;
    }

    private int dfs(int l, int r, int[] piles) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        boolean even = (r - l+1) % 2 == 0;
        // int left = even ? piles[l] : 0;
        // int right = even ? piles[r] : 0;
        // dp[l][r] = Math.max(dfs(l + 1, r, piles) + left, dfs(l, r - 1, piles) + right);
        int left = piles[l],right = piles[r];
        if(even)
            dp[l][r] = Math.max(dfs(l + 1, r, piles) + left, dfs(l, r - 1, piles) + right);
        else
            dp[l][r] = Math.min(dfs(l + 1, r, piles) - left, dfs(l, r - 1, piles) - right);
        return dp[l][r];
    }
}