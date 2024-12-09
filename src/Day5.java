import java.util.ArrayList;

public class Day5 {

    ArrayList list = new ArrayList(); //사이즈가 없어도 저장소 생성 가능 : 가변 배열
    void in() {
        list.add(10); //가변배열
        list.add(20);
    }
    void out() {
        Object obj1 = list.get(0);
        Integer iobj1 = (Integer)obj1;
        Object obj2 = list.get(1);
        Integer iobj2 = (Integer)obj2; //객체 형태라 강제 형변환이 필요함(Object -> Integer)
        int i = iobj1.intValue();
        int j = iobj2.intValue(); //언박싱(참조형 -> 기본형)
        System.out.println("obj1 : " + i + " obj2 : " + j);
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.in();
        day5.out();
    }

}