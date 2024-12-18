import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class Lotto1RateN {
    String fName = "list.txt";
    FileReader fr;
    BufferedReader br;
    int num;
    ArrayList<String> list = new ArrayList();
    Hashtable<Integer, Integer> rates = new Hashtable();
    int rate;
    int idxRate;
    String name;
    Random r = new Random();
    ArrayList<Integer> list_key = new ArrayList();

    Lotto1RateN() {
    }

    void readF() {
        String var1 = "";

        try {
            this.fr = new FileReader(this.fName);
            this.br = new BufferedReader(this.fr);
            this.num = 0;

            while((var1 = this.br.readLine()) != null) {
                var1 = var1.trim();
                if (var1.length() != 0) {
                    this.set(var1);
                    this.list.add(this.name);
                    ++this.num;
                }
            }
        } catch (FileNotFoundException var3) {
        } catch (IOException var4) {
        }

    }

    void set(String var1) {
        if (var1 != null) {
            this.name = var1.trim();
        }

        int var2 = this.name.indexOf(" ");
        if (var2 != -1) {
            this.name = var1.substring(0, var2);
            String var3 = var1.substring(var2 + 1);
            var3 = var3.trim();

            try {
                this.rate = Integer.parseInt(var3);
            } catch (NumberFormatException var5) {
                this.pln("파일(" + this.fName + ") 수정 필요: 숫자 아닌 확율이 존재)");
                System.exit(0);
            }

            this.idxRate = this.num;
            this.rates.put(this.idxRate, this.rate);
        }

    }

    public void showRates() {
        Set var1 = this.rates.keySet();
        TreeSet var2 = new TreeSet(var1);
        Iterator var3 = var2.iterator();

        int var4;
        int var6;
        for(var4 = 0; var3.hasNext(); var4 += var6) {
            int var5 = (Integer)var3.next();
            var6 = (Integer)this.rates.get(var5);
        }

        if (var4 > 100) {
            this.pln("파일(" + this.fName + ") 수정 필요: 확율 총합이 100 초과)");
            System.exit(0);
        } else if (this.list.size() == this.rates.size()) {
            if (var4 != 100) {
                this.pln("파일(" + this.fName + ") 수정 필요: 확율 총합이 100이 아님)");
                System.exit(0);
            } else {
                this.makeR100();
            }
        } else {
            this.makeR100();
        }

    }

    void makeR100() {
        int var1 = this.r.nextInt(100);
        ++var1;
        Set var2 = this.rates.keySet();
        TreeSet var3 = new TreeSet(var2);
        Iterator var4 = var3.iterator();
        int var5 = 0;

        while(var4.hasNext()) {
            int var6 = (Integer)var4.next();
            int var7 = (Integer)this.rates.get(var6);
            var5 += var7;
            if (var1 <= var5) {
                this.pln("당첨자(1): " + (String)this.list.get(var6));
                return;
            }

            this.list_key.add(var6);
        }

        this.other();
    }

    void other() {
        int var1 = 0;

        for(Iterator var2 = this.list_key.iterator(); var2.hasNext(); ++var1) {
            int var3 = (Integer)var2.next();
            this.list.remove(var3 - var1);
        }

        int var4 = this.r.nextInt(this.list.size());
        this.pln("당첨자(2): " + (String)this.list.get(var4));
    }

    void pln(String var1) {
        System.out.println(var1);
    }

    public static void main(String[] var0) {
        Lotto1RateN var1 = new Lotto1RateN();
        var1.readF();
        var1.showRates();
    }
}
