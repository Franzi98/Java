
/**
 * Aggiungi qui una descrizione della classe esame130617
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class esame130617
{
    
    /*Il seguente programma è una traduzione in Java del codice Scheme riportato all’inizio dell’esercizio 2, dove le liste
sono realizzate applicando la classe IntList il cui protocollo è specificato nell’esercizio 3: */
 public static IntSList lis( IntSList s ) {
 return lisRec( s, 0 );
 }

 private static IntSList lisRec( IntSList s, int t ) {
  if ( s.isNull() ) {
  return new IntSList();
  } else if ( s.car() <= t ) {
  return lisRec( s.cdr(), t );
  } else {
  return longer( new IntSList( s.car(), lisRec( s.cdr(), s.car() ) ),
  lisRec( s.cdr(), t )
  );
  }
 }

 private static IntSList longer( IntSList u, IntSList v ) {
  if ( u.length() < v.length() ) {
  return v;
  } else {
  return u;
  }
 }
 
 private static final IntSList UNKNOWN = null;
 
 public static IntSList lisMem(IntSList s){
    int n = s.length();
    IntSList[][] h = new IntSList[n+1][n+1];
    for(int i = 0; i<=n; i++){
      for(int j = 0; j<=n; j++){
         h[i][j] = UNKNOWN; 
        }
     }
     return lis2Rec(s,0,h);
    }
 private static IntSList lis2Rec(IntSList s, int t, IntSList[][] h){
     int k = s.length();
     
     if(h[k][k] == UNKNOWN){
        if(s.isNull()){
         h[k][k] = new IntSList();
         } else if (s.car() <= t){
              h[k][k] = lis2Rec(s.cdr(), t ,h);
             } else{
                  h[k][k] = longer( new IntSList( s.car(), lisRec( s.cdr(), s.car() ) ), lisRec( s.cdr(), t ));
                 }
           
       }
       return h[k][k];
    }
 /*private static IntSList longerRec( IntSList u, IntSList v ) {
     if ( u.length() < v.length() ) {
     return v;
     } else {
     return u;
     }   
 }*/
 public static void main(String[] args){
     IntSList sesso = new IntSList();
     sesso = sesso.cons(4).cons(5).cons(1);
     System.out.println(lisMem(sesso));
    }
}
 
/*Applica la tecnica top-down di memoization per realizzare una versione più efficiente del programma. A tal fine, assumi
che le sequenze passate come argomento al metodo statico lis soddisfino sempre questa proprietà: una sequenza s di
lunghezza k è costituita da una permutazione degli interi 1, 2, …, k. (Tale proprietà limita l’intervallo di valori che
possono essere assunti dal parametro t del metodo ricorsivo.)*/



