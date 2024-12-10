import java.util.*;

//데이터를 보호하기 위해 Get과 Set를 사용하여 구현해줍니다.
public class User {
    private String Userid;
    private String Userpassword;

    public User(String Userid, String Userpassword) {
        this.Userid = Userid;
        this.Userpassword = Userpassword;
    }
    public String getUserid() {
        return Userid;
    }
    public String getUserpassword() {
        return Userpassword;
    }
}

class Login {
    public boolean login(String userid, String Userpassword) {
        User user = UserRepo.findUserName(userid);
        if (user != null && user.getUserpassword().equals(Userpassword)) {
            return true;
        }
        return false;
    }
}

class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        System.out.print("사용자 아이디 :");
        String userid = scanner.nextLine();
        System.out.print("사용자 비밀번호 :");
        String password = scanner.nextLine();

        if (login.login(userid, password)) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인과 비밀번호가 잘못되었습니다.");
        }
        scanner.close();
    }

}
