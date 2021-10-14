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
        
        IIterator iterador = nuevaEstructura.createIterator(Estructura.IteratorType.Diagonal);
        iterador.sumatoria();
        
        IIterator iterador2 = nuevaEstructura.createIterator(Estructura.IteratorType.DiagonalInvertida);
        iterador2.sumatoria();
        
        IIterator iterador3 = nuevaEstructura.createIterator(Estructura.IteratorType.UnaFila);
        iterador3.sumatoria();
        
        IIterator iterador4 = nuevaEstructura.createIterator(Estructura.IteratorType.UnaColumna);
        iterador4.sumatoria();
        
        IIterator iterador5 = nuevaEstructura.createIterator(Estructura.IteratorType.PorFilas);
        iterador5.sumatoria();
        
        
        
    }
    
}
