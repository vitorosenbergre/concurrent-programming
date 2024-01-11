/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 10/06/2021.
* Ultima alteracao: 18/06/2021.
* Nome do Programa: Circuito Automato.
* Classe: Carro.
* Funcao: Utilizando apenas uma classe para criar todos os carros, com metodos separados para cada cor.
* Responsavel pela movimentacao dos carros e responsavel por aplicar os mutex e semaphores.
*************************************************************** */
import javax.swing.JLabel;

// A Classe controlador apresenta quais sao os semaforos que compoem as regioes (Joao e Maria) citadas abaixo.
// Coloquei Maria e Joao porque me lembram das barreiras de um anime que assisti.
// Porque barreiras, bem, as regioes vao impedir que carros alem da cota da regiao, (no meu caso 3 permissoes), 
// nao acessem os outros semaforos que estao apos a permissao da regiao (Joao ou Maria), evintando assim um posterior
// deadlock ou starvation.
public class Carro extends Thread{
  
  // label do carro
  private JLabel carro;

  // mapa
  private Mapa mapa;

  // carro que vai ser escolhido
  private int cor;
  
  // velocidade do carro
  private int velocidade;

  //curva, variavel utilizada nos carros para evitar a repeticao
  //de alguns movimentos em determinados pontos
  private int curva =1;
  private int curvaRosa =1;
  private int curvaAzul =1;
  private int curvaPreta =1;
  private int curvaVermelha =1;
  private int curvaAmarelo =1;
  private int curvaVerde =1;

  //a maioria dos carros iniciam em zonas criticas, por isso a variavel
  //vez*** eh utilizada para adquirir aquela regiao no inicio.
  private int vezMarrom =0;
  private int vezRosa=0;
  private int vezAzul=0;
  private int vezPreto=0;
  private int vezVermelho=0;
  private int vezVerde=0;
  private int passeiRosa =0;

  public Carro(JLabel carro, int cor, int velocidade, Mapa mapa){
    this.carro = carro;
    this.cor = cor;
    this.velocidade = velocidade;
    this.mapa = mapa;
  } // fim do construtor da classe Carro

  // O que cada cor(int) representa
  // 1 = carro cinza
  // 2 = carro marrom
  // 3 = carro rosa
  // 4 = carro azul
  // 5 = carro preto
  // 6 = carro vermelho
  // 7 = carro amarelo
  // 8 = carro verde

  public void run(){
    while(true){
      try{
      switch(cor){
        case 1:
          movimentacaoCinza(this.carro);
          break;
        case 2:
          movimentacaoMarrom(this.carro);
          break;
        case 3:
          movimentacaoRosa(this.carro);
          break;
        case 4:
          movimentacaoAzul(this.carro);
          break;
        case 5:
          movimentacaoPreto(this.carro);
          break;
        case 6:
          movimentacaoVermelho(this.carro);
          break;
        case 7:
          movimentacaoAmarelo(this.carro);
          break;
        case 8:
          movimentacaoVerde(this.carro);
          break;
      } // fim do try
      sleep(getVelocidade());
      }catch (InterruptedException e) {
        e.printStackTrace();
      } // fim do catch
    }// fim do while
  } // fim do run

  //@Cinza
  /* ***************************************************************
  * Metodo: movimentacaoCinza
  * Funcao: Exerce a movimentacao do label(CarroCinza) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoCinza(JLabel carro) throws InterruptedException{
    if(carro.getX() ==20 && carro.getY()<515){
      carro.setLocation(carro.getX(), carro.getY()+1); // faz a movimentacao do label
      if(carro.getY()==130){ // verifica se tem algum carro na rua do circuito azul que tem contato com o circuito cinza
        Controlador.semaforo12.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getY()==390){
        Controlador.semaforo12.release(); // libera a passaguem da rua quando passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<61 && carro.getY()<555 && curva==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);  // faz a curva 
      if(carro.getY()==540){
        mapa.alterarDirecao("90", carro,1);
        carro.setSize(50, 30); // alterar o size do label pra caber a imagem
      } // fim do if
      if(carro.getY() == 555){
        curva =2;
      } // fim do if
      sleepi(10); 
    }else if(carro.getX()<800 && carro.getY()==555){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==100){// verifica se tem algum carro na rua do circuito amarelo que tem contato com o circuito cinza
        Controlador.semaforo24.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==350){// verifica se tem algum carro na rua do circuito verde que tem contato com o circuito cinza
        Controlador.semaforo26.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==440){ 
        Controlador.semaforo24.release();// libera a passaguem da rua quando passar.
      } // fim do if
      if(carro.getX()==670){
        Controlador.semaforo26.release();// libera a passaguem da rua quando passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<825 && carro.getY()>530){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1); // faz a curva 
      if(carro.getY()==540){
        mapa.alterarDirecao("0", carro,1);
        carro.setSize(30, 50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==825 && carro.getY()>30){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==430){ // verifica se tem algum carro na rua do circuito vermelho que tem contato com o circuito cinza
        Controlador.semaforo15.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } //fim do if
      if(carro.getY() == 165){
        Controlador.semaforo15.release(); // libera a passaguem da rua quando passar.
      } //fim do if
      sleepi(1);
    }else if(carro.getX()>814 && carro.getY()>20){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1); // faz a curva 
      if(carro.getY()==20){
        mapa.alterarDirecao("270", carro,1);
        carro.setSize(50, 30);
      } //fim do if
      sleepi(10);
    }else if(carro.getX()>30 && carro.getY()==20 && curva==2){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==680){// verifica se tem algum carro na rua do circuito rosa que tem contato com o circuito cinza
        Controlador.semaforo3.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } //fim do if
      if(carro.getX()==440){ // verifica se tem algum carro na rua do circuito marrom que tem contato com o circuito cinza
        Controlador.semaforo1.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } //fim do if
      if(carro.getX()==330){
        Controlador.semaforo3.release(); // libera a passaguem da rua quando passar.
      } //fim do if
      if(carro.getX()==150){
        Controlador.semaforo1.release(); // libera a passaguem da rua quando passar.
      }
      sleepi(1);
    }else if(carro.getX()>20 && carro.getY()<30 && curva ==2){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1); // faz a curva e comeca tudo novamente 
      if(carro.getX()==20){
        mapa.alterarDirecao("180", carro,1);
        carro.setSize(30,50);
        curva=1;
      } //fim do if
      sleepi(10);
    } // fim do else if
  }// fim do metodo movimentacaoCinza

  //@MARROM
  /* ***************************************************************
  * Metodo: movimentacaoMarrom
  * Funcao: Exerce a movimentacao do label(CarroMarrom) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoMarrom(JLabel carro) throws InterruptedException{

    // ja que o marrom ja inicia em uma rua que eh considerada uma area critica, entao ele ja 
    // bloqueia a rua para os outros carros nao passarem, esse eh o objetivo do if, ele soh ocorre no inicio.
    if(carro.getX() == 203 && carro.getY()==22 && vezMarrom ==0){
      Controlador.semaforo1.acquire();  
      vezMarrom=1;
    } //fim do if

    if(carro.getX()<400 && carro.getY() == 22){
      carro.setLocation(carro.getX()+1, carro.getY());
      sleepi(1); // trocar pra 5
      if(carro.getX()==330){  // verifica se tem algum carro na rua do circuito rosa que tem contato com o circuito marrom
        Controlador.semaforo4.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      }//fim do if
    }else if(carro.getX()<401 && carro.getY()< 23){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva
      if(carro.getY()==23){
        mapa.alterarDirecao("180", carro,2);
        carro.setSize(30,50);
      }//fim do if
      sleepi(10);
    }else if(carro.getX()==401 && carro.getY()<160){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(1); // trocar pra 5
      if(carro.getY()== 70){ 
        Controlador.semaforo1.release();  // libera a passaguem da rua quando passar.
      }//fim do if
      if(carro.getY()==125){ // verifica se tem algum carro na rua do circuito preto que tem contato com o circuito marrom
        Controlador.semaforo7.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      }//fim do if
    }else if(carro.getX()>375 && carro.getY()<186){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1); // faz a curva
      if(carro.getX()==390){ 
        mapa.alterarDirecao("270", carro,2);
        carro.setSize(50,30);
      }//fim do if
      sleepi(10);
    }else if(carro.getX()>180 && carro.getY()==186){ 
      carro.setLocation(carro.getX()-1, carro.getY());
        if(carro.getX() == 340){ 
          Controlador.semaforo4.release();   // libera a passaguem da rua quando passar.
        }//fim do if
        if(carro.getX()==310){ // verifica se tem algum carro na rua do circuito azul que tem contato com o circuito marrom
          Controlador.semaforo5.acquire();  // bloqueia a passaguem da rua se conseguir passar.
        }//fim do if
        if(carro.getX()==220){ 
          Controlador.semaforo7.release(); // libera a passaguem da rua quando passar.
        }//fim do if
      sleepi(1);
    }else if(carro.getX()>159 && carro.getY()>165){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getY()==178){
        mapa.alterarDirecao("0", carro,2);
        carro.setSize(30,50);
      }//fim do if
      sleepi(10);
    }else if(carro.getX()==159 && carro.getY()>30){ 
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==125){
        Controlador.semaforo5.release();  // libera a passaguem da rua quando passar.
      }//fim do if
      if(carro.getY()==45){ // verifica se tem algum carro na rua do circuito cinza que tem contato com o circuito marrom
        Controlador.semaforo1.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      }//fim do if
      sleepi(1);
    }else if(carro.getX()<167 && carro.getY()>22){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1); // faz a curva e se encontra no primeiro if
      if(carro.getX()==165){
        mapa.alterarDirecao("90", carro,2);
        carro.setSize(50,30);
      }//fim do if
      sleepi(10);
    }// fim do else if
  } // fim do metodo movimentacaoMarrom

  //-----------------------@ROSA
  /* ***************************************************************
  * Metodo: movimentacaoRosa
  * Funcao: Exerce a movimentacao do label(CarroRosa) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoRosa(JLabel carro) throws InterruptedException{

    // ja que o rosa inicia em uma rua que eh considerada uma area critica, entao ele ja 
    // bloqueia a rua para os outros carros nao passarem, esse eh o objetivo do if, ele soh ocorre no inicio.
    if(carro.getX()==400 && carro.getY()==62 && vezRosa==0){
      Controlador.semaforo4.acquire(); 
      vezRosa=1;   
    } // fim do if

    // um if que coloquei para acontecer da segunda rotacao do carro rosa ateh o fim do circuito,
    // pois no fim da primeira rotacao ele bloqueia a rua rosa com interferencia no cinza
    if(carro.getX()==400 && carro.getY()<166){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==80 && passeiRosa ==1){
        Controlador.semaforo3.release(); // bloqueia
      }// fim do if
      // jah que nessa encruzilhada pode ocorrer o encontro entre 3 carros e causar um deadlock, 
      // fiz o rosa analisar a rua proxima e a encruzilhada, se houver 1 carro querendo passar pela encruzilhada, 
      // entao tudo okay, porem se houver dois ou mais carros usando aquela encruzilhada, entao o rosa espera um deles
      // terminar de usar.
      if(carro.getY()==125){
        passeiRosa=1;
        // o semaforoMaria eh uma regiao grande que foi criada por conta da chance de dar deadlock, ela so 
        // permite 3 carros terem a intencao de passar por essa regiao, se chegar a 3, o quarto carro espera.
        Controlador.semaforoRose.acquire(); // @Rose
        Controlador.semaforoMaria.acquire(); //@Maria
        Controlador.semaforo10.acquire();  // tira uma permissao da encruzilhada
        Controlador.semaforo9.acquire();  
        // com a encruzilhada livre, agora verificar se pode acessar a rua preta com interseccao na rua rosa.
        // se sim, bloqueia a rua agora, se nao, espera desbloquear
      }// fim do if
      sleepi(1);
    }else if(carro.getX()<430 && carro.getY()<186 && curvaRosa==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva 
      if(carro.getY()== 170){
        mapa.alterarDirecao("90", carro,3);
        carro.setSize(50,30);
      }// fim do if
      if(carro.getY()==186){
        curvaRosa=2; 
      }// fim do if
      sleepi(10);
    }else if(carro.getX()<625 && carro.getY()==186){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==460){
        Controlador.semaforo4.release(); // libera a passaguem da rua quando passar.
      } // fim do if
      if(carro.getX()==470){// verifica se tem algum carro na rua do circuito vermelho que tem contato com o circuito rosa
        Controlador.semaforo11.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      }
      if(carro.getX()==550){ //libera a rua e encruzilhada, para os outros carros passarem.
        Controlador.semaforo10.release(); // libera uma permissao da encruzilhada.
        Controlador.semaforo9.release(); // libera a passaguem da rua quando passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<641 && carro.getY()>170){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1); // faz a curva
      if(carro.getY()== 176){
        mapa.alterarDirecao("0", carro,3);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==641 && carro.getY()>25){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==140){
        // sai da regiao do semaforoMaria
        Controlador.semaforo11.release(); // libera a passaguem da rua quando passar.
        Controlador.semaforoMaria.release(); //@Mariarelease
        Controlador.semaforoRose.release(); //@Roserelease
      } // fim do if
      if(carro.getY()==68){ // verifica se tem algum carro na rua do circuito cinza que tem contato com o circuito rosa
        Controlador.semaforo3.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()>634 && carro.getY()>18){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1); // faz a curva 
      sleepi(10);
    }else if(carro.getX()>410 && carro.getY()==18){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()== 440){ // verifica se tem algum carro na rua do circuito marrom que tem contato com o circuito rosa
        Controlador.semaforo4.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      }// fim do if
      if(carro.getX()== 633){
        mapa.alterarDirecao("270", carro,3);
        carro.setSize(50,30);
      }// fim do if
      sleepi(1);
    }else if(carro.getX()>400 && carro.getY()<28){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1); // faz a curva e se encontra no primeiro if
      if(carro.getX()== 400){
        mapa.alterarDirecao("180", carro,3);
        carro.setSize(30,50);
        curvaRosa =1; 
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoRosa

  //@AZUL
  /* ***************************************************************
  * Metodo: movimentacaoAzul
  * Funcao: Exerce a movimentacao do label(CarroAzul) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoAzul(JLabel carro) throws InterruptedException{
    // ja que o azul inicia em uma rua que eh considerada uma area critica, entao ele ja 
    // bloqueia a rua para os outros carros nao passarem, esse eh o objetivo do if, ele soh ocorre no inicio.
    if(carro.getX()==20 && carro.getY()==227 && vezAzul ==0){
      Controlador.semaforo12.acquire(); 
      vezAzul=1;
    } // fim do if
    if(carro.getX()==20 && carro.getY()<350){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(1);
    }else if(carro.getX()<56 && carro.getY()<376 && curvaAzul==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva
      if(carro.getX()== 38){
        mapa.alterarDirecao("90", carro,4);
        carro.setSize(50,30);
      } // fim do if
      if(carro.getY()==376){
        curvaAzul=2;
      } // fim do if
      sleepi(10);
    }else if(carro.getX()<260 && carro.getY()==376){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==80){
        Controlador.semaforo12.release(); // libera a passaguem da rua quando passar, pois iniciou na regiao.
      } // fim do if
      if(carro.getX()==100){
        // jah que nessa encruzilhada pode ocorrer o encontro entre 3 carros e causar um deadlock, 
      // fiz o joao analisar a rua proxima e a encruzilhada, se houver 1 carro querendo passar pela encruzilhada, 
      // entao tudo okay, porem se houver dois ou mais carros usando aquela encruzilhada, entao o azul espera um deles
      // terminar de usar.
        Controlador.semaforoJoao.acquire(); // @Joao
        Controlador.semaforo17.acquire(); // 17 vai ser a encruzilhada 
        Controlador.semaforo16.acquire(); // verifica se pode pegar a rua do circuito amarelo que pertence tambem ao
        // circuito azul.
         // o semaforoJoao eh uma regiao grande que foi criada por conta da chance de dar deadlock, ela so 
        // permite 3 carros terem a intencao de passar por essa regiao, se chegar a 3, o quarto carro espera
      } // fim do if
      if(carro.getX()==213){ // verifica se tem algum carro na rua do circuito preto que tem contato com o circuito azul
        Controlador.semaforo13.acquire(); 
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<281 && carro.getY()>355){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()== 273){
        mapa.alterarDirecao("0", carro,4);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==281 && carro.getY()>190){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==330){
        Controlador.semaforo17.release(); // libera 1 permissao da encruzilhada
        Controlador.semaforo16.release(); // libera a passaguem da rua quando passar, pois iniciou na regiao.
      } // fim do if 
      if(carro.getY()== 228){ // verifica se tem algum carro na rua do circuito marrom que tem contato com o circuito azul
        Controlador.semaforo5.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()>276 && carro.getY()>185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()== 276){
        mapa.alterarDirecao("270", carro,4);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()>20 && carro.getY()==185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()); // faz a curva
      sleepi(1);
      if(carro.getX()==220){
        Controlador.semaforo13.release(); // libera a passaguem da rua quando passar, pois iniciou na regiao.
        Controlador.semaforoJoao.release(); // sai da regiao Joao, dando uma permissao para a regiao @Joaorelease
      } // fim do if
      if(carro.getX()==120){
        Controlador.semaforo5.release();  // libera a passaguem da rua quando passar, pois iniciou na regiao.
      } // fim do if
      if(carro.getX()==70){ // verifica se tem algum carro na rua do circuito cinza que tem contato com o circuito azul
        Controlador.semaforo12.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==20){
        mapa.alterarDirecao("180", carro,4); 
        carro.setSize(30,50);
        curvaAzul =1;
      } // fim do if
    } // fim do else if
  } // fim do metodo movimentacaoAzul
  
  //@PRETO
  /* ***************************************************************
  * Metodo: movimentacaoPreto
  * Funcao: Exerce a movimentacao do label(CarroPreto) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoPreto(JLabel carro) throws InterruptedException{

    // ja que o preto inicia em uma rua que eh considerada uma area critica, entao ele ja 
    // bloqueia a rua para os outros carros nao passarem, esse eh o objetivo do if, ele soh ocorre no inicio.
    // o carro preto inicia na regiao Joao, entao ele ja tem 1 permissao da regiao
    if(carro.getX()==279 && carro.getY()==227 && vezPreto==0){
      Controlador.semaforo17.acquire(); // pede uma permissao da encruzilhada entre os circuitos azul,amarelo,preto
      Controlador.semaforo13.acquire(); 
      vezPreto =1;
    } // fim do if

    if(carro.getX()==279 && carro.getY()<355){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==320){
        Controlador.semaforoRose.acquire(); //  @Rose pega 1 permissao do semaforo rose
        // pede uma permissao da encruzilhada entre os circuitos amarelo,preto,verde
        Controlador.semaforo19.acquire();
        // verifica se tem algum carro na rua do circuito amarelo que tem contato com o circuito preto
        Controlador.semaforo18.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<313 && carro.getY()<378 && curvaPreta==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva 
      if(carro.getX()== 289){
        mapa.alterarDirecao("90", carro,5);
        carro.setSize(50,30);
      } // fim do if
      if(carro.getY()==378){
        curvaPreta=2;
      } // fim do if
      sleepi(10);
    }else if(carro.getX()<505 && carro.getY()==378){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==330){
        Controlador.semaforo17.release();  // libera uma permissao da encruzilhada azul,amarelo,preto
        Controlador.semaforo13.release(); // libera a passaguem da rua quando passar, pois iniciou na regiao.
      } // fim do if
      if(carro.getX()==340){
        // pede permissao pra entrar na regiao Maria, se houver 3, entao ele espera 
        Controlador.semaforoMaria.acquire(); // @Maria
        Controlador.semaforo21.acquire(); // pede permissao para encruzilhada vermelho,verde,preto
        // verifica se tem algum carro na rua do circuito verde que tem contato com o circuito preto
        Controlador.semaforo20.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==420){
        Controlador.semaforo19.release();   // libera uma permissao da encruzilhada amarelo, verde, preto
        Controlador.semaforo18.release(); // libera a passaguem da rua quando passar
      } // fim do if
      if(carro.getX()==453){
        Controlador.semaforo10.acquire(); // pede permissao para encruzilhada vermelho,verde,preto
        // verifica se tem algum carro na rua do circuito vermelho que tem contato com o circuito preto
        Controlador.semaforo14.acquire();   // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<520 && carro.getY()>363){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1); // faz a curva
      if(carro.getX()== 520){
        mapa.alterarDirecao("0", carro,5);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);         
    }else if(carro.getX()==520 && carro.getY()>190){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==325){
        Controlador.semaforo21.release();    // libera uma permissao da encruzilhada verde, vermelho ,preto
        Controlador.semaforo20.release();  // libera a passaguem da rua quando passar
        // saiu da regiao Joao, entao ele libera uma permissao.
        Controlador.semaforoJoao.release(); // @Joaorelease
      } // fim do if
      if(carro.getY()==228){ // verifica se tem algum carro na rua do circuito rosa que tem contato com o circuito preto
        Controlador.semaforo9.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
      // verificar o semaforo no y = 228
    }else if(carro.getX()>515 && carro.getY()>185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1); // faz a curva 
      if(carro.getX()== 515){
        mapa.alterarDirecao("270", carro,5);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()>279 && carro.getY()==185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()); 
      if(carro.getX()==470){
        Controlador.semaforo10.release();  // libera uma permissao da encruzilhada rosa,vermelho,preto
        Controlador.semaforo14.release();  // libera a passaguem da rua quando passar
        Controlador.semaforoRose.release(); //@Rose
      } // fim do if
      if(carro.getX()==440){// verifica se tem algum carro na rua do circuito marrom que tem contato com o circuito preto
        Controlador.semaforo7.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==350){
        Controlador.semaforo9.release(); // libera a passaguem da rua quando passar
        Controlador.semaforoMaria.release(); // libera uma permissao para a regiao Maria. @Maria
      } // fim do if
      if(carro.getX()==330){
        Controlador.semaforoJoao.acquire(); // pede uma permissao para a regiao Joao. @Joao
        Controlador.semaforo17.acquire(); // pede permissao para encruzilhada azul,amarelo,preto
        // verifica se tem algum carro na rua do circuito azul que tem contato com o circuito preto
        Controlador.semaforo13.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==279){
        Controlador.semaforo7.release(); // libera a passaguem da rua quando passar
        mapa.alterarDirecao("180", carro,5);
        carro.setSize(30,50);
        curvaPreta =1;
      } // fim do if
      sleepi(1);
    } // fim do else if
  } //fim do metodo movimentacaoPreto

  //@VERMELHO
  /* ***************************************************************
  * Metodo: movimentacaoVermelho
  * Funcao: Exerce a movimentacao do label(CarroVermelho) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoVermelho(JLabel carro) throws InterruptedException{
    // ja que o vermelho inicia em uma rua que eh considerada uma area critica, entao ele ja 
    // bloqueia a rua para os outros carros nao passarem, esse eh o objetivo do if, ele soh ocorre no inicio.
    // o carro preto inicia na regiao Maria, entao ele ja tem 1 permissao da regiao
    if(carro.getX()==520 && carro.getY()==225 && vezVermelho==0){
      Controlador.semaforo21.acquire(); 
      Controlador.semaforo14.acquire(); 
      vezVermelho=1;
    } // fim do if

    if(carro.getX() == 520 & carro.getY()<350){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(1);
      if(carro.getY()==313){// verifica se tem algum carro na rua do circuito verde que tem contato com o circuito vermelho
        Controlador.semaforo22.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
    }else if(carro.getX()< 547 & carro.getY()<377 && curvaVermelha==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva
      if(carro.getX()==535){
        mapa.alterarDirecao("90", carro,6);
        carro.setSize(50,30);
      } // fim do if
      if(carro.getX()==547){
        curvaVermelha=2;
      } // fim do if
      sleepi(10);          
    }else if(carro.getX()<800 & carro.getY()==377){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==575){
        Controlador.semaforo21.release(); // libera uma permissao da encruzilhada verde, vermelho ,preto
        Controlador.semaforo14.release();  // libera a passaguem da rua quando passar
      } // fim do if
      if(carro.getX()==670){
        Controlador.semaforo22.release();  // libera a passaguem da rua quando passar
        Controlador.semaforoMaria.release(); //libera uma permissao da regiao Maria @Mariarelease
        Controlador.semaforoRose.release(); // @Rose
      } // fim do if
      if(carro.getX()==755){// verifica se tem algum carro na rua do circuito cinza que tem contato com o circuito vermelho
        Controlador.semaforo15.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()< 825 & carro.getY()>352){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1); // faz a curva
      if(carro.getX()==815){
        mapa.alterarDirecao("0", carro,6);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()== 825 & carro.getY()>195){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      sleepi(1);
    }else if(carro.getX()> 815 & carro.getY()>185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1); // faz a curva
      if(carro.getX()==820){
        mapa.alterarDirecao("270", carro,6);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()> 525 & carro.getY()==185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==770){
        Controlador.semaforo15.release();  // libera a passaguem da rua quando passar
      } // fim do if
      if(carro.getX()==680){
        Controlador.semaforoMaria.acquire(); // pediu uma permissao para a regiao Maria @Maria
        Controlador.semaforoRose.acquire(); // @rose
        Controlador.semaforo10.acquire();  //pediu permissao para a  encruzilhada rosa,vermelho,preto
        // verifica se tem algum carro na rua do circuito rosa que tem contato com o circuito vermelho
        Controlador.semaforo11.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      if(carro.getX()==550){
        Controlador.semaforo21.acquire(); //pediu permissao para a encruzilhada verde, vermelho ,preto
        // verifica se tem algum carro na rua do circuito preto que tem contato com o circuito vermelho
        Controlador.semaforo14.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      }
      sleepi(1);
    }else if(carro.getX()>520 && carro.getY()<190){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1); // faz a curva 
      if(carro.getX()==520){
        Controlador.semaforo10.release();  // libera uma permissao da encruzilhada rosa,vermelho,preto
        Controlador.semaforo11.release(); // libera a passaguem da rua quando passar
        mapa.alterarDirecao("180", carro,6);
        carro.setSize(30,50);
        curvaVermelha=1;
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoVermelho

  //@AMARELO
  /* ***************************************************************
  * Metodo: movimentacaoAmarelo
  * Funcao: Exerce a movimentacao do label(CarroAmarelo) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoAmarelo(JLabel carro) throws InterruptedException{

    if(carro.getX() ==159 && carro.getY()<530){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY() == 493){// verifica se tem algum carro na rua do circuito cinza que tem contato com o circuito amarelo
        Controlador.semaforo24.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<187 && carro.getY()<556 && curvaAmarelo==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva 
      if(carro.getX()==173){
        mapa.alterarDirecao("90", carro,7);
        carro.setSize(50,30);
      } // fim do if
      if(carro.getY()==556){
        curvaAmarelo =2;
      } // fim do if
      sleepi(10);
    }else if(carro.getX()<380 && carro.getY()==556){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==333){
        Controlador.semaforoJoao.acquire(); // pede permissao a regiao Joao @Joao
        Controlador.semaforoRose.acquire(); // @Rose
        Controlador.semaforo19.acquire(); // pede permissao a encruzilhada amarelo, verde, preto
        // verifica se tem algum carro na rua do circuito verde que tem contato com o circuito amarelo
        Controlador.semaforo23.acquire();   // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<402 && carro.getY()>524){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1); // faz a curva
      if(carro.getX()==390){
        mapa.alterarDirecao("0", carro,7);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==402 && carro.getY()>380){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==500){
        Controlador.semaforo24.release(); // liberar a passagem da rua que passou
      } // fim do if
      if(carro.getY()==420){
        Controlador.semaforo17.acquire();  // pede permissao a encruzilhada azul,amarelo,preto
        // verifica se tem algum carro na rua do circuito preto que tem contato com o circuito amarelo
        Controlador.semaforo18.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()>397 && carro.getY()>375){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()==397){
        mapa.alterarDirecao("270", carro,7);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()>165 && carro.getY()==375){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==365){
        Controlador.semaforo19.release(); // libera a encruzilhada azul,amarelo,preto
        Controlador.semaforo23.release(); // liberar a passagem da rua que passou
      } // fim do if
      if(carro.getX()==330){// verifica se tem algum carro na rua do circuito azul que tem contato com o circuito amarelo
        Controlador.semaforo16.acquire();   // bloqueia a passaguem da rua se conseguir passar.
      }
      if(carro.getX() == 240){
        Controlador.semaforo17.release(); // libera a encruzilhada encruzilhada azul,amarelo,preto
        Controlador.semaforo18.release(); // liberar a passagem da rua que passou
        Controlador.semaforoRose.release(); // @Rose
      } // fim do if
      sleepi(1);
    }else if(carro.getX()>159 && carro.getY()<381){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==159){
        Controlador.semaforo16.release();  // liberar a passagem da rua que passou
        Controlador.semaforoJoao.release(); // libera uma permissao para a regiao Joao. @Joaorelease
        mapa.alterarDirecao("180", carro,7);
        carro.setSize(30,50);
        curvaAmarelo =1;
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoAmarelo

  //@VERDE
   /* ***************************************************************
  * Metodo: movimentacaoVerde
  * Funcao: Exerce a movimentacao do label(CarroVerde) por seu determinado circuito
  * e utiliza o semaphore para evitar que os carros se choquem.
  * Parametros: JLabel carro
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void movimentacaoVerde(JLabel carro) throws InterruptedException{
    // ja que o verde inicia em uma rua que eh considerada uma area critica, entao ele ja 
    // bloqueia a rua para os outros carros nao passarem, esse eh o objetivo do if, ele soh ocorre no inicio.
    // o carro verde inicia na regiao Joao, entao ele ja tem 1 permissao da regiao
    if(carro.getX() == 400 && carro.getY()==418 && vezVerde==0){
      Controlador.semaforo23.acquire();
      vezVerde =1;
    } // fim do if

    if(carro.getX()==400 && carro.getY()<530){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==490){// verifica se tem algum carro na rua do circuito cinza que tem contato com o circuito verde
        Controlador.semaforo26.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<428 && carro.getY()<556 && curvaVerde==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1); // faz a curva
      if(carro.getX()==415){
        mapa.alterarDirecao("90", carro,8);
        carro.setSize(50,30);
      } // fim do if
      if(carro.getY()==556){
        curvaVerde =2;
      } // fim do if
      sleepi(10);
    }else if(carro.getX()<620 && carro.getY()==556){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY());

      if(carro.getX()==455){
        Controlador.semaforo23.release();  // libera a passagem da rua que estava
        Controlador.semaforoJoao.release(); // libera uma permissao da regiao Joao @Joaorelease
        Controlador.semaforoRose.release(); // @Rose
      } // fim do if
      sleepi(1);
    }else if(carro.getX()<640 && carro.getY()>504){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==635){
        mapa.alterarDirecao("0", carro,8);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==640 && carro.getY()>380){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==470){ 
        Controlador.semaforo26.release();// libera a passagem da rua que estava
      } // fim do if
      if(carro.getY()==410){ 
        Controlador.semaforoMaria.acquire(); // pede permissao a regiao Maria para poder continuar @Maria
        Controlador.semaforoRose.acquire(); // @Rose
        Controlador.semaforo21.acquire(); //pede permissao para a encruzilhada verde, vermelho ,preto
        // verifica se tem algum carro na rua do circuito vermelho que tem contato com o circuito verde
        Controlador.semaforo22.acquire();  // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()>635 && carro.getY()>375){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      sleepi(10);
      if(carro.getX()==635){
        mapa.alterarDirecao("270", carro,8);
        carro.setSize(50,30);
      } // fim do if
    }else if(carro.getX()>410 && carro.getY()==375){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==570){
        Controlador.semaforoJoao.acquire(); // pede permissao para a regiao Joao para poder continuar. @Joao
        Controlador.semaforo19.acquire(); //pede permissao para a encruzilhada amarelo, verde, preto
        // verifica se tem algum carro na rua do circuito preto que tem contato com o circuito verde
        Controlador.semaforo20.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      }
      if(carro.getX()==510){// fazer analise
        Controlador.semaforo21.release();  // libera uma permissao na encruzilhada verde, vermelho ,preto
        Controlador.semaforo22.release();  // libera a passagem da rua que estava
      } // fim do if
      if(carro.getX()==447){// verifica se tem algum carro na rua do circuito amarelo que tem contato com o circuito verde
        Controlador.semaforo23.acquire(); // bloqueia a passaguem da rua se conseguir passar.
      } // fim do if
      sleepi(1);
    }else if(carro.getX()>400 && carro.getY()<385){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==400){
        Controlador.semaforo19.release();  // libera uma permissao na encruzilhada amarelo, verde, preto
        Controlador.semaforo20.release();  // libera a passagem da rua que estava
        Controlador.semaforoMaria.release(); // libera uma permissao da regiao Maria. @Mariarelease
        mapa.alterarDirecao("180", carro,8);
        carro.setSize(30,50);
        curvaVerde =1;
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoVerde

  /* ***************************************************************
  * Metodo: sleepi.
  * Funcao: faz o papel do sleep. Criado para poupar linhas do try-catch.
  * Parametros: int valor.
  * Retorno: eh um void, nao retorna nada.
  *************************************************************** */
  public void sleepi(int valor){
    try {
      sleep(valor);
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch 
  } //fim do metodo sleepi

  /* ***************************************************************
  * Metodo: getCarro().
  * Funcao: retorna a variavel carro(JLabel).
  * Parametros: nenhum.
  * Retorno: JLabel carro.
  *************************************************************** */
  public JLabel getCarro() {
    return carro;
  } // fim do metodo getCarro

   /* ***************************************************************
  * Metodo: setCarro.
  * Funcao: altera o Jlabel carro.
  * Parametros: JLabel carro.
  * Retorno: nenhum.
  *************************************************************** */
  public void setCarro(JLabel carro) {
    this.carro = carro;
  } //fim do metodo setCarro

  /* ***************************************************************
  * Metodo: getCor().
  * Funcao: retorna a variavel int cor, que representa o carro a partir de um inteiro.
  * Parametros: nenhum.
  * Retorno: int cor.
  *************************************************************** */
  public int getCor() {
    return cor;
  } // fim do metodo getCor

   /* ***************************************************************
  * Metodo: setCor.
  * Funcao: altera o int cor.
  * Parametros: int cor.
  * Retorno: nenhum.
  *************************************************************** */
  public void setCor(int cor) {
    this.cor = cor;
  } // fim do metodo setCor

  /* ***************************************************************
  * Metodo: getVelocidade().
  * Funcao: retorna a variavel int velocidade.
  * Parametros: nenhum.
  * Retorno: int velocidade.
  *************************************************************** */
  public int getVelocidade() {
    return velocidade;
  } // fim do metodo getVelocidade

  /* ***************************************************************
  * Metodo: setVelocidade.
  * Funcao: altera o int velocidade.
  * Parametros: int velocidade.
  * Retorno: nenhum.
  *************************************************************** */
  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  } // fim do metodo setVelocidade
  
  /* ***************************************************************
  * Metodo: getMapa().
  * Funcao: retorna a variavel Mapa mapa.
  * Parametros: nenhum.
  * Retorno: Mapa mapa.
  *************************************************************** */
  public Mapa getMapa() {
    return mapa;
  } // fim do metodo getMapa()

   /* ***************************************************************
  * Metodo: setMapa()
  * Funcao: altera o Mapa map.
  * Parametros: Mapa mapa.
  * Retorno: nenhum.
  *************************************************************** */
  public void setMapa(Mapa mapa) {
    this.mapa = mapa;
  } // fim do metodo setMapa
} // fim da classe Carro
