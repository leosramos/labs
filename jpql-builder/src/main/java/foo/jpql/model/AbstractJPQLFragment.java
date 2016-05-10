package foo.jpql.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractJPQLFragment {

	private Map<String, String> params;

	/**
	 * 
	 * @return
	 */
	public abstract String buildFragment();

	public Map<String, String> getParams() {
		if (this.params == null) {
			this.params = new HashMap<>();
		}
		return params;
	}

	protected String replace(String str, Object... params) {
		return String.format(str, params);
	}

}
