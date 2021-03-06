package ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class index {


    //GLOBAL VARIABLES
    static boolean bandera=false;
    static short aciertos=0, errores=0;

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        
        //instancia del venctor palabras con las palabras del juego
       
        String palabaras[], palabraSelected="";
        char juego[];
        char letra;    
        char seguir;   
      
        
        //puede volver a jugar.
        //con las palabras que no ha salido. Gastando palabras
        //en caso de no existir palabra terminar el juego e indicar el mensaje respectivo.


        do {
            aciertos=0; errores=0;
            bandera=false;

            palabaras= leerArchivo();
            
            if(palabaras.length==0){
                System.out.println("No se puede jugar porque no hay palabras");
                break;            
            }

        
         
           String nombre= palabaras[0].substring(0,18).trim().toUpperCase();

            String pa= String.format("%1$-20s", "walter");
            System.out.println(pa.length());

            // escribirLineaArchivo(palabaras);
     
             //obtenerPalabra
             //random para obtener la palabara
           
             palabraSelected= obtenerPalabra(palabaras);
             //palabraSelected= palabraSelected.toUpperCase();
     
             //obtnerVectorJuego
             //instacia del venctor juego con el tamaño de la palabra seleccionada
             juego=  obtenerVectorJuego(palabraSelected);
     
             /*//1 manera apata de llenar el vector juego con la palabra seleccinada
             for(int i=0; i<palabraSelected.length(); i++){
     
                 juego[i]=palabraSelected.charAt(i);
     
             }
             */
     
             //segunda manera

            /* if(!palabraSelected.equals("fdd")){


             }*/
          
             System.out.println("BIENVENIDO AL JUEGO DEL AHORCADO..");    
     
             do {
     
                 bandera=false;
                 //imprimirJuego
                 imprimirJuego(palabraSelected, juego);
     
                 letra = solicitarLetra();
     
                 //validarLetra
                 validarLetra(letra, juego);
                 
                 //imprimirResultado
                 imprimirResultado();
     
     
             } while (aciertos!=juego.length && errores!=7);
     
     
             //imprimirResultadoFinal
             imprimirResultadoFinal(juego, palabraSelected);



             System.out.println("Desea volver a jugar(S/N)? ");   
             seguir= scan.next().toUpperCase().charAt(0);
             
             eliminarPalabraArchivo(palabraSelected, palabaras);
             




        } while (seguir=='S');
    }

    //CREAR METODOS: UN TROZO DE CODIGO DE UNA FUNCIONALIDAD ESPECIFICA......
    // HACE SOLAMENTE UNA ACCION, EL NOMBRE SE DEFINE EN VERBO EN INFINITIVO AR ER IR .
    // UN METODO HACE SOLAMENTE LO QUE INDICA SU ACCION.

    //¿PARA QUE CREO SUBRUTINAS O METODOS? REUTILIZACION 


    // nivel de acceso. public o private
    //retorno- si devuelve o no y que devuelve, no devuelve nada: VOID, si devuelve: TIPO DE DATO(SOLO 1)
    // el identificador del metodo. LE NOMBRE. Verbo en infinitivo caminar, comer, nadar
    //paramtros. la diferencia entre una variable y un metodo; Es el insumo que utliza el metodo para realizar la accion
    
   

    private static void eliminarPalabraArchivo(String palabraSelected, String[] palabaras) {
        String [] palabrasAux= new String[palabaras.length-1];

        short conta=0;

        for (int i = 0; i < palabaras.length; i++) {
            if(!palabaras[i].toUpperCase().trim().equals(palabraSelected.toUpperCase().trim())){
                palabrasAux[conta]=palabaras[i]; 
                conta++;
            }
        }

        escribirLineaArchivo(palabrasAux);
    }

    private static String obtenerPalabra(String palabras[]){
        Random ran= new Random();
       // String pala=  palabras[ran.nextInt(palabras.length)].toUpperCase();
       return   palabras[ran.nextInt(palabras.length)].toUpperCase();
    }

    private static char[] obtenerVectorJuego(String palabara){

        /*char []juego= new char[palabara.length()];   
        
        juego= */
    

        return palabara.toCharArray();
    }

    private static void imprimirJuego(String palabra, char[] juego){

        for (int i = 0; i < juego.length; i++) {               
            if(juego[i]=='*'){
                 System.out.print(palabra.charAt(i)+" ");
             
            }else{
                 System.out.print("__ ");
            } 
         }    

    }

    private static char solicitarLetra(){
      

        System.out.println("");
        System.out.print("Digite un letra: ");
        char letra= scan.next().toUpperCase().charAt(0);

        return letra;

    }

    private static void validarLetra(char letra, char[] juego){

        for (int i = 0; i < juego.length; i++) {
            if(letra==juego[i]){

                bandera= true;
                aciertos++;
                juego[i]='*';
            }
        }            
        if(!bandera){
            errores++;
        }
    }

    private static void imprimirResultado(){

        System.out.println("Aciertos: "+ aciertos);
        System.out.println("Intentos fallidos: "+ errores);
        System.out.println("Le quedan "+ (7-errores) + " intentos.");


    }

    private static void imprimirResultadoFinal(char[] juego, String palabra){

        if(aciertos==juego.length){
            System.out.println("USTED HA GANADO");
        }
        if(errores==7){
            
            System.out.println("HA QUEDADO AHORCADO..."+ "La palabra es: "+ palabra);
        }      

    }

    private static String [] leerArchivo(){
    
       String [] palabras = null;
       //ArrayList lista = new ArrayList<>();
       try {        
         
            short conta=0;
            String linea="";
        
            File archivo= new File("C://ina/palabras.txt");
            //verifica si no existe
            if(!archivo.exists()){
                //lo crea
                archivo.createNewFile();
            }

            FileReader fr = new FileReader(archivo);
            BufferedReader br= new BufferedReader(fr);

            
            while ((linea= br.readLine())!=null) {
                conta++;                
            }

            palabras= new String [conta];

            fr = new FileReader(archivo);
            br= new BufferedReader(fr);
        
            conta=0;
            while ((linea= br.readLine())!=null) {
                palabras[conta]= linea;            
                conta++;               
            }

       } catch (Exception e) {
           System.out.println(e);
           //TODO: handle exception
       }
       
       return palabras; 

    }
    public static String padRight(String s, int n) 
    { 
        return String.format("%1$-" + n + "s", s); 
    }


    

    private static void escribirLineaArchivo(String []lineas){

        FileWriter fichero= null;
        try {
            
            String ruta= "C://ina/palabras.txt";           
            
            File archivo= new File(ruta);
            //verifica si no existe
            if(!archivo.exists()){
                //lo crea
                archivo.createNewFile();
            }
            
            fichero= new FileWriter(ruta);

            PrintWriter pw = new PrintWriter(fichero);

            for (int i = 0; i < lineas.length; i++) {
                pw.println(lineas[i]);
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
        finally{
        
            try {
                if(fichero!=null){
                    fichero.close();    
                }

            } catch (Exception e) {
                //TODO: handle exception
            }          

        }

    }
}
