package tech.jiangchen.array;

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

    public int[] mergeTwoLists(int[] a, int[] b) {
        int al = a.length;
        int bl = b.length;
        int[] result = new int[al + bl];
        int count = Math.min(al, bl);
        int ai = 0;
        int bi = 0;
        int i = 0;
        while (ai >= count && bi >= count) {
            if (a[ai] <= b[bi]) {
                result[i++] = a[ai++];
            } else {
                result[i++] = b[bi++];
            }
        }

        return result;
    }
}
