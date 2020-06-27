/* In questo esercizio creeremo dei tipi di dati che su java non esistono
 * ma usavamo in scheme tipo le liste.
 * creeremo
 * intSList il = new intSList() // null , il new crea il nuovo oggetto
 * "il" sta per lista di interi ,
 * il.isNull() : boolean  //null?,
 * il.car() : int         //car,
 * il.cdr() : intSList    //cdr,
 * il.cons() :intSList    //cons
 * il.length(): int
 * il.restRef(i): int
 * il.equals(cl): boolean
 * il.append(cl): IntSList
 * il.reverse() : IntSList
 * intSList il= new intSList();
 * il.isNull()---> true
 * oppure:
 * intSList il = new intSList();
 * il = il.cons(5);
 * il.isNull()--> false
 * il --> (5)
 * il = il.cons(4)
 * il --> (4 5)
 *
 */
//S sta per scheme, list sta per lista e int perchè è una lista di interi
  public class IntSList {
  public static final IntSList NULL_INTLIST = new IntSList(); //crea un oggetto IntSList() e lo chiamo NULL_INTLIST 
  private final boolean empty; // lista vuota : true/false
  private final int first;     //primo elemento della lista
  private final IntSList rest; //resto della lista
 
  public IntSList() {
  empty = true;
  first = 0; //car
  rest = null; //cdr di scheme
  }   // come si definisce un COSTRUTTORE
  public IntSList(int f, IntSList r) { //due volte la stessa funzione: overload. f è il primo elemento, r è il cdr
  empty = false;
  first = f;
  rest = r;
  } //serve per il cons, ha 2 variabili: car, cdr
  public boolean isNull() {
  return empty;
  }
  public int car() {
  return first;
  }
  public IntSList cdr() {
  return rest;
  }
  public IntSList cons(int n) {
  return ( new IntSList(n, this) ); //this fa riferimento a IntSList creato 
  }
  
  public int length() {
      if (this.isNull() ){ //this può essere omesso
        return 0;
    } else {
      return (this.cdr().length() + 1);
    }
    
    
    }//length
  public int listRef(int i){ //ricorsivo
      if (i == 0){
          return car();
        }else {
         return (cdr().listRef(i-1) );
        }
      
    }//listRef
    
  public boolean equals(IntSList cl){
      if (isNull()) {
        return (cl.isNull() );
        }else if (cl.isNull()){ 
        return false;
        }else if (car() == cl.car() ){
         return (cdr().equals(cl.cdr()));
        }else {
         return false;
        }
    }//equals
  public IntSList append (IntSList ql){
      if (isNull() ){
        return ql;
        }else {
        return ((cdr().append(ql)).cons(car()) );
        }
      
    }
  public IntSList reverse() {
    return reverseRec(NULL_INTLIST);
    }
  private IntSList reverseRec(IntSList rl){ //private: non si può usare all'esterno della classe
      if (isNull() ) {
        return rl;
        }else{
        return cdr().reverseRec(rl.cons(car()));
        }
    }
  
  
  
  public String toString() { //metodo per trasformare in testo il contenuto dell'oggetto
   if ( empty ) {
      return "()";
    } else if ( rest.isNull() ) {
      return "(" + first + ")";
    } else {
      String rep = "(" + first;
      IntSList r = rest;
      while ( !r.isNull() ) {
        rep = rep + ", " + r.car();
        r = r.cdr();
      }
      return ( rep + ")" );
    }
  }
  } //class intSList