//import java.lang.*; -> 보이지 않지만 존재 묵시적 임포트

class Day7{ //object로부터 묵시적 상속
    String name = "홍길동";
    Day7(String name) {
        super(); //묵시적 상속 new object()
        this.name = name;
    } //다른생성자가 있음
    void walk() {
        System.out.println("걷는다 " + name);
    }
    //다른생성자가 없을때 JVM이 만들어줌
    //부모와 자식관계를 가지게 됨 -> 부모에 있는 생성자를 자식에게 줌
}

class SuperMan extends Day7 {
    //부모에 있는 것을 사용이 가능함
    int power = 100;
    SuperMan() {
        super("클락"); //부모의 생성자를 의미
    } //여기서 호출
    void fly() {
        System.out.println("난다 " + power);
    }
}
class God {
    public static void main(String[] args) {
        //생성자가 존재 (누군가로부터 상속을 받아서)
        SuperMan superMan = new SuperMan();
        superMan.walk();
        superMan.fly();
    }
}

//생성자 : 1개
//속성 : 0개 -> 특정됨
//메소드 : 11개의 메소드가 존재 (이건 JAVA의 문서에 있음)
