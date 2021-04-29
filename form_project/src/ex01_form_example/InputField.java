package ex01_form_example;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

public class InputField extends JPanel{
	private static final long serialVersionUID = 7425536708396072157L;

	private JLabel label;
	public JTextComponent textField; 
	
	public InputField(String fieldName, JTextComponent input) {
		label = new JLabel(fieldName + ":");
		textField = input;
		textField.setLayout(null);
		textField.setPreferredSize(new Dimension(300, 30));
		textField.setMaximumSize(new Dimension(300, 30));
		textField.setMinimumSize(new Dimension(150, 20));
		textField.setBorder(BorderFactory.createCompoundBorder(
			textField.getBorder(),
			BorderFactory.createEmptyBorder(0, 4, 0, 4)
		));
		
		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);

		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 0;
		gc.gridy = 0;
		add(label, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy++;
		add(textField, gc);
	}

}
