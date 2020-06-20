
/**
 * Aggiungi qui una descrizione della classe Soluzione_rompicapodel15
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Soluzione_rompicapodel15
{
    public static int[][] piastrelle(int n){
     return visualizza_piastrelle(new Rompicapodel15(n));
    }
    private static int[][] visualizza_piastrelle(Rompicapodel15 r){
        int n=r.size();
        int[][] v = new int[n][n];
        for(int i=0; i<n; i++){
          for (int j=0; j<n; j++){
              v[i][j] = r.getNum(i,j);
            }
         }
        return v;
        
        
    }
    
    /*public static String configurazione(int n){
     return config(new Rompicapodel15(n));
    }
    private static String config(Rompicapodel15 r){
     
    }*/
}
