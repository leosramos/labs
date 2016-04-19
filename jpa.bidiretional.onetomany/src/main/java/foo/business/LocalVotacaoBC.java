package foo.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import foo.domain.LocalVotacao;
import foo.persistence.LocalVotacaoDAO;

@BusinessController
public class LocalVotacaoBC extends DelegateCrud<LocalVotacao, Long, LocalVotacaoDAO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
