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
// concertar a leitura do x do carro vermelho, esta batendo com o cinza
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
      sleepi(getVelocidade());
      }catch (InterruptedException e) {
        e.printStackTrace();
      } // fim do catch
    }// fim do while
  } // fim do run

  public void movimentacaoCinza(JLabel carro) throws InterruptedException{
    if(carro.getX() ==20 && carro.getY()<515){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==130){
        Controlador.semaforo12.acquire();
      } // fim do if
      if(carro.getY()==390){
        Controlador.semaforo12.release();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<61 && carro.getY()<555 && curva==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
      if(carro.getX()==100){
        //Controlador.semaforo25.acquire();
        Controlador.semaforo24.acquire();
      } // fim do if
      if(carro.getX()==350){
        Controlador.semaforo26.acquire();
      } // fim do if
      if(carro.getX()==440){
        //Controlador.semaforo25.release();
        Controlador.semaforo24.release();
      } // fim do if
      if(carro.getX()==670){
        Controlador.semaforo26.release();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<825 && carro.getY()>530){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getY()==540){
        mapa.alterarDirecao("0", carro,1);
        carro.setSize(30, 50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==825 && carro.getY()>30){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==430){
        Controlador.semaforo15.acquire();
      } //fim do if
      if(carro.getY() == 165){
        Controlador.semaforo15.release();
      } //fim do if
      sleepi(5);
    }else if(carro.getX()>814 && carro.getY()>20){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getY()==20){
        mapa.alterarDirecao("270", carro,1);
        carro.setSize(50, 30);
      } //fim do if
      sleepi(10);
    }else if(carro.getX()>30 && carro.getY()==20 && curva==2){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==680){
        //Controlador.semaforo2.acquire();
        Controlador.semaforo3.acquire();
      } //fim do if
      if(carro.getX()==440){
        Controlador.semaforo1.acquire();
      } //fim do if
      if(carro.getX()==330){
        //Controlador.semaforo2.release();
        Controlador.semaforo3.release();
      } //fim do if
      if(carro.getX()==170){
        Controlador.semaforo1.release();
      }
      sleepi(5);
    }else if(carro.getX()>20 && carro.getY()<30 && curva ==2){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==20){
        mapa.alterarDirecao("180", carro,1);
        carro.setSize(30,50);
        curva=1;
      } //fim do if
      sleepi(10);
    } // fim do else if
  }// fim do metodo movimentacaoCinza

  //@MARROM
  public void movimentacaoMarrom(JLabel carro) throws InterruptedException{

    if(carro.getX() == 203 && carro.getY()==22 && vezMarrom ==0){
      //Controlador.semaforo2.acquire();
      Controlador.semaforo1.acquire();  
      vezMarrom=1;
    } //fim do if

    if(carro.getX()<400 && carro.getY() == 22){
      carro.setLocation(carro.getX()+1, carro.getY());
      sleepi(5); // trocar pra 5
      if(carro.getX()==330){
        //Controlador.semaforo8.acquire();
        Controlador.semaforo4.acquire(); 
      }//fim do if
    }else if(carro.getX()<401 && carro.getY()< 23){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getY()==23){
        mapa.alterarDirecao("180", carro,2);
        carro.setSize(30,50);
      }//fim do if
      sleepi(10);
    }else if(carro.getX()==401 && carro.getY()<160){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(5); // trocar pra 5
      if(carro.getY()== 70){
        //Controlador.semaforo2.release();
        Controlador.semaforo1.release(); 
      }//fim do if
      if(carro.getY()==125){
        //Controlador.semaforo6.acquire(); // primeiro as encruzilhadas  
        Controlador.semaforo7.acquire();
      }//fim do if
    }else if(carro.getX()>375 && carro.getY()<186){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==390){
        mapa.alterarDirecao("270", carro,2);
        carro.setSize(50,30);
      }//fim do if
      sleepi(10);
    }else if(carro.getX()>180 && carro.getY()==186){ 
      carro.setLocation(carro.getX()-1, carro.getY());
        if(carro.getX() == 340){ 
          //Controlador.semaforo8.release();
          Controlador.semaforo4.release();  
        }//fim do if
        if(carro.getX()==310){
          Controlador.semaforo5.acquire(); 
        }//fim do if
        if(carro.getX()==220){
          //Controlador.semaforo6.release(); 
          Controlador.semaforo7.release(); 
        }//fim do if
      sleepi(5);
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
        Controlador.semaforo5.release(); 
      }//fim do if
      if(carro.getY()==45){
        //Controlador.semaforo2.acquire();
        Controlador.semaforo1.acquire();
      }//fim do if
      sleepi(5);
    }else if(carro.getX()<167 && carro.getY()>22){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==165){
        mapa.alterarDirecao("90", carro,2);
        carro.setSize(50,30);
      }//fim do if
      sleepi(10);
    }// fim do else if
  } // fim do metodo movimentacaoMarrom

  //-----------------------@ROSA
  public void movimentacaoRosa(JLabel carro) throws InterruptedException{

    if(carro.getX()==400 && carro.getY()==62 && vezRosa==0){
      //Controlador.semaforo8.acquire();
      Controlador.semaforo4.acquire(); 
      vezRosa=1;   
    } // fim do if

    if(carro.getX()==400 && carro.getY()<166){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==80 && passeiRosa ==1){
        //Controlador.semaforo2.release();
        Controlador.semaforo3.release();
      }// fim do if
      if(carro.getY()==125){
        passeiRosa=1;
        Controlador.semaforo10.acquire();  
        Controlador.semaforo11.acquire(); 
        Controlador.semaforo9.acquire(); 
      }// fim do if
      sleepi(5);
    }else if(carro.getX()<430 && carro.getY()<186 && curvaRosa==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
      if(carro.getX()==480){
        //Controlador.semaforo8.release(); 
        Controlador.semaforo4.release();
      } // fim do if
      if(carro.getX()==490){
        //Controlador.semaforo11.acquire();
      }
      if(carro.getX()==550){
        Controlador.semaforo10.release();
        Controlador.semaforo9.release();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<641 && carro.getY()>170){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getY()== 176){
        mapa.alterarDirecao("0", carro,3);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==641 && carro.getY()>25){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==140){
        Controlador.semaforo11.release(); 
      } // fim do if
      if(carro.getY()==68){
        //Controlador.semaforo2.acquire();
        Controlador.semaforo3.acquire();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()>634 && carro.getY()>18){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      sleepi(10);
    }else if(carro.getX()>410 && carro.getY()==18){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()== 440){
        //Controlador.semaforo8.acquire();
        Controlador.semaforo4.acquire();
      }// fim do if
      if(carro.getX()== 633){
        mapa.alterarDirecao("270", carro,3);
        carro.setSize(50,30);
      }// fim do if
      sleepi(5);
    }else if(carro.getX()>400 && carro.getY()<28){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()== 400){
        mapa.alterarDirecao("180", carro,3);
        carro.setSize(30,50);
        curvaRosa =1; 
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoRosa

  //@AZUL
  public void movimentacaoAzul(JLabel carro) throws InterruptedException{
    if(carro.getX()==20 && carro.getY()==227 && vezAzul ==0){
      Controlador.semaforo12.acquire(); 
      vezAzul=1;
    } // fim do if

    if(carro.getX()==20 && carro.getY()<350){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(5);
    }else if(carro.getX()<56 && carro.getY()<376 && curvaAzul==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
        Controlador.semaforo12.release(); 
      } // fim do if
      if(carro.getX()==100){
        Controlador.semaforo17.acquire();
        //Controlador.semaforo23.acquire(); // novo 
        Controlador.semaforo16.acquire();
      } // fim do if
      if(carro.getX()==213){
        //Controlador.semaforo6.acquire();
        Controlador.semaforo13.acquire(); 
      } // fim do if
      sleepi(5);
      // x = 213 verificar semaforo
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
        Controlador.semaforo17.release();
        //Controlador.semaforo23.release(); 
        Controlador.semaforo16.release();
      } // fim do if
      if(carro.getY()== 228){
        Controlador.semaforo5.acquire();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()>276 && carro.getY()>185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()== 276){
        mapa.alterarDirecao("270", carro,4);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()>20 && carro.getY()==185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      sleepi(5);
      if(carro.getX()==220){
        //Controlador.semaforo6.release(); 
        Controlador.semaforo13.release();
      } // fim do if
      if(carro.getX()==120){
        Controlador.semaforo5.release(); 
      } // fim do if
      if(carro.getX()==70){
        Controlador.semaforo12.acquire();
      } // fim do if
      if(carro.getX()==20){
        mapa.alterarDirecao("180", carro,4);
        carro.setSize(30,50);
        curvaAzul =1;
      } // fim do if
    } // fim do else if
  } // fim do metodo movimentacaoAzul
  
  //@PRETO
  public void movimentacaoPreto(JLabel carro) throws InterruptedException{

    if(carro.getX()==279 && carro.getY()==227 && vezPreto==0){
      Controlador.semaforo17.acquire();
      Controlador.semaforo13.acquire(); 
      vezPreto =1;
    } // fim do if

    if(carro.getX()==279 && carro.getY()<355){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==320){
        Controlador.semaforo21.acquire();
        Controlador.semaforo19.acquire();
        Controlador.semaforo20.acquire();
        Controlador.semaforo18.acquire();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<313 && carro.getY()<378 && curvaPreta==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
        Controlador.semaforo17.release();  
        Controlador.semaforo13.release();
      } // fim do if
      if(carro.getX()==340){
       // Controlador.semaforo21.acquire();
        //Controlador.semaforo20.acquire();
      } // fim do if
      if(carro.getX()==420){
        Controlador.semaforo19.release(); 
        Controlador.semaforo18.release();
      } // fim do if
      if(carro.getX()==453){
        Controlador.semaforo10.acquire();
        Controlador.semaforo14.acquire(); 
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<520 && carro.getY()>363){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()== 520){
        mapa.alterarDirecao("0", carro,5);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);         
    }else if(carro.getX()==520 && carro.getY()>190){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==325){
        Controlador.semaforo21.release(); 
        Controlador.semaforo20.release();
      } // fim do if
      if(carro.getY()==228){
        //Controlador.semaforo10.acquire(); 
        //Controlador.semaforo6.acquire();
        //Controlador.semaforo8.acquire();
        //Controlador.semaforo7.acquire();
        Controlador.semaforo9.acquire();
      } // fim do if
      sleepi(5);
      // verificar o semaforo no y = 228
    }else if(carro.getX()>515 && carro.getY()>185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()== 515){
        mapa.alterarDirecao("270", carro,5);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()>279 && carro.getY()==185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==470){
        Controlador.semaforo10.release(); 
        Controlador.semaforo14.release(); 
      } // fim do if
      if(carro.getX()==440){
        //Controlador.semaforo6.acquire();
        Controlador.semaforo7.acquire();
      } // fim do if
      if(carro.getX()==350){
        //Controlador.semaforo8.release(); 
        Controlador.semaforo9.release();
      } // fim do if
      if(carro.getX()==330){
        Controlador.semaforo17.acquire();
        Controlador.semaforo13.acquire(); 
      } // fim do if
      if(carro.getX()==279){
        //Controlador.semaforo6.release();
        Controlador.semaforo7.release();
        
        mapa.alterarDirecao("180", carro,5);
        carro.setSize(30,50);
        curvaPreta =1;
      } // fim do if
      sleepi(5);
    } // fim do else if
  } //fim do metodo movimentacaoPreto

  //@VERMELHO
  public void movimentacaoVermelho(JLabel carro) throws InterruptedException{
    
    if(carro.getX()==520 && carro.getY()==225 && vezVermelho==0){
      Controlador.semaforo21.acquire();
      //Controlador.semaforo22.acquire();
      Controlador.semaforo14.acquire(); 
      vezVermelho=1;
    } // fim do if

    if(carro.getX() == 520 & carro.getY()<350){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(5);
      if(carro.getY()==313){
        Controlador.semaforo22.acquire();
      } // fim do if
    }else if(carro.getX()< 547 & carro.getY()<377 && curvaVermelha==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
        Controlador.semaforo21.release(); 
        Controlador.semaforo14.release();
      } // fim do if
      if(carro.getX()==670){
        Controlador.semaforo22.release(); 
      } // fim do if
      if(carro.getX()==755){
        Controlador.semaforo15.acquire();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()< 825 & carro.getY()>352){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==815){
        mapa.alterarDirecao("0", carro,6);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()== 825 & carro.getY()>195){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      sleepi(5);
    }else if(carro.getX()> 815 & carro.getY()>185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()==820){
        mapa.alterarDirecao("270", carro,6);
        carro.setSize(50,30);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()> 525 & carro.getY()==185){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==770){
        Controlador.semaforo15.release(); 
      } // fim do if
      if(carro.getX()==680){
        Controlador.semaforo21.acquire();
        Controlador.semaforo10.acquire();  
        Controlador.semaforo14.acquire();
        Controlador.semaforo11.acquire();
      } // fim do if
      if(carro.getX()==550){
        //Controlador.semaforo21.acquire();
        //Controlador.semaforo22.acquire(); talvez aqui, testar
        //Controlador.semaforo14.acquire();
      }
      sleepi(5);
    }else if(carro.getX()>520 && carro.getY()<190){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==520){
        Controlador.semaforo10.release(); 
        Controlador.semaforo11.release();
        mapa.alterarDirecao("180", carro,6);
        carro.setSize(30,50);
        curvaVermelha=1;
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoVermelho

  //@AMARELO
  public void movimentacaoAmarelo(JLabel carro) throws InterruptedException{

    if(carro.getX() ==159 && carro.getY()<530){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY() == 493){
        Controlador.semaforo24.acquire();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<187 && carro.getY()<556 && curvaAmarelo==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
        //Controlador.semaforo17.acquire();
        //Controlador.semaforo19.acquire();
        //Controlador.semaforo18.acquire();
        //Controlador.semaforo25.acquire(); 
        Controlador.semaforo19.acquire();
        Controlador.semaforo23.acquire();  
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<402 && carro.getY()>524){ // fim do else if
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==390){
        mapa.alterarDirecao("0", carro,7);
        carro.setSize(30,50);
      } // fim do if
      sleepi(10);
    }else if(carro.getX()==402 && carro.getY()>380){ // fim do else if
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==500){
        //Controlador.semaforo25.release(); 
        Controlador.semaforo24.release();
      } // fim do if
      if(carro.getY()==420){
        Controlador.semaforo17.acquire(); 
        Controlador.semaforo16.acquire();
        Controlador.semaforo18.acquire();
      } // fim do if
      sleepi(5);
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
        Controlador.semaforo19.release();
        Controlador.semaforo23.release();
      } // fim do if
      if(carro.getX()==330){
        //Controlador.semaforo16.acquire();
      }
      if(carro.getX() == 240){
        Controlador.semaforo17.release(); 
        Controlador.semaforo18.release();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()>159 && carro.getY()<381){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==159){
        Controlador.semaforo16.release(); 
        mapa.alterarDirecao("180", carro,7);
        carro.setSize(30,50);
        curvaAmarelo =1;
      } // fim do if
      sleepi(10);
    } // fim do else if
  } // fim do metodo movimentacaoAmarelo

  //@VERDE
  public void movimentacaoVerde(JLabel carro) throws InterruptedException{
    
    if(carro.getX() == 400 && carro.getY()==418 && vezVerde==0){
      //Controlador.semaforo25.acquire();
      Controlador.semaforo23.acquire();
      vezVerde =1;
    } // fim do if

    if(carro.getX()==400 && carro.getY()<530){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==490){
        //Controlador.semaforo25.acquire();
        Controlador.semaforo26.acquire();
      } // fim do if
      sleepi(5);
    }else if(carro.getX()<428 && carro.getY()<556 && curvaVerde==1){ // fim do if
      carro.setLocation(carro.getX()+1, carro.getY()+1);
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
        //Controlador.semaforo25.release(); 
        Controlador.semaforo23.release();  
      } // fim do if
      sleepi(5);
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
        Controlador.semaforo26.release();
      } // fim do if
      if(carro.getY()==410){
        //Controlador.semaforo25.acquire();
        //Controlador.semaforo19.acquire();   
        Controlador.semaforo21.acquire(); 
        //Controlador.semaforo23.acquire();
        //Controlador.semaforo20.acquire();
        Controlador.semaforo22.acquire();
      } // fim do if
      sleepi(5);
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
        Controlador.semaforo19.acquire();
        Controlador.semaforo20.acquire();
      }
      if(carro.getX()==510){// fazer analise
        Controlador.semaforo21.release();    
        Controlador.semaforo22.release(); 
      } // fim do if
      if(carro.getX()==447){
        //Controlador.semaforo25.acquire(); // poderia continuar com acquire do 25 aqui
        Controlador.semaforo23.acquire();// 
      } // fim do if
      sleepi(5);
      // x = 447 colocar 1 semaforo
    }else if(carro.getX()>400 && carro.getY()<385){ // fim do else if
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==400){
        Controlador.semaforo19.release(); 
        Controlador.semaforo20.release();
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
