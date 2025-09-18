package com.mycompany.universidad;

import java.util.Scanner;

public class Validacion {
    static Scanner  sc =   new Scanner(System.in);
    
    
        public static String  leerCarneEstudiante(Archivo arch,String mensaje){
            String codigo = "";
            boolean pasa = true;
            try{
                do{
                    System.out.print(mensaje);
                    codigo = sc.next();
                    if(codigo.length() !=7){
                        System.out.print("El codigo debe de tener 7 caracteres\n");
                        pasa = false;
                    }
                    if(BuscarEstudiante(arch,codigo)){
                         System.out.print("El codigo del estudiante ya existe\n");
                        pasa = false;
                    }
                
                }while(!pasa);  
        
            }catch(Exception e){
                System.out.print("Error: "+ e);
            }
                return codigo;
        }
        
        
        public static boolean BuscarEstudiante(Archivo objArch, String carneEstudiante) 
        { 
            boolean sw=false;
            String cod;
            try {
                Estudiante objE = new Estudiante();
                int tamaño = objArch.contadorLineas("DatosEstudiante.txt");
                objArch.abrirModoLectura("DatosEstudiante.txt");
                Estudiante vecE[] = new Estudiante[tamaño];
                vecE = objArch.leerEstudiante();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
                int i=0;
                int cantRegistros = objArch.contadorLineas("DatosEstudiante.txt");
                while (i<= cantRegistros) 
                {
                    objE = vecE[i];
                    cod = objE.getCarneEstudiante();
                    if(cod == null ? carneEstudiante == null : cod.equals(carneEstudiante))
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
            }
        
             public static int leerEntero(String mensaje) // me permite validar el idCliente 
	{
             Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if(num<=0)
                     System.out.println("ERROR, el Numero debe ser mayor que cero");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while(num<=0);
		return num;
	}
       
        public static int leerEdad(String mensaje)
        {
          Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if((num<14)||(num>=76))
                     System.out.println("ERROR, la edad debe estar entre 18 y 100");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while((num<18)||(num>100));
		return num;  
        }      
        
        public static String leerString(String mensaje)
	{
	  String cadena= "";
          Scanner sc = new Scanner (System.in);
          do
          {
	   try
	    {
              System.out.println(mensaje);
              cadena = sc.nextLine();
	       if(cadena.equals(""))
                  System.out.println("ERROR: debe ingresar informacion");
            }
	    catch (Exception e)
	      {
		System.out.println("ERROR: " + e);
	      }
           }while(cadena.equals(""));
	 return cadena;
	}
    


        public static float leerSalario(String titulo){

            if(titulo.equals("doctor")){
                return 500;
            }else if(titulo.equals("master")){
                return 350;
            }else{
                return 200;
            }

        
        }
    public static String leerTitulo()
     {
    int t;
     do
     {
      System.out.println(" seleccione el titulo del docente: ");
      System.out.println(" 1. Especialista");
      System.out.println(" 2. Master ");
      System.out.println(" 3. Doctor ");
      t = sc.nextInt();
      switch(t)
      {
          case 1 -> {
              return "especialista";
            }
          case 2 -> {
              return "master";
            }
          case 3 -> {
              return "doctor";
            }
          default -> {
              System.out.println("*** opcion no valida ***");
              t = 0;
            }
        }       
      }while(t==0);  
      return "";
  }   
   public static String leerCarneDocente(String mensaje)
  {
   //* El carné de docente debe ser único y debe tener la siguiente estructura(DOCXXX) donde xxx representa números    
      return "";
  } 
   
  public static String leerCarneEstudiante(String mensaje)
  {
      String codigo = "";
      boolean pasa;
      try{
          do{
              pasa = true;

              System.out.print(mensaje);
              codigo = sc.next();
              if(codigo.length() !=7){
                  System.out.print("El codigo debe de tener 7 caracteres\n");
                  pasa = false;
              }


          }while(!pasa);

      }catch(Exception e){
          System.out.print("Error: "+ e);
      }
      return codigo;

  }
  
  public static float leerNota(String mensaje){
      float nota = 0;
      boolean sw = true;
      System.out.print(mensaje);
      Scanner sc = new Scanner (System.in);
      do{
            nota = sc.nextFloat();
              if(nota>0&&nota<= 5){
                  sw = false;
                  return nota;
              }
          
      }while(sw);
      return 0;
  }
  
  
  public static String leerEstadoG(float nota){
      String estado = "Aprobo";
      if(nota<3){
          estado = "Reprobo";
      }
      return estado;
  }
  
  
  public static String actualizarEstado(float nota){
      String estado = "Aprobo";
      if(nota<3){
          estado = "Reprobo";
      }
      return estado;
  }
  
  public static String LeerEstadoActulizarEstado(float nota){
    int t;
    String estado = "Aprobo";
     do
     {
      System.out.println(" seleccione que formar vas actualizar el estado");
      System.out.println(" 1. Actualizar por la nota");
      System.out.println(" 2. Cancelo ");
      t = sc.nextInt();
      switch(t)
      {
          case 1 -> {
              if(nota<3){
                  estado = "Reprobo";
              }
              return estado;
            }
          case 2 -> {
              return "cancelado";
            }
          default -> {
              System.out.println("*** opcion no valida ***");
              t = 0;
            }
        }       
      }while(t==0);  
      return "";
  }
    public static int leerCreditos(String mensaje)
  {
   int c;
   c = sc.nextInt();
   do
   {
     if(c<2 || c>4)
     {
      System.out.println("el valor del credito debe estar entre 2 y 4");
      System.out.println("ingrese nuevamente el valor de creditos: ");
      c = sc.nextInt();
     }  
    }while(c>=2 && c<=4);
  return c;   
  }  
}
