using System;
using System.Collections.Generic;

class Ejercicio8
{
    static void Main()
    {
        LinkedList<double> listaPrincipal = new LinkedList<double>();
        LinkedList<double> listaMenoresIguales = new LinkedList<double>();
        LinkedList<double> listaMayores = new LinkedList<double>();

        Console.Write("Ingrese la cantidad de datos: ");
        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            Console.Write($"Ingrese el dato {i + 1}: ");
            double valor = double.Parse(Console.ReadLine());
            listaPrincipal.AddLast(valor);
        }

        double suma = 0;
        foreach (double valor in listaPrincipal)
        {
            suma += valor;
        }

        double promedio = suma / listaPrincipal.Count;

        foreach (double valor in listaPrincipal)
        {
            if (valor <= promedio)
                listaMenoresIguales.AddLast(valor);
            else
                listaMayores.AddLast(valor);
        }

        Console.WriteLine("\n--- RESULTADOS ---");

        Console.WriteLine("Lista principal:");
        MostrarLista(listaPrincipal);

        Console.WriteLine($"Promedio: {promedio}");

        Console.WriteLine("Valores menores o iguales al promedio:");
        MostrarLista(listaMenoresIguales);

        Console.WriteLine("Valores mayores al promedio:");
        MostrarLista(listaMayores);
    }

    static void MostrarLista(LinkedList<double> lista)
    {
        foreach (double valor in lista)
        {
            Console.Write(valor + " ");
        }
        Console.WriteLine();
    }
}
