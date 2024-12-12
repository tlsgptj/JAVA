public class Day9 {
    public int publicField;
    protected int protectedField;
    int defaultField;
    private int privateField;
    public void publicMethod() {
        System.out.println("m()");
    }
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }
    public static void main(String[] args) {
        Day9 day9 = new Day9();
        day9.defaultField = Integer.parseInt("");
        int privateField1 = day9.privateField;
        int protectedField1 = day9.protectedField;
        int publicField1 = day9.publicField;
    }
}

class C {
    static int i;
    int j;
    //static C(){} //불가!
    static void m(){
        //static int j = 1; //불가!
        System.out.println("m()");
    }
    void m2(){
        System.out.println("m2()");
    }
    public static void main(String[] args)
    {
        System.out.println("i: " + i);
        m();

        C c = new C();
        System.out.println("j: " + c.j);
        c.m2();
    }
}

class CUser {
    public static void main(String[] args)
    {
        System.out.println("C.i: " + C.i);
        C.m();
    }
}

class D1 {
    static int i;
    int j;
    void m() {
        i++;
        j++;
    }

    public static void main(String[] args) {
        D1 d = new D1();
        d.m();

        System.out.println("i: " + i);
        System.out.println("j: " + d.j); //객체의 이름으로 접근해야함
    }
}

class E {
    public final static int YES = 10;
    final void m() {
        final int NO = 20;
    }
}
class Echild extends E {
    E e = new E();
}

abstract class F {
    int j; //가능
    //abstract F(){}
    abstract void m(); //추상메소드
    void m2() { //일반메소드
        System.out.println("m2()");
    }
}
class Fchild extends F {
    void m() {
        System.out.println("m() 구현");
    }
}
class FUser {
    public static void main(String[] args) {
        F f = new Fchild();
        System.out.println(f.j);
        f.m();
        f.m2();
        //new F();
        //추상클래스 F의 객체를 만들어서 사용하려고, 자원을 사용해보자~
    }
}

class K {
    String name;
    K(String name) {
        this.name = name;
    }
}
class KChild extends K {
    String name = "이순신";
    KChild() {
        super("홍길동");
    }
    void showName() {
        System.out.println("name : " + this.name);
    }
    void m() { //오버라이딩
        System.out.println(super.name);
    }
}
class Kuser {
    public static void main(String[] args) {
        KChild kc = new KChild();
        kc.showName();
    }
}
