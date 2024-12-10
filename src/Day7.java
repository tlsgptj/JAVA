//import java.lang.*; -> 보이지 않지만 존재 묵시적 임포트

import java.net.HttpURLConnection;

class Day7{ //object로부터 묵시적 상속
    String name = "홍길동";
    Day7(String name) {
        super(); //묵시적 상속 new object()
        this.name = name;
    } //다른생성자가 있음
    void walk() {
        System.out.println("걷는다 " + name);
    }
    void move() { //오버라이딩
        System.out.print("히히 ");
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
    void move() {
        super.move();//오버라이딩 부모꺼 호출
        System.out.print("걸어");
    }
}
class PepsiMan extends Day7 {
    int speed = 200;
    PepsiMan() {
        super("팹시맨");
    } //부모한테 생성자가 없는 상태로 갔음
    void move() {
        System.out.print("오네가이시마스");
    }
    void shake() {
        System.out.print("손을 흔든다.");
    }
}
class God {
    public static void main(String[] args) {
        //생성자가 존재 (누군가로부터 상속을 받아서)
        SuperMan superMan = new SuperMan();
        //SuperMan sman4 = new PepsiMan(); -> 형제끼리 불가능 //남남이다.
        /*SuperMan sman3 = (SuperMan)new Human("이순신"); -> 컴파일은 되지만 실행은 되지 않음 //코끼리한테 개미옷을 입힌다. 데이터가 깨져버림(실행시)*/
        /*SuperMan unit2 = (SuperMan) day7;*/ //강제형변환 다운캐스팅
        /*Day7 day7 = superMan;*/ //자동형변환 업캐스팅 부모는 아무런 힘이 없음 자식의 void로 찍힘
        superMan.walk();
        superMan.fly();
        superMan.move();
        //day7.move(); //자식의 함수가 나옴
    }
}

//생성자 : 기본 1개
//속성 : 0개 -> 특정됨
//메소드 : 11개의 메소드가 존재 (이건 JAVA의 문서에 있음)
