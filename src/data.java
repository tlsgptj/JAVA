import java.io.*;

//목적
public class data {
    FileOutputStream fos; //근본
    DataOutputStream dos; //목적
    String fn = "D.txt";
    FileInputStream fis;
    DataInputStream dis;

    byte b = 1;
    short s = 2;
    int i = 3;
    long lo = 4L;
    float f = 5.0f;
    double d = 6.0;
    boolean flag = false;
    String str = "점심식사";  // 3 * 4 = 12 + 2 (따옴표 2바이트)

    data() {
        try{
            fos = new FileOutputStream(fn);
            dos = new DataOutputStream(fos);
            fis = new FileInputStream(fn);
            dis = new DataInputStream(fis);
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
    //읽어주자 각각의 문자열을
    void r() throws IOException {
        byte r1 = dis.readByte();
        short r2 = dis.readShort();
        char r3 = dis.readChar();
    }
    public static void main(String[] args) throws IOException {
        data D = new data();
        D.w();
        D.r();
    }
//문자로 바꾸려고 했기 때문에 파일이 깨져버림
}
