import javax.xml.crypto.Data;
import java.net.*;
import java.io.*;
import java.util.*;

class MServer {
    int port = 4000;
    ServerSocket server;
    Socket socket;
    BufferedReader br;

    void start() {
        try {
            server = new ServerSocket(port);
            while(true) {
                System.out.println("클라이언트 접속 대기중");
                socket = server.accept();

                OnlineUser onlineUser = new OnlineUser(socket);
                onlineUser.start();
            }
        } catch (IOException ie) {
            System.out.println("[서버 접속 끊김");
        } finally {
            try{
                server.close();
            } catch (IOException ie) {

            }
        }
    }

    public static void main(String[] args) {
        MServer mServer = new MServer();
        mServer.start();
    }
}

class OnlineUser extends Thread{
    static List<DataOutputStream> list = Collections.synchronizedList(new ArrayList<DataOutputStream>());
    //Collections의 synchronizedList에 대해서 알아보자
    /*
    * 멀티스레드 환경에서 안전하게 사용할 수 있도록 리스트를 동기화하는 방법을 제공
    * 주어진 리스트를 감싸서 동기화된 리스트를 반환
    * 여러 스레드가 동시에 리스트에 접근하더라도 데이터의 일관성 유지 가능
    * */

    Socket socket;
    BufferedReader br;
    DataInputStream dis;
    DataOutputStream dos;

    OnlineUser(Socket socket) {
        try {
            this.socket = socket;
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            list.add(dos);
        } catch (IOException ie){}
    }
    @Override
    public void run() {
        String name = "";
        try {
            name = dis.readUTF();
            System.out.println("[" + name + "새연결 생성");
            allSend("[" + name + "] 님이 들어오셨습니다.");

            String chat = "";
            while (dis != null) {
                chat = dis.readUTF();
                if(chat.equals("/quit")) break;
                else if(chat.equals("/nick")) {
                    dos.writeUTF("/nick 닉네임");
                    dos.flush();
                    continue;
                } else if (chat.contains("/nick")) {
                    name = chat.substring(chat.lastIndexOf(" "));
                    continue;
                }
                allSend(name + " >> " + chat);
            }
        } catch (IOException ie) {
            try {Thread.sleep(2000);}catch (InterruptedException ine) {}
        }
        finally {
            System.out.println("[" + name + "퇴장하였습니다.");
            try {
                dis.close();
                dos.close();
                socket.close();
            } catch (IOException ie) {}
        }
    }
    void allSend(String chat) {
        try{
            for (DataOutputStream user : list) {
                System.out.println(user);
                user.writeUTF(chat);
                user.flush();
            }
        } catch (IOException ie) {}
    }
}