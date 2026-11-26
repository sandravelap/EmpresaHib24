package menus;

import libs.Leer;
import libs.UserData;
import repositories.EmpleadosRepository;
import services.EmpleadosServices;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {
    private boolean salir = false;
    private Scanner sc = new Scanner(System.in);
    private EmpleadosServices empleadosServices = new EmpleadosServices();

    public void muestraMenu() {
        String opcion;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Listar empleados.");
            System.out.println("2. Modificar sueldo de ARROYO.");
            System.out.println("3. Insertar nuevo empleado.");
            System.out.println("3. Borrar empleado.");
            System.out.println("0. Salir");
            opcion = this.pideOpcion();
            this.procesaOpcion(opcion);
        } while (!salir);
    }

    private String pideOpcion() {
        return this.sc.nextLine();
    }

    private void procesaOpcion(String opcion) {

        switch (opcion) {
            case "0" -> salir = true;
            case "1" -> {
                libs.Leer.mostrarEnPantalla(empleadosServices.listarEmpleados());
            }
            case "2" -> {
                empleadosServices.modificarSueldoArroyo(libs.Leer.pedirFloat("Introduce el nuevo sueldo de Arroyo: "));
            }
            case "3" ->{
            }
            default -> System.out.println("Opción incorrecta");
        }
    }
}
