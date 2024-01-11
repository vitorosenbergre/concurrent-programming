/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 11/04/2021.
* Ultima alteracao: 17/04/2021.
* Classe: Estrada.
* Funcao: Controla as movimentacoes dos trens no mapa, junto com os acessos e posicoes.
*************************************************************** */

import javax.swing.JLabel;

public class Estrada {

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

  // construtor vazio
  public Estrada(){}

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
    controlerCritica1Verificar = false; 

    if(trem.getX()>99 && trem.getY()<240){ 
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);  
    }else if(trem.getX()<360 && trem.getY()==240){  //fim do if
      trem.setBounds(trem.getX()+2,trem.getY(), 100, 40);
    } // fim do else if

    if(trem.getY()<=240 && trem.getX()>= 360){
      controlerCritica1FuncionamentoTrem1 = false;
      controlerNaoCritica2Trem1 =true;
      controlerCritica1Verificar = true;
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
    controlerCritica2Verificar = false;
    if(trem.getX()<=660 && trem.getY()<=240){ 
      trem.setBounds(trem.getX(),trem.getY()+2, 100, 40);
    }else if(trem.getX()<=770 && trem.getY()<=242){ // fim do if
      trem.setBounds(trem.getX()+2,trem.getY(), 100, 40); 
    } // fim do else if

    if(trem.getX()==770 && trem.getY()==242){
      controlerCritica2FuncionamentoTrem1 = false; 
      controlerNaoCritica3Trem1 =true;
      controlerCritica2Verificar = true;
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

    controlerCritica1Verificar = false;
    if(trem.getX()>=345 && trem.getY()>=242){
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40);
    }else if(trem.getX()>=250 && trem.getY()<=240){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40);
    } // fim do else if

    if(trem.getX()<=250 && trem.getY()<=240){
      controlerCritica1FuncionamentoTrem2 = false;
      controlerNaoCritica1Trem2 = true;
      controlerCritica1Verificar = true;
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
    controlerCritica2Verificar = false;
    if(trem.getX()<=776 && trem.getY()>=246){
      trem.setBounds(trem.getX(),trem.getY()-2, 100, 40); 
    }else if(trem.getX()>=645 && trem.getY()<=246){ // fim do if
      trem.setBounds(trem.getX()-2,trem.getY(), 100, 40); 
    } // fim do else if

    if(trem.getX()<=645 && trem.getY()<=246){
      controlerCritica2FuncionamentoTrem2 = false;
      controlerNaoCritica2Trem2 = true;
      controlerCritica2Verificar = true;
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
}


