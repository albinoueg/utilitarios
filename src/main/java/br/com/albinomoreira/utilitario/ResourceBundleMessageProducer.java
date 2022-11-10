package br.com.albinomoreira.utilitario;

import br.com.albinomoreira.utilitario.validation.InvalidValue;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleMessageProducer implements MessageProducer {

    private final ResourceBundle bundle;

    /**
     * @param bundle ResourceBlunde que contém o mapa que associa erros 
     * 				as mensagens.
     */
    public ResourceBundleMessageProducer(final ResourceBundle bundle) {
        this.bundle = bundle;
    }
    
    public ValidationMessage getMessage(InvalidValue error) {
        Locale locale = bundle.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String key = messageKeyFor(locale, error.getClass(), error);
        String message;
        try {
            message = bundle.getString(key);
        } catch (MissingResourceException ex) {
            message = key.replaceFirst("[.]", " : ").replaceAll("_", " ");
        }
        return new SimpleValidationMessage(message);
    }

    /**
     * A chave padrao é gerada com base no nome da classe do erro e do nome do
     * erro, sempre minúscula. <br>
     * 
     * Ex.:
     * <ul>
     * 	<li>classe do erro: CPFError</li>
     * 	<li>nome do erro: INVALID_DIGITS</li>
     * </ul>
     * 
     * <p>
     * Chave gerada: <b>cpferror.invalid_digits</b>.
     * </p>
     * 
     * @param locale locale a ser usado na conversão para minúsculo
     * @param errorClass classe do tipo de erro
     * @param error erro
     * @return chave que representa o erro a ser usada para recuperar sua
     *         mensagem associada
     */
    public String messageKeyFor(Locale locale, Class<? extends InvalidValue> errorClass, InvalidValue error) {
        String simpleName = errorClass.getSimpleName();
        String errorName = error.name();
        String key = simpleName + "." + errorName;
        return key.toLowerCase(locale);
    }
}
