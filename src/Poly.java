public class Poly {
    void draw() {
        System.out.println("도형을 그리다");
    }
}

class Circle extends Poly {
    void draw() { //오버라이딩
        System.out.println("원형을 그리다");
    }
}

class Rec extends Poly {
    void draw() {
        System.out.println("사각형을 그리다");
    }
}

class Triangle extends Poly {
    void draw() {
        System.out.println("삼각형을 그리다");
    }
}

class Account { //해커일 경우
    private long balance = 1000L;
    private String ssn = "123456-12341234";
    String getSsn() {
        return ssn;
    }
    long getBalance() {
        return balance;
    }
    void setBalance(long balance) {
        this.balance = balance;
    }
    void setSsn(String ssn) {
        this.ssn = ssn;
    } //메소드를 통해서 값에 접근하도록 설정함
}

class D {
    int sum(int i, int j) {
        return i+j;
    }
}

class B {
    public static void main(String[] args) {
        Poly f1 = new Triangle();
        Poly f2 = new Circle();
        Poly f3 = new Rec();
        Poly f4 = new Poly();
        f1.draw();
        f2.draw();
        f3.draw();
        f4.draw();
        Account acc = new Account();
        acc.getBalance();
        acc.setBalance(10000000L);
        D d = new D();
        int s = d.sum(10, 20);
        System.out.print("s : " + s);
        //acc.ssn = "12341234";
        //acc.balance = 20000L; //마음대로 변경할 수 없도록 은닉해야함 -> 이것이 private
        //이것이 다형성
    }
}

