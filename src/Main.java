import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class driver {

    public static void main(String[] args) {
        FTGUI g = new FTGUI();
    }

}
import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;


public class FTBTNHandler implements ActionListener {

    FTGUI li;

    public FTBTNHandler(FTGUI g) {
        li = g;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Read My Fortune")) {
            String s = "A secret admirer will soon send you a sign of affection.\nYour heart is in a place to draw true happiness.\nA thrilling time is in your near future.\nThe one you love is closer than you think.\nPlan for many pleasures ahead.\nSomething you lost will turn up soon. ";
            li.txtArea.setText(s);
        }
        if (ae.getActionCommand().equals("Quit")) {

            li.fr.dispose();
        }
    }
}
import java.awt.Color;
        import java.awt.Font;
        import java.awt.TextArea;
        import javax.swing.ImageIcon;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JPanel;


public class FTGUI {

    JFrame fr;
    JButton read;
    JButton quit;
    JLabel introduction, pic;
    TextArea txtArea;
    JPanel introPanel;
    JPanel startPanel;
    ImageIcon bg;
    FTBTNHandler hnd;

    public FTGUI() {
        initFTGUI();
    }

    public void initFTGUI() {
        fr = new JFrame("Fortune Teller");
        fr.setLayout(null);
        fr.setSize(600, 500);
        hnd = new FTBTNHandler(this);

        txtArea = new TextArea();
        txtArea.setBounds(20, 150, 560, 200);
        txtArea.setFont(new Font("Arial", Font.BOLD, 15));

//starting panel
        startPanel = new JPanel();
        startPanel.setLayout(null);
        startPanel.setOpaque(false);
        startPanel.setSize(600, 500);
        //adding intro panel

        introPanel = new JPanel();
        introPanel.setLayout(null);
        introPanel.setSize(600, 100);

        read = new JButton("Read My Fortune");
        read.setBounds(300, 400, 150, 30);
        read.addActionListener(hnd);
        read.setFocusPainted(false);
        read.setBackground(Color.WHITE);

        quit = new JButton("Quit");
        quit.setBounds(150, 400, 100, 30);
        quit.setFocusPainted(false);

        quit.setBackground(Color.WHITE);
        quit.addActionListener(hnd);

        introduction = new JLabel("Fortune Teller");
        introduction.setFont(new Font("Tahoma Bold", Font.BOLD, 40));
        introduction.setForeground(Color.BLACK);
        introduction.setBounds(220, 0, 300, 100);

        bg = new ImageIcon("ftp.png");
        pic = new JLabel(bg);
        pic.setBounds(120, 0, bg.getIconWidth(), bg.getIconHeight());

        introPanel.setBounds(0, 20, 600, 100);
        introPanel.add(pic);
        introPanel.add(introduction);

        startPanel.add(introPanel);
        startPanel.add(read);
        startPanel.add(quit);
        startPanel.add(txtArea);

        fr.setContentPane(startPanel);

        fr.setLocation(250, 150);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
