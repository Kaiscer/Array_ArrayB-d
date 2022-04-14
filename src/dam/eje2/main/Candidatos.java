package dam.eje2.main;

import dam.eje2.model.Perfiles;
import java.util.*;
public class Candidatos {
			static  final int N_PERFILES = 3;
			
			static Perfiles []candidatos;
			static Scanner sc;
	public static void main(String[] args) {
				sc = new Scanner (System.in);
				candidatos = new Perfiles[N_PERFILES];
				
				fillVector();
				sc.close();
				
				showVector();
				analysVector();

	}
	private static void analysVector() {
			Perfiles perfilMenosC = new Perfiles(null, null, null,100001);
			
			for (int i = 0; i < candidatos.length; i++) {
				
				if (candidatos[i].getCiudad().equals(Perfiles.CITY[0])&& candidatos[i].getNumContac()< perfilMenosC.getNumContac()  ) {
					perfilMenosC = candidatos[i];
					
				}
			}
			if (perfilMenosC.getCiudad() != null) {
				System.out.println("El perfil con menos contactos es: \n" + perfilMenosC);
			}else {
				System.out.println("Los contactos de Madrid son los que tiene mas contactos");
			}
		
	}
	private static void showVector() {
			System.out.println("Perfiles Guardado");
			for (int i = 0; i < candidatos.length; i++) {
				System.out.println(candidatos[i]);
				System.out.println();
			}
			
		
		
	}
	private static void fillVector() {
			String nombre;
			String puesto;
			String ciudad;
			int numContac;
			
			for (int i = 0; i < candidatos.length; i++) {
				
				nombre = solicitarNombreYPuesto("nombre " , i);
				
				puesto = solicitarNombreYPuesto("puesto actual ", i);
				
				ciudad = solicitarCuidad(i);
				
				numContac = solicitarContactos(i);
				
				candidatos[i] = new Perfiles(nombre, puesto, ciudad, numContac);
			}
		
		
	}
	private static int solicitarContactos(int i) {
		int num =0;
		boolean numNoOk = true;
		while (numNoOk) {
			try {
				System.out.println("Introduce el número de contactos");
				num = Integer.parseInt(sc.nextLine());
				if (num > Perfiles.MIN_C && num < Perfiles.MAX_C) {
					numNoOk = false;
				}else {
					throw new Exception("El número tiene que estar en el rango de " + Perfiles.MIN_C + " y " + Perfiles.MAX_C);
				}
				
				}catch (NumberFormatException e) {
					System.out.println("Debes ingresar un número entero positivo");
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
			
		}
		
		
		return num;
	}
	private static String solicitarCuidad(int i) {
		String ciudad = "";
		boolean ciudadNoOk = true;
		while (ciudadNoOk) {
	
				System.out.println("Introduce la ciudad del " + (i+1) + "º perfil");
				ciudad = sc.nextLine().toUpperCase();
				
				for (int j = 0; j < Perfiles.CITY.length&& ciudadNoOk; j++) {
					if (ciudad.equals(Perfiles.CITY[j])) {
						ciudadNoOk = false;
					}
					
				}
				if (ciudadNoOk) {
					System.out.println("Los perfiles solo pueden ser de Madrid, Barcelona, Malága o Valladolid");
				}
				
				
			
		}
		return ciudad;
	}
	private static String solicitarNombreYPuesto(String dato, int i) {
		String chain = "";
		boolean cadenaNoOk = true;
		while (cadenaNoOk) {
				
				System.out.println("Introduce el " + dato + " del perfil " + (i+1));
				chain = sc.nextLine().trim();
				
				if (chain.length() > Perfiles.LIM_C || chain.isEmpty()) {
					System.out.println("El " + dato + " no puede superar los 45 caracteres");
				}else {
					cadenaNoOk = false;
				}
				
			
		}						
		return chain;
	}

}
