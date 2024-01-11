/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 20/05/2021
* Ultima alteracao: 23/05/2021
* Nome do Programa: Producao e consumo de barris de petroleo.
* Classe: Consumidor
* Funcao: Tem a funcao de consumir o barril de petroleo do buffer, e tambem criar e movimentar o navio consumidor.
*************************************************************** */
import javax.swing.JLabel;

public class Consumidor extends Thread {
  
  // variavel representa o label do navio
  private JLabel navio;

  //variavel que recebe o mapa para manuseiar os components.
  private Mapa mapa;

  // variavel que controla a velocidade da thread,comeca com 1  para o navio ficar parado.
  private int velocidade =1;

  // variavel que controla a movimentacao do label ate o porto de consumo do petroleo
  private int cont =1;

  public Consumidor(JLabel navio, Mapa mapa){
    this.navio = navio;
    this.mapa = mapa;
  } // final do construtor Consumidor

  public void run() {
    while(true){
      if(getVelocidade()==1){
        while(getVelocidade()==1){
          sleepi(1);
        }// fim do while
      }else{ //fim do primeiro if
        try {
          ida();
        } catch (InterruptedException e) { //fim do try
          e.printStackTrace();
        } // fim do catch

        sleepi(getVelocidade());

        volta();
      } // fim do else
    } // fim do while
  } // fim do metodo run

  /* ***************************************************************
  * Metodo: consumirItem().
  * Funcao: procura um espaco ocupado no buffer, deixa ele vazio e retira um barril do porto.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void consumirItem(){
    for(int i=0; i<Controlador.buffer.length;i++){
      if(Controlador.getBuffer(i)!=0){
        Controlador.setBuffer(i, 0);
        mapa.barrilVisivel("retirar", i);
        break;
      } //fim do if
    } // fim do for
  } // fim do metodo consumirItem

   /* ***************************************************************
  * Metodo: ida.
  * Funcao: faz a movimentacao do label ate o porto de consumo do petroleo. 
  * Quando no porto, faz a verificacao dos semaforos para ver se pode acessar o buffer.
  * Consome o barril.
  * Muda a direcao do label do navio para a volta ao porto de entrega.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void ida() throws InterruptedException{
    if(cont ==1){
      if(navio.getX() >=464){
        navio.setLocation(navio.getX()-2, navio.getY());
      } // fim do segundo if
      if(navio.getX()==464){

        Controlador.full.acquire();
        Controlador.mutex.acquire();

        consumirItem();

        Controlador.mutex.release();
        Controlador.empty.release();

        cont =0;
        mapa.alterarDirecao("volta", "R2", this.navio);
      } // fim do terceiro if
    } // fim do primeiro if
  } // fim do metodo ida

  /* ***************************************************************
  * Metodo: volta.
  * Funcao: faz a movimentacao do label ate o porto de entrega dos barris de petroleo.
  * Quando finalizada a movimentacao, troca a imagem do label.
  * Parametros: nenhum.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void volta(){
    if(cont ==0){
      if(navio.getX()<=592){
        navio.setLocation(navio.getX()+2, navio.getY());
      } // fim do segundo if
      if(navio.getX()==592){
        cont=1;
        mapa.alterarDirecao("ida", "R2", this.navio);
      } // fim do terceiro if
    } // fim do primeiro if
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
  } //fim do metodo getVelocidade

  /* ***************************************************************
  * Metodo: setVelocidade.
  * Funcao: altera a variavel velocidade.
  * Parametros: int velocidade.
  * Retorno: nenhum.
  *************************************************************** */
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  } //fim do metodo setVelocidade
} // fim da class Consumidor

