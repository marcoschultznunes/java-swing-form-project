package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SubmitButton extends JButton{
	private static final long serialVersionUID = 8173557996920669019L;

	public SubmitButton(String text, FormPanel form) {
		super(text);
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				form.submitForm();
			}
		});
	}
}
