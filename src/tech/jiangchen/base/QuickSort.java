package tech.jiangchen.base;

import java.util.Arrays;

/**
 * @author jiangchen
 * @date 2021/01/25
 */
public class QuickSort {

    /**
     * // 快速排序，A是数组，n表示数组的大小
     * quick_sort(A, n) {
     * quick_sort_c(A, 0, n-1)
     * }
     * <p>
     * // 快速排序递归函数，p,r为下标
     * quick_sort_c(A, p, r) {
     * if p >= r then return
     * <p>
     * q = partition(A, p, r) // 获取分区点
     * quick_sort_c(A, p, q-1)
     * quick_sort_c(A, q+1, r)
     * }
     */

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        // 获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        System.out.println(Arrays.toString(a));
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println(Arrays.toString(a) + "====");
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 2, 1, 9, 5, 6};
        quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
