package ejercicio1;

public class ExcepcionesAdivinador extends Exception{
	
	private int codigoExcepcion;

	public ExcepcionesAdivinador(int codigoExcepcion) {
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

		default:
			mensaje="Código de error desconocido";
			break;
		}
		return mensaje;
	}
}
