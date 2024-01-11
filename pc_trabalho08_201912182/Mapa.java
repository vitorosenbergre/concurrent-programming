/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 10/06/2021.
* Ultima alteracao: 18/06/2021.
* Nome do Programa: Circuito Automato.
* Classe: Mapa.
* Funcao:  Fazer o display do mapa, dos carros e dos sliders.
* Eh onde armazena as threads dos carros.
*************************************************************** */

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JLabel;

public class Mapa extends JFrame{
  
  // panel utilizado no mapa
  private ImagePanel imagePanel;

  
  // sliders dos carros
  private SliderDemo sliderCinza;
  private SliderDemo sliderMarrom;
  private SliderDemo sliderRosa;
  private SliderDemo sliderAzul;
  private SliderDemo sliderPreto;
  private SliderDemo sliderVermelho;
  private SliderDemo sliderAmarelo;
  private SliderDemo sliderVerde;


  //labels que representam os carros
  private JLabel carroCinza;
  private JLabel carroMarrom;
  private JLabel carroRosa;
  private JLabel carroAzul;
  private JLabel carroPreto;
  private JLabel carroVermelho;
  private JLabel carroAmarelo;
  private JLabel carroVerde;

  //carros, threads
  private  Carro ThreadCinza;
  private  Carro ThreadMarrom;
  private  Carro ThreadRosa;
  private  Carro ThreadAzul;
  private  Carro ThreadPreto;
  private  Carro ThreadVermelho;
  private  Carro ThreadAmarelo;
  private  Carro ThreadVerde;

  public Mapa(){
    
    imagePanel = new ImagePanel();

    this.add(imagePanel);

    carroCinza= new JLabel(new ImageIcon(getClass().getResource("carro1_180.png")));
    carroCinza.setBounds(20,60,30,50);
    imagePanel.addPanel(carroCinza);

    ThreadCinza = new Carro(carroCinza,1,1,this);
    ThreadCinza.start();

    carroMarrom = new JLabel(new ImageIcon(getClass().getResource("carro2_90.png")));
    carroMarrom.setBounds(203,22,50,30);
    imagePanel.addPanel(carroMarrom);

    ThreadMarrom = new Carro(carroMarrom,2,1,this);
    ThreadMarrom.start();

    carroRosa = new JLabel(new ImageIcon(getClass().getResource("carro3_180.png")));
    carroRosa.setBounds(400,62,30,50);
    imagePanel.addPanel(carroRosa);

    ThreadRosa = new Carro(carroRosa,3,1,this);
    ThreadRosa.start();

    carroAzul = new JLabel(new ImageIcon(getClass().getResource("carro4_180.png")));
    carroAzul.setBounds(20,227,30,50);
    imagePanel.addPanel(carroAzul);

    ThreadAzul = new Carro(carroAzul,4,1,this);
    ThreadAzul.start();

    carroPreto = new JLabel(new ImageIcon(getClass().getResource("carro5_180.png")));
    carroPreto.setBounds(279,227,30,50);
    imagePanel.addPanel(carroPreto);

    ThreadPreto = new Carro(carroPreto,5,1,this);
    ThreadPreto.start();

    carroVermelho = new JLabel(new ImageIcon(getClass().getResource("carro6_180.png")));
    carroVermelho.setBounds(520,225,30,50);
    imagePanel.addPanel(carroVermelho);

    ThreadVermelho = new Carro(carroVermelho,6,1,this);
    ThreadVermelho.start();

    carroAmarelo = new JLabel(new ImageIcon(getClass().getResource("carro7_180.png")));
    carroAmarelo.setBounds(159,418,30,50);
    imagePanel.addPanel(carroAmarelo);

    ThreadAmarelo = new Carro(carroAmarelo,7,1,this);
    ThreadAmarelo.start();

    carroVerde = new JLabel(new ImageIcon(getClass().getResource("carro8_180.png")));
    carroVerde.setBounds(400,418,30,50);
    imagePanel.addPanel(carroVerde);

    ThreadVerde = new Carro(carroVerde,8,1,this);
    ThreadVerde.start();

    sliderCinza = new SliderDemo(ThreadCinza);
    sliderMarrom = new SliderDemo(ThreadMarrom);
    sliderRosa = new SliderDemo(ThreadRosa);
    sliderAzul = new SliderDemo(ThreadAzul);
    sliderPreto = new SliderDemo(ThreadPreto);
    sliderVermelho = new SliderDemo(ThreadVermelho);
    sliderAmarelo = new SliderDemo(ThreadAmarelo);
    sliderVerde = new SliderDemo(ThreadVerde);
    

    gerarFrame();
    adicionarSlider();
  } // fim do construtor Mapa();

  /* ***************************************************************
  * Metodo: gerarFrame.
  * Funcao: adicionar caracteristicas ao frame.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void gerarFrame(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    setSize(1000,650);
    setVisible(true);
    sizeBugPatch();
    setLocationRelativeTo(null);
  } // fim do metodo gerarFrame

  /* ***************************************************************
  * Metodo: sizeBugPatch().
  * Funcao: se houver algum bug no tamanho do frame, fazer o pack dos components e contents.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  private void sizeBugPatch(){
    while(this.getWidth() > 1000){
      this.pack();
    } // fim do while
  } // fim do metodo sizeBugPatch

  
  /* ***************************************************************
  * Metodo: adicionarSlider().
  * Funcao: adicionar os sliders ao panel.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void adicionarSlider(){
    sliderCinza.setLocationSlider(920, 50);  
    sliderCinza.setSize(60, 40);
    imagePanel.add(sliderCinza.getSlider());

    sliderMarrom.setLocationSlider(920, 120);
    sliderMarrom.setSize(60, 40);
    imagePanel.add(sliderMarrom.getSlider());

    sliderRosa.setLocationSlider(920, 185);
    sliderRosa.setSize(60,40);
    imagePanel.add(sliderRosa.getSlider());

    sliderAzul.setLocationSlider(920, 255);
    sliderAzul.setSize(60, 40);
    imagePanel.add(sliderAzul.getSlider());

    sliderPreto.setLocationSlider(920, 330);
    sliderPreto.setSize(60,40);
    imagePanel.add(sliderPreto.getSlider());

    sliderVermelho.setLocationSlider(920, 400);
    sliderVermelho.setSize(60,40);
    imagePanel.add(sliderVermelho.getSlider());

    sliderAmarelo.setLocationSlider(920,475);
    sliderAmarelo.setSize(60,40);
    imagePanel.add(sliderAmarelo.getSlider());

    sliderVerde.setLocationSlider(920, 545);
    sliderVerde.setSize(60, 40);
    imagePanel.add(sliderVerde.getSlider());

  } // fim do metodo AdicionarSlider


  /* ***************************************************************
  * Metodo: alterarDirecao().
  * Funcao: alterar a posicao do carro (0,90,180,270 graus).
  * Parametros: String direcao (0,80,180,270), JLabel carroTroca(label do carro), int cor(numero representando
  * a cor do carro que vai ter a posicao alterada).
  * Retorno: nenhum.
  *************************************************************** */
  public void alterarDirecao(String direcao,JLabel carroTroca,int cor){
    if(cor==1){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro1_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro1_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro1_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro1_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } //fim do switch
    } //fim do if
    if(cor==2){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro2_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro2_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro2_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro2_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if
    if(cor==3){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro3_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro3_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro3_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro3_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if

    if(cor==4){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro4_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro4_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro4_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro4_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if

    if(cor==5){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro5_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro5_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro5_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro5_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if

    if(cor==6){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro6_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro6_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro6_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro6_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if

    if(cor==7){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro7_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro7_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro7_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro7_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if

    if(cor==8){
      switch(direcao){
        case"0":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("carro8_0.png"));
          carroTroca.setIcon(imageTemporaria);
          break;
        case"90":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("carro8_90.png"));
          carroTroca.setIcon(imageTemporaria2);
          break;
        case"180":
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("carro8_180.png"));
          carroTroca.setIcon(imageTemporaria3);
          break;
        case"270":
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("carro8_270.png"));
          carroTroca.setIcon(imageTemporaria4);
          break;
      } // fim do switch
    }// fim do if

  } // fim do metodo AlterarDirecao
} // fim da class Mapa