package tech.jiangchen.dp;

import java.util.Arrays;

/**
 * @author jiangchen
 * @date 2021/06/24
 */
public class Rob2 {

    private int[] memo;

    // 主函数
    public int rob(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) {
            return memo[start];
        }

        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }

    public static void main(String[] args) {
        Rob2 rob = new Rob2();
        System.out.println(rob.rob(new int[]{7, 5, 2, 9, 1, 4, 2}));
        System.out.println(Arrays.toString(rob.memo));
    }
}
