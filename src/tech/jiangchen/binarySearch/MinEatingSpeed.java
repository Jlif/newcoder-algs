package tech.jiangchen.binarySearch;

/**
 * @author jiangchen
 * @date 2021/06/25
 */
public class MinEatingSpeed {

    //暴力连续空间线性搜索，故而可以使用二分法优化
    public int minEatingSpeed(int[] piles, int H) {
        // piles 数组的最大值
        int max = getMax(piles);
        for (int speed = 1; speed < max; speed++) {
            // 以 speed 是否能在 H 小时内吃完香蕉
            if (canFinish(piles, speed, H)) {
                return speed;
            }
        }
        return max;
    }

    public int minEatingSpeed2(int[] piles, int H) {
        int left = 1;
        int right = getMax(piles);
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time = time + (n / speed) + ((n % speed > 0) ? 1 : 0);
        }
        return time <= H;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        return max;
    }

    public static void main(String[] args) {
        MinEatingSpeed demo = new MinEatingSpeed();
        System.out.println(demo.minEatingSpeed2(new int[]{3, 6, 7, 11}, 8));
    }

}
