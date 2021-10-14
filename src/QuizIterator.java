/*
Joshua Arcia - Debir Granados
 */
package quiziterator;

import java.util.Scanner;

public class QuizIterator {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el tamaño: ");
        int n = entrada.nextInt();
        
        Estructura nuevaEstructura = new Estructura(n);
        IIterator iterador = nuevaEstructura.createIterator(Estructura.IteratorType.FilasImpares);
        iterador.sumatoria();
        
        
        
    }
    
}
