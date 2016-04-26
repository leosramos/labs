package foo.business.validator;

import br.jus.tre_pa.jbase.jsf.validation.BusinessValidator;
import br.jus.tre_pa.jbase.jsf.validation.exception.BusinessValidationException;
import foo.domain.Bookmark;

/**
 * 
 * @author jcruz
 *
 */
public class BookmarkHasLinkValidator extends BusinessValidator<Bookmark> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Override
	public void validate(Bookmark bean) throws BusinessValidationException {
		if (bean.getLink() != null) {
			if (bean.getLink().length() < 3) {
				fail("Link deve possuir mais de 3 caracteres");
			}
		}
	}
}
