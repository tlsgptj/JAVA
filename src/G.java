class Hth1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("i : " + i);
            this.yield();
        }
    }
}

class HTh2 extends Thread {
    @Override
    public void run() {
        for(int j = 0; j < 100000; j++) {
            System.out.println("j: " + j);
            this.yield();
        }
    }
}

class G {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Hth1();
        int p1 = th1.getPriority();
        Thread th2 = new HTh2();
        th1.join();
        int p2 = th2.getPriority();
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
        th1.start();
        th2.start();
        System.out.println("end");
    }
}
//우선 순위를 주면 th1이 먼저 출력됨
//yield를 쓰면 지그재그로 찍힘 서로 양보하는거임

