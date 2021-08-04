package CLASE2;

import java.util.Scanner;

public class naugrafo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        short tipoHamb=1, cantidad=0, tipoPago=1;
        double pagar=0;
        
        
        do{

            if(tipoHamb<1 || tipoHamb>3){
                System.out.println("Opcion incorrecta, vueleva a digitar...");
            }
            System.out.println("Digite el tipo de hamburguesa 1. Sencilla 2.Doble 3.Triple");
            System.out.print("Opcion: ");
            tipoHamb= scan.nextShort();

        }while(tipoHamb<1 || tipoHamb>3 );

        System.out.print("Digite la cantidad de hamburguesas requeridas: ");
        cantidad= scan.nextShort();

/*
        if(tipoHamb==1){
            pagar=20;
        }else if(tipoHamb==2){
            pagar=25;
        }else{
            pagar=28;
        }

        switch (tipoHamb) {
            case 1:
                pagar=20;
                break;
    
            case 2:
                pagar=25;
                break;
            
            case 3:
                pagar=28;
                break;
        
            default:
                break;
        }
*/
        pagar= tipoHamb==1 ? 20 : tipoHamb== 2 ? 25 : 28;
        pagar= pagar*cantidad;

        do{
            if(tipoPago<1 || tipoPago>2){
                System.out.println("El tipo pago indicado es incorrecto, vuleva a digitar.");
            }
            System.out.print("Digite el tipo de pago: 1.Efectivo 2. Tarjeta: ");
            tipoPago=scan.nextShort();
        }while(tipoPago<1 || tipoPago>2);

        if(tipoPago==2){

            pagar= pagar*1.05;
        }

        System.out.println("El total a pagar es: "+ pagar);       
    }
}
