/* ***************************************************************
* Autor: VITOR ROSENBERGRE DOS SANTOS CARMO
* Matricula: 201912182
* Inicio: 27/03/2021
* Ultima 29/03/2021
* Nome: Arvore Genealogica com Threads. 
* Classe: ThreadArvore.
* Funcao: Classe que vai administrar todas as threads chamads, 
* tendo como paramentro no seu construtor uma string (para 
* identificar o familiar) e um Controlador para passar os dados e metodos. 
*************************************************************** */

import java.lang.Thread;

public class ThreadArvore extends Thread {

  private String familiar;  // string pra reconhecer o metodo

  private Controlador controle;  // controlador para acessar o metodo

  public ThreadArvore(String familiar, Controlador controle) {
    this.familiar = familiar;
    this.controle = controle;
  }

  /* ***************************************************************
* Metodo: run.
* Funcao: vai executar os comandos a partir do run da thread instanciada.
* Parametros: nenhum.
* Retorno: eh um void, nao retorna nada.
*************************************************************** */
  public void run() {
    for (int i = 0; i != 91; i++) { // para cada tread o for vai vai ser responsavel pelo tempo

      if (familiar == "pai" && i == 91) { // se o "i" (idade) do pai for igual a 90, entao ele sai do laco 
        break;                            // e encerra a thread. 
      } else if (familiar == "pai") {     // senao ele continua a thread.
        controle.pai();
      }

      if (familiar == "filho1" && i == 62) { // se o "i" (idade) do filho1 for igual a 61, entao ele sai do
        break;                               // laco e encerra a thread.
      } else if (familiar == "filho1") {     // senao ele continua a thread
        controle.filho_1();                 
      }

      if (familiar == "filho2" && i == 56) { // se o "i" (idade) do filho2 for igual a 55, entao ele sai do
        break;                               // laco e encerra a thread.
      } else if (familiar == "filho2") {     // senao ele continua a thread.
        controle.filho_2();
      }

      if (familiar == "filho3" && i == 56) { // se o "i" (idade) do filho3 for igual a 55, entao ele sai do
        break;                               // laco e encerra a thread. 
      } else if (familiar == "filho3") {     // senao ele continua a thread.
        controle.filho_3();
      }

      if (familiar == "neto1" && i == 36) { // se o "i" (idade) do neto1 for igual a 35, entao ele sai do
        break;                              // laco e encerra a thread. 
      } else if (familiar == "neto1") {     // senao ele continua a thread.
        controle.neto_1();
      }

      if (familiar == "neto2" && i == 34) { // se o "i" (idade) do neto2 for igual a 33, entao ele sai do
        break;                              // laco e encerra a thread.
      } else if (familiar == "neto2") {     // senao ele continua a thread.
        controle.neto_2();
      }

      if (familiar == "bisneto1" && i == 13) { // se o "i" (idade) do bisneto1 for igual a 12, entao ele 
        break;                                 // sai do laco e encerra a thread.
      } else if (familiar == "bisneto1") {     // senao ele continua a thread.
        controle.bisneto_1();
      }
      try {
        sleep(1000);                           // pra cada iteracao dorme 1 segundo.
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
