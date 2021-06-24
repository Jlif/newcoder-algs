package tech.jiangchen.dp;

/**
 * @author jiangchen
 * @date 2021/06/24
 */
public class Rob3 {
    /**
     * 前面的是自顶向下，根据那个可以写出自底向上
     */

    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    //上述方法的空间复杂度可以进一步简化，只需要两个变量即可
    public int rob2(int[] nums) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    public static void main(String[] args) {
        Rob3 rob = new Rob3();
        System.out.println(rob.rob(new int[]{7, 5, 2, 9, 1, 4, 2}));
    }
}
