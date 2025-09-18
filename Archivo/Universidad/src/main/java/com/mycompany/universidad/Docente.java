package com.mycompany.universidad;
import static com.mycompany.universidad.Validacion.*;

public class Docente extends Persona{
     private String carneDocente, titulo;
    private float salario;

    
    Docente(){
        super();
    }
    
    Docente(String carneDocente,String nombre, String apellido, String telefono, 
            String correo, int edad,String titulo,float salario){
        super(nombre,apellido,telefono,correo,edad);
        this.carneDocente = carneDocente;
        this.titulo = titulo;
        this.salario = salario;
    }

    public String getCarneDocente() {
        return carneDocente;
    }

    public void setCarneDocente(String carneDocente) {
        this.carneDocente = carneDocente;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String Titulo) {
        this.titulo = Titulo;
    }
    
    public float asignacionSalario(String t)
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
    
    public Docente guardarDocente(String codDocente){
        Docente doc;
        String nombre, apellido, telefono, correo;
        int edad;

        nombre = leerString("Ingresar el nombre del docente");
        apellido = leerString("Ingresar apellido del docente");;
        telefono = leerString("Ingresar el telefono del docente");
        correo = leerString("Ingresar el correo del docente");
        edad = leerEdad("Ingresar la edad del docente");
        carneDocente = codDocente;
        titulo = leerTitulo();
        salario = leerSalario(titulo);
        doc = new Docente(carneDocente,nombre, apellido, telefono, correo,edad,
        titulo,salario);
        return doc;
    }

    
    public String estructuraRegistro() {
        return   carneDocente +"| "+ super.getNombre() +"| "+ super.getApellido() 
            +"| "+ super.getEdad() + "| "+ super.getTelefono()+"| " 
            +"| "+ super.getCorreo()+ "| "+ super.getEdad() + "| " +titulo + "| "+ + salario;
    }
}
