import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerWithJPanel extends JFrame
{
  public TimerWithJPanel()
  {
    super("My Frame");
    setContentPane(new DrawPane());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 675);
    setResizable(false);
    setVisible(true);
  }

  class DrawPane extends JPanel
  {
    Timer timer = new Timer(1000, new MyTimer());

    @Override
    public void paintComponent(Graphics g)
    {
      //Paint stuff
      super.paintComponent(g);

      timer.start();

      for(int i = 0; i < 1000; i += 110)
      {
        g.fillRect(i, 10, 100, 100);

        try{Thread.sleep(100);}
        catch(InterruptedException ie){}
      }

      timer.stop();
    }
  }

  class MyTimer implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      //Loop stuff
      repaint();
    }
  }

  public static void main(String[] args)
  {
    new TimerWithJPanel();
  }
}