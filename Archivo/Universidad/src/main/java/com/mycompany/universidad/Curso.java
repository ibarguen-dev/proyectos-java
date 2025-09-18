package com.mycompany.universidad;
import java.util.Scanner;
import static com.mycompany.universidad.Validacion.*;
public class Curso {
     private String nombre,codCurso;
    private int  creditos;
    
    Curso(){
        
    }
    
    Curso(String codCurso,String nombre,int creditos){
        this.nombre = nombre;
        this.codCurso = codCurso;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    public Curso ingresarDatos(String codCurso){
        Scanner sc = new Scanner(System.in); 
        nombre = leerString("Ingrese el nombre del curso: ");
        creditos = leerCreditos("Ingrese el numero de créditos: ");
        return new Curso(codCurso, nombre, creditos);
    }

    @Override
    public String toString() {
        return codCurso+"|"+nombre+"|"+creditos;
    }
    
}
