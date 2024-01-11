import java.util.concurrent.Semaphore;

public class Controlador{
  
  // semaforos das zonas criticas
  public static Semaphore semaforo1 = new Semaphore(1);
  public static Semaphore semaforo3 = new Semaphore(1);
  public static Semaphore semaforo4 = new Semaphore(1);
  public static Semaphore semaforo12 = new Semaphore(1);
  public static Semaphore semaforo5 = new Semaphore(1);
  public static Semaphore semaforo7 = new Semaphore(1);
  public static Semaphore semaforo9 = new Semaphore(1);
  public static Semaphore semaforo11 = new Semaphore(1);
  public static Semaphore semaforo13 = new Semaphore(1);
  public static Semaphore semaforo14 = new Semaphore(1);
  public static Semaphore semaforo15 = new Semaphore(1);
  public static Semaphore semaforo16 = new Semaphore(1);
  public static Semaphore semaforo18 = new Semaphore(1);
  public static Semaphore semaforo20 = new Semaphore(1);
  public static Semaphore semaforo22 = new Semaphore(1);
  public static Semaphore semaforo23 = new Semaphore(1);
  public static Semaphore semaforo24 = new Semaphore(1);
  public static Semaphore semaforo26 = new Semaphore(1);

  // semaforos com (2)
  public static Semaphore semaforo2 = new Semaphore(2);
  public static Semaphore semaforo6 = new Semaphore(2);
  public static Semaphore semaforo8 = new Semaphore(2);
  public static Semaphore semaforo10 = new Semaphore(2);
  public static Semaphore semaforo17 = new Semaphore(2);
  public static Semaphore semaforo19 = new Semaphore(2);
  public static Semaphore semaforo21 = new Semaphore(2);
  public static Semaphore semaforo25 = new Semaphore(2);

  
  // mapa, para fazer as alteracoes na interface.
  //public static Mapa mapinha = new Mapa();
  
  public Controlador(){

      // semaforo com (2), zonas de cruzamento

      //semaforo2 = new Semaphore(2);
      //semaforo6 = new Semaphore(2);
      //semaforo8 = new Semaphore(2);
      //semaforo10 = new Semaphore(2);
      //semaforo17 = new Semaphore(2);
      //semaforo19 = new Semaphore(2);
      //semaforo21 = new Semaphore(2);
      //semaforo25 = new Semaphore(2);


  } // fim do construro Controlador
} // fim da classe Controlador

