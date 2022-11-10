package br.com.albinomoreira.utilitario.validation.error;

import br.com.albinomoreira.utilitario.validation.InvalidValue;
public enum NITError implements InvalidValue {
    INVALID_CHECK_DIGITS, INVALID_DIGITS, REPEATED_DIGITS, INVALID_FORMAT
}
