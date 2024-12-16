class Ith extends Thread {
    public void run() {
        //JVM이 호출하도록 해야함
        ossYN.m();
    }
}
public class ossYN {
    static int i;
    ossYN() {
        Thread th1 = new Hth1();
        Thread th2 = new HTh2();
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException ie) {}
        System.out.print("i : " + i);
    }
    static void m() {
        for(int j = 0; j < 10; j++) {
            i++; //20이 나옴
        }
    }
    public static void main(String[] args) {
        new ossYN();
    }
}

