import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        // Definir el tamaño del inventario
        System.out.print("Ingrese el tamaño del inventario: ");
        int TamArreglo = leer.nextInt();
        leer.nextLine();
        
        // Declarar los arreglos para almacenar los libros y sus cantidades
        String[] libros = new String[TamArreglo];
        int[] cantidades = new int[TamArreglo];
        
        // Pedir al usuario que ingrese los libros y sus cantidades
        for (int i = 0; i < TamArreglo; i++) {
            System.out.println("Ingrese el nombre del libro #" + (i+1) + ": ");
            libros[i] = leer.nextLine();
            try {
                System.out.println("Ingrese la cantidad de ejemplares: ");
                cantidades[i] = leer.nextInt();
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("Solo numeros enteros");
                leer.nextLine();
                i--;
            }
        }
        
        // Ordenar los libros por nombre usando Insertion Sort
        for (int i = 1; i < libros.length; i++) {
            String libroActual = libros[i];
            int cantidadActual = cantidades[i];
            int j = i - 1;
            
            while (j >= 0 && libros[j].compareTo(libroActual) > 0) {
                libros[j + 1] = libros[j];
                cantidades[j + 1] = cantidades[j];
                j = j - 1;
            }
            libros[j + 1] = libroActual;
            cantidades[j + 1] = cantidadActual;
        }
        
        // Mostrar el inventario ordenado
        System.out.println("\nInventario de la librería:");
        for (int i = 0; i < TamArreglo; i++) {
            System.out.println(libros[i] + ": " + cantidades[i] + " ejemplares");
        }
        leer.close();
    }
}
