package br.com.albinomoreira.utilitario.type;

import br.com.albinomoreira.utilitario.MessageProducer;
import br.com.albinomoreira.utilitario.validation.Validator;
import br.com.albinomoreira.utilitario.validation.ie.*;

/**
 * Respresenta um estado brasileiro, ou o Destrito Federal.
 *
 * @author leobessa
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public enum Estado {

    AC(12) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAcreValidator(messageProducer, isFormatted);
        }
        
    },
    AL(27) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAlagoasValidator(messageProducer, isFormatted);
        }

    },
    AP(16) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAmapaValidator(messageProducer, isFormatted);
        }

    },
    AM(13) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEAmazonasValidator(messageProducer, isFormatted);
        }

    },
    BA(29) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEBahiaValidator(messageProducer, isFormatted);
        }

    },
    CE(23) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IECearaValidator(messageProducer, isFormatted);
        }

    },
    DF(53) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEDistritoFederalValidator(messageProducer, isFormatted);
        }

    },
    ES(32) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEEspiritoSantoValidator(messageProducer, isFormatted);
        }

    },
    GO(52) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEGoiasValidator(messageProducer, isFormatted);
        }

    },
    MA(21) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMaranhaoValidator(messageProducer, isFormatted);
        }

    },
    MT(51) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMatoGrossoValidator(messageProducer, isFormatted);
        }

    },
    MS(50) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMatoGrossoDoSulValidator(messageProducer, isFormatted);
        }

    },
    MG(31) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEMinasGeraisValidator(messageProducer, isFormatted);
        }

    },
    PA(15) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParaValidator(messageProducer, isFormatted);
        }

    },
    PB(25) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParaibaValidator(messageProducer, isFormatted);
        }

    },
    PR(41) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEParanaValidator(messageProducer, isFormatted);
        }

    },
    PE(26) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEPernambucoValidator(messageProducer, isFormatted);
        }

    },
    PI(22) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IEPiauiValidator(messageProducer, isFormatted);
        }

    },
    RJ(33) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioDeJaneiroValidator(messageProducer, isFormatted);
        }

    },
    RN(24) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioGrandeDoNorteValidator(messageProducer, isFormatted);
        }

    },
    RS(43) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERioGrandeDoSulValidator(messageProducer, isFormatted);
        }

    },
    RO(11) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERondoniaValidator(messageProducer, isFormatted);
        }

    },
    RR(14) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IERoraimaValidator(messageProducer, isFormatted);
        }

    },
    SC(42) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESantaCatarinaValidator(messageProducer, isFormatted);
        }

    },
    SP(35) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESaoPauloValidator(messageProducer, isFormatted);
        }

    },
    SE(28) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IESergipeValidator(messageProducer, isFormatted);
        }

    },
    TO(17) {
        public Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted) {
            return new IETocantinsValidator(messageProducer, isFormatted);
        }

    };

    private final int codigoIBGE;

	/**
     * Retorna um validador de Inscri????o Estadual.
     * 
     * @param messageProducer
     *            um produtor de mensagens.
     * @param isFormatted
     *            indicando se o validador deve considerar as cadeias como
     *            formatadas.
     * @return Validador de Inscri????o Estudual correspondente.
     */
    public abstract Validator<String> getIEValidator(MessageProducer messageProducer, boolean isFormatted);
    
    private Estado(int codigoIBGE) {
    	this.codigoIBGE = codigoIBGE;
	}
    
    public int getCodigoIBGE() {
		return codigoIBGE;
	}

    /**
	 * A regi??o do territ??rio brasileiro em que esse estado est?? localizado.
	 *
	 * @return Retorna a regi??o em que esse estado est?? localizado.
	 */
	public Regiao regiao() {
		Regiao[] regioes = Regiao.values();

		for (Regiao regiao : regioes) {
			if(regiao.compostaPor(this)) {
				return regiao;
			}
		}

		throw new IllegalStateException("N??o foi poss??vel determinar a regi??o do estado " + this);
	}

	/**
	 * Verifica se esse estado est?? localizado na regi??o informada.
	 *
	 * @param regiao Uma das regi??es do territ??rio brasileiro.
	 * @return Retorna {@code true} se esse estado pertencer ?? regi??o informada ou {@code false} caso contr??rio.
	 */
	public boolean localizadoEm(Regiao regiao) {
		return regiao() == regiao;
	}
}
