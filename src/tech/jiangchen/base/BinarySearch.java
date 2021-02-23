package tech.jiangchen.base;

/**
 * @author jiangchen
 * @date 2021/01/25
 */
public class BinarySearch {

    /**
     * 给定一个n个元素有序的（升序）整型数组 nums 和一个目标值 target ，
     * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public int binarySearch1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (nums[pivot] < right) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    /**
     * 请实现有重复数字的升序数组的二分查找。
     * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     */
    public int binarySearch2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (mid > 0 && nums[mid - 1] >= target) {
                j = mid - 1;
            } else {
                return mid + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch1(new int[]{1, 2, 4, 4, 5}, 3));
        System.out.println(binarySearch.binarySearch2(new int[]{1, 2, 4, 4, 5}, 3));
    }
}
