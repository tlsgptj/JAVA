import javax.management.monitor.Monitor;
import java.net.*;
import java.io.*;

public class Server {
    int port = 4000;
    ServerSocket ss;
    Socket s;
    String ipClient;
    InputStream is;
    DataInputStream dis;

    OutputStream os;
    DataOutputStream dos;

    Server() {
        try {
            ss = new ServerSocket(port); //서버소켓 : 몇 번 포트에서 대기?
            System.out.println(port + "번 포트에서 TCP서버 대기중");

            //while(true)
            s = ss.accept(); //대기시키는 메소드(IO블럭)
            InetAddress ia = s.getInetAddress();
            ipClient = ia.getHostAddress();
            System.out.println("클라이언트" + ipClient + "접속완료!");

            is = s.getInputStream();
            dis = new DataInputStream(is);

            os = s.getOutputStream();
            dos = new DataOutputStream(os);

            new Thread(() -> listen()).start();
            speak();
        } catch (IOException ie) {
            System.out.println(port + "번 포트는 이미 사용중입니다.");
        } finally {
            try {
                s.close();
                ss.close();
            } catch (IOException ie) {

            }
        }
    }
    void listen() { //Socket -> Monitor
        String msg = "";
        try {
            while (true) {
                msg = dis.readUTF();
                System.out.println("Client>>" +msg);
            }
        } catch (IOException ie) {
            System.out.println("==상대방이 접속을 종료함 \n초 후에 종료예정==");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
            System.exit(-1);
        } finally {
            try {
                is.close();
                dis.close();
            } catch (IOException ie) {}
        }
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //키보드를 읽어보자

    void speak() { //keyboard -> Socket
        String line = "";
        try {
            while (true) {
                line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
        } finally {
            try{
                dos.close();
                os.close();
                br.close();
            } catch (IOException ie) {

            }
        }
    }
    public static void main(String[] args) {
        new Server();
    }

}

//1. 연결 성공
//2. 클라이언트 접속 완료!
//3. 다른 사람의 클라이언트에 접근
