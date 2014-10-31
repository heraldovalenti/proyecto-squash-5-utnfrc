/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Matias
 */
public class CalculosTorneo {
    static Jugador jugadores[];
    static int cantRondas;
    Ronda rondas[] ;        
    static TreeSet <Partido> tree=new TreeSet();
    static Partido partidosPrimeraRonda[];
    static int rondasFixture[][];
    static int duracionRonda[];
    static Club clubes;
    static double diasRonda[]; 
    
    public static void clear() {
    	jugadores = null;
    	cantRondas = 0;
    	tree = new TreeSet();
    	partidosPrimeraRonda = null;
    	rondasFixture = null;
    	duracionRonda = null;
    	clubes = null;
    	diasRonda = null;
    }
    
    public static TreeSet<Partido> generarPrimeraRonda(Jugador[] jugadores) {
    	clear();
    	cargarJugadores(jugadores);
        calcularRondas();
        ordenarJugadores();
        generarJugadoresVacios();
        cruzarJugadores();
        cargarRondasFixture();
        generarSembrado();
        return tree;
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el numero de jugadores: ");
        int n = sc.nextInt();
        cargarJugadores(n);        
        calcularRondas();
        ordenarJugadores();
        generarJugadoresVacios();
        cruzarJugadores();
        cargarRondasFixture();
        generarSembrado();
    }
    
    private static void generarSembrado()
    {
        int maxJugPriRonda= (int)Math.pow(2, cantRondas);
        int cantPart=maxJugPriRonda/2;
        String s="";
        for (int i=0;i<cantPart;i++)
        {
            s+="\n Partido "+(i+1)+" : ";
            int arreglo[]=new int [cantRondas-1] ;
            int c=0;
            for (int j=rondasFixture.length-1;j>-1;j--)
            {
                arreglo[c]=rondasFixture[j][i];
                c++;
            }
            int orden=binarioADecimal(arreglo);
            s+=" "+orden;
            partidosPrimeraRonda[orden-1].setOrdenLLave(i);
            
        }     
        
        for(int i=0;i<partidosPrimeraRonda.length;i++){            
            tree.add(partidosPrimeraRonda[i]);
        }
        
        //for( Iterator it = tree.iterator(); it.hasNext();) {
        //    Partido p = (Partido)it.next();
        //    s+="\n "+(p);
        //}
        
        //System.out.print(s+"\n");
    }
    
    private static int binarioADecimal(int arreglo[])
    {   
        int decimal=1;
        for(int i=0;i<arreglo.length;i++)
        {
            decimal+= arreglo[arreglo.length-i-1]*(int)Math.pow(2, i);
        }
        return decimal;
    }
    
    public CalculosTorneo(){
        
    }
    
    public void iniciarClub(){
            clubes= new Club();
    }
    
    /*
     * Carga Jugadores con su posicion
     */
    private static void cargarJugadores(int n){
        Scanner sc = new Scanner(System.in);
        jugadores= new Jugador[n];
        for (int i=0;i<n;i++){
            System.out.print("Introduzca la posicion del ranking del jugador "+ i+": ");
            int pos = sc.nextInt();
            boolean var=false;
            if(pos==0)
            {
                pos=(int)(Math.random()*100)+n;
                var=true;
            }
            jugadores[i] = new Jugador();
            jugadores[i].setPos(pos);
            jugadores[i].setUnranked(var);
        }            
    }
    
    private static void cargarJugadores(Jugador[] n){
    	jugadores = new Jugador[n.length];
        for (int i=0;i<n.length;i++){
            
            int pos = n[i].getPos();
            boolean var=false;
            if(pos==0)
            {
                pos=(int)(Math.random()*100)+n.length;
                var=true;
            }
            jugadores[i] = new Jugador();
            jugadores[i].setId(n[i].getId());
            jugadores[i].setPos(pos);
            jugadores[i].setUnranked(var);
        }            
    }
    
    /*
     * Ordena Jugadores con su posicion
     */
    private static void ordenarJugadores(){
        Jugador aux; 
        for (int i = 0; i < jugadores.length - 1; i++) {
            for (int x = i + 1; x < jugadores.length; x++) {
                if (jugadores[x].getPos() < jugadores[i].getPos()) {
                    aux = jugadores[i];
                    jugadores[i] = jugadores[x];
                    jugadores[x] = aux;
                }
            }
        }         
    }
    
    /*
     * Rellena con Jugadores vacios
     */
    private static void generarJugadoresVacios(){ 
        Jugador jugadoresDestino[];
        int maxJugPriRonda= (int)Math.pow(2, cantRondas);
        jugadoresDestino=new Jugador[maxJugPriRonda];
        int maxPos=0;
        for (int i=0;i<jugadores.length;i++)
        {
            jugadoresDestino[i] = jugadores[i];
            if(jugadores[i].getPos()>=maxPos){
                maxPos=jugadores[i].getPos()+2;
            }
        }
        
        for (int i=jugadores.length;i<jugadoresDestino.length;i++)
        {
            
            jugadoresDestino[i]=new Jugador(maxPos);
            jugadoresDestino[i].setVacio(true); 
            maxPos++;
        }
        jugadores=jugadoresDestino;
    }
    
    /*
     * cruza Jugadores con su posicion
     */
    private static void cruzarJugadores(){
        int maxJugPriRonda= (int)Math.pow(2, cantRondas);
        int cantPart=maxJugPriRonda/2;
        partidosPrimeraRonda=new Partido[cantPart];
        for (int i=0;i<partidosPrimeraRonda.length;i++)
        {
            partidosPrimeraRonda[i]=new Partido(i,1,jugadores[i],jugadores[jugadores.length-i-1]);
        }
    }
    
    /*
     * Calcula la cantidad de Rondas a jugar en  base a la cantidad de Jugadores Inscriptos
     */
    public static void calcularRondas(){
        double cantJug=jugadores.length;
        if (cantJug == 1) cantRondas = 1;
        while(cantJug>1)
        {
            cantRondas++;
            cantJug=cantJug/2;            
        }            
    }
    
    /*
     * Calcular la cantidad de Partidos en cada Ronda
     */
    public void rellenarRondas(){
        int cantJug=jugadores.length;
        int maxJugPriRonda= (int)Math.pow(2, cantRondas);
        int cantJugSegRonda=maxJugPriRonda-cantJug;
        int cantPart=(int)(cantJug-cantJugSegRonda)/2;
        rondas[0]=new Ronda(cantPart);//primera ronda
        for(int i=1;i<cantRondas;i++)
        {
            cantPart=(int)cantJug/2;
            rondas[i]=new Ronda(cantPart);//i ronda
        }
    }
    
    /*
     * Realiza una prueba
     */
    private static void cargarRondasFixture(){
        double cantJug=jugadores.length;
        int maxJugPriRonda= (int)Math.pow(2, cantRondas);
        int cantPart=maxJugPriRonda/2;
        rondasFixture= new int [cantRondas-1][cantPart];
        for(int i = 0; i<rondasFixture.length;i++)
        {
            int calc=(int)Math.pow(2, i);
            int var=cantPart/(calc*2);
            if(var==0) {
                rondasFixture[i][0]=0;break;
            }
            for(int j=0;j<var;j++)
            {
                rondasFixture[i][j]=0;
                rondasFixture[i][j+var]=1;
            }
            int mid=var*(2);
            for(int k=1;k<=i;k++)
            {
                
                int doubleMid=mid*2;
                for(int j=0;j<mid;j++)
                {
                    int v=doubleMid-j-1;
                    if(v<rondasFixture[i].length){
                    rondasFixture[i][v]=rondasFixture[i][j];}
                }
                mid=mid*(2);
            }
        }
    }
}
