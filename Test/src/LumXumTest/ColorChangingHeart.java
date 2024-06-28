package LumXumTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ColorChangingHeart extends JFrame implements ActionListener {

//    JPanel p = new JPanel();
    Drawing dr = new Drawing();
    String actionChangeColor = "Start";
    String actionStop = "Stop";
    JButton bColor, bStop;
    
    /* Driver Code */
    public ColorChangingHeart() {
        super("Color Button Test");

//        dr.setPreferredSize(new Dimension(500, 400));
        dr.setBounds(0, 0, 500, 400);

        
//        p.setBackground(Color.BLACK);
//        p.setBounds(50, 50, 380, 300);

        //Create button
        this.add(bColor = createButton(actionChangeColor, "Start"));
        this.add(bStop = createButton(actionStop, "Stop"));
        bColor.setBounds(150, 400, 200, 50);
        bColor.setVisible(true);
        bStop.setBounds(150, 400, 200, 50);
        bStop.setVisible(false);

        this.setBackground(Color.RED);
        this.add(dr);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // create JButton with text is btnName and add ActionListener
    private JButton createButton(String action, String btnName) {
        JButton btn = new JButton(btnName);
        btn.setActionCommand(action);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        //Start changing color of the panel.
        if (actionChangeColor.equals(command)) {
            ActionListener taskPerformer = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    dr.changeTheColor();
                }
            };
            Timer timer = new Timer(800, taskPerformer);
            timer.setRepeats(true);
            timer.start();
            bColor.setVisible(false);
            bStop.setVisible(true);
        }

        //Stop progress.
        if (actionStop.equals(command)) {
            dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ColorChangingHeart obj = new ColorChangingHeart();
        obj.setVisible(true);
    }
}
