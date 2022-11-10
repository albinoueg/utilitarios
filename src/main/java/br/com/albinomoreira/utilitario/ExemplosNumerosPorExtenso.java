package br.com.albinomoreira.utilitario;

import br.com.albinomoreira.utilitario.format.CEPFormatter;
import br.com.albinomoreira.utilitario.format.CPFFormatter;
import br.com.albinomoreira.utilitario.format.Formatter;
import br.com.albinomoreira.utilitario.inwords.FormatoDeInteiro;
import br.com.albinomoreira.utilitario.inwords.FormatoDeReal;
import br.com.albinomoreira.utilitario.inwords.InteiroSemFormato;
import br.com.albinomoreira.utilitario.inwords.NumericToWordsConverter;
import br.com.albinomoreira.utilitario.validation.CPFValidator;

public class ExemplosNumerosPorExtenso {
    public static void main(String[] args) {
     /*   NumericToWordsConverter converter;
        converter = new NumericToWordsConverter(new FormatoDeInteiro());
        double numero = 1000150.99;
        String extenso = converter.toWords(numero);
        System.out.println(extenso);
        // um milhão e cento e cinquenta inteiros e novecentos e noventa milésimos

        NumericToWordsConverter converter;
        converter = new NumericToWordsConverter(new InteiroSemFormato());
        double numero = 1000150.99;
        String extenso = converter.toWords(numero);
        System.out.println(extenso);
        // um milhão e cento e cinquenta e um

        NumericToWordsConverter converter;
        converter = new NumericToWordsConverter(new FormatoDeReal());
        double numero = 1000150.99;
        String extenso = converter.toWords(numero);
        System.out.println(extenso);
        // um milhão e cento e cinquenta reais e noventa e nove centavos

      */

        Formatter formatter = new CPFFormatter();
        String unfotmatedValue = "67335828397";
        String formatedValue = formatter.format(unfotmatedValue);
        System.out.println(formatedValue);
        String unFormatedValue = formatter.unformat(formatedValue);
        System.out.println(unFormatedValue);
        System.out.println(formatter.canBeFormatted(unfotmatedValue));
        // formatedValue = "170.33259.50-4";


        CPFValidator cpfValidator = new CPFValidator();
        System.out.println(cpfValidator.generateRandomValid());
        System.out.println(cpfValidator.invalidMessagesFor(unFormatedValue));
    }
}
