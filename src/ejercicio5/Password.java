package ejercicio5;

import java.util.Iterator;
import java.util.Random;

public class Password {
	private int longitud;
	private String password;
	
	private final int LONGITUD_DEF = 8;
	private final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&";
	
	//constructor por defecto
	public Password() {
		this.longitud =LONGITUD_DEF;
		this.password = generarPassword();
	}
	
	//constructor con la longitud ingresada por el cliente
	public Password(int longitud) {
		this.longitud = longitud;
		this.password = generarPassword();
	}
	
	//Genero un password utilizando el String de caracteres permitidos, eligiendo una posición de este al azar
	public String generarPassword() {
		String aux = "";
		for (int i = 0; i <longitud; i++) {
			aux += CARACTERES_PERMITIDOS.charAt(createRandomInt());
		}
		return aux;
	}
	
	//verifica si la contraseña es fuerte o no
	public boolean esFuerte() {
		int contadorMayusculas=0, contadorMinusculas=0, contadorNumeros=0;
		
		for(int i = 0; i<password.length(); i++) {
			if(password.charAt(i)>=48 && password.charAt(i)<=57) {
				contadorNumeros++;
			} else if(password.charAt(i)>=65 && password.charAt(i)<=90) {
				contadorMayusculas++;
			} else if(password.charAt(i)>=97 && password.charAt(i)<=122) {
				contadorMinusculas++;
			}
		}
		return contadorMayusculas > 2 && contadorMinusculas > 1 && contadorNumeros >5 ? true :  false;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	//si cambio la longitud vuelvo a setear la contraseña también
	public void setLongitud(int longitud) {
		this.longitud = longitud;
		this.password = generarPassword();
	}
	
	//crea un número random entre el rango del largo de CARACTERES_PERMITIDOS
	public int createRandomInt() {
		Random random = new Random();
		return random.nextInt(CARACTERES_PERMITIDOS.length());
	}
}
