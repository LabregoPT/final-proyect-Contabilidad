package exceptions;

@SuppressWarnings("serial")
public class NoDataException extends Exception{

	public NoDataException() {
       super("No hay datos para hacer los calculos necesarios");	
	}

}
