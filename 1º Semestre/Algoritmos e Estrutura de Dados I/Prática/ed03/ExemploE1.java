/**
 * Estudo Dirigido E1
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version E1
*/

import IO.*;

public class ExemploE1
{
   public static void metodo16( )
   {
      String y;
      int quant;
      char a;
      int j;
      
         y = IO.readString( "Digite uma cadeia de caracter: " );
         
         quant = y.length( );
         
         for( j = 0; j < quant; j = j + 1 )
         {
            a = y.charAt( j );
            
            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'))
            {  
               IO.println( "Letra: " + a );
            }
            else
            {
               IO.println( "Algarismo: " + a );
            }
         }
   }
   
   public static void main ( String [] args )
   {
      metodo16( );
   }
}