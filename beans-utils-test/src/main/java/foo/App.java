package foo;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Model model = new Model();

		model.getInputQry().put("nome", "José Ribamar");
		// System.out.println(BeanUtils.describe(model));

		Map<String, String> propertyMap = BeanUtils.describe(model);

		Iterator<String> iter = propertyMap.keySet().iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key);

			System.out.println("=================================");

		}
		System.out.println(BeanUtils.getMappedProperty(model, "inputQry", "nome"));
	}
}
