package tech.jiangchen.array;

import java.util.Arrays;

/**
 * @author jiangchen
 * @date 2021/02/02
 */
public class MergeTwoSortedArray {

    /**
     * 合并两个有序数组
     *
     * @param a
     * @param b
     * @return
     */

    public void mergeTwoLists(int[] a, int al, int[] b, int bl) {
        int[] result = new int[al + bl];
        int ai = 0;
        int bi = 0;
        int i = 0;
        while (ai < al && bi < bl) {
            if (a[ai] <= b[bi]) {
                result[i++] = a[ai++];
            } else {
                result[i++] = b[bi++];
            }
        }
        if (ai == al) {
            for (int k = bi; k < bl; k++) {
                result[i++] = b[k];
            }
        } else {
            for (int k = ai; k < al; k++) {
                result[i++] = a[k];
            }
        }

        a = result;
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6};
        MergeTwoSortedArray demo = new MergeTwoSortedArray();
        demo.mergeTwoLists(a, a.length, b, b.length);
    }
}
