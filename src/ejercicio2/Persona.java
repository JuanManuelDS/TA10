package ejercicio2;

import javax.swing.JOptionPane;

import excepciones.ExcepcionesPersonalizadas;

public class Persona {

	private String nombre, apellido, nacionalidad;
	private int edad;

	// constructor por defecto
	public Persona() {
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nApellido: " + apellido + "\nNacionalidad: " + nacionalidad + "\nEdad: " + edad;
	}

	// función que ejecuta la interfaz gráfica para el ingreso de datos y controla
	// que los ingresos sean correctos.
	public void rellenarDatos() {
		boolean inputCorrecto = false;

		do {
			try {
				nombre = JOptionPane.showInputDialog("Ingrese su nombre por favor");
				if (hasNumbers(nombre)) {
					throw new ExcepcionesPersonalizadas(2);
				} else
					inputCorrecto = true;
			} catch (ExcepcionesPersonalizadas ep) {
				JOptionPane.showMessageDialog(null, "Excepción capturada con mensaje: " + ep.getMessage());
			}

		} while (!inputCorrecto);

		do {
			try {
				apellido = JOptionPane.showInputDialog("Ingrese su apellido por favor");
				if (hasNumbers(apellido)) {
					inputCorrecto = false;
					throw new ExcepcionesPersonalizadas(2);
				} else
					inputCorrecto = true;
			} catch (ExcepcionesPersonalizadas ep) {
				JOptionPane.showMessageDialog(null, "Excepción capturada con mensaje: " + ep.getMessage());
			}

		} while (!inputCorrecto);

		do {
			try {
				nacionalidad = JOptionPane.showInputDialog("Ingrese su nacionalidad");
				if (hasNumbers(nacionalidad)) {
					inputCorrecto = false;
					throw new ExcepcionesPersonalizadas(2);
				} else
					inputCorrecto = true;
			} catch (ExcepcionesPersonalizadas ep) {
				JOptionPane.showMessageDialog(null, "Excepción capturada con mensaje: " + ep.getMessage());
			}

		} while (!inputCorrecto);

		do {
			try {
				edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
				inputCorrecto = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Excepción capturada con mensaje: debe ingresar únicamente valores numéricos.");
				inputCorrecto = false;
			}
		} while (!inputCorrecto);
	}

	// devuelve true si la cadena que se le pasa como parámetro posee un número en
	// ella. False en el caso contrario
	public boolean hasNumbers(String cadena) {
		char[] chArray = cadena.toCharArray();
		for (char c : chArray) {
			if (Character.isDigit(c))
				return true;
		}
		return false;
	}

}
