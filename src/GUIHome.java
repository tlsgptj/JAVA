import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class GUIHome extends JFrame implements ActionListener {
    Container cp;
    String fPath = "C:\\demo\\untitled\\src\\Client.java";
    JTextPane tp = new JTextPane();
    JScrollPane sp;
    JButton bOpen = new JButton("Open");
    JButton bSave = new JButton("Save");
    JButton bClear = new JButton("Clear");
    JPanel p = new JPanel();
    static final int FC_OPEN = 0;
    static final int FC_SAVE = 1;

    void UiTest2() {
        this.bOpen.addActionListener(this);
        this.bSave.addActionListener(this);
        this.bClear.addActionListener(this);
    }
    void init() {
        this.cp = this.getContentPane();
        this.sp = new JScrollPane(this.tp);
        this.cp.add(this.sp);
        this.cp.add(this.bClear, "North");
        this.p.setLayout(new GridLayout(1, 2));
        this.p.add(this.bOpen);
        this.p.add(this.bSave);
        this.cp.add(this.p, "South");
        this.setUI();
        this.tp.requestFocus();
    }

    void showFC(int var1) {
        JFileChooser var2 = new JFileChooser();
        FileNameExtensionFilter var3 = new FileNameExtensionFilter("파일열기");
        var2.addChoosableFileFilter(var3);
        boolean var4 = true;
        int var6;
        if (var1 == 0) {
            var6 = var2.showOpenDialog(this);
        } else {
            var6 = var2.showSaveDialog(this);
        }

        if(var6 == 0) {
            File var5 = var2.getSelectedFile();
            if (var1 == 0) {
                this.readF(var5);
            } else {
                this.writeF(var5);
            }
        }
    }

    void readF(File var1) {
        BufferedReader var2 = null;
        FileReader var3 = null;

        try {
            String var4 = "";
            StringBuffer var5 = new StringBuffer();
            var3 = new FileReader(var1);
            var2 = new BufferedReader(var3);

            while ((var4 = var2.readLine()) != null) {
                var5.append(var4 + "\n");
            }

            String var6 = var5.toString();
            this.tp.setText(var6);
        } catch (IOException var15) {

        } finally {
            try {
                if (var2 != null) {
                    var2.close();
                }
                if (var3 != null) {
                    var3.close();
                }
            } catch (IOException var14) {

            }
        }
    }
    void writeF(File var1) {
        String var2 = this.tp.getText();
        var2 = var2.replace("\n", "\r\n");
        FileWriter var3 = null;
        PrintWriter var4 = null;

        try {
            var3 = new FileWriter(var1);
            var4 = new PrintWriter(var3, true);
            var4.print(var2);
        } catch (IOException var14) {

        } finally {
            try {
                if (var4 != null) {
                    var4.close();
                }

                if (var3 != null) {
                    var3.close();
                }
            } catch (IOException var13) {

            }
        }
    }
    void setUI() {
        this.setTitle("JFile");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setLocation(500,100);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent var1) {
        Object var2 = var1.getSource();
        if (var2 == this.bOpen){
            this.showFC(0);
        } else if (var2 == this.bSave) {
            this.showFC(1);
        } else {
            this.tp.setText("");
            this.tp.requestFocus();
        }
    }
    public static void main(String[] var0) {
        GUIHome guiHome = new GUIHome();
        guiHome.UiTest2();
        guiHome.init();

    }
}
