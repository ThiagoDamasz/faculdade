#include <iostream>
#include <string>
using namespace std;

struct produto
{
	string nome;
	int codigo;
	int quantidade;
};

int buscaBinaria(produto array[], int busca, int tamanho)
{
	int inicio = 0;
	int fim = tamanho - 1;


	while (inicio <= fim)
	{
		int meio = inicio + (fim - inicio) / 2;


		if (array[meio].codigo == busca)
		{
			return meio;
		}
		
		else if (array[meio].codigo < busca)
		{
			inicio = meio + 1;
		}
	
		else
		{
			fim = meio - 1;
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
		cin >> array[i].codigo;
		cin.ignore();
		cin >> array[i].nome;
		cin >> array[i].quantidade;
		cin.ignore();
	}

	int busca;
	cin >> busca;
	
	int resultado = buscaBinaria(array,busca,tamanho);
	
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
