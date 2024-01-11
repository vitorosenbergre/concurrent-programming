/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 20/05/2021
* Ultima alteracao: 23/05/2021
* Nome do Programa: Producao e consumo de barris de petroleo.
* Classe: Controlador
* Funcao: Classe responsavel por disponibilizar e fazer o controle do buffer e dos semaforos. 
*************************************************************** */

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Controlador {

  // instacializa a variavel que vai criar o numero aleatorio.
  private Random rand = new Random(1000L);

  // variavel responsavel por armazenar os 7 itens
  public static int[] buffer = new int[7];  

  // semaforo responsavel pela mutua exclusao, evitando que dois navios acessem o buffer ao mesmo tempo.
  public static Semaphore mutex = new Semaphore(1); // Mutua exclusao

  // semaforo responsavel por indicar a quantidade de espacos vazios no buffer
  public static Semaphore empty = new Semaphore(buffer.length); // inicia com o tamanho do vetor

  // semaforo responsavel por indicar a quantidade de espacos cheios no buffer
  public static Semaphore full = new Semaphore(0); // Comeca com 0 no inicio

  public Controlador(){
    esvaziarBuffer();
  } // fim do construtor
  
  /* ***************************************************************
  * Metodo: produzirBarril.
  * Funcao: retornar um numero aleatorio de 0 a 6.
  * Parametros: nenhum.
  * Retorno: um inteiro com o valor de 0 a 6. int barril.
  *************************************************************** */
  public int produzirBarril(){
    int barril = rand.nextInt(6) +1;
    return barril;
  } //fim do metodo ProduzirBarril

  /* ***************************************************************
  * Metodo: esvaziarBuffer.
  * Funcao: esvazia o buffer (com 0) quando a class e instanciada.
  * Parametros: nenhum.
  * Retorno: nenhum.
  *************************************************************** */
  public void esvaziarBuffer(){
    for(int i=0; i<buffer.length;i++){
      buffer[i] =0;
    } //fim do for
  } // fim do metodo esvaziarBuffer

  /* ***************************************************************
  * Metodo: setBuffer.
  * Funcao: vai achar a posicao escolhida do buffer e inserir o valor.
  * Parametros: int posicao,int valor.
  * Retorno: nenhum.
  *************************************************************** */
  public static void setBuffer(int posicao,int valor) {
    for(int i=0; i<buffer.length;i++){
      if(i==posicao){
        buffer[i] = valor;
      } // fim do if
    } // fim do for
  } // fim do metodo setBuffer

  /* ***************************************************************
  * Metodo: getBuffer.
  * Funcao: pegar o valor de uma determinada posicao do buffer.
  * Parametros: int posicao.
  * Retorno: o valor encontrado. int valor.
  *************************************************************** */
  public static int getBuffer(int posicao) {
    int valor =0;
    for(int i=0; i<buffer.length;i++){
      if(i==posicao){
        valor = buffer[i];
      } // fim do if
    } // fim do for
    return valor;
  } // fim do metodo getBuffer
} // fim da class Controlador
