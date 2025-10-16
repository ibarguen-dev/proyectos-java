package fusanjose;
import java.util.Scanner;
import static fusanjose.Validacion.*;


public class NotaCurso 
{
  private String codCurso, carneEstudiante, carneDocente,estado;
  private double notaFinal; 

    public NotaCurso() 
    {
    }

    public NotaCurso(String codCurso, String carneEstudiante, String carneDocente, String estado, double notaFinal)
    {
      this.codCurso = codCurso;
      this.carneEstudiante = carneEstudiante;
      this.carneDocente = carneDocente;
      this.estado = estado;
      this.notaFinal = notaFinal;
    }
    public NotaCurso ingresarDatos(String carneEstudiante, String carneDocente, String codCurso)
    {
      notaFinal = leerNota("Ingrese la nota final del estudiante: ");  
      estado = actualizarEstado(notaFinal);
      return new NotaCurso(codCurso, carneEstudiante,carneDocente,estado,notaFinal);
    }
    public String actualizarEstado(double nf)
    {
        
      return "";  
    }
    public String getCodCurso() 
    {
        return codCurso;
    }

    public void setCodCurso(String codCurso) 
    {
        this.codCurso = codCurso;
    }

    public String getCarneEstudiante() 
    {
        return carneEstudiante;
    }

    public void setCarneEstudiante(String carneEstudiante) 
    {
        this.carneEstudiante = carneEstudiante;
    }

    public String getCarneDocente() 
    {
        return carneDocente;
    }

    public void setCarneDocente(String carneDocente) 
    {
        this.carneDocente = carneDocente;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public double getNotaFinal() 
    {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) 
    {
        this.notaFinal = notaFinal;
    }
    
  
    @Override
    public String toString() 
    {
     return codCurso+"|"+carneEstudiante+"|"+carneDocente+"|"+estado+"|"+notaFinal;
    }
}
