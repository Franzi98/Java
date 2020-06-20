import java.util.Random;


public class Rompicapodel15
{
 private static final String ROWS = " 123456789ABCDEF ";
 private static final String COLS = " abcdefghijklmno ";   
 private final int size;
 private static int n_tasselli;
 private static int[][] tasselli;
 private static String config;
 private int[] row;
 private int[] col;
 public Rompicapodel15(int n){
     size=n;
     n_tasselli=n*n - 1;
     config = "";
     tasselli = creaTasselli(n);
     row = new int[n];
     col = new int[n];
     
    }
 private int[][] creaTasselli(int k){
     int[][] v = new int[k][k];
     Random random = new Random();
     int r = random.nextInt(k*k-1);
     for(int i=0; i<k; i++){
        for(int j=0; j<k; j++){
          v[i][j] = r;
          config = config + "," + COLS.substring(j,j+1) + "," + ROWS.substring(i,i+1) + " = " + v[i][j]; 
          
         }
        }
        return v;
    }
 public int getNum(int i, int j){
     return tasselli[i-1][j-1];
    }
 public int size(){
     return size;
    }
 public String arrangement(){
     return config;
    }   
 public String toString(){
    return config;
    }


}
