import java.util.*;

//카드 등록 시스템 구현
public class Credit {
    //카드 등록 시스템을 구현하기 위해서는 우선 카드등록 번호와 카드 CVC번호, 이름 등이 필요함
    //일단 생성자 정의 Double? String? 을 고민하다가 그냥 String으로 통일
    private String Cardname;
    private String Cardnum;
    private String year;
    private int CVCnum;

    public void Card(String Cardname, String Cardnum, String year, int CVCnum) {
        this.Cardname = Cardname;
        this.Cardnum = Cardnum;
        this.year = year;
        this.CVCnum = CVCnum;
    }

    //get을 써주어 데이터를 꺼내옴
    public String getCardname() {
        return Cardname;
    }
    public String getCardnum() {
        return Cardnum;
    }
    public String getYear() {
        return year;
    }
    public int getCVCnum() {
        return CVCnum;
    }
}
//카드DB를 어떻게 생성해야할지 밍고중


class CardScan {
    public boolean cardscan(String Cardname, String Cardnum, String year, Integer CVCnum) {
      if (Cardname == null && Cardnum == null && year == null && CVCnum == null) {
          return false;
      } else {
          Credit credit = new Credit(Cardname, Cardnum, year, CVCnum);


      }
    }


}
class YourCardIs {

}

class Main3 {
    public static void main(String[] args) {
        //이거 자바 유틸 클래스에 들어있어서 사용 가능 이거 써줄때 꼭 System.in을 써야함 아니면 에러남 왜그런지는 모르겠음
        Scanner scanner = new Scanner(System.in);
        CardScan cardScan = new CardScan();
        YourCardIs yourCardIs = new YourCardIs();
        System.out.println("카드를 등록하세요!");
        System.out.println("카드 이름을 입력하세요!");
        scanner.nextLine();
        System.out.println("카드를 번호를 입력하세요!");
        scanner.nextLine();
        System.out.println("카드 유효기간을 입력하세요!");
        scanner.nextLine();
        System.out.println("카드 CVC번호를 입력하세요!");
        scanner.nextLine();
        System.out.println("카드가 정상적으로 등록되었습니다.");

        System.out.println("본인 카드 조회");


    }
}
