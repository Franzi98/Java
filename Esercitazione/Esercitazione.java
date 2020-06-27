import java.lang.*;
import java.util.*;

public class Esercitazione
{
 private static final String[] UNKNOWN = null;
 
  public static String[] diff(String u, String v){ //vuole un array in output
      if(u.equals("") || v.equals("")){
         return new String[] {u,v};
        } else if (u.charAt(0) == v.charAt(0)){
           return diff(u.substring(1), v.substring(1));
         } else {
            String[] x = diff(u.substring(1),v);
            String[] y = diff(u,v.substring(1));
            if(x[0].length()<y[0].length()){
            return new String[] {y[0],v.charAt(0)+y[1]};
            }
            }
      return diff(u,v);       
    }
    
 public static String[] diffMem(String u, String v){
     int m = u.length();
     int n = v.length();
     String[][][] h = new String[m+1][n+1][];
     for (int i=0; i<=m; i++){
        for(int j=0; j<=n; i++){
          h[i][j] = null;
         } 
        }
     return diffRec(u,v,h);
    }
    
 public static String[] diffRec(String u, String v, String[][][] h){ //h=matrice di array di stringhe
    int i = u.length();
    int j = v.length();
    if(h[i][j] == null){
    if (u.equals("") || v.equals("")){
         h[i][j] = new String[] { u, v};
     } else if (u.charAt(0) == v.charAt(0) ){
        h[i][j] = diffRec(u.substring(1),v.substring(1),h);
        } else {
            String[] x = diffRec(u.substring(1),v, h);
            String[] y = diffRec(u,v.substring(1),h);
            if(x[0].length()<y[0].length()){
            h[i][j] = new String[] {y[0],v.charAt(0)+y[1]};
            } 
         }
    
    }
    return diffRec(u,v,h);
 }
 
 public static long st(int n, int k){
    long[] cn = new long[] {0};
    sRec(1,n,k,cn);
    return cn[0];
    }
 private static void sRec(int p, int n, int k, long[] cn){
    if( (k==1) || (k==n) ){
      cn[0] = cn[0] + p;
     } else {
         sRec(p,n-1,k-1, cn);
         sRec(k*p, n-1, k, cn);
        }
    }
 
 
 public static long stIter(int n, int k){
    long[] cn = new long[] {0}; //contatore 
    Stack<int[]> stack = new Stack<int[]>(); //lo stack rappresenta l'informazione sui parametri della ricorsione
    
    
    int[] f = new int[] {n,k,1}; //uso i parametri di sRec eccetto l'array
    stack.push(f);
    
    while(!stack.empty()){ // si va avanti finchè lo stack non è vuoto. Elementi nello stack indicano che il programma andrà avanti
     f = stack.pop(); //elimino un elemento dallo stack
     if((f[1] == 1) || (f[1] == f[0])) {
        cn[0] = cn[0] + f[0];
        } else {
          stack.push(new int[] {f[0]-1, f[1]-1, f[2]  }); 
          stack.push(new int[] { f[0]-1, f[1], f[1]*f[2] })  ;
         }
     }
     return cn[0];
    }
    
 public static long f(int x, int y){
     if((x<2) || (y<2)){
         return x*y;
        } else{
         return f(x,y-1) + f(x-2,y) + f(x-1, y+1); }
        }
 public static long fDP(int x, int y){
     long[][] h = new long[x+1][y+1];
     
     for(int i=0; i<=x; i++){
        for(int j=0; j<=y; j++){
          if((x<2) || (y<2)){
             h[i][j] = x*y;
             } else{
                 h[i][j] = h[i][j-1] + h[x-2][y] + h[x-1][y+1];
                }
         }
        }
        return h[x][y];
    }
    
 public static int p(int x, int y){
    
     int[][] h = new int[x+1][y+1];
     for(int i = 0; i<=x; i++){
         for(int j = 0; j<=y; j++){
            h[i][j] = 0;
            }
        }
     return pMem(x,y,h);
    }
 public static int pMem(int x, int y, int[][] h){
     if((x==0) || (y==0)){
        return 1;
        } else if(x==1){
           h[x][y] = y;
         } else if(y==1){
             h[x][y] = x;
            } else{
              int u = (int) ( ( x - 1 ) * Math.random() ) + 1;
              int v = (int) ( ( x - 1 ) * Math.random() ) + 1;
              h[x][y] = pMem(u,v,h) + pMem(u,y-v,h) + pMem(x-u,v,h) + pMem(x-u,y-v,h);
             }
     return h[x][y];
    }   
}
