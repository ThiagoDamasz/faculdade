#include <iostream>
using namespace std;

void dfs(int adj[][], bool visited[], int vertices, int curr)
{
	visited[curr] = true;
	cout << curr << endl;
	for(int i = 0; i < vertices, i++)
	{
		if(adj[curr][i] != -1 && visited[i] == false)
		{
			dfs (adj, visited, vertices, i);
		}
	}
}

int main()
{

	int vertices, directed, o, d, p;
	
	cin >> vertices >> directed;
	
	in
	
	return 0;
}
