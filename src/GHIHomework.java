import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

class GHIHomework extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    ImageIcon ii1;
    ImageIcon ii2;
    ImageIcon ii3;
    ImageIcon ii4;
    Container cp;
    JPanel p = new JPanel();

    void init() {
        this.loadImg();
        this.b1 = new JButton("동");
        this.b2 = new JButton("서");
        this.b3 = new JButton("남");
        this.b4 = new JButton("북");
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.b3.addActionListener(this);
        this.b4.addActionListener(this);
        this.cp = this.getContentPane();
        this.cp.add(this.b1, "East");
        this.cp.add(this.b2, "West");
        this.cp.add(this.b3, "South");
        this.cp.add(this.b4, "North");
        this.cp.add(this.p);
        this.p.setLayout(new GridLayout(2, 2));
        this.p.add(new JButton(this.ii1));
        this.p.add(new JButton(this.ii2));
        this.p.add(new JButton(this.ii3));
        this.p.add(new JButton(this.ii4));
        this.setUI();
    }

    void setUI() {
        this.setTitle("JOptions");
        this.pack();
        this.setVisible(true);
        this.setLocation(500, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
    }

    void loadImg() {
        try {
            this.ii1 = new ImageIcon(ImageIO.read(new File("C:\\demo\\untitled\\src\\imgs\\p_girl.png")));
            this.ii2 = new ImageIcon(ImageIO.read(new File("C:\\demo\\untitled\\src\\imgs\\p_hello.png")));
            this.ii3 = new ImageIcon(ImageIO.read(new File("C:\\demo\\untitled\\src\\imgs\\p_play.png")));
            this.ii4 = new ImageIcon(ImageIO.read(new File("C:\\demo\\untitled\\src\\imgs\\p_study.png")));
        } catch (IOException var2){}
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.b1) {
            JOptionPane.showMessageDialog((Component)null, "안녕!", "제목", 3, this.ii1 );
        } else if (var2 == this.b2) {
            int var3 = JOptionPane.showConfirmDialog((Component)null, "종료할까요?", "선택", 2, 3, this.ii2 );
            if(var3 == 0){
                System.exit(0);
            }
        } else if (var2 == this.b3) {
            Object[] var9 = new Object[]{"Good", "Bad", "Normal"};
            Object var4 = JOptionPane.showInputDialog((Component)null, "오늘 기분 어때?", "질문", 3, this.ii3, var9, var9[0]);
            if (var4 != null) {
                String var5 = var4.toString();
                String var6 = "";
                switch (var5) {
                    case "Good" :
                        var6 = "좋아";
                        break;
                    case "Bad" :
                        var6 = "싫어";
                        break;
                    default:
                        var6 = "그냥 그래";
                }
                JOptionPane.showMessageDialog((Component)null, var6, "답변", -1 );
            }
        } else if (var2 == this.b4) {
            Object[] var10 = new Object[] {"국", "영", "수"};
            Object var11 = JOptionPane.showInputDialog((Component)null, "공부를 합시다", "질문", 3, this.ii4, var10, var10[0]);
            if (var11 != null) {
                String var12 = var11.toString();
                String var13 = "";
                switch (var12) {
                    case "국어" :
                        var13 = "국어공부";
                        break;
                    case "수학" :
                        var13 = "수학공부";
                        break;
                    case "영어" :
                        var13 = "영어공부";
                        break;
                    default:
                        var13 = "안해";
                }
                JOptionPane.showMessageDialog((Component)null, "공부과목이 선택되었습니다.", "답변", -1 );
            }
        }
    }
    public static void main(String[] var0) {
        GHIHomework guihome = new GHIHomework();
        guihome.init();
    }

}