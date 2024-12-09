import java.io.*;
import java.util.*;

class Tip1 {
    String fname = "C:\\demo\\untitled\\src\\list.txt"; // 파일 경로
    FileReader fr;
    BufferedReader br;
    String[] names = new String[8];

    Tip1() {
        try {
            fr = new FileReader(fname);
            System.out.println("fr: " + fr);
            br = new BufferedReader(fr); // UTF-8로 읽어와야함
        } catch (FileNotFoundException fe) {
            pln("File not found: " + fname);
        }
    }
   //파일을 읽는 함수
    void read() {
        String line = null;
        try {
            int i = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    names[i] = line;
                    i++;
                }
            }
        } catch (IOException ie) {
            pln("파일 읽기 성공 : " + ie.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ie) {
                pln("파일 에러남 : " + ie.getMessage());
            }
        }
    }
   // 이름과 할당된 번호를 보여주는 함수
    void showNames() {
        for (int i = 0; i < names.length; i++) {
            pln("names[" + i + "]: " + names[i]);
        }
    }

    void pln(String str) {
        System.out.println(str);
    }
}

// 랜덤 함수 임포트로 불러오기
class Tip2 {
    Random r = new Random();
    Tip1 tip1;

    Tip2(Tip1 tip1) {
        this.tip1 = tip1;
    }

    // 총인원과 당첨자, 당첨자의 번호 출력

    void showRan() {
        int i = r.nextInt(tip1.names.length);
        System.out.println("총인원 : " + tip1.names.length);
        pln("당첨자 : " + tip1.names[i] + " 당첨자의 번호 : " + i);

    }

    void pln(String str) {
        System.out.println(str);
    }
}

class Main {
    public static void main(String[] args) {
        Tip1 t1 = new Tip1();
        t1.read();
        t1.showNames();
        Tip2 t2 = new Tip2(t1);
        t2.showRan();
    }
}