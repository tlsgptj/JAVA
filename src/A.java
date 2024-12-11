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
    boolean flag;
    ExceptionUser() throws MyException{
        if(flag) {
            throw new MyException();
        }
    }
    void use() throws YourException{
        if(!flag) {
            throw new YourException();
        }
    } //예외가 발생할 수 있는 가능성을 적어줘야함
}

class A {
    public static void main(String[] args) {

    }
}