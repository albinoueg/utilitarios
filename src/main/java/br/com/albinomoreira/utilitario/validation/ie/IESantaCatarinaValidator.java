package br.com.albinomoreira.utilitario.validation.ie;

import br.com.albinomoreira.utilitario.DigitoGenerator;
import br.com.albinomoreira.utilitario.DigitoPara;
import br.com.albinomoreira.utilitario.MessageProducer;
import br.com.albinomoreira.utilitario.SimpleMessageProducer;

import java.util.regex.Pattern;

public class IESantaCatarinaValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("\\d{3}(\\.?\\d{3}){2}");

	public static final Pattern UNFORMATED = Pattern.compile("\\d{9}");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IESantaCatarinaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IESantaCatarinaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IESantaCatarinaValidator(MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer, isFormatted);
	}

	@Override
	protected Pattern getUnformattedPattern() {
		return UNFORMATED;
	}

	@Override
	protected Pattern getFormattedPattern() {
		return FORMATED;
	}

	protected boolean hasValidCheckDigits(String unformattedIE) {
		String iESemDigito = unformattedIE.substring(0, unformattedIE.length() - 1);
		String digito = unformattedIE.substring(unformattedIE.length() - 1);

		String digitoCalculado = calculaDigito(iESemDigito);

		return digito.equals(digitoCalculado);
	}

	private String calculaDigito(String iESemDigito) {
		DigitoPara digitoPara = new DigitoPara(iESemDigito);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11);

		return digitoPara.calcula();
	}

	@Override
	public String generateRandomValid() {
		final String ieSemDigito = new DigitoGenerator().generate(8);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return super.format(ieComDigito, "###.###.###");
		}
		return ieComDigito;
	}
}
