//내부클래스 (inner class)

class A7 {
    class AInner {
        int i;
        void m() {
            System.out.println("AInner m()");
        }
    }
    public static class AInner2 {
        int j;
        void m() {
            System.out.print("Ainner m()");
        }
    }
}
public class inner {
    public static void main(String[] args) {
        new A7().new AInner();
        A7.AInner in1 = new A7(). new AInner();
        System.out.println("in1.i" + in1.i);
        in1.m();

        A7.AInner2 in2 = new A7.AInner2(); //이너클래스 접근법은 좀 다름
        System.out.println("in1.i" + in2.j);
        in1.m();
    }
}

