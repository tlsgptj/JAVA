interface Day11 {
    int I = 0; //상수
    void m1(); //추상메소드
    static void m2() { //static 메소드

    }
    default void m3() { //default 메소드

    }//상수랑 메소드만 가능함
}
class CChild implements Day11 {
    public void m1() {}
}
class CUser1 {
    public static void main(String[] args) {

    }
}
