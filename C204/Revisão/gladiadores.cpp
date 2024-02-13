#include <iostream>
#include <string>
#include <cmath>

using namespace std;

struct gladiadores
{
    string nome;
    int forca;
    int skill;
    int idade;
};

bool combate(array g1, array g2){
    

}



int main(){
    
    const int tamanho = 5;

    gladiadores* array = new gladiadores[tamanho];

    for (int i = 0; i < tamanho; i++)
    {
        cin >> array[i].nome;
        cin >> array[i].forca;
        cin >> array[i].skill;
        cin >> array[i].idade;
    }
    
    delete[] array;

    return 0;
}