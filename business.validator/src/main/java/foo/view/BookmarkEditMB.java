package foo.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.jus.tre_pa.jbase.jsf.validation.annotation.JSFValidationHandler;
import br.jus.tre_pa.jbase.jsf.workflow.annotation.UIAction;
import br.jus.tre_pa.jbase.jsf.workflow.context.UIService;
import foo.business.BookmarkBC;
import foo.domain.Bookmark;

@ViewController
@PreviousView("/bookmark_list.xhtml")
public class BookmarkEditMB extends AbstractEditPageBean<Bookmark, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookmarkBC bookmarkBC;

	@Inject
	private UIService service;

	@Override
	@Transactional
	public String delete() {
		this.bookmarkBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	@JSFValidationHandler
	public String insert() {
		this.bookmarkBC.insert(getBean());
		return getPreviousView();
	}

	@UIAction
	@Override
	@Transactional
	@JSFValidationHandler
	public String update() {
		this.bookmarkBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected Bookmark handleLoad(Long id) {
		return this.bookmarkBC.load(id);
	}

	public String highlight() {
		service.hightlightEffect("form1:f1");
		return null;
	}
}
