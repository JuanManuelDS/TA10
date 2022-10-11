package ejercicio3;

import java.util.Random;

import excepciones.ExcepcionesPersonalizadas;

public class Numero {

	private int numeroAleatorio;
	
	public Numero() {
		this.numeroAleatorio = createRandomInt();
	}
	
	public int createRandomInt() {
		Random random = new Random();
		return random.nextInt(1000) + 1;
	}
	
	@Override
	public String toString() {
		String retorno = "Generando número aleatorio...\n" + "Número aleatorio generado: " + numeroAleatorio + "\n";
		try {
			isPar();
		}catch (ExcepcionesPersonalizadas ep) {
			retorno += ep.getMessage();
		}
		return retorno;
	}
	
	public void isPar() throws ExcepcionesPersonalizadas {
		if(numeroAleatorio%2==0) {
			throw new ExcepcionesPersonalizadas(3);
		} else {
			throw new ExcepcionesPersonalizadas(4);
		}
		
	}
}
