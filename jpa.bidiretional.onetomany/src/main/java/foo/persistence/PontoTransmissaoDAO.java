package foo.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import foo.domain.PontoTransmissao;

@PersistenceController
public class PontoTransmissaoDAO extends JPACrud<PontoTransmissao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
