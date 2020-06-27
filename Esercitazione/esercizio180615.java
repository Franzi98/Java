
/**
 * Aggiungi qui una descrizione della classe esercizio180615
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class esercizio180615
{
   public static long q( int i, int j, boolean b ) { // i, j >= 0
 if ( b ) {
 if ( i*j == 0 ) {
 return i + j + 1;
 } else {
 return q( i-1, j, b ) + q( i, j-1, b ) + q( i, j, !b );
 }
 } else {
 if ( i*j == 0 ) {
 return 1;
 } else {
 return q( i-1, j, b ) + q( i, j-1, b );
 }}
 }
 
 public static long qBottomUp(int i, int j, boolean b){
    long[][][] h = new long[i+1][j+1][2];
    
    for(int x = 0; x<=i; x++){
     for(int y = 0; y<=j; y++){
        for(int z = 0; z<=1; z++){
          if(z==1){
             if(x*y == 0){
                h[x][y][1] = i + j + 1;
                } else {
                 h[x][y][1] = h[i-1][j][1] + h[i][j-1][1] + h[i][j][0];
                } 
            } else {
                if(x*y == 0){
                  h[x][y][z] = 1;
                } else {
                 h[x][y][1] = h[x-1][y][1] + h[x][y-1][1];
                }
             }
         }
        }
    }
    return h[i][j][b?1:0];
    }
 
}
