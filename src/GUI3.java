import javax.swing.*;
import java.awt.event.*;


//델리게이션 이벤트 처리
class GUI3 extends JFrame  {
    JButton b;
    void init(){
        b = new JButton("자바의 버튼");

        ActionListener handler = new GUI3Handler(this);
        b.addActionListener(handler);
        add(b);
        setUI();
    }
    void setUI(){
        setTitle("GUI Test Ver 1.0");
        setVisible(true);
        setSize(300, 200);
        setLocation(200, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new GUI3().init();
    }
}