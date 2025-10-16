
package fusanjose;

import static fusanjose.Validacion.*;


import java.util.Scanner;

public class Docente extends Persona
{
  private String carneDocente, titulo;
  private double salario;
  public Docente()
  {
      
  }   

  public Docente(String carneDocente, String nombre, String apellido, String tel, String correo, int edad, String titulo, double salario) 
  {
        super(nombre, apellido, tel, correo, edad);
        this.carneDocente = carneDocente;
        this.titulo = titulo;
        this.salario = salario;
  }
  
  public Docente ingresarDatos(String carneDocente)
  {
   Scanner sc = new Scanner(System.in);
   nombre = leerCadena("Ingresar nombre del docente: ");
   apellido = leerCadena("Ingresar apellido del docente: ");
   tel = leerCadena("Ingresar telefono del docente");
   correo = leerCadena("Ingresar Correo del docente");
   edad = leerEdadDocente("Ingresar edad del docente");
   titulo = leerTitulo("Ingrese el título del docente: ");
   salario = asignacionSalario(titulo);
   return new Docente(carneDocente,nombre,apellido, tel,correo,edad,titulo, salario);
  }      
    public double asignacionSalario(String t)
    {
     if(t.equals("especialista"))
     {   
        return 200;
     } 
      else if (t.equals("master"))
       {   
          return 350;
       }    
      else if(t.equals("doctor"))
       { 
         return 500;
       }
      else 
         return 0;
    }
    public String getCarneDocente() 
    {
        return carneDocente;
    }

    public void setCarneDocente(String carneDocente) 
    {
        this.carneDocente = carneDocente;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public double getSalario() 
    {
        return salario;
    }

    public void setSalario(double salario) 
    {
        this.salario = salario;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    public String getTel() 
    {
        return tel;
    }

    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getCorreo() 
    {
        return correo;
    }

    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }

    public int getEdad() 
    {
        return edad;
    }

    public void setEdad(int edad) 
    {
        this.edad = edad;
    }

    @Override
    public String toString() 
    {
     return carneDocente+"|"+nombre+"|"+apellido+"|"+tel+"|"+correo+"|"+edad+"|"+titulo+"|"+salario;
    }
    
  
  
  
  
}
