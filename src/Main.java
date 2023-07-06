public class Main {
    public static void main(String[] args) {
        SingleThread t1 = new SingleThread(1);
        SingleThread t2 = new SingleThread(2);
        SingleThread t3 = new SingleThread(3);

        t1.start();
        t2.start();
        t3.start();


    }
}