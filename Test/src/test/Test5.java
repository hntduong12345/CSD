package test;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.*;
import java.awt.event.*;

public class Test5 extends Frame implements WindowListener, ActionListener{
    final JTextField text = new JTextField();
    final JPasswordField value = new JPasswordField();
    
    public static void main(String[] args) {
        Test5 t = new Test5("Pass demo");
        
    }

    public Test5(String str){
        super(str);
        
        value.setBounds(100, 90, 100, 30);
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(20, 40, 80, 30);
        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 90, 80, 30);
        JButton b = new JButton("Login");
        b.setBounds(100, 150, 80, 30);
        text.setBounds(100, 40, 100, 30);
        add(value);
        add(l1);
        add(l2);
        add(b);
        add(text);
        setSize(280, 200);
        setLayout(new BorderLayout());
        addWindowListener(this);
        setVisible(true);
        b.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        System.out.println(text.getText());
        System.out.println(new String(value.getPassword()));
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(false);
    }

}
