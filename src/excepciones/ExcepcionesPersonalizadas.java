package excepciones;

public class ExcepcionesPersonalizadas extends Exception{
	
	private int codigoExcepcion;

	public ExcepcionesPersonalizadas(int codigoExcepcion) {
		super();
		this.codigoExcepcion = codigoExcepcion;
	
	}
	
	@Override
	public String getMessage() {
		String mensaje ="";
		switch (codigoExcepcion) {
		case 1:
			mensaje="El número tiene que estar entre los valores 1 y 500";
			break;
		case 2:
			mensaje="El valor no puede contener números";
			break;
		case 3:
			mensaje="El número es par";
			break;
		case 4:
			mensaje="El número es impar";
			break;
		default:
			mensaje="Código de error desconocido";
			break;
		}
		return mensaje;
	}
}
