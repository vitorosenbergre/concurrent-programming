/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 20/05/2021
* Ultima alteracao: 23/05/2021
* Nome do Programa: Producao e consumo de barris de petroleo.
* Classe: Mapa
* Funcao: Fazer o display do mapa, do navio, dos sliders e dos botoes.
*************************************************************** */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;

public class Mapa extends JFrame implements ActionListener{
  
  // controladores utilizados nos botoes produtores e consumidores.
  private int controladorCriar =1;
  private int controladorCriarConsumidor =1;
  
  // panel utilizado no mapa
  private ImagePanel imagePanel;

  // botoes de exposicao
  private JButton botaoConsumidor;
  private JButton botaoProdutor;

  // sliders produtores
  private SliderDemo slider;
  private SliderDemo slider2;
  private SliderDemo slider3;
  private SliderDemo slider4;
  private SliderDemo slider5;

  // sliders consumidores
  private SliderDemo sliderConsumidor;
  private SliderDemo slider2Consumidor;
  private SliderDemo slider3Consumidor;
  private SliderDemo slider4Consumidor;
  private SliderDemo slider5Consumidor;

  //navios regiao1
  private JLabel navio1;
  private JLabel navio2;
  private JLabel navio3;
  private JLabel navio4;
  private JLabel navio5;

  //navios regiao2
  private JLabel navio1R2;
  private JLabel navio2R2;
  private JLabel navio3R2;
  private JLabel navio4R2;
  private JLabel navio5R2;
  

  //barris
  private JLabel barril1;
  private JLabel barril2;
  private JLabel barril3;
  private JLabel barril4;
  private JLabel barril5;
  private JLabel barril6;
  private JLabel barril7;

  //produtores
  private Produtor produtor1;
  private Produtor produtor2;
  private Produtor produtor3;
  private Produtor produtor4;
  private Produtor produtor5;

  //consumidores
  private Consumidor consumidor1;
  private Consumidor consumidor2;
  private Consumidor consumidor3;
  private Consumidor consumidor4;
  private Consumidor consumidor5;

  // controlador unico, para ser global
  private Controlador controlador;


  public Mapa(){
    
    imagePanel = new ImagePanel();
    controlador =new Controlador();

    this.add(imagePanel);

    navio1 = new JLabel(new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png")));
    navio2 = new JLabel(new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png")));
    navio3 = new JLabel(new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png")));
    navio4 = new JLabel(new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png")));
    navio5 = new JLabel(new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png")));

    navio1R2 = new JLabel(new ImageIcon(getClass().getResource("Navio_volta_menor.png")));
    navio2R2 = new JLabel(new ImageIcon(getClass().getResource("Navio_volta_menor.png")));
    navio3R2 = new JLabel(new ImageIcon(getClass().getResource("Navio_volta_menor.png")));
    navio4R2 = new JLabel(new ImageIcon(getClass().getResource("Navio_volta_menor.png")));
    navio5R2 = new JLabel(new ImageIcon(getClass().getResource("Navio_volta_menor.png")));

    barril1 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));
    barril2 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));
    barril3 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));
    barril4 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));
    barril5 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));
    barril6 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));
    barril7 = new JLabel(new ImageIcon(getClass().getResource("tonelpetroleo_menor.png")));

    botaoConsumidor = new JButton("Consumidor");
    botaoProdutor = new JButton("Produtor");

    produtor1 = new Produtor(navio1,this, controlador);
    produtor2 = new Produtor(navio2,this,controlador);
    produtor3 = new Produtor(navio3,this, controlador);
    produtor4 = new Produtor(navio4,this,controlador);
    produtor5 = new Produtor(navio5,this, controlador);

    consumidor1 = new Consumidor(navio1R2,this);
    consumidor2 = new Consumidor(navio2R2,this);
    consumidor3 = new Consumidor(navio3R2,this);
    consumidor4 = new Consumidor(navio4R2,this);
    consumidor5 = new Consumidor(navio5R2,this);

    slider = new SliderDemo(produtor1,consumidor1,"produtor");
    slider2 = new SliderDemo(produtor2,consumidor2,"produtor");
    slider3 = new SliderDemo(produtor3,consumidor3,"produtor");
    slider4 = new SliderDemo(produtor4,consumidor4,"produtor");
    slider5 = new SliderDemo(produtor5,consumidor5,"produtor");

    sliderConsumidor = new SliderDemo(produtor1,consumidor1,"consumidor");
    slider2Consumidor = new SliderDemo(produtor2,consumidor2,"consumidor");
    slider3Consumidor = new SliderDemo(produtor3,consumidor3,"consumidor");
    slider4Consumidor = new SliderDemo(produtor4,consumidor4,"consumidor");
    slider5Consumidor = new SliderDemo(produtor5,consumidor5,"consumidor");

    gerarFrame();
    adicionarSlider();
    gerarBotoesCriacao();
    gerarNaviosR1();
    gerarNaviosR2();
    gerarBarris();
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
    setSize(800,553);
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
  * Metodo: gerarBotoesCriacao().
  * Funcao: adicionar os botoes responsaveis por adicionar produtores e consumidores ao panel.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void gerarBotoesCriacao(){
    botaoProdutor.setBounds(180, 40, 100, 40);
    botaoProdutor.addActionListener(this);
    imagePanel.add(botaoProdutor);


    botaoConsumidor.setBounds(520,40,120,40);
    botaoConsumidor.addActionListener(this);
    imagePanel.add(botaoConsumidor);
  } // fim do metodo gerarBotoesCriacao

  /* ***************************************************************
  * Metodo: adicionarSlider().
  * Funcao: adicionar os sliders ao panel.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void adicionarSlider(){
    slider.setLocationSlider(20, 125);  
    slider.setSize(60, 40);
    slider.setSliderVisible(false);
    imagePanel.add(slider.getSlider());

    slider2.setLocationSlider(20, 200);
    slider2.setSize(60, 40);
    slider2.setSliderVisible(false);
    imagePanel.add(slider2.getSlider());

    slider3.setLocationSlider(20, 275);
    slider3.setSize(60,40);
    slider3.setSliderVisible(false);
    imagePanel.add(slider3.getSlider());

    slider4.setLocationSlider(20, 350);
    slider4.setSize(60, 40);
    slider4.setSliderVisible(false);
    imagePanel.add(slider4.getSlider());

    slider5.setLocationSlider(20, 430);
    slider5.setSize(60,40);
    slider5.setSliderVisible(false);
    imagePanel.add(slider5.getSlider());

    sliderConsumidor.setLocationSlider(711, 125);
    sliderConsumidor.setSize(60,40);
    sliderConsumidor.setSliderVisible(false);
    imagePanel.add(sliderConsumidor.getSlider());

    slider2Consumidor.setLocationSlider(711,200);
    slider2Consumidor.setSize(60,40);
    slider2Consumidor.setSliderVisible(false);
    imagePanel.add(slider2Consumidor.getSlider());

    slider3Consumidor.setLocationSlider(711, 275);
    slider3Consumidor.setSize(60, 40);
    slider3Consumidor.setSliderVisible(false);
    imagePanel.add(slider3Consumidor.getSlider());

    slider4Consumidor.setLocationSlider(711, 350);
    slider4Consumidor.setSize(60, 40);
    slider4Consumidor.setSliderVisible(false);
    imagePanel.add(slider4Consumidor.getSlider());

    slider5Consumidor.setLocationSlider(711, 430);
    slider5Consumidor.setSize(60, 40);
    slider5Consumidor.setSliderVisible(false);
    imagePanel.add(slider5Consumidor.getSlider());
  } // fim do metodo AdicionarSlider

  /* ***************************************************************
  * Metodo: gerarNaviosR1().
  * Funcao: adicionar os labels que representam os navios produtores ao panel.
  * Dar start nas threads de Produtores.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void gerarNaviosR1(){
    navio1.setBounds(110, 100, 100, 49);
    navio1.setVisible(false);
    imagePanel.add(navio1);
    produtor1.start();

    navio2.setBounds(110, 180, 100, 49);
    navio2.setVisible(false);
    imagePanel.add(navio2);
    produtor2.start();

    navio3.setBounds(110, 260, 100, 49);
    navio3.setVisible(false);
    imagePanel.add(navio3);
    produtor3.start();

    navio4.setBounds(110, 340, 100, 49);
    navio4.setVisible(false);
    imagePanel.add(navio4);
    produtor4.start();

    navio5.setBounds(110, 420, 100, 49);
    navio5.setVisible(false);
    imagePanel.add(navio5);
    produtor5.start();
  } // fim do metodo gerarNaviosR1

  /* ***************************************************************
  * Metodo: gerarNaviosR2().
  * Funcao: adicionar os labels que representam os navios consumidores ao panel.
  * Dar start nas threads de Consumidores.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void gerarNaviosR2(){
    navio1R2.setBounds(592, 100, 100, 51);
    navio1R2.setVisible(false);
    imagePanel.add(navio1R2);
    consumidor1.start();

    navio2R2.setBounds(592, 180, 100, 51);
    navio2R2.setVisible(false);
    imagePanel.add(navio2R2);
    consumidor2.start();

    navio3R2.setBounds(592, 260, 100, 51);
    navio3R2.setVisible(false);
    imagePanel.add(navio3R2);
    consumidor3.start();

    navio4R2.setBounds(592, 340, 100, 51);
    navio4R2.setVisible(false);
    imagePanel.add(navio4R2);
    consumidor4.start();

    navio5R2.setBounds(592, 420, 100, 51);
    navio5R2.setVisible(false);
    imagePanel.add(navio5R2);
    consumidor5.start();
  } // fim do metodo gerarNaviosR2

  /* ***************************************************************
  * Metodo: gerarBarris().
  * Funcao: adicionar os labels que representam os barris de petroleo ao panel.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void gerarBarris(){
    barril1.setBounds(380, 60, 50, 60);
    barril1.setVisible(false);
    imagePanel.add(barril1);

    barril2.setBounds(380, 120, 50, 60);
    barril2.setVisible(false);
    imagePanel.add(barril2);

    barril3.setBounds(380, 180, 50, 60);
    barril3.setVisible(false);
    imagePanel.add(barril3);

    barril4.setBounds(380, 240, 50, 60);
    barril4.setVisible(false);
    imagePanel.add(barril4);

    barril5.setBounds(380, 300, 50, 60);
    barril5.setVisible(false);
    imagePanel.add(barril5);

    barril6.setBounds(380, 360, 50, 60);
    barril6.setVisible(false);
    imagePanel.add(barril6);

    barril7.setBounds(380, 420, 50, 60);
    barril7.setVisible(false);
    imagePanel.add(barril7);
  } // fim do metodo gerarBarris()

  /* ***************************************************************
  * Metodo: barrilVisivel().
  * Funcao: deixar um barril visivel ou oculta-lo.
  * Parametros: String estado (se vai inserir ou vai retirar o barril),int posicao (posicao do barril).
  * Retorno: nenhum.
  *************************************************************** */
  public void barrilVisivel(String estado,int posicao){
    if(estado =="inserir"){
      switch(posicao){
        case 0:
          barril1.setVisible(true);
          break;
        case 1:
          barril2.setVisible(true);
          break;
        case 2:
          barril3.setVisible(true);
          break;
        case 3:
          barril4.setVisible(true);
          break;
        case 4:
          barril5.setVisible(true);
          break;
        case 5:
          barril6.setVisible(true);
          break;
        case 6:
          barril7.setVisible(true);
          break;
      }// fim do switch
    } // fim do if

    if(estado =="retirar"){
      switch(posicao){
        case 0:
          barril1.setVisible(false);
          break;
        case 1:
          barril2.setVisible(false);
          break;
        case 2:
          barril3.setVisible(false);
          break;
        case 3:
          barril4.setVisible(false);
          break;
        case 4:
          barril5.setVisible(false);
          break;
        case 5:
          barril6.setVisible(false);
          break;
        case 6:
          barril7.setVisible(false);
          break;
      } //fim do switch
    } // fim do if
  } //fim do metodo BarrilVisivel

  /* ***************************************************************
  * Metodo: alterarDirecao().
  * Funcao: alterar a posicao do navio (ida ou volta).
  * Parametros: String direcao (ida-volta), String regiao(consumidor-produtor), JLabel navioTroca(label do navio).
  * Retorno: nenhum.
  *************************************************************** */
  public void alterarDirecao(String direcao, String regiao, JLabel navioTroca){
    if(regiao == "R1"){
      switch(direcao){
        case"ida":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png"));
          navioTroca.setIcon(imageTemporaria);
          break;
        case"volta":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("Navio_volta_menor.png"));
          navioTroca.setIcon(imageTemporaria2);
          break;
      } //fim do switch
    } // fim do if

    if(regiao == "R2"){
      switch(direcao){
        case"ida":
          ImageIcon imageTemporaria = new ImageIcon(getClass().getResource("Navio_volta_menor.png"));
          navioTroca.setIcon(imageTemporaria);
          break;
        case"volta":
          ImageIcon imageTemporaria2 = new ImageIcon(getClass().getResource("NavioIdaPNG_pequeno.png"));
          navioTroca.setIcon(imageTemporaria2);
          break;
      } // fim do switch
    } // fim do if
  } // fim do metodo AlterarDirecao

  /* ***************************************************************
  * Metodo: actionPerformed.
  * Funcao: fazer alteracoes quando clicado em cada botao da interface. 
  * Parametros: ActionEvent evento, envendo do click.
  * Retorno: nenhum.
  *************************************************************** */
  public void actionPerformed(ActionEvent evento){
    
    if(evento.getSource()==botaoProdutor){
      switch(controladorCriar){
        case 1:
          navio1.setVisible(true);
          slider.setSliderVisible(true);
          controladorCriar++;
          break;
        case 2:
          navio2.setVisible(true);
          slider2.setSliderVisible(true);
          controladorCriar++;
          break;
        case 3:
          navio3.setVisible(true);
          slider3.setSliderVisible(true);
          controladorCriar++;
          break;
        case 4:
          navio4.setVisible(true);
          slider4.setSliderVisible(true);
          controladorCriar++;
          break;
        case 5:
          navio5.setVisible(true);
          slider5.setSliderVisible(true);
          botaoProdutor.setEnabled(false);
          break;
      } // fim do switch
    } // fim do if

    if(evento.getSource()==botaoConsumidor){
      switch(controladorCriarConsumidor){
        case 1:
          navio1R2.setVisible(true);
          sliderConsumidor.setSliderVisible(true);
          controladorCriarConsumidor++;
          break;
        case 2:
          navio2R2.setVisible(true);
          slider2Consumidor.setSliderVisible(true);
          controladorCriarConsumidor++;
          break;
        case 3:
          navio3R2.setVisible(true);
          slider3Consumidor.setSliderVisible(true);
          controladorCriarConsumidor++;
          break;
        case 4:
          navio4R2.setVisible(true);
          slider4Consumidor.setSliderVisible(true);
          controladorCriarConsumidor++;
          break;
        case 5:
          navio5R2.setVisible(true);
          slider5Consumidor.setSliderVisible(true);
          botaoConsumidor.setEnabled(false);
          break;
      } // fim do switch
    } // fim do if
  } // fim do metodo actionPerformed
} // fim da class Mapa