
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Movimento extends Thread {

  private JLabel lTrem1;
  private JLabel lTrem2;
  private JFrame frame;

  public Movimento(JLabel lTrem1, JLabel lTrem2, JFrame frame){
    this.lTrem1 = lTrem1;
    this.lTrem2 = lTrem2;
    this.frame = frame;

  }

  public void run(){
    while(true){
      try {
        sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
        if(lTrem1.getX()<1100){
          lTrem1.setBounds(lTrem1.getX()+1,0, 200,200);
          frame.add(lTrem1);
        }
        if(lTrem2.getX()<1100){
          lTrem2.setBounds(lTrem2.getX()+2,250, 200,200);
          frame.add(lTrem2);
        }
    }
  }
}
