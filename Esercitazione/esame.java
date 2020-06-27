
/**
 * Aggiungi qui una descrizione della classe esame
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class esame
{
 public static String[] diff( String u, String v ) {

 if ( u.equals("") || v.equals("") ) {

 return new String[] { u, v };

 } else if ( u.charAt(0) == v.charAt(0) ) {

 return diff( u.substring(1), v.substring(1) );

 } else {

 String[] x = diff( u.substring(1), v );
 String[] y = diff( u, v.substring(1) );

 if ( x[0].length() < y[0].length() ) {
 return new String[] { u.charAt(0)+x[0], x[1] };
 } else {
 return new String[] { y[0], v.charAt(0)+y[1] };
 }}
 }
 public static String[] diffmem(String u, String v){
     String[][] h = new String[u.length() + 1] [v.length() + 1];
     for (int i=0; i<=u.length() + 1; i++){
        for ( int j=0; j<=v.length() + 1; j++ ){
          h[i][j] = null;
         }
        }
        return diffRec(u,v,h);
    }
 private static String[] diffRec(String u,String v, String[][] h){
     int i = u.length();
     int j = v.length();
     if(h[i][j]==""){
        if(u.equals("") || v.equals("")){
          h[i][j] = null;
         }
        } else if ( u.charAt(0) == v.charAt(0) ){
           h[i][j] = diffRec( u.substring(1), v.substring(1), h ); 
         }
       }   
}
