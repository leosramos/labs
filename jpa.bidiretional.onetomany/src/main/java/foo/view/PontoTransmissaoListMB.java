package foo.view;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.On;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateBody;
import foo.business.PontoTransmissaoBC;
import foo.domain.PontoTransmissao;

@ViewController
public class PontoTransmissaoListMB extends AbstractListPageBean<PontoTransmissao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@Inject
	private PontoTransmissaoBC bc;

	@Override
	protected List<PontoTransmissao> handleResultList() {
		return bc.findAll();
	}

	@UpdateBody
	protected void onSave(@Observes @On("ponto.transmissao.edit.dialog.save") PontoTransmissao pt) {
		log.debug("Atualizando...");
		clear();
	}

}
