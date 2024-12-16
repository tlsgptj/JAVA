import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

class Lotto1Rate {
    String fName = "list.txt";
    BufferedReader br;
    FileReader fr;
    BufferedReader brKey;
    ArrayList<String> names;
    String name;
    int rate;
    int idxRate;
    int num;
    Random r;

    Lotto1Rate() {
        this.brKey = new BufferedReader(new InputStreamReader(System.in));
        this.names = new ArrayList();
        this.idxRate = -1;
        this.r = new Random();
    }

    void searchF() throws IOException {
        try {
            this.fr = new FileReader(this.fName);
            this.br = new BufferedReader(this.fr);
        } catch (FileNotFoundException var2) {
            this.p("파일경로(" + this.fName + " 못찾음): ");
            this.fName = this.brKey.readLine();
            this.searchF();
        }

    }

    void readF() throws IOException {
        String var1 = "";

        while((var1 = this.br.readLine()) != null) {
            this.set(var1);
        }

    }

    void set(String var1) {
        if (var1 != null) {
            var1 = var1.trim();
        }

        if (var1.length() != 0) {
            int var2 = var1.indexOf(" ");
            if (var2 == -1) {
                this.name = var1;
            } else {
                this.name = var1.substring(0, var2);
                String var3 = var1.substring(var2 + 1);
                var3 = var3.trim();

                try {
                    this.rate = Integer.parseInt(var3);
                } catch (NumberFormatException var5) {
                    this.pln(this.fName + "의 확율정보가 잘못됨. 변경 후 다시 하세요");
                    System.exit(0);
                }

                if (this.rate > 100) {
                    this.rate = 100;
                }

                if (this.rate < 0) {
                    this.rate = 0;
                }

                this.idxRate = this.num;
            }

            this.names.add(this.name);
            ++this.num;
        }

    }

    void makeR100() {
        int var1 = this.r.nextInt(100);
        ++var1;
        int var2;
        if (this.idxRate != -1) {
            if (var1 <= this.rate) {
                this.pln("당첨자: " + (String)this.names.get(this.idxRate));
            } else {
                this.names.remove(this.idxRate);
                var2 = this.r.nextInt(this.names.size());
                this.pln("당첨자: " + (String)this.names.get(var2));
            }
        } else {
            var2 = this.r.nextInt(this.names.size());
            this.pln("당첨자: " + (String)this.names.get(var2));
        }

    }

    void p(String var1) {
        System.out.print(var1);
    }

    void pln(String var1) {
        System.out.println(var1);
    }

    public static void main(String[] var0) {
        Lotto1Rate var1 = new Lotto1Rate();

        try {
            var1.searchF();
            var1.readF();
        } catch (IOException var3) {
        }

        var1.makeR100();
    }
}