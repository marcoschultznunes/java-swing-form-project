package form;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import fields.ComboBoxField;
import fields.FormField;
import fields.InputField;
import fields.ListField;
import fields.RadioField;

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
		
		ComboBoxField genderField = new ComboBoxField("Gender", Arrays.asList(
			"Male", "Female", "Other"
		));
		
		RadioField roleField = new RadioField("Role", Arrays.asList("User", "Admin", "Other"));
		
		ListField hierarchyField = new ListField("Occupation", 
			Arrays.asList(
				"Trainee", "Staff", "Employee", "Manager", "CEO", "Director", "VP", "President"
			), ListSelectionModel.SINGLE_SELECTION
		);
		
		List<FormField> fields = Arrays.asList(
			nameField, surnameField, emailField, passwordField, rgField, occupationField, genderField, 
			roleField, hierarchyField
		);
		
		FormPanel form = new FormPanel(fields, 5);
		
		tabbedPane.add("Form", form);
		window.add(tabbedPane);
		window.setSize(1024, 728);
		window.setVisible(true);
	}

}
