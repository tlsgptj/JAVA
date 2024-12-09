import java.util.*;

class A2 {
    Vector<String> v = new Vector<String>();

    void in() {
        v.add("봄");
        v.add("여름");
        v.add("가을");
        v.add("겨울");
        v.add("가을");
        System.out.println("v.size(): " + v.size());
    }

    void out() {
        for (int i = 0; i < v.size(); i++) {
            //Object obj = v.get(i);
            //String str = (String)obj;
            String str = v.get(i);
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        A2 a = new A2();
        a.in();
        a.out();
    }
}
class B2 {
    TreeSet<String> ts = new TreeSet<String>();

    void in() {
        ts.add("봄");
        ts.add("여름");
        ts.add("가을");
        ts.add("겨울");
        ts.add("가을");
        System.out.println("ts.size(): " + ts.size());
    }

    void out() {
        //Iterator iter<String> = ts.iterator(); //오름차순 정렬
        Iterator<String> iter = ts.descendingIterator(); //내림차순 정렬
        while (iter.hasNext()) {
            //Object obj = iter.next();
            //String str = (String)obj;
            String str = iter.next();
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        B2 b = new B2();
        b.in();
        b.out();
    }
}
class C2 {
    Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

    void in() {
        ht.put(10, "봄"); //put(int, String)
        ht.put(20, "여름");
        ht.put(30, "가을");
        ht.put(40, "겨울");
        //ht.put(30, "초가을"); //key를 중복시켜봄
        ht.put(50, "가을"); //value를 중복시켜봄
        System.out.println("ht.size(): " + ht.size());
    }

    void out() { //key와 value들을 함께 꺼냄
        Enumeration<Integer> e = ht.keys();
        while (e.hasMoreElements()) {
            //Object key = e.nextElement();
            //Integer keyObj = (Integer)key;
            Integer keyObj = e.nextElement();
            int k = keyObj.intValue();

            //Object value = ht.get(key);
            //String v = (String)value;
            String v = ht.get(keyObj);

            System.out.println("k:" + k + ", v:" + v);
        }
    }
    public static void main(String[] args) {
        C2 c = new C2();
        c.in();
        c.out();
    }
}



