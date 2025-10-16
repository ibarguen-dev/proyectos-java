/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fusanjose;

import static fusanjose.Validacion.*;


/**
 *
 * @author miguelmanosalva
 */
public class CRUDDocente 
{
  public CRUDDocente() 
    {
     
    }
    
    public void IngresarDocente(Archivo objArchivo) 
    {   
       Docente objD = new Docente();
       String carneDocente= leerCarneDocente("Ingresar Codigo del Docente: ");
       
        if(Buscar(objArchivo,carneDocente) == false) 
         {//si no lo encuentra
            objD = objD.ingresarDatos(carneDocente);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objD);  //metodo que graba fisicamente el registro en memoria
         }
        else 
        {
            System.out.println("*****Docente YA existe en el archivo*****");
        }//Fin if 
    }//fin  de ingresar Estudiante
    
  public void Grabar(Archivo objArchivos, Docente objD ) 
    {
        objArchivos.abrirModoEscritura("DatosDocentes.txt");
        objArchivos.escribir(objD.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
     }//fin  Grabar Estudiante
  
  public boolean Buscar(Archivo objArch, String carneDocente) //busca en un vector tipo Estudiante
    { 
        boolean sw=false;
        String cod;
        try 
        {
            Docente objD = new Docente();
            int tamaño = objArch.contadorLineas("DatosDocentes.txt");
            objArch.abrirModoLectura("DatosDocentes.txt");
            Docente vecD[] = new Docente[tamaño];
            vecD = objArch.leerDocente();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int cantRegistros = objArch.contadorLineas("DatosDocentes.txt");
            while (i<= cantRegistros) 
            {
               objD = vecD[i];
               cod = objD.getCarneDocente();
               if(cod.equals(carneDocente))
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
  
  
  public Docente Consultar(Archivo objArchivo, String carneDocente) 
  {
    objArchivo.abrirModoLectura("DatosDocentes.txt");
    Docente[] Docente = objArchivo.leerDocente();
    objArchivo.cerrarModoLectura();

    for (Docente d : Docente) 
     {
        if (d != null && d.getCarneDocente().equals(carneDocente)) 
        {
            return d; // Devuelve el objeto Estudiante encontrado
        }
     }
    return null; // Si no existe
  }
  
  public void Actualizar(Archivo objArchivos, String carneDoc)
   {
    String carneDocente, nombre, apellido, tel, correo, titulo;
    int edad;
    double salario;
    objArchivos.abrirModoLectura("DatosDocentes.txt");
    int op;
    if(objArchivos.archivo.exists()== true)
    {
     int cantLineas = objArchivos.contadorLineas("DatosDocentes.txt");
     Docente vecD[] = new Docente[cantLineas];
     try
      {
       boolean sw = false;
       Docente objD = new Docente();
       vecD = objArchivos.leerDocente();//Almacenamos cada registro del archivo en un vector tipo hospital
       int i =0;
       while (i < cantLineas) 
        {
         objD = vecD[i]; 
         carneDocente = objD.getCarneDocente();
         nombre = objD.getNombre();
         apellido = objD.getApellido();
         tel = objD.getTel();
         correo = objD.getCorreo();
         edad = objD.getEdad();
         titulo = objD.getTitulo();
         salario = objD.getSalario();
         if(carneDocente.equals(carneDocente))
         {
          sw = true;
          System.out.println("Se actualizará el registro cuyo docente es: "+carneDocente);
          do
           {
            op = leerEntero(" 1. edad █ 2. tel █ 3. correo █ 4. titulo █ 5. salario");
            switch(op)
             {
              case 1:
               edad= leerEdadEstudiante("Ingrese la nueva edad del Docente: ");
               break;
              case 2:
               correo = leerCadena("Ingrese el nuevo correo del Docente: ");
               break;
              case 3:
               tel = leerCadena("Ingrese el nuevo telefono del Docente: ");
               break;
               case 4:
               titulo = leerCadena("Ingrese el nuevo titulo del Docente: ");
               salario = objD.asignacionSalario(titulo); 
               break;
            }  
           }while(op<3);
          objD = new Docente(carneDocente,nombre,apellido, tel,correo,edad, titulo, salario);
          vecD[i]= objD;
          System.out.println(" registro actualizado"+ objD.toString());
        }
        else
         {
          vecD[i]= objD;
         }
         i++;
        }
       if(sw ==false)
        {
          System.out.println("El Docente No existe");
        }  
     objArchivos.cerrarModoLectura();
     }catch (Exception e)
      {
       System.out.println("***Archivo leido y cerrado correctamente*****");
       objArchivos.cerrarModoLectura();
      }
     grabarActualizacion(vecD, objArchivos);
    }
  else 
   {
    System.out.println("No existe un archivo para actualizar");
   }
 
  }
   
  public void grabarActualizacion(Docente[] vecD, Archivo objArchCopy) 
     {   
        Docente objD;
        objArchCopy.cerrarModoLectura(); // se cierra el archivo que se encuentra en modo lectura
        objArchCopy.eliminaArchivo("DatosDocentes.txt"); // se elimina el archivo original
        objArchCopy.abrirModoEscritura("DatosDocentes.txt");
        for(int i = 0; i<vecD.length;i++)
        {
         objD = vecD[i];
         String texto = "";
         texto = objD.toString();//con este metodo se da la estructura al registro
         objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo 
        }
        objArchCopy.cerrarModoEscritura();
    } 
  
  public String Mostrar(Archivo objArch) 
    { 
        String cadena=" ";//cadena para el almacenamiento de todos los registros
        Docente objD;
        //int tamaño;
        try {
             int cantRegistros = objArch.contadorLineas("DatosDocentes.txt");
             //tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
             Docente vecD[] = new Docente[cantRegistros];
             objArch.abrirModoLectura("DatosDocentes.txt");
           
            vecD = objArch.leerDocente();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i =0;
            //int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<=cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
              objD = vecD[i];
              cadena=cadena+"[ "+objD.toString()+" ]\n";//se anexan cada registro a la cadena
              i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
            
        } catch (Exception e)
        {
             System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de método mostrar 
  
  public String EliminarRegistro(Archivo objArchivos, String carneDoc) 
  {
        try 
        {
            // 1. Leer todos los Estudiante
            objArchivos.abrirModoLectura("DatosDocentes.txt");
            Docente[] todos = objArchivos.leerDocente();
            objArchivos.cerrarModoLectura();

            if (todos == null || todos.length == 0) 
            {
                return "No hay Docentes registrados.";
            }

            // 2. Contar Estudiante que NO coinciden con el ID a eliminar
            int contador = 0;
            String eliminado = "";
            for (Docente d : todos) 
            {
                if (d != null && !d.getCarneDocente().equals(carneDoc)) 
                {
                    contador++;
                } else if (d != null) 
                {
                    eliminado = d.toString();
                }
            }

            // 3. Si no se encontró el cliente
            if (eliminado.isEmpty()) 
            {
                return "Docente no encontrado.";
            }

            // 4. Crear nuevo array sin el cliente eliminado
            Docente[] nuevos = new Docente[contador];
            int index = 0;
            for (Docente d : todos) 
            {
                if (d != null && !d.getCarneDocente().equals(carneDoc)) 
                {
                    nuevos[index] = d;
                    index++;
                }
            }

            // 5. Regenerar archivo
            objArchivos.eliminaArchivo("DatosDocentes.txt");
            for (Docente d : nuevos) 
            {
                if (d != null) 
                {
                    Grabar(objArchivos, d);
                }
            }

            return "Eliminado: " + eliminado;

        } catch (Exception e) 
           {
            return "Error al eliminar: " + e.getMessage();
           }
    }
   
    
}
