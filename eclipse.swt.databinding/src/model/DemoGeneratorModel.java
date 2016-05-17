package model;

import jtools.eclipse.core.generator.GeneratorModel;

public class DemoGeneratorModel extends GeneratorModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static DemoGeneratorModel model;

	private DemoGeneratorModel() {
		super();
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static DemoGeneratorModel getInstance() {
		if (model == null) {
			model = new DemoGeneratorModel();
		}
		return model;
	}

	@Override
	protected void clear() {
		this.name = null;
	}

}
