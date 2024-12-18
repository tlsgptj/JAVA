import javax.management.monitor.Monitor;
import java.io.*;

//keyboard -> Moniter
//Keyboard -> File
public class Stream {
    InputStream is = System.in; //keyboard
    OutputStream os = System.out; //Monitor
    String fname = "Stream.java";
    Stream() {
        try{
            is = new FileInputStream(fname);
        } catch (FileNotFoundException fame) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }
    //키보드에서 읽어오는것
    void initKey() {
        is = System.in;
    }
    //파일에서 읽어오는 것
    void initFile() {
        try {
            //is 객체 생성
            is = new FileInputStream(fname);
        } catch (FileNotFoundException fnfe) {}
    }
    void inOut1(){
        byte[] bs = new byte[8];
        try {
            int i = 0;
            long total = 0L;
            while ((i = is.read(bs)) != -1) {
                os.write(bs, 0, i);
            }
            os.flush();
        } catch (IOException ie) {
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException ie) {}
        }
    }
    void inOut2() {
        try{
            //바이트 객체 생성
            byte[] bs = is.readAllBytes();
            os.write(bs); //바이트 쓰기
            os.flush(); //메모리 위치가 가득차면 모든 스트림을 플러시, 완전히 실행
            System.out.println("읽은 총 바이트수 : " + bs.length);
        } catch (IOException ie) {
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException ie) {}
        }
    }
    public static void main(String[] args) throws IOException {
        Stream a = new Stream();
        a.initFile();
        a.initKey();
        a.inOut1();
        a.inOut2();
    }
}
