package com.mycompany.universidad;
import static com.mycompany.universidad.Validacion.*;
import java.util.Scanner;



public class Estudiante extends Persona {
     private String carneEstudiante = "";
    private Scanner sc = new Scanner(System.in);
    
    Estudiante(){
        super();
    }
    
    Estudiante(String carneEstudiante,String nombre, String apellido,
            String telefono, String correo, int edad){
        super(nombre,apellido,telefono,correo,edad);
        this.carneEstudiante = carneEstudiante;
    }

    public String getCarneEstudiante() {
        return carneEstudiante;
    }

    public void setCarneEstudiante(String carneEstudiante) {
        this.carneEstudiante = carneEstudiante;
    }
    
    
    public Estudiante guardarEstudainte(Archivo arch,String codEs){
        Estudiante est;
        String nombre, apellido, telefono, correo,carneEstudiante;
        int edad;
        
        nombre = leerString("Ingrese el nombre del estudiante");
        apellido = leerString("Ingrese el apellido del estudiante");
        telefono = leerString("Ingrese el telefono del estudiante");
        correo = leerString("Ingrese el correo del estudiante");
        edad = leerEdad("Ingrese la edad del estudianete");
        System.out.print("carneEstudiante");

        carneEstudiante = codEs;
        System.out.print(carneEstudiante);
        System.out.print(telefono);
        est = new Estudiante(carneEstudiante,nombre, apellido, telefono,
                correo,edad);

        return est;
    }



  public String estructuraRegistro()
  {   
    return  getCarneEstudiante() +"| "+ super.getNombre() +"| "+ super.getApellido()
            +"| "+ super.getEdad() + "| "+ super.getTelefono()+"| " 
            +"| "+ super.getCorreo();
  }
}
