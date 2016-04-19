package foo.view;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.jus.tre_pa.jbase.jsf.template.Editable;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UIAction;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateBody;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UpdateRegion;
import foo.business.PontoTransmissaoBC;
import foo.domain.LocalVotacao;
import foo.domain.PontoTransmissao;

@ViewController
public class PontoTransmissaoEditDialogMB extends AbstractEditPageBean<PontoTransmissao, Long> implements Editable<PontoTransmissao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PontoTransmissaoBC bc;

	@Inject
	private Logger log;

	@Override
	public String delete() {
		return null;
	}

	@UIAction
	@Override
	public String insert() {
		bc.insert(getBean());
		return null;
	}

	@UIAction
	@Override
	public String update() {
		log.debug("[update] Before {}", getBean());
		PontoTransmissao pt = bc.update(getBean());
		log.debug("[update] After {}", pt);
		return null;
	}

	@Override
	protected PontoTransmissao handleLoad(Long arg0) {
		return null;
	}

	@Override
	public PontoTransmissao getEventTargetBean() {
		return this.getBean();
	}

	@UIAction
	@Override
	public String save() {
		if (getBean().getId() == null) {
			this.insert();
			return null;
		}
		this.update();
		return null;
	}

	@UIAction
	@Override
	public String load(Long id) {
		setBean(bc.load(id));
		return null;
	}

	@UIAction
	@Override
	public String cancel() {
		return null;
	}

	@UIAction
	@Override
	public String create() {
		setBean(new PontoTransmissao());
		return null;
	}

	@UIAction
	@Override
	public String fetch(Long id) {
		return null;
	}
	
	/*
	@UpdateRegion(id = "lvlist_id")
	public String removeLocalVotacao(LocalVotacao lv) {
		//lv.setPontoTransmissao(null);
		getBean().getLocaisVotacao().remove(lv);
		return null;
	}
	*/
}
