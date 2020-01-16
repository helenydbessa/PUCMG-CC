/**
 * Guia 0042
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 28/02/2016
 *
 *@version 0042
*/

/**
 * Guia0041
 *
 * @author
 * @version 01
 */
//
// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;
import IO.*;
/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0042 extends Robot
{
/**
 * construtor padrao da classe Guia00.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0042( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0042( )
/**
 * metodo para criar configuracoes do ambiente.
 * @param nome do arquivo onde guardar a configuracao
 */
   public static void createWorld( String nome )
   {
   // o executor deste metodo (World - agente)
   // ja' foi definido na classe original (Robot)
      World.reset( ); // limpar configuracoes
   // para nao exibir os passos de criacao do ambiente
      World.setTrace( false ); // (opcional)
   // para criar obstaculos
   // Guia0-001.txt
      World.placeNSWall( 1, 1, 1 ); // espelho do degrau 1
      World.placeEWWall( 2, 1, 1 ); // patamar do degrau 1
      World.placeNSWall( 2, 2, 1 ); // espelho do degrau 2
      World.placeEWWall( 3, 2, 1 ); // patamar do degrau 2
      World.placeNSWall( 3, 3, 1 ); // espelho do degrau 3
      World.placeEWWall( 4, 3, 1 ); // patamar do degrau 4
      World.placeNSWall( 4, 1, 3 ); // apoio da escada 'a direita
   // para colocar marcadores
      World.placeBeepers( 4, 4, 1 );// marcador no topo da escada
   // para guardar em arquivo
      World.saveWorld( nome ); // gravar configuracao
   } // end createWorld( )
/**
 * metodo para virar 'a direita.
 */
   public void turnRight( )
   {
   // o executor deste metodo
   // deve virar tres vezes 'a esquerda
      turnLeft( );
      turnLeft( );
      turnLeft( );
   } // end turnRight( )

/**
 * metodo para contar comandos de arquivo.
 *@return quantidade de comandos
 *@param filename - nome do arquivo
 */
   public int countCommands( String filename )
   {
   // definir dados
      int length;
      FILE archive = new FILE ( FILE.INPUT, filename );
      String line;
   // repetir enquanto houver dados
      length = 0;
      line = archive.readln ( );
      while ( ! archive.eof( ) )
      {
      // contar mais um comando
         length = length + 1;
      // tentar ler a proxima linha
         line = archive.readln( );
      } // end while
   // fechar o arquivo
      archive.close( );
   // retornar a quantidade de comandos guardados
      return length;
   } // end countCommands( )    
 
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente com escada
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0042.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 6 ); // escolher velocidade
      World.readWorld( "Guia0042.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0042 JK = new Guia0042( 1, 1, World.EAST, 0 );
   // definir dado local
      int n; // para a quantidade de comandos
   // executar acoes
   // obter a quantidade de comandos e guardar
      n = JK.countCommands( "Tarefa0001.txt" );
   // informar a quantidade de comandos guardada
      IO.println ( "File Tarefa0001.txt has " +
         "" + n + " commands." );      
   } // end main( )
} // end class
// ---------------------------------------------- testes
/*
 Versao Teste
 0.1 01. ( ) - teste inicial
*/