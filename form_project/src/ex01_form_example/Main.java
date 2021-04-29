package ex01_form_example;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame("JLabel");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		InputField nameField = new InputField("Name", new JTextField());
		InputField surnameField = new InputField("Surname", new JTextField());
		InputField emailField = new InputField("Email", new JTextField());
		InputField passwordField = new InputField("Password", new JPasswordField());
		InputField rgField = new InputField("RG", new JTextField());
		InputField occupationField = new InputField("Occupation", new JTextField());
		
		List<InputField> fields = Arrays.asList(
			nameField, surnameField, emailField, passwordField, rgField, occupationField
		);
		
		FormPanel form = new FormPanel(fields, 5);
		
		tabbedPane.add("Form", form);
		window.add(tabbedPane);
		window.setSize(1024, 728);
		window.setVisible(true);
	}

}
