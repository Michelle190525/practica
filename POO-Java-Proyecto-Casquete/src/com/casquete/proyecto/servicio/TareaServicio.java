package com.casquete.proyecto.servicio;

import com.casquete.proyecto.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

public class TareaServicio {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(String descripcion) {
        int id = tareas.size() + 1;
        tareas.add(new Tarea(id, descripcion));
    }

    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    public void completarTarea(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.completar();
            }
        }
    }
}
