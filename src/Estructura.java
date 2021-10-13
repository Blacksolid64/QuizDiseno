/*
 */
package quiziterator;

public class Estructura implements IContainer<Estructura>{
    
    private int n;
    private int fila;
    private int columna;
    
    public Estructura(int n){
        this.n = n;
        this.fila = 1;
        this.columna = 1;
    }
    
    public enum IteratorType{
        Diagonal, DiagonalInvertida, PorFilas, PorColumnas, UnaFila, UnaColumna,
        FilasPares, FilasImpares, ColumnasPares, ColumnasImpares
    }

    @Override
    public IIterator<Estructura> createIterator(IteratorType type) {
        switch (type){
            case Diagonal:
                return new Diagonal(this);
            case DiagonalInvertida:
                return new DiagonalInvertida();
            case PorFilas:
                return new PorFilas();
            case PorColumnas:
                return new PorColumnas();
            case UnaFila:
                return new UnaFila();
            case UnaColumna:
                return new UnaColumna();
            case FilasPares:
                return new FilasPares();
            case FilasImpares:
                return new FilasImpares();
            case ColumnasPares:
                return new ColumnasPares();
            case ColumnasImpares:
                return new ColumnasImpares();
            default:
                System.out.println("Patrón no válido");
                return null;
        }
    }
    
    private class Diagonal implements IIterator<Estructura> {
        Estructura structure;
        
        public Diagonal(Estructura strcuture) {
            this.structure = strcuture;
        }
                                 
        @Override                    
        public boolean hasNext() {
            return ((structure.fila < structure.n) && (structure.fila == structure.columna));
        }
        
        @Override                    
        public Estructura next() {
            structure.fila += 1;
            structure.columna += 1;
            return structure;
        }
        
        @Override
        public void sumatoria(){
            int result = 0;
            while(this.hasNext()){
                result += structure.fila;
                structure = this.next();
            }
            result += structure.fila;
            System.out.println("Resultado Diagonal: " + result);
        }
    }
    
        private class DiagonalInvertida implements IIterator<Estructura> {
        
        public DiagonalInvertida() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
            private class PorFilas implements IIterator<Estructura> {
        
        public PorFilas() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    } 
            
        private class PorColumnas implements IIterator<Estructura> {
        
        public PorColumnas() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private class UnaFila implements IIterator<Estructura> {
        
        public UnaFila() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private class UnaColumna implements IIterator<Estructura> {
        
        public UnaColumna() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private class FilasPares implements IIterator<Estructura> {
        
        public FilasPares() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private class FilasImpares implements IIterator<Estructura> {
        
        public FilasImpares() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private class ColumnasPares implements IIterator<Estructura> {
        
        public ColumnasPares() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
        
        private class ColumnasImpares implements IIterator<Estructura> {
        
        public ColumnasImpares() {               
        }
                                 
        
        @Override                    
        public boolean hasNext() {                        
            return false;
        }
        
        @Override                    
        public Estructura next() {
            return null;
        }                

        @Override
        public void sumatoria() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    } 
    
    
}
