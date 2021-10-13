/*
 */
package quiziterator;
import quiziterator.Estructura.IteratorType;

public interface IContainer<T> {
    public IIterator<T> createIterator(IteratorType type);  
}
