/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 20/05/2021
* Ultima alteracao: 23/05/2021
* Nome do Programa: Producao e consumo de barris de petroleo.
* Classe: Produtor
* Funcao: Tem a funcao de produzir o barril de petroleo e inseri-lo no buffer, e tambem criar e movimentar o navio produtor.
*************************************************************** */

import javax.swing.JLabel;

public class Produtor extends Thread {
  
  // variavel utilizada para ontrolar o buffer e os semaforos
  private Controlador controlador;

  // variavel que recebe o label do navio
  private JLabel navio;

  //variavel que recebe o mapa para manuseiar os components
  private Mapa mapa;

  // variavel que vai introduzir um inteiro representando o barril no buffer
  private int barril;

  // variavel que controla a velocidade da thread, comeca com 1  para o navio ficar parado.
  private int velocidade =1;

  // contador que controla a ida do Jlabel do navio para o porto de insersao do petroleo 
  private int cont =1;

  // contador que controla a producao do barril 
  private int cont2 =1;

  public Produtor(JLabel navio, Mapa mapa,Controlador controlador){
    this.navio = navio;
    this.mapa = mapa;
    this.controlador = controlador;
  } // fim do contrutor do Produtor

  public void run() {
    while(true){
      if(getVelocidade()==1){
        while(getVelocidade()==1){
          sleepi(1);
        } // fim do while
      }else{ //fim do if

        produzirItem();
      
        try {
          ida();
        } catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch

        volta();

        sleepi(getVelocidade());
      } // fim do else
    } //fim do while
  } // fim do metodo run

  /* ***************************************************************
  * Metodo: produzirItem.
  * Funcao: produz um numero aleatorio de 0 a 6 e armazena na variavel barril.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void produzirItem(){
    if(cont2 ==1){
      barril = controlador.produzirBarril();
      cont2 =0;
    } // fim do if
  } //fim do metodo produzirItem

  /* ***************************************************************
  * Metodo: inserirItem.
  * Funcao: procura um espaco vazio no buffer, insere a variavel barril e deixa um barril visivel no porto.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void inserirItem(){
    for(int i=0; i<Controlador.buffer.length;i++){
      if(Controlador.getBuffer(i)==0){
        Controlador.setBuffer(i, barril);
        mapa.barrilVisivel("inserir", i);
        break;
      } // fim do if
    } // fim do for
  } // fim do metodo inserirItem

  /* ***************************************************************
  * Metodo: ida.
  * Funcao: faz a movimentacao do label ate o porto. 
  * Quando no porto, faz a verificacao dos semaforos para ver se pode acessar o buffer.
  * Insere o item.
  * Muda a direcao do label do navio para o porto de producao.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void ida() throws InterruptedException{
    if(cont ==1){
      if(navio.getX() <=240){
        navio.setLocation(navio.getX()+2, navio.getY());
      } // fim do segundo if
      if(navio.getX()==240){

        Controlador.empty.acquire(); 
        Controlador.mutex.acquire(); 

        inserirItem();

        Controlador.mutex.release();
        Controlador.full.release();

        cont =0;
        mapa.alterarDirecao("volta", "R1", this.navio);
      } // fim do terceiro if
    } // fim do primeiro if
  } // fim do metodo ida

  /* ***************************************************************
  * Metodo: volta.
  * Funcao: faz a movimentacao do label ate o porto de producao de barris de petroleo.
  * Quando finalizada a movimentacao, troca a imagem do label.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void volta(){
    if(cont ==0){
      if(navio.getX()>=110){
        navio.setLocation(navio.getX()-2, navio.getY());
      } // fim do segundo if
      if(navio.getX()<=110){
        cont=1;
        mapa.alterarDirecao("ida", "R1", this.navio);
        cont2 =1; 
      } // fim do terceiro if
    } //fim do primeiro if
  } // fim do metodo volta

   /* ***************************************************************
  * Metodo: sleepi.
  * Funcao: faz o papel do sleep. Criado para poupar linhas do try-catch.
  * Parametros: int valor.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void sleepi(int valor){
    try {
      sleep(valor);
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch
  } //fim do metodo sleepi
  
   /* ***************************************************************
  * Metodo: getVelocidade.
  * Funcao: retorna a variavel velocidade.
  * Parametros: nenhum.
  * Retorno: inteiro velocidade.
  *************************************************************** */
  public int getVelocidade() {
    return velocidade;
  } // fim do metodo getVelocidade

  /* ***************************************************************
  * Metodo: setVelocidade.
  * Funcao: altera a variavel velocidade.
  * Parametros: int velocidade.
  * Retorno: nenhum.
  *************************************************************** */
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  } // fim do metodo setVelocidade
} // fim da class Produtor
