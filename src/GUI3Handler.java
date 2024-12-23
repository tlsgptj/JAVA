import javax.swing.*;
import java.awt.event.*;
//분리도 가능함
// 셀프 이벤트 모델
class GUI3Handler implements ActionListener {
    GUI3 a3;

    GUI3Handler(GUI3 a3) {
        this.a3 = a3;
    }

    public void actionPerformed(ActionEvent e) {
        //Object obj = e.getSource();
        //JButton b = (JButton)obj;
        a3.b.setText("이벤트 처리됨! by 제3클래스");
        a3.setTitle("메리 크리스마스~^^");
    }
}