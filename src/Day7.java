class Day7{
    String name = "홍길동";
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
        super(); //부모의 생성자를 의미
    }
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
//속성 : 2개
//메소드 : 2개
