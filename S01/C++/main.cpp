#include <iostream>  
using namespace std; 

// Classe Pessoa
class Pessoa {
protected: 
    string nome;
    int idade;

public:
    // Construtor 
    Pessoa(string n, int i) {
        nome = n;
        idade = i;
    }

    void imprimirNome() {
        cout << "O nome é: " << nome << endl;
    }
};

// Classe Professor 
class Professor : public Pessoa {
public:
    // Construtor 
    Professor(string n, int i) : Pessoa(n, i) {}

    void idadeProfessor() {
        cout << "O professor tem " << idade << " anos." << endl;
    }
};

// Classe Aluno herda de Pessoa
class Aluno : public Pessoa {
private:
    string matricula;

public:
    // Construtor
    Aluno(string n, int i, string m) : Pessoa(n, i) {
        matricula = m;
    }

    void idadeAluno() {
        cout << "O aluno tem " << idade << " anos." << endl;
    }

    void imprimirMatricula() {
        cout << "A matrícula do aluno é: " << matricula << endl;
    }
};

int main() {
    // Criando objeto 
    Pessoa pessoa("Thiago", 23);

    Professor professor("Soned", 10000);

    Aluno aluno("Rodrigo", 23, "1");

    // imprimindo
    pessoa.imprimirNome(); 

    professor.imprimirNome();
    professor.idadeProfessor(); 

    aluno.imprimirNome(); 
    aluno.idadeAluno(); 
    aluno.imprimirMatricula(); 

    return 0;
}

