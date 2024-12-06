public class Day4 {
    String  str1 = "봄";
    String str2 = "여름";
    String str3 = "가을";
    String str4 = "겨울";
    String[] stars; //(1) 선언
    //String []strs; -> 배열 변수
    void m1() {
        stars = new String[4]; //생성(방의 크기가 중요함)
        stars[0] = str1; //초기화
        stars[1] = str2;
        stars[2] = str3;
        stars[3] = str4;//초기화

        for(int i=0; i<stars.length; i++) {
            System.out.println(stars[i]);
        }
        System.out.println(stars[0]); //out (저장소다)
        System.out.println(stars[1]);
    }

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.m1();
    }
}

//선언, 생성, 초기화가 핵심
