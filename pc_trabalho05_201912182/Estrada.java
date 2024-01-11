/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 11/04/2021.
* Ultima alteracao: 08/05/2021.
* Classe: Estrada.
* Funcao: Controla as movimentacoes dos trens no mapa, junto com os acessos e posicoes.
*************************************************************** */

import javax.swing.JLabel;

public class Estrada {

  // vetor boolean utilizado na zona critica 1 no protocolo de peterson
  private static boolean[] interesse = new boolean[2];

  // vetor boolean utilizado na zona critica 2 no protocolo de peterson
  private static boolean[] interesse2 = new boolean[2];

  // inteiro que vai ser inicializado posteriormente como a vez de acessar regiao critica1, usado pelos trens, protocolo de Peterson.
  private static int vez;

  // inteiro que vai ser inicializado posteriormente como a vez de acessar a regiao critica2, usado pelos trens, protocolo de Peterson.
  private static int vez2;

  // inteiro usado na estrita alternancia, para representar de quem e a vez de acessar a zona critica1
  private static int vezZonaCritica1 = 0;

  // inteiro usado na estrita alternancia, para representar de quem e a vez de acessar a zona critica2
  private static int vezZonaCritica2 = 1;

  // inteiro usado na variavel de travamento, atualizada com a entrada e saida da zona critica11.
  // variando de 1 a 0, se puder acessar =1, se nao puder =0.
  private static int zonaCritica1 =1;

  // inteiro usado na variavel de travamento, atualizada com a entrada e saida da zona critica12.
  // variando de 1 a 0, se puder acessar =1, se nao puder =0.
  private static int zonaCritica2 =1;

  // controladores que criei para acessar a regiao critica 1  e seus dados apenas 1 vez por rotacao do trem1,
  // usado no protocolo de Peterson
  private static int controladorPetersonTrem1Zona1=0;

  // controladores que criei para acessar a regiao critica 2  e seus dados apenas 1 vez por rotacao do trem1,
  // usado no protocolo de Peterson
  private static int controladorPetersonTrem1Zona2=0;

  // controladores que criei para acessar a regiao critica 1  e seus dados apenas 1 vez por rotacao do trem2,
  // usado no protocolo de Peterson
  private static int controladorPetersonTrem2Zona1=0;

  // controladores que criei para acessar a regiao critica 2  e seus dados apenas 1 vez por rotacao do trem2,
  // usado no protocolo de Peterson
  private static int controladorPetersonTrem2Zona2=0;

  // controladores servindo como else if pro meu cod
  private static int controladorCriticaTrem1 =0;

  // controladores servindo como else if pro meu cod
  private static int controladorCriticaTrem2 =0;

  // variavel boolean eh true quando for ativar a zona NaoCritica1 do trem1
  private static boolean controlerNaoCritica1Trem1 =true;

  // variavel boolean eh true quando for ativar a zona Critica1 do trem1
  private static boolean controlerCritica1FuncionamentoTrem1 =false;

  // variavel boolean eh true quando for ativar a zona NaoCritica2 do trem1
  private static boolean controlerNaoCritica2Trem1 = false;

  // variavel boolean eh true quando for ativar a zona Critica2 do trem1
  private static boolean controlerCritica2FuncionamentoTrem1 = false;

  // variavel boolean eh true quando for ativar a zona NaoCritica3 do trem1
  private static boolean controlerNaoCritica3Trem1 = false;

  // verificar se pode acessar a critica 1, que ambos os trens vao usar
  private static boolean controlerCritica1Verificar = true;

  // verificar se pode acessar a critica 2, que ambos os trens vao usar
  private static boolean controlerCritica2Verificar = true;

  
  // zerar os vetores quando instanciado
  public Estrada(){
    zerarVetores();
  }

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica1Trem1.
  * Funcao: faz com que o trem1 se movimente pela regiao NaoCritica1.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica1Trem1(JLabel trem){
    if(trem.getX()<100){
      trem.setBounds(trem.getX()+2,78, 100, 40); 
    }else if(trem.getX()>99 && trem.getY()<140){ // fim do if
      trem.setBounds(trem.getX()+2,trem.getY()+1, 100, 40); 
    }else if(trem.getX()>99 && trem.getY()<=158){  // fim do primeiro else if
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);  
    } //fim do segundo else if

    if(trem.getY()==158){ 
      controlerNaoCritica1Trem1 =false;
      controlerCritica1FuncionamentoTrem1 =true;
      controlerCritica1Verificar = false; 
      zonaCritica1 =0; // usado no outro protocolo da variavel de travamento
    } // fim do if
  } // fim do metodo RegiaoNaoCritica1Trem1

  /* ***************************************************************
  * Metodo: VerificaRegiaoNaoCritica1Trem1.
  * Funcao: vai retornar o estado da regiao NaoCritica1 do trem1,
  * (true) se o trem1 estiver nessa regiao e (false) se o trem1 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoNaoCritica1Trem1(){
    return controlerNaoCritica1Trem1;
  } // fim do metodo VerificaRegiaoNaoCritica1Trem1

   /* ***************************************************************
  * Metodo: RegiaoCritica1Trem1.
  * Funcao: faz com que o trem1 se movimente pela regiao Critica1.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica1Trem1(JLabel trem){

    if(trem.getX()>99 && trem.getY()<240){ 
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);  
    }else if(trem.getX()<360 && trem.getY()==240){  //fim do if
      trem.setBounds(trem.getX()+2,trem.getY(), 100, 40);
    } // fim do else if

    if(trem.getY()<=240 && trem.getX()>= 360){
      controlerCritica1FuncionamentoTrem1 = false;
      zonaCritica1 =1; // usado no outro protocolo da variavel de travamento
      controlerNaoCritica2Trem1 =true;
      controladorCriticaTrem1 =1;
    } //fim do if
  } // fim do metodo RegiaoCritica1Trem1

   /* ***************************************************************
  * Metodo: VerificaRegiaoCritica1Trem1Funcionamento.
  * Funcao: vai retornar o estado da regiao Critica1 do trem1,
  * (true) se o trem1 estiver nessa regiao e (false) se o trem1 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoCritica1Trem1Funcionamento(){
    return controlerCritica1FuncionamentoTrem1;
  } // fim do metodo VerificaRegiaoCritica1Trem1Funcionamento

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica2Trem1.
  * Funcao: faz com que o trem1 se movimente pela regiao NaoCritica2.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica2Trem1(JLabel trem){
    if(trem.getX()<=360 && trem.getY()>=200){
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40); 
    }else if(trem.getX()<=460 && trem.getY()>=60){ // fim do if
      trem.setBounds(trem.getX()+2,trem.getY()-2, 100, 40);
    }else if(trem.getX()<=550 && trem.getY()>=60){  // fim do primeiro else if
      trem.setBounds(trem.getX()+2,trem.getY(), 100, 40);
    }else if(trem.getX()<=626 && trem.getY()<=170){  // fim do segundo else if
      trem.setBounds(trem.getX()+2,trem.getY()+2, 100, 40); 
    } // fim do terceiro else if

    if(trem.getX()==628 && trem.getY()==172){
      controlerNaoCritica2Trem1 =false;
      controlerCritica2FuncionamentoTrem1 = true;
      controlerCritica2Verificar = false;
      zonaCritica2 =0; // usado no outro protocolo da variavel de travamento
    } // fim do if
  } // fim do metodo RegiaoNaoCritica2Trem1
  
  /* ***************************************************************
  * Metodo: VerificaRegiaoNaoCritica2Trem1.
  * Funcao: vai retornar o estado da regiao NaoCritica2 do trem1,
  * (true) se o trem1 estiver nessa regiao e (false) se o trem1 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoNaoCritica2Trem1(){
    return controlerNaoCritica2Trem1;
  } // fim do metodo VerificaRegiaoNaoCritica2Trem1

  /* ***************************************************************
  * Metodo: RegiaoCritica2Trem1.
  * Funcao: faz com que o trem1 se movimente pela regiao Critica2.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica2Trem1(JLabel trem){

    if(trem.getX()<=660 && trem.getY()<=240){ 
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);
    }else if(trem.getX()<=770 && trem.getY()<=242){ // fim do if
      trem.setBounds(trem.getX()+2,trem.getY(), 100, 40); 
    } // fim do else if

    if(trem.getX()==770 && trem.getY()==242){
      controlerCritica2FuncionamentoTrem1 = false; 
      zonaCritica2 =1; // usado no outro protocolo da variavel de travamento
      controlerNaoCritica3Trem1 =true;
      controladorCriticaTrem1 =1; 
    } // fim do if
  } // fim do metodo RegiaoCritica2Trem1

  /* ***************************************************************
  * Metodo: VerificaRegiaoCritica2Trem1Funcionamento.
  * Funcao: vai retornar o estado da regiao Critica2 do trem1,
  * (true) se o trem1 estiver nessa regiao e (false) se o trem1 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoCritica2Trem1Funcionamento(){
    return controlerCritica2FuncionamentoTrem1;
  } // fim do metodo VerificaRegiaoCritica2Trem1Funcionamento

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica3Trem1.
  * Funcao: faz com que o trem1 se movimente pela regiao NaoCritica3.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica3Trem1(JLabel trem){
    if(trem.getX()<=802 && trem.getY()>=210){
      trem.setBounds(trem.getX()+2,trem.getY()-2, 100, 40); 
    }else if(trem.getX()<=804 && trem.getY()>=170){ // fim do if
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40); 
    }else if(trem.getX()<=850 && trem.getY()>=120){ // fim do primeiro else if
      trem.setBounds(trem.getX()+2,trem.getY()-2, 100, 40); 
    }else if(trem.getX()<=885 && trem.getY()==120){ // fim do segundo else if
      trem.setBounds(trem.getX()+2,trem.getY(), 100, 40);
    } // fim do terceiro else if

    if((trem.getX()==886 && trem.getY()==120)){
      controlerNaoCritica3Trem1 =false;
      trem.setBounds(20,78, 100,40);
      controladorPetersonTrem1Zona1 =0;
      controladorPetersonTrem1Zona2 =0;
      controlerNaoCritica1Trem1 =true;
    } // fim do if
  } // fim do metodo RegiaoNaoCritica3Trem1

  /* ***************************************************************
  * Metodo: VerificaRegiaoNaoCritica3Trem1.
  * Funcao: vai retornar o estado da regiao NaoCritica3 do trem1,
  * (true) se o trem1 estiver nessa regiao e (false) se o trem1 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoNaoCritica3Trem1(){
    return controlerNaoCritica3Trem1;
  } // fim do metodo VerificaRegiaoNaoCritica3Trem1

  //--------------------------TREM2------------------------

  // variavel boolean eh true quando for ativar a zona NaoCritica1 do trem2
  private static boolean controlerNaoCritica1Trem2 =false;

  // variavel boolean eh true quando for ativar a zona Critica1 do trem2
  private static boolean controlerCritica1FuncionamentoTrem2 =false;

  // variavel boolean eh true quando for ativar a zona NaoCritica2 do trem2
  private static boolean controlerNaoCritica2Trem2 = false;

  // variavel boolean eh true quando for ativar a zona Critica2 do trem2
  private static boolean controlerCritica2FuncionamentoTrem2=false;

  // variavel boolean eh true quando for ativar a zona NaoCritica3 do trem2
  private static boolean controlerNaoCritica3Trem2 = true;

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica1Trem2.
  * Funcao: faz com que o trem2 se movimente pela regiao NaoCritica1.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica1Trem2(JLabel trem){

    if(trem.getX()<=250 && trem.getY()<= 300){
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);
    }else if(trem.getX()>=168 && trem.getY()<= 382){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY()+2, 100, 40);
    }else if(trem.getX()>=40 && trem.getY()>=384){ // fim do primeiro else if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40);
    }else if(trem.getX()<=38 && trem.getY()>=384){ // fim do segundo else if
      controlerNaoCritica1Trem2 = false;
      trem.setBounds(886,405,100,40);
      controlerNaoCritica3Trem2 = true;
      controladorPetersonTrem2Zona1=0;
      controladorPetersonTrem2Zona2=0;
    } // fim do terceiro else if
  } // fim do metodo RegiaoNaoCritica1Trem2

  /* ***************************************************************
  * Metodo: VerificaRegiaoNaoCritica1Trem2.
  * Funcao: vai retornar o estado da regiao NaoCritica1 do trem2,
  * (true) se o trem2 estiver nessa regiao e (false) se o trem2 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoNaoCritica1Trem2(){
    return controlerNaoCritica1Trem2;
  } // fim do metodo VerificaRegiaoNaoCritica1Trem2

  /* ***************************************************************
  * Metodo: RegiaoCritica1Trem2.
  * Funcao: faz com que o trem2 se movimente pela regiao Critica1.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica1Trem2(JLabel trem){

    if(trem.getX()>=345 && trem.getY()>=242){
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40);
    }else if(trem.getX()>=250 && trem.getY()<=240){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40);
    } // fim do else if

    if(trem.getX()<=250 && trem.getY()<=240){
      controlerCritica1FuncionamentoTrem2 = false;
      controlerNaoCritica1Trem2 = true;
      controladorCriticaTrem2 =1;
      zonaCritica1 =1; // usado no outro protocolo da variavel de travamento
    } // fim do if
  } // fim do metodo RegiaoCritica1Trem2

  /* ***************************************************************
  * Metodo: VerificaRegiaoCritica1Trem2Funcionamento.
  * Funcao: vai retornar o estado da regiao Critica1 do trem2,
  * (true) se o trem2 estiver nessa regiao e (false) se o trem2 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoCritica1Trem2Funcionamento(){
    return controlerCritica1FuncionamentoTrem2;
  } // fim do metodo VerificaRegiaoCritica1Trem2Funcionamento

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica2Trem2.
  * Funcao: faz com que o trem2 se movimente pela regiao NaoCritica2.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica2Trem2(JLabel trem){

    if(trem.getX()>=644 && trem.getY()<=310){
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);
    }else if(trem.getX()>=544 && trem.getY()<=400){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY()+2, 100, 40);
    }else if(trem.getX()>=440 && trem.getY()<=402){ // fim do primeiro else if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40);
    }else if(trem.getX()>=345 && trem.getY()>=315){ // fim do segundo else if
      trem.setBounds(trem.getX()-2,trem.getY()-2, 100, 40);
    }else if(trem.getX()>=345 && trem.getY()>=306){ // fim do terceiro else if
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40);
    }else if(trem.getX()>=345 && trem.getY()>=304){ // fim do quarto else if
      controlerNaoCritica2Trem2 = false;
      controlerCritica1FuncionamentoTrem2 = true;
      controlerCritica1Verificar = false;
      zonaCritica1 =0; // usado no outro protocolo da variavel de travamento
    } // fim do quinto else if
  } // fim do metodo RegiaoNaoCritica2Trem2

  /* ***************************************************************
  * Metodo: VerificaRegiaoNaoCritica2Trem2.
  * Funcao: vai retornar o estado da regiao NaoCritica2 do trem2,
  * (true) se o trem2 estiver nessa regiao e (false) se o trem2 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoNaoCritica2Trem2(){
    return controlerNaoCritica2Trem2;
  } // fim do metodo VerificaRegiaoNaoCritica2Trem2 

  /* ***************************************************************
  * Metodo: RegiaoCritica2Trem2.
  * Funcao: faz com que o trem2 se movimente pela regiao Critica2.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoCritica2Trem2(JLabel trem){
  
    if(trem.getX()<=776 && trem.getY()>=246){
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40); 
    }else if(trem.getX()>=645 && trem.getY()<=246){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40); 
    } // fim do else if

    if(trem.getX()<=645 && trem.getY()<=246){
      controlerCritica2FuncionamentoTrem2 = false;
      controlerNaoCritica2Trem2 = true;
      controladorCriticaTrem2 =1;
      zonaCritica2 =1; // usado no outro protocolo da variavel de travamento
    } // fim do if
  } // fim do metodo RegiaoCritica2Trem2

  /* ***************************************************************
  * Metodo: VerificaRegiaoCritica2Trem2Funcionamento.
  * Funcao: vai retornar o estado da regiao Critica2 do trem2,
  * (true) se o trem2 estiver nessa regiao e (false) se o trem2 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoCritica2Trem2Funcionamento(){
    return controlerCritica2FuncionamentoTrem2;
  } // fim do metodo VerificaRegiaoCritica2Trem2Funcionamento

  /* ***************************************************************
  * Metodo: RegiaoNaoCritica3Trem2.
  * Funcao: faz com que o trem2 se movimente pela regiao NaoCritica3.
  * Parametros: recebe um Jlabel representando o trem que vai ter as coordenadas alteradas.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void RegiaoNaoCritica3Trem2(JLabel trem){
    if(trem.getX()>=852){
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40);
    }else if(trem.getX()>=790 && trem.getY()>=345){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY()-1, 100, 40);  
    }else if(trem.getX()>=778 && trem.getY()>=343){ // fim do primeiro else if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40);     
    }else if(trem.getX()<=776 && trem.getY()>=308){ // fim do segundo else if
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40); 
    } // fim do terceiro else if

    if(trem.getX()<=776 && trem.getY()<=306){
      controlerNaoCritica3Trem2 = false;
      controlerCritica2FuncionamentoTrem2 = true;
      controlerCritica2Verificar = false;
      zonaCritica2 =0; // usado no outro protocolo da variavel de travamento
    } // fim do if
  } // fim do metodo RegiaoNaoCritica3Trem2

   /* ***************************************************************
  * Metodo: VerificaRegiaoNaoCritica3Trem2.
  * Funcao: vai retornar o estado da regiao NaoCritica3 do trem2,
  * (true) se o trem2 estiver nessa regiao e (false) se o trem2 nao estiver nessa regiao.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoNaoCritica3Trem2(){
    return controlerNaoCritica3Trem2;
  } // fim do metodo VerificaRegiaoNaoCritica3Trem2

  /* ***************************************************************
  * Metodo: VerificaRegiaoCritica1.
  * Funcao: retorna o valor de controlerCritica1Verificar,
  * (true) se nao tiver nenhum trem na regiao e (false) se tiver algum trem na regiao critica1.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoCritica1(){ 
    return controlerCritica1Verificar;
  } // fim do metodo VerificaRegiaoCritica1

  /* ***************************************************************
  * Metodo: VerificaRegiaoCritica2.
  * Funcao: retorna o valor de controlerCritica2Verificar,
  * (true) se nao tiver nenhum trem na regiao e (false) se tiver algum trem na regiao critica2.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public boolean VerificaRegiaoCritica2(){ 
    return controlerCritica2Verificar;
  } // fim do metodo VerificaRegiaoCritica2 



  //----------------------------set-get-controles-----------------------


  //CRIADO PARA SE OBTER OS VALORES DAS VARIAVEIS ESTRADA, E MODIFICAR ELES NO RESET


  /* ***************************************************************
  * Metodo: isControlerCritica2Verificar.
  * Funcao: retornar o valor da variavel controlerCritica2Verificar.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public static boolean isControlerCritica2Verificar() {
    return controlerCritica2Verificar;
  } //fim do metodo isControlerCritica2Verificar

  /* ***************************************************************
  * Metodo: setControlerCritica2Verificar.
  * Funcao: alterar o valor da variavel controlerCritica2Verificar.
  * Parametros: boolean controlerCritica2Verificar.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerCritica2Verificar(boolean controlerCritica2Verificar) {
    Estrada.controlerCritica2Verificar = controlerCritica2Verificar;
  } // fim do metodo setControlerCritica2Verificar

  /* ***************************************************************
  * Metodo: getControladorCriticaTrem1.
  * Funcao: retornar o valor da variavel controladorCriticaTrem1.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getControladorCriticaTrem1() {
    return controladorCriticaTrem1;
  } // fim do metodo  getControladorCriticaTrem1

  /* ***************************************************************
  * Metodo: setControladorCriticaTrem1.
  * Funcao: alterar o valor da variavel controladorCriticaTrem1.
  * Parametros: int controladorCriticaTrem1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControladorCriticaTrem1(int controladorCriticaTrem1) {
    Estrada.controladorCriticaTrem1 = controladorCriticaTrem1;
  } // fim do metodo setControladorCriticaTrem1

  /* ***************************************************************
  * Metodo: getControladorCriticaTrem2.
  * Funcao: retornar o valor da variavel controladorCriticaTrem2.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getControladorCriticaTrem2() {
    return controladorCriticaTrem2;
  } // fim do metodo getControladorCriticaTrem2

  /* ***************************************************************
  * Metodo: setControladorCriticaTrem2.
  * Funcao: alterar o valor da variavel controladorCriticaTrem2.
  * Parametros: int controladorCriticaTrem2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControladorCriticaTrem2(int controladorCriticaTrem2) {
    Estrada.controladorCriticaTrem2 = controladorCriticaTrem2;
  } // fim do metodo setControladorCriticaTrem2

  /* ***************************************************************
  * Metodo: isControlerCritica1Verificar.
  * Funcao: retornar o valor da variavel controlerCritica1Verificar.
  * Parametros: nenhum.
  * Retorno: retorna um boolean.
  *************************************************************** */
  public static boolean isControlerCritica1Verificar() {
    return controlerCritica1Verificar;
  } // fim do metodo isControlerCritica1Verificar

  /* ***************************************************************
  * Metodo: setControlerCritica1Verificar.
  * Funcao: alterar o valor da variavel controlerCritica1Verificar.
  * Parametros: boolean controlerCritica1Verificar.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerCritica1Verificar(boolean controlerCritica1Verificar) {
    Estrada.controlerCritica1Verificar = controlerCritica1Verificar;
  } // fim do metodo setControlerCritica1Verificar

  //-----------------------------TRAVAMENTO------------------------------
  
   /* ***************************************************************
  * Metodo: getZonaCritica1.
  * Funcao: retornar o valor da variavel zonaCritica1.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getZonaCritica1() {
    return zonaCritica1;
  } // fim do metodo getZonaCritica1

  /* ***************************************************************
  * Metodo: setZonaCritica1.
  * Funcao: alterar o valor da variavel zonaCritica1.
  * Parametros: int zonaCritica1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setZonaCritica1(int zonaCritica1) {
    Estrada.zonaCritica1 = zonaCritica1;
  } // fim do metodo setZonaCritica1

  /* ***************************************************************
  * Metodo: getZonaCritica2.
  * Funcao: retornar o valor da variavel zonaCritica2.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getZonaCritica2() {
    return zonaCritica2;
  } // fim do metodo getZonaCritica2

  /* ***************************************************************
  * Metodo: setZonaCritica2.
  * Funcao: alterar o valor da variavel zonaCritica2.
  * Parametros: int zonaCritica2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setZonaCritica2(int zonaCritica2) {
    Estrada.zonaCritica2 = zonaCritica2;
  } // fim do metodo setZonaCritica2

  //--------------------------FINAL TRAVAMENTO--------------------------

  // -------------------------ESTRITA-ALTERNANCIA-----------------------

  /* ***************************************************************
  * Metodo: getVezZonaCritica1.
  * Funcao: retornar o valor da variavel vezZonaCritica1.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getVezZonaCritica1() {
    return vezZonaCritica1;
  } // fim do metodo getVezZonaCritica1

  /* ***************************************************************
  * Metodo: setVezZonaCritica1.
  * Funcao: alterar o valor da variavel vezZonaCritica1.
  * Parametros: int vezZonaCritica1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setVezZonaCritica1(int vezZonaCritica1) {
    Estrada.vezZonaCritica1 = vezZonaCritica1;
  } // fim do metodo setVezZonaCritica1

  /* ***************************************************************
  * Metodo: getVezZonaCritica2.
  * Funcao: retornar o valor da variavel vezZonaCritica2.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getVezZonaCritica2() {
    return vezZonaCritica2;
  } // fim do metodo getVezZonaCritica2

  /* ***************************************************************
  * Metodo: setVezZonaCritica2.
  * Funcao: alterar o valor da variavel vezZonaCritica2.
  * Parametros: int vezZonaCritica2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setVezZonaCritica2(int vezZonaCritica2) {
    Estrada.vezZonaCritica2 = vezZonaCritica2;
  } // fim do metodo setVezZonaCritica2

  //-----------------------FIM-ESTRITA-ALTERNANCIA----------------------

  //---------------------sets-trem1-----------------------------
  
  //CRIADO PARA MODIFICAR AS VARIAVEIS DE ESTRADA NO RESET

  /* ***************************************************************
  * Metodo: setControlerNaoCritica1Trem1.
  * Funcao: alterar o valor da variavel controlerNaoCritica1Trem1.
  * Parametros: boolean controlerNaoCritica1Trem1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerNaoCritica1Trem1(boolean controlerNaoCritica1Trem1) {
    Estrada.controlerNaoCritica1Trem1 = controlerNaoCritica1Trem1;
  } // fim do metodo setControlerNaoCritica1Trem1

  /* ***************************************************************
  * Metodo: setControlerCritica1FuncionamentoTrem1.
  * Funcao: alterar o valor da variavel controlerCritica1FuncionamentoTrem1.
  * Parametros: boolean controlerCritica1FuncionamentoTrem1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerCritica1FuncionamentoTrem1(boolean controlerCritica1FuncionamentoTrem1) {
    Estrada.controlerCritica1FuncionamentoTrem1 = controlerCritica1FuncionamentoTrem1;
  } // fim do metodo setControlerCritica1FuncionamentoTrem1

  /* ***************************************************************
  * Metodo: setControlerNaoCritica2Trem1.
  * Funcao: alterar o valor da variavel controlerNaoCritica2Trem1.
  * Parametros: boolean controlerNaoCritica2Trem1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerNaoCritica2Trem1(boolean controlerNaoCritica2Trem1) {
    Estrada.controlerNaoCritica2Trem1 = controlerNaoCritica2Trem1;
  } // fim do metodo setControlerNaoCritica2Trem1

  /* ***************************************************************
  * Metodo: setControlerCritica2FuncionamentoTrem1.
  * Funcao: alterar o valor da variavel controlerCritica2FuncionamentoTrem1.
  * Parametros: boolean controlerCritica2FuncionamentoTrem1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerCritica2FuncionamentoTrem1(boolean controlerCritica2FuncionamentoTrem1) {
    Estrada.controlerCritica2FuncionamentoTrem1 = controlerCritica2FuncionamentoTrem1;
  } // fim do metodo setControlerCritica2FuncionamentoTrem1

  /* ***************************************************************
  * Metodo: setControlerNaoCritica3Trem1.
  * Funcao: alterar o valor da variavel controlerNaoCritica3Trem1.
  * Parametros: boolean controlerNaoCritica3Trem1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerNaoCritica3Trem1(boolean controlerNaoCritica3Trem1) {
    Estrada.controlerNaoCritica3Trem1 = controlerNaoCritica3Trem1;
  } // fim do metodo setControlerNaoCritica3Trem1

  // ---------------------------set-trem2----------------------------------------

  /* ***************************************************************
  * Metodo: setControlerNaoCritica1Trem2.
  * Funcao: alterar o valor da variavel controlerNaoCritica1Trem2.
  * Parametros: boolean controlerNaoCritica1Trem2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerNaoCritica1Trem2(boolean controlerNaoCritica1Trem2) {
    Estrada.controlerNaoCritica1Trem2 = controlerNaoCritica1Trem2;
  } // fim do metodo setControlerNaoCritica1Trem2

  /* ***************************************************************
  * Metodo: setControlerCritica1FuncionamentoTrem2.
  * Funcao: alterar o valor da variavel controlerCritica1FuncionamentoTrem2.
  * Parametros: boolean controlerCritica1FuncionamentoTrem2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerCritica1FuncionamentoTrem2(boolean controlerCritica1FuncionamentoTrem2) {
    Estrada.controlerCritica1FuncionamentoTrem2 = controlerCritica1FuncionamentoTrem2;
  } // fim do metodo setControlerCritica1FuncionamentoTrem2

  /* ***************************************************************
  * Metodo: setControlerNaoCritica2Trem2.
  * Funcao: alterar o valor da variavel controlerNaoCritica2Trem2.
  * Parametros: boolean controlerNaoCritica2Trem2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerNaoCritica2Trem2(boolean controlerNaoCritica2Trem2) {
    Estrada.controlerNaoCritica2Trem2 = controlerNaoCritica2Trem2;
  } // fim do metodo setControlerNaoCritica2Trem2

  /* ***************************************************************
  * Metodo: setControlerCritica2FuncionamentoTrem2.
  * Funcao: alterar o valor da variavel controlerCritica2FuncionamentoTrem2.
  * Parametros: boolean controlerCritica2FuncionamentoTrem2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerCritica2FuncionamentoTrem2(boolean controlerCritica2FuncionamentoTrem2) {
    Estrada.controlerCritica2FuncionamentoTrem2 = controlerCritica2FuncionamentoTrem2;
  } // fim do metodo setControlerCritica2FuncionamentoTrem2

  /* ***************************************************************
  * Metodo: setControlerNaoCritica3Trem2.
  * Funcao: alterar o valor da variavel controlerNaoCritica3Trem2.
  * Parametros: boolean controlerNaoCritica3Trem2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControlerNaoCritica3Trem2(boolean controlerNaoCritica3Trem2) {
    Estrada.controlerNaoCritica3Trem2 = controlerNaoCritica3Trem2;
  } // fim do metodo setControlerNaoCritica3Trem2

  //--------------------------------PETERSON----------------------------------
  
  /* ***************************************************************
  * Metodo: zerarVetores.
  * Funcao: passar os valores dos elementos dos vetores interesse e interesse2 para falso.
  * Parametros: nenhum.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public void zerarVetores(){
    for(int i=0; i<interesse.length;i++){
      interesse[i] = false;
    } // fim do primeiro for
    for(int i=0; i<interesse2.length;i++){
      interesse[i] = false;
    } // fim do segundo for
  } // fim do metodo zerarVetores

  /* ***************************************************************
  * Metodo: getInteresse.
  * Funcao: pegar o elemento do vetor interesse por meio da sua posicao, e retornar o valor desse elemento.
  * Parametros: int posicao.
  * Retorno: boolean.
  *************************************************************** */
  public static boolean getInteresse(int posicao) {
    boolean valor=false;
    for(int i=0; i<Estrada.interesse.length;i++){
      if(i==posicao){
        valor = Estrada.interesse[i];
      } // fim do if
    } // fim do for
    return valor;
  } // fim do metodo getInteresse

  /* ***************************************************************
  * Metodo: setInteresse.
  * Funcao: alterar o valor do elemento do vetor interesse por meio da sua posicao, e retornar o valor desse elemento.
  * Parametros: boolean interesseValor (qual valor quer dar ao elemento) e int posicao.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setInteresse(boolean interesseValor, int posicao) {
    for(int i=0; i<Estrada.interesse.length;i++){
      if(i==posicao){
        Estrada.interesse[i] = interesseValor;
      } // fim do if
    } // fim do for 
  } // fim do metodo setInteresse

  /* ***************************************************************
  * Metodo: getInteresse2.
  * Funcao: pegar o elemento do vetor interesse2 por meio da sua posicao, e retornar o valor desse elemento.
  * Parametros: int posicao.
  * Retorno: boolean.
  *************************************************************** */
  public static boolean getInteresse2(int posicao) {
    boolean valor=false;
    for(int i=0; i<Estrada.interesse2.length;i++){
      if(i==posicao){
        valor = Estrada.interesse2[i];
      } // fim do if
    } // fim do for
    return valor;
  } // fim do metodo getInteresse2

  /* ***************************************************************
  * Metodo: setInteresse2.
  * Funcao: alterar o valor do elemento do vetor interesse2 por meio da sua posicao, e retornar o valor desse elemento.
  * Parametros: boolean interesseValor (qual valor quer dar ao elemento) e int posicao.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setInteresse2(boolean interesseValor, int posicao) {
    for(int i=0; i<Estrada.interesse2.length;i++){
      if(i==posicao){
        Estrada.interesse2[i] = interesseValor;
      } // fim do if
    } // fim do for
  } // fim do metodo setInteresse2

  /* ***************************************************************
  * Metodo: getVez.
  * Funcao: retornar o valor da variavel vez.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getVez() {
    return vez;
  } // fim do metodo getVez

  /* ***************************************************************
  * Metodo: setVez.
  * Funcao: alterar o valor da variavel vez.
  * Parametros: int vez.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setVez(int vez) {
    Estrada.vez = vez;
  } // fim do metodo setVez

  /* ***************************************************************
  * Metodo: getVez2.
  * Funcao: retornar o valor da variavel vez2.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getVez2() {
    return vez2;
  } // fim do metodo getVez2

  /* ***************************************************************
  * Metodo: setVez2.
  * Funcao: alterar o valor da variavel vez2.
  * Parametros: int vez2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setVez2(int vez2) {
    Estrada.vez2 = vez2;
  } // fim do metodo setVez2

  /* ***************************************************************
  * Metodo: getControladorPetersonTrem1Zona1.
  * Funcao: retornar o valor da variavel controladorPetersonTrem1Zona1.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getControladorPetersonTrem1Zona1() {
    return controladorPetersonTrem1Zona1;
  } // fim do metodo getControladorPetersonTrem1Zona1

   /* ***************************************************************
  * Metodo: setControladorPetersonTrem1Zona1.
  * Funcao: alterar o valor da variavel controladorPetersonTrem1Zona1.
  * Parametros: int controladorPetersonTrem1Zona1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControladorPetersonTrem1Zona1(int controladorPetersonTrem1Zona1) {
    Estrada.controladorPetersonTrem1Zona1 = controladorPetersonTrem1Zona1;
  } // fim do metodo setControladorPetersonTrem1Zona1

  /* ***************************************************************
  * Metodo: getControladorPetersonTrem1Zona2.
  * Funcao: retornar o valor da variavel controladorPetersonTrem1Zona2.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getControladorPetersonTrem1Zona2() {
    return controladorPetersonTrem1Zona2;
  } // fim do metodo getControladorPetersonTrem1Zona2

  /* ***************************************************************
  * Metodo: setControladorPetersonTrem1Zona2.
  * Funcao: alterar o valor da variavel controladorPetersonTrem1Zona2.
  * Parametros: int controladorPetersonTrem1Zona2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControladorPetersonTrem1Zona2(int controladorPetersonTrem1Zona2) {
    Estrada.controladorPetersonTrem1Zona2 = controladorPetersonTrem1Zona2;
  } // fim do metodo setControladorPetersonTrem1Zona2

  /* ***************************************************************
  * Metodo: getControladorPetersonTrem2Zona1.
  * Funcao: retornar o valor da variavel controladorPetersonTrem2Zona1.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getControladorPetersonTrem2Zona1() {
    return controladorPetersonTrem2Zona1;
  } // fim do metodo getControladorPetersonTrem2Zona1

  /* ***************************************************************
  * Metodo: setControladorPetersonTrem2Zona1.
  * Funcao: alterar o valor da variavel controladorPetersonTrem2Zona1.
  * Parametros: int controladorPetersonTrem2Zona1.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControladorPetersonTrem2Zona1(int controladorPetersonTrem2Zona1) {
    Estrada.controladorPetersonTrem2Zona1 = controladorPetersonTrem2Zona1;
  } // fim do metodo setControladorPetersonTrem2Zona1

  /* ***************************************************************
  * Metodo: getControladorPetersonTrem2Zona2.
  * Funcao: retornar o valor da variavel controladorPetersonTrem2Zona2.
  * Parametros: nenhum.
  * Retorno: retorna um inteiro.
  *************************************************************** */
  public static int getControladorPetersonTrem2Zona2() {
    return controladorPetersonTrem2Zona2;
  }// fim do metodo getControladorPetersonTrem2Zona2

  /* ***************************************************************
  * Metodo: setControladorPetersonTrem2Zona2.
  * Funcao: alterar o valor da variavel controladorPetersonTrem2Zona2.
  * Parametros: int controladorPetersonTrem2Zona2.
  * Retorno: nao retorna nada, pois eh um void.
  *************************************************************** */
  public static void setControladorPetersonTrem2Zona2(int controladorPetersonTrem2Zona2) {
    Estrada.controladorPetersonTrem2Zona2 = controladorPetersonTrem2Zona2;
  } // fim do metodo setControladorPetersonTrem2Zona2

  //--------------------------------FINAL PETERSON--------------------------------------
} // final da class Estrada


