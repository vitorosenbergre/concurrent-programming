/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 05/05/2021.
* Ultima alteracao: 08/05/2021.
* Classe: Trem1.
* Funcao: Fazer o caminho do trem1 e selecionar os protocolos.
*************************************************************** */

import javax.swing.JLabel;


public class Trem1 extends Thread{
  
  // variavel representando o trem1
  private JLabel trem;

  //variavel representando a estrada
  private Estrada estrada;
  
  // variavel representando o mapa
  private Mapa mapa;

  // protocolos, que vai ser setado ao apertar o botao e alterar o protoco.
  private static String protocolo ="bandeiras";

  // variavel que representa a velocidade do trem
  private static int velocidade =50; 

  // Nomeia o processo =0 no protocolo de peterson
  private static int processo =0;

  // variavel utilizada para controlar a mudanca da cor das bandeiras
  private static int controlador =1;

  // controlador protocolo, usado para resetar o protocolo apenas 1 vez quando selecionado
  private static int controladorProtocolo=0;

  //controlador substituindo o else if da antiga estrutura
  private static int controladorElseIf = 1;

  // controlador usado para acessar o ja sai Rc1 apenas quando sair da respectiva zona critica
  private static int controlador3 =0;

  // controlador usado para acessar o ja sai Rc2 apenas quando sair da respectiva zona critica
  private static int controlador4=0;
  
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
      
      // switch usado para escolher e resetar o protocolo
      switch(protocolo){
        case"bandeiras":
          if(controladorProtocolo==1){
            resetProtocoloTrem1();
            controladorProtocolo=0;
          } // fim do if
          ProtocoloBandeirasTrem1();
          break;
        case"travamento":
          if(controladorProtocolo==1){
            resetProtocoloTrem1();
            controladorProtocolo=0;
          } // fim do if
          VariavelDeTravamentoTrem1();
          break;
        case"estrita":
          if(controladorProtocolo==1){
            resetProtocoloTrem1();
            controladorProtocolo=0;            
          }// fim do if
          EstritaAlternanciaTrem1();
          break;
        case"peterson":
          if(controladorProtocolo==1){
            resetProtocoloTrem1();
            controladorProtocolo=0;
            Estrada.setInteresse2(false,0);
            Estrada.setInteresse2(false,1);;       
          }// fim do if
          PetersonTrem1();
          break;
        default:
          break;
      } // fim do switch
    } // fim do while
  } // fim do run
  
  //------------------------------------------PROTOCOLO-BANDEIRAS-------------------------------------------

  /* ***************************************************************
  * Metodo: ProtocoloBandeirasTrem1.
  * Funcao: Exerce a funcao do protocolo das Bandeiras no trem1.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void ProtocoloBandeirasTrem1(){
      RegiaoNaoCritica1Thread();

      PossoAcessarRC1();
      RegiaoCritica1Thread();
      JaSaiDaRC1();

      RegiaoNaoCritica2Thread();

      PossoAcessarRC2();
      RegiaoCritica2Thread();
      JaSaiDaRC2();

      RegiaoNaoCritica3Thread();
  } // fim do metodo ProtocoloBandeirasTrem1
  
  //------------------------------------PROTOCOLO-VARIAVEL-DE-TRATAMENTO------------------------------------
  /* ***************************************************************
  * Metodo: VariavelDeTravamentoTrem1.
  * Funcao: Exerce a funcao do protocolo das variaveis de travamento no trem1.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void VariavelDeTravamentoTrem1(){
      RegiaoNaoCritica1Thread();

      PossoAcessarRC1PorInt();
      RegiaoCritica1Thread();
      JaSaiDaRC1PorInt();

      RegiaoNaoCritica2Thread();

      PossoAcessarRC2PorInt();
      RegiaoCritica2Thread();
      JaSaiDaRC2PorInt();

      RegiaoNaoCritica3Thread();
  } // fim do metodo VariavelDeTravamentoTrem1
  
  //--------------------------------------PROTOCOLO-ESTRITA-ALTERNANCIA-------------------------------------
  /* ***************************************************************
  * Metodo: EstritaAlternanciaTrem1.
  * Funcao: Exerce a funcao do protocolo da estrita alternancia no trem1.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void EstritaAlternanciaTrem1(){
      RegiaoNaoCritica1Thread();

      PossoAcessarRC1PorEstrita();
      RegiaoCritica1Thread();
      JaSaiDaRC1PorEstrita();

      RegiaoNaoCritica2Thread();

      PossoAcessarRC2PorEstrita();
      RegiaoCritica2Thread();
      JaSaiDaRC2PorEstrita();

      RegiaoNaoCritica3Thread();
  } // fim do metodo EstritaAlternanciaTrem1
  
  //------------------------------------------PROTOCOLO-PETERSON--------------------------------------------
  /* ***************************************************************
  * Metodo: PetersonTrem1.
  * Funcao: Exerce a funcao do protocolo de Peterson no trem1.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PetersonTrem1(){
      RegiaoNaoCritica1Thread();

      PossoAcessarRC1PorPeterson();
      RegiaoCritica1Thread();
      JaSaiDaRC1PorPeterson();

      RegiaoNaoCritica2Thread();

      PossoAcessarRC2PorPeterson();
      RegiaoCritica2Thread();
      JaSaiDaRC2PorPeterson();

      RegiaoNaoCritica3Thread();
  } // fim do metodo PetersonTrem1
  //---------------------------------------------PETERSON---------------------------------------------------

  /* ***************************************************************
  * Metodo: PossoAcessarRC1PorPeterson.
  * Funcao: Modifica a verificacao da regiao critica 1 do trem1 para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1PorPeterson(){
    if(trem.getX()==224 && trem.getY()==156 && Estrada.getControladorPetersonTrem1Zona1()==0){
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
      Estrada.setControladorPetersonTrem1Zona1(1);
      Estrada.setControladorPetersonTrem1Zona2(1);
    } // fim do primeiro if
  } // fim do metodo PossoAcessarRC1PorPeterson

  /* ***************************************************************
  * Metodo: PossoAcessarRC2PorPeterson.
  * Funcao: Modifica a verificacao da regiao critica 2 do trem1 para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2PorPeterson(){
    if(trem.getX()== 626 && trem.getY()== 170 && Estrada.getControladorPetersonTrem1Zona2()==1){
      int outro;
      outro = 1 -processo;
      Estrada.setInteresse2(true,processo);
      Estrada.setVez2(processo);
      if(Estrada.getVez2()==processo && Estrada.getInteresse2(outro)==true){
        controladorElseIf =0;
        while(Estrada.getInteresse2(outro)==true){
          try{
            sleep(10);
          }catch (InterruptedException e) { // fim do try
            e.printStackTrace();
          } // fim do catch
        } //fim do while
        try{
          sleep(1000); // dome 1 segundo na espera do trem passar
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      controladorElseIf =1;
      } // fim do segundo if
      Estrada.setControladorPetersonTrem1Zona2(0);
    } // fim do primeiro if
  } // fim do metodo PossoAcessarRC2PorPeterson

  /* ***************************************************************
  * Metodo: JaSaiDaRC1PorPeterson.
  * Funcao: Modifica o valor e a variavel alterada (interesse[processo]) na saida da regiao critica 1 do trem1,
  * para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC1PorPeterson(){
    if(controlador3==1){
      Estrada.setInteresse(false,processo);
      controlador3 =0;
      Estrada.setControladorCriticaTrem1(0);
      // seta o ControladorCriticaTrem1, que vai permitir a entrada no metodo das regioes criticas.

    } // fim do if
  } // fim do metodo JaSaiDaRC1PorPeterson

  /* ***************************************************************
  * Metodo: JaSaiDaRC2PorPeterson.
  * Funcao: Modifica o valor e a variavel alterada (interesse2[processo]) na saida da regiao critica 2 do trem1,
  * para o protocolo de Peterson.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2PorPeterson(){
    if(controlador4==1){
      Estrada.setInteresse2(false,processo);
      controlador4 =0;
      Estrada.setControladorCriticaTrem1(0);
      // seta o ControladorCriticaTrem1, que vai permitir a entrada no metodo das regioes criticas.
    } // fim do if
  } // fim do metodo JaSaiDaRC2PorPeterson
  //--------------------------------------------FINAL-PETERSON----------------------------------------------

  //----------------------------------------ESTRITA-ALTERNANCIA---------------------------------------------

  /* ***************************************************************
  * Metodo: PossoAcessarRC1PorEstrita.
  * Funcao: Modifica a verificacao da regiao critica 1 do trem1 para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1PorEstrita(){
    if(trem.getX()==224 && trem.getY()==156 &&  Estrada.getVezZonaCritica1()==1){
      controladorElseIf =0;
      while(Estrada.getVezZonaCritica1()==1){
        if(Estrada.getVezZonaCritica1()==0 && Estrada.getVezZonaCritica2()==1){
          break; //if usado para o reset
        }  // fim do segundo if
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
  } // fim do metodo PossoAcessarRC1PorEstrita
  
  /* ***************************************************************
  * Metodo: PossoAcessarRC2PorEstrita.
  * Funcao: Modifica a verificacao da regiao critica 2 do trem1 para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2PorEstrita(){
    if(trem.getX()== 626 && trem.getY()== 170 && Estrada.getVezZonaCritica2()==1){
      controladorElseIf =0;
      while(Estrada.getVezZonaCritica2()==1){
        if(Estrada.getVezZonaCritica1()==0 && Estrada.getVezZonaCritica2()==1){
          break; //if usado para o reset
        } // fim do segundo if
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } //fim do while
      try{
        sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC2PorEstrita

  /* ***************************************************************
  * Metodo: JaSaiDaRC1PorEstrita.
  * Funcao: Modifica o valor e a variavel alterada (vezZonaCritica1) na saida da regiao critica 1 do trem1,
  * para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */

  public void JaSaiDaRC1PorEstrita(){
    if(controlador3==1){
      Estrada.setVezZonaCritica1(1);
      controlador3 =0;
      Estrada.setControladorCriticaTrem1(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC1PorEstrita

  /* ***************************************************************
  * Metodo: JaSaiDaRC2PorEstrita.
  * Funcao: Modifica o valor e a variavel alterada (VezZonaCritica2) na saida da regiao critica 2 do trem1,
  * para o protocolo de Estrita Alternancia.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2PorEstrita(){
    if(controlador4==1){
    Estrada.setVezZonaCritica2(1);
    controlador4=0;
    Estrada.setControladorCriticaTrem1(0);
    } //fim do if
  } // fim do metodo JaSaiDaRC2PorEstrita
  
  //---------------------------------------FINAL-ESTRITA-ALTERNANCIA----------------------------------------

  // ---------------------------------------VARIAVEIS-DE-TRAVAMENTO-----------------------------------------

  /* ***************************************************************
  * Metodo: PossoAcessarRC1PorInt.
  * Funcao: Modifica a verificacao da regiao critica 1 do trem1 para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1PorInt(){
    if(trem.getX()==224 && trem.getY()==156 &&  Estrada.getZonaCritica1()==0){
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
  } // fim do metodo PossoAcessarRC1PorInt

  /* ***************************************************************
  * Metodo: PossoAcessarRC2PorInt.
  * Funcao: Modifica a verificacao da regiao critica 2 do trem1 para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2PorInt(){
    if(trem.getX()== 626 && trem.getY()== 170 && Estrada.getZonaCritica2()==0){
      controladorElseIf =0;
      while(Estrada.getZonaCritica2()==0){
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } //fim do while
      try{
        sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC2PorInt

  /* ***************************************************************
  * Metodo: JaSaiDaRC1PorInt.
  * Funcao: Modifica o valor e a variavel alterada (zonaCritica1) na saida da regiao critica 1 do trem1,
  * para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC1PorInt(){
    if(controlador3==1){
      Estrada.setZonaCritica1(1);
      controlador3 =0;
      Estrada.setControladorCriticaTrem1(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC1PorInt

  /* ***************************************************************
  * Metodo: JaSaiDaRC2PorInt.
  * Funcao: Modifica o valor e a variavel alterada (zonaCritica2) na saida da regiao critica 2 do trem1,
  * para o protocolo Variavel de Travamento.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2PorInt(){
    if(controlador4==1){
    Estrada.setZonaCritica2(1);
    controlador4=0;
    Estrada.setControladorCriticaTrem1(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC2PorInt
  
  //---------------------------------------FINAL-VARIAVEL-TRATAMENTO----------------------------------------

  // ---------------------------------------ENTRANDO-NAS-BANDEIRAS------------------------------------------
  
  /* ***************************************************************
  * Metodo: RegiaoNaoCritica1Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 1 do trem1.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica1Thread(){
    if(estrada.VerificaRegiaoNaoCritica1Trem1()==true &&  controladorElseIf ==1){
      estrada.RegiaoNaoCritica1Trem1(trem);
    } // fim do if
  } // fim do metodo RegiaoNaoCritica1Thread

  /* ***************************************************************
  * Metodo: PossoAcessarRC1.
  * Funcao: Verifica se o trem pode acessar a regiao critica 1 do trem 1, verificando uma variavel boolean.
  * Se nao puder acessar, espera ate o valor da variavel for alterado.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC1(){
    if(trem.getX()==224 && trem.getY()==156 &&  estrada.VerificaRegiaoCritica1()==false){
      controladorElseIf =0;
      while(estrada.VerificaRegiaoCritica1()==false){
        try{
        sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } //fim do catch
      } // fim do while
      try{
        sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } //fim do if
  } // fim do metodo PossoAcessarRC1

  /* ***************************************************************
  * Metodo: RegiaoCritica1Thread.
  * Funcao: Faz o trem se movimentar pela regiao critica 1 trem1 e altera a cor das bandeiras da regiao correspondente.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica1Thread(){
    if(estrada.VerificaRegiaoCritica1Trem1Funcionamento()==true){
      if(controlador==1){
      pintarBandeiras("esquerda", "vermelha");
      controlador++;
      } // fim do segundo if
      estrada.RegiaoCritica1Trem1(trem);
      if(Estrada.getControladorCriticaTrem1()==1){
        controlador3=1;
      } // fim do terceiro if
    } // fim do primeiro if
  } //fim do metodo RegiaoCritica1Thread

  /* ***************************************************************
  * Metodo: JaSaiDaRC1.
  * Funcao: Modifica o valor da variavel boolean (controlerCritica1Verificar) para que outros trem possam passar.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC1(){
    if(controlador3==1){
      Estrada.setControlerCritica1Verificar(true);
      controlador3 =0;
      Estrada.setControladorCriticaTrem1(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC1

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica2Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 2 do trem1 e pinta as bandeiras da RC que saiu de verde.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica2Thread(){
    if(estrada.VerificaRegiaoNaoCritica2Trem1()==true && controladorElseIf ==1){
      if(controlador==2){
      pintarBandeiras("esquerda", "verde");
      controlador++;
      } // fim do segundo if
      estrada.RegiaoNaoCritica2Trem1(trem);
    } // fim do primeiro if
  } // fim do metodo RegiaoNaoCritica2Thread

  /* ***************************************************************
  * Metodo: PossoAcessarRC2.
  * Funcao: Verifica se o trem pode acessar a regiao critica 2 do trem 1, verificando uma variavel boolean.
  * Se nao puder acessar, espera ate o valor da variavel for alterado.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void PossoAcessarRC2(){
    if(trem.getX()== 626 && trem.getY()== 170 && estrada.VerificaRegiaoCritica2()==false){
      controladorElseIf =0;
      while(estrada.VerificaRegiaoCritica2()==false){
        try{
          sleep(10);
        }catch (InterruptedException e) { // fim do try
          e.printStackTrace();
        } // fim do catch
      } //fim do while
      try{
        sleep(1000); // dome 1 segundo na espera do trem passar
      }catch (InterruptedException e) { // fim do try
        e.printStackTrace();
      } // fim do catch
      controladorElseIf =1;
    } // fim do if
  } // fim do metodo PossoAcessarRC2

   /* ***************************************************************
  * Metodo: RegiaoCritica2Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 2 do trem1 e pinta as bandeiras da RC que atual de vermelha.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica2Thread(){
    if(estrada.VerificaRegiaoCritica2Trem1Funcionamento()==true){
      if(controlador==3){
      pintarBandeiras("direita", "vermelha");
      controlador++;
      } // fim do segundo if
      estrada.RegiaoCritica2Trem1(trem);
      if(Estrada.getControladorCriticaTrem1()==1){
        controlador4=1;
      } // fim do terceiro if
    }  // fim do primeiro fi
  } // fim do metodo RegiaoCritica2Thread

  /* ***************************************************************
  * Metodo: JaSaiDaRC2.
  * Funcao: Modifica o valor da variavel boolean (controlerCritica2Verificar) para que outros trem possam passar.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void JaSaiDaRC2(){
    if(controlador4==1){
    Estrada.setControlerCritica2Verificar(true);
    controlador4=0;
    Estrada.setControladorCriticaTrem1(0);
    } // fim do if
  } // fim do metodo JaSaiDaRC2

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica3Thread.
  * Funcao: Realiza a acao do trem pela regiao nao critica 3 do trem1 e pinta as bandeiras da RC que saiu de verde.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica3Thread(){ 
    if(estrada.VerificaRegiaoNaoCritica3Trem1()==true && controladorElseIf ==1){
      if(controlador==4){
      pintarBandeiras("direita", "verde");
      controlador=1;
      } // fim do segundo if
      estrada.RegiaoNaoCritica3Trem1(trem);
    } // fim do primeiro if
  } // fim do metodo RegiaoNaoCritica3Thread

  // -----------------------------------------SAINDO-DAS-BANDEIRAS---------------------------------------------

  /* ***************************************************************
  * Metodo: resetProtocoloTrem1.
  * Funcao: seta os valores utilizados para o funcionamento do trem em cada protocolo,
  * setando pelos valores de quando o trem estava no inicio.
  * Parametros: nao tem parametro.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void resetProtocoloTrem1(){
    trem.setBounds(20,78, 100,40);
    Estrada.setControlerNaoCritica1Trem1(true);
    Estrada.setControlerCritica1FuncionamentoTrem1(false);
    Estrada.setControlerNaoCritica2Trem1(false);
    Estrada.setControlerCritica2FuncionamentoTrem1(false);
    Estrada.setControlerNaoCritica3Trem1(false);
    Estrada.setControlerCritica1Verificar(true);
    Estrada.setControlerCritica2Verificar(true);
    Estrada.setControladorCriticaTrem1(0);
    Estrada.setZonaCritica1(1);
    Estrada.setZonaCritica2(1);
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
  } // fim do metodo resetProtocoloTrem1

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

  public static String getProtocolo() {
    return protocolo;
  } // fim do metodo getProtocolo

  public static void setProtocolo(String protocolo) {
    Trem1.protocolo = protocolo;
  } // fim do metodo setProtocolo

  public static int getControladorProtocolo() {
    return controladorProtocolo;
  } // fim do metodo getControladorProtocolo

  public static void setControladorProtocolo(int controladorProtocolo) {
    Trem1.controladorProtocolo = controladorProtocolo;
  } // fim do metodo setControladorProtocolo
} // fim da Classe Trem1