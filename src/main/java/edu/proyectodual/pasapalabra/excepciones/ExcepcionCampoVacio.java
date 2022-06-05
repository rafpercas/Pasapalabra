package edu.proyectodual.pasapalabra.excepciones;

public class ExcepcionCampoVacio extends Exception{
    private final static String MESSAGE = "Exception personal";

    public ExcepcionCampoVacio(String message) {
        super(MESSAGE +": "+message);
    }
}
