//회원가입 클래스 구현
import java.util.*;

public class SignUp {
    public boolean signup(String userid, String password) {
        if (userid == null || password == null) {
            return false;
        }
        if (UserRepo.findUserName(userid) != null) {
            return false;
        }
        User newUser = new User(userid, password);
        return UserRepo.addUser(newUser);

    }


}
