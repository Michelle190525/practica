package com.casquete.proyecto.vista;

import com.casquete.proyecto.modelo.Tarea;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuYObtenerOpcion() {
        System.out.println("\n--- MENÚ DASHBOARD ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String leerDescripcion() {
        System.out.print("Ingrese la descripción de la tarea: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int leerIdTarea() {
        System.out.print("Ingrese el ID de la tarea a completar: ");
        return scanner.nextInt();
    }

    public void mostrarTareas(List<Tarea> tareas) {
        System.out.println("\nLista de tareas:");
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
