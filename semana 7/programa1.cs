using System;
using System.Collections.Generic;

class TorresDeHanoi
{
    /// <summary>
    /// Resuelve el problema de las Torres de Hanoi usando pilas
    /// </summary>
    static void Hanoi(int n, Stack<int> origen, Stack<int> auxiliar, Stack<int> destino,
                      string nombreOrigen, string nombreAuxiliar, string nombreDestino)
    {
        if (n == 1)
        {
            int disco = origen.Pop();
            destino.Push(disco);
            Console.WriteLine($"Mover disco {disco} de {nombreOrigen} a {nombreDestino}");
            return;
        }

        // Mover n-1 discos al auxiliar
        Hanoi(n - 1, origen, destino, auxiliar, nombreOrigen, nombreDestino, nombreAuxiliar);

        // Mover el disco mayor
        int discoMayor = origen.Pop();
        destino.Push(discoMayor);
        Console.WriteLine($"Mover disco {discoMayor} de {nombreOrigen} a {nombreDestino}");

        // Mover los n-1 discos al destino
        Hanoi(n - 1, auxiliar, origen, destino, nombreAuxiliar, nombreOrigen, nombreDestino);
    }

    static void Main()
    {
        int numDiscos = 3;

        Stack<int> torreA = new Stack<int>();
        Stack<int> torreB = new Stack<int>();
        Stack<int> torreC = new Stack<int>();

        // Inicializar torre A con discos
        for (int i = numDiscos; i >= 1; i--)
        {
            torreA.Push(i);
        }

        Console.WriteLine("Movimientos de las Torres de Hanoi:\n");
        Hanoi(numDiscos, torreA, torreB, torreC, "A", "B", "C");
    }
}