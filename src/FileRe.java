import java.io.*;

//키보드 -> 파일
class FileRe {
    BufferedReader br;//목적 = new BufferedReader(new InputStreamReader(System.in));
    InputStreamReader isr; //다리
    InputStream is = System.in; //근본

    PrintWriter pw;//목적
    FileOutputStream fos; //근본
    String fn = "F.txt";
    FileRe(){
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        try{
            fos = new FileOutputStream(fn, true);
        }catch(FileNotFoundException fe){}
        pw = new PrintWriter(fos, true);
    }
    void save(){ //키보드 -> 파일
        String line = "";
        try{
            line = br.readLine();
            pw.println(line);
        }catch(IOException ie){
        }finally{
            try{
                br.close();
                isr.close();
                is.close();
                pw.close();
                fos.close();
            }catch(IOException ie){}
        }
    }
    public static void main(String[] args) {
        FileRe f = new FileRe();
        f.save();
    }
}
