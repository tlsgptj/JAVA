import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

class FileCopyBySoo {
    PrintStream ps;
    InputStream is;
    BufferedReader br;
    FileInputStream fis;
    FileOutputStream fos;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    int option;
    String oriFileName;
    String fName;
    File fileDir;
    String dirName;
    boolean isDuplication;

    FileCopyBySoo() {
        this.ps = System.out;
        this.is = System.in;
        this.br = new BufferedReader(new InputStreamReader(this.is));
        this.option = 1;
        this.oriFileName = "";
        this.fName = "";
        this.dirName = "";
    }

    void inputOption() {
        this.pln("1. 복사   2. 잘라내기");

        try {
            String var1 = this.br.readLine();
            if (var1 != null) {
                var1 = var1.trim();
            }

            if (var1.length() == 0) {
                this.pln("입력은 필수");
                this.inputOption();
                return;
            }

            int var2 = Integer.parseInt(var1);
            if (var2 != 1 && var2 != 2) {
                this.pln("1 or 2만 입력 가능");
                this.inputOption();
            }

            this.option = var2;
            this.inputOriginal();
        } catch (IOException var3) {
        } catch (NumberFormatException var4) {
            this.pln("숫자만 입력 가능");
            this.inputOption();
        }

    }

    void inputOriginal() {
        this.p("복사 원본 파일 : ");

        try {
            String var1 = this.br.readLine();
            if (var1 != null) {
                var1 = var1.trim();
            }

            if (var1.length() == 0) {
                this.pln("입력은 필수");
                this.inputOriginal();
                return;
            }

            this.fis = new FileInputStream(var1);
            this.bis = new BufferedInputStream(this.fis, 2048);
            this.oriFileName = var1;
            int var2 = var1.lastIndexOf("\\");
            this.fName = var1.substring(var2 + 1);
            this.inputCopyDir();
        } catch (FileNotFoundException var3) {
            this.pln("입력한 파일은 없음");
            this.inputOriginal();
        } catch (IOException var4) {
        }

    }

    void inputCopyDir() {
        this.p("복사할 폴더 위치 : ");

        try {
            String var1 = this.br.readLine();
            if (var1 != null) {
                var1 = var1.trim();
            }

            if (var1.length() == 0) {
                this.pln("입력은 필수");
                this.inputCopyDir();
                return;
            }

            this.fileDir = new File(var1);
            if (this.fileDir.isFile()) {
                this.pln("폴더만 입력 가능");
                this.inputCopyDir();
            } else {
                this.dirName = var1;
                if (this.fileDir.exists()) {
                    this.checkDuplication();
                } else {
                    this.showMsgNotExistDir();
                }
            }
        } catch (IOException var2) {
        }

    }

    void showMsgNotExistDir() {
        this.p("존재하지 않는 디렉토리! 만들까요?(Yes/No) : ");

        try {
            String var1 = this.br.readLine();
            if (var1 != null) {
                var1 = var1.trim();
            }

            if (var1.equalsIgnoreCase("yes")) {
                if (this.fileDir.mkdirs()) {
                    this.goCopyOrCut();
                }
            } else {
                if (var1.equalsIgnoreCase("no")) {
                    return;
                }

                this.pln("yes와 no만 가능!");
            }
        } catch (IOException var2) {
        }

    }

    void checkDuplication() {
        File[] var1 = this.fileDir.listFiles();
        File[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            File var5 = var2[var4];
            if (var5.isFile()) {
                String var6 = var5.getName();
                if (this.fName.equals(var6)) {
                    this.isDuplication = true;
                }
            }
        }

        this.showMsgDuplication();
    }

    void showMsgDuplication() {
        if (this.isDuplication) {
            this.p("동일 이름 파일 존재! 덮어 쓸까요?(Yes/No) : ");

            try {
                String var1 = this.br.readLine();
                if (var1 != null) {
                    var1 = var1.trim();
                }

                if (var1.equalsIgnoreCase("yes")) {
                    this.goCopyOrCut();
                } else {
                    if (var1.equalsIgnoreCase("no")) {
                        return;
                    }

                    this.pln("yes와 no만 가능!");
                }
            } catch (IOException var2) {
            }
        } else {
            this.goCopyOrCut();
        }

    }

    void goCopyOrCut() {
        String var1 = this.dirName + "\\" + this.fName;

        try {
            this.fos = new FileOutputStream(var1);
            this.bos = new BufferedOutputStream(this.fos, 2048);
            boolean var2 = false;
            byte[] var3 = new byte[512];

            int var17;
            while((var17 = this.bis.read(var3)) != -1) {
                this.bos.write(var3, 0, var17);
            }

            this.bos.flush();
        } catch (FileNotFoundException var14) {
        } catch (IOException var15) {
        } finally {
            try {
                if (this.bos != null) {
                    this.bos.close();
                }

                if (this.bis != null) {
                    this.bis.close();
                }

                if (this.fos != null) {
                    this.fos.close();
                }

                if (this.fis != null) {
                    this.fis.close();
                }
            } catch (IOException var13) {
            }

        }

        this.showMsgResult();
    }

    void showMsgResult() {
        if (this.option == 1) {
            this.pln("복사 성공");
        } else if ((new File(this.oriFileName)).delete()) {
            this.pln("잘라내기 성공");
        } else {
            this.pln("원본 삭제 실패");
        }

    }

    void pln(String var1) {
        this.ps.println(var1);
    }

    void p(String var1) {
        this.ps.print(var1);
    }

    public static void main(String[] var0) {
        FileCopyBySoo var1 = new FileCopyBySoo();
        var1.inputOption();
    }
}
