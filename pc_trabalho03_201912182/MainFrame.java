/* ***************************************************************
* Autor: VITOR ROSENBERGRE DOS SANTOS CARMO
* Matricula: 201912182
* Inicio: 27/03/2021
* Ultima 29/03/2021
* Nome: Arvore Genealogica com Threads. 
* Classe: MainFrame.
* Funcao: Classe do frame eh responsavel por criar e administrar os labels.
*************************************************************** */

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  
  //Labels que representam a imagem de cada familiar.
  private JLabel labelPai, labelFilho1, labelFilho2, labelFilho3, labelNeto1, labelNeto2, labelBisneto1;

  //Labels que representam o tempo de cada familiar.
  private JLabel TempoPai, TempoFilho1, TempoFilho2, TempoFilho3, TempoNeto1, TempoNeto2, TempoBisneto1;

  //Imagens que sao usadas para representar os familiares. 
  private ImageIcon iconePai, iconeFilho1, iconeFilho2, iconeFilho3, iconeNeto1, iconeNeto2, iconeBisneto1;

  public MainFrame() {

    //----------------------------------FRAME------------------------------

    this.setTitle("Arvore Genealogica");
    this.setVisible(true);
    this.setResizable(false);
    this.setSize(650, 650);
    this.setLayout(null);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(Color.WHITE);

    //---------------------------------LABELSFAMILIAR----------------------

    // ----------------------------------LabelPai--------------------------

    iconePai = new ImageIcon("PaiRedimensionado.png"); // instancia o icone do pai
    labelPai = new JLabel();
    labelPai.setIcon(iconePai);
    labelPai.setForeground(Color.BLACK);
    labelPai.setBounds(265, 20, 100, 100);
    labelPai.setVisible(false);
    this.add(labelPai);

    // --------------------------------LabelFilho1---------------------------

    iconeFilho1 = new ImageIcon("Filho1Redimensionado.png"); // instancia o icone do filho1
    labelFilho1 = new JLabel();
    labelFilho1.setIcon(iconeFilho1);
    labelFilho1.setForeground(Color.BLACK);
    labelFilho1.setBounds(110, 160, 100, 100);
    labelFilho1.setVisible(false);
    this.add(labelFilho1);

    // --------------------------------LabelFilho2----------------------------

    iconeFilho2 = new ImageIcon("Filho2Redimensionado.png"); // instancia o icone do filho2
    labelFilho2 = new JLabel();
    labelFilho2.setIcon(iconeFilho2);
    labelFilho2.setForeground(Color.BLACK);
    labelFilho2.setBounds(270, 160, 100, 100);
    labelFilho2.setVisible(false);
    this.add(labelFilho2);

    // --------------------------------LabelFilho3------------------------------

    iconeFilho3 = new ImageIcon("Filho3Redimensionado.png"); // instancia o icone do filho3
    labelFilho3 = new JLabel();
    labelFilho3.setIcon(iconeFilho3);
    labelFilho3.setForeground(Color.BLACK);
    labelFilho3.setBounds(430, 160, 100, 100);
    labelFilho3.setVisible(false);
    this.add(labelFilho3);

    // --------------------------------LabelNeto1-------------------------------

    iconeNeto1 = new ImageIcon("Neto1Redimensionado.png"); // instancia o icone do Neto1
    labelNeto1 = new JLabel();
    labelNeto1.setIcon(iconeNeto1);
    labelNeto1.setForeground(Color.BLACK);
    labelNeto1.setBounds(110, 300, 100, 100);
    labelNeto1.setVisible(false);
    this.add(labelNeto1);

    // --------------------------------LabelNeto2--------------------------------

    iconeNeto2 = new ImageIcon("Neto2Redimensionado.png"); // instancia o icone do Neto2
    labelNeto2 = new JLabel();
    labelNeto2.setIcon(iconeNeto2);
    labelNeto2.setForeground(Color.BLACK);
    labelNeto2.setBounds(270, 300, 100, 100);
    labelNeto2.setVisible(false);
    this.add(labelNeto2);

    // ------------------------------LabelBisneto1---------------------------------

    iconeBisneto1 = new ImageIcon("BisnetoRedimensionado2.png"); // instancia o icone do Bisneto1
    labelBisneto1 = new JLabel();
    labelBisneto1.setIcon(iconeBisneto1);
    labelBisneto1.setForeground(Color.BLACK);
    labelBisneto1.setBounds(110, 440, 100, 100);
    labelBisneto1.setVisible(false);
    this.add(labelBisneto1);

    // --------------------------------CRONOMETROS-------------------------------

    // -------------------------------CronometroPai------------------------------
    
    TempoPai = new JLabel(); // instancia o Label do Cronometro do Pai
    TempoPai.setForeground(Color.BLACK);
    TempoPai.setBounds(500, 300, 100, 100);
    this.add(TempoPai);

    // -----------------------------CronometroFilho1-----------------------------

    TempoFilho1 = new JLabel(); // instancia o Label do Cronometor do Filho1
    TempoFilho1.setForeground(Color.BLACK);
    TempoFilho1.setBounds(500, 330, 100, 100);
    this.add(TempoFilho1);

    // -----------------------------CronometroFilho2-----------------------------

    TempoFilho2 = new JLabel(); // instancia o label do Cronometro do Filho2
    TempoFilho2.setForeground(Color.BLACK);
    TempoFilho2.setBounds(500, 360, 100, 100);
    this.add(TempoFilho2);

    // -----------------------------CronometroFilho3------------------------------

    TempoFilho3 = new JLabel(); // instancia o label do Cronometro do Filho3
    TempoFilho3.setForeground(Color.BLACK);
    TempoFilho3.setBounds(500, 390, 100, 100);
    this.add(TempoFilho3);

    // ------------------------------CronometroNeto1------------------------------

    TempoNeto1 = new JLabel(); // instancia o label do Cronometro do Neto1
    TempoNeto1.setForeground(Color.BLACK);
    TempoNeto1.setBounds(500, 420, 100, 100);
    this.add(TempoNeto1);

    // ------------------------------CronometroNeto2-----------------------------

    TempoNeto2 = new JLabel(); // instancia o label do Cronometro do Neto2
    TempoNeto2.setForeground(Color.BLACK);
    TempoNeto2.setBounds(500, 450, 100, 100);
    this.add(TempoNeto2);
    // ----------------------------CronometroBisneto1----------------------------

    TempoBisneto1 = new JLabel(); // instancia o label do Cronometro do Bisneto1
    TempoBisneto1.setForeground(Color.BLACK);
    TempoBisneto1.setBounds(500, 480, 100, 100);
    this.add(TempoBisneto1);

  } // fim MainFrame construtor
  
  /* ***************************************************************
  * Metodo: setTime.
  * Funcao: Alterar o label responsavel por mostrar o tempo, 
  * alterando para cada familiar.
  * Parametros: String familiar, int time.
  * Retorno: Eh um void, nao vai retornar nada.
  *************************************************************** */
  public void setTime(String familiar, int time) {
    switch (familiar) { // vai pegar o familiar e entrar no case escolhido
    case "pai":
      TempoPai.setText("Pai: " + Integer.toString(time));
      break;
    case "filho1":
      TempoFilho1.setText("Filho1: " + Integer.toString(time));
      break;
    case "filho2":
      TempoFilho2.setText("Filho2: " + Integer.toString(time));
      break;
    case "filho3":
      TempoFilho3.setText("Filho3: " + Integer.toString(time));
      break;
    case "neto1":
      TempoNeto1.setText("Neto1: " + Integer.toString(time));
      break;
    case "neto2":
      TempoNeto2.setText("Neto2: " + Integer.toString(time));
      break;
    case "bisneto1":
      TempoBisneto1.setText("Bisneto1: " + Integer.toString(time));
      break;
    } // fim do switch
  } // fim do metodo setTime

  /* ***************************************************************
  * Metodo: labelsetVisible.
  * Funcao: Alterar a visibilidade dos labels, deixando eles visiveis,
  * alterando para cada familiar.
  * Parametros: String familiar.
  * Retorno: Eh um void, nao vai retornar nada.
  *************************************************************** */
  public void labelsetVisible(String familiar) {
    switch (familiar) {
    case "pai":
      labelPai.setVisible(true);
      break;
    case "filho1":
      labelFilho1.setVisible(true);
      break;
    case "filho2":
      labelFilho2.setVisible(true);
      break;
    case "filho3":
      labelFilho3.setVisible(true);
      break;
    case "neto1":
      labelNeto1.setVisible(true);
      break;
    case "neto2":
      labelNeto2.setVisible(true);
      break;
    case "bisneto1":
      labelBisneto1.setVisible(true);
      break;
    } // fim do switch
  } // fim do metodo labelsetVisible

  /* ***************************************************************
  * Metodo: setMorte.
  * Funcao: Alterar os icones de cada labels familiar, junto com a cor do label 
  * responsavel pelo cronometro do familiar correspondente. Inicializa os icones nos 
  * proprios cases.
  * Parametros: String familiar.
  * Retorno: Eh um void, nao vai retornar nada.
  *************************************************************** */
  public void setMorte(String familiar) {
    switch (familiar) {
    case "pai":
      ImageIcon labelpaiMorte = new ImageIcon("PaiRedimensionadoMorte.png");
      labelPai.setIcon(labelpaiMorte);
      TempoPai.setForeground(Color.RED);
      break;
    case "filho1":
      ImageIcon labelFilho1Morte = new ImageIcon("Filho1RedimensionadoMorte.png");
      labelFilho1.setIcon(labelFilho1Morte);
      TempoFilho1.setForeground(Color.RED);
      break;
    case "filho2":
      ImageIcon labelFilho2Morte = new ImageIcon("Filho2RedimensionadoMorte.png");
      labelFilho2.setIcon(labelFilho2Morte);
      TempoFilho2.setForeground(Color.RED);
      break;
    case "filho3":
      ImageIcon labelFilho3Morte = new ImageIcon("Filho3RedimensionadoMorte.png");
      labelFilho3.setIcon(labelFilho3Morte);
      TempoFilho3.setForeground(Color.RED);
      break;
    case "neto1":
      ImageIcon labelNeto1Morte = new ImageIcon("Neto1RedimensionadoMorte.png");
      labelNeto1.setIcon(labelNeto1Morte);
      TempoNeto1.setForeground(Color.RED);
      break;
    case "neto2":
      ImageIcon labelNeto2Morte = new ImageIcon("Neto2RedimensionadoMorte.png");
      labelNeto2.setIcon(labelNeto2Morte);
      TempoNeto2.setForeground(Color.RED);
      break;
    case "bisneto1":
      ImageIcon labelBisneto1Morte = new ImageIcon("BisnetoRedimensionado2Morte.png");
      labelBisneto1.setIcon(labelBisneto1Morte);
      TempoBisneto1.setForeground(Color.RED);
      break;
    }// fim do switch
  } // fim do metodo setMorte

} // fim Jframe
