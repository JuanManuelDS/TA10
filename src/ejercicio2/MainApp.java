package ejercicio2;

import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {

		Persona persona = new Persona();
		persona.rellenarDatos();
		JOptionPane.showMessageDialog(null, persona.toString());
	}

}
