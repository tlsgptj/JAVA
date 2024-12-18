import java.io.*;
//File -> File & Monitor
public class writer {
    Reader r;
    Writer w;
    String fn_fn = "writer.java";
    String fn_out = "writer.txt";
    OutputStream os = System.out;
    OutputStreamWriter osw;
    writer() {
        try{
            r = new FileReader(fn_fn);
            w = new FileWriter(fn_out);
            osw = new OutputStreamWriter(os);
        }catch (IOException fe) {

        }
    }
    void copy() {
        char[] cs = new char[128];
        try{
            int i = 0;
            long total = 0L;
            while((i=r.read(cs)) != -1) {
                w.write(cs, 0, i); //파일에 쓰기
                osw.write(cs, 0, i); //모니터에 쓰기
                total += i;
            }
            w.flush();
            osw.flush();
            System.out.print("복사완료!");
        } catch (IOException ie) {

        } finally {
            try{
                r.close();
                w.close();
                osw.close();
            } catch (IOException ie) {

            }
        }
    }
    public static void main(String[] args) {
        writer e = new writer();
        e.copy();
    }
}
//OutputStreamWriter