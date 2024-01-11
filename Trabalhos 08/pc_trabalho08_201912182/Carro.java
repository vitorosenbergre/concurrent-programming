import javax.swing.JLabel;

public class Carro extends Thread{
  
  // label do carro
  private JLabel carro;

  // mapa
  private Mapa mapa;

  // carro que vai ser escolhido
  private int cor;
  
  // velocidade do carro
  private int velocidade;

  //curva
  private int curva =1;
  private int curvaRosa =1;
  private int curvaAzul =1;
  private int curvaPreta =1;
  private int curvaVermelha =1;
  private int curvaAmarelo =1;
  private int curvaVerde =1;

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
  }

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
      } // concertar a leitura do x do carro vermelho, esta batendo com
      sleepi(getVelocidade());
      }catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void movimentacaoCinza(JLabel carro) throws InterruptedException{
    if(carro.getX() ==20 && carro.getY()<515){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==130){
        Controlador.semaforo12.acquire();
      }
      if(carro.getY()==390){
        Controlador.semaforo12.release();
      }
      sleepi(5);
      //usar semaforo aqui no y = 493
    }else if(carro.getX()<61 && carro.getY()<555 && curva==1){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getY()==540){
        mapa.alterarDirecao("90", carro,1);
        carro.setSize(50, 30); // alterar o size do label pra caber a imagem
      }
      if(carro.getY() == 555){
        curva =2;
      }
      sleepi(10); 
    }else if(carro.getX()<800 && carro.getY()==555){
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==100){
        Controlador.semaforo25.acquire();
        Controlador.semaforo24.acquire();
      }
      if(carro.getX()==350){
        Controlador.semaforo26.acquire();
      }
      if(carro.getX()==440){
        Controlador.semaforo25.release();
        Controlador.semaforo24.release();
      }
      if(carro.getX()==670){
        Controlador.semaforo26.release();
      }
      sleepi(5);
      // usar semaforo no x = 755
    }else if(carro.getX()<825 && carro.getY()>530){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getY()==540){
        mapa.alterarDirecao("0", carro,1);
        carro.setSize(30, 50);
      }
      sleepi(10);
    }else if(carro.getX()==825 && carro.getY()>30){
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getX()==430){
        Controlador.semaforo15.acquire();
      }
      if(carro.getY() == 165){
        Controlador.semaforo15.release();
      }
      sleepi(5);
      //usar semaforo no y = 63
    }else if(carro.getX()>814 && carro.getY()>20){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getY()==20){
        mapa.alterarDirecao("270", carro,1);
        carro.setSize(50, 30);
      }
      sleepi(10);
    }else if(carro.getX()>30 && carro.getY()==20 && curva==2){
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==680){
        Controlador.semaforo2.acquire();
        Controlador.semaforo3.acquire();
      }
      if(carro.getX()==440){
        Controlador.semaforo1.acquire();
      }
      if(carro.getX()==330){
        Controlador.semaforo2.release();
        Controlador.semaforo3.release();
      }
      if(carro.getX()==170){
        Controlador.semaforo1.release();
      }
      sleepi(5);
      // usar semaforo no x = 70
    }else if(carro.getX()>20 && carro.getY()<30 && curva ==2){
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==20){
        mapa.alterarDirecao("180", carro,1);
        carro.setSize(30,50);
        curva=1;
      }
      sleepi(10);
    }
  }
  //@MARROM
  public void movimentacaoMarrom(JLabel carro) throws InterruptedException{

    if(carro.getX() == 203 && carro.getY()==22 && vezMarrom ==0){
      Controlador.semaforo2.acquire();
      Controlador.semaforo1.acquire();  
      vezMarrom=1;
    }

    if(carro.getX()<400 && carro.getY() == 22){
      carro.setLocation(carro.getX()+1, carro.getY());
      sleepi(5); // trocar pra 5
      //x = 335 eh onde vai lancar a verificacao do semaforo
      if(carro.getX()==330){
        Controlador.semaforo8.acquire();
        Controlador.semaforo4.acquire(); // perguntando se pode aceesar o 4 
      }
    }else if(carro.getX()<401 && carro.getY()< 23){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getY()==23){
        mapa.alterarDirecao("180", carro,2);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()==401 && carro.getY()<160){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(5); // trocar pra 5
      if(carro.getY()== 70){
        Controlador.semaforo2.release();
        Controlador.semaforo1.release(); 
      }
      if(carro.getY()==125){
        Controlador.semaforo6.acquire(); // primeiro as encruzilhadas  
        Controlador.semaforo7.acquire();
      }
      // y = 125 eh onde vai lancar a verificacao do semaforo
    }else if(carro.getX()>375 && carro.getY()<186){
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==390){
        mapa.alterarDirecao("270", carro,2);
        carro.setSize(50,30);
      }// x entra no outro if =375 e y = 186
      sleepi(10);
    }else if(carro.getX()>180 && carro.getY()==186){ // x = 205 ele verifica o semaforo
      carro.setLocation(carro.getX()-1, carro.getY());
        if(carro.getX() == 340){ //ou 360, verificar ainda
          Controlador.semaforo8.release();
          Controlador.semaforo4.release(); //liberar a passagem pro 4  
        }
        if(carro.getX()==310){
          Controlador.semaforo5.acquire(); 
        }
        if(carro.getX()==220){
          Controlador.semaforo6.release(); // verificar se tira o 6 tbm quando tiver no 5
          Controlador.semaforo7.release(); 
        }
      sleepi(5);
    }else if(carro.getX()>159 && carro.getY()>165){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getY()==178){
        mapa.alterarDirecao("0", carro,2);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()==159 && carro.getY()>30){ // y = 63 ele verifica o semaforo
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==125){
        Controlador.semaforo5.release(); 
      }
      if(carro.getY()==45){
        Controlador.semaforo2.acquire();
        Controlador.semaforo1.acquire();
      }
      sleepi(5);
    }else if(carro.getX()<167 && carro.getY()>22){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==165){
        mapa.alterarDirecao("90", carro,2);
        carro.setSize(50,30);
      }
      sleepi(10);
    }
  }
  //-----------------------@ROSA
  public void movimentacaoRosa(JLabel carro) throws InterruptedException{

    if(carro.getX()==400 && carro.getY()==62 && vezRosa==0){
      Controlador.semaforo8.acquire();
      Controlador.semaforo4.acquire(); // pq ele ja inicia no 4 
      vezRosa=1;   
    }

    if(carro.getX()==400 && carro.getY()<166){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==80 && passeiRosa ==1){
        Controlador.semaforo2.release(); 
        Controlador.semaforo3.release();
      }
      if(carro.getY()==125){
        passeiRosa=1;
        System.out.println("--");
        Controlador.semaforo10.acquire(); // a ordem dos semaforos importa!! 
        System.out.println("b");
        Controlador.semaforo11.acquire();
        System.out.println("c");
        Controlador.semaforo9.acquire();
        System.out.println("d");
      }
      sleepi(5);
      // y = 125 fazer a verificacao do semaforo
    }else if(carro.getX()<430 && carro.getY()<186 && curvaRosa==1){ // curvaRosa
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getY()== 170){
        mapa.alterarDirecao("90", carro,3);
        carro.setSize(50,30);
      }
      if(carro.getY()==186){
        curvaRosa=2; // curvaRosa
      }
      sleepi(10);
    }else if(carro.getX()<625 && carro.getY()==186){
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==480){//ou 490 
        Controlador.semaforo8.release();
        //Controlador.semaforo14.release();  
        Controlador.semaforo4.release();
      } 
      if(carro.getX()==550){// olhar aqui
        Controlador.semaforo10.release(); 
        Controlador.semaforo9.release();
      }
      sleepi(5);
      // faz a verificacao do semaforo no x = 575
    }else if(carro.getX()<641 && carro.getY()>170){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getY()== 176){
        mapa.alterarDirecao("0", carro,3);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()==641 && carro.getY()>25){
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==140){
        Controlador.semaforo11.release(); 
      }
      if(carro.getY()==68){
        Controlador.semaforo2.acquire(); 
        Controlador.semaforo3.acquire();
      }
      sleepi(5);
      // y = 62 para fazer a verificacao do semaforo
    }else if(carro.getX()>634 && carro.getY()>18){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      sleepi(10);
    }else if(carro.getX()>410 && carro.getY()==18){
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()== 440){
        Controlador.semaforo8.acquire();
        Controlador.semaforo4.acquire();
      }
      if(carro.getX()== 633){
        mapa.alterarDirecao("270", carro,3);
        carro.setSize(50,30);
      }
      sleepi(5);
      // x = 445 pra fazer a verificacao
    }else if(carro.getX()>400 && carro.getY()<28){
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()== 400){
        mapa.alterarDirecao("180", carro,3);
        carro.setSize(30,50);
        curvaRosa =1; // curva rosa
      }
      sleepi(10);
    }
  }

  //@AZUL
  public void movimentacaoAzul(JLabel carro) throws InterruptedException{
    if(carro.getX()==20 && carro.getY()==227 && vezAzul ==0){
      Controlador.semaforo12.acquire(); 
      vezAzul=1;
    }

    if(carro.getX()==20 && carro.getY()<350){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(5);
      // y = 315 verificar semaforo
    }else if(carro.getX()<56 && carro.getY()<376 && curvaAzul==1){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getX()== 38){
        mapa.alterarDirecao("90", carro,4);
        carro.setSize(50,30);
      }
      if(carro.getY()==376){
        curvaAzul=2;
      }
      sleepi(10);
    }else if(carro.getX()<260 && carro.getY()==376){
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==80){
        Controlador.semaforo12.release(); 
      }
      if(carro.getX()==100){
        //Controlador.semaforo17.acquire(); 
        Controlador.semaforo16.acquire();
      }
      if(carro.getX()==213){
        Controlador.semaforo6.acquire();
        Controlador.semaforo17.acquire();
        Controlador.semaforo13.acquire(); 
      }
      sleepi(5);
      // x = 213 verificar semaforo
    }else if(carro.getX()<281 && carro.getY()>355){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()== 273){
        mapa.alterarDirecao("0", carro,4);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()==281 && carro.getY()>190){
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==330){
        Controlador.semaforo17.release(); 
        Controlador.semaforo16.release();
      }
      if(carro.getY()== 228){
        Controlador.semaforo5.acquire();
      }
      sleepi(5);
      // verificar semaforo no y = 228
    }else if(carro.getX()>276 && carro.getY()>185){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()== 276){
        mapa.alterarDirecao("270", carro,4);
        carro.setSize(50,30);
      }
      sleepi(10);
    }else if(carro.getX()>20 && carro.getY()==185){
      carro.setLocation(carro.getX()-1, carro.getY());
      sleepi(5);
      if(carro.getX()==220){
        Controlador.semaforo6.release(); 
        Controlador.semaforo13.release();
      }
      if(carro.getX()==120){
        Controlador.semaforo5.release(); 
      }
      if(carro.getX()==70){
        Controlador.semaforo12.acquire();
      }
      if(carro.getX()==20){
        mapa.alterarDirecao("180", carro,4);
        carro.setSize(30,50);
        curvaAzul =1;
      }
      // verificar o semaforo no x = 68
    }
  }
  
  //@PRETO
  public void movimentacaoPreto(JLabel carro) throws InterruptedException{

    if(carro.getX()==279 && carro.getY()==227 && vezPreto==0){
      Controlador.semaforo17.acquire();
      Controlador.semaforo13.acquire(); 
      vezPreto =1;
    }

    if(carro.getX()==279 && carro.getY()<355){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==320){
        //Controlador.semaforo21.acquire();
        Controlador.semaforo19.acquire();
        //Controlador.semaforo17.acquire(); 
        Controlador.semaforo18.acquire();
        //Controlador.semaforo18.acquire();
      }
      sleepi(5);
    }else if(carro.getX()<313 && carro.getY()<378 && curvaPreta==1){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getX()== 289){
        mapa.alterarDirecao("90", carro,5);
        carro.setSize(50,30);
      }
      if(carro.getY()==378){
        curvaPreta=2;
      }
      sleepi(10);
    }else if(carro.getX()<505 && carro.getY()==378){
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==330){
        Controlador.semaforo17.release();  
        Controlador.semaforo13.release();
      }
      if(carro.getX()==340){
        Controlador.semaforo21.acquire();
        Controlador.semaforo20.acquire();
      }
      if(carro.getX()==420){
        Controlador.semaforo19.release(); 
        Controlador.semaforo18.release();
      }
      if(carro.getX()==453){
        //Controlador.semaforo10.acquire();
        Controlador.semaforo10.acquire(); 
        Controlador.semaforo14.acquire(); 
      }
      sleepi(5);
      // x = 453 pra verificar no semaforo
    }else if(carro.getX()<520 && carro.getY()>363){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()== 520){
        mapa.alterarDirecao("0", carro,5);
        carro.setSize(30,50);
      }
      sleepi(10);         
    }else if(carro.getX()==520 && carro.getY()>190){
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==325){
        Controlador.semaforo21.release(); 
        Controlador.semaforo20.release();
      }
      if(carro.getY()==228){
        //Controlador.semaforo6.acquire();
        Controlador.semaforo8.acquire();
        //Controlador.semaforo7.acquire();
        Controlador.semaforo9.acquire();
      }
      sleepi(5);
      // verificar o semaforo no y = 228
    }else if(carro.getX()>515 && carro.getY()>185){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()== 515){
        mapa.alterarDirecao("270", carro,5);
        carro.setSize(50,30);
      }
      sleepi(10);
    }else if(carro.getX()>279 && carro.getY()==185){
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==470){
        Controlador.semaforo10.release(); // dps ver e tira aqui msm nesse momento
        Controlador.semaforo14.release(); 
      }
      if(carro.getX()==440){
        Controlador.semaforo6.acquire();
        Controlador.semaforo7.acquire();
      }
      if(carro.getX()==350){
        Controlador.semaforo8.release(); 
        Controlador.semaforo9.release();
      }
      if(carro.getX()==330){
        Controlador.semaforo13.acquire(); 
      }
      if(carro.getX()==279){
        Controlador.semaforo6.release();
        Controlador.semaforo7.release();
        
        mapa.alterarDirecao("180", carro,5);
        carro.setSize(30,50);
        curvaPreta =1;
      }
      sleepi(5);
    }
  }

  //@VERMELHO
  public void movimentacaoVermelho(JLabel carro) throws InterruptedException{
    
    if(carro.getX()==520 && carro.getY()==225 && vezVermelho==0){
      Controlador.semaforo14.acquire(); 
      vezVermelho=1;
    }

    if(carro.getX() == 520 & carro.getY()<350){
      carro.setLocation(carro.getX(), carro.getY()+1);
      sleepi(5);
      if(carro.getY()==313){
        //Controlador.semaforo21.acquire(); 
        Controlador.semaforo22.acquire();
      }
      // verifica semaforo com y = 313
    }else if(carro.getX()< 547 & carro.getY()<377 && curvaVermelha==1){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getX()==535){
        mapa.alterarDirecao("90", carro,6);
        carro.setSize(50,30);
      }
      if(carro.getX()==547){
        curvaVermelha=2;
      }
      sleepi(10);          
    }else if(carro.getX()<800 & carro.getY()==377){
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==575){
        Controlador.semaforo21.release(); 
        Controlador.semaforo14.release();
      }
      if(carro.getX()==670){
        Controlador.semaforo22.release(); 
      }
      if(carro.getX()==755){
        Controlador.semaforo15.acquire();
      }
      sleepi(5);
      // x = 755 verifica semaforo 
    }else if(carro.getX()< 825 & carro.getY()>352){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==815){
        mapa.alterarDirecao("0", carro,6);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()== 825 & carro.getY()>195){
      carro.setLocation(carro.getX(), carro.getY()-1);
      sleepi(5);
      // y = 230 verifica o semaforo
    }else if(carro.getX()> 815 & carro.getY()>185){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()==820){
        mapa.alterarDirecao("270", carro,6);
        carro.setSize(50,30);
      }
      sleepi(10);
    }else if(carro.getX()> 525 & carro.getY()==185){
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==770){
        Controlador.semaforo15.release(); 
      }
      if(carro.getX()==740){
        System.out.println("aaa"); 
        Controlador.semaforo21.acquire();
        Controlador.semaforo14.acquire();
        Controlador.semaforo10.acquire(); 
        Controlador.semaforo11.acquire();
      }
      if(carro.getX()==580){
        //Controlador.semaforo21.acquire();
      }
      sleepi(5);
    }else if(carro.getX()>520 && carro.getY()<190){
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==520){
        Controlador.semaforo10.release(); 
        Controlador.semaforo11.release();
        mapa.alterarDirecao("180", carro,6);
        carro.setSize(30,50);
        curvaVermelha=1;
      }
      sleepi(10);
    }
  }

  //@AMARELO
  public void movimentacaoAmarelo(JLabel carro) throws InterruptedException{

    if(carro.getX() ==159 && carro.getY()<530){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY() == 493){
        Controlador.semaforo25.acquire(); 
        Controlador.semaforo24.acquire();
      }
      sleepi(5);
      // verifica y = 493 o semaforo
    }else if(carro.getX()<187 && carro.getY()<556 && curvaAmarelo==1){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getX()==173){
        mapa.alterarDirecao("90", carro,7);
        carro.setSize(50,30);
      }
      if(carro.getY()==556){
        curvaAmarelo =2;
      }
      sleepi(10);
    }else if(carro.getX()<380 && carro.getY()==556){
      carro.setLocation(carro.getX()+1, carro.getY());
      if(carro.getX()==333){
        Controlador.semaforo19.acquire();
        Controlador.semaforo23.acquire(); // talvez pegar o semaforo 19 tbm 
      }
      sleepi(5);
      // verifica semaforo com x= 333
    }else if(carro.getX()<402 && carro.getY()>524){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==390){
        mapa.alterarDirecao("0", carro,7);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()==402 && carro.getY()>380){
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==500){
        Controlador.semaforo25.release(); 
        Controlador.semaforo24.release();
      }
      if(carro.getY()==420){
        Controlador.semaforo17.acquire(); 
        //Controlador.semaforo19.acquire();
        Controlador.semaforo16.acquire();
        Controlador.semaforo18.acquire();
      }
      sleepi(5);
      // y = 420 faz a verificacao do semaforo
    }else if(carro.getX()>397 && carro.getY()>375){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      if(carro.getX()==397){
        mapa.alterarDirecao("270", carro,7);
        carro.setSize(50,30);
      }
      sleepi(10);
    }else if(carro.getX()>165 && carro.getY()==375){
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==365){
        Controlador.semaforo19.release();
        Controlador.semaforo23.release();
      }
      if(carro.getX() == 240){
        Controlador.semaforo17.release(); 
        Controlador.semaforo18.release();
      }
      sleepi(5);
      // x = 205 faz a verificacao do semaforo
    }else if(carro.getX()>159 && carro.getY()<381){
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==159){
        Controlador.semaforo16.release(); 
        mapa.alterarDirecao("180", carro,7);
        carro.setSize(30,50);
        curvaAmarelo =1;
      }
      sleepi(10);
    }
  }

  //@VERDE
  public void movimentacaoVerde(JLabel carro) throws InterruptedException{
    
    if(carro.getX() == 400 && carro.getY()==418 && vezVerde==0){
      Controlador.semaforo25.acquire();
      Controlador.semaforo23.acquire();
      vezVerde =1;
    }

    if(carro.getX()==400 && carro.getY()<530){
      carro.setLocation(carro.getX(), carro.getY()+1);
      if(carro.getY()==490){
        //Controlador.semaforo25.acquire();
        Controlador.semaforo26.acquire();
      }
      sleepi(5);
    }else if(carro.getX()<428 && carro.getY()<556 && curvaVerde==1){
      carro.setLocation(carro.getX()+1, carro.getY()+1);
      if(carro.getX()==415){
        mapa.alterarDirecao("90", carro,8);
        carro.setSize(50,30);
      }
      if(carro.getY()==556){
        curvaVerde =2;
      }
      sleepi(10);
    }else if(carro.getX()<620 && carro.getY()==556){
      carro.setLocation(carro.getX()+1, carro.getY());

      if(carro.getX()==455){
        Controlador.semaforo25.release();
        Controlador.semaforo23.release();
      }
      sleepi(5);
      // verifica semaforo com x= 575
    }else if(carro.getX()<640 && carro.getY()>504){
      carro.setLocation(carro.getX()+1, carro.getY()-1);
      if(carro.getX()==635){
        mapa.alterarDirecao("0", carro,8);
        carro.setSize(30,50);
      }
      sleepi(10);
    }else if(carro.getX()==640 && carro.getY()>380){
      carro.setLocation(carro.getX(), carro.getY()-1);
      if(carro.getY()==470){ //ou 480
        Controlador.semaforo26.release();
      }
      if(carro.getY()==410){
        Controlador.semaforo19.acquire();
        Controlador.semaforo21.acquire();
        Controlador.semaforo20.acquire();
        Controlador.semaforo22.acquire();
      }
      sleepi(5);
    }else if(carro.getX()>635 && carro.getY()>375){
      carro.setLocation(carro.getX()-1, carro.getY()-1);
      sleepi(10);
      if(carro.getX()==635){
        mapa.alterarDirecao("270", carro,8);
        carro.setSize(50,30);
      }
    }else if(carro.getX()>410 && carro.getY()==375){
      carro.setLocation(carro.getX()-1, carro.getY());
      if(carro.getX()==510){// fazer analise
        Controlador.semaforo21.release();
        Controlador.semaforo22.release();
      }
      if(carro.getX()==447){
        Controlador.semaforo25.acquire();
        Controlador.semaforo23.acquire();
      }
      sleepi(5);
      // x = 447 colocar 1 semaforo
    }else if(carro.getX()>400 && carro.getY()<385){
      carro.setLocation(carro.getX()-1, carro.getY()+1);
      if(carro.getX()==400){
        Controlador.semaforo19.release();
        Controlador.semaforo20.release();
        mapa.alterarDirecao("180", carro,8);
        carro.setSize(30,50);
        curvaVerde =1;
      }
      sleepi(10);
    }
  }

  public void sleepi(int valor){
    try {
      sleep(valor);
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch 
  } //fim do metodo sleepi

  
  public JLabel getCarro() {
    return carro;
  }

  public void setCarro(JLabel carro) {
    this.carro = carro;
  }

  public int getCor() {
    return cor;
  }

  public void setCor(int cor) {
    this.cor = cor;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }
  
  public Mapa getMapa() {
    return mapa;
  }

  public void setMapa(Mapa mapa) {
    this.mapa = mapa;
  }

}
