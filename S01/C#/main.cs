using System;

class Cachorro
{
    public string Nome;
    public int Idade;

    public void MostrarNome()
    {
        Console.WriteLine("O nome do cachorro é: " + Nome);
    }

    public virtual void ShowIdade()
    {
        Console.WriteLine("A idade do cachorro é: " + Idade);
    }
}

class CachorroGrande : Cachorro
{
    private string tamanho = "Grande";

    public override void ShowIdade()
    {
        Console.WriteLine("Idade do cachorro grande: " + Idade);
    }

    public void MostrarTamanho()
    {
        Console.WriteLine("O tamanho do cachorro é: " + tamanho);
    }
}

class CachorroPequeno : Cachorro
{
    public override void ShowIdade()
    {
        Console.WriteLine("Idade do cachorro pequeno: " + Idade);
    }
}

class Program
{
    static void Main(string[] args)
    {
        Cachorro cachorro = new Cachorro();
        cachorro.Nome = "Billy";
        cachorro.Idade = 5;

        CachorroPequeno cachorroPequeno = new CachorroPequeno();
        cachorroPequeno.Nome = "Tampico";
        cachorroPequeno.Idade = 2;

        CachorroGrande cachorroGrande = new CachorroGrande();
        cachorroGrande.Nome = "Trem bala";
        cachorroGrande.Idade = 7;

        Console.WriteLine("----- Cachorro -----");
        cachorro.MostrarNome();
        cachorro.ShowIdade();

        Console.WriteLine("\n----- Cachorro Pequeno -----");
        cachorroPequeno.MostrarNome();
        cachorroPequeno.ShowIdade();

        Console.WriteLine("\n----- Cachorro Grande -----");
        cachorroGrande.MostrarNome();
        cachorroGrande.ShowIdade();
        cachorroGrande.MostrarTamanho();
    }
}