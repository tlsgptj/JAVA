import java.util.*;

public class Day5 {

    Vector<String> v = new Vector<String>(); //Generic
    TreeSet ts = new TreeSet();
    Hashtable ht = new Hashtable();
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
        ht.put(10, "봄"); //하나의 값으로
        ht.put(20, "여름");
        ht.put(30, "가을"); //object타입으로 들어감
        ht.put(40, "겨울");
        System.out.println(ht.size()); //4
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
        Iterator iter = ts.iterator(); // ts객체를 같이 참조하는거임, Like Stack
        while(iter.hasNext()){
            Object obj = iter.next();
            String str = (String)obj; // object -> String
            System.out.println(str);
        }
        Enumeration e = ht.keys();
        while(e.hasMoreElements()) {
           Object key = e.nextElement();
           Integer keyObj = (Integer) key;
           int y = keyObj.intValue();
           Object value = ht.get(key);
           String v = (String)value;
           System.out.println("k: " + y + "v : " + v);
        }
        System.out.println("obj1 : " + i + " obj2 : " + j);
    }
    void out2() { //이터레이터 이용방법 value값 꺼냄
        System.out.println("(1) Iterator이용법");
        Collection col = ht.values();
        Iterator iter = col.iterator();
        while (iter.hasNext()) {
            Object obj = iter.next();
            String value = (String) obj;
            System.out.println("value: " + value);
        }
    }

    void out3() { //array 이용방법
        Collection col = ht.values();
        Object[] values = col.toArray();
        for (int i = 0; i<values.length; i++) {
            Object obj = values[i];
            String value = (String)obj;
            System.out.println("value: " + value);
        }
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.in();
        day5.out();
        day5.out2();
        day5.out3();
    }

}