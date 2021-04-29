package ex01_form_example;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FormPanel extends JPanel{
	private static final long serialVersionUID = 4410373794361096540L;
	
	private ArrayList<InputField> fields = new ArrayList<InputField>();
	private JButton submitButton = new JButton("Submit");
	private Integer rows = 1;
	private Integer columns = 1;
	
	public FormPanel(List<InputField> fields, Integer maxY) {
		setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(20, 80, 20, 80),
			BorderFactory.createTitledBorder("Signup")
		));
		
		for(InputField field: fields) {
			this.fields.add(field);
		}
		
		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		for(int i = 0; i < fields.size(); i++) {
			add(fields.get(i), gc);
			gc.gridy++;
			
			if(gc.gridy >= maxY) {
				gc.gridx++;
				gc.gridy = 0;
				this.columns++;
			}
			else {
				this.rows++;
			}
		}
		
		gc.gridx = 0;
		gc.gridy = this.rows;
		gc.gridwidth = this.columns;
		add(submitButton, gc);
	}
}
