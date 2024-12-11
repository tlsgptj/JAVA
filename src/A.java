class MyException extends Exception {
    void myM1() {
        System.out.print("MyException의 예외처리");
    }
}

class YourException extends Exception{
    void yourM() {
        System.out.print("YourException의 예외처리");
    }
}
class ExceptionUser {
    boolean flag = false;
    ExceptionUser() throws MyException{
        if(flag) {
            throw new MyException();
        }
    }
    void use() throws YourException{
        if(!flag) {
            throw new YourException();
        }
    }
    //예외가 발생할 수 있는 가능성을 적어줘야함
    void use2() throws Exception {
        boolean flag2 = true;
        if(flag2) {
            throw new Exception();
        }
    }
}

class A {
    A() throws MyException, YourException, Exception { //순서의 관계가 없다.
        try {
            System.out.print("1");
            ExceptionUser exceptionUser = new ExceptionUser();
            //중간에 예외가 있으면 예외문으로 건너뜀
            System.out.print("2");
            exceptionUser.use();
            System.out.print("3");
            exceptionUser.use2(); //예외 발생
        } catch (Exception e) {
            System.out.println("5");
            return; //메인절로 돌아감 -> finally가 더 쎔, 그러고 return 호출 메인 시행
            //System.exit(-1); // 1,3번까지만 찍힘
        } finally {
            System.out.println("6"); //무조건 수행하는 거라고 생각하면 됨
        }
        System.out.println("8"); //그러고 이친구는 return 때문에 호출이 안됨
        //
        // 넒은 범위의 익셉션은 좁은 범위의 익셉션을 잡을 수 있다.
        // 세련된 예외처리 자식을 먼저 잡아주고, 부모를 처리함
        // 고유한 속성과 메소드가 있으면 세련된 처리가 가능함 (그래서 자식을 만들어주는 것!)
        // 작은 예외부터 차근차근 해결하는 과정이 중요함
        //1만 출력
    }
    public static void main(String[] args) throws MyException, YourException {
        ExceptionUser exceptionUser = new ExceptionUser();
        exceptionUser.use(); //떠넘기기
        try {
            new B();
        } catch(Exception e) {
            System.out.println("10");
        }
        // throws를 필수로 써줘야 한다.
    }
}