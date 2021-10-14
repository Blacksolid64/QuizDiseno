/*
 */
package quiziterator;

import java.util.Scanner;

public class Estructura implements IContainer<Estructura>{
    
    private int n;
    private int fila;
    private int columna;
    
    public Estructura(int n){
        this.n = n;
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
                return new DiagonalInvertida(this);
            case PorFilas:
                return new PorFilas(this);
            case PorColumnas:
                return new PorColumnas(this);
            case UnaFila:
                return new UnaFila(this);
            case UnaColumna:
                return new UnaColumna(this);
            case FilasPares:
                return new FilasPares(this);
            case FilasImpares:
                return new FilasImpares(this);
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
            this.structure.fila = 1;
            this.structure.columna = 1;
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
            Estructura structure;
            
            public DiagonalInvertida(Estructura structure) {
                this.structure = structure;
                this.structure.fila = 1;
                this.structure.columna = this.structure.n;
            }

            @Override                    
            public boolean hasNext() {
                return ((structure.fila < n) && (structure.columna > 1));
            }

            @Override                    
            public Estructura next() {
                structure.fila += 1;
                structure.columna -= 1;
                return structure;
            }                

            @Override
            public void sumatoria() {
            int result = 0;
            while(this.hasNext()){
                result += structure.fila;
                structure = this.next();
            }
            result += structure.fila;
            System.out.println("Resultado Diagonal Invertida: " + result);
        }
    }
        
        private class PorFilas implements IIterator<Estructura> {
            Estructura strcuture;

            public PorFilas(Estructura structure) {
                this.strcuture =  structure;
                structure.fila = 1;
                structure.columna = 1;
            }


            @Override                    
            public boolean hasNext() {                        
                return (((strcuture.fila <= n) && (strcuture.columna <= n)));
            }

            @Override                    
            public Estructura next() {
                if (strcuture.columna == n){
                    strcuture.fila += 1;
                    strcuture.columna = 1;
                }
                else{
                    strcuture.columna += 1;
                }
                return strcuture;
            }                

            @Override
            public void sumatoria() {
                int resultado = 0;
                while(this.hasNext()){
                    resultado += strcuture.columna;
                    strcuture = this.next();
                }
                System.out.println("Resultado Filas: " + resultado);
            }
    } 
            
        private class PorColumnas implements IIterator<Estructura> {
        Estructura strcuture;

        public PorColumnas(Estructura strcuture) {
            this.strcuture =  strcuture;
            strcuture.fila = 1;
            strcuture.columna = 1;
        }
                                 
        
        @Override                    
        public boolean hasNext() {
            return (((strcuture.fila <= n) && (strcuture.columna <= n)));
        }
        
        @Override                    
        public Estructura next() {
            if (strcuture.fila == n){
                strcuture.columna += 1;
                strcuture.fila = 1;
            }
            else{
                strcuture.fila += 1;
            }
            return strcuture;
        }                

        @Override
        public void sumatoria() {
            int resultado = 0;
            while(this.hasNext()){
                resultado += strcuture.fila;
                strcuture = this.next();
            }
            System.out.println("Resultado Columnas: " + resultado);
        }
    }
        
        private class UnaFila implements IIterator<Estructura> {
            Estructura structure;
            
            public UnaFila(Estructura structure) {
                this.structure = structure;
                Scanner entrada = new Scanner(System.in);
                System.out.print("Ingrese la fila: ");
                int f = entrada.nextInt();
                
                if(f > structure.n || f < 1){
                    System.out.println("Número de fila no válido");
                    this.structure.fila = -1; 
                } else {
                    this.structure.fila = f;
                    structure.columna = 1;
                }
            }

            @Override                    
            public boolean hasNext() {                        
                return ((structure.columna < structure.n));
            }

            @Override                    
            public Estructura next() {
                structure.columna += 1;
                return structure;
            }                

            @Override
            public void sumatoria() {
                if(this.structure.fila == -1){
                    System.out.println("");
                } else {
                    int result = 0;
                    while(this.hasNext()){
                        result += structure.fila;
                        structure = this.next();
                    }
                    result += structure.fila;
                    System.out.println("Resultado Fila " + structure.fila + ": " + result);
                }    
            }
        }
        
        private class UnaColumna implements IIterator<Estructura> {
            Estructura structure;
            
            public UnaColumna(Estructura structure) {
                    this.structure = structure;
                    Scanner entrada = new Scanner(System.in);
                    System.out.print("Ingrese la columna: ");
                    int c = entrada.nextInt();

                    if(c > structure.n || c < 1){
                        System.out.println("Número de columna no válido");
                        this.structure.columna = -1; 
                    } else {
                        this.structure.columna = c;
                        structure.fila = 1;
                    }
            }

            @Override                    
            public boolean hasNext() {                        
                return ((structure.fila < structure.n));
            }

            @Override                    
            public Estructura next() {
                structure.fila += 1;
                return structure;
            }                

            @Override
            public void sumatoria() {
                if(this.structure.columna == -1){
                    System.out.println("");
                } else {
                    int result = 0;
                    while(this.hasNext()){
                        result += structure.fila;
                        structure = this.next();
                    }
                    result += structure.fila;
                    System.out.println("Resultado Columna " + structure.columna + ": " + result);
                }
            }
        }
        
        private class FilasPares implements IIterator<Estructura> {
        Estructura structure;
        public FilasPares(Estructura structure) {
            this.structure = structure;
            structure.fila = 1;
            structure.columna = 1;
        }
                                 
        
        @Override                    
        public boolean hasNext() {
            return (((structure.fila <= n) && (structure.columna <= n)));
        }
        
        @Override                    
        public Estructura next() {
            if (structure.columna == n){
                structure.fila += 1;
                structure.columna = 1;
            }
            else{
                structure.columna += 1;
            }
            return structure;
        }                

        @Override
        public void sumatoria() {
            int resultado = 0;
            while(this.hasNext()){
                if ((structure.columna % 2) == 0) {
                    resultado += structure.fila;
                }
                structure = this.next();
            }
            System.out.println("Resultado Pares: " + resultado);
        }
    }
        
        private class FilasImpares implements IIterator<Estructura> {
            Estructura structure;
        public FilasImpares(Estructura structure) {
            this.structure = structure;
            structure.fila = 1;
            structure.columna = 1;
        }
                                 
        
        @Override                    
        public boolean hasNext() {
            return (((structure.fila <= n) && (structure.columna <= n)));
        }
        
        @Override                    
        public Estructura next() {
            if (structure.columna == n){
                structure.fila += 1;
                structure.columna = 1;
            }
            else{
                structure.columna += 1;
            }
            return structure;
        }                

        @Override
        public void sumatoria() {
            int resultado = 0;
            while(this.hasNext()){
                if ((structure.columna % 2) != 0) {
                    resultado += structure.fila;
                }
                structure = this.next();
            }
            System.out.println("Resultado Pares: " + resultado);
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
