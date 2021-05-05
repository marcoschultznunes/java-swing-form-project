package fields;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import sizes.Sizes;

public class RadioField extends FormField{
	private static final long serialVersionUID = 9147593834345715609L;
	
	private JPanel container = new JPanel(new GridBagLayout());
	private ButtonGroup btnGroup = new ButtonGroup();

	public RadioField(String fieldName, List<String> options) {
		super();
		this.label = new JLabel(" " + fieldName + " ");
		
		for(String opt: options) {
			JRadioButton button = new JRadioButton(opt);
			button.setActionCommand(opt);
			btnGroup.add(button);
			
			GridBagConstraints gc = new GridBagConstraints();
			gc.anchor = GridBagConstraints.CENTER;
			
			container.add(button, gc);
		}
		
		addLayout(container);
	}

	
	@Override
	protected void addLayout(JComponent formField) {
		Color borderColor = new Color(122, 138, 153);
		
		container.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createLineBorder(borderColor, 1, false),
			this.label.getText(),
			TitledBorder.CENTER,
			TitledBorder.CENTER
		));
		container.setPreferredSize(new Dimension(
			Sizes.DEFAULT_MAX_WIDTH, (int)(Sizes.DEFAULT_MAX_HEIGHT * 1.5)
		));
		container.setMinimumSize(new Dimension(
			(int)(Sizes.DEFAULT_MIN_WIDTH * 1.5), (int)(Sizes.DEFAULT_MAX_HEIGHT * 1.5)
		));
		
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		gc.anchor = GridBagConstraints.CENTER;
		add(formField, gc);
	}



	@Override
	public String getValue() {
		return this.label.getText().trim() + ": " + this.btnGroup.getSelection().getActionCommand();
	}

}
