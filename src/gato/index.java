package gato;

import java.util.Scanner;

public class index {
    
    static short fila=0, col=0;
    public static void main(String[] args) {
                    
        
        char gato[][]= new char[3][3];
        char marca='O';

        boolean ganar=false;
        short contaMarca=0;        

        do {

            //CAMBIO LA MARCA PARA EL SIGUIENTE TURNO
            marca= cambiarMarca(marca);           


            //imprimo el gato
            imprimirGato(gato);
            

            //ingresa marca y la valida.
            do {

                System.out.println("Digite la marca jugador: "+marca+" :");
                

                //solcitarValidarMarca

                solcitarValidarMarca();

                //RESTO UNO PARA TAMAÑO LOGICO
                fila--;
                col--;

                //VALIDO SI LA CASILLA ESTA OCUPADA PARA EL MENSAJE
                if(gato[fila][col]!=Character.MIN_VALUE ){
                    System.out.println("Casilla ocupada o incorrecta, vuelva a digital la posicion.");
                }
                //REPITE SI ESTA OCUPADA LA CASILLA
            } while (gato[fila][col]!=Character.MIN_VALUE );



            //realizarMarca()
            //REALIZO LA MARCA CON LA MARCA X o O
            gato[fila][col]= marca;


            //VALIDACIONES DE MARCA         
            ganar= validarJuego(gato, marca);
                    

            
            
          //REPITO SI NADIE A GANADO  
        } while (!ganar);



        //imprimir ultima jugada
        imprimirGato(gato);

        //MENSAJE DE GANE
        //EN EL CASO QUE SEA CONTA MARCA 9 NINGUNO GANO
        if(contaMarca==9 ){
            System.out.println("Ninguno gano.");
        }else{
            //GANO LA ULTIMA MARCA DIGITADA
            System.out.println("GANooo.. Marca "+ marca);
        }
    }

    private static char cambiarMarca(char marca){

       /* if(marca=='X'){
            marca='O';
        }else{
            marca='X';
        }

        marca= marca=='X'? 'O': 'X';
        
        */

        return marca=='X'? 'O': 'X';
    }

    private static void imprimirGato(char[][] gato){
        System.out.println("---------");
        for (int i = 0; i < gato.length; i++) {
            System.out.print("|");
            for (int j = 0; j < gato.length; j++) {
                //VALIDO SI TIENE MARCA O ESTA VACIA
                if(gato[i][j]==Character.MIN_VALUE)
                {
                    System.out.print("  ");
                }
                else
                {
                    //IMPRIMO LA MARCA
                    System.out.print(" "+gato[i][j]);
                }
                System.out.print("|");
            }System.out.println("");
            System.out.println("---------");
            
        }
    }

    private static void solcitarValidarMarca(){
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.print("Fila (1-3): ");
            fila=scan.nextShort();
    
            System.out.print("Columna (1-3): ");
            col=scan.nextShort();

            //VALIDO SI LA POSCION INDICADA ESTA EN RANGO PERMITIDO
            if((fila <1 || fila>3) || (col <1 || col>3)){
                System.out.println("Posicion incorrecta, verifique.");
            }
          //REPITO SI EL RANGO ESTA AFUERA DEL PERMITIDO  
        } while ((fila <1 || fila>3) || (col <1 || col>3));



    }

    private static boolean validarJuego(char [][] gato, char marca){

        //boolean ganar= false;

        if(validarFila(gato, marca) || validarColumna(gato, marca) || validarDiagonal(gato, marca) || 
        validarInversa(gato, marca) || validarEmpate(gato) ){

            return true;
        }else {
            return false;
        }        
        
        /*
        
        ganar= validarFila(gato, marca);
        if(ganar){
            return true;
        }
        ganar= validarColumna(gato, marca);
        if(ganar){
            return true;
        }

        ganar= validarDiagonal(gato, marca);
        if(ganar){
            return true;
        }

        ganar= validarInversa(gato, marca);
        if(ganar){
            return true;
        }

        ganar= validarEmpate(gato);
        if(ganar){
            return true;
        }

        return ganar;*/
    }

    private static boolean validarFila(char [][] gato, char marca){

        short contaMarca=0;
        boolean gana=false;
        //valido fila
        for (int i = 0; i < gato.length; i++) {
            if(gato[fila][i]==marca){
                contaMarca++;
            }                
        }

        //VALIDO SI TIENE 3 MARCAS PARA GANAR
        if(contaMarca==3){
            gana=true;
        }
        return gana;
    }

    private static boolean validarColumna(char [][]gato, char marca){


        short contaMarca=0;
        //valido columna
        for (int i = 0; i < gato.length; i++) {
            if(gato[i][col]==marca){
                contaMarca++;
            }                
        }

        //VALIDO SI TIENE 3 MARCAS PARA GANAR
        if(contaMarca==3){
             return true;
        }

        return false;
    }

    private static boolean validarDiagonal(char [][]gato, char marca){


        short contaMarca=0;
        //valido diagonal
        for (int i = 0; i < gato.length; i++) {
            if(gato[i][i]==marca){
                contaMarca++;
            }                
        }

        //VALIDO SI TIENE 3 MARCAS PARA GANAR
        if(contaMarca==3){
            return true;
        }

        return false;
    }


    private static boolean validarInversa(char [][] gato, char marca){

        short contaMarca=0;
        //valido diagnoal inversa
        for (int i = 0; i < gato.length; i++) {
            if(gato[i][2-i]==marca){
                contaMarca++;
            }                
        }

        //VALIDO SI TIENE 3 MARCAS PARA GANAR
        if(contaMarca==3){
           return true;
        }

        return false;
    }

    private static boolean validarEmpate(char [][]gato){

        short contaMarca=0;
        //valida que gato es completo y ninguno ha ganado
        

        for (int i = 0; i < gato.length; i++) {
            for (int j = 0; j < gato.length; j++) {
                if(gato[i][j]!=Character.MIN_VALUE){
                    contaMarca++;
                }
            }
        }

        //VALIDO SI TIENE 9 MARCAS Y NINGUNO GANA
        if(contaMarca==9){
            return true;
        }

        return false;

        
    }





}
