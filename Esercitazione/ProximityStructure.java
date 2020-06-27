import java.util.Vector;
/**
Un’istanza della classe ProximityStructure consente di modellare una collezione di misure, rappresentate da valori
di tipo double, manipolabile attraverso il seguente protocollo:
 new ProximityStructure() // costruisce una collezione vuota di misure
 s.size() // restituisce il numero di misure contenute nella collezione
 s.add( x ) // aggiunge la misura x alla collezione s
 s.removeClosestTo( x ) // rimuove da s e restituisce la misura più prossima a x
// (la cui distanza da x è più piccola) in s
Completa la defnizione della classe ProximityStructure introducendo opportune variabili d’istanza
(rappresentazione interna) e realizzando il costruttore e i metodi coerentemente con le scelte implementative fatte.
 */
public class ProximityStructure{
    private Vector<Double> collezione;
    public ProximityStructure(){
        collezione=new Vector<Double>();
    }
    
    public int size(){
        return collezione.size();
    }
    
    public void add(double x){
        
        collezione.add(x); //aggiunge x in coda.
    }
    
    public double removeClosetTo(double x){
        int n=collezione.size();
        double y = collezione.get(0); //mi restituiesce l'elemento alla pos 0
        int k=0;
        for (int i=1; i<n; i++){ 
          double z=collezione.get(i);
            if( Math.abs(z-x) < (Math.abs(y-z) )){
               y=z;
               k=i;
             } //al termine del ciclo for ho trovato l'elemento + vicino a x
        }
        collezione.removeElementAt(k);
        return y;
    }

}
