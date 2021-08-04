package CLASE2;

import java.util.Scanner;

public class estructuras {

    public static void main(String[] args) {
        //estructuras
        // if- switch- for- while- do while

        Scanner scan= new Scanner(System.in);

        /*
        System.out.print("Digite una edad: ");
        int edad= scan.nextInt();
        //booleanbo como resultado
        // condicionales > < >= <= == != !(NEGACION) ||(O) && (Y)
        //opcional ELSE
        //indentacion
        if((edad>=18)){      
         
            System.out.println("MAYOR DE EDAD");
        }else{         
            System.out.println("ES MENOR DE EDAD");
        }




       
        //1 UNA SENTECIA
        if(edad>=18)
            System.out.println("fffff");    
        else{

        }
        
        String valor = edad>=18 ? "MAYOR DE EDAD": "MENOR DE EDAD";   
        System.out.println(valor);


    
        System.out.print("1. Multiplicar 2.Sumar 3.Dividir 4. Restar");
        short opc= scan.nextShort();

        System.out.print("Numero 1: ");
        float numero1= scan.nextFloat();

        System.out.print("Numero 2: ");
        float numero2= scan.nextFloat();


        //break detiene ejecuion del bloque
        //cada caso termina con un break
        switch(opc){
            
            case 1:
                System.out.println("EL RESULTADO ES: " + (numero1*numero2));
                
                break;

            case 2:
                System.out.println("EL RESULTADO ES: " + (numero1+numero2));
                break;

            case 3:
            
            System.out.println("EL RESULTADO ES: " + (numero1/numero2));
                break;

            case 4:
                System.out.println("EL RESULTADO ES: " + (numero1-numero2));
                break;

            default:

                System.out.println("no existe la opcion dentro del menu");
        } 
        
    
        //casteo o parseo == CUANDO QUIERO CONVERTIR DE UN TIPO A OTRO TIPO DE DATO
        //IMPICITOS -- EXPLICITOS
        short var1=5;
        int var2=455555555;

        double ddd=9;
        float ddds=3;
        
        String numero3="4";
        // implicito
        var2= var1;


        //explicita tipos diferentes o maneja rangos diferentes
        var1= (short)var2;

        //explicito casteo de un string
        var1= Short.parseShort(numero3);
        //ir a su clase de tipo. la que comienza en MAYUSCULA, no el tipo primitivo
        ddd= Double.parseDouble(numero3);

        System.out.println("valor: "+ var1);

*/
        //CICLOS
        //for
        //i=i+1 == i++  
        //i=i-1 i--

      /*  if(true){
            if(true){

            }else if(true){
                
            }

        }else if(false){

        }else if(true){

        }else if(true){

        }else{

        }*/


        for (int i=0; i< 10; i++ ){
            System.out.println(i);
            caminar();

        }

        //AUMENTOS Y DECREMENTO
        // x=x+1;
        int x=0;
        System.out.println("incremento x++: "+ x++);
        System.out.println("incremento x++: "+ x);


        int y=0;
        System.out.println("incremento ++y: "+ ++y);

        System.out.println("incremento ++y: "+ y);


        System.out.println(y);
        
        //while repite condicion verdadera
        while(y>=1 && y<=10){

            System.out.println(y);
            y++;

        }

        //do while repite condicion verdadera
        System.out.println("do while");
        do{
            y--;
            System.out.println(y);

        }while(y>=1);

                 
        //comentario alfonso


    }


    public static void caminar(){

        System.out.println("estoy caminando...");

    }
    
}
