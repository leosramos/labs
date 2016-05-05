package dialog;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import model.GeneratorModel;

public class GeneratorWizard extends Wizard {

	public GeneratorWizard() {
		super();
		addPage(new GeneratorWizardPage("Gerador de DAOs"));
	}

	@Override
	public boolean performFinish() {

		GeneratorModel generatorModel = GeneratorModel.getInstance();

		MessageDialog.openInformation(null, "Valor", generatorModel.getName());

		return true;
	}

}
