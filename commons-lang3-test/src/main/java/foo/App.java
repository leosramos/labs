package foo;

import org.apache.commons.lang3.StringUtils;

public class App {

	public static void main(String[] args) {
		System.out.println(StringUtils.appendIfMissing("Atividade", "Page"));
		System.out.println(StringUtils.appendIfMissing("PontoPage", "Page"));
	}

}
