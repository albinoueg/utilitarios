package br.com.albinomoreira.utilitario.validation.ie;

import br.com.albinomoreira.utilitario.*;
import br.com.albinomoreira.utilitario.validation.LogicOrComposedValidator;
import br.com.albinomoreira.utilitario.validation.Validator;
import br.com.albinomoreira.utilitario.validation.error.IEError;

import java.util.ArrayList;
import java.util.List;

public class IEPernambucoValidator implements Validator<String> {

	private final LogicOrComposedValidator<String> baseValidator;

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEPernambucoValidator() {
		this(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEPernambucoValidator(boolean isFormatted) {
		this(new SimpleMessageProducer(), isFormatted);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IEPernambucoValidator(MessageProducer messageProducer, boolean isFormatted) {
		Class[] validatorClasses = { IEPernambucoNovaValidator.class, IEPernambucoAntigaValidator.class };
		this.baseValidator = new LogicOrComposedValidator<String>(messageProducer, isFormatted, validatorClasses);
		this.baseValidator.setInvalidFormat(IEError.INVALID_FORMAT);
	}

	public void assertValid(String value) {
		if (value != null) {
			baseValidator.assertValid(value);
		}
	}

	public List<ValidationMessage> invalidMessagesFor(String value) {
		List<ValidationMessage> result;
		if (value != null) {
			result = baseValidator.invalidMessagesFor(value);
		} else {
			result = new ArrayList<ValidationMessage>();
		}
		return result;
	}

	public boolean isEligible(String object) {
		return baseValidator.isEligible(object);
	}

	/**
	 * @see Validator#generateRandomValid()
	 * @see LogicOrComposedValidator#generateRandomValid()
	 * @return uma inscrição estadual válida de acordo com o novo padrão de
	 *         Pernambuco
	 */
	@Override
	public String generateRandomValid() {
		return baseValidator.generateRandomValid();
	}
}