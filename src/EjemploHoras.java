import java.util.Scanner;

public class EjemploHoras {

public static void main(String[] args) {

    Scanner scan= new Scanner(System.in);
/*Se requiere determinar el sueldo semanal de un trabajador con base en las horas que trabaja y
 el pago por hora que recibe. Realice el diagrama de flujo y 
 el pseudocódigo que representen el algoritmo de solución corres¬pondiente.*/

    float horaTrabajadas=0;
    float pagoHora=0;
    float pago=0;

    System.out.print("Digite la cantidad de horas trabajadas a al semana: ");
    horaTrabajadas= scan.nextFloat();

    System.out.print("Digite el pago por hora: ");
    pagoHora= scan.nextFloat();


    pago= horaTrabajadas * pagoHora;

    System.out.println("El sueldo a pagar es: " +pago);






    
}



    
}
