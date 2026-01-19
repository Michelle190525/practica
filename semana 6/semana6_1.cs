using System;
using System.Collections.Generic;

class Ejercicio9
{
    static void Main()
    {
        LinkedList<int> lista1 = new LinkedList<int>();
        LinkedList<int> lista2 = new LinkedList<int>();

        Console.Write("Ingrese cantidad de datos para la primera lista: ");
        int n1 = int.Parse(Console.ReadLine());

        for (int i = 0; i < n1; i++)
        {
            Console.Write($"Lista 1 - Dato {i + 1}: ");
            lista1.AddLast(int.Parse(Console.ReadLine()));
        }

        Console.Write("Ingrese cantidad de datos para la segunda lista: ");
        int n2 = int.Parse(Console.ReadLine());

        for (int i = 0; i < n2; i++)
        {
            Console.Write($"Lista 2 - Dato {i + 1}: ");
            lista2.AddLast(int.Parse(Console.ReadLine()));
        }

        bool mismoTamano = lista1.Count == lista2.Count;
        bool mismoContenido = true;

        if (mismoTamano)
        {
            LinkedListNode<int> nodo1 = lista1.First;
            LinkedListNode<int> nodo2 = lista2.First;

            while (nodo1 != null)
            {
                if (nodo1.Value != nodo2.Value)
                {
                    mismoContenido = false;
                    break;
                }
                nodo1 = nodo1.Next;
                nodo2 = nodo2.Next;
            }
        }
        else
        {
            mismoContenido = false;
        }

        Console.WriteLine("\n--- RESULTADO ---");

        if (mismoTamano && mismoContenido)
        {
            Console.WriteLine("Las listas son iguales en tamaño y contenido.");
        }
        else if (mismoTamano && !mismoContenido)
        {
            Console.WriteLine("Las listas son iguales en tamaño pero no en contenido.");
        }
        else
        {
            Console.WriteLine("Las listas no tienen el mismo tamaño ni contenido.");
        }
    }
}
