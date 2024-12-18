import javax.management.monitor.Monitor;
import java.io.*;

//keyboard -> Moniter

public class Stream {
    InputStream is = System.in; //keyboard
    OutputStream os = System.out; //Monitor
    String fname = "Stream.java";
    Stream() {
        try{
            is = new FileInputStream(fname);
        } catch (FileNotFoundException fame) {

        }
    }
    void initKey() {
        is = System.in;
    }
    void inOut1() throws IOException {
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
            byte[] bs = is.readAllBytes();
            os.write(bs);
            os.flush();
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
        a.initKey();
        a.inOut1();
        a.inOut2();
    }
}
