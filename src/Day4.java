public class Day4 {
    String  str1 = "봄";
    String str2 = "여름";
    String str3 = "가을";
    String str4 = "겨울";
    String[] stars; //(1) 선언

    void m1() {
        stars = new String[4]; //생성(방의 크기가 중요함)
        stars[0] = str1; //초기화
        stars[1] = str2;
        stars[2] = str3;
        stars[3] = str4;//초기화

        for(int i=0; i<stars.length; i++) {
            System.out.println(stars[i]);
        }
    }

    void m2() {
        int[] is; //선언 지역변수 메모리 관점에서는 참조형 데이터
        is = new int[2]; //생성

        for(int i=0; i<is.length; i++) {
            System.out.println(is[i]);
        }
    }

    void out() { //isss 모든 데이터를 출력하시오
        int[] is = {10, 20};
        int[][] iss = {is, {30, 40, 50, 60}, {700}};
        int[][][] isss = {iss, {{8000, 9000}, {10000}}}; //3차원 데이터를 뽑아오는 것
        for (int i = 0; i < isss.length; i++) { //3차원
            for (int j = 0; j < isss[i].length; j++) { //2차원
                for(int k = 0; k < isss[i][j].length; k++) { //1차원
                    System.out.println("isss[" + i + "][" + j + "][" + k + "]: " + isss[i][j][k]);
                }
            }
        }
    }


    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.m1();
        day4.m2();
        day4.out();
    }
}

//선언, 생성, 초기화가 핵심
