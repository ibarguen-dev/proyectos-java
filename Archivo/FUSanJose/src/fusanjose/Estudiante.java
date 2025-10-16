
package fusanjose;
import static fusanjose.Validacion.*;

import java.util.Scanner;


public class Estudiante extends Persona 
{
  private String carneEstudiante;
  
   public Estudiante()
   {
      
   }

   public Estudiante ingresarDatos(String carneEstudiante)
  {
   Scanner sc = new Scanner(System.in);
   nombre = leerCadena("Ingresar nombre del Estudiante: ");
   apellido = leerCadena("Ingresar apellido del Estudiante: ");
   tel = leerCadena("Ingresar telefono del Estudiante");
   correo = leerCadena("Ingresar Correo del Estudiante");
   edad = leerEdadEstudiante("Ingresar edad del Estudiante");
   return new Estudiante(carneEstudiante,nombre,apellido, tel,correo,edad);
  }      

   public Estudiante(String carneEstudiante, String nombre, String apellido, String tel, String correo, int edad) 
   {
    super(nombre, apellido, tel, correo, edad);
    this.carneEstudiante = carneEstudiante;
   }

    public String getCarneEstudiante() {
        return carneEstudiante;
    }

    public void setCarneEstudiante(String carneEstudiante) {
        this.carneEstudiante = carneEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
  
   
   
    
}
