import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;

public class MClient {
    Socket socket;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DataOutputStream dos;

    void start() {
        try {
            socket = new Socket("localhost" , 4000);
            System.out.println("서버와 연결되었습니다.");

            String name = "user";
            Thread UserInner = new UserInner(socket, name);
            UserInner.start();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            String chat="";
            while(dis != null) {
                chat = dis.readUTF();
                if(("[" + name + "퇴장하였습니다.]").equals(chat)) break;
                System.out.println("From" +chat);
            }
            dis.close();
        } catch (IOException ie) {
            System.out.println("서버 접속 종료");
        } finally {
            try {
                dos.close();
                br.close();
                socket.close();
            }
            catch (IOException ie) {}
        }
    }
    public static void main(String[] args) {
        MClient mc = new MClient();
        mc.start();
    }
}

class UserInner extends Thread{
    Socket socket;
    DataOutputStream dos;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    UserInner(Socket socket, String name) {
        this.socket = socket;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(name);
            dos.flush();
        } catch (IOException ie) {}
    }
    public void run() {
        String chat="";
        try{
            while (true) {
                chat = br.readLine();
                dos.writeUTF(chat);
                dos.flush();
                if(chat.equals("/quit")) break;
            }
        } catch (IOException e) {}
        finally {
            try {
                dos.close();
                br.close();
                socket.close();
            } catch (IOException e) {}
        }
    }
}
