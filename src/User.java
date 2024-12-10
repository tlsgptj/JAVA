import java.util.*;

//데이터를 보호하기 위해 Get과 Set를 사용하여 구현해줍니다.
public class User {
    private String userid;
    private String password;

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() { // 이름 변경
        return password;
    }
}

class Login {
    public boolean login(String userid, String Userpassword) {
        User user = UserRepo.findUserName(userid);
        if (user != null && user.getPassword().equals(Userpassword)) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SignUp signUp = new SignUp();
        Login login = new Login();
        System.out.print("사용자 아이디 :");
        String userid = scanner.nextLine();
        System.out.print("사용자 비밀번호 :");
        String password = scanner.nextLine();
        System.out.print("사용자 새아이디 :");
        String newid = scanner.nextLine();
        System.out.print("사용자 새비밀번호 :");
        String newpw = scanner.nextLine();

        if (signUp.signup(newid, newpw)) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("다시 입력");
        }

        if (login.login(userid, password)) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인과 비밀번호가 잘못되었습니다.");
        }

        scanner.close();
    }

}
