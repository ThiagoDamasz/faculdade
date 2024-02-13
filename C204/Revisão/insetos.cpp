#include <iostream>
#include <string>

using namespace std;

struct Inseto {
    string nome;
    double tamanho;
};

int main() {
    int N;
    cin >> N;
    cin.ignore();

    Inseto *array = new Inseto[N];

    for (int i = 0; i < N; i++) {
        getline(cin, array[i].nome);
        cin >> array[i].tamanho;
        cin.ignore();
    }

    for (int i = 0; i < N - 1; i++) {
        for (int j = 0; j < N - i - 1; j++) {
            if (array[j].tamanho > array[j + 1].tamanho) {
                Inseto temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        cout << array[i].nome << endl;
    }

    delete[] array; 

    return 0;
}