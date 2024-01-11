/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 05/05/2021.
* Ultima alteracao: 08/05/2021.
* Classe: Trem2.
* Funcao: Fazer o caminho do trem2 e selecionar os protocolos.
*************************************************************** */

import javax.swing.JLabel;

public class Trem2 extends Thread{
  
  // variavel representando o trem2
  private JLabel trem;

  //variavel representando a estrada
  private Estrada estrada;

  // variavel representando o mapa
  private Mapa mapa;

  // controlerProtocolos
  private static int controladorProtocolo =0;

  // Nomeia o processo =1 no protocolo de peterson
  private static int processo =1;

  // variavel utilizada para controlar a mudanca da cor das bandeiras
  private static int controlador =1;

  // protocolos, que vai ser setado ao apertar o botao e alterar o protoco.
  private static String protocolo ="bandeiras";
  
  // variavel que representa a velocidade do trem
  private static int velocidade =50;
  
  // controlador utilizado na estrita alternancia, para quando sair do loop nao esperar 1segundo. 
  private static int controladorDormida= 1;

  //controlador substituindo o else if da antiga estrutura
  private int controladorElseIf = 1;

  // controlador usado para acessar o ja sai Rc1 apenas quando sair da respectiva zona critica
  private int controlador3 =0;

  // controlador usado para acessar o ja sai Rc2 apenas quando sair da respectiva zona critica
  private int controlador4=0;

  // construtor vai receber o label representando o trem, a estrada com as coordenadas e o mapa
  public Trem2( JLabel trem, Estrada estrada, Mapa mapa){
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

      // switch usado para escolher e resetar o protocolo
      switch(protocolo){
        case"bandeiras":
          if(controladorProtocolo==1){
            resetProtocoloTrem2();
            controladorProtocolo =0;
          } // fim do if
          ProtocoloBandeirasTrem2();
          break;
        case"travamento":
          if(controladorProtocolo==1){
            resetProtocoloTrem2();
            controladorProtocolo =0;
          } // fim do if
          VariavelDeTravamentoTrem2();
          break;
        case"estrita":
          if(controladorProtocolo==1){
            resetProtocoloTrem2();
            controladorProtocolo =0;
          } // fim do if
          EstritaAlternanciaTrem2();
          break;
        case"peterson":
          if(controladorProtocolo==1){
            resetProtocoloTrem2();
            controladorProtocolo=0;
            Estrada.setInteresse2(false,0);
            Estrada.setInteresse2(false,1);
          } // fim do if
          PetersonTrem2();
          break;
        default:
          break;
      } // fim do switch     
    } // fim do while
  } // fim do run

  //------------------------------------------PROTOCOLO-BANDEIRAS-------------------------------------------

  /* ***************************************************************
  * Metodo: ProtocoloBandeirasTrem2.
  * Funcao: Exerce a funcao do protocolo das Bandeiras no trem2.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void ProtocoloBandeirasTrem2(){
      RegiaoNaoCritica1Trem2Thread();

      PossoAcessarRC1Trem2();
      RegiaoCritica1Trem2Thread();
      JaSaidaRC1Trem2();

      RegiaoNaoCritica2Trem2Thread();

      PossoAcessarRC2Trem2();
      RegiaoCritica2Trem2Thred();
      JaSaiDaRC2Trem2();

      RegiaoNaoCritica3Trem2Thread();
  } // fim do metodo ProtocoloBandeirasTrem2
  
  //------------------------------------PROTOCOLO-VARIAVEL-DE-TRATAMENTO------------------------------------
  
  /* ***************************************************************
  * Metodo: VariavelDeTravamentoTrem2.
  * Funcao: Exerce a funcao do protocolo das variaveis de travamento no trem2.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void VariavelDeTravamentoTrem2(){
      RegiaoNaoCritica1Trem2Thread();

      PossoAcessarRC1Trem2PorInt();
      RegiaoCritica1Trem2Thread();
      JaSaidaRC1Trem2PorInt();

      RegiaoNaoCritica2Trem2Thread();

      PossoAcessarRC2Trem2PorInt();
      RegiaoCritica2Trem2Thred();
      JaSaiDaRC2Trem2PorInt();

      RegiaoNaoCritica3Trem2Thread();
  } // fim do metodo VariavelDeTravamentoTrem2
  
  //-----------------------------------PROTOCOLO-ESTRITA-ALTERNANCIA----------------------------------------
  
  /* ***************************************************************
  * Metodo: EstritaAlternanciaTrem2.
  * Funcao: Exerce a funcao do protocolo da estrita alternancia no trem2.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void EstritaAlternanciaTrem2(){

      RegiaoNaoCritica1Trem2Thread();

      PossoAcessarRC1Trem2PorEstrita();
      RegiaoCritica1Trem2Thread();
      JaSaidaRC1Trem2PorEstrita();

      RegiaoNaoCritica2Trem2Thread();

      PossoAcessarRC2Trem2PorEstrita();
      RegiaoCritica2Trem2Thred();
      JaSaiDaRC2Trem2PorEstrita();

      RegiaoNaoCritica3Trem2Thread();
  } // fim do metodo EstritaAlternanciaTrem

  //------------------------------------------PROTOCO-PETERSON----------------------------------------------

  /* ***************************************************************
  * Metodo: PetersonTrem2.
  * Funcao: Exerce a funcao do protocolo de Peterson no trem2.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PetersonTrem2(){

      RegiaoNaoCritica1Trem2Thread();

      PossoAcessarRC1Trem2Porpeterson();
      RegiaoCritica1Trem2Thread();
      JaSaidaRC1Trem2PorPeterson();

      RegiaoNaoCritica2Trem2Thread();

      PossoAcessarRC2Trem2PorPeterson();
      RegiaoCritica2Trem2Thred();
      JaSaiDaRC2Trem2PorPeterson();

      RegiaoNaoCritica3Trem2Thread();
  }// fim do metodo PetersonTrem2
  //---------------------------------------------PETERSON---------------------------------------------------

  /* ***************************************************************
  * Metodo: PossoAcessarRC1Trem2Porpeterson.
  * Funcao: Modifica a verificacao da regiao critica 1 do trem2 para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1Trem2Porpeterson(){
    if(trem.getX()==776 && trem.getY()== 308 && Estrada.getControladorPetersonTrem2Zona1()==0){
      int outro;
      outro = 1 -processo;
      Estrada.setInteresse2(true,processo);
      Estrada.setVez2(processo);
      if(Estrada.getVez2()==processo && Estrada.getInteresse2(outro)==true){
        controladorElseIf =0;
        while(Estrada.getVez2()==processo && Estrada.getInteresse2(outro)==true){
          try{
            sleep(10);
          }catch (InterruptedException e) { // fim do try
            e.printStackTrace();
          } // fim do catch
        } // fim do while
        try{
        sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
        controladorElseIf =1;
      } // fim do segundo if
      Estrada.setControladorPetersonTrem2Zona1(1);
      Estrada.setControladorPetersonTrem2Zona2(1);
    } // fim do primeiro if
  } // fim do metodo PossoAcessarRC1Trem2Porpeterson

  /* ***************************************************************
  * Metodo: PossoAcessarRC2Trem2PorPeterson.
  * Funcao: Modifica a verificacao da regiao critica 2 do trem2 para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2Trem2PorPeterson(){
    if(trem.getX()==350 && trem.getY()== 306 && Estrada.getControladorPetersonTrem2Zona2()==1){
      int outro;
      outro = 1- processo;
      Estrada.setInteresse(true,processo);
      Estrada.setVez(processo);
      if(Estrada.getVez()==processo && Estrada.getInteresse(outro)==true){
        controladorElseIf =0;
        while(Estrada.getVez()==processo && Estrada.getInteresse(outro)==true){
          try{
            sleep(10);
          }catch (InterruptedException e) { // fim do try
            e.printStackTrace();
          } // fim do catch
        } // fim do while
        try{
        sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
        controladorElseIf =1;
      } // fim do segundo if
      Estrada.setControladorPetersonTrem2Zona2(0);
    } // fim do primeiro if
  } // fim do metodo PossoAcessarRC2Trem2PorPeterson

  /* ***************************************************************
  * Metodo: JaSaidaRC1Trem2PorPeterson.
  * Funcao: Modifica o valor e a variavel alterada (interesse2[processo]) na saida da regiao critica 1 do trem2,
  * para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaidaRC1Trem2PorPeterson(){
    if(controlador3==1){
      Estrada.setInteresse2(false,processo);
      controlador3 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if
  } // fim do metodo JaSaidaRC1Trem2PorPeterson

  /* ***************************************************************
  * Metodo: JaSaiDaRC2Trem2PorPeterson.
  * Funcao: Modifica o valor e a variavel alterada (interesse[processo]) na saida da regiao critica 2 do trem2,
  * para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  ****************************************************************/
  public void JaSaiDaRC2Trem2PorPeterson(){
    if(controlador4==1){
      Estrada.setInteresse(false,processo);
      controlador4 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC2Trem2PorPeterson

  //---------------------------------------------FIM-PETERSON----------------------------------------------

  //----------------------------------------ESTRITA-ALTERNANCIA---------------------------------------------
  
  /* ***************************************************************
  * Metodo: PossoAcessarRC1Trem2PorEstrita.
  * Funcao: Modifica a verificacao da regiao critica 1 do trem2 para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1Trem2PorEstrita(){
    if(trem.getX()==776 && trem.getY()== 308 && Estrada.getVezZonaCritica2()==0){
      controladorElseIf =0;
      while(Estrada.getVezZonaCritica2()==0){
        if(Estrada.getVezZonaCritica1()==0 && Estrada.getVezZonaCritica2()==1){
          controladorDormida=0;
          break;
        } // fim do segundo if
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do while
      if(controladorDormida==1){
        try{
        sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do terceiro if
      controladorDormida=1;
      controladorElseIf =1;
    } // fim do primeiro if
  } // fim do metodo PossoAcessarRC1Trem2PorEstrita

  /* ***************************************************************
  * Metodo: PossoAcessarRC2Trem2PorEstrita.
  * Funcao: Modifica a verificacao da regiao critica 2 do trem2 para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2Trem2PorEstrita(){
    if(trem.getX()==350 && trem.getY()== 306 && Estrada.getVezZonaCritica1()==0){
      controladorElseIf =0;
      while(Estrada.getVezZonaCritica1()==0){
        if(Estrada.getVezZonaCritica1()==0 && Estrada.getVezZonaCritica2()==1){
          controladorDormida=0;
          break;
        } // fim do segundo if
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do while
      if(controladorDormida==1){
        try{
        sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do terceiro if
      controladorDormida=1;
      controladorElseIf =1;
    } // fim do primeiro if
  }// fim do metodo PossoAcessarRC2Trem2PorEstrita

  /* ***************************************************************
  * Metodo: JaSaidaRC1Trem2PorEstrita.
  * Funcao: Modifica o valor e a variavel alterada (vezZonaCritica2) na saida da regiao critica 1 do trem2,
  * para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaidaRC1Trem2PorEstrita(){
    if(controlador3==1){
      Estrada.setVezZonaCritica2(0);
      controlador3 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if
  } // fim do metodo JaSaidaRC1Trem2PorEstrita

  /* ***************************************************************
  * Metodo: JaSaiDaRC2Trem2PorEstrita.
  * Funcao: Modifica o valor e a variavel alterada (VezZonaCritica1) na saida da regiao critica 2 do trem2,
  * para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2Trem2PorEstrita(){
    if(controlador4==1){
      Estrada.setVezZonaCritica1(0);
      controlador4 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC2Trem2PorEstrita

  //---------------------------------------FINAL-ESTRITA-ALTERNANCIA----------------------------------------

  // ---------------------------------------VARIAVEIS-DE-TRAVAMENTO-----------------------------------------
  
  /* ***************************************************************
  * Metodo: PossoAcessarRC1Trem2PorInt.
  * Funcao: Modifica a verificacao da regiao critica 1 do trem2 para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1Trem2PorInt(){
    if(trem.getX()==776 && trem.getY()== 308 && Estrada.getZonaCritica2()==0){
      controladorElseIf =0;
      while(Estrada.getZonaCritica2()==0){
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do while
      try{
      sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC1Trem2PorInt

  /* ***************************************************************
  * Metodo: PossoAcessarRC2Trem2PorInt.
  * Funcao: Modifica a verificacao da regiao critica 2 do trem2 para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2Trem2PorInt(){
    if(trem.getX()==350 && trem.getY()== 306 && Estrada.getZonaCritica1()==0){
      controladorElseIf =0;

      while(Estrada.getZonaCritica1()==0){
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do while
      try{
      sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC2Trem2PorInt

  /* ***************************************************************
  * Metodo: JaSaidaRC1Trem2PorInt.
  * Funcao: Modifica o valor e a variavel alterada (zonaCritica2) na saida da regiao critica 1 do trem2,
  * para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaidaRC1Trem2PorInt(){
    if(controlador3==1){
      Estrada.setZonaCritica2(1);
      controlador3 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if 
  } // fim do metodo JaSaidaRC1Trem2PorInt

  /* ***************************************************************
  * Metodo: JaSaiDaRC2Trem2PorInt.
  * Funcao: Modifica o valor e a variavel alterada (zonaCritica1) na saida da regiao critica 2 do trem2,
  * para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2Trem2PorInt(){
    if(controlador4==1){
      Estrada.setZonaCritica1(1);
      controlador4 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC2Trem2PorInt

  //-------------------------------------------FINAL-TRAVAMENTO---------------------------------------------

  // ---------------------------------------ENTRANDO-NAS-BANDEIRAS------------------------------------------
  
  /* ***************************************************************
  * Metodo: RegiaoNaoCritica1Trem2Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 1 do trem2.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica1Trem2Thread(){
    if(estrada.VerificaRegiaoNaoCritica3Trem2()==true && controladorElseIf ==1){
      estrada.RegiaoNaoCritica3Trem2(trem);
    } // fim do if
  } // fim do metodo RegiaoNaoCritica1Trem2Thread

  /* ***************************************************************
  * Metodo: PossoAcessarRC1Trem2.
  * Funcao: Verifica se o trem pode acessar a regiao critica 1 do trem 2, verificando uma variavel boolean.
  * Se nao puder acessar, espera ate o valor da variavel for alterado.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1Trem2(){
    if(trem.getX()==776 && trem.getY()== 308 && estrada.VerificaRegiaoCritica2()==false){
      controladorElseIf =0;
      while(estrada.VerificaRegiaoCritica2()==false){
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do while
      try{
      sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC1Trem2

  /* ***************************************************************
  * Metodo: RegiaoCritica1Trem2Thread().
  * Funcao: Faz o trem se movimentar pela regiao critica 1 trem2 e altera a cor das bandeiras da regiao correspondente.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica1Trem2Thread(){
    if(estrada.VerificaRegiaoCritica2Trem2Funcionamento()==true){
      if(controlador==1){
      pintarBandeiras("direita", "vermelha");
      controlador++;
      } // fim do segundo if
      estrada.RegiaoCritica2Trem2(trem);
      if(Estrada.getControladorCriticaTrem2()==1){
        controlador3=1;
      } // fim do terceiro if
    } // fim do primeiro if
  } // fim do metodo RegiaoCritica1Trem2Thread

  /* ***************************************************************
  * Metodo: JaSaidaRC1Trem2.
  * Funcao: Modifica o valor da variavel boolean (controlerCritica2Verificar) para que outros trem possam passar.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaidaRC1Trem2(){
    if(controlador3==1){
      Estrada.setControlerCritica2Verificar(true);
      controlador3 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim if
  } // fim do metodo JaSaidaRC1Trem2

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica2Trem2Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 2 do trem2 e e pinta as bandeiras da RC que saiu de verde.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica2Trem2Thread(){
    if(estrada.VerificaRegiaoNaoCritica2Trem2()==true && controladorElseIf ==1){
      if(controlador==2){
      pintarBandeiras("direita", "verde");
      controlador++;
      } // fim do segundo if
      estrada.RegiaoNaoCritica2Trem2(trem);
    } // fim do primeiro if
  } // fim do metodo RegiaoNaoCritica2Trem2Thread

  /* ***************************************************************
  * Metodo: PossoAcessarRC2Trem2.
  * Funcao: Verifica se o trem pode acessar a regiao critica 2 do trem 2, verificando uma variavel boolean.
  * Se nao puder acessar, espera ate o valor da variavel for alterado.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2Trem2(){
    if(trem.getX()==350 && trem.getY()== 306 && estrada.VerificaRegiaoCritica1()==false){
      controladorElseIf =0;
      while(estrada.VerificaRegiaoCritica1()==false){
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } // fim do while
      try{
      sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC2Trem2

   /* ***************************************************************
  * Metodo: RegiaoCritica2Trem2Thred.
  * Funcao: Realiza a acao do trem pela regiao nao critica 2 do trem2 e pinta as bandeiras da RC atual de vermelho.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica2Trem2Thred(){
    if(estrada.VerificaRegiaoCritica1Trem2Funcionamento()==true){
      if(controlador==3){
      pintarBandeiras("esquerda", "vermelha");
      controlador++;
      } // fim do segundo if
      estrada.RegiaoCritica1Trem2(trem);
      if(Estrada.getControladorCriticaTrem2()==1){
        controlador4=1;
      } // fim do terceiro if
    } // fim do primeiro if
  } // fim do metodo RegiaoCritica2Trem2Thred

  /* ***************************************************************
  * Metodo: JaSaiDaRC2Trem2.
  * Funcao: Modifica o valor da variavel boolean (controlerCritica1Verificar) para que outros trem possam passar.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2Trem2(){
    if(controlador4==1){
      Estrada.setControlerCritica1Verificar(true);
      controlador4 =0;
      Estrada.setControladorCriticaTrem2(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC2Trem2

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica3Trem2Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 3 do trem2 e pinta as bandeiras da RC que saiu de verde.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica3Trem2Thread(){
    if(estrada.VerificaRegiaoNaoCritica1Trem2()==true && controladorElseIf ==1){
      if(controlador==4){
      pintarBandeiras("esquerda", "verde");
      controlador=1;
      } // fim do segundo if
      estrada.RegiaoNaoCritica1Trem2(trem);
    } // fim do primeiro if
  } // fim do metodo RegiaoNaoCritica3Trem2Thread

  // -----------------------------------------SAINDO-DAS-BANDEIRAS---------------------------------------------

  public void setVelocidade(int velocidade){
    Trem2.velocidade = velocidade;
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

  public static String getProtocolo() {
    return protocolo;
  } // fim do metodo getProtocolo

  public static void setProtocolo(String protocolo) {
    Trem2.protocolo = protocolo;
  } // fim do metodo setProtocolo
  
  /* ***************************************************************
  * Metodo: resetProtocoloTrem2.
  * Funcao: seta os valores utilizados para o funcionamento do trem em cada protocolo,
  * setando pelos valores de quando o trem estava no inicio.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void resetProtocoloTrem2(){
    trem.setBounds(886,405,100,40);
    Estrada.setControlerNaoCritica1Trem2(false);
    Estrada.setControlerCritica1FuncionamentoTrem2(false);
    Estrada.setControlerNaoCritica2Trem2(false);
    Estrada.setControlerCritica2FuncionamentoTrem2(false);
    Estrada.setControlerNaoCritica3Trem2(true);
    Estrada.setControlerCritica1Verificar(true);
    Estrada.setControlerCritica2Verificar(true);
    Estrada.setZonaCritica1(1);
    Estrada.setZonaCritica2(1);
    Estrada.setControladorCriticaTrem2(0);
    Estrada.setVezZonaCritica1(0);
    Estrada.setVezZonaCritica2(1);
    controlador =1;
    pintarBandeiras("esquerda", "verde");
    pintarBandeiras("direita", "verde");
    estrada.zerarVetores();
    Estrada.setVez(10);
    Estrada.setVez2(10);
    Estrada.setControladorPetersonTrem1Zona1(0);
    Estrada.setControladorPetersonTrem1Zona2(0);
    Estrada.setControladorPetersonTrem2Zona1(0);
    Estrada.setControladorPetersonTrem2Zona2(0);
  } // fim do metodo resetProtocoloTrem2

  public static int getControladorProtocolo() {
    return controladorProtocolo;
  } // fim do metodo getControladorProtocolo

  public static void setControladorProtocolo(int controladorProtocolo) {
    Trem2.controladorProtocolo = controladorProtocolo;
  } // fim do metodo setControladorProtocolo
} // fim da classe Trem2
