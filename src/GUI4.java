import javax.swing.*;
import java.awt.event.*;

class GUI4 extends JFrame implements ActionListener {
    JButton b;
    void init(){
        b = new JButton("자바의 버튼");
        b.addActionListener(this);
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
        new GUI4().init();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        b.setText("이벤트 처리됨! by 자신클래스");
    }
}