interface Day11 {
    int I = 0; //상수
    public abstract void m1(); //추상메소드
    static void m2() { //static 메소드
        System.out.println("C m2()");
    }
    default void m3() { //default 메소드
        System.out.println("C m2()");
    }//상수랑 메소드만 가능함
}
class CChild implements Day11 {
    public void m1() {
        //접근제한자의 규칙에 의해서 public밖에 못옴
        System.out.println("C m3()");
    }
}
class CUser1 {
    public static void main(String[] args) {
        Day11 c = new CChild();
        System.out.println("C I : " + c.I);
        c.m1(); //추상메소드 호출
        Day11.m2(); //static 메소드 호출
        c.m3(); //default 메소드 호출
    }
}
