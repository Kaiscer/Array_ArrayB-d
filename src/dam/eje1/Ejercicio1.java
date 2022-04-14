package dam.eje1;
/*
 - Inicializar una matriz de enteros de dimensión n x n, solicitando 
	el valor de n por teclado.
- Rellenar la matriz con valores aleatorios que no sean múltiplos 
	de 3.
- Mostrar la matriz por consola.
- Indicar cuál de los dos triángulos que separa la diagonal inversa 
tiene mayor suma, el superior o el inferior. (mostrar las sumas)
 */
import java.util.*;
public class Ejercicio1 {
	static final int MIN = 1;
	static final int MAX = 100;
	
	static int [][] matrix;

	public static void main(String[] args) {
		
		starMatrix();
		
		fillMatrix();
		
		showMatrix();
		
		analysMatrix();

	}

	private static void analysMatrix() {
		
		int sumaTSup = 0;
		int sumaTInf = 0;
		int l = 1;
		
		for (int i = 0; i < matrix[i].length - 1; i++) {
			for (int j = 0; j < matrix.length - l; j++) {
				sumaTSup += matrix[i][j];
				sumaTInf += matrix[matrix.length - 1 - i][matrix[i].length - 1 - j];
			}
			l++;
		}
		System.out.println("\nLa suma del triangulo superior es " + sumaTSup);
		System.out.println("La suam del triangulo inferior es  " + sumaTInf);
		
		if (sumaTSup > sumaTInf) {
			System.out.println("El triangulo superio tiene mayor suma");
		}else if (sumaTSup < sumaTInf) {
			System.out.println("El triangulo inferior tiene mayor suma");
		}else {
			System.out.println("La suma de ambos triangulos son iguales");
		}
				
		
	}

	private static void showMatrix() {
		System.out.println("\nElementos de la matriz");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ||");
			}
			System.out.println();
		}
		
		
	}

	private static void fillMatrix() {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = getRandom(MIN,MAX);
			}
		}
	}

	private static int getRandom(int min2, int max2) {
		int alea = 0;
		Random rd = new Random();
		do {
			
			alea = rd.nextInt(MAX + 1 - MIN) + MIN;
			
		} while (alea % 3 == 0);
		
		return alea;
	}

	private static void starMatrix() {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Introduce el número de filas y columnas");
		int n = Integer.parseInt(sc.nextLine());
		
		int n2 = n * n;
		
		matrix = new int[n2][n2];
		
		sc.close();
		
		
	}

}
