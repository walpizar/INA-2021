import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {
    //variable GLOBAL ???
   //ES RECOMENDABLE CREAR VARIABLES GLOBALES???????? /////NOOOOOOOOOOOOOOOOOOOO
    int num2 =0; //scope- ambito
    
    
    /**
     * ESTE ESE EL MAIN PRINCIPAL
     * RECIBE UN PARAMETO DE ARGUMENTOS
     * RETORN   X COSA
     * AUTHOR: WALTER ALPIZAR
     * FEHCA CREACION: 29-7-21
     * FECHA ULTIMA MODIFICAICON: 29-7-21
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan= new Scanner(System.in);
        //declaracion de variable        
        
        //datos primitivos short-int-long - String - float- double- boolean- byte
       /* int num=0;
        short num5=0;
        long num6=0;
        double num7=0;
        boolean bandera = false;
        String nombre="HOLA";
        int[][] matriz = {{6,3,5},{4,5,6}};
        int[] vector = {1,2,3};
        */


        //int num1=0 , num2=0;
      //ejemplo: sumar 2 numeros
        //LOS indentificadores no pueden ser iguales y no pueden ser PALABRAS RESERVADAS
        int num1=0;
        int num2=0;
        int suma=0;
        String nombre= "";

        System.out.print("Digite el numero 1 :");
        num1=scan.nextInt();
        System.out.print("Digite el numero 2: ");
        num2=scan.nextInt();

        suma=num1+num2;


        System.out.println("El resultado es:"+suma);
        JOptionPane.showMessageDialog(null, suma);

        nombre= JOptionPane.showInputDialog(null, "Digite el nombre de la persona");


        System.out.println("EL nombre es: "+ nombre + " sumó: "+ suma);
        JOptionPane.showMessageDialog(null,"EL nombre es: "+ nombre + " sumó: "+ suma);









/*
        if(true)
        {
            //scope
           int num3=0;
            System.out.println(num3);

        }

        System.out.println(num3);



*/

        //variable: espacio en memoria
        //tipo indetificador valor de inicializacion
        //donde declara variables al INICIO- bloque- objeto-metodo
           



        //cambio maria laura prueba
        //esto es la impresion de el main principal- linea
        //System.out.println("Hello, World!");    
        /*
        caminar();
        if (5>6){
            System.out.println("si");
            int x=5;
        }
        */

       
    }

    /*public static void caminar(){


        System.out.println("estoy caminando, Y CAMBIANDO....");
    }*/

}
