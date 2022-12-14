package br.com.albinomoreira.utilitario.validation;

import br.com.albinomoreira.utilitario.MessageProducer;
import br.com.albinomoreira.utilitario.SimpleMessageProducer;
import br.com.albinomoreira.utilitario.ValidationMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Esta classe serve como base para validadores utilizados no Caelum Stella
 * Core. Ela é responsável por extrair {@linkplain ValidationMessage} de um
 * {@link MessageProducer}.
 * </p>
 * <p>
 * O {@link MessageProducer} pode ser passado pelo construtor. Assim, através
 * dos métodos {@link #generateValidationMessages(List)} e
 * {@link #assertValid(List)} as mensagens de validação são geradas.
 * </p>
 * 
 * @author leobessa
 */
public class BaseValidator {
    private final MessageProducer messageProducer;

    /**
     * Utiliza um {@linkplain SimpleMessageProducer}.
     */
    public BaseValidator() {
        this.messageProducer = new SimpleMessageProducer();
    }

    /**
     * @param messageProducer
     *            produtor das mensagens de validação.
     */
    public BaseValidator(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    /**
     * @param invalidValues
     *            lista de valores que descrevem erros de validação.
     * @return lista de mensagens inválidas obtida pelo produto de mensagem.
     */
    public List<ValidationMessage> generateValidationMessages(List<InvalidValue> invalidValues) {
        List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
        for (InvalidValue invalidValue : invalidValues) {
            ValidationMessage message = messageProducer.getMessage(invalidValue);
            messages.add(message);
        }
        return messages;
    }

    /**
     * @param invalidValues
     *            lista de valores que descrevem erros de validação.
     * @throws InvalidStateException
     *             caso a lista não esteja vazia.
     */
    public void assertValid(List<InvalidValue> invalidValues) {
        if (!invalidValues.isEmpty()) {
            throw new InvalidStateException(generateValidationMessages(invalidValues));
        }
    }

}