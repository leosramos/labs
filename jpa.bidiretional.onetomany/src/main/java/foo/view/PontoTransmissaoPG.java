package foo.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.jus.tre_pa.jbase.jsf.layout.DocumentPageBean;
import br.jus.tre_pa.jbase.jsf.layout.UILayout;

@ViewController
public class PontoTransmissaoPG implements DocumentPageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UILayout layout;

	@Override
	public String load() {
		layout.setRendered("left", false);
		layout.setRendered("right", false);
		layout.setRendered("center.header", true);
		layout.setRendered("center.detail", true);
		return null;
	}

}
