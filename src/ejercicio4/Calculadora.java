package ejercicio4;

import javax.swing.JOptionPane;

import excepciones.ExcepcionesPersonalizadas;

public class Calculadora {
	
	//constructor por defecto
	public Calculadora() {
	}
	
	//Iniciar calculadora posee toda la interface visual del programa, desde donde se llama a las diferentes funciones
	public void iniciarCalculadora() {
		boolean opcionCorrecta = false;
		int opcion = 0;
		//verifico que lo que ingresa el usuario sean sólamente números que se encuentren entre 1 y 7
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(
						"Ingrese el número con la operación que desea realizar: \n1. Sumar \n2. Restar \n3. Dividir \n4. Multiplicar \n5. Elevar \n6. Raíz cuadrada \n7. Raíz cúbica "));
				if (opcion < 1 || opcion > 7) {
					throw new ExcepcionesPersonalizadas(5);
				}
				opcionCorrecta = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar únicamente valores numéricos. Vuelva a intentarlo");
			} catch (ExcepcionesPersonalizadas ea) {
				JOptionPane.showMessageDialog(null, ea.getMessage());
			}
		} while (!opcionCorrecta);

		int[] inputs;
		int input;
		int resultado;
		
		//llamo a las distintas funciones en función de la opción seleccionada
		switch (opcion) {
		case 1:
			inputs = inputsVerificados("suma");
			resultado = sumar(inputs[0], inputs[1]);
			JOptionPane.showMessageDialog(null, inputs[0] + "+" + inputs[1] + "= " + resultado);
			break;
		case 2:
			inputs = inputsVerificados("resta");
			resultado = restar(inputs[0], inputs[1]);
			JOptionPane.showMessageDialog(null, inputs[0] + "-" + inputs[1] + "= " + resultado);
			break;
		case 3:
			inputs = inputsVerificados("división");
			resultado = dividir(inputs[0], inputs[1]);
			JOptionPane.showMessageDialog(null, inputs[0] + "/" + inputs[1] + "= " + resultado);
			break;
		case 4:
			inputs = inputsVerificados("multiplicación");
			resultado = multiplicar(inputs[0], inputs[1]);
			JOptionPane.showMessageDialog(null, inputs[0] + "*" + inputs[1] + "= " + resultado);
			break;
		case 5:
			inputs = inputsVerificados("potencia");
			resultado = potencia(inputs[0], inputs[1]);
			JOptionPane.showMessageDialog(null, inputs[0] + "^" + inputs[1] + "= " + resultado);
			break;
		case 6:
			input = inputVerificado("raíz cuadrada");
			JOptionPane.showMessageDialog(null, raizCuadrada(input));
			break;
		case 7:
			input = inputVerificado("raíz cúbica");
			JOptionPane.showMessageDialog(null, raizCubica(input));
			break;

		}

	}

	// la función verifica que los inputs sean únicamente numéricos y los ingresa.
	// Esta en particular sirve sólamente para las funciones que precisan de 2
	// inputs
	public int[] inputsVerificados(String operacion) {
		boolean inputCorrecto = false;
		int input1 = 0;
		int input2 = 0;
		do {
			try {
				input1 = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese el primer valor a calcular la " + operacion));
				input2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo valor"));
				inputCorrecto = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar únicamente valores numéricos. Vuelva a intentarlo");
			}
		} while (!inputCorrecto);
		int[] inputs = { input1, input2 };
		return inputs;
	}

	// Esta función verifica el input ingresado, que sea numérico. Sirve
	// exclusivamente para las operaciones que requieran un solo input
	public int inputVerificado(String operacion) {
		boolean inputCorrecto = false;
		int input = 0;
		do {
			try {
				input = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a calcular la " + operacion));
				inputCorrecto = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Debe ingresar únicamente valores numéricos. Vuelva a intentarlo");
			}
		} while (!inputCorrecto);

		return input;
	}

	public int sumar(int a, int b) {
		return (a + b);
	}

	public int restar(int a, int b) {
		return (a - b);
	}
	
	//esta función maneja la excepción lanzada cuando se intenta dividir por 0
	public int dividir(int a, int b) {
		double resultado = 0;
		try {
			resultado = a / b;
		} catch (ArithmeticException ae) {
			JOptionPane.showMessageDialog(null, "No es posible dividir por 0");
		}
		return (int) resultado;
	}

	public int multiplicar(int a, int b) {
		return (a * b);
	}

	public int potencia(int a, int b) {
		return (int) Math.pow(a, b);
	}

	public double raizCuadrada(int a) {
		return Math.sqrt(a);
	}

	public double raizCubica(int a) {
		return Math.cbrt(a);
	}

}
