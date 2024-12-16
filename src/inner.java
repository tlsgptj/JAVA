//내부클래스 (inner class)

class A7 {
    class AInner {
        int i;
        void m() {
            System.out.println("AInner m()");
        }
    }
    static class AInner2 {
        int j;
        void m() {
            System.out.print("Ainner m()");
        }
    }
}
class B7 {
    interface BInner {
        //상수가 오겠지?
        int i = 10;
        void m();
    }
    static interface BInnerInter2 {
        int J = 20;
        void m2();
    }
}
class BUser123 implements B7.BInner {
    public void m(){};
    public static void main(String[] args) {
        System.out.println("BInnerInterChild m()");
    }
}
interface C8 {
    interface CInnerInter1 {
        int I = 10;
        void m1();
    }
    static interface CInnerInter2 {
        int J = 20;
        void m2();
    }
}
class D8 {
    int i;
    D8() {
        System.out.println("D()");
    }
    void m() {
        System.out.println("m()");
    }
    class DInter {
        void use() {
            System.out.println("i : " + i);
            m(); //이것도 호출이 가능함
        }
    }
}
public class inner {
    public static void main(String[] args) {
        new A7().new AInner();
        A7.AInner in1 = new A7(). new AInner();
        D8.DInter in = new D8().new DInter();
        System.out.println("in1.i" + in1.i);
        in1.m();

        A7.AInner2 in2 = new A7.AInner2(); //이너클래스 접근법은 좀 다름
        System.out.println("in1.i" + in2.j);
        in1.m();
        in.use();
    }
}





