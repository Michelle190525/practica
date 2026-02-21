using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
        // 1. Conjunto universo: 500 ciudadanos
        HashSet<string> ciudadanos = new HashSet<string>();
        for (int i = 1; i <= 500; i++)
        {
            ciudadanos.Add($"Ciudadano {i}");
        }

        // 2. Conjunto Pfizer (75 ciudadanos)
        HashSet<string> pfizer = new HashSet<string>();
        for (int i = 1; i <= 75; i++)
        {
            pfizer.Add($"Ciudadano {i}");
        }

        // 3. Conjunto AstraZeneca (75 ciudadanos)
        HashSet<string> astrazeneca = new HashSet<string>();
        for (int i = 50; i < 125; i++)
        {
            astrazeneca.Add($"Ciudadano {i}");
        }

        // 4. Operaciones de teoría de conjuntos

        // Unión Pfizer y AstraZeneca
        HashSet<string> vacunados = new HashSet<string>(pfizer);
        vacunados.UnionWith(astrazeneca);

        // Ciudadanos no vacunados: U - (P ∪ A)
        HashSet<string> noVacunados = new HashSet<string>(ciudadanos);
        noVacunados.ExceptWith(vacunados);

        // Ciudadanos con ambas dosis: P ∩ A
        HashSet<string> ambasDosis = new HashSet<string>(pfizer);
        ambasDosis.IntersectWith(astrazeneca);

        // Solo Pfizer: P - A
        HashSet<string> soloPfizer = new HashSet<string>(pfizer);
        soloPfizer.ExceptWith(astrazeneca);

        // Solo AstraZeneca: A - P
        HashSet<string> soloAstra = new HashSet<string>(astrazeneca);
        soloAstra.ExceptWith(pfizer);

        // 5. Mostrar resultados
        Console.WriteLine("=== Ciudadanos no vacunados ===");
        MostrarLista(noVacunados);

        Console.WriteLine("\n=== Ciudadanos con ambas dosis ===");
        MostrarLista(ambasDosis);

        Console.WriteLine("\n=== Ciudadanos solo con Pfizer ===");
        MostrarLista(soloPfizer);

        Console.WriteLine("\n=== Ciudadanos solo con AstraZeneca ===");
        MostrarLista(soloAstra);
    }

    static void MostrarLista(HashSet<string> lista)
    {
        foreach (var ciudadano in lista)
        {
            Console.WriteLine(ciudadano);
        }
        Console.WriteLine($"Total: {lista.Count}\n");
    }
}