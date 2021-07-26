package tech.jiangchen.multiThread.swapPrint;

/**
 * 两个不同的线程将会共用一个Kaola实例，其中一个线程将会调用kao()方法，另一个线程将会调用la()方法。
 * 请修改以下的类，确保 "kaola" 被输出 n 次。
 *
 * @author jiangchen
 * @date 2021/7/26
 */
public class Kaola {
    private int n;
    private boolean flag = false;

    private Kaola kaola;

    public Kaola(int n) {
        this.n = n;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void kao(Runnable printKao) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (kaola) {
                while (!kaola.flag) {
                    kaola.wait();
                }
            }
            printKao.run();
            kaola.setFlag(false);
            kaola.notifyAll();
        }
    }

    public void la(Runnable printLa) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (kaola) {
                while (kaola.flag) {
                    kaola.wait();
                }
            }
            printLa.run();
            kaola.setFlag(true);
            kaola.notifyAll();
        }
    }

}
