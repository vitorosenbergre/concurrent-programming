/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 10/06/2021
* Ultima alteracao: 18/06/2021
* Nome do Programa: Circuito Automato.
* Classe: SliderDemo
* Funcao: Controlar a velocidade dos carros.
*************************************************************** */

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderDemo implements ChangeListener{

  //variavel do JSlider
  private JSlider slider;

  //carro
  private Carro carro;

  // constante representando a velocidade inicial do slider
  private int VELOCIDADE_INIT = 0;
  
  // constante representando a velocidade minima do slider
  static final int VELOCIDADE_MIN = 0;
  
  // constante representando a velocidade maxima do slider
  static final int VELOCIDADE_MAX = 10;

  public SliderDemo(Carro carro){

    this.carro = carro;

    slider = new JSlider(JSlider.HORIZONTAL,
    VELOCIDADE_MIN, VELOCIDADE_MAX, VELOCIDADE_INIT);
    slider.setSize(20, 20);

    slider.setValue(10);
    slider.setPaintLabels(true);
    slider.setBackground(new Color(0,255,33));
    slider.addChangeListener(this);
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
  * Metodo: getCarro().
  * Funcao: retorna a variavel carro.
  * Parametros: nenhum.
  * Retorno: Carro carro.
  *************************************************************** */
  public Carro getCarro() {
    return carro;
  } // fim do metodo getCarro()

  /* ***************************************************************
  * Metodo: setCarro().
  * Funcao: altera o valor de carro.
  * Parametros: Carro carro.
  * Retorno: nenhum.
  *************************************************************** */
  public void setCarro(Carro carro) {
    this.carro = carro;
  } // fim do metodo setCarro()

  /* ***************************************************************
  * Metodo: stateChanged.
  * Funcao: toda vez que o slider for alterado, vai realizar uma acao correspondente a alteracao.
  * Parametros: ChangeEvent e.
  * Retorno: nenhum.
  *************************************************************** */
  @Override
  public void stateChanged(ChangeEvent e) {
      if(slider.getValue()==0){
        carro.setVelocidade(10); 
      } // fim do if
      if(slider.getValue()==1){
        carro.setVelocidade(9); 
      } // fim do if
      if(slider.getValue()==2){
        carro.setVelocidade(8); 
      } // fim do if
      if(slider.getValue()==3){
        carro.setVelocidade(7); 
      } // fim do if
      if(slider.getValue()==4){
        carro.setVelocidade(6); 
      } // fim do if
      if(slider.getValue()==5){
        carro.setVelocidade(5); 
      } // fim do if
      if(slider.getValue()==6){
        carro.setVelocidade(4); 
      } // fim do if
      if(slider.getValue()==7){
        carro.setVelocidade(3); 
      } // fim do if
      if(slider.getValue()==8){
        carro.setVelocidade(2); 
      } // fim do if
      if(slider.getValue()==9){
        carro.setVelocidade(1); 
      } // fim do if
      if(slider.getValue()==10){
        carro.setVelocidade(0); 
      } // fim do if
  } // fim do meotod stateChanged
} // fim da class SliderDemo
