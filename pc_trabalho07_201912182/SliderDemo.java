/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 03/06/2021.
* Ultima alteracao:  05/06/2021.
* Classe: SliderDemo
* Funcao: Controlar a velocidade do pensamento e do momento de jogar.
*************************************************************** */

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderDemo implements ChangeListener{

  //variavel do Jslider
  private JSlider slider;

  // jogador que vai ter a variavel alterada
  private Jogador jogador;

  // tipo de slider
  private String tipo;

  // constante representando a velocidade inicial do slider
  private int VELOCIDADE_INIT = 0;
  
  // constante representando a velocidade minima do slider
  static final int VELOCIDADE_MIN = 0;
  
  // constante representando a velocidade maxima do slider
  static final int VELOCIDADE_MAX = 5;

  public SliderDemo(Jogador jogador, String tipo){

    this.jogador = jogador;
    this.tipo = tipo;
    
    slider = new JSlider(JSlider.HORIZONTAL,
    VELOCIDADE_MIN, VELOCIDADE_MAX, VELOCIDADE_INIT);
    slider.setSize(20, 20);

    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(1);
    
    slider.setPaintLabels(true);

    slider.addChangeListener(this);
    slider.setBackground(new Color(30,225,225));
  } // fim do construtor SliderDemo

  /* ***************************************************************
  * Metodo: setLocationSlider.
  * Funcao: altera a localizacao do slider no panel.
  * Parametros: int x, int y.
  * Retorno: nenhum.
  *************************************************************** */
  public void setLocationSlider(int x, int y){
    slider.setLocation(x, y);
  } // fim do metodo setLocationSlider

  /* ***************************************************************
  * Metodo: getSlider.
  * Funcao: retorna a variavel slider.
  * Parametros: nenhum.
  * Retorno: JSlider slider.
  *************************************************************** */
  public JSlider getSlider() {
    return slider;
  } // fim do metodo getSlider

  /* ***************************************************************
  * Metodo: setSize.
  * Funcao: altera o tamanho do slider no panel.
  * Parametros: int largura, int altura.
  * Retorno: nenhum.
  *************************************************************** */
  public void setSize(int largura, int altura){
    slider.setSize(largura,altura);
  } // fim do metodo setSize

  /* ***************************************************************
  * Metodo: setSlider.
  * Funcao: troca de JSlider.
  * Parametros: JSlider slider.
  * Retorno: nenhum.
  *************************************************************** */
  public void setSlider(JSlider slider) {
    this.slider = slider;
  } // fim do metodo setSlider

  /* ***************************************************************
  * Metodo: setSliderVisible.
  * Funcao: troca a visibilizade do slider.
  * Parametros: boolean valor.
  * Retorno: nenhum.
  *************************************************************** */
  public void setSliderVisible(boolean valor){
    slider.setVisible(valor);
  } // fim do metodo setSliderVisible

  /* ***************************************************************
  * Metodo: getVELOCIDADE_INIT().
  * Funcao: retorna a variavel VELOCIDADE_INIT.
  * Parametros: nenhum.
  * Retorno: int VELOCIDADE_INIT.
  *************************************************************** */
  public int getVELOCIDADE_INIT() {
    return VELOCIDADE_INIT;
  } // fim do metodo getVELOCIDADE_INIT
  
  /* ***************************************************************
  * Metodo: setVELOCIDADE_INIT.
  * Funcao: troca o valor inicial do slider.
  * Parametros: int vELOCIDADE_INIT.
  * Retorno: nenhum.
  *************************************************************** */
  public void setVELOCIDADE_INIT(int vELOCIDADE_INIT) {
    VELOCIDADE_INIT = vELOCIDADE_INIT;
  } // fim do metodo setVELOCIDADE_INIT

  /* ***************************************************************
  * Metodo: getJogador().
  * Funcao: retorna a variavel jogador.
  * Parametros: nenhum.
  * Retorno: Jogador jogador.
  *************************************************************** */
  public Jogador getJogador(){
    return jogador;
  } // fim do metodo getJogador

  /* ***************************************************************
  * Metodo: setJogador.
  * Funcao: troca o valor da variavel jogador.
  * Parametros: Jogador jogador.
  * Retorno: nenhum.
  *************************************************************** */
  public void setJogador(Jogador jogador) {
    this.jogador = jogador;
  } // fim do metodo setJogador 

  /* ***************************************************************
  * Metodo: getTipo().
  * Funcao: retorna a variavel tipo.
  * Parametros: nenhum.
  * Retorno: String tipo.
  *************************************************************** */
  public String getTipo() {
    return tipo;
  } // fim do metodo getTipo

  /* ***************************************************************
  * Metodo: setTipo.
  * Funcao: troca o valor da variavel tipo.
  * Parametros: String tipo.
  * Retorno: nenhum.
  *************************************************************** */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  } // fim do metodo setTipo

  // velocidades
  // velocidade 0 =  1
  // velocidade 1 = 7000
  // velocidade 2 = 5000
  // velocidade 3 = 4000
  // velocidade 4 = 2000
  // velocidade 5 = 1000
  /* ***************************************************************
  * Metodo: stateChanged.
  * Funcao: toda vez que o slider for alterado, vai realizar uma acao correspondente a alteracao.
  * Parametros: ChangeEvent e.
  * Retorno: nenhum.
  *************************************************************** */
  @Override
  public void stateChanged(ChangeEvent e) {
  
    if(tipo == "descansar"){
      if(slider.getValue()==0){
        jogador.setVelocidadeDescansar(10000);
      } // fim do if
      if(slider.getValue()==1){
        jogador.setVelocidadeDescansar(7000);
      } // fim do if
      if(slider.getValue()==2){
        jogador.setVelocidadeDescansar(5000);
      } // fim do if
      if(slider.getValue()==3){
        jogador.setVelocidadeDescansar(4000);
      } // fim do if
      if(slider.getValue()==4){
        jogador.setVelocidadeDescansar(2000);
      } // fim do if 
      if(slider.getValue()==5){
        jogador.setVelocidadeDescansar(1000);
      } // fim do if
    }else{ // fim do if
      if(slider.getValue()==0){
        jogador.setVelocidadeJogar(10000);
      } // fim do if
      if(slider.getValue()==1){
        jogador.setVelocidadeJogar(7000);
      } // fim do if
      if(slider.getValue()==2){
        jogador.setVelocidadeJogar(5000);
      } // fim do if
      if(slider.getValue()==3){
        jogador.setVelocidadeJogar(4000);
      } // fim do if
      if(slider.getValue()==4){
        jogador.setVelocidadeJogar(2000);
      } // fim do if 
      if(slider.getValue()==5){
        jogador.setVelocidadeJogar(1000);
      } // fim do if
    } // fim do else
  } // fim do meotod stateChanged
} // fim da class SliderDemo
