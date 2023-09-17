import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InhaltGUI extends  JFrame{
    private JPanel JPanelMain2;
    private JTextArea textArea1;
    private JButton button1;

    public InhaltGUI() {

        add(JPanelMain2);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Schließen Sie das aktuelle Fenster
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(button1);
                topFrame.dispose();
            }
        });

    }

    public void setVis(){
        setTitle("Test");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(300,200,300,400);

        setVisible(true);
    }

    public void setPos(int x, int y, int w, int h){
        setBounds(x,y,w,h);
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(String text) {
        this.textArea1.setText(text);
    }

    public void setMyTitle(String fileName){
        setTitle(fileName);
    }
}
