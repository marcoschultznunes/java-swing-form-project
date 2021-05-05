package fields;

import javax.swing.BorderFactory;
import javax.swing.text.JTextComponent;

public class InputField extends FormField{
	private static final long serialVersionUID = 7425536708396072157L;

	private JTextComponent formField; 
	
	public InputField(String fieldName, JTextComponent input) {
		super(fieldName);
		
		formField = input;
		formField.setPreferredSize(maxSize);
		formField.setMaximumSize(maxSize);
		formField.setMinimumSize(minSize);
		formField.setBorder(BorderFactory.createCompoundBorder(
			formField.getBorder(),
			BorderFactory.createEmptyBorder(0, 4, 0, 4)
		));
		
		addLayout(formField);
	}

	@Override
	public String getValue() {
		return this.label.getText() + formField.getText();
	}

}
