//에노테이션
abstract class E7 {
    abstract void m1();
    abstract void m2();
}

class Echild1 extends E7 {
    void m1() {
        System.out.println("m1()");
    }
    @Override //가독성을 높여주는 것일뿐 빼도 넣어도 상관없음
    void m2(){
        System.out.println("m2");
    }
}

class EUser {
    public static void main(String[] args) {
        E7 e = new Echild1();
        e.m2();
        e.m1();
    }
}