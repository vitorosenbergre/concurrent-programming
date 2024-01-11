/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo
* Matricula: 201912182
* Inicio: 10/06/2021
* Ultima alteracao: 18/06/2021
* Nome do Programa: Circuito Automato.
* Classe: Controlador.
* Funcao: Armazenar os semaphores que vao ser utilizados no circuito.
*************************************************************** */
import java.util.concurrent.Semaphore;

public class Controlador{
  
  // mutex, representando a rua.
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

  // semaforos responsaveis pelas encruzilhadas, envitando deadlock, pois soh dois carros sao capazes de passar com a espera.
  public static Semaphore semaforo10 = new Semaphore(2); // encruzilhada rosa,vermelho,preto
  public static Semaphore semaforo17 = new Semaphore(2); // encruzilhada azul,amarelo,preto
  public static Semaphore semaforo19 = new Semaphore(2); // encruzilhada amarelo, verde, preto
  public static Semaphore semaforo21 = new Semaphore(2); // encruzilhada verde, vermelho ,preto

  // houveram duas regioes que tiveram mais de 1 deadlock, por isso criei um semaphore com n-1 permissoes
  // que representava uma regiao maior para as threads, n sendo a quantidade de threads que 
  // precisam acessar aquela regiao maior, e eh usado n-1 para evitar o deadlock com os n carros. 
  // A regiao maior aceita no maximo n-1 carros. 

  // O semaforo que representa a regiao Joao( com os semaforos 13,16,17,18,19,20,23) comeca com 1
  // por conta de haver 2 carros que iniciam o circuito dentro dessa regiao
  public static Semaphore semaforoJoao = new Semaphore(1); // comecam com 3

  // O semaforo que representa a regiao Maria( com os semaforos 9,10,11,14,20,21,22) comeca com 2
  // por conta de haver 1 carro que inicia o circuito dentro dessa regiao
  public static Semaphore semaforoMaria = new Semaphore(2); // comecam com 3

  public static Semaphore semaforoRose = new Semaphore(2); // comecam com 4

} // fim da classe Controlador

