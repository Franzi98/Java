
/**
 * Aggiungi qui una descrizione della classe esercezio130616
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class esercezio130616
{
public static double averageCodeLength( Node root ) {

  int ws = 0;

  Stack<Node> stack = new Stack<Node>();
  Stack<Integer> depth = new Stack<Integer>();

  stack.push( root ); // push inserisce un elemento nello stack 
  depth.push( 0 );

  do {
   Node n = stack.pop(); //pop prende il primo elemento dello stack
   int d = depth.pop(); 

  if ( n.isLeaf() ) {

  ws = ws + d * n.weight(); //fa la somma dei pesi dei nodi 

  } else {
      stack.push(n.right());
      depth.push(d+1);
      stack.push(n.left());
      depth.push(d+1);
 
  }
  } while (!stack.empty()  );

  return ( (double) ws ) / root.weight();
 }}
