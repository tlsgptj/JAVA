
interface DInter1 {
    void m1();
}
interface DInter2 {
    void m2();
}
interface DInter extends DInter1, DInter2{
    void m3();
}

class D7 implements DInter {
    public void m1(){
        System.out.println("m1()");
    }
    public void m2(){
        System.out.println("m2()");
    }
    public void m3(){
        System.out.println("m3()");
    }
    public static void main(String[] args) {
        D7 d = new D7();
        DInter i = d;
        DInter1 i1 = i;
        DInter2 i2 = i;
        i1.m1();
        i2.m2();
        System.out.println();
        i.m3();
        i.m1();
        i.m2();
    }
}