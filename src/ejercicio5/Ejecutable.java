package ejercicio5;

public class Ejecutable {

	private Password[] passwords;
	private boolean[] fuertes;
	private int largo;

	// constructor
	public Ejecutable(int largo) {
		this.largo = largo;
		passwords = new Password[largo];
	}

	// relleno el array con el largo pasado por parámetro
	public void rellenarArray(int longitud) {
		for (int i = 0; i < passwords.length; i++) {
			passwords[i] = new Password(longitud);
		}
	}

	// setea el atributo fuertes con un array de booleanos, que serán true o false
	// dependiendo si son contraseñas fuertes o no
	public void sonFuertes() {
		fuertes = new boolean[passwords.length];
		for (int i = 0; i < passwords.length; i++) {
			fuertes[i] = passwords[i].esFuerte();
		}
	}

	@Override
	public String toString() {
		sonFuertes();
		String aux = "";
		for (int i = 0; i < passwords.length; i++) {
			aux += passwords[i].getPassword() + " es fuerte ? " + fuertes[i] + "\n";
		}
		return aux;
	}

}
