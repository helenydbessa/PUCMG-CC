/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 14/02/2016
 *
 *@version E2
*/

import IO.*;

public class E2
{
   public static void main (String[] args)
   {
      char x;
      int y;
      
      y = IO.readint("Entre com uma sequ�ncia de digitos: ");
      
      if ( y >= 32 && y <= 126)
      {
      
         x = (char)y;
      
         IO.println ( "x = " + x );
      
         IO.println ( "y = " + y );
      }
   }
}