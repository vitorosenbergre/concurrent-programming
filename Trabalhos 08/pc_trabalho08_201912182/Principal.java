/* ***************************************************************
* Autor: Vitor Rosenbergre dos Santos Carmo.
* Matricula: 201912182.
* Inicio: 10/06/2021.
* Ultima alteracao: 17/06/2021.
* Nome do Programa: Circuito Automato.
* Classe: Principal.
* Funcao: Simular 8 carros que percorrem circuitos diferentes e com diferentes sentidos.
* As ruas sao de mao unica.
* Os carros nao podem se bater ou atrasar muito para exercer uma acao. 
* Alguns percursos podem demorar um pouco mais ja que os sentidos acabams e chocando, e se n houver uma espera,
* existe uma grande chance de ocorrer um acidente. 
*************************************************************** */

import java.io.IOException;

public class Principal {
  public static void main(String[] args) throws IOException {
    new Mapa();
  } // fim da main
} // fim da class Principal