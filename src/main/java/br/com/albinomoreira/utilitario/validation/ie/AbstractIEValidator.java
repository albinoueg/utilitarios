package br.com.albinomoreira.utilitario.validation.ie;

import br.com.albinomoreira.utilitario.MessageProducer;
import br.com.albinomoreira.utilitario.ValidationMessage;
import br.com.albinomoreira.utilitario.validation.BaseValidator;
import br.com.albinomoreira.utilitario.validation.InvalidValue;
import br.com.albinomoreira.utilitario.validation.Validator;
import br.com.albinomoreira.utilitario.validation.error.IEError;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractIEValidator implements Validator<String> {

	protected final boolean isFormatted;
	private final BaseValidator baseValidator;

	public AbstractIEValidator() {
		this(true);
	}

	public AbstractIEValidator(boolean isFormatted) {
		this.isFormatted = isFormatted;
		this.baseValidator = new BaseValidator();
	}

	public AbstractIEValidator(MessageProducer messageProducer, boolean isFormatted) {
		this.baseValidator = new BaseValidator(messageProducer);
		this.isFormatted = isFormatted;
	}

	private List<InvalidValue> getInvalidValues(String IE) {
		List<InvalidValue> errors = new ArrayList<InvalidValue>();
		if (IE != null) {
			String unformattedIE = checkForCorrectFormat(IE, errors);
			if (errors.isEmpty()) {
				if (!hasValidCheckDigits(unformattedIE)) {
					errors.add(IEError.INVALID_CHECK_DIGITS);
				}
			}
		}
		return errors;
	}

	protected String checkForCorrectFormat(String ie, List<InvalidValue> errors) {
		String unformatedIE = null;
		if (isFormatted) {
			if (!(getFormattedPattern().matcher(ie).matches())) {
				errors.add(IEError.INVALID_FORMAT);
			}
			unformatedIE = ie.replaceAll("\\D", "");
		} else {
			if (!getUnformattedPattern().matcher(ie).matches()) {
				errors.add(IEError.INVALID_DIGITS);
			}
			unformatedIE = ie;
		}
		return unformatedIE;
	}

	protected abstract Pattern getUnformattedPattern();

	protected abstract Pattern getFormattedPattern();

	public boolean isEligible(String value) {
		boolean result;
		if (isFormatted) {
			result = getFormattedPattern().matcher(value).matches();
		} else {
			result = getUnformattedPattern().matcher(value).matches();
		}
		return result;
	}

	public void assertValid(String IE) {
		baseValidator.assertValid(getInvalidValues(IE));
	}

	public List<ValidationMessage> invalidMessagesFor(String IE) {
		return baseValidator.generateValidationMessages(getInvalidValues(IE));
	}

	protected abstract boolean hasValidCheckDigits(String value);

	protected String format(String value, String pattern, String validCharacters) {
		try {
			final MaskFormatter formatador = new MaskFormatter(pattern);
			formatador.setValidCharacters(validCharacters);
			formatador.setValueContainsLiteralCharacters(false);
			return formatador.valueToString(value);
		} catch (ParseException e) {
			throw new RuntimeException("Valor gerado n??o bate com o padr??o: " + value, e);
		}
	}

	protected String format(String value, String pattern) {
		return this.format(value, pattern, "1234567890");
	}
}