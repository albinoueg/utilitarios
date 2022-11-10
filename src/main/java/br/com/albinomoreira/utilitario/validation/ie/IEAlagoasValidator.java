package br.com.albinomoreira.utilitario.validation.ie;

import br.com.albinomoreira.utilitario.DigitoGenerator;
import br.com.albinomoreira.utilitario.DigitoPara;
import br.com.albinomoreira.utilitario.MessageProducer;

import java.util.regex.Pattern;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a>
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_AL.html">SINTEGRA -
 * ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
public class IEAlagoasValidator extends AbstractIEValidator {

	public static final Pattern FORMATED = Pattern.compile("24(\\.\\d{3}){2}\\-\\d{1}");

	public static final Pattern UNFORMATED = Pattern.compile("24\\d{7}");

	public IEAlagoasValidator() {
		super(true);
	}

	public IEAlagoasValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEAlagoasValidator(MessageProducer messageProducer, boolean isFormatted) {
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
		final String ieSemDigito = "24" + new DigitoGenerator().generate(6);
		final String ieComDigito = ieSemDigito + calculaDigito(ieSemDigito);
		if (isFormatted) {
			return super.format(ieComDigito, "##.###.###-#");
		}
		return ieComDigito;
	}
}
