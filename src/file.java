import java.io.*;

//파일 -> 파일
class file {
    FileInputStream fis;
    FileOutputStream fos;
    String fn_in = "A.java";
    String fn_out = "ACopy.java";
    file(){
        try{
            fis = new FileInputStream(fn_in);
            fos = new FileOutputStream(fn_out);
        }catch(FileNotFoundException fnfe){
        }
    }
    void copy1(){
        byte[] bs = new byte[8];
        try{
            int i = 0;
            long total = 0L;
            while((i=fis.read(bs)) != -1){
                //System.out.println("i: " + i);
                fos.write(bs, 0, i);
                total += i;
            }
            fos.flush();
            System.out.println("[1]복사성공(" + total + "bytes)");
        }catch(IOException ie){
        }finally{
            try{
                fis.close();
                fos.close();
            }catch(IOException ie){}
        }
    }
    void copy2(){
        try{
            byte[] bs = fis.readAllBytes();
            fos.write(bs);
            fos.flush();
            System.out.println("[2]복사성공(" + bs.length+ "bytes)");
        }catch(IOException ie){
        }finally{
            try{
                fis.close();
                fos.close();
            }catch(IOException ie){}
        }
    }
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        file b = new file();
        //b.copy1();
        b.copy2();
    }
}















