package fusanjose;

import static fusanjose.Validacion.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
 - ingresar
 - eliminar 
 - mostrar
 - consultar
*/

public class CRUDEstudiante 
{
 
    public CRUDEstudiante() 
    {
     
    }
    
    public void IngresarEstudiante(Archivo objArchivo) 
    {   
       Estudiante objE = new Estudiante();
       String carneEstudiante= leerCarneEstudiante("Ingresar Codigo del Estudiante: ");
       
        if(Buscar(objArchivo,carneEstudiante) == false) {//si no lo encuentra
            objE = objE.ingresarDatos(carneEstudiante);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objE);  //metodo que graba fisicamente el registro en memoria
        }
        else {
            System.out.println("*****Estudiante YA existe en el archivo*****");
        }//Fin if 
    }//fin  de ingresar Estudiante
    
  public void Grabar(Archivo objArchivos, Estudiante objE ) 
    {
        objArchivos.abrirModoEscritura("DatosEstudiantes.txt");
        objArchivos.escribir(objE.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
     }//fin  Grabar Estudiante
  
  public boolean Buscar(Archivo objArch, String carneEstudiante) //busca en un vector tipo Estudiante
    { 
        boolean sw=false;
        String cod;
        try 
        {
            Estudiante objE = new Estudiante();
            int tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
            objArch.abrirModoLectura("DatosEstudiantes.txt");
            Estudiante vecE[] = new Estudiante[tamaño];
            vecE = objArch.leerEstudiante();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<= cantRegistros) 
            {
               objE = vecE[i];
               cod = objE.getCarneEstudiante();
               if(cod.equals(carneEstudiante))
                {
                    sw=true;
                    break;
                }
               i++;
            }//fin mientras
            objArch.cerrarModoLectura();

        } catch (Exception e)
        {
             System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return sw;
        
    }//fin de buscar*/
  
  
  public Estudiante Consultar(Archivo objArchivo, String carneEstudiante) 
  {
    objArchivo.abrirModoLectura("DatosEstudiantes.txt");
    Estudiante[] Estudiante = objArchivo.leerEstudiante();
    objArchivo.cerrarModoLectura();

    for (Estudiante e : Estudiante) 
     {
        if (e != null && e.getCarneEstudiante().equals(carneEstudiante)) 
        {
            return e; // Devuelve el objeto Estudiante encontrado
        }
     }
    return null; // Si no existe
  }
  
  public void Actualizar(Archivo objArchivos, String carneEst)
   {
    String carneEstudiante, nombre, apellido, tel, correo;
    int edad;
    objArchivos.abrirModoLectura("DatosEstudiantes.txt");
    int op;
    if(objArchivos.archivo.exists()== true)
    {
     int cantLineas = objArchivos.contadorLineas("DatosEstudiantes.txt");
     Estudiante vecE[] = new Estudiante[cantLineas];
     try
      {
       boolean sw = false;
       Estudiante objE = new Estudiante();
       vecE = objArchivos.leerEstudiante();//Almacenamos cada registro del archivo en un vector tipo hospital
       int i =0;
       while (i < cantLineas) 
        {
         objE = vecE[i]; 
         carneEstudiante = objE.getCarneEstudiante();
         nombre = objE.getNombre();
         apellido = objE.getApellido();
         tel = objE.getTel();
         correo = objE.getCorreo();
         edad = objE.getEdad();
         if(carneEst.equals(carneEstudiante))
         {
          sw = true;
          System.out.println("Se actualizará el registro cuyo Estudiante es: "+carneEstudiante);
          do
           {
            op = leerEntero(" 1. edad █ 2.Tel █ 3. correo");
            switch(op)
             {
              case 1:
               edad= leerEdadEstudiante("Ingrese la nueva edad del estudiante: ");
               break;
              case 2:
               correo = leerCadena("Ingrese el nuevo correo del estudiante: ");
               break;
              case 3:
               tel = leerCadena("Ingrese el nuevo telefono del Estudiante: ");
               break;
            }  
           }while(op<3);
          objE = new Estudiante(carneEstudiante,nombre,apellido, tel,correo,edad);
          vecE[i]= objE;
          System.out.println(" registro actualizado"+ objE.toString());
        }
        else
         {
          vecE[i]= objE;
         }
         i++;
        }
       if(sw ==false)
        {
          System.out.println("El Estudiante No existe");
        }  
     objArchivos.cerrarModoLectura();
     }catch (Exception e)
      {
       System.out.println("***Archivo leido y cerrado correctamente*****");
       objArchivos.cerrarModoLectura();
      }
     grabarActualizacion(vecE, objArchivos);
    }
  else 
   {
    System.out.println("No existe un archivo para actualizar");
   }
 
  }
   
  public void grabarActualizacion(Estudiante[] vecE, Archivo objArchCopy) 
     {   
        Estudiante objE;
        objArchCopy.cerrarModoLectura(); // se cierra el archivo que se encuentra en modo lectura
        objArchCopy.eliminaArchivo("DatosEstudiantes.txt"); // se elimina el archivo original
        objArchCopy.abrirModoEscritura("DatosEstudiantes.txt");
        for(int i = 0; i<vecE.length;i++)
        {
         objE = vecE[i];
         String texto = "";
         texto = objE.toString();//con este metodo se da la estructura al registro
         objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo 
        }
        objArchCopy.cerrarModoEscritura();
    } 
  
  public String Mostrar(Archivo objArch) 
    { 
        String cadena=" ";//cadena para el almacenamiento de todos los registros
        Estudiante objE;
        //int tamaño;
        try {
             int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
             //tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
             Estudiante vecE[] = new Estudiante[cantRegistros];
             objArch.abrirModoLectura("DatosEstudiantes.txt");
           
            vecE = objArch.leerEstudiante();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i =0;
            //int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<=cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
              objE = vecE[i];
              cadena=cadena+"[ "+objE.toString()+" ]\n";//se anexan cada registro a la cadena
              i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
            
        } catch (Exception e)
        {
             System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de método mostrar 
  
  public String EliminarRegistro(Archivo objArchivos, String carneEst) 
  {
        try 
        {
            // 1. Leer todos los Estudiante
            objArchivos.abrirModoLectura("DatosEstudiantes.txt");
            Estudiante[] todos = objArchivos.leerEstudiante();
            objArchivos.cerrarModoLectura();

            if (todos == null || todos.length == 0) 
            {
                return "No hay Estudiante registrados.";
            }

            // 2. Contar Estudiante que NO coinciden con el ID a eliminar
            int contador = 0;
            String eliminado = "";
            for (Estudiante e : todos) 
            {
                if (e != null && !e.getCarneEstudiante().equals(carneEst)) 
                {
                    contador++;
                } else if (e != null) 
                {
                    eliminado = e.toString();
                }
            }

            // 3. Si no se encontró el cliente
            if (eliminado.isEmpty()) 
            {
                return "Estudiante no encontrado.";
            }

            // 4. Crear nuevo array sin el cliente eliminado
            Estudiante[] nuevos = new Estudiante[contador];
            int index = 0;
            for (Estudiante e : todos) 
            {
                if (e != null && !e.getCarneEstudiante().equals(carneEst)) 
                {
                    nuevos[index] = e;
                    index++;
                }
            }

            // 5. Regenerar archivo
            objArchivos.eliminaArchivo("DatosEstudiantes.txt");
            for (Estudiante e : nuevos) 
            {
                if (e != null) 
                {
                    Grabar(objArchivos, e);
                }
            }

            return "Eliminado: " + eliminado;

        } catch (Exception e) 
           {
            return "Error al eliminar: " + e.getMessage();
           }
    }

}
