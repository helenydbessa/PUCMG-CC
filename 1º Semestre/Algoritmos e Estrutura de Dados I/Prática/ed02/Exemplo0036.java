/**
 * Estudo Dirigido 0036
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 *
 *@version 0036
*/

import IO.*;

public class Exemplo0036
{
   public static void main( String [] args )
   {
      int x, y, z;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readint( "Digite o primeiro n�mero: " );
         z = IO.readint( "Digite o segundo n�mero: " );
            
         if(z > 0 && z > y )
         {
            IO.println( "y: "+ y );
            IO.println( "z: "+ z );
         }
            
         x = x - 1;
      }
   }
}