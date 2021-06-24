package tech.jiangchen.dp;

/**
 * @author jiangchen
 * @date 2021/06/24
 */
public class Rob1 {

    /**
     *  明确了状态转移方程，就能写出这个算法，但这个算法其实存在重叠子问题，于是可以使用备忘录优化
     */

    // 主函数
    public int rob(int[] nums) {
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        return res;
    }

    public static void main(String[] args) {
        Rob1 rob = new Rob1();
        System.out.println(rob.rob(new int[]{7, 5, 2, 9, 1, 4, 2}));
    }
}
