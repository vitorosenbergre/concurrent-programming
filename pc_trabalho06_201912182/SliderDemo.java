/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 20/05/2021
* Ultima alteracao: 23/05/2021
* Nome do Programa: Producao e consumo de barris de petroleo.
* Classe: SliderDemo
* Funcao: Controlar a velocidade dos navios produtores e consumidores.
*************************************************************** */

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SliderDemo implements ChangeListener{

  //variavel do Jslider
  private JSlider slider;

  // variavel para controlar a velocidade do navio Produtor
  private Produtor produtor;

  // variavel para controlar a velocidade do navio Consumidor
  private Consumidor consumidor;
  
  // variavel para saber o tipo de navio
  private String tipo;

  // constante representando a velocidade inicial do slider
  private int VELOCIDADE_INIT = 0;
  
  // constante representando a velocidade minima do slider
  static final int VELOCIDADE_MIN = 0;
  
  // constante representando a velocidade maxima do slider
  static final int VELOCIDADE_MAX = 5;

  public SliderDemo(Produtor produtor, Consumidor consumidor, String tipo){

    this.produtor = produtor;
    this.consumidor = consumidor;
    this.tipo = tipo;

    slider = new JSlider(JSlider.HORIZONTAL,
    VELOCIDADE_MIN, VELOCIDADE_MAX, VELOCIDADE_INIT);
    slider.setSize(20, 20);

    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(1);
    
    slider.setPaintLabels(true);

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
  * Metodo: getProdutor.
  * Funcao: retorna a variavel produtor.
  * Parametros: nenhum.
  * Retorno: Produtor produtor.
  *************************************************************** */
  public Produtor getProdutor() {
    return produtor;
  } //fim do metodo getProdutor
  
  /* ***************************************************************
  * Metodo: setProdutor.
  * Funcao: troca de Produtor.
  * Parametros: Produtor produtor.
  * Retorno: nenhum.
  *************************************************************** */
  public void setProdutor(Produtor produtor) {
    this.produtor = produtor;
  } // fim do metodo setProdutor

  /* ***************************************************************
  * Metodo: getConsumidor().
  * Funcao: retorna a variavel consumidor.
  * Parametros: nenhum.
  * Retorno: Consumidor consumidor.
  *************************************************************** */
  public Consumidor getConsumidor() {
    return consumidor;
  } // fim do metodo getConsumidor
  
  /* ***************************************************************
  * Metodo: setConsumidor.
  * Funcao: troca de Consumidor.
  * Parametros: Consumidor consumidor.
  * Retorno: nenhum.
  *************************************************************** */
  public void setConsumidor(Consumidor consumidor) {
    this.consumidor = consumidor;
  } // fim do metodo setConsumidor

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
  * Funcao: troca de tipo.
  * Parametros: String tipo.
  * Retorno: nenhum.
  *************************************************************** */
  public void setTipo(String tipo) {
    this.tipo = tipo;
  } // fim do metodo setTipo

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

  // velocidades 
  // velocidade 0 = while
  // velocidade 1 = 50s
  // velocidade 2 = 40s
  // velocidade 3 = 30s
  // velocidade 4 = 25s
  // velocidade 5 = 20s
  
  /* ***************************************************************
  * Metodo: stateChanged.
  * Funcao: toda vez que o slider for alterado, vai realizar uma acao correspondente a alteracao.
  * Parametros: ChangeEvent e.
  * Retorno: nenhum.
  *************************************************************** */
  @Override
  public void stateChanged(ChangeEvent e) {

    if(getTipo()=="produtor"){
      if(slider.getValue()==0){
        produtor.setVelocidade(1);
      } // fim do if
      if(slider.getValue()==1){
        produtor.setVelocidade(50);
      } // fim do if
      if(slider.getValue()==2){
        produtor.setVelocidade(40);
      } // fim do if
      if(slider.getValue()==3){
        produtor.setVelocidade(30);
      } // fim do if
      if(slider.getValue()==4){
        produtor.setVelocidade(25);
      } // fim do if
      if(slider.getValue()==5){
        produtor.setVelocidade(20);
      } // fim do if
    }else if(getTipo()=="consumidor"){ // fim do if
      if(slider.getValue()==0){
        consumidor.setVelocidade(1);
      } // fim do if
      if(slider.getValue()==1){
        consumidor.setVelocidade(50);
      } // fim do if
      if(slider.getValue()==2){
        consumidor.setVelocidade(40);
      } // fim do if
      if(slider.getValue()==3){
        consumidor.setVelocidade(30);
      } // fim do if
      if(slider.getValue()==4){
        consumidor.setVelocidade(25);
      } // fim do if 
      if(slider.getValue()==5){
        consumidor.setVelocidade(20);
      } // fim do if
    } // fim do else if
  } // fim do meotod stateChanged
} // fim da class SliderDemo
