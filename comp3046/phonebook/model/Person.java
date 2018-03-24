package comp3046.phonebook.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final IntegerProperty phone;
	private final StringProperty email;
	private final ObjectProperty<LocalDate> birthdate;
	
	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.phone = new SimpleIntegerProperty(98765432);
		this.email = new SimpleStringProperty("myname@gmail.com");
		this.birthdate = new SimpleObjectProperty<LocalDate>
		(LocalDate.of(1996, 2, 23));
		}
	
	public Person() {
		this(null, null);
	}
	public String getFirstName() {
		return firstName.get();
		}
		
		public void setFirstName(String firstName) {
		this.firstName.set(firstName);
		}
		
		public StringProperty firstNameProperty() {
		return firstName;
		}
		
		public String getLastName() {
			return lastName.get();
			}
			
			public void setLastName(String lastName) {
			this.lastName.set(lastName);
			}
			
			public StringProperty lastNameProperty() {
			return lastName;
			}
			
		
			public int getPhone() {
				return phone.get();
			}
				
			public void setPhone(int phone) {
				this.phone.set(phone);
			}
				
			public IntegerProperty phoneProperty() {
				return phone;
			}
	
			
			
			public String getEmail() {
				return email.get();
			}
				
			public void setEmail(String email) {
				this.email.set(email);
			}
				
			public StringProperty emailProperty() {
				return email;
			}
			
			
			
			public LocalDate getBirthdate() {
				return birthdate.get();
			}
				
			public void setBirthdate(LocalDate birthdate) {
				this.birthdate.set(birthdate);
			}
				
			public ObjectProperty birthdateProperty() {
				return birthdate;
			}
			
			
	
}
