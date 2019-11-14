package br.com.clientes.exception;

public class ClientesNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public ClientesNotFound(String msg) {
        super(msg);
    }

    public ClientesNotFound(String msg, Throwable cause) {
        super(msg, cause);
    }

}
