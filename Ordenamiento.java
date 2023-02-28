import java.util.Random;

public class Ordenamiento {

    public static void main(String[] args) {
        
        int[] tamaños = {100, 500, 1000, 5000, 10000};
        
        for (int tamaño : tamaños) {
            double[] arreglo = generarArregloAleatorio(tamaño);
            
            double[] copiaBurbuja = arreglo.clone();
            long inicioBurbuja = System.currentTimeMillis();
            ordenamientoBurbuja(copiaBurbuja);
            long finBurbuja = System.currentTimeMillis();
            
            double[] copiaInsercion = arreglo.clone();
            long inicioInsercion = System.currentTimeMillis();
            ordenamientoInsercion(copiaInsercion);
            long finInsercion = System.currentTimeMillis();
            
            double[] copiaSeleccion = arreglo.clone();
            long inicioSeleccion = System.currentTimeMillis();
            ordenamientoSeleccion(copiaSeleccion);
            long finSeleccion = System.currentTimeMillis();
            
            double[] copiaMerge = arreglo.clone();
            long inicioMerge = System.currentTimeMillis();
            ordenamientoMergeSort(copiaMerge, 0, copiaMerge.length-1);
            long finMerge = System.currentTimeMillis();
            
            System.out.printf("Tamaño: %d%n", tamaño);
            System.out.printf("Burbuja: %d ms%n", finBurbuja-inicioBurbuja);
            System.out.printf("Inserción: %d ms%n", finInsercion-inicioInsercion);
            System.out.printf("Selección: %d ms%n", finSeleccion-inicioSeleccion);
            System.out.printf("Mergesort: %d ms%n%n", finMerge-inicioMerge);
        }
        
    }
    
    public static void ordenamientoBurbuja(double[] arreglo) {
        for (int i = 0; i < arreglo.length-1; i++) {
            for (int j = 0; j < arreglo.length-1-i; j++) {
                if (arreglo[j] > arreglo[j+1]) {
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }
    }
    
    public static void ordenamientoInsercion(double[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            double actual = arreglo[i];
            int j = i-1;
            while (j >= 0 && arreglo[j] > actual) {
                arreglo[j+1] = arreglo[j];
                j--;
            }
            arreglo[j+1] = actual;
        }
    }
    
    public static void ordenamientoSeleccion(double[] arreglo) {
        for (int i = 0; i < arreglo.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arreglo[i];
            arreglo[i] = arreglo[minIndex];
            arreglo[minIndex] = temp;
        }
    }
    
    public static void ordenamientoMergeSort(double[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
        ordenamientoMergeSort(arreglo, inicio, medio);
        ordenamientoMergeSort(arreglo, medio + 1, fin);
 
      
        
    }
  }
       public static double[] generarArregloAleatorio(int n) {
        
        Random rand = new Random();
        double[] arr = new double[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextDouble();
        }
        
        return arr;
        
    }
}