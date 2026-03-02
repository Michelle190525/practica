using System;
using System.Collections.Generic;
using System.Linq;

namespace TraductorBasico
{
    class Program
    {
        // Diccionario global para almacenar las palabras (Inglés - Español)
        static Dictionary<string, string> diccionario = new Dictionary<string, string>(StringComparer.OrdinalIgnoreCase);

        static void Main(string[] args)
        {
            InicializarDiccionario();
            int opcion;

            do
            {
                Console.Clear();
                Console.WriteLine("==================== MENÚ ====================");
                Console.WriteLine("1. Traducir una frase (Inglés -> Español)");
                Console.WriteLine("2. Agregar palabras al diccionario");
                Console.WriteLine("0. Salir");
                Console.WriteLine("==============================================");
                Console.Write("Seleccione una opción: ");

                if (!int.TryParse(Console.ReadLine(), out opcion)) continue;

                switch (opcion)
                {
                    case 1:
                        TraducirFrase();
                        break;
                    case 2:
                        AgregarPalabra();
                        break;
                    case 0:
                        Console.WriteLine("Saliendo del programa...");
                        break;
                    default:
                        Console.WriteLine("Opción no válida. Presione cualquier tecla para intentar.");
                        Console.ReadKey();
                        break;
                }
            } while (opcion != 0);
        }

        static void InicializarDiccionario()
        {
            // Lista base de palabras sugeridas
            diccionario.Add("Time", "tiempo");
            diccionario.Add("Person", "persona");
            diccionario.Add("Year", "año");
            diccionario.Add("Way", "camino");
            diccionario.Add("Day", "día");
            diccionario.Add("Thing", "cosa");
            diccionario.Add("Man", "hombre");
            diccionario.Add("World", "mundo");
            diccionario.Add("Life", "vida");
            diccionario.Add("Hand", "mano");
            diccionario.Add("Eye", "ojo");
            diccionario.Add("Work", "trabajo");
        }

        static void TraducirFrase()
        {
            Console.WriteLine("\n--- TRADUCIR FRASE ---");
            Console.Write("Ingrese la frase: ");
            string fraseInput = Console.ReadLine();

            // Dividir la frase por espacios
            string[] palabras = fraseInput.Split(' ');
            List<string> fraseTraducida = new List<string>();

            foreach (string item in palabras)
            {
                // Limpiar puntuación para buscar la palabra pura
                string palabraLimpia = new string(item.Where(c => !char.IsPunctuation(c)).ToArray());
                string puntuacion = new string(item.Where(c => char.IsPunctuation(c)).ToArray());

                if (diccionario.ContainsKey(palabraLimpia))
                {
                    // Si existe, se traduce y se le devuelve su puntuación original
                    fraseTraducida.Add(diccionario[palabraLimpia] + puntuacion);
                }
                else
                {
                    // Si no existe, se mantiene la palabra original
                    fraseTraducida.Add(item);
                }
            }

            Console.WriteLine("\nResultado:");
            Console.WriteLine(string.Join(" ", fraseTraducida));
            Console.WriteLine("\nPresione cualquier tecla para volver al menú...");
            Console.ReadKey();
        }

        static void AgregarPalabra()
        {
            Console.WriteLine("\n--- AGREGAR PALABRA ---");
            Console.Write("Palabra en Inglés: ");
            string ingles = Console.ReadLine().Trim();
            
            Console.Write("Traducción al Español: ");
            string espanol = Console.ReadLine().Trim();

            if (!diccionario.ContainsKey(ingles))
            {
                diccionario.Add(ingles, espanol);
                Console.WriteLine("¡Palabra agregada con éxito!");
            }
            else
            {
                Console.WriteLine("La palabra ya existe en el diccionario.");
            }

            Console.WriteLine("Presione cualquier tecla para volver...");
            Console.ReadKey();
        }
    }
}
