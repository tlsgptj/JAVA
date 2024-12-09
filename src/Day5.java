import java.util.*;

public class Day5 {

    Vector v = new Vector();
    TreeSet ts = new TreeSet();
    ArrayList list = new ArrayList(); //사이즈가 없어도 저장소 생성 가능 : 가변 배열
    void in() {
        list.add(10); //가변배열
        list.add(20);
        v.add("봄");
        v.add("여름");
        v.add("가을");
        v.add("겨울");
        ts.add("하나");
        ts.add("둘");
        ts.add("셋");
        ts.add("넷");
        System.out.println(v.size());
        System.out.println(ts.size());
    }
    void out() {
        Object obj1 = list.get(0);
        Integer iobj1 = (Integer)obj1;
        Object obj2 = list.get(1);
        Integer iobj2 = (Integer)obj2; //객체 형태라 강제 형변환이 필요함(Object -> Integer)
        int i = iobj1.intValue();
        int j = iobj2.intValue(); //언박싱(참조형 -> 기본형)
        for (int k = 0; i<v.size(); i++) {
            Object obj = v.get(i);
            String str = (String)obj;
            System.out.println(str);
        }
        Iterator iter = ts.iterator(); // ts객체를 같이 참조하는거임
        while(iter.hasNext()){
            Object obj = iter.next();
            String str = (String)obj; // object -> String
            System.out.println(str);
        }
        System.out.println("obj1 : " + i + " obj2 : " + j);
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.in();
        day5.out();
    }

}