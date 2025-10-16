
package fusanjose;
import java.util.Scanner;

public class Validacion 
{
    
 private static Scanner sc = new Scanner(System.in); 
  public static int leerEdadEstudiante(String mensaje)
  {
      System.out.println(mensaje);
      int edad;
      edad = sc.nextInt();
    do
   {

     if(edad<14 || edad>75)
     {
      System.out.println("la edad del estudiante debe estar entre los 14 y los 75 años");
      System.out.println("ingrese nuevamente la edad del docente: ");
      edad = sc.nextInt();
     }else{
         return edad;
     }
    }while(edad>=14 && edad<=75);
      //la edad debe estar entre los 14 años y los 75 años
   return edad;  
   
  }      
  public static String leerCarneEstudiante(String mensaje)
  {
    boolean sw =  true;
    String carne = " ";
    do
     {
      try
      {   
       System.out.println(mensaje);
       carne = sc.nextLine();
        if (carne == null || carne.length() != 7)
        {
          sw = false;
        }

        for (char c : carne.toCharArray()) 
         {
            if (!Character.isDigit(c)) 
            {
                sw = false;
            }
         }
       } 
      catch (Exception e) 
        {
          System.out.println("ERROR: " + e);
        }
    } while (sw==false);   
        return carne;
    // Carné de estudiante debe ser único y debe contar con 7 dígitos   
  }       
  public static String leerCarneDocente(String mensaje)
  {
   //* El carné de docente debe ser único y debe tener la siguiente estructura(DOCXXX) donde xxx representa números    
   String cadena = "";   
   boolean valido = true;
   do {
        System.out.println("Por favor, ingrese un código con el formato 'DOCxxx' (donde 'xxx' son 3 dígitos):");
           try 
            {
                cadena = sc.nextLine();
                if (cadena == null || cadena.length() != 6) 
                {
                  valido = false;
                }
                if (!cadena.substring(0, 3).equals("DOC")) 
                {
                  valido = false;
                }
                for (int i = 3; i < 6; i++) 
                 {
                   if (!Character.isDigit(cadena.charAt(i))) 
                   {
                    valido = false;
                   }
                 }  
                if (!valido) 
                {
                  System.out.println("Error: El formato de la cadena es incorrecto. Intente de nuevo.");
                }
            } 
           catch (Exception e) 
            {
             System.out.println("Ha ocurrido un error inesperado. Por favor, intente de nuevo.");
            }
      } while (!valido);

     return cadena;
  }      
    public static int leerEdadDocente(String mensaje)
  {
    int edad;
   edad = sc.nextInt();
   do
   {
     if(edad<24 || edad>75)
     {
      System.out.println("la edad del docente debe estar entre los 14 y los 75 años");
      System.out.println("ingrese nuevamente la edad del docente: ");
      edad = sc.nextInt();
     }  
    }while(edad>=24 && edad<=75);
   return edad;
  }      
  public static String leerTitulo(String mensaje)
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
          case 1:
            return "especialista";
          case 2:
            return "master";
          case 3:
             return "doctor";
          default:
              System.out.println("*** opcion no valida ***");
              t = 0;
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
   
 public static double leerNota(String mensaje)
  {
   double n;
   n = sc.nextInt();
   do
   {
     if(n<0 || n>5)
     {
      System.out.println("el valor de la nota debe estar entre 0 y 5");
      System.out.println("ingrese nuevamente la nota del estudiante: ");
      n = sc.nextInt();
     }  
    }while(n<0 && n>5);
   return n;   
    
  }

 public static String leerCadena(String mensaje)
   {
     String cadena = "";
        Scanner sc = new Scanner(System.in);
        do {
          try 
          {
            System.out.println(mensaje);
            cadena = sc.nextLine();
            if (cadena.equals("")) 
              {
               System.out.println("ERROR: debe ingresar informacion");
              }
          } 
          catch (Exception e) 
           {
                System.out.println("ERROR: " + e);
           }
        } while (cadena.equals(""));
        return cadena;
   }      
  
  public static int leerEntero(String mensaje)
  {
    while (true) 
    {
      try 
      {
         System.out.print(mensaje);
         return Integer.parseInt(sc.nextLine()); // ¡Clave aquí!
      } 
      catch (NumberFormatException e) 
      {
                System.out.println("Error: Ingrese un número válido.");
      }
    }
  
  } 
  
  public static double leerReal(String mensaje)
  {
   while (true) 
    {
      try 
      {
         System.out.println(mensaje);
         return Double.parseDouble(sc.nextLine());// ¡Clave aquí!
      } 
      catch (NumberFormatException e) 
      {
        System.out.println("Error: Ingrese un número válido.");
      }
    }  

  }      
  
}
