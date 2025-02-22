#include<iostream>
#include<string>
using namespace std;

struct Pedras{
    string nome;
    double volume;
    int peso;
    int preco;
};



int main (){

    Pedras pedras[5];


    for(int i = 0; i < 5; i++)
    {
        getline(cin, pedras[i].nome);
        cin >> pedras[i].volume;
        cin >> pedras[i].peso;
        cin >> pedras[i].preco;
        cin.ignore();
    }


    return 0;
}