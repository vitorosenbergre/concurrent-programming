import java.lang.Thread;

// PAI
class Pai extends Thread {
  private static int cont = 0;

  public void run() {
    System.out.println("O pai Nasceu!");
    try {

      sleep(22000);
      Filho1 filho1 = new Filho1("O filho 1 nasceu!", 16000); // tempo que o neto1 nasce
      filho1.start();
      sleep(3000);
      Filho2 filho2 = new Filho2("O filho 2 nasceu!", 20000); // tempo que o neto 2 nasce
      filho2.start();
      sleep(7000);
      Filho3 filho3 = new Filho3("O filho 3 nasceu!", 0); // neto 3 n nasce
      filho3.start();
      sleep(58000);
      System.out.println("O pai morreu!");

    } catch (InterruptedException e) { // fim do catch
      // TODO Auto-generated catch block
      e.printStackTrace();
    } // fim catch
  }// fim metodo run
} // fim class Pai

// FILHO 1
class Filho1 extends Thread {
  private long delay;
  private String string;

  public Filho1(String string, long delay) {
    this.delay = delay;
    this.string = string;
  } // fim construtor Filho1

  public void run() {
    System.out.println(string);
    try {
      sleep(delay);
      new Neto1("O neto 1 Nasceu!", 30000).start(); // tempo que o bisneto 1 nasce
      sleep(45000);
      System.out.println("O Filho 1 Morreu!");
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch
  }// fim do metodo run
}// fim da classe ProcessoA

// FILHO 2
class Filho2 extends Thread {
  private long delay;
  private String string;

  public Filho2(String string, long delay) {
    this.delay = delay;
    this.string = string;
  } // fim construtor Filho1

  public void run() {
    System.out.println(string);
    try {
      sleep(delay);
      new Neto2("O neto 2 nasceu!", 0).start(); // tempo que o bisneto 2 nasce
      sleep(35000);
      System.out.println("O filho 2 morreu!");
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch
  }// fim do metodo run
}// fim da classe Processo1

// Filho3
class Filho3 extends Thread {
  // private long delay;
  private String string;
  private long delay;

  public Filho3(String string, long delay) {
    this.delay = delay;
    this.string = string;
  } // fim construtor Filho1

  public void run() {
    System.out.println(string);
    try {
      sleep(55000);
      System.out.println("O Filho 3 morreu!"); // neto 3 n nasceu
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch
  }// fim do metodo run
}// fim da classe Processo1

// NETO1
class Neto1 extends Thread {
  private long delay;
  private String string;

  public Neto1(String string, long delay) {
    this.delay = delay;
    this.string = string;
  } // fim construtor Filho1

  public void run() {
    System.out.println(string);
    try {
      sleep(delay);
      new Bisneto1("O Bisneto 1 nasceu!", 0).start();
      sleep(5000);
      System.out.println("O Neto 1 morreu!");
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch
  }// fim do metodo run
} // fim da class Neto1

// NETO2
class Neto2 extends Thread {
  private String string;
  private long delay;

  public Neto2(String string, long delay) {
    this.string = string;
    this.delay = delay;
  } // fim construtor Neto2

  public void run() {
    System.out.println(string);
    try {
      sleep(33000); // tempo morte neto2
      System.out.println("O neto 2 morreu!");

    } catch (InterruptedException e) { // fim try
      e.printStackTrace();
    } // fim catch
  } // fim metodo run
} // fim class Neto2

// BISNETO1
class Bisneto1 extends Thread {
  private String string;
  private long delay;

  public Bisneto1(String string, long delay) {
    this.string = string;
    this.delay = delay;
  } // fim do construtor Bisneto1

  public void run() {
    System.out.println(string);
    try {
      sleep(12000);
      System.out.println("O Binesto 1 morre!");
    } catch (InterruptedException e) { // fim do try
      e.printStackTrace();
    } // fim do catch
  } // fim metodo run
} // fim da class Bisneto1

public class Principal {
  static public void main(String s[]) {
    Pai pai = new Pai();
    pai.start();
  }// fim do metodo main
}// fim da classe principal