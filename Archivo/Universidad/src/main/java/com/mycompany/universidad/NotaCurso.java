package com.mycompany.universidad;


public class NotaCurso {
    private String codCurso,carneEstudiante,carneDocente,estado;
    private float notaFinal;
    
    NotaCurso(){
        
    }
    
    NotaCurso(String codCurso,String carneEstudiante, String carneDocente,
    String estado, float notaFinal ){
        this.codCurso=codCurso;
        this.carneEstudiante=carneEstudiante;
        this.carneDocente=carneDocente;
        this.estado=estado;
        this.notaFinal=notaFinal;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getCarneEstudiante() {
        return carneEstudiante;
    }

    public void setCarneEstudiante(String carneEstudiante) {
        this.carneEstudiante = carneEstudiante;
    }

    public String getCarneDocente() {
        return carneDocente;
    }

    public void setCarneDocente(String carneDocente) {
        this.carneDocente = carneDocente;
    }

 

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    public NotaCurso ingresarDatos(String codCurso,String carneEstudiante, String carneDocente,
    String estado, float notaFinal){
       
        return new NotaCurso(codCurso,carneEstudiante,carneDocente,
        estado,notaFinal);
    }
    
      public  String actualizarEstado(float nota){
      String estado = "Aprobo";
      if(nota<3){
          estado = "Reprobo";
      }
      return estado;
  }
      
          @Override
    public String toString() 
    {
     return codCurso+"|"+carneEstudiante+"|"+carneDocente+"|"+estado+"|"+notaFinal;
    }
}
