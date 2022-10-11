package ejercicio5;

public class MainApp {

	public static void main(String[] args) {
		//Creo un ejecutable indicándole que tendrá 25 contraseñas
		Ejecutable ejecutable = new Ejecutable(25);
		//relleno el array con contraseñas aleatorias de 20 caracteres de longitud
		ejecutable.rellenarArray(20);
		System.out.println(ejecutable.toString());
	}

}
