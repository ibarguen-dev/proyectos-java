package com.mycompany.universidad;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo 
    {
    Scanner sc = new Scanner(System.in);
    File archivo;//archivo logico
    FileReader lectura;//objeto para modo lectura del archivo
    BufferedReader buffer;//objeto que reserva un espacio en memoria donde se guarda la informacion
    BufferedWriter bufferW;
    BufferedReader bufferNEW;
    FileWriter escritura;//objeto para modo escritura del archivo
    PrintWriter impresion;//objeto para grabar directamente en el texto
   
    
   public String escribir(String registro)//graba el texto se dice que lo imprime en el archivo
    {
        String mensaje="grabará un registro";
        
        try
        {  
            impresion.println(registro);
           // impresion.println(); 
           //buffer.close();
         }
        catch(Exception objException)
         {
           mensaje = objException.getMessage(); 
         } 
        
        return mensaje;
    }
    
    public Estudiante[] leerEstudiante()
    {
        int cl = contadorLineas("DatosEstudiante.txt");
        Estudiante vecE[];
        vecE = new Estudiante[cl];
        String registro;
        String vec[];
        vec = new String[6];
       try
        {
           int i = 0;
            while(cl>0)
            {
              registro = buffer.readLine();
              String separador = Pattern.quote("|");
              vec = registro.split(separador);
               String carnE = vec[0];
               String nombre = vec[1];
               String apellido = vec[2];
               String telefono = vec[3];
               String correo = vec[4];
               int edad = Integer.parseInt(vec[5]);
               Estudiante objE = new Estudiante (carnE,nombre,apellido,telefono,
               correo,edad);
               vecE[i] = objE;
               i++;
               cl--;  
            }
         buffer.close();   
        }
        catch(Exception objException)
        {
         objException.getMessage();          
        }
        return vecE;
    }
    
    
        public Docente[] leerDocente()
    {
        int cl = contadorLineas("DatosEstudiante.txt");
        Docente vecD[];
        vecD = new Docente[cl];
        String registro;
        String vec[];
        vec = new String[6];
       try
        {
           int i = 0;
            while(cl>0)
            {
              registro = buffer.readLine();
              String separador = Pattern.quote("|");
              vec = registro.split(separador);
               String carneD = vec[0];
               String nombre = vec[1];
               String apellido = vec[2];
               String telefono = vec[3];
               String correo = vec[4];
               int edad = Integer.parseInt(vec[5]);
               String titulo = vec[6];
               float salario = Float.parseFloat(vec[7]);
               Docente objD = new Docente (carneD,nombre,apellido,telefono,
               correo,edad,titulo,salario);
               vecD[i] = objD;
               i++;
               cl--;  
            }
         buffer.close();   
        }
        catch(Exception objException)
        {
         objException.getMessage();          
        }
        return vecD;
    }
    
    public NotaCurso[] leerNotaCurso()
    {
        int cl = contadorLineas("DatosEstudiante.txt");
        NotaCurso vecNC[];
        vecNC = new NotaCurso[cl];
        String registro;
        String vec[];
        vec = new String[5];
       try
        {
           int i = 0;
            while(cl>0)
            {
              registro = buffer.readLine();
              String separador = Pattern.quote("|");
              vec = registro.split(separador);
               String codCurso = vec[0];
               String carneEstudiante = vec[1];
               String carneDocente = vec[2];
               String estado = vec[3];
               float notaFinal = Float.parseFloat(vec[4]);
               NotaCurso objNC = new NotaCurso (codCurso, carneEstudiante,carneDocente,estado,notaFinal);
               
               vecNC[i] = objNC;
               i++;
               cl--;  
            }
         buffer.close();   
        }
        catch(Exception objException)
        {
         objException.getMessage();          
        }
        return vecNC;
    }
  public String abrirModoLectura(String ruta)
    {
        String mensaje = "El archivo esta en  **Modo lectura**";
        try{
            archivo = new File(ruta);
            lectura = new FileReader(archivo);
            buffer  = new BufferedReader(lectura);
        }
        catch(Exception objException)
         {
            mensaje = objException.getMessage();          
         }
         return mensaje;
    }
    
  public Curso[] leerCurso()
    {
        int cl = contadorLineas("DatosEstudiante.txt");
        Curso vecC[];
        vecC = new Curso[cl];
        String registro;
        String vec[];
        vec = new String[6];
       try
        {
           int i = 0;
            while(cl>0)
            {
              registro = buffer.readLine();
              String separador = Pattern.quote("|");
              vec = registro.split(separador);
               String codCurso = vec[0];
               String nombre = vec[1];
               int creditos = Integer.parseInt(vec[3]);
               Curso objC = new Curso(nombre,codCurso,creditos);
               vecC[i] = objC;
               i++;
               cl--;  
            }
         buffer.close();   
        }
        catch(Exception objException)
        {
         objException.getMessage();          
        }
        return vecC;
    }  
  public String cerrarModoLectura()
    {
        String mensaje="¡El archivo en Modo lectura se cierra";
        try
        {
         lectura.close();
        // buffer.close();
        }
        catch(Exception objException)
         {
            mensaje = objException.getMessage();          
         }
        return mensaje;
    }
        
    public String abrirModoEscritura(String ruta)
    {
        String mensaje="¡El archivo se abrirá de Modo escritura!";
        try{
            archivo = new File(ruta);
            escritura= new FileWriter(archivo,true);
            impresion = new PrintWriter(escritura);
        }
        catch(Exception objException)
        {
         mensaje = objException.getMessage();          
        }
        System.out.println("mensaje método abrirModoEscritura: "+mensaje);
        return mensaje;
    }
    
    public String cerrarModoEscritura()
    {
        String mensaje="¡El archivo en **Modo escritura** se cierra!";
        try
         {
          impresion.close();
          buffer.close();
         }
        catch(Exception objException)
        {
          mensaje = objException.getMessage();          
        }
        return mensaje;
    }

    public boolean eliminaArchivo(String ruta)
    {
       System.out.println("cual es el valor de Ruta:"+ruta);
       try
       { 
         archivo = new File(ruta);
         if(archivo.exists())
          {
           //impresion.close();
           //lectura.close();
           System.out.println("****Archivo Eliminado****");
           System.out.println("****: "+archivo.getAbsolutePath());
           archivo.delete();
           archivo.deleteOnExit();
           return true;
          }  
          else 
           {
            return false;
           }
       }catch(Exception e)
        { 
            System.out.println("ERROR: " + e.getMessage());
             return false;
        }
}
          
   public int contadorLineas(String arch)
    {
      int numLineas=0;
      
      try
      {
       archivo = new File(arch);
       if(archivo.isFile()== false)
       {
         return 0;  
       }
       else
        {
       lectura = new FileReader(arch);
       BufferedReader br = new BufferedReader(lectura);
       
        while (br.readLine()!=null) 
          {
            numLineas++;
          }
        br.close();
        return numLineas;
       }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return numLineas;
    }
     
   
   public void renombrarArchivo( String nuevoNombre)
    {
      try
      {
        String nombreActual = "DatosEstudiante.txt";
        File oldfile = new File(nombreActual);
        File newfile = new File(nuevoNombre);
         if (oldfile.renameTo(newfile)) 
        {
            System.out.println("El archivo fue renombrado");
        } else {
            System.out.println("no se puede renombrar el archivo");
        }
        //newfile.renameTo(oldfile);
        
      }catch(Exception e)
       {
        System.out.println("***Archivo leído y cerrado correctamente*****"); 
       }
    }
}
