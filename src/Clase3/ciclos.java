package Clase3;

import java.util.Scanner;

public class ciclos {
    public static void main(String[] args) {
        short conta=0;
        int suma=0, numero=0;

        Scanner scan= new Scanner(System.in);


        //cuando se repetite, o se repite mientras ???
       /* while (conta<=9) {

            System.out.print("Digite un numero "+ (conta+1) +": ");
            numero= scan.nextInt();

            //acumulando
            //suma=suma+numero;
            suma+=numero;

            conta++;
            
        }
        System.out.println("el resultado de la suma es: "+ suma);*/
/*
        do {
            
            System.out.print("Digite un numero "+ (conta+1) +": ");
            numero= scan.nextInt();

            //acumulando
            //suma=suma+numero;
            suma+=numero;


            conta++;
            
        } while (conta<=9);
        System.out.println("el resultado de la suma es: "+ suma);

*/

        for (int i = 0; i <= 9; i++) {
           
            System.out.print("Digite un numero "+ (i+1) +": ");
            numero= scan.nextInt();

            //acumulando
            //suma=suma+numero;
            suma+=numero;
            
        }

        System.out.println("el resultado de la suma es: "+ suma);


    }
}
