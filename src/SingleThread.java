public class SingleThread extends Thread {

    private int threadNum;

    public SingleThread(int threadNum) {

        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.print("Thread " + threadNum + " : ");
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
