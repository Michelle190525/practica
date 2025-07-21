package com.casquete.proyecto.dashboard;

import com.casquete.proyecto.servicio.TareaServicio;
import com.casquete.proyecto.vista.VistaConsola;
import java.util.List;

public class Dashboard {
    private TareaServicio tareaServicio = new TareaServicio();
    private VistaConsola vista = new VistaConsola();

    public void iniciar() {
        vista.mostrarMensaje("¡Bienvenido al Dashboard de gestión de tareas!");
        int opcion;
        do {
            opcion = vista.mostrarMenuYObtenerOpcion();
            switch (opcion) {
                case 1 -> {
                    String desc = vista.leerDescripcion();
                    tareaServicio.agregarTarea(desc);
                    vista.mostrarMensaje("Tarea agregada correctamente.");
                }
                case 2 -> {
                    List tareas = tareaServicio.obtenerTareas();
                    vista.mostrarTareas(tareas);
                }
                case 3 -> {
                    int id = vista.leerIdTarea();
                    tareaServicio.completarTarea(id);
                    vista.mostrarMensaje("Tarea completada si el ID existía.");
                }
                case 4 -> vista.mostrarMensaje("Saliendo del Dashboard. ¡Hasta luego!");
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        new Dashboard().iniciar();
    }
}
