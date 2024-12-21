import jdk.jfr.DataAmount;

import java.net.*;
import java.io.*;

public class Client {
    Socket s;
    String ipServer = "10.41.2.99"; //IP " 10.41.2.99"
    int port = 4000; //서버포트
    OutputStream os;
    DataOutputStream dos;

    InputStream is;
    DataInputStream dis;

    Client() {
        //데이터 소프트웨어적인 통로 "소켓" 만들기
        // Socket은 UnknownHostException, IOException
        try{
            s = new Socket(ipServer, port);
            System.out.println("서버에 연결");

            os = s.getOutputStream();
            dos = new DataOutputStream(os);

            is = s.getInputStream();
            dis = new DataInputStream(is);

            new Thread(() -> listen()).start();
            speak();

        } catch (UnknownHostException ue) {
            System.out.println("네트워크 상에 그런 주소를 찾을 수 없음");
        } catch (IOException ie) {
            System.out.println("네트워크 상에 그런 주소를 찾을 수 없음");
        } finally {
            try{
                s.close();
                System.out.println("서버와의 접속해제");
            } catch(IOException ie) {}
        }
    }
    void listen() { //Socket -> Monitor
        String msg = "";
        try{
            while (true) {
                msg = dis.readUTF();
                System.out.println("Server>>" +msg);
            }
        } catch (IOException ie) {
            System.out.println("서버퇴장\n초 후에 종료예정");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
            System.exit(-1);
        } finally {
            try{
                is.close();
                dis.close();
            } catch (IOException ie) {}
        }
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //키보드 읽음

    void speak() {//keyboard -> Socket
        String line = "";
        try{
            while (true) {
                line = br.readLine();
                dos.writeUTF(line);
                dos.flush();
            }
        } catch (IOException ie) {
        } finally {
            try {
                dos.close();
                os.close();
                br.close();
            } catch (IOException ie) {

            }
        }
    }
    public static void main(String[] args) {
        new Client();
    }
}
