package dialog;

import jtools.eclipse.core.generator.GeneratorWizard;
import model.DemoGeneratorModel;

public class DemoGeneratorWizard extends GeneratorWizard<DemoGeneratorModel> {

	DemoGeneratorModel generatorModel = DemoGeneratorModel.getInstance();

	public DemoGeneratorWizard() {
		super();
		addPage(new DemoGeneratorWizardPage("Gerador de DAOs", generatorModel));
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
