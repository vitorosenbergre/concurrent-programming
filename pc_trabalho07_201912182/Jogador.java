/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 03/06/2021.
* Ultima alteracao: 05/06/2021.
* Classe: Jogador.
* Funcao: Um jogador que tem as funcoes de descansar, procurar controle e jogar.
*************************************************************** */

public class Jogador extends Thread{
  // identificador do jogador
  private int index;

  // Jogador mais proximo a Esquerda
  private Jogador jogadorEsquerda;

  // Jogador mais proximo a Direita
  private Jogador jogadorDireita;

  // Velocidade de Descanso, inicia com um valor aleatorio e depois eh regulada pelo usuario
  private int velocidadeDescansar = (1000 + (int)(Math.random() * 1000));

  // Velocidade de Jogo, inicia com um valor aleatorio e depois eh regulada pelo usuario
  private int velocidadeJogar = (1000 + (int)(Math.random() * 1000));


  public Jogador(int index){
    this.index = index;
  } // fim do construtor Jogador

  public void run(){
    while(true){
        try {
          descansar();
          pegarControles();
          jogar();
          devolverControles();
        } catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
    } //fim do while
  } // fim do run

  /* ***************************************************************
  * Metodo: setVizinhaca().
  * Funcao: seta o vizinha da esquerda e da direita de todos o Jogadores.
  * Parametros: nenhum.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void setVizinhaca(){
    this.jogadorDireita = Controlador.jogadores[(getIndex() + 1 + 5)%5]; //pega o da Direita
    this.jogadorEsquerda = Controlador.jogadores[(getIndex() - 1 +5)%5]; //pega o da Esquerda
  } // fim do metodo setVizinhanca

  /* ***************************************************************
  * Metodo: descansar().
  * Funcao: faz o jogador dormir, variando de acordo com o tempo escolhido pelo usuario.
  * Parametros: nenhum.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void descansar() throws InterruptedException {
    Thread.sleep(velocidadeDescansar);
  } //fim do metodo descansar

  /* ***************************************************************
  * Metodo: jogar().
  * Funcao: faz o jogador jogar, variando de acordo com o tempo escolhido pelo usuario.
  * Tira a visibilidade dos controles usados e deixa o controle principal visivel.
  * Parametros: nenhum.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void jogar() throws InterruptedException {
    Controlador.mapinha.alterarVisibilidadeControles(this.getIndex(),"false");
    Controlador.mapinha.alterarVisibilidadeControles(this.jogadorEsquerda.getIndex(),"false");
    Controlador.mapinha.alterarControleCompleto(this.getIndex(),"true");
    Thread.sleep(velocidadeJogar);
  } // fim do metodo jogar

  /* ***************************************************************
  * Metodo: pegarControles().
  * Funcao: faz o jogador ter vontade de jogar e procurar o garfos, ou seja, ver se os proximos estao disponiveis.
  * Altera o estado do jogador para procurando, junto com o labelEstado.
  * Parametros: nenhum.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void pegarControles() throws InterruptedException{
    Controlador.mutex.acquire();
    Controlador.estados[getIndex()] =1;
    Controlador.mapinha.alterarEstado("procurando", getIndex());
    verificar(this); // verifica se pode jogar, se os controles estao livres.
    Controlador.mutex.release();
    Controlador.controles[getIndex()].acquire(); 
  } // fim do metodo pegarControles

  /* ***************************************************************
  * Metodo: devolverControles().
  * Funcao: faz o jogador devolver os controles a mesa, liberando-os para os seus vizinhos usarem (se quiserem).
  * Altera o estado do jogador para Descansando, junto com o labelEstado.
  * Deixa os controles visiveis novamente e o controle principal desligado.
  * Parametros: nenhum.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void devolverControles() throws InterruptedException{
    Controlador.mutex.acquire();
    Controlador.estados[getIndex()] = 0;
    Controlador.mapinha.alterarEstado("descansando", getIndex());
    Controlador.mapinha.alterarVisibilidadeControles(this.getIndex(),"true");
    Controlador.mapinha.alterarVisibilidadeControles(this.jogadorEsquerda.getIndex(),"true");
    Controlador.mapinha.alterarControleCompleto(this.getIndex(),"false");
    verificar(jogadorEsquerda); // verifica se os jogadores vizinhos estao interessados e seus controles 
    verificar(jogadorDireita);  // proximos estao livres.
    Controlador.mutex.release();
  } // fim do metodo devolverControles

  /* ***************************************************************
  * Metodo: verificar.
  * Funcao: verifica se o jogador quer jogar e se os controles proximos estao livres para serem usados..
  * Altera o estado do jogador para Jogando, junto com o labelEstado.
  * Parametros: Jogador player, o jogador que vai ser verificado.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void verificar(Jogador player) throws InterruptedException{
    if(Controlador.estados[player.getIndex()] == 1 && Controlador.estados[player.getJogadorEsquerda().getIndex()] != 2 && Controlador.estados[player.getJogadorDireita().getIndex()] != 2) {
      Controlador.estados[player.getIndex()] = 2;
      Controlador.mapinha.alterarEstado("jogando", player.getIndex());
      Controlador.controles[player.getIndex()].release();
    } // fim do if
  } // fim do metodo verificar

  /* ***************************************************************
  * Metodo: getIndex.
  * Funcao: retornar a variavel index.
  * Parametros: nenhum.
  * Retorno: a variavel index.
  *************************************************************** */
  public int getIndex() {
    return index;
  } // fim do metodo getIndex

  /* ***************************************************************
  * Metodo: setIndex.
  * Funcao: alterar a variavel index.
  * Parametros: int index, valor para a alteracao.
  * Retorno: nada.
  *************************************************************** */
  public void setIndex(int index) {
    this.index = index;
  } // fim do metodo setIndex

  /* ***************************************************************
  * Metodo:  getJogadorEsquerda.
  * Funcao: retornar a variavel jogadorEsquerda.
  * Parametros: nenhum.
  * Retorno: a variavel jogadorEsquerda.
  *************************************************************** */
  public Jogador getJogadorEsquerda() {
    return jogadorEsquerda;
  } //fim do metodo getJogadorEsquerda

  /* ***************************************************************
  * Metodo: setJogadorEsquerda.
  * Funcao: alterar a variavel jogadorEsquerda.
  * Parametros: Jogador jogadorEsquerda, valor para a alteracao.
  * Retorno: nada.
  *************************************************************** */
  public void setJogadorEsquerda(Jogador jogadorEsquerda) {
    this.jogadorEsquerda = jogadorEsquerda;
  } // fim do metodo setJogadorEsquerda

  /* ***************************************************************
  * Metodo: getJogadorDireita.
  * Funcao: retornar a variavel jogadorDireita.
  * Parametros: nenhum.
  * Retorno: a variavel jogadorDireita.
  *************************************************************** */
  public Jogador getJogadorDireita() {
    return jogadorDireita;
  } // fim do metodo getJogadorDireita

  /* ***************************************************************
  * Metodo: setJogadorDireita.
  * Funcao: alterar a variavel jogadorDireita.
  * Parametros: Jogador jogadorDireita, valor para a alteracao.
  * Retorno: nada.
  *************************************************************** */
  public void setJogadorDireita(Jogador jogadorDireita) {
    this.jogadorDireita = jogadorDireita;
  } // fim do metodo setJogadorDireita

  /* ***************************************************************
  * Metodo: getVelocidadeJogar.
  * Funcao: retornar a variavel velocidadeJogar.
  * Parametros: nenhum.
  * Retorno: a variavel velocidadeJogar.
  *************************************************************** */
  public int getVelocidadeJogar() {
    return velocidadeJogar;
  } // fim do metodo getVelocidadeJogar

  /* ***************************************************************
  * Metodo: setVelocidadeJogar.
  * Funcao: alterar a variavel velocidadeJogar.
  * Parametros: int velocidadeJogar, valor para a alteracao.
  * Retorno: nada.
  *************************************************************** */
  public void setVelocidadeJogar(int velocidadeJogar) {
    this.velocidadeJogar = velocidadeJogar;
  } // fim do metodo setVelocidadeJogar

  /* ***************************************************************
  * Metodo: getVelocidadeDescansar.
  * Funcao: retornar a variavel velocidadeDescansar.
  * Parametros: nenhum.
  * Retorno: a variavel velocidadeDescansar.
  *************************************************************** */
  public int getVelocidadeDescansar() {
    return velocidadeDescansar;
  } // fim do metodo getVelocidadeDescansar

  /* ***************************************************************
  * Metodo: setVelocidadeDescansar.
  * Funcao: alterar a variavel int velocidadeDescansar.
  * Parametros: int int velocidadeDescansar, valor para a alteracao.
  * Retorno: nada.
  *************************************************************** */
  public void setVelocidadeDescansar(int velocidadeDescansar) {
    this.velocidadeDescansar = velocidadeDescansar;
  } // fim do metodo setVelocidadeDescansar
}// fim da classe Jogador
