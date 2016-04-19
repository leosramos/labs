package foo.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import foo.domain.LocalVotacao;

@PersistenceController
public class LocalVotacaoDAO extends JPACrud<LocalVotacao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
