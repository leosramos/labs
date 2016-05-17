package foo.jpql.model;

/**
 * 
 * @author jcruz
 *
 */
public abstract class AbstractJPQLFragment {

	/**
	 * 
	 * @return
	 */
	public abstract String buildFragment();

	protected String replace(String str, Object... params) {
		return String.format(str, params);
	}

}
