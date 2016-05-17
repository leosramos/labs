package dialog;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import jtools.eclipse.core.generator.GeneratorWizardPage;
import model.DemoGeneratorModel;

public class DemoGeneratorWizardPage extends GeneratorWizardPage<DemoGeneratorModel> {

	protected DemoGeneratorWizardPage(String pageName, DemoGeneratorModel model) {
		super(pageName, model);
	}

	@Override
	public void createControl(Composite parent) {
		DataBindingContext ctx = new DataBindingContext();
		
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText("&Container:");

		Text containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);

		IObservableValue target = WidgetProperties.text(SWT.Modify).observe(containerText);

		IObservableValue model = BeanProperties.value(DemoGeneratorModel.class, "name").observe(DemoGeneratorModel.getInstance());

		ctx.bindValue(target, model);

		setControl(container);
	}

}
