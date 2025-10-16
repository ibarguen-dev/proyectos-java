
package fusanjose;
import static fusanjose.Validacion.*;
import java.util.Scanner;
public class FUSanJose 
{
    static Archivo objArchivo = new Archivo();
    static CRUDEstudiante crudE = new CRUDEstudiante();
    static CRUDDocente crudD = new CRUDDocente();
    static CRUDCurso crudC = new CRUDCurso();
    static CRUDNotaCurso crudNC = new CRUDNotaCurso();
    static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) 
   {
    menuPrincipal();
   }
   
   public static void menuPrincipal() 
   {
    int swArchivos; 
    do // se ejecuta ciclo para retornar al menu de centro de consulta
      {
        System.out.println("*****Centro de Consulta *******");
        System.out.println("1- Menu Estudiante ");
        System.out.println("2- Menu Docente ");
        System.out.println("3- Menu Curso ");
        System.out.println("4- Menu Nota Curso"); // Nueva opción para gestionar citas
        System.out.println("5- Salir");
        swArchivos = sc.nextInt();
        switch (swArchivos) 
        {
          case 1:
            menuArchivoEstudiante();
            break;
          case 2:
            menuArchivoDocente();
            break;
          case 3:
            menuArchivoCurso();
            break;
          case 4:
            menuArchivoNotaCurso();
            break;    
         }
       }while(swArchivos < 5);                   
    }

   
   public static String menuArchivoE() 
   {
        return (" **** MENU ARCHIVO Estudiante ****\n"
                + "1. Ingresar Estudiannte\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Estudiante\n"
                + "4. Eliminar un Estudiante\n"
                + "5. actualizar un Estudiante\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

    }
    
    public static String menuArchivoD() 
   {
        return (" **** MENU ARCHIVO DOCENTE ****\n"
                + "1. Ingresar Docente\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Docente\n"
                + "4. Eliminar un Docente\n"
                + "5. actualizar un Docente\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

    }
    
        public static String menuArchivoC() 
   {
        return (" **** MENU ARCHIVO CURSO ****\n"
                + "1. Ingresar Curso\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Curso\n"
                + "4. Eliminar un Curso\n"
                + "5. actualizar un Curso\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

    }
     public static String menuArchivoNC() 
      {
        return (" **** MENU ARCHIVO NOTA CURSO ****\n"
                + "1. Ingresar Datos\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar por Estudiante\n"
                + "4. Consultar por Docente\n"
                + "5. Consultar por Curso\n"
                + "4. Eliminar un registro\n"
                + "5. actualizar una nota de un estudiante según su curso\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

      }
     
  public static void menuArchivoEstudiante() 
  {
    int opE;
        String idEstudiante;
        do {
            opE = leerEntero(menuArchivoE());
            switch (opE) {
                case 1:
                    System.out.println("*******************************************\n");
                    crudE.IngresarEstudiante(objArchivo);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Estudiante son: \n" + crudE.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idEstudiante = leerCarneEstudiante("Digite el IDEstudiante del cliente a consultar: ");
                    System.out.println("El cliente consultado es: " + crudE.Consultar(objArchivo, idEstudiante));
                    break;
                case 4: 
                    idEstudiante = Validacion.leerCarneEstudiante("ID a eliminar: ");
                    System.out.println(crudE.EliminarRegistro(objArchivo, idEstudiante));
                    break;
                case 5: 
                    idEstudiante = Validacion.leerCarneEstudiante("ID a actualizar: ");
                    crudE.Actualizar(objArchivo, idEstudiante);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    String nom = sc.nextLine();
                    objArchivo.renombrarArchivo(nom + ".txt");
                    break;
                case 7:
                    objArchivo.eliminaArchivo("DatosEstudiantes.txt");
                    break;
            }
        } while (opE < 7);
   }
  public static void menuArchivoDocente() 
  {
     int opD;
        String idDocente;
        do {
            opD = leerEntero(menuArchivoD());
            switch (opD) {
                case 1:
                    System.out.println("*******************************************\n");
                    crudD.IngresarDocente(objArchivo);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Docente son: \n" + crudD.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idDocente = leerCarneDocente("Digite el IDDocente a consultar: ");
                    System.out.println("El docente consultado es: " + crudD.Consultar(objArchivo, idDocente));
                    break;
                case 4: 
                    idDocente = Validacion.leerCarneDocente("ID a eliminar: ");
                    System.out.println(crudD.EliminarRegistro(objArchivo, idDocente));
                    break;
                case 5: 
                    idDocente = Validacion.leerCarneDocente("ID a actualizar: ");
                    crudD.Actualizar(objArchivo, idDocente);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    String nom = sc.nextLine();
                    objArchivo.renombrarArchivo(nom + ".txt");
                    break;
                case 7:
                    objArchivo.eliminaArchivo("DatosDocentes.txt");
                    break;
            }
        } while (opD < 7);

    }
    
    public static void menuArchivoCurso() 
  {
     int opC;
        String idCurso;
        do {
            opC = leerEntero(menuArchivoC());
            switch (opC) {
                case 1:
                    System.out.println("*******************************************\n");
                    crudC.IngresarCurso(objArchivo);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Curso son: \n" + crudC.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idCurso = leerCarneDocente("Digite el IDcurso a consultar: ");
                    System.out.println("El curso consultado es: " + crudC.Consultar(objArchivo, idCurso));
                    break;
                case 4: 
                    idCurso = Validacion.leerCarneDocente("ID a eliminar: ");
                    System.out.println(crudC.EliminarRegistro(objArchivo, idCurso));
                    break;
                case 5: 
                    idCurso = Validacion.leerCarneDocente("ID a actualizar: ");
                    crudC.Actualizar(objArchivo, idCurso);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    String nom = sc.nextLine();
                    objArchivo.renombrarArchivo(nom + ".txt");
                    break;
                case 7:
                    objArchivo.eliminaArchivo("DatosCursos.txt");
                    break;
            }
        } while (opC < 7);

    }
     public static void menuArchivoNotaCurso() 
  {
     int opNC;
        String idEstudiante;
        do {
            opNC = leerEntero(menuArchivoNC());
            switch (opNC) {
                case 1:
                    System.out.println("*******************************************\n");
                    crudNC.IngresarNotaCurso(objArchivo);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Nota Curso son: \n" + crudNC.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    System.out.println(crudNC.Consultar(objArchivo));
                    break;
                case 4: 
                    idEstudiante = Validacion.leerCarneEstudiante("ID de Estudiante a eliminar: ");
                    System.out.println(crudNC.EliminarRegistro(objArchivo, idEstudiante));
                    break;
                case 5: 
                    idEstudiante = Validacion.leerCarneEstudiante("ID a actualizar: ");
                    crudNC.Actualizar(objArchivo, idEstudiante);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    String nom = sc.nextLine();
                    objArchivo.renombrarArchivo(nom + ".txt");
                    break;
                case 7:
                    objArchivo.eliminaArchivo("DatosNotasCursos.txt");
                    break;
            }
        } while (opNC < 7);

    }
     
    
}
