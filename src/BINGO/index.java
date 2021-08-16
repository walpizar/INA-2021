package BINGO;
import java.util.Scanner;



public class index {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);
        //crear carton
        String bingo [][]= new String[5][5];
        int tipoGane=0;
        String [] bolitasJugadas= new String[50];
         String [] bolitasAcertadas= new String[50];

        String bolita="";
        boolean gane=false;

        do {
            System.out.println("Indique el tipo de gane: 1.CARTON LLENO 2.UNA FILA 3.UNA COLUMNA 4.CUATRO ESQUINAS");
            tipoGane = scan.nextInt();
            if(tipoGane<1 || tipoGane>4){
                System.out.println("La opcion indica es incorrecta.");
            }
        } while (tipoGane<1 || tipoGane>4);
       //lleno el carton
        llenarCarton(bingo);
        //empiezo a jugar
    
        do {

            imprimirJuego(bingo,bolitasJugadas,bolitasAcertadas);
      
        
            //cayo bolita......        
            bolita = generarValidarBolitaRecursivo(bolitasJugadas);
            agregarBolitaVector(bolitasJugadas, bolita);
            System.out.println("CAYÓ BOLITA: "+ bolita);

            //validarB
            gane = validarBolitaGaneCarton(bolita, bingo, tipoGane, bolitasAcertadas);

            
        } while (!gane);


        
    }


    private static void imprimirJuego(String[][] bingo, String[] bolitasJugadas, String[] bolitasAcertadas) {
    
        imprimirCarton(bingo);
        imprimirJugadas(bolitasJugadas);
        imprimirAcertadas(bolitasAcertadas); 
        System.out.println("");
    }


    private static void imprimirAcertadas(String[] bolitasAcertadas) {


        System.out.println("");
        System.out.print("BOLITAS ACERTADAS: ");
        for (int i = 0; i < bolitasAcertadas.length; i++) {
            if(bolitasAcertadas[i]!=null){
                System.out.print(bolitasAcertadas[i]+" ");

            }   
        }
    }


    private static void imprimirJugadas(String[] bolitasJugadas) {
        System.out.println("");
        System.out.print("BOLITAS JUGADAS: ");
        for (int i = 0; i < bolitasJugadas.length; i++) {
           if(bolitasJugadas[i]!=null){
            System.out.print(bolitasJugadas[i]+" ");
           }  
        }
    }


   


    private static boolean validarBolitaGaneCarton(String bolita, String[][] bingo, int tipoGane, String [] bolitasAcertadas) {

        
        boolean gano = false;
        //validar
        //gano = validarBolita(bolita, bingo);    

        if(validarBolita(bolita, bingo, bolitasAcertadas)){
            //validar gane 
            switch (tipoGane) {
                    
                //carton lleno
                case 1:
                    gano = validarCartonLleno(bingo);
                    break;
                //fila
                case 2:
                    gano = validarFila(bingo);
                    break;
                //columna
                case 3:
                    gano = validarColumna(bingo);
                    break;
                //4 esquiinas
                case 4:
                    gano = validarEsquinas(bingo);   
                    break;
        
                default:
                    break;
            }
        }     

        return gano; 
        
    }


    private static boolean validarBolita(String bolita, String[][] bingo, String [] bolitasAcertadas) {
        

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {

                if(bingo[i][j].equals(bolita)){

                    bingo[i][j]="X";
                    agregarBolitaVector(bolitasAcertadas, bolita);
                    return  true;
                }
                
            }
        }
        
        return false;
    }
    private static void agregarBolitaVector(String[] vector, String bolita) {
        for (int i = 0; i < vector.length; i++) {
            if(vector[i]==null){
                vector[i]=bolita;
                break;
            }            
        }

    }
/*
    private static void agregarBolitaAcertada(String bolita, String[] bolitasAcertadas) {
        for (int i = 0; i < bolitasAcertadas.length; i++) {
            if(bolitasAcertadas[i]==null){
                bolitasAcertadas[i]=bolita;
                break;
            }            
        }
    }
*/

    private static boolean validarColumna(String[][] bingo) {
        boolean gano=false;

        for (int i = 0; i < bingo.length; i++) {           

            for (int j = 0; j < bingo.length; j++) {
                if(!bingo[j][i].equals("X")){
                    gano=false;
                    break;                    
                }
                gano=true;
            } 

            if(gano){
                break;   
            } 
        }  
        
        return gano;  

    }


    private static boolean validarEsquinas(String[][] bingo) {
       
        if(bingo[0][0].equals("X") && bingo[0][4].equals("X") && bingo[4][0].equals("X") && bingo[4][4].equals("X")){

            return true;
        }else
        {
            return false;
        }      

    }


    private static boolean validarFila(String[][] bingo) {

        boolean gano=false;

        for (int i = 0; i < bingo.length; i++) {            

            for (int j = 0; j < bingo.length; j++) {
                if(!bingo[i][j].equals("X")){
                    gano=false;
                    break;                    
                }
                gano=true;
            } 

            if(gano){
                break;   
            } 
        }  
        
        return gano;     
    }


    private static boolean validarCartonLleno(String[][] bingo) {

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {
                if(!bingo[i][j].equals("X")){
                    return false;

                }                
            }
        }

        return true;
    }


    private static String generarValidarBolita(String[] bolitasJugadas) {
        
        String num;
        boolean repetido=false;

        do {
            num= obternerNumeroAleaterios();
            repetido=false;
            for (int i = 0; i < bolitasJugadas.length; i++) {
                if(bolitasJugadas[i]!=null && bolitasJugadas.equals(num)){
                    repetido=true;
                    break;
                }            
            }
        } while (repetido);       
        return num;
    }

    private static String generarValidarBolitaRecursivo(String[] bolitasJugadas) {
        
        String num= obternerNumeroAleaterios();

        for (int i = 0; i < bolitasJugadas.length; i++) {
            if(bolitasJugadas[i]!=null && bolitasJugadas[i].equals(num)){
                num = generarValidarBolitaRecursivo(bolitasJugadas);                
            }            
        }
        return num;
    }

    private static void imprimirCarton(String[][] bingo) {

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {

                System.out.print(bingo[i][j]+ "  ");
                
            }  
            System.out.println("");          
        }
    }

    private static void llenarCarton(String[][] bingo) {


        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {

                bingo[i][j]= obtenerValidarNumeroRecusivo(bingo);                 
            }
        }

    }

    private static String obtenerValidarNumero(String[][] bingo) {

        boolean repetido=false;
        String num;
 
        do {
            num= obternerNumeroAleaterios();
            repetido=false; 

            for (int i = 0; i < bingo.length; i++) {
                for (int j = 0; j < bingo.length; j++) {
    
                    if(bingo[i][j]!=null && bingo[i][j].equals(num)){
                        repetido=true; 
                        break;
                    }                                 
                } 
                if(repetido){
                    break;
                }           
            }            
        } while (repetido);

        return num;
    }

    //recursividad: es un metodo que se llama a el mismo
    private static String obtenerValidarNumeroRecusivo(String[][] bingo) {
     
        String num= obternerNumeroAleaterios();        

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {

                if(bingo[i][j]!=null && bingo[i][j].equals(num)){
                   num = obtenerValidarNumeroRecusivo(bingo);
                }                                 
            }                     
        } 
        return num;
    }

    private static String obternerNumeroAleaterios(){
        return  Integer.toString((int)(Math.random() *50+1)); 

    } 


    private static int [][] cargarBingoAlfonso(int Bingo[][]){
        int numero = 0; 

        for (int i = 0; i < Bingo.length; i++) {

            for (int j = 0; j < Bingo.length; j++) {

                numero =(int)(Math.random()*50+1);                

                for (int j2 = 0; j2 < Bingo.length; j2++) {

                    for (int k = 0; k <Bingo.length; k++) {

                        if (numero==Bingo[j2][k]) {

                           numero=(int)(Math.random()*50+1); 
                           j2=0;k =0;
                        }
                    }
                }
                Bingo[i][j]= numero;
            }
        }
        return Bingo;
    }    
}
