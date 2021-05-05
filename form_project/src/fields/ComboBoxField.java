package fields;

import java.util.List;

import javax.swing.JComboBox;

public class ComboBoxField extends FormField{
	private static final long serialVersionUID = -6513146539753491651L;

	private JComboBox<String> comboBox;

	public ComboBoxField(String fieldName, List<String> options) {
		super(fieldName);
		
		comboBox = new JComboBox<String>(options.toArray(new String[options.size()]));
		comboBox.setPreferredSize(maxSize);
		comboBox.setMinimumSize(minSize);
		
		addLayout(comboBox);
	}

	@Override
	public String getValue() {
		return this.label.getText() + comboBox.getSelectedItem().toString();
	}
	
}
