package br.com.albinomoreira.utilitario;

/**
 * Implementação básica e imutável. Apenas guarda a mensagem.
 * 
 * @author Fabio Kung
 */
public class SimpleValidationMessage implements ValidationMessage {
    private final String message;

    public SimpleValidationMessage(String message) {
        this.message = message;
    }

    /**
     * @see br.com.albinomoreira.utilitario.ValidationMessage#getMessage()
     */
    public String getMessage() {
        return this.message;
    }
    
    @Override
    public String toString() {
    	return this.getMessage();
    }
}
