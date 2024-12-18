import java.io.*;

//목적
public class data {
    FileOutputStream fos;
    DataOutputStream dos;
    String fn = "D.txt";
    byte b = 1;
    short s = 2;
    int i = 3;
    long lo = 4L;
    float f = 5.0f;
    double d = 6.0;
    boolean flag = false;
    String str = "점심식사";  //3*4 = 12

    data() {
        try{
            fos = new FileOutputStream(fn);
            dos = new DataOutputStream(fos);
        } catch (FileNotFoundException fe) {

        }
    }
    void w() {
        try{
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(lo);
            dos.writeUTF(str);
            dos.flush();
            System.out.println(fn + "에 쓰기완료");
        } catch (IOException ie) {}
    }
    public static void main(String[] args) {
        data D = new data();
        D.w();
    }

}
