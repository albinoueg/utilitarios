package br.com.albinomoreira.utilitario;

import br.com.albinomoreira.utilitario.validation.InvalidValue;

public interface MessageProducer {
    ValidationMessage getMessage(InvalidValue invalidValue);
}
