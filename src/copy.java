import java.io.*;

//키보드 -> 파일
class copy {
    InputStream is = System.in; //근본
    FileOutputStream fos; //근본
    BufferedInputStream bis; //목적
    BufferedOutputStream bos; //목적
    String fn = "C.txt";

    copy(){
        bis = new BufferedInputStream(is, 1024); //읽어서
        try{
            fos = new FileOutputStream(fn, true); //true: 기존내용에 append 됨!
        }catch(FileNotFoundException fnfe){
        }
        bos = new BufferedOutputStream(fos, 1024); //쓴다
    }
    void save1(){
        byte[] bs = new byte[8];
        try{
            int i = 0;
            long total = 0L;
            while((i=bis.read(bs)) != -1){
                //System.out.println("i: " + i);
                bos.write(bs, 0, i);
                total += i;
            }
            bos.flush();
            System.out.println("(1) "+fn+"에 쓰기 완료!");
        }catch(IOException ie){
        }finally{
            try{
                bis.close();
                bos.close();
                is.close();
                fos.close();
            }catch(IOException ie){}
        }
    }
    void save2(){
        try{
            byte[] bs = bis.readAllBytes();
            bos.write(bs);
            bos.flush();
            System.out.println("(2) "+fn+"에 쓰기 완료!");
        }catch(IOException ie){
        }finally{
            try{
                bis.close();
                bos.close();
                is.close();
                fos.close();
            }catch(IOException ie){}
        }
    }
    public static void main(String[] args) {
        copy c = new copy();
        //c.save1();
        c.save2();
    }
}