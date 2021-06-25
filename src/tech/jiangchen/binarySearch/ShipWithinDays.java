package tech.jiangchen.binarySearch;

/**
 * @author jiangchen
 * @date 2021/06/25
 */
public class ShipWithinDays {

    int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = getSum(weights);
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFinish(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int cap, int D) {
        int n = 0;
        for (int i = 0; i < D; i++) {
            int maxCap = cap;
            while ((maxCap = maxCap - weights[n]) >= 0) {
                n++;
                if (n == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int n : weights) {
            sum = sum + n;
        }
        return sum;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int n : weights) {
            max = Math.max(n, max);
        }
        return max;
    }

    public static void main(String[] args) {
        ShipWithinDays demo = new ShipWithinDays();
        System.out.println(demo.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }
}
