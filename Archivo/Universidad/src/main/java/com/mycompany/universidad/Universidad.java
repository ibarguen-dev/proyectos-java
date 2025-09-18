package com.mycompany.universidad;

import java.util.Scanner;

public class Universidad {
 static Scanner   sc = new Scanner(System.in);
    public static void main(String[] args) {
        Archivo objArchivos = new Archivo();
        int op = 0;
        do {
            System.out.println("******** Adminitracion U**********");
            System.out.println("1. Para administrar Estudiante");
            System.out.println("2. Para administrar Docente");
            System.out.println("3. Para administrar Nota");
            System.out.println("4. Para administrar NotaEstudiante");
            System.out.println("5. Salir");
            op = sc.nextInt();
            switch (op){
                case 1:
                    Estudiante(objArchivos);
                    break;
                case 2:
                    Docente(objArchivos);
                    break;
                case 3:
                    Curso(objArchivos);
                    break;
                case 4:
                    NotaCurso(objArchivos);
                    break;
                default:
                    System.out.println("La opcion ingresada no es correcta");
            }
        }while (op !=5);
    }
    
    
    
    private static void Estudiante(Archivo objArchivos ){
        CRUDEstudiante estudiante = new CRUDEstudiante();
        int op = 0;
        do {
            System.out.println("******** Estudiante **********");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Actualizar Estudiante");
            System.out.println("3. Consultar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Mostrar Estudiante");
            System.out.println("6. Salir");
            op = sc.nextInt();
            switch (op){
                case 1:
                    estudiante.IngresarEstudiante(objArchivos);
                    break;
                case 2:
                    estudiante.Actualizar(objArchivos);
                    break;
                case 3:
                    estudiante.Consultar(objArchivos);
                    break;
                case 4:
                    estudiante.Eliminar(objArchivos);
                    break;
                case 5:
                    estudiante.Mostrar(objArchivos);
                default:
                    System.out.println("La opcion ingresada no es correcta");
            }
        }while (op !=6);
    }
    
    
    private static void Docente(Archivo objArchivos ){
        CRUDDocente docente = new CRUDDocente();
        int op = 0;
        do {
            System.out.println("******** Docente **********");
            System.out.println("1. Agregar Docente");
            System.out.println("2. Actualizar Docente");
            System.out.println("3. Consultar Docente");
            System.out.println("4. Eliminar Docente");
            System.out.println("5. Mostrar Docente");
            System.out.println("6. Salir");
            op = sc.nextInt();
            switch (op){
                case 1:
                    docente.IngresarDocente(objArchivos);
                    break;
                case 2:
                    docente.Actualizar(objArchivos);
                    break;
                case 3:
                    docente.Consultar(objArchivos);
                    break;
                case 4:
                    docente.EliminarRegistro(objArchivos);
                    break;
                case 5:
                    docente.Mostrar(objArchivos);
                default:
                    System.out.println("La opcion ingresada no es correcta");
            }
        }while (op !=6);
    }
    
    private static void Curso(Archivo objArchivos ){
        CRUDCurso curso = new CRUDCurso();
        int op = 0;
        do {
            System.out.println("******** Estudiante **********");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Actualizar Estudiante");
            System.out.println("3. Consultar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Mostrar Estudiante");
            System.out.println("6. Salir");
            op = sc.nextInt();
            switch (op){
                case 1:
                    curso.IngresarCurso(objArchivos);
                    break;
                case 2:
                    curso.Actualizar(objArchivos);
                    break;
                case 3:
                    curso.Consultar(objArchivos);
                    break;
                case 4:
                    curso.EliminarRegistro(objArchivos);
                    break;
                case 5:
                    curso.Mostrar(objArchivos);
                default:
                    System.out.println("La opcion ingresada no es correcta");
            }
        }while (op !=6);

    }
    
    
    private static void NotaCurso(Archivo objArchivos ){
        CRUDNotaCurso notaCurso = new CRUDNotaCurso();
        int op = 0;
        do {
            System.out.println("******** NotaCursos **********");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Actualizar Estudiante");
            System.out.println("3. Consultar Estudiante");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Mostrar Estudiante");
            System.out.println("6. Salir");
            op = sc.nextInt();
            switch (op){
                case 1:
                    notaCurso.IngresarNotaCurso(objArchivos);
                    break;
                case 2:
                    notaCurso.Actualizar(objArchivos);
                    break;
                case 3:
                    notaCurso.Consultar(objArchivos);
                    break;
                case 4:
                    notaCurso.EliminarRegistro(objArchivos);
                    break;
                case 5:
                    notaCurso.Mostrar(objArchivos);
                default:
                    System.out.println("La opcion ingresada no es correcta");
            }
        }while (op !=6);
    }
}
