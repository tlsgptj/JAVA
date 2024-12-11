import java.util.*;

//ArrayList 구현이 개같이 실패하여 해쉬맵을 활용해보았읍니다...
//사실 지피티가 알려줌
public class CreditRepo {
    static Map<String, Credit> cardDB = new HashMap<>();

    static void addCard(Credit credit) {
        cardDB.put("유저1", new Credit("혜서의 카카오카드", "5365-1012-9919-8486", "08/25", 795));
    }

    void YourCardIs(String user) {
        if (cardDB.containsKey(user)) {
            Credit card = cardDB.get(user);
            System.out.println("카드 정보:");
            System.out.println("카드 이름: " + card.getCardname());
            System.out.println("카드 번호: " + card.getCardnum());
            System.out.println("유효 기간: " + card.getYear());
            System.out.println("CVC 번호: " + card.getCVCnum());
        } else {
            System.out.println("등록된 카드가 없습니다.");
        }

    }
}