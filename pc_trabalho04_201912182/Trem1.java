/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 11/04/2021.
* Ultima alteracao: 17/04/2021.
* Classe: Trem1.
* Funcao: Fazer o caminho do trem1.
*************************************************************** */

import javax.swing.JLabel;

public class Trem1 extends Thread{
  
  // variavel representando o trem1
  private JLabel trem;

  //variavel representando a estrada
  private Estrada estrada;
  
  // variavel representando o mapa
  private Mapa mapa;

  // variavel que representa a velocidade do trem
  private static int velocidade =50; 

  // variavel utilizada para controlar a mudanca da cor das bandeiras
  private static int controlador =1;
  
  // construtor vai receber o label representando o trem, a estrada com as coordenadas e o mapa
  public Trem1(JLabel trem, Estrada estrada, Mapa mapa){
    this.trem = trem;
    this.estrada = estrada;
    this.mapa = mapa;
  } // fim do construtor

  public void run(){
    while(true){
      try {
        sleep(getVelocidade());
      } catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch

      // faz a passagem do trem1 pela regiaoNaoCritica1 e verifica tambem se vai ser possivel a passagem do 
      // trem pela regiaoCritica1
      if(trem.getX()==224 && trem.getY()==156 &&  estrada.VerificaRegiaoCritica1()==false){
        while(estrada.VerificaRegiaoCritica1()==false){
          try{
          sleep(10);
          }catch (InterruptedException e) { // fim do try
            e.printStackTrace();
          }
        } // fim do while
        try{
          sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      }else if(estrada.VerificaRegiaoNaoCritica1Trem1()==true){
        estrada.RegiaoNaoCritica1Trem1(trem);
      } // fim do else if

      // faz a passagem do trem1 pela regiaoCritica1 e modifica a cor das bandeiras da regiaoCritica1
      if(estrada.VerificaRegiaoCritica1Trem1Funcionamento()==true){
        if(controlador==1){
        pintarBandeiras("esquerda", "vermelha");
        controlador++;
        } // fim do if
        estrada.RegiaoCritica1Trem1(trem);
      } // fim do if
      
      // faz a passagem do trem1 pela regiaoNaoCritica2, verifica tambem se vai ser possivel a passagem do 
      // trem pela regiaoCritica2, e modifica a cor das bandeiras da regiaoCritica1
      if(trem.getX()== 626 && trem.getY()== 170 && estrada.VerificaRegiaoCritica2()==false){
        while(estrada.VerificaRegiaoCritica2()==false){
          try{
            sleep(10);
          }catch (InterruptedException e) { // fim do try
            e.printStackTrace();
          }
        } //fim do while
        try{
          sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      }else if(estrada.VerificaRegiaoNaoCritica2Trem1()==true){
        if(controlador==2){
        pintarBandeiras("esquerda", "verde");
        controlador++;
        } // fim do if
        estrada.RegiaoNaoCritica2Trem1(trem);
      } // fim do else if

      // faz a passagem do trem1 pela regiaoCritica2 e modifica a cor das bandeiras da regiaoCritica2
      if(estrada.VerificaRegiaoCritica2Trem1Funcionamento()==true){
        if(controlador==3){
        pintarBandeiras("direita", "vermelha");
        controlador++;
        } // fim do if
        estrada.RegiaoCritica2Trem1(trem);
      } // fim do else if

      // faz a passagem do trem1 pela regiaoNaoCritica3 e modifica a cor das bandeiras da regiaoCritica2
      if(estrada.VerificaRegiaoNaoCritica3Trem1()==true){
        if(controlador==4){
        pintarBandeiras("direita", "verde");
        controlador=1;
        } // fim do if
        estrada.RegiaoNaoCritica3Trem1(trem);
      } // fim do if
    } // fim do while
  } // fim do run

  public void setVelocidade(int velocidade){
    Trem1.velocidade = velocidade;
  } // fim do metodo setVelocidade

  public int getVelocidade(){
    return velocidade;
  } // fim do metodo getVelocidade 

  /* ***************************************************************
  * Metodo: pintarBandeiras.
  * Funcao: organizar melhor a pintura das bandeiras, acessando o mapa.
  * Parametros: uma String para saber a localizacao da pintura, podendo ser na esquerda do mapa ou na direita,
  * e outra String representando a cor que vai alterar.
  * Retorno: nao retorna nada, pois eh um void.
  ****************************************************************/
  public void pintarBandeiras(String localizacao, String cor){

    // se for na esquerda do mapa
    if(localizacao == "esquerda"){
      switch(cor){
        case "vermelha":
        mapa.alterarCorBandeira("b1", "vermelho");
        mapa.alterarCorBandeira("b2", "vermelho");
        break;
        case "verde":
        mapa.alterarCorBandeira("b1", "verde");
        mapa.alterarCorBandeira("b2", "verde");
        break;
      } // fim do switch
    } // fim do if
    
    // se for na direita do mapa
    if(localizacao=="direita"){
      switch(cor){
        case "vermelha":
          mapa.alterarCorBandeira("b3", "vermelho");
          mapa.alterarCorBandeira("b4", "vermelho");
          break;
        case "verde":
          mapa.alterarCorBandeira("b3", "verde");
          mapa.alterarCorBandeira("b4", "verde");
          break;
      } // fim do switch
    } // fim do if

  } // fim do metodo pintarBandeiras 
} // fim da Classe Trem1
