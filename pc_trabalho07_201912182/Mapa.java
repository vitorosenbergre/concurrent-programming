/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 03/06/2021.
* Ultima alteracao: 05/06/2021.
* Classe: Mapa
* Funcao: Fazer o display do mapa, dos labels, dos jogadores e dos sliders.
*************************************************************** */
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mapa extends JFrame{


  //panel
  JPanel panel = new JPanel();

  // sliders Descansar
  private SliderDemo sliderDescansar;
  private SliderDemo slider2Descansar;
  private SliderDemo slider3Descansar;
  private SliderDemo slider4Descansar;
  private SliderDemo slider5Descansar;

  // sliders jogar
  private SliderDemo sliderJogar;
  private SliderDemo slider2Jogar;
  private SliderDemo slider3Jogar;
  private SliderDemo slider4Jogar;
  private SliderDemo slider5Jogar;

  //labels estados
  private JLabel labelEstado1;
  private JLabel labelEstado2;
  private JLabel labelEstado3;
  private JLabel labelEstado4;
  private JLabel labelEstado5;

  // labels indicativos
  private JLabel labelJogar;
  private JLabel labelDescansar;
  private JLabel labelJogador1;
  private JLabel labelJogador2;
  private JLabel labelJogador3;
  private JLabel labelJogador4;
  private JLabel labelJogador5;

  // labels mesa 362x360
  private JLabel labelMesa;

  //jogadores
  private JLabel jogador1;
  private JLabel jogador2;
  private JLabel jogador3;
  private JLabel jogador4;
  private JLabel jogador5;

  //"garfos", controles switch
  private JLabel controle1;
  private JLabel controle2;
  private JLabel controle3;
  private JLabel controle4;
  private JLabel controle5;
  

  //"pratos", controles completos
  private JLabel controleCompleto1;
  private JLabel controleCompleto2;
  private JLabel controleCompleto3;
  private JLabel controleCompleto4;
  private JLabel controleCompleto5;

  public Mapa(){

    // *labels que atualizam e mostram os estados de cada jogador

    labelEstado1 = new JLabel("Descansando");
    labelEstado1.setBounds(525,17,100,100);

    labelEstado2 = new JLabel("Descansando");
    labelEstado2.setBounds(670,105,100,100);

    labelEstado3 = new JLabel("Descansando");
    labelEstado3.setBounds(680,277,100,100);

    labelEstado4 = new JLabel("Descansando");
    labelEstado4.setBounds(380,280,100,100);

    labelEstado5 = new JLabel("Descansando");
    labelEstado5.setBounds(380, 112, 100, 100);

    //----------------------------------------------

    // *Labels que indicam os sliders responsaveis por controlar a velocidade de descansar e jogar

    labelJogar = new JLabel("Jogar");
    labelJogar.setBounds(230, 0, 100, 100);

    labelDescansar = new JLabel("Descansar");
    labelDescansar.setBounds(100,0,100,100);

    //----------------------------------------------

    // *labels que indica a qual jogador pertence os sliders

    labelJogador1 = new JLabel("Jogador1");
    labelJogador1.setBounds(10, 50,100,100);

    labelJogador2 = new JLabel("Jogador2");
    labelJogador2.setBounds(10, 150,100,100);

    labelJogador3 = new JLabel("Jogador3");
    labelJogador3.setBounds(10, 250,100,100);

    labelJogador4 = new JLabel("Jogador4");
    labelJogador4.setBounds(10, 350,100,100);

    labelJogador5 = new JLabel("Jogador5");
    labelJogador5.setBounds(10, 450,100,100);

    //---------------------------------------------
    
    // *Label que representa a mesa.

    labelMesa = new JLabel(new ImageIcon(getClass().getResource("a.png")));
    labelMesa.setBounds(420,150,270,269);

    //---------------------------------------------

    // *Labels que representam os jogadores (herois da marvel)

    jogador1 = new JLabel(new ImageIcon(getClass().getResource("filosofo_1.png")));
    jogador1.setBounds(515,70,80,104);

    jogador2 = new JLabel(new ImageIcon(getClass().getResource("filosofo_2.png")));
    jogador2.setBounds(365,175,87,109);
   
    jogador3 = new JLabel(new ImageIcon(getClass().getResource("filosofo_3.png")));
    jogador3.setBounds(400,335,84,103); 

    jogador4 = new JLabel(new ImageIcon(getClass().getResource("filosofo_4.png")));
    jogador4.setBounds(625,335,87,101); 

    jogador5 = new JLabel(new ImageIcon(getClass().getResource("filosofo_5.png")));
    jogador5.setBounds(655,175,100,102);

    //---------------------------------------------

    // *controles switch, "garfos"
    controle5 = new JLabel(new ImageIcon(getClass().getResource("controle_1_redimensionado.png")));
    controle5.setBounds(485,170,21,45);
    
    controle1 = new JLabel(new ImageIcon(getClass().getResource("controle_2_redimensionado.png")));
    controle1.setBounds(600,171,21,45);
    
    controle4= new JLabel(new ImageIcon(getClass().getResource("controle_1_redimensionado_ladoOposto.png")));
    controle4.setBounds(450,290,45,21);

    controle2 = new JLabel(new ImageIcon(getClass().getResource("controle_1_redimensionado_ladoOposto.png")));
    controle2.setBounds(620,290,45,21);

    controle3 = new JLabel(new ImageIcon(getClass().getResource("controle_2_redimensionado.png")));
    controle3.setBounds(550,368,21,45);

    //-----------------------------------------------

    // *controles completos, "pratos"
    controleCompleto1 = new JLabel(new ImageIcon(getClass().getResource("b.png")));
    controleCompleto1.setBounds(525,170,53,40);

    controleCompleto2 = new JLabel(new ImageIcon(getClass().getResource("controle_ladoOposto.png")));
    controleCompleto2.setBounds(620,220,40,53);

    controleCompleto3 = new JLabel(new ImageIcon(getClass().getResource("b.png")));
    controleCompleto3.setBounds(580,325,53,40);

    controleCompleto4 = new JLabel(new ImageIcon(getClass().getResource("b.png")));
    controleCompleto4.setBounds(480,325,53,40);
    
    controleCompleto5 = new JLabel(new ImageIcon(getClass().getResource("controle_ladoOposto.png")));
    controleCompleto5.setBounds(440,220,40,53);
    
    //-----------------------------------------------

    // *sliders responsaveis pela velocidade de descanso, "pensar"
    sliderDescansar = new SliderDemo(null,"descansar");
    slider2Descansar = new SliderDemo(null,"descansar");
    slider3Descansar = new SliderDemo(null,"descansar");
    slider4Descansar = new SliderDemo(null,"descansar");
    slider5Descansar = new SliderDemo(null,"descansar");

    //-----------------------------------------------

    // *sliders reponsaveis pela velocidade de jogo, "comer"
    sliderJogar = new SliderDemo(null,"jogar");
    slider2Jogar = new SliderDemo(null,"jogar");
    slider3Jogar = new SliderDemo(null,"jogar");
    slider4Jogar = new SliderDemo(null,"jogar");
    slider5Jogar = new SliderDemo(null,"jogar");

    //-----------------------------------------------

    gerarFrame();
    gerarPanel();
    adicionarSlider();

    //-----------------------------------------------

    // *Adicionando os labels no panel

    panel.add(labelJogar);
    panel.add(labelDescansar);
    panel.add(labelJogador1);
    panel.add(labelJogador2);
    panel.add(labelJogador3);
    panel.add(labelJogador4);
    panel.add(labelJogador5);
    // estados
    panel.add(labelEstado1);
    panel.add(labelEstado2);
    panel.add(labelEstado3);
    panel.add(labelEstado4);
    panel.add(labelEstado5);
    //controles
    panel.add(controle1);
    panel.add(controle2);
    panel.add(controle3);
    panel.add(controle4);
    panel.add(controle5);
    //controles completos
    panel.add(controleCompleto1);
    panel.add(controleCompleto2);
    panel.add(controleCompleto3);
    panel.add(controleCompleto4);
    panel.add(controleCompleto5);
    //jogadores/mesa
    panel.add(jogador3);
    panel.add(jogador4);
    panel.add(labelMesa);
    panel.add(jogador1);
    panel.add(jogador2);
    panel.add(jogador5);
    
    sizeBugPatch();
    
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
    setSize(800,600);
    setVisible(true);
    sizeBugPatch();
    setLocationRelativeTo(null);
  } // fim do metodo gerarFrame

 /* ***************************************************************
  * Metodo: gerarPanel.
  * Funcao: adicionar caracteristicas ao panel.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void gerarPanel(){
    panel.setBackground(new Color(0,255,255));             
    panel.setSize(800,600);                        
    panel.setLayout(null);
    this.add(panel);
  } // fim do metodo gerarPanel

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
  * Funcao: adicionar os sliders que controlam as velocidades de cada jogador ao panel.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void adicionarSlider(){

    // sliders Descansar
    sliderDescansar.setLocationSlider(100, 80);  
    sliderDescansar.setSize(60, 40);
    panel.add(sliderDescansar.getSlider());

    slider2Descansar.setLocationSlider(100, 180);
    slider2Descansar.setSize(60, 40);
    panel.add(slider2Descansar.getSlider());

    slider3Descansar.setLocationSlider(100, 280);
    slider3Descansar.setSize(60,40);
    panel.add(slider3Descansar.getSlider());

    slider4Descansar.setLocationSlider(100, 380);
    slider4Descansar.setSize(60, 40);
    panel.add(slider4Descansar.getSlider());

    slider5Descansar.setLocationSlider(100, 480);
    slider5Descansar.setSize(60,40);
    panel.add(slider5Descansar.getSlider());
    
    // slider jogar 
    sliderJogar.setLocationSlider(220, 80);
    sliderJogar.setSize(60,40);
    panel.add(sliderJogar.getSlider());

    slider2Jogar.setLocationSlider(220,180);
    slider2Jogar.setSize(60,40);
    panel.add(slider2Jogar.getSlider());

    slider3Jogar.setLocationSlider(220, 280);
    slider3Jogar.setSize(60, 40);
    panel.add(slider3Jogar.getSlider());

    slider4Jogar.setLocationSlider(220, 380);
    slider4Jogar.setSize(60, 40);
    panel.add(slider4Jogar.getSlider());

    slider5Jogar.setLocationSlider(220, 480);
    slider5Jogar.setSize(60, 40);
    panel.add(slider5Jogar.getSlider());
  } // fim do metodo adicionarSlider

  /* ***************************************************************
  * Metodo: alterarVisibilidadeControles.
  * Funcao: altera a visibilidade dos controles "garfos", deixando visivel ou tirando sua visibilidade.
  * Parametros: int index (numero do controle), String estado (deixar ou tirar a visibilidade).
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void alterarVisibilidadeControles(int index, String estado){
    if(estado =="false"){
      switch(index){
        case 0:
          controle1.setVisible(false);
          break;
        case 1:
          controle2.setVisible(false);
          break;
        case 2:
          controle3.setVisible(false);
          break;
        case 3:
          controle4.setVisible(false);
          break;
        case 4:
          controle5.setVisible(false);
          break;
      } // fim do switch
    } // fim do if

    if(estado =="true"){
      switch(index){
        case 0:
          controle1.setVisible(true);
          break;
        case 1:
          controle2.setVisible(true);
          break;
        case 2:
          controle3.setVisible(true);
          break;
        case 3:
          controle4.setVisible(true);
          break;
        case 4:
          controle5.setVisible(true);
          break;
      } // fim do switch
    } // fim do if
  } // fim do metodo alterarVisibilidadeControles

  /* ***************************************************************
  * Metodo: alterarControleCompleto
  * Funcao: "liga" ou "desliga" o controle principal (prato), recebendo uma String "true" se for ligar e "false" se for desligar.
  * Parametros: int index(numero do controle), String estado (ligar ou desligar).
  * Retorno: nao retorna nada, eh um void.
  *************************************************************** */
  public void alterarControleCompleto(int index, String estado){
   
    if(estado == "true"){
      switch(index){
        case 0:
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("controle_usando_1_redimensionado.png"));
          controleCompleto1.setIcon(imageTemporaria);
          break;
        case 1:
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("controle_usando_1_redimensionado_ladoOposto.png"));
          controleCompleto2.setIcon(imageTemporaria2);
          break;
        case 2:
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("controle_usando_1_redimensionado.png"));
          controleCompleto3.setIcon(imageTemporaria3);
          break;
        case 3:
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("controle_usando_1_redimensionado.png"));
          controleCompleto4.setIcon(imageTemporaria4);
          break;
        case 4:
          ImageIcon imageTemporaria5 = new ImageIcon(getClass().getResource("controle_usando_1_redimensionado_ladoOposto.png"));
          controleCompleto5.setIcon(imageTemporaria5);
          break;
      } // fim do switch
    } // fim do if

    if(estado == "false"){
      switch(index){
        case 0:
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("b.png"));
          controleCompleto1.setIcon(imageTemporaria);
          break;
        case 1:
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("controle_ladoOposto.png"));
          controleCompleto2.setIcon(imageTemporaria2);
          break;
        case 2:
          ImageIcon imageTemporaria3 = new ImageIcon(getClass().getResource("b.png"));
          controleCompleto3.setIcon(imageTemporaria3);
          break;
        case 3:
          ImageIcon imageTemporaria4 = new ImageIcon(getClass().getResource("b.png"));
          controleCompleto4.setIcon(imageTemporaria4);
          break;
        case 4:
          ImageIcon imageTemporaria5 = new ImageIcon(getClass().getResource("controle_ladoOposto.png"));
          controleCompleto5.setIcon(imageTemporaria5);
          break;
      } // fim do switch
    } // fim do if
  } // fim do metodo alterarControleCompleto

  /* ***************************************************************
  * Metodo: setarJogador.
  * Funcao: setar o valor da variavel Jogador jogador da classe SliderDemo.
  * Parametros: Jogador jogador (O jogador que vai substituir), int index (qual slider ele vai ocupar).
  * Retorno: nao retorna nada, eh um void.
  *************************************************************** */
  public void setarJogador(Jogador jogador, int index){
    switch(index){
      case 0:
        sliderJogar.setJogador(jogador);
        sliderDescansar.setJogador(jogador);
        break;
      case 1:
        slider2Jogar.setJogador(jogador);
        slider2Descansar.setJogador(jogador);
        break;
      case 2:
        slider3Jogar.setJogador(jogador);
        slider3Descansar.setJogador(jogador);
        break;
      case 3:
        slider4Jogar.setJogador(jogador);
        slider4Descansar.setJogador(jogador);
        break;
      case 4:
        slider5Jogar.setJogador(jogador);
        slider5Descansar.setJogador(jogador);
        break;
    } // fim do switch
  } // fim do metodo setarJogador

  /* ***************************************************************
  * Metodo: alterarEstado
  * Funcao: alterar o texto (estado) das variaveis labelEstado(i), cada label representa o estado de cada Jogador.
  * Parametros: String estado (descansando, procurando, jogando), int index (numero do jogador).
  * Retorno: nao retorna nada eh um void.
  *************************************************************** */
  public void alterarEstado(String estado, int index){
    if(estado =="descansando"){
      switch(index){
        case 0:
          labelEstado1.setText("Descansando");
          break;
        case 1:
          labelEstado2.setText("Descansando");
          break;
        case 2:
          labelEstado3.setText("Descansando");
          break;
        case 3:
          labelEstado4.setText("Descansando");
          break;
        case 4:
          labelEstado5.setText("Descansando");
          break;
      } // fim do switch
    } // fim do if
    if(estado=="procurando"){
      switch(index){
        case 0:
          labelEstado1.setText("Procurando");
          break;
        case 1:
          labelEstado2.setText("Procurando");
          break;
        case 2:
          labelEstado3.setText("Procurando");
          break;
        case 3:
          labelEstado4.setText("Procurando");
          break;
        case 4:
          labelEstado5.setText("Procurando");
          break;
      } // fim do switch
    } // fim do if
    if(estado =="jogando"){
      switch(index){
        case 0:
          labelEstado1.setText("Jogando");
          break;
        case 1:
          labelEstado2.setText("Jogando");
          break;
        case 2:
          labelEstado3.setText("Jogando");
          break;
        case 3:
          labelEstado4.setText("Jogando");
          break;
        case 4:
          labelEstado5.setText("Jogando");
          break;
      } // fim do switch
    }// fim do if
  } // fim do metodo alterarEstado

} // fim da class Mapa