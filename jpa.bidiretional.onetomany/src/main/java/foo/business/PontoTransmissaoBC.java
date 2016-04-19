package foo.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import foo.domain.PontoTransmissao;
import foo.persistence.PontoTransmissaoDAO;

@BusinessController
public class PontoTransmissaoBC extends DelegateCrud<PontoTransmissao, Long, PontoTransmissaoDAO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
