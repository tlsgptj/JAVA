import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI extends JFrame {
    JButton b;
    //어떤 컴포넌트가 주체가 될 것인지
    void init(){
        b = new JButton("자바의 버튼");
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("이벤트 처리됨! by 무명내부클래스");
            } //바디 만들어주고 오버라이딩을 해야함 (자식클래스를 만들지 않고도 사용가능)
        };
        b.addActionListener(l);
        add(b);
        setUI();
    }

    void setUI() {
        setTitle("GUI Test Ver 1.0");
        setVisible(true);
        setSize(300, 200);
        setLocation(200, 100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } //컨테이너를 꾸미는 것

    public static void main(String[] args) {
        new GUI().init();
    }

    //이렇게도 가능함 클래스 독립도 가능함
    class A3handler implements ActionListener {
        GUI a3;
        A3handler(GUI a3) {
            this.a3 = a3;
        }
        public void actionPerformed(ActionEvent e) {
            //Object obj = e.getSource();
            //JButton b = (JButton)obj;
            b.setText("처리됨");
            a3.setTitle("크리스마스");
        }
    }
}
