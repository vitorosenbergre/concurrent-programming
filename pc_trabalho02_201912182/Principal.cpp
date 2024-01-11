/* **************************************************************** 
Autor: VITOR ROSENBERGRE DOS SANTOS CARMO 
Matricula: 201912182 
Inicio: 19/03/2021 
Ultima alteracao: 20/03/2021
Nome: Arvore genealogica utilizando o comando fork(). 
Funcao: Demonstrar uma arvore genealogica por meio de processos, com seus nascimentos e mortes. Cada segundo na execucao representa 1 ano.
****************************************************************/

#include <sys/types.h>
#include <iostream>
#include <unistd.h>

using namespace std;

int main(){
  cout << "Nasce o pai, CPF:"<< getpid() << endl;
  sleep(22); //processo principal "dorme" por 22 segundos
  
  switch(fork()){ // Nasce o processo filho 1
    case -1: //se o retorno do fork() for negativo, significa que ouve erro.
      exit(1); // exit(), encera o processo.
    case 0: //se o retorno for igual a 0,esta tratando com o subprocesso.
      cout << "O pai tem o primeiro filho aos 22 anos, CPF:"<< getpid() << endl;
      sleep(16); 
      switch(fork()){ // nasce o processo neto 1 
        case -1:
          exit(1);
        case 0: // retorna para o processo neto 1 atuar
          cout<< "O pai eh avo (primeiro filho) aos 38 anos, CPF:"<< getpid() <<endl;
          sleep(30);
          switch(fork()){ // nasce o processo bisneto 1
            case -1:
              exit(1);
            case 0: // retorna para o processo do bisneto 1
              cout << "O pai eh bisavo (primeiro filho) aos 68 anos, CPF:"<< getpid() << endl;
              sleep(12);
              cout << "O Bisneto morre aos 12 anos, CPF:"<< getpid()<< endl;
              break; // break do caso 0 do atual processo (bisneto 1)
            default: // retorna para o processo do neto 1
              sleep(5);
              cout << "O neto um morre aos 35 anos, CPF:"<< getpid()<< endl;
              break; // break no default do bisneto, retorna o pai (Neto 1)
          } // fim do switch/case
          break; // break do case 0 do neto 1, processo atual = case 0
        default: // se o processo for maior que 0, esta tratando do pai.
           sleep(45);
           cout << "O primeiro filho morre aos 61 anos, CPF:"<< getpid()<<endl;
          break; // break do switch do neto 1 (default), retorna o (filho 1)
      } // fim do switch/case
      break; // break do caso 0 do switch do filho 1, processo atual
    default: // retorna para o processo principal (pai), fork()>0.
      sleep(3);
      switch(fork()){ // o processo filho 2 nasceu
        case -1:
          exit(1);
        case 0: // retorna para o processo do filho 2, fork()==0.
          cout << "O pai tem o segundo filho aos 25 anos, CPF:"<< getpid() << endl;
          sleep(20);
          switch(fork()){ // o processo neto 2 nasceu
            case -1:
              exit(1);
            case 0: // retorna para o processo neto 2, fork()==0.
              cout << "O pai eh avo (segundo filho) aos 45 anos, CPF:" << getpid() << endl;
              sleep(33);
              cout << "O neto dois morre aos 33, CPF:"<< getpid()<<endl;
              break; // break do case 0 do neto 2, processo atual = case 0
            default: // retorna para o processo do filho 2, fork()>0;
              sleep(35);
              cout << "O segundo filho morre aos 55 anos, CPF:"<< getpid()<< endl;
              break; // break do default do neto 2.
          } // fim do switch/case
          break; // break do case 0 do filho 2.
        default: // retorna para o processo principal (pai), fork()>0.
          sleep(7);
          switch(fork()){	// o processo filho 3 nasceu
            case -1:
              exit(1);
            case 0: // retorna para o processo filho 3, fork()==0.
              cout << "O pai tem o terceiro filho aos 32 anos, CPF:"<< getpid() << endl;
              sleep(55);
              cout << "O terceiro filho morre aos 55 anos, CPF:"<< getpid()<<endl;
              break; // break do case 0 do filho 3.
            default: //retorna para o processo principal (pai).
              sleep(58);
              cout << "O pai morre aos 90 anos, CPF:"<< getpid()<<endl;
              break; // break do default do filho 3. *****
          } // fim do switch/case
          break; // break do default do filho 2. *****
      } // fim do switch/case
      break; // break do default do filho 1. *****
  } // fim do switch/case
} // fim do metodo main
