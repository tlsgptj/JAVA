import java.util.ArrayList;
import java.util.List;

//유저의 데이터 리스트가 저장되어 있음
public class UserRepo {
    private static List<User> users = new ArrayList<>();
    
    static {
        users.add(new User("angele0709", "12345678"));
        users.add(new User("main", "87654321"));
    }
    
    public static User findUserName(String username) {
        for (User user : users) {
            if (user.getUserid().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
