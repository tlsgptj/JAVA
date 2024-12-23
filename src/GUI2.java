import javax.swing.*;
import java.awt.event.*;

class GUI2 extends JFrame  {
    JButton b;
    void init(){
        b = new JButton("자바의 버튼");
		/*ActionListener handler = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("이벤트 처리됨! by 무명내부클래스");
			}
		};
		b.addActionListener(handler);*/

		/*b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("이벤트 처리됨! by 무명내부클래스");
			}
		});*/

        b.addActionListener(e -> b.setText("이벤트 처리됨! by 무명내부클래스"));
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
        new GUI2().init();
    }
}
