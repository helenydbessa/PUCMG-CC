/**
 * Estudo Dirigido 11
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 14/02/2016
 *
 *@version 11
*/

import IO.*;

public class Exemplo0011
{
   public static void main (String[] args)
   {
      String x;
      int y;
      double z;
      
      y = IO.readint("Digite um n�mero: ");
      z = IO.readdouble("Digite um n�mero: ");
      
      x = ""+(y+z);
      
      IO.println ( "x = " + x );
      
      IO.println ( "y = " + y );
      
      IO.println ( "y = " + z );
   }
}
