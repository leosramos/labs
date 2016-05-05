package model;

public class GeneratorModel {

	private static GeneratorModel model;

	private GeneratorModel() {
		super();
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static GeneratorModel getInstance() {
		if (model == null) {
			model = new GeneratorModel();
		}
		return model;
	}

}
