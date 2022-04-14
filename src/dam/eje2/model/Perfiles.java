package dam.eje2.model;
/*
 * Se debe crear un programa para registrar 10 perfiles de LinkedIn, de manera que:
- Inicialice el array donde almacenarlos
- Para cada perfil solicite la siguiente información:
 Nombre (por ej: Carlos Ibarra Fernández)
 Puesto actual  (por ej: Director Comercial de D&B)
 Ciudad (por ej: Madrid)
 Número de contactos (por ej: 326)
 */

public class Perfiles {
	 
		public static final int LIM_C = 45; 
		public static final int MIN_C = 0;
		public static final int MAX_C = 100000;
		
		public static final  String [] CITY = {"MADRID", "BARCELONA","MALÁGA","VALLADOLID"};
		
		
		private String nombre;
		private String puesto;
		private String ciudad;
		private int numContac;
		
		public Perfiles(String nombre, String puesto, String ciudad, int numContac) {
		
			this.nombre = nombre;
			this.puesto = puesto;
			this.ciudad = ciudad;
			this.numContac = numContac;
		}

		

		public String getCiudad() {
			return ciudad;
		}

		public int getNumContac() {
			return numContac;
		}

		@Override
		public String toString() {
			return "Nombre: " + nombre +
					"\nPuesto actual: " + puesto + 
					"\nCiudad: " + ciudad + 
					"\n"+ numContac + " Contactos";
		}
		
		
		
		
		
		

}
