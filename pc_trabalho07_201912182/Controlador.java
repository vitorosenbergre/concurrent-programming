/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 03/06/2021.
* Ultima alteracao: 05/06/2021.
* Classe: Controlador.
* Funcao: Classe responsavel por disponibilizar e fazer o controle dos semaphores.
* Criar e inserir os novos jogadores no vetor que vai servir como indicacao dos mesmos.
* Criar um vetor reponsavel pelo estado de cada jogador.
* Dar start nos Jogadores. 
*************************************************************** */

import java.util.concurrent.Semaphore;

public class Controlador{
  
  // vetor com os Jogadores
  public static Jogador[] jogadores = new Jogador[5];
  
  // vetor com o estado de cada jogador, o index representando cada jogador
  // Estado 0 = Descansando
  // Estado 1 = Procurando controles
  // Estado 2 = Jogando
  public static int[] estados = new int[5];
  
  // vetor representando os controles, se pode pegar ou nao
  public static Semaphore[] controles = new Semaphore[5];
  
  // mutex
  public static Semaphore mutex = new Semaphore(1);

  // mapa, para fazer as alteracoes na interface.
  public static Mapa mapinha = new Mapa();
  
  public Controlador(){

    for(int i = 0 ; i < 5 ; i++){
      //deixar eles pensando e instanciar os constroles com semaforos (0).
      controles[i] = new Semaphore(0);
      estados[i] = 0;
      
      // acrescenta os jogadores no vetor, para fazer o manuseio
      jogadores[i] = new Jogador(i);

      // setando sliders
      mapinha.setarJogador(jogadores[i], i);

    }//fim do for
    
    // com o vetor preenchido, vamos setar os vizinhos de cada jogador e dar start nas threads
    for(int i = 0 ; i < 5; i++){
      jogadores[i].setVizinhaca();
      jogadores[i].start();
    }//fim do for

  } // fim do construro Controlador
} // fim da classe Controlador
