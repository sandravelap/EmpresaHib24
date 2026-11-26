package services;

import entities.EmpleadosEntity;
import repositories.EmpleadosRepository;

import java.util.ArrayList;

public class EmpleadosServices {
    EmpleadosRepository empleadosRepository = new EmpleadosRepository();
    public String listarEmpleados(){
        String mensaje = "";
        ArrayList<EmpleadosEntity> listaEmpleadosEntity = empleadosRepository.leerEmpleados();
        return  mensaje;
    }
    public String modificarSueldoArroyo(float nuevoSueldo){
        String mensaje = "";
        try {
            empleadosRepository.modificarSueldoEmpleado(nuevoSueldo);
        } catch (Exception e) {
            mensaje = e.toString();
        }
        return  mensaje;
    }
}
