package fields;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static sizes.Sizes.*;

public abstract class FormField extends JPanel{
	private static final long serialVersionUID = -5593184588494177575L;
	
	protected JLabel label;
	protected Dimension maxSize = new Dimension(DEFAULT_MAX_WIDTH, DEFAULT_MAX_HEIGHT);
	protected Dimension minSize = new Dimension(DEFAULT_MIN_WIDTH, DEFAULT_MIN_HEIGHT);
	protected Integer spanY = 1;
	
	public FormField() {
		
	}
	
	public FormField(String fieldName) {
		label = new JLabel(fieldName + ": ");
	}

	protected void addLayout(JComponent formField) {
		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);

		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 0;
		gc.gridy = 0;
		add(label, gc);
		
		gc.gridy++;
		add(formField, gc);
	}
	
	public abstract String getValue();
	
	public int getSpanY() {
		return this.spanY;
	}
}
