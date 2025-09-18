package com.mycompany.universidad;
import static com.mycompany.universidad.Validacion.*;
public class CRUDNotaCurso {
    CRUDNotaCurso(){
        
    }
    public void IngresarNotaCurso(Archivo objArchivo) 
    {   
       NotaCurso objNC = new NotaCurso();
       
       String codCurso= leerString("Ingresar Codigo del curso : ");
       String carneDocente = leerCarneDocente("Ingresar Codigo del docente : ");
       String carneEstudiante = leerCarneEstudiante("Ingresar Codigo del estudiante: ");
       float notaFinal = leerNota("Ingresa la nota del estudiante: ");
       String estado = leerEstadoG(notaFinal);
       do
       {
        if(BuscarCurso(objArchivo,codCurso) == false) 
         {
           System.out.println("el codigo del curso no se encuentra en el archivo, por favor ingrese nuevamente el codigo");
           codCurso= leerString("Ingresar Codigo del curso: ");
         }
       }while(BuscarCurso(objArchivo,codCurso) == false);
      do
       {
        if(BuscarCurso(objArchivo,carneDocente) == false) 
         {
           System.out.println("el carne de docente no se encuentra en el archivo, por favor ingrese nuevamente el carne");
           carneDocente= leerCarneDocente("Ingresar carne del docente: ");
         }
       }while(BuscarCurso(objArchivo,carneDocente) == false);
      do
       {
        if(BuscarCurso(objArchivo,carneEstudiante) == false) 
         {
           System.out.println("el carne del estudiante no se encuentra en el archivo, por favor ingrese nuevamente el carne");
           codCurso= leerString("Ingresar carne del estudiante: ");
         }
       }while(BuscarCurso(objArchivo,carneEstudiante) == false);
       
        objNC = objNC.ingresarDatos(codCurso,carneEstudiante,carneDocente,
                estado,notaFinal);//lee toda la informacion y recibe el objeto
        Grabar(objArchivo,objNC);  //metodo que graba fisicamente el registro en memoria
    }//fin  de ingresar Estudiante
    
  public void Grabar(Archivo objArchivos, NotaCurso objNC ) 
    {
        objArchivos.abrirModoEscritura("DatosNotasCursos.txt");
        objArchivos.escribir(objNC.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
     }
  
  public boolean BuscarCurso(Archivo objArch, String codCurso) //busca en un vector tipo Estudiante
    { 
        boolean swC=false;
        String cod;
        try 
        {
            Curso objC = new Curso();
            int tamañoCur = objArch.contadorLineas("DatosCursos.txt");
            objArch.abrirModoLectura("DatosCursos.txt");
            Curso vecC[] = new Curso[tamañoCur];
            vecC = objArch.leerCurso();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int RegC = objArch.contadorLineas("DatosCursos.txt");
            while (i<= RegC) 
            {
               objC = vecC[i];
               cod = objC.getCodCurso();
               if(cod.equals(codCurso))
                {
                    swC=true;
                    break;
                }
               i++;
            }
            
            objArch.cerrarModoLectura();

        } catch (Exception e)
        {
             System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return swC;
        
    }
  public boolean BuscarDocente(Archivo objArch, String carneDocente) //busca en un vector tipo Estudiante
    { 
        boolean swD=false;
        String cod;
        try 
        {
            Docente objD = new Docente();
            int tamañoDoc = objArch.contadorLineas("DatosDocentes.txt");
            objArch.abrirModoLectura("DatosDocentes.txt");
            Docente vecD[] = new Docente[tamañoDoc];
            vecD = objArch.leerDocente();
            int i=0;
            int RegD = objArch.contadorLineas("DatosDocentes.txt");
            while (i<= RegD) 
            {
               objD = vecD[i];
               cod = objD.getCarneDocente();
               if(cod.equals(carneDocente))
                {
                    swD=true;
                    break;
                }
               i++;
            }
          objArch.cerrarModoLectura();

        } catch (Exception e)
        {
             System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return swD;
        
    }//fin de buscar*/
  public boolean BuscarEstudiante(Archivo objArch,String carneEstudiante) //busca en un vector tipo Estudiante
    { 
        boolean swE=false;
        String cod;
        try 
        {
            Estudiante objE = new Estudiante();
            int tamañoEst = objArch.contadorLineas("DatosEstudiantes.txt");
            objArch.abrirModoLectura("DatosEstudiantes.txt");
            Estudiante vecE[] = new Estudiante[tamañoEst];
            vecE = objArch.leerEstudiante();
            int i=0;
            int RegE = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<= RegE) 
            {
               objE = vecE[i];
               cod = objE.getCarneEstudiante();
               if(cod.equals(carneEstudiante))
                {
                    swE=true;
                    break;
                }
               i++;
            }
           objArch.cerrarModoLectura();

        } catch (Exception e)
        {
             System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return swE;
        
    }//fin de buscar*/
  
  public NotaCurso Consultar(Archivo objArchivo) 
  {
    int op;  
    CRUDCurso cc = new CRUDCurso();
    objArchivo.abrirModoLectura("DatosNotasCursos.txt");
    NotaCurso[] vecNC = objArchivo.leerNotaCurso();
    objArchivo.cerrarModoLectura();
    op = leerEntero("█ 1. Consultar por Estudiante █ 2. Consultar por Docente █ 3. Consultar por Curso ");
    switch(op)
      {
        case 1:
          String carneEstudiante = leerCarneEstudiante("ingrese el carne del estudiante que desea consultar: ");
          for (NotaCurso nc : vecNC) 
          {
           if(nc != null && nc.getCarneEstudiante().equals(carneEstudiante)) 
            {
             return nc; // Devuelve el objeto Estudiante encontrado
            }
          }
          break;    
        case 2:
          String carneDocente = leerCarneDocente("ingrese el carne del docente que desea consultar: ");
          for (NotaCurso nc : vecNC) 
          {
           if(nc != null && nc.getCarneDocente().equals(carneDocente)) 
            {
             return nc; // Devuelve el objeto Estudiante encontrado
            }
          }
          break;  
         case 3:
          String codCurso = leerString("ingrese el codigo del curso que desea consultar: ");
          for (NotaCurso nc : vecNC) 
          {
           if(nc != null && nc.getCodCurso().equals(codCurso)) 
            {
             return nc; // Devuelve el objeto Estudiante encontrado
            }
          }
          break;
        default:
            System.out.println("**** Opcion no valida ****");
    }    

    return null; // Si no existe
  }
  
  public void Actualizar(Archivo objArchivos)
   {
       String carneEst= leerCarneEstudiante("Ingresar Codigo del Estudiante: ");
    String estado, codCurso, carneEstudiante, carneDocente;
    float notaFinal;
    objArchivos.abrirModoLectura("DatosNotaCursos.txt");
    int op=1;
    boolean sw = false;
    if(objArchivos.archivo.exists()== true)
    {
     int cantLineas = objArchivos.contadorLineas("DatosNotaCursos.txt");
     NotaCurso vecNC[] = new NotaCurso[cantLineas];
     try
      {
       NotaCurso objNC = new NotaCurso();
       vecNC = objArchivos.leerNotaCurso();//Almacenamos cada registro del archivo en un vector tipo hospital
       int i =0;
       while (i < cantLineas) 
        {
         objNC = vecNC[i]; 
         carneEstudiante = objNC.getCarneEstudiante();
         carneDocente = objNC.getCarneDocente();
         codCurso = objNC.getCodCurso();
         estado = objNC.getEstado();
         notaFinal = objNC.getNotaFinal();
         if(carneEst.equals(carneEstudiante)&&(op==1))
         {
          sw = true;
          System.out.println("Se actualizarán los registros la nota del curso para el estudiante con el carné: "+carneEstudiante);
          notaFinal=leerNota("Ingrese la nueva nota para el estudiante en el curso "+codCurso+": ");
          estado = objNC.actualizarEstado(notaFinal);
          System.out.println("*** Registro Actualizado ***");
         }
         else
         {
          vecNC[i]= objNC;
         }
           objNC = new NotaCurso(carneEstudiante, carneDocente, codCurso,estado,notaFinal);
           vecNC[i]= objNC;
           System.out.println(" registro actualizado"+ objNC.toString());
           op = leerEntero("Desea seguir actualizando notas del estudiante: █ 1. Sí █ 2.No");
           i++;
         }
        if(sw ==false)
        {
          System.out.println("El estdudiante No existe");
        }  
       objArchivos.cerrarModoLectura();
     }catch (Exception e)
      {
       System.out.println("***Archivo leido y cerrado correctamente*****");
       objArchivos.cerrarModoLectura();
      }
     grabarActualizacion(vecNC, objArchivos);
    }
  else 
   {
    System.out.println("No existe un archivo para actualizar");
   }
 
}
   
  public void grabarActualizacion(NotaCurso[] vecNC, Archivo objArchCopy) 
     {   
        NotaCurso objNC;
        objArchCopy.cerrarModoLectura(); // se cierra el archivo que se encuentra en modo lectura
        objArchCopy.eliminaArchivo("DatosNotasCursos.txt"); // se elimina el archivo original
        objArchCopy.abrirModoEscritura("DatosNotasCursos.txt");
        for(int i = 0; i<vecNC.length;i++)
        {
         objNC = vecNC[i];
         String texto = "";
         texto = objNC.toString();//con este metodo se da la estructura al registro
         objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo 
        }
        objArchCopy.cerrarModoEscritura();
    } 
  
  public String Mostrar(Archivo objArch) 
    { 
        String cadena=" ";//cadena para el almacenamiento de todos los registros
        NotaCurso objNC;
        //int tamaño;
        try {
             int cantRegistros = objArch.contadorLineas("DatosNotaCursos.txt");
             //tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
             NotaCurso vecNC[] = new NotaCurso[cantRegistros];
             objArch.abrirModoLectura("DatosNotaCursos.txt");
           
            vecNC = objArch.leerNotaCurso();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i =0;
            //int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<=cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
              objNC = vecNC[i];
              cadena=cadena+"[ "+objNC.toString()+" ]\n";//se anexan cada registro a la cadena
              i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
            
        } catch (Exception e)
        {
             System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de método mostrar 
  
  public String EliminarRegistro(Archivo objArchivos)
  {
      String carneEst= leerCarneEstudiante("Ingresar Codigo del Estudiante: ");
        try 
        {
            // 1. Leer todos los Estudiante
            objArchivos.abrirModoLectura("DatosNotaCursos.txt");
            NotaCurso[] todos = objArchivos.leerNotaCurso();
            objArchivos.cerrarModoLectura();

            if (todos == null || todos.length == 0) 
            {
                return "No hay Estudiante registrados.";
            }

            // 2. Contar Estudiante que NO coinciden con el ID a eliminar
            int contador = 0;
            String eliminado = "";
            for (NotaCurso nc : todos) 
            {
                if (nc != null && !nc.getCarneEstudiante().equals(carneEst)) 
                {
                    contador++;
                } else if (nc != null) 
                {
                    eliminado = nc.toString();
                }
            }

            // 3. Si no se encontró el cliente
            if (eliminado.isEmpty()) 
            {
                return "Estudiante no encontrado.";
            }

            // 4. Crear nuevo array sin el cliente eliminado
            NotaCurso[] nuevos = new NotaCurso[contador];
            int index = 0;
            for (NotaCurso nc : todos) 
            {
                if (nc != null && !nc.getCarneEstudiante().equals(carneEst)) 
                {
                    nuevos[index] = nc;
                    index++;
                }
            }

            // 5. Regenerar archivo
            objArchivos.eliminaArchivo("DatosNotaCursos.txt");
            for (NotaCurso nc : nuevos) 
            {
                if (nc != null) 
                {
                    Grabar(objArchivos, nc);
                }
            }

            return "Eliminado: " + eliminado;

        } catch (Exception e) 
           {
            return "Error al eliminar: " + e.getMessage();
           }
    }
   
    
/*Crear un pseudocódigo que permita consultar cuantos estudiantes le aprobaron 
  a un docente el método me debe retornar una cadena con el nombre del estudiante 
  y la nota del curso*/

public String aprobadosXdocente(Archivo nc)
{
 String resultado ="";
 Archivo d = new Archivo();
 Archivo e = new Archivo();
 String carneDocente = leerCarneDocente("Ingrese el carne del docente a consultar: ");
 nc.abrirModoLectura("DatosNotaCursos.txt");
 d.abrirModoLectura("DatosDocentes.txt");
 e.abrirModoLectura("DatosEstudiantes.txt");
 if(BuscarDocente(d, carneDocente)==false)
 {
   resultado = "Docente no existe";  
 }
 else 
 {
     Estudiante vecE[] = new Estudiante[e.contadorLineas("DatoEstudiantes.txt")]; 
     NotaCurso vecNC[] = new NotaCurso[nc.contadorLineas("DatoNotaCursos.txt")]; 
     vecNC = nc.leerNotaCurso();
     vecE = e.leerEstudiante();
     for(int i = 0; i < vecNC.length; i++)
     {
      if((carneDocente == vecNC[i].getCarneDocente())&& (vecNC[i].getNotaFinal()>=3))
        {
          for(int j = 0; j < vecE.length; j++)
           { 
             if(vecNC[i].getCarneEstudiante()==vecE[j].getCarneEstudiante())
                resultado = resultado + vecE[j].getNombre() + vecNC[i].getNotaFinal();
            }  
        }
     }
      if(resultado == " ")
        resultado = "el docente no tiene curso asignado";
       
     }
      nc.cerrarModoLectura();
      d.cerrarModoLectura();
      e.cerrarModoLectura();
  return resultado;
 }       
}
