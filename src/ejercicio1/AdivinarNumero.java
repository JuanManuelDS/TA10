package ejercicio1;

import java.util.Random;

import javax.swing.JOptionPane;

import excepciones.ExcepcionesPersonalizadas;

public class AdivinarNumero {

	private int numeroPorAdivinar;

	// constructor por defecto
	public AdivinarNumero() {
		this.numeroPorAdivinar = createRandomInt();
	}

	// interfaz gráfica del programa. Se controla que se ingresen únicamente números
	// y que estos se encuentren entre 1 y 500
	public void jugar() {
		boolean adivino = false;
		int intentos = 0;
		JOptionPane.showMessageDialog(null, "Bienvenido al Adivinador Adivinador");
		do {
			try {
				int input = Integer.parseInt(JOptionPane.showInputDialog(
						"Ingrese un número entre 1 y 500 para ver si coincide con el que piensa la máquina"));
				// En caso que el número esté fuera del rango lanzo un error personalizado
				if (input < 1 || input > 500)
					throw new ExcepcionesPersonalizadas(1);
				else if (input == numeroPorAdivinar) {
					JOptionPane.showMessageDialog(null,
							"Felicitaciones!!! Has adivinado en " + intentos + " intentos!!!");
					adivino = true;
				} else if (input < numeroPorAdivinar) {
					JOptionPane.showMessageDialog(null, "Frío");
					intentos++;
				} else {
					JOptionPane.showMessageDialog(null, "Caliente");
					intentos++;
				}
				// Por si el usuario ingresó algo que no sea un número
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar únicamente valores numéricos. Vuelva a intentarlo");
				intentos++;
			} catch (ExcepcionesPersonalizadas ea) {
				JOptionPane.showMessageDialog(null, ea.getMessage());
				intentos++;
			}

		} while (!adivino);
	}

	public int createRandomInt() {
		Random random = new Random();
		return random.nextInt(500) + 1;
	}

	public boolean adivino(int numero) {
		return numero == numeroPorAdivinar ? true : false;
	}

	public boolean esMayor(int numero) {
		return numero > numeroPorAdivinar ? true : false;
	}
}
