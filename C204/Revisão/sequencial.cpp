#include <iostream>
#include <string>
using namespace std;

struct produto
{
	string nome;
	int quantidade;
};

int buscaSequencial(produto array[], string busca, int tamanho)
{
    for (int i = 0; i < tamanho; ++i)
    {
        if (array[i].nome == busca)
        {
            return i;
        }
    }
    return -1;
}



int main()
{
	int tamanho;
	cin >> tamanho;
	cin.ignore();
	produto *array = new produto[tamanho];

	for(int i = 0; i < tamanho; i++)
	{
		getline(cin, array[i].nome);
		cin >> array[i].quantidade;
		cin.ignore();
	}

	string busca;
	cin >> busca;
	
	int resultado = buscaSequencial(array,busca,tamanho);
	
	if(resultado != -1)
	{
		cout << array[resultado].nome << " esta em estoque" << endl;
	}
	
	else
	{
		cout << "Nao existem produtos com esse codigo em estoque!" << endl;
	}
	
	delete[] array;
	
	return 0;
}
