package tech.jiangchen.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jiangchen
 * @date 2021/02/23
 */
public class GetLeastNumbers {

    //方法一：直接使用Java内置的优先队列
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return result;
        }
        //默认小顶堆，需要重写比较器，大顶堆
        Queue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i : input) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        GetLeastNumbers demo = new GetLeastNumbers();
        System.out.println(demo.getLeastNumbers(new int[]{3, 7, 1, 4, 9, 2}, 3));
    }

}
