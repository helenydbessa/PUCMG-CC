/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 27/03/2016
 
 *@version E2
*/

import IO.*;

public class ExemploE2
{
   public static void main( String [] args )
   {
      int x;
      double y, z;
      int a, b;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readdouble( "Digite o primeiro n�mero: " );
         z = IO.readdouble( "Digite o segundo n�mero: " );
         
         a = (int)y;
         b = (int)z;    
         
         if( !( y <= 25 && y >= -25 ) && !( z <= 25 && z >= -25 ) )
         {
            if( y != z && y < z && !( a % 2 == 0 ) && !( b % 2 == 0 ))
            {
               IO.println( "y: "+ y );
               IO.println( "z: "+ z );
            }
         }
            
         x = x - 1;
      }
   }
}