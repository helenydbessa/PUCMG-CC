/**
 * Estudo Dirigido 0054
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version 54
*/

import IO.*;

public class Exemplo0054
{
   public static void metodo09( )
   {
      int x, z;
      double y;
      
      x = IO.readint( "Quantos n�meros voc� que escrever: " );
      while( x > 0 )
      {
         y = IO.readdouble( "Digite um n�mero: " );
         
         if ( y >= 0 && y < 100 )
         {
            z = (int)y;
            
            IO.println( "Z = " + z );
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo09( );
   }
}