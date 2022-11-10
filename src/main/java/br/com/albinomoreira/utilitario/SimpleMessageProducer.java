package br.com.albinomoreira.utilitario;

import br.com.albinomoreira.utilitario.validation.InvalidValue;

public class SimpleMessageProducer implements MessageProducer {

    public ValidationMessage getMessage(InvalidValue error) {
        String simpleName = error.getClass().getSimpleName();
        String errorName = error.name();
        String key = simpleName + "." + errorName;
        String message;
        message = key.replaceFirst("[.]", " : ").replaceAll("_", " ");
        return new SimpleValidationMessage(message);
    }
}
