/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 10/06/2021
* Ultima alteracao: 18/06/2021
* Nome do Programa: Circuito Automato.
* Classe: ImagePanel
* Funcao: Faz o papel do panel, inserido no mapa.
*************************************************************** */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

  // variavel responsavel por armazenar o mapa.
  private BufferedImage image;

  public ImagePanel() {
    try {                
      image = ImageIO.read(this.getClass().getResource("circuitolindao.png"));
    } catch (IOException ex) { // fim do try
      System.out.println("nao imprimiu");
    } //fim do catch
      gerarPanel();
  } // fim do construtor ImagePanel

  /* ***************************************************************
  * Metodo: gerarPanel.
  * Funcao: gerar o panel onde vai ser adicionado os components.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void gerarPanel(){
    this.setBackground(new Color(0,0,0)); 
    this.setSize(1000,650);                        
    this.setLayout(null);
  } // fim do metodo gerarPanel

  /* ***************************************************************
  * Metodo: addPanel.
  * Funcao: adicionar components no Jpanel.
  * Parametros: JComponent comp.
  * Retorno: nenhum.
  *************************************************************** */
  public void addPanel(JComponent comp){
    this.add(comp);
  } // fim do metodo addPanel

  /* ***************************************************************
  * Metodo: paintComponent.
  * Funcao: inserir uma imagem no panel com o graphics. 
  * Parametros: Graphics g.
  * Retorno: nenhum.
  *************************************************************** */
  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, this);       
  } // fim do metodo paintComponent
} // fim da class ImagePanel.