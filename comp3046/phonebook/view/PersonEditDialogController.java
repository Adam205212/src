package comp3046.phonebook.view;

import comp3046.phonebook.model.Person;
import comp3046.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField birthdateField;
	private Person person;

	@FXML
	private void initialize() {
	}

	private Stage dialogStage;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	private boolean okClicked = false;

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setPhone(Integer.parseInt(phoneField.getText()));
			person.setEmail(emailField.getText());
			person.setBirthdate(DateUtil.parse(birthdateField.getText()));
			okClicked = true;
			dialogStage.close();
		}
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (phoneField.getText() == null || phoneField.getText().length() == 0) {
			errorMessage += "No valid phone!\n";
		} else {
			// try to parse the phone into an int.
			try {
				Integer.parseInt(phoneField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid phone (must be an integer)!\n";
			}
		}
		if (emailField.getText() == null || emailField.getText().length() == 0) {
			errorMessage += "No valid email!\n";
		}
		if (birthdateField.getText() == null || birthdateField.getText().length() == 0) {
			errorMessage += "No valid birthdate!\n";
		} else {
			if (!DateUtil.validDate(birthdateField.getText())) {
				errorMessage += "No valid birthdate. " + "Use the format dd.mm.yyyy!\n";
			}
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;
		}
	}

	public void setPerson(Person person) {
		this.person = person;

		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		phoneField.setText(Integer.toString(person.getPhone()));
		emailField.setText(person.getEmail());
		birthdateField.setText(DateUtil.format(person.getBirthdate()));
		birthdateField.setPromptText("dd.mm.yyyy");
	}
}
