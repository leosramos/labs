package foo;

import java.util.HashMap;
import java.util.Map;

public class Model {

	private Map<String, String> inputQry;

	public Map<String, String> getInputQry() {
		if(this.inputQry == null) {
			this.inputQry = new HashMap<String, String>();
		}
		return inputQry;
	}

	public void setInputQry(Map<String, String> inputQry) {
		this.inputQry = inputQry;
	}

}
