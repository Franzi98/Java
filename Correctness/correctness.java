
public class correctness
{
public static int sqr(int n){ //quadrato di un numero n >= 0
 /**Precondizione: n>=0 **/
 
 int x=0;
 int y=0;
 int z=1;
 
 while (x<n) {  /**Inv: 0 <= x <= n; y=x^2; z = 2x + 1 **/
    x = x+1;    //term: n-x; funzione termina, calcola quanti cicli devo fare prima di finire il programma
    y = y+z;
    z = z+2;
    }
    return y;  /** Postcondizione: y = n^2 **/
 }
 /***
  * Invariante(x,y,z) studia le relazioni costanti fra le variabili
  * 
  * Per dimostrare che il programma è corretto devo dimostrare che l'invariante vale per ogni iterazione
  * 
  * 1 Iterazione:
  * Inv(0,0,1) : 0 <= 0 <= n; 0=0^2; z = 2*0 + 1
  * 
  * Conservazione dell'invariante (l'invariante continua a valere per ogni n?)
  * Assumo che Inv(x,y,z) & (x<n)
  * Dimostro che Inv(x',y',z') con x'=x+1, y'=y+z, z'=z+2;
  * 
  * Dato che Inv: 0 <= x <= n; y=x^2; z = 2x + 1
  * allora Inv(x+1,y+z,z+2) : 0<= x+1 <= n, y+z = (x+1)^2, z+2= 2(x+1)+1;
  *      verifico le relazioni
  *                         : 0<= x+1 ? VERO
  *                         : x+1 <= n ? VERO perchè lo è per ipotesi del while 
  *                         : y+z = (x+1)^2 = x^2 + 2x + 1 ? VERO perchè y=x^2, z=2x+1.
  *                         : z+2 = 2(x+1)+1 = 2x+1 + 2 ? VERO perchè z=2x+1;
  *                         
  * Risultato finale
  * Assumo: Inv(x,y,z) & (x >= n) Finisco il ciclo while, quindi la condizione x<n non è più vera
  * Dimostro: y=n^2
  *  
  *   Per l'invariante x<=n, ma dato che siamo fuori dal ciclo while x>=n quindi deve essere perforza x=n;
  *   x=n quindi  y=x^2 = n^2 
  *    
  *term(x,y,z) = n-x, dimostro che x<=n in modo che n-x >=0 ma x<=n è una della relazioni dell'invariante, quindi è già dimostrata
  *term(x+1, y+z, z+2) = n - (x+1) = n-x -1 < n-x = term(x,y,z) <--- Inv(x,y,z)
  ***/
 public static int lcm(int m,int n){ //m,n > 0;
     //miminimo comune multiplo di m e n (mcm)
     int x=m; 
     int y=n;
     
     while (x!=y){   /**Inv: 0<x, y<= mcm(m,n), x mod m = 0 (quindi x è multiplo di m); y mod n= 0 (quindi y è multiplo di n). Mod=resto */;
        if (x < y){  /**term: mcm(m,n)-x mcm(m,n)-y ---> 2mcm(m,n)-x-y.*/
         x = x+m;
        }else {
          y= y+n;
        }
        }
        return x; //x o y, è uguale!
    } //il valore restituito è il minimo comune multiplo di m e n.
     /**
  * Inv(x,y), con x=m, y=n;
  * 
  * Inv(m,n) : 0 < m,n <= mcm(m,n); m mod m=0, n mod n= 0
  *            Pre 0 <=m,n
  * 
  * Conservazione
  * Assumo che Inv(x,y) & (x!=Y)
  * 
  * Assumo (a) : Inv(x,y) & (x < y)
  * Dimostro: Inv(x+m,y)
  * 
  * Assumo (b) : Inv(x,y) & (x > y)
  * Dimostro: Inv(x,y+n)
  * 
  * a) Inv(x+m,y) : 0<x, y<= mcm(m,n), (x+m) mod m = 0; y mod n= 0.
  *    
  *    x<y<=mcm(m,n)--->x+m<=mcm(m,n) //
  *    
  *Risultato Finale:
  * Assumo Inv(x.y) & (x=y) perchè sono appena uscito dal while;
  * Dimostro: x = mcm(x,y);
  *           0<x = y <= mcm(m,n), x mod m = 0; y mod n= 0. con x=n, y=x^2, x mod m = 0, y mod n = 0;
  *    
  *Terminazione:    
  *term(x,y) = 2mcm(m,n)-x-y >= 0. x,y <= mcm(m,n);
  *term(x',y') = 2mcm(m,n)-x'-y' < 2mcm(m,n)-x-y. m,n > 0
  */
 
 public static int cube(int n){ //Pre: n>= 0
     int x=0;          
     int y=0;
     int u=1;
     int v=6;
     
     while (x<n){              /** Inv: 0<=x <= n, y=x^3,
                                  u=3x^2
                               */
         
        x=x+1;
        y=y+u;
        u=u+v;
        v=v+6;
        }
     return y;
}
 public static int[] fattorizzazione(int n){ /** Pre: n>= 2 */
    
     int[] fattori = new int[n+1]; 
     for(int i=0; i<=n; i++){
         fattori[i] = 0;
        }
     int x=n;
     int p=2; //sarebbe inutile dividere per un num<2
     while(x>1){         /**Inv: 1<= x <=n, n = x * n (n=tutto ciò che è già stato fattorizzato)   */
       if(x % p == 0){ //se il resto della divisione x/p = 0, quindi se x è divisibile per p
        fattori[p] = fattori[p] +1;
        x= x / p;  //usando x al posto di n, so quante volte posso fattorizzare
        } else {
         p = p + 1;
        }
    }
    return fattori;     /** Post: n=Prodotto di tutti i k^fattori[k] con k[2,n] */
 }
 /**
  * Inv( {0,0...,0}, n 2) : Inv: 1<= n <=n, n = n * Prod(k:[2,n]) k^0 = n*1
  * 
  * (a) p divide x 
  *     Inv: 1<= x/p <=n,
  *     n = x/p * Prod(k:[2,p-1]) k^fattori[k] * p^(fattori[p+1]) * Prod(k:[p+1,n]) k^fattori[k]
  */
}
