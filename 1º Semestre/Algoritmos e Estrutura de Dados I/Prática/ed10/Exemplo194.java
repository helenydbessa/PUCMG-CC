/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 23/04/2016
 
   Exemplo0194
 
 *@version 01
*
*/

import IO.*;

class Arranjo
{
   public Object [ ] tabela;
   
   public Arranjo ( )
   {
      tabela = null;
   }
   
   public Arranjo ( int tamanho )
   {
      if( tamanho <= 0 )
      {
         IO.println( "ERROR! Quantidade inv�lida!" );
      }
      else
      {
         tabela = new Object [ tamanho ];
      }
   }
   
   public int length ( )
   {
      int tamanho = 0;
      
      if( tabela != null )
      {
         tamanho = tabela.length;
      }
      return( tamanho );
   }
   
   public void readIntArranjo ( String msn, int onde, int n )
   {
      int posicao, tamanho = length( );
      String linha;
      
      if( tamanho <= 0 || n <= 0 || n > tamanho )
      {
         IO.println( "ERROR! Quantidade inv�lidada!" );
      }
      else
      {
         if( onde < 0 )
         {
            IO.println( "ERRO: POsi��o inv�lida!" );
         }
         else
         {
            IO.println( msn );
            for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
            {
               if( posicao >= onde )
               {
                  linha = IO.readln( );
                  
                  tabela [ posicao ] = IO.getint ( linha );
               }
            }
         }
      }
   }
   
   public void printIntArranjo ( int quant )
   {
      int posicao, tamanho = length( );
      
      if( tabela == null || tamanho <= 0 )
      {
         IO.println( "ERROR: Tabela vazio ou quantidade inv�lida!" );
      }
      else
      {
         for( posicao = quant; posicao < tamanho; posicao = posicao + 1 )
         {
            IO.println( ""+( int )tabela[ posicao ] );
         }
      }
   }
   
   public void lerArquivo ( String nome )
   {
      FILE arquivo = new FILE( FILE.INPUT, nome );
      int posicao, tamanho;
      String linha;
      Arranjo novo = null;
      
      linha = arquivo.readln( );
      
      if( linha == null )
      {
         IO.println( "ERROR: N�o cont�m dados o arquivo!" );
      }
      else
      {
         tamanho = IO.getint( linha );
         
         if( tamanho <= 0 )
         {
            IO.println( "ERROR: Tamanho inv�lido!" );
         }
         else
         {
            novo = new Arranjo( tamanho );
            
            IO.println( "Lendo arquivo: " );
                        
            for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
            {
               linha = arquivo.readln( );
               
               IO.println( "Posicao"+posicao+": "+linha );
               
               novo.tabela[ posicao ] = IO.getint( linha );
            }
         }
      }
      arquivo.close( );
   }
   
   public void gravaArquivo( String nome )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, nome );
      int posicao, tamanho = length( );
      
      if( tabela == null || tamanho <= 0 )
      {
         IO.println( "ERROR: Tabela vazio ou quantidade inv�lida!" );
      }
      else
      {
         arquivo.println( ""+tamanho );
         
         for( posicao = 0; posicao < tamanho; posicao = posicao + 1  )
         {
            IO.println( ""+tabela[ posicao ] );
            arquivo.println( ""+tabela[ posicao ] );
         }
      }
      arquivo.close( ); 
   }
}

public class Exemplo194
{
   public static int tamanhoArquivo( String nome )
   {
      int tamanho = 0;
      FILE arquivo = new FILE( FILE.INPUT, nome );
      String linha;
      
      linha = arquivo.readln( );
      
      if( linha == null )
      {
         IO.println( "ERROR: N�o cont�m dados o arquivo!" );
      }
      else
      {
         tamanho = IO.getint( linha );
      }
      arquivo.close( );
      
      return( tamanho );
   }
   
   public static void principal( )
   {
      Arranjo teste = null;
      String nome, nome1;
      
      IO.println( "Lendo arquivo e gravando no arranjo!"+"\n" );
      
      nome = IO.readString( "Digite o nome do arquivo: " );
      
      teste = new Arranjo( tamanhoArquivo( nome ));
      
      teste.lerArquivo( nome ); 
      
      IO.println( "Gravando dados do arranjo no arquivo!"+"\n" );
      
      nome1 = IO.readString( "Digite o nome do arquivo: " );
      
      teste.gravaArquivo( nome1 );         
   }
   
   public static void main( String [ ] args )
   {
      principal( );
   }
}