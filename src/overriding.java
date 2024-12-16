public class overriding {
    int m() {
        System.out.println("A의 m()");
        return 0;
    }
}

class overridingchild extends overriding{
    int m(int i) {
        System.out.println("Achild m()");
        return -1;
    }
}

class B3 {
    String name;

    //생성자 오버로딩
    B3(){}
    B3(String name){
        this.name = name;
    }

    //메소드 오버로딩
    void m(){
    }
    int m(int i){
        System.out.println("i: " + i);
        return i;
    }
    String m(String str, int i){
        return str;
    }
    void m(int i, String str){
    }
}
class BChild extends B {
    void m(byte b){ //오버로딩
        System.out.println("b: " + b);
    }
}
class BUser{
    public static void main(String args[]){
        BChild c = new BChild();
        byte b = 10;
        c.m(b);
    }
}

/*
< (메소드) 오버라이딩 조건 >
(상속관계에서) 부모메소드의 내용을 자식에서 바꾸는 것
1) 메소드 이름이 같아야 함
2) 리턴타입이 일치해야 함 new Achild(); a.m();
3) 파라미터의 타입과 순서와 갯수가 모두 일치해야 함
4) 생성자는 안됨
5) 자식메소드 접근제한자가 부모메소드 접근제한자보다 같거나 넓어야한다.

ex) day11/A.java

< 오버로딩(overloading) >
1) 정의
   (그 형태에 매핑되어 호출되도록) 메서드의 이름은 같고 매개변수의 유형과 개수가 다르도록 하는 것
2) 종류
    1) 생성자
    2) 메소드
3) 특징
    1) 메소드(생성자 포함) 이름이 같아야 함
    2) 리턴타입과 관련이 없다.
    3) 상속관계의 자식클래스에서도 오버로딩이 가능
    4) 형변환이 가능한 파라미터라도 오버로딩으로 인정

    요약
    - 오버로딩 : 기존에 없던 새로운 메소드 정의
       -> 메소드 오버로딩을 하면 가독성이 좋아짐
    - 오버라이딩 : 상속 받은 메서드의 내용만 변경
 */

