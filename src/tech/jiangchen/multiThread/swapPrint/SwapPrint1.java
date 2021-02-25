package tech.jiangchen.multiThread.swapPrint;

import java.util.concurrent.locks.LockSupport;

public class SwapPrint1 {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] abcArr = "ABCDEF".toCharArray();
        char[] numArr = "123456".toCharArray();

        t1 = new Thread(() -> {
            for (int i = 0; i < numArr.length; i++) {
                LockSupport.park();
                System.out.print(numArr[i] + "\n");
                LockSupport.unpark(t2);
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (int i = 0; i < abcArr.length; i++) {
                LockSupport.unpark(t1);
                System.out.print(abcArr[i] + "\n");
                LockSupport.park();
            }
        });

        t2.start();
        t1.start();
    }
}
