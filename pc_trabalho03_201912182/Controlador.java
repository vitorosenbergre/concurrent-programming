/* ***************************************************************
* Autor: VITOR ROSENBERGRE DOS SANTOS CARMO
* Matricula: 201912182
* Inicio: 27/03/2021
* Ultima 29/03/2021
* Nome: Arvore Genealogica com Threads. 
* Classe: Controlador.
* Funcao: Classe responsavel por setar os labels e as threads no tempo correto
* do processamento de cada thread. A classe que ira iniciar as threads.
*************************************************************** */

public class Controlador {

  private int NASCE_FILHO_1 = 22, NASCE_FILHO_2 = 25, NASCE_FILHO_3 = 32, NASCE_NETO_1 = 38, NASCE_NETO_2 = 45,
      NASCE_BISNETO_1 = 68;

  private int MORRE_PAI = 90, MORRE_FILHO_1 = 83, MORRE_FILHO_2 = 80, MORRE_FILHO_3 = 87, MORRE_NETO_1 = 73,
      MORRE_NETO_2 = 78, MORRE_BISNETO_1 = 80;

  private int TEMPO = 0;

  private int TEMPO_FILHO_1 = 0, TEMPO_FILHO_2 = 0, TEMPO_FILHO_3 = 0, TEMPO_NETO_1 = 0, TEMPO_NETO_2 = 0,
      TEMPO_BISNETO_1 = 0;

  private MainFrame frame = new MainFrame();

  /*
   * *************************************************************** 
   * Metodo:iniciar. 
   * Funcao: instancializa o pai e deixa o labelPai visivel. 
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void iniciar() {
    new ThreadArvore("pai", this).start();
    frame.labelsetVisible("pai");
  }

  /*
   * *************************************************************** 
   * Metodo: pai.
   * Funcao: metodo responsavel instanciar a thread e deixar o label do 
   * familiar visivel. Tambem atualiza o iconePai e o icone do cronometro.
   * Parametros:nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void pai() {
    frame.setTime("pai", TEMPO);

    if (TEMPO == NASCE_FILHO_1) {
      frame.labelsetVisible("filho1");
      new ThreadArvore("filho1", this).start();

    }
    if (TEMPO == NASCE_FILHO_2) {
      frame.labelsetVisible("filho2");
      new ThreadArvore("filho2", this).start();
    }
    if (TEMPO == NASCE_FILHO_3) {
      frame.labelsetVisible("filho3");
      new ThreadArvore("filho3", this).start();
    }
    if (TEMPO == MORRE_PAI) {
      frame.setMorte("pai");
    }
    TEMPO++;
  }

  /*
   * *************************************************************** 
   * Metodo: filho_1. 
   * Funcao: metodo responsavel por instanciar a thread e deixar o label do
   * familiar visivel. Tambem atualiza o icone do filho 1 e o icone do cronometro.
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void filho_1() {
    frame.setTime("filho1", TEMPO_FILHO_1);

    if (TEMPO == NASCE_NETO_1) {
      frame.labelsetVisible("neto1");
      new ThreadArvore("neto1", this).start();
    }

    if (TEMPO == MORRE_FILHO_1) {
      frame.setMorte("filho1");
    }
    TEMPO_FILHO_1++;
  }

  /*
   * *************************************************************** 
   * Metodo: filho_2. 
   * Funcao: metodo responsavel por instanciar a thread e deixar o label do
   * familiar visivel. Tambem atualiza o icone do filho 2 e o icone do cronometro.
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void filho_2() {
    frame.setTime("filho2", TEMPO_FILHO_2);

    if (TEMPO == NASCE_NETO_2) {
      frame.labelsetVisible("neto2");
      new ThreadArvore("neto2", this).start();
    }

    if (TEMPO == MORRE_FILHO_2) {
      frame.setMorte("filho2");
    }
    TEMPO_FILHO_2++;
  }

  /*
   * *************************************************************** 
   * Metodo: filho_3. 
   * Funcao: Atualiza o icone do filho 3 e o icone do cronometro.
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void filho_3() {
    frame.setTime("filho3", TEMPO_FILHO_3);

    if (TEMPO == MORRE_FILHO_3) {
      frame.setMorte("filho3");
    }
    TEMPO_FILHO_3++;
  }

  /*
   * *************************************************************** 
   * Metodo: neto_1. 
   * Funcao: metodo responsavel por instanciar a thread e deixar o label do
   * familiar visivel. Tambem atualiza o icone do neto 1 e o icone do cronometro.
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void neto_1() {
    frame.setTime("neto1", TEMPO_NETO_1);

    if (TEMPO == NASCE_BISNETO_1) {
      frame.labelsetVisible("bisneto1");
      new ThreadArvore("bisneto1", this).start();
      ;
    }

    if (TEMPO == MORRE_NETO_1) {
      frame.setMorte("neto1");
    }
    TEMPO_NETO_1++;
  }

  /*
   * *************************************************************** 
   * Metodo: neto_2. 
   * Funcao: Atualiza o icone do neto 2 e o icone do cronometro.
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void neto_2() {
    frame.setTime("neto2", TEMPO_NETO_2);

    if (TEMPO == MORRE_NETO_2) {
      frame.setMorte("neto2");
    }
    TEMPO_NETO_2++;
  }

  /*
   * *************************************************************** 
   * Metodo: bisneto_1. 
   * Funcao: Atualiza o icone do bisneto 1 e o icone do cronometro.
   * Parametros: nenhum. 
   * Retorno: eh um void, nao vai retornar nada.
   */
  public void bisneto_1() {
    frame.setTime("bisneto1", TEMPO_BISNETO_1);

    if (TEMPO == MORRE_BISNETO_1) {
      frame.setMorte("bisneto1");
    }
    TEMPO_BISNETO_1++;
  }
}
