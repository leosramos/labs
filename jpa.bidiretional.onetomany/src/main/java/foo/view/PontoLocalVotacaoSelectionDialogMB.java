package foo.view;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.jus.tre_pa.jbase.jsf.template.AbstractMultipleSelectionDialogPageBean;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.Hide;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.On;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.Show;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateBody;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateFooter;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateHeader;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateRegion;
import foo.business.LocalVotacaoBC;
import foo.domain.LocalVotacao;
import foo.domain.PontoTransmissao;

@ViewController
public class PontoLocalVotacaoSelectionDialogMB extends AbstractMultipleSelectionDialogPageBean<PontoTransmissao, LocalVotacao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private LocalVotacaoBC bc;

	@Override
	@Show
	@UpdateBody
	@UpdateFooter
	@UpdateHeader
	public String load(PontoTransmissao bean) {
		return super.load(bean);
	}

	/**
	 * 
	 * @return
	 */
	@Override
	@Hide
	@UpdateRegion(forClass = PontoTransmissaoEditDialogMB.class, id = "lvlist_id")
	public String done() {
		return super.done();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	protected List<LocalVotacao> handleTarget() {
		return getBean().getLocaisVotacao();
	}

	/**
	 * 
	 * @return
	 */
	@Override
	protected List<LocalVotacao> handleSource() {
		return bc.findAll();
	}

	/**
	 * 
	 * @param bean
	 */
	@Override
	protected void onCancelBean(@Observes @On("ponto.transmissao.edit.dialog.cancel") PontoTransmissao bean) {
		clear();
	}

}
