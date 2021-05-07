package form;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fields.FormField;

public class FormPanel extends JPanel{
	private static final long serialVersionUID = 4410373794361096540L;
	
	private ArrayList<FormField> fields = new ArrayList<FormField>();
	private JButton submitButton = new SubmitButton("Submit", this);
	private Integer rows = 1;
	private Integer columns = 1;
	
	public FormPanel(List<FormField> fields, Integer maxY) {
		setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(20, 80, 20, 80),
			BorderFactory.createTitledBorder("Signup")
		));
		
		for(FormField field: fields) {
			this.fields.add(field);
		}
		
		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		for(int i = 0; i < fields.size(); i++) {
			// Span Y => 2
			if(fields.get(i).getSpanY() == 2) {
				gc.gridheight = 2;
				add(fields.get(i), gc);
				gc.gridy += 2;
			}
			else {
				add(fields.get(i), gc);
				gc.gridy++;
			}
			
			gc.gridheight = 1;
			
			// New Column
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
	
	public void submitForm() {
		for(FormField field: fields) {
			System.out.println(field.getValue());
		}
	}
}
