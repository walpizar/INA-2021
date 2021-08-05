package clase8;

import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //colecciones: vectores y matrices...... array list
        //declaracion
        int edad[];
        short cantidad=0, fil=0, col=0;

        //vector- declaracion e instanciacion 
       /* int edades[]= new int[10];
        System.out.println("Digite el tamaño del vector");
        cantidad= scan.nextShort();

        //instanciacion dinamica deacuerdo al valor indicado por el usuario
        edad= new int[cantidad];
*/
        //matrices
        //matriz- declaracion e instanciacion 
        String mNombres[][]= new String[5][3];
        
        //declaracion
        String mApodos[][];

        //tamaño dinamico
        System.out.println("Digite la cantidad de filas");
        fil= scan.nextShort();

        System.out.println("Digite la cantidad de columnas");
        col= scan.nextShort();

        //instanciacion dinamica deacuerdo al valor indicado por el usuario
        mApodos= new String[fil][col];
        



    }
    
}
