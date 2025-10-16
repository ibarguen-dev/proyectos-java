
package fusanjose;

import java.util.Scanner;
import static fusanjose.Validacion.*;

public class Curso 
{
  private String codCurso, nombre ;
  private int creditos;
  public Curso()
  {
      
  }

  public Curso(String codCurso, String nombre, int creditos) 
  {
    this.codCurso = codCurso;
    this.nombre = nombre;
    this.creditos = creditos;
  }
  
  public Curso ingresarDatos(String codCurso)
  {
    Scanner sc = new Scanner(System.in); 
    nombre = leerCadena("Ingrese el nombre del curso: ");
    creditos = leerCreditos("Ingrese el numero de créditos: ");
    return new Curso(codCurso, nombre, creditos);
  }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
  
  
   @Override
    public String toString() 
    {
     return codCurso+"|"+nombre+"|"+creditos;
    }
    
  
}
