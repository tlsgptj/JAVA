import java.io.*;
import java.util.*;
import java.io.IOException;
class P {
    P() {
    }
    static void pln(String var0) {
        System.out.println(var0);
    }
    static void p(String var0) {
        System.out.print(var0);
    }
}
//파일을 읽는 클래스
class ReadPath {
    LottoMulti lotto;
    BufferedReader brFile;
    String path;
    FileReader fr;

    ReadPath(LottoMulti var1) {
        this.lotto = var1;
    }

    boolean inputList() {
        try {
            P.p("리스트 파일(기본 : 우리반리스트.txt) : ");
            this.path = this.lotto.br.readLine();
            if (this.path != null) {
                this.path = this.path.trim();
            }

            if (this.path.length() == 0) {
                this.path = "list.txt";
            }

            this.fr = new FileReader(this.path);
            return this.insertMap();
        } catch (FileNotFoundException var2) {
            P.pln("그런 파일 없잖여..");
            return this.inputList();
        } catch (IOException var3) {
            return this.inputList();
        }
    }

    boolean insertMap() {
        int var1 = 0;
        String var2 = "";
        this.brFile = new BufferedReader(this.fr);

        try {
            while((var2 = this.brFile.readLine()) != null) {
                this.lotto.map.put(var1, var2);
                ++var1;
            }

            LottoMulti.totalCount = var1;
            return this.copyListRes(var1);
        } catch (IOException var4) {
            return false;
        }
    }

    void showMap() {
        Set var1 = this.lotto.map.keySet();
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            int var3 = (Integer)var2.next();
            P.pln("key : " + var3 + ", value : " + (String)this.lotto.map.get(var3));
        }

    }

    boolean copyListRes(int var1) {
        Set var2 = this.lotto.map.keySet();
        Iterator var3 = var2.iterator();

        while(var3.hasNext()) {
            int var4 = (Integer)var3.next();
            this.lotto.listRes.add(var4);
        }

        return this.lotto.listRes.size() == var1;
    }

    void showListRes() {
        Iterator var1 = this.lotto.listRes.iterator();

        while(var1.hasNext()) {
            int var2 = (Integer)var1.next();
            P.pln("listRes의 idx : " + var2);
        }

    }
}
//Lotto의 위너를 뽑는 클래스
class Winner {
    LottoMulti lotto;
    Random ran = new Random();
    TreeSet<String> tset = new TreeSet();
    BufferedReader brRate;
    String target;
    float rate;

    Winner(LottoMulti var1) {
        this.lotto = var1;
    }

    void moveStore() {
        for(int var1 = 0; var1 < this.lotto.su; ++var1) {
            this.moveOne();
        }

        this.addWinners();
    }

    void moveOne() {
        int var1 = this.ran.nextInt(this.lotto.listRes.size());
        int var2 = (Integer)this.lotto.listRes.get(var1);
        this.lotto.listWin.add(var2);
        this.lotto.listRes.remove(var1);
    }

    void addWinners() {
        String var1 = "";
        String var2 = "";
        Iterator var3 = this.lotto.listWin.iterator();

        while(var3.hasNext()) {
            int var4 = (Integer)var3.next();
            var1 = (String)this.lotto.map.get(var4);
            ++var4;
            if (var4 < 10) {
                var2 = "0" + var4;
            } else {
                var2 = "" + var4;
            }

            String var5 = "번호 : " + var2 + ", 이름 : " + var1.trim();
            this.tset.add(var5);
        }

        this.descWinner();
    }

    void ascWinner() {
        Iterator var1 = this.tset.iterator();

        while(var1.hasNext()) {
            String var2 = (String)var1.next();
            P.pln(var2.toString());
        }

    }

    void descWinner() {
        NavigableSet var1 = this.tset.descendingSet();
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            P.pln(var3.toString());
        }

    }
}

class ReadCount {
    LottoMulti lotto;

    ReadCount(LottoMulti var1) {
        this.lotto = var1;
    }

    void inputCount() {
        String var1 = "";

        try {
            P.p("당첨자수 : ");
            var1 = this.lotto.br.readLine();
            if (var1 != null) {
                var1 = var1.trim();
            }

            if (var1.length() != 0) {
                this.lotto.su = Integer.parseInt(var1);
                if (this.lotto.su < 0 || this.lotto.su > LottoMulti.totalCount) {
                    P.pln("범위가 잘못됨(총수:" + LottoMulti.totalCount + ")");
                    this.inputCount();
                }
            } else {
                this.inputCount();
            }
        } catch (IOException var3) {
            this.inputCount();
        } catch (NumberFormatException var4) {
            P.pln("숫자만 입력 가능..");
            this.inputCount();
        }

    }
}


class LottoMulti {
    BufferedReader br;
    static int totalCount;
    int su;
    Hashtable<Integer, String> map;
    Vector<Integer> listRes;
    Vector<Integer> listWin;

    LottoMulti() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.map = new Hashtable();
        this.listRes = new Vector();
        this.listWin = new Vector();
        ReadPath var1 = new ReadPath(this);
        ReadCount var2 = new ReadCount(this);
        if (var1.inputList()) {
            var2.inputCount();
            Winner var3 = new Winner(this);
            var3.moveStore();
        } else {
            var1.inputList();
        }

    }
    public static void main(String[] var0) {
        new LottoMulti();
    }
}