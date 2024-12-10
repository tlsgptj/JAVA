import java.util.*;

public class Day6 {
    Hashtable<Integer, String> map1 = new Hashtable<>();
    Hashtable<Integer, String> map2 = new Hashtable<>();
    HashSet<Hashtable<Integer, String>> hs = new HashSet<>();
    //hashSet을 사용하는거임
    //TreeSet은 생성될때부터 한계가 있음 그래서 HashSet를 사용해주는 것

    // 생성자에서 Comparator를 제공
        void in() {
            map1.put(1, "아침");
            map1.put(2, "저녁");
            map1.put(3, "점심");

            map2.put(10, "헬쓰");
            map2.put(20, "헬뜨");
            map2.put(30, "수영");

            hs.add(map1);
            hs.add(map2);
        }

        void out () {
            for (Hashtable<Integer, String> ht : hs) { //hs객체를 ht에 넣어줌 반복문이 2번 돌아
                Set<Integer> keys = ht.keySet(); //키들을 뽑아냄
                for (Integer key : keys) { //키들에서 다시 키를 뽑아냄
                    System.out.println("key: " + key + ", value: " + ht.get(key));
                }
            }
        }

        public static void main (String[] args){
            Day6 day6 = new Day6();
            day6.in();
            day6.out();
        }
    }

