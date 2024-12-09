import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

class LottoC {
    String fname = "C:\\demo\\untitled\\src\\list.txt";
    Hashtable<Integer, String> names = new Hashtable<>(); //names 해쉬테이블 생성
    Random r = new Random();

    void init() {
        try (FileReader fr = new FileReader(this.fname);
             BufferedReader br = new BufferedReader(fr)) {
            String var1; //var1 생성
            int id = 1; //id 생성
            while ((var1 = br.readLine()) != null) {
                var1 = var1.trim();
                if (!var1.isEmpty()) {
                    names.put(id++, var1); // 번호 부여 후 저장
                } // var1이 비어있지 않으면 아이디 부여 1부터 (for문으로도 할 수 있지 않을까 조심스럽게 고민)
            }
        } catch (IOException e) {
            pln("파일 읽는 중 오류 발생: " + e.getMessage());
        }
    }

    void showWinner() {
        if (names.isEmpty()) {
            pln("참가자가 없습니다.");
            return;
        }
        int var1 = r.nextInt(names.size()) + 1; // 1부터 시작하는 키
        pln("당첨번호: " + var1 + ", 당첨자: " + names.get(var1));
    }

    void show() {
        for (Integer id : names.keySet()) {
            pln(id + "번: " + names.get(id));
        }
    }

    void pln(String var1) {
        System.out.println(var1);
    }

    public static void main(String[] args) {
        LottoC lotto = new LottoC();
        lotto.init();
        lotto.show(); // 참가자 목록 출력
        lotto.showWinner(); // 당첨자 출력
    }
}

//var1에 각각의 번호를 부여하고 var1의 value에 이름이 들어가게끔 만들었음