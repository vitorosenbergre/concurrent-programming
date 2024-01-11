
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JogoTrem extends JFrame{
  
  private JLabel lTrem = new JLabel(new ImageIcon(getClass().getResource("Trem 1 Redimensionado.png"))); 
  private JLabel lTrem2 = new JLabel(new ImageIcon(getClass().getResource("Trem 2 Redimensionado.png"))); 
  
  private static final long serialVersionUID = 1L;

  public JogoTrem(){
    editarTela(); 
    new Movimento(lTrem,lTrem2,this).start(); 
  }

  public void editarTela(){
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(1300,500);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setLayout(null);
    lTrem.setBounds(0, 0, 200, 200);
    lTrem2.setBounds(0, 250, 200, 200);
    this.add(lTrem);
    this.add(lTrem2);
    
  }

}
