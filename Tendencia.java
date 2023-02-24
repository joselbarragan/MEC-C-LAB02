
//http://dit.upm.es/~pepe/libros/vademecum/index.html?n=305.html informacion de arrays
//https://es.stackoverflow.com/questions/97417/programa-en-java-para-calcular-modas-de-una-muestra info hallar moda
//https://parzibyte.me/blog/2020/02/28/media-mediana-java/#Mediana identificar la diferencia entre media y mediana 


import java.util.Arrays;
import java.util.Scanner;


public class Tendencia {

    
    public static void main(String[] args) {

        
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tama = leer.nextInt();

       
        int[] arreglo = new int[tama];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }

        
        System.out.println("Arreglo generado: " + Arrays.toString(arreglo));

        
        double media = 0;
        for (int i = 0; i < arreglo.length; i++) {
            media += arreglo[i];
        }
        media /= arreglo.length;
        System.out.println("Media: " + media);

        
        Arrays.sort(arreglo);
        double mediana;
        if (arreglo.length % 2 == 0) {
            mediana = (arreglo[arreglo.length / 2] + arreglo[(arreglo.length / 2) - 1]) / 2.0;
        } else {
            mediana = arreglo[arreglo.length / 2];
        }
        System.out.println("Mediana: " + mediana);

        
        double varianza = 0;
        for (int i = 0; i < arreglo.length; i++) {
            varianza += Math.pow(arreglo[i] - media, 2);
        }
        varianza /= arreglo.length;
        System.out.println("Varianza: " + varianza);

        
        double desviacionEstandar = Math.sqrt(varianza);
        System.out.println("Desviación estándar: " + desviacionEstandar);

        
        int moda = arreglo[0];
        int modaFrecuencia = 1;
        int frecuenciaActual = 1;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] == arreglo[i - 1]) {
                frecuenciaActual++;
            } else {
                if (frecuenciaActual > modaFrecuencia) {
                    moda = arreglo[i - 1];
                    modaFrecuencia = frecuenciaActual;
                }
                frecuenciaActual = 1;
            }
        }
        if (frecuenciaActual > modaFrecuencia) {
            moda = arreglo[arreglo.length - 1];
        }
        System.out.println("Moda: " + moda);

    }

}
