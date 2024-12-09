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
        for (String str : v) { //v에서 String을 꺼내쓴다.
            //Object obj = v.get(i);
            //String str = (String)obj;
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
            int k = keyObj; //언박싱 Unboxing (Integer -> int)

            //Object value = ht.get(key);
            //String v = (String)value;
            String v = ht.get(keyObj);
            Set<Integer> keys = ht.keySet();
            for (int key : keys) { //진화된 루프
                System.out.println("key: " + key);
            }

            System.out.println("k:" + k + ", v:" + v);
        }
    }
    public static void main(String[] args) {
        C2 c = new C2();
        c.in();
        c.out();
    }
}

//배열도 enhanced Loop
class arrayT {
    int is[] = {10, 20, 30};
    void out() {
        for (int i : is) {
            System.out.println("didiii");
        }
    }
    public static void main(String[] args) {
        new arrayT().out(); //배열도 향상된 루프를 사용할 수 있다.
    }
}

class C3 {
    Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
    void in(){
        ht.put(10, "봄"); //put(int, String)
        ht.put(20, "여름");
        ht.put(30, "가을");
        ht.put(40, "겨울");
        //ht.put(30, "초가을"); //key를 중복시켜봄
        ht.put(50, "가을"); //value를 중복시켜봄
        System.out.println("ht.size(): " + ht.size());
    }
    void out(){ //key와 value들을 함께 꺼냄
        Enumeration<Integer> e = ht.keys();
        while(e.hasMoreElements()){
            //Object key = e.nextElement();
            //Integer keyObj = (Integer)key;
            Integer keyObj = e.nextElement();
            //int k = keyObj.intValue();
            int k = keyObj; //UnBoxing ( Integer -> int )

            //Object value = ht.get(key);
            //String v = (String)value;
            String v = ht.get(keyObj);

            System.out.println("k:" + k + ", v:" + v);
        }
    }
    public static void main(String[] args) {
        C3 c = new C3();
        c.in();
        c.out();
    }
}

class Boxing
{
    //WraperClass: Byte, Short, Character, Integer, Long, Float, Double, Boolean

    byte b = 1;
    short s = 2;
    char c = 'A';
    int i = 3;
    long lo = 4;
    float f = 5.0f;
    double d = 6.0;
    boolean flag = true;

    Byte bOjb;
    Short sObj;
    Character cObj;
    Integer iObj;
    Long loObj;
    Float fObj;
    Double dObj;
    Boolean flagObj;

    void box(){ //박싱
        bOjb = b;
        sObj = s;
        cObj = c;
        iObj = i;
        loObj = lo;
        fObj = f;
        dObj = d;
        flagObj = flag;
    }
    void unbox(){ //언박싱
        b = bOjb;
        s = sObj;
        c = cObj;
        i = iObj;
        lo = loObj;
        f = fObj;
        d = dObj;
        flag = flagObj;

        System.out.println("다시 기본형이 되었을까? 예)" + (b+1));
    }
    public static void main(String[] args)
    {
        Boxing b = new Boxing();
        b.box();
        b.unbox();
        //System.out.println("Hello World!");
    }
}

class A4 {
    Vector<String> v = new Vector<String>();
    void in(){
        v.add("봄");v.add("여름");v.add("가을");v.add("겨울");v.add("가을");
        System.out.println("v.size(): " + v.size());
    }
    void out(){
        for(String str: v){
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        A4 a = new A4();
        a.in();
        a.out();
    }
}

class B4 {
    TreeSet<String> ts = new TreeSet<String>();
    void in(){
        ts.add("봄");ts.add("여름");ts.add("가을");ts.add("겨울");ts.add("가을");
        System.out.println("ts.size(): " + ts.size());
    }
    void out(){
        for(String str : ts){
            System.out.println("str: " + str);
        }
    }
    public static void main(String[] args) {
        B4 b = new B4();
        b.in();
        b.out();
    }
}
class C4 {
    Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
    void in(){
        ht.put(10, "봄"); //put(int, String)
        ht.put(20, "여름");
        ht.put(30, "가을");
        ht.put(40, "겨울");
        //ht.put(30, "초가을"); //key를 중복시켜봄
        ht.put(50, "가을"); //value를 중복시켜봄
        System.out.println("ht.size(): " + ht.size());
    }
    void out(){ //key와 value들을 함께 꺼냄
        Set<Integer> keys = ht.keySet();
        for(int key : keys){
            System.out.println("key: " + key + ", value: " + ht.get(key));
        }
    }
    public static void main(String[] args) {
        C4 c = new C4();
        c.in();
        c.out();
    }
}









