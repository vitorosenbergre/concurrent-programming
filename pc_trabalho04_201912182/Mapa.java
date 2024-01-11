/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 11/04/2021.
* Ultima alteracao: 17/04/2021.
* Classe: Mapa.
* Funcao: Criar a parte grafica do circuito e fazer algumas alteracoes na thread.
*************************************************************** */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mapa extends JFrame implements ActionListener{

  private static final long serialVersionUID = 1L;
  
  // label que representa os trilhos
  private JLabel trilhos = new JLabel(new ImageIcon(getClass().getResource("Trilhos.png")));

  // labels que representam os trens
  private JLabel lTrem1 = new JLabel(new ImageIcon(getClass().getResource("Trem.png")));
  private JLabel lTrem2 = new JLabel(new ImageIcon(getClass().getResource("Trem2.png")));

  // labels que sao responsaveis indicar qual trem esta sendo alterado a velocidade
  private JLabel labelVelocidadetrem1 = new JLabel("Velocidade trem 1");
  private JLabel labelVelocidadetrem2 = new JLabel("Velocidade trem 2");

  // botoes utilizados na velocidade do trem1
  private JButton botaoAumentarVelocidadeTrem1 = new JButton(new ImageIcon(getClass().getResource("BotaoAumentarTrem1.png")));
  private JButton botaoMostraVelocidadeTrem1 = new JButton(new ImageIcon(getClass().getResource("1.png")));
  private JButton botaoDiminuirVelocidadeTrem1 = new JButton(new ImageIcon(getClass().getResource("BotaoDiminuirTrem1.png")));
  
  // botoes utilizados na velocidade do trem2
  private JButton botaoAumentarVelocidadeTrem2 = new JButton(new ImageIcon(getClass().getResource("BotaoAumentarTrem2.png")));
  private JButton botaoMostraVelocidadeTrem2 = new JButton(new ImageIcon(getClass().getResource("1trem2.png")));
  private JButton botaoDiminuirVelocidadeTrem2= new JButton(new ImageIcon(getClass().getResource("BotaoDiminuirTrem2.png")));
  
  // bandeiras posicionadas no mapa
  private JLabel bandeira = new JLabel(new ImageIcon(getClass().getResource("BandeiraIdaVerde.png")));
  private JLabel bandeira2 = new JLabel(new ImageIcon(getClass().getResource("BandeiraVerdeVolta.png")));
  private JLabel bandeira3 = new JLabel(new ImageIcon(getClass().getResource("BandeiraIdaVerde.png")));
  private JLabel bandeira4 = new JLabel(new ImageIcon(getClass().getResource("BandeiraVerdeVolta.png")));

  // estrada que os dois trens utilizam
  private Estrada estrada = new Estrada();

  // panel para armazenar os contents
  private JPanel panel = new JPanel();

  // as threads dos trens
  private Trem1 trem1 = new Trem1(lTrem1,estrada,this);
  private Trem2 trem2 = new Trem2(lTrem2,estrada,this);
 
  
  public Mapa(){
    gerarFrame();
    gerarPanel();
    adicionarBandeiras(); 
    adicionarTrem1();
    adicionarTrem2();
    adicionarTrilhos();
    adicionarBotaoTrem1();
    adicionarBotaoTrem2();
  }// fim do construtor

  /* ***************************************************************
  * Metodo: gerarFrame.
  * Funcao: adicionar caracteristicas ao frame.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void gerarFrame(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    setSize(1000,500);
    setVisible(true);
    sizeBugPatch();
    setLocationRelativeTo(null);
  } // fim do metodo gerarFrame

   /* ***************************************************************
  * Metodo: sizeBugPatch.
  * Funcao: As vezes no linux o frame fica muito pequeno por conta do setResizable(false), e o pack() lida com
  * setResizable(boolean). 
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  private void sizeBugPatch(){
    while(this.getWidth() > 1000){
      this.pack();
    } // fim do while
  } // fim do metodo sizeBugPatch

  /* ***************************************************************
  * Metodo: gerarPanel.
  * Funcao: adicionar caracteristicas ao panel.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void gerarPanel(){
    panel.setBackground(new Color(0,255,255));             
    panel.setSize(1000,500);                        
    panel.setLayout(null);
    this.add(panel);
  } // fim do metodo gerarPanel

  /* ***************************************************************
  * Metodo: adicionarTrilhos.
  * Funcao: adiciona ao panel o label que vai caracterizar os trilhos.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void adicionarTrilhos(){
    trilhos.setSize(1000,500);
    panel.add(trilhos);
  } // fim do metodo adicionarTrilhos

  /* ***************************************************************
  * Metodo: adicionarTrem1.
  * Funcao: adiciona ao panel o label que vai caracterizar o Trem1 e vai iniciar a thread.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void adicionarTrem1(){
    lTrem1.setBounds(20,78, 100,40);
    panel.add(lTrem1);
    trem1.start();
  } // fim do metodo adicionarTrem1

  /* ***************************************************************
  * Metodo: adicionarTrem2.
  * Funcao: adiciona ao panel o label que vai caracterizar o Trem2 e vai iniciar a thread.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void adicionarTrem2(){
    lTrem2.setBounds(886,405,100,40);
    panel.add(lTrem2);
    trem2.start();
  } // fim do metodo adicionarTrem2
  
  /* ***************************************************************
  * Metodo: adicionarBandeiras.
  * Funcao: adiciona ao panel os labels que vao caracterizar as bandeiras.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void adicionarBandeiras(){
    // bandeira 1
    bandeira.setBounds(310,165,30,70);
    panel.add(bandeira);
    // bandeira 2
    bandeira2.setBounds(360,165,30,70);
    panel.add(bandeira2);
    //bandeira 3
    bandeira3.setBounds(710,170,30,70);
    panel.add(bandeira3);
    //bandeira 4
    bandeira4.setBounds(770,170,30,70);
    panel.add(bandeira4);
  } // fim do metodo adicionarBandeiras

  /* ***************************************************************
  * Metodo: adicionarBotaoTrem1.
  * Funcao: adiciona ao panel os botoes para regular a velocidade do trem 1, um botao para aumentar outro para
  * diminuir a velocidade.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void adicionarBotaoTrem1(){
    // botaoDiminuirVelocidade do trem1
    botaoDiminuirVelocidadeTrem1.setBounds(30,230,25,25);
    botaoDiminuirVelocidadeTrem1.addActionListener(this);
    panel.add(botaoDiminuirVelocidadeTrem1);

    // botaoMostraVelocidade do trem1
    botaoMostraVelocidadeTrem1.setBounds(65,230,25,25);
    botaoMostraVelocidadeTrem1.addActionListener(this);
    panel.add(botaoMostraVelocidadeTrem1);
    
    // botaoAumentarVelocidade do trem1
    botaoAumentarVelocidadeTrem1.setBounds(100,230,25,25);
    botaoAumentarVelocidadeTrem1.addActionListener(this);
    panel.add(botaoAumentarVelocidadeTrem1);

    // label que vai mostrar de qual trem sao os botoes, nesse caso do trem1
    labelVelocidadetrem1.setBounds(30,160,150,100);
    panel.add(labelVelocidadetrem1);
  }// fim do metodo adicionarBotaoTrem1

  /* ***************************************************************
  * Metodo: adicionarBotaoTrem2.
  * Funcao: adiciona ao panel os botoes para regular a velocidade do trem 2, um botao para aumentar outro para
  * diminuir a velocidade.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void adicionarBotaoTrem2(){

    // botaoDiminuirVelocidade do trem2
    botaoDiminuirVelocidadeTrem2.setBounds(30,320,25,25);
    botaoDiminuirVelocidadeTrem2.addActionListener(this);
    panel.add(botaoDiminuirVelocidadeTrem2);

    // botaoMostraVelocidade do trem2
    botaoMostraVelocidadeTrem2.setBounds(65,320,25,25);
    botaoMostraVelocidadeTrem2.addActionListener(this);
    panel.add(botaoMostraVelocidadeTrem2);

    // botaoAumentarVelocidade do trem2
    botaoAumentarVelocidadeTrem2.setBounds(100,320,25,25);
    botaoAumentarVelocidadeTrem2.addActionListener(this);
    panel.add(botaoAumentarVelocidadeTrem2);
    
    // label que vai mostrar de qual trem sao os botoes, nesse caso do trem2
    labelVelocidadetrem2.setBounds(30,250,150,100);
    panel.add(labelVelocidadetrem2);
  } // fim do metodo adicionarBotaoTrem2

  // * Valores de cada velocidade:
  // * Velocidade 1 = 50, Velocidade 2 = 40, Velocidade 3 = 30, Velocidade 4 = 20, Velocidade 5 = 10.

  /* ***************************************************************
  * Metodo: aumentarVelocidade.
  * Funcao: aumenta a velocidade recebida do trem em 10.
  * Parametros: um inteiro, representando a velocidade recebida.
  * Retorno: retorna um inteiro, representando a velocidade alterada.
  *************************************************************** */
  public int aumentarVelocidade(int velocidade){
    switch(velocidade){
      case 50:
        velocidade = velocidade-10;
        return velocidade;
      case 40:
        velocidade = velocidade-10;
        return velocidade;
      case 30:
        velocidade = velocidade-10;
        return velocidade;
      case 20:
        velocidade = velocidade-10; 
        return velocidade;
      case 10:
        velocidade = 10;
        return velocidade;
    } // fim do switch
    return velocidade;
  }// fim do metodo aumentarVelocidade

  /* ***************************************************************
  * Metodo: diminuirVelocidade.
  * Funcao: diminui a velocidade recebida do trem em 10.
  * Parametros: um inteiro, representando a velocidade recebida.
  * Retorno: retorna um inteiro, representando a velocidade alterada.
  *************************************************************** */
  public int diminuirVelocidade(int velocidade){
    switch(velocidade){
      case 50:
        velocidade = 50;
        return velocidade;
      case 40:
        velocidade = velocidade+10;
        return velocidade;
      case 30:
        velocidade = velocidade+10;
        return velocidade;
      case 20:
        velocidade = velocidade+10; 
        return velocidade;
      case 10:
        velocidade = velocidade+10; 
        return velocidade;
    } // fim do switch
    return velocidade;
  } // fim do metodo diminuirVelocidade

  /* ***************************************************************
  * Metodo: setBotaoMostrar.
  * Funcao: altera a imagem do botao que representa a velocidade atual dos trens.
  * Parametros: um inteiro, representando a velocidade atual do trem e uma string, representando qual trem
  * vai alterar o botao.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void setBotaoMostrar(int velocidade, String trem){
    
    // modificar o botao do trem1
    if(trem=="t1"){
      switch(velocidade){
        case 50:
        ImageIcon imageTemporaria = new ImageIcon("1.png");
        botaoMostraVelocidadeTrem1.setIcon(imageTemporaria);
        break;
        case 40:
        ImageIcon imageTemporaria2 = new ImageIcon("2.png");
        botaoMostraVelocidadeTrem1.setIcon(imageTemporaria2);
        break;
        case 30:
        ImageIcon imageTemporaria3 = new ImageIcon("3.png");
        botaoMostraVelocidadeTrem1.setIcon(imageTemporaria3);
        break;
        case 20:
        ImageIcon imageTemporaria4 = new ImageIcon("4.png");
        botaoMostraVelocidadeTrem1.setIcon(imageTemporaria4);
        break;
        case 10:
        ImageIcon imageTemporaria5 = new ImageIcon("5.png");
        botaoMostraVelocidadeTrem1.setIcon(imageTemporaria5);
        break;
      } //fim do switch
    } // fim do if

    // modificar o botao do trem2
    if(trem=="t2"){
      switch(velocidade){
        case 50:
        ImageIcon imageTemporaria = new ImageIcon("1trem2.png");
        botaoMostraVelocidadeTrem2.setIcon(imageTemporaria);
        break;
        case 40:
        ImageIcon imageTemporaria2 = new ImageIcon("2trem2.png");
        botaoMostraVelocidadeTrem2.setIcon(imageTemporaria2);
        break;
        case 30:
        ImageIcon imageTemporaria3 = new ImageIcon("3trem2.png");
        botaoMostraVelocidadeTrem2.setIcon(imageTemporaria3);
        break;
        case 20:
        ImageIcon imageTemporaria4 = new ImageIcon("4trem2.png");
        botaoMostraVelocidadeTrem2.setIcon(imageTemporaria4);
        break;
        case 10:
        ImageIcon imageTemporaria5 = new ImageIcon("5trem2.png");
        botaoMostraVelocidadeTrem2.setIcon(imageTemporaria5);
        break;
      } // fim do switch
    } // fim do if
  } // fim do metodo setBotaoMostrar

  /* ***************************************************************
  * Metodo: alterarCorBandeira.
  * Funcao: altera a cor das bandeiras para vermelho ou verde.
  * Parametros: recebe uma String, representando qual bandeira quer alterar a cor e outra
  * String representando a cor que vai alterar.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void alterarCorBandeira(String band, String cor){

    // alterando a cor para vermelho
    if(cor == "vermelho"){
      switch(band){
        case "b1":
          ImageIcon imageTemporaria = new ImageIcon("BandeiraIdaVermelha.png");
          bandeira.setIcon(imageTemporaria);
          break;
        case "b2":
          ImageIcon imageTemporaria2 = new ImageIcon("BandeiraVermelhaVolta.png");
          bandeira2.setIcon(imageTemporaria2);
          break;
        case "b3":
          ImageIcon imageTemporaria3 = new ImageIcon("BandeiraIdaVermelha.png");
          bandeira3.setIcon(imageTemporaria3);
          break;
        case "b4":
          ImageIcon imageTemporaria4 = new ImageIcon("BandeiraVermelhaVolta.png");
          bandeira4.setIcon(imageTemporaria4);
        break;
      } // fim do switch
    } // fim do if

    // alterando a cor para verde
    if(cor=="verde"){
      switch(band){
        case "b1":
          ImageIcon imageTemporaria = new ImageIcon("BandeiraIdaVerde.png");
          bandeira.setIcon(imageTemporaria);
          break;
        case "b2":
          ImageIcon imageTemporaria2 = new ImageIcon("BandeiraVerdeVolta.png");
          bandeira2.setIcon(imageTemporaria2);
          break;
        case "b3":
          ImageIcon imageTemporaria3 = new ImageIcon("BandeiraIdaVerde.png");
          bandeira3.setIcon(imageTemporaria3);
          break;
        case "b4":
          ImageIcon imageTemporaria4 = new ImageIcon("BandeiraVerdeVolta.png");
          bandeira4.setIcon(imageTemporaria4);
        break;
      } // fim do switch
    } // fim do if
  } // fim do metodo alterarCorBandeira

  /* ***************************************************************
  * Metodo: actionPerformed.
  * Funcao: recebe um evento, e dependendo do evento vai realizar uma acao que vai ser definida.
  * Parametros: ActionEvent evento.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  @Override
  public void actionPerformed(ActionEvent evento){
    try{
      // quando o evento for igual ao botaoDiminuirVelocidadetrem1, vai diminuir a velocidade do trem1
      // e setar o botao que vai mostrar a velocidade atual do trem1.
     if(evento.getSource() == botaoDiminuirVelocidadeTrem1){
       trem1.setVelocidade(diminuirVelocidade(trem1.getVelocidade()));
       setBotaoMostrar(trem1.getVelocidade(),"t1");
     } // fim do if

      // quando o evento for igual ao botaoAumentarVelocidadetrem1, vai aumentar a velocidade do trem1
      // e setar o botao que vai mostrar a velocidade atual do trem1.
     if(evento.getSource() == botaoAumentarVelocidadeTrem1){
       trem1.setVelocidade(aumentarVelocidade(trem1.getVelocidade()));
       setBotaoMostrar(trem1.getVelocidade(), "t1");
     } // fim do if

      // quando o evento for igual ao botaoDiminuirVelocidadetrem2, vai diminuir a velocidade do trem2
      // e setar o botao que vai mostrar a velocidade atual do trem2.
     if(evento.getSource() == botaoDiminuirVelocidadeTrem2){
       trem2.setVelocidade(diminuirVelocidade(trem2.getVelocidade()));
       setBotaoMostrar(trem2.getVelocidade(), "t2");
     } // fim do if

      // quando o evento for igual ao botaoAumentarVelocidadetrem2, vai aumentar a velocidade do trem2
      // e setar o botao que vai mostrar a velocidade atual do trem2.
     if(evento.getSource() == botaoAumentarVelocidadeTrem2){
       trem2.setVelocidade(aumentarVelocidade(trem2.getVelocidade()));
       setBotaoMostrar(trem2.getVelocidade(), "t2");
     } //fim do if

    } catch(Exception e){ // fim do try
      System.out.println("erro"); 
    } // fim do catch 
  } // fim do metodo actionPerformed
} // fim da classe Mapa
