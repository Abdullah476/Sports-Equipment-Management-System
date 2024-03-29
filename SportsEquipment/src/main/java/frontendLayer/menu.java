package frontendLayer;

import buisnessLayer.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Thread.sleep;

public class menu {
	@FXML
	TextField fx_name;
	@FXML
	private DatePicker fx_DOB;
	@FXML
	private ImageView closeButton;
	@FXML
	private ImageView minimizeButton;

	Stage stage;
	LocalDate dobDate;
	String name;

	@FXML
	void dateClicked() {
		dobDate = fx_DOB.getValue();
	}

	void getStage(Stage stage){
		this.stage = stage;
		closeButton.setOnMouseClicked(mouseEvent -> stage.close());
		minimizeButton.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
	}


	@FXML
	void logout () throws IOException {
		//CALLING LOGIN SCREEN
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 509, 552);
		stage.setScene(scene);
		((login) fxmlLoader.getController()).getStage(stage);
		stage.show();
	}

	@FXML
	void updateProfile() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("updatePersonalInfo.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 509, 552);
		stage.setScene(scene);
		((updatePersonalInformation) fxmlLoader.getController()).getStage(stage);
		stage.show();
	}

	@FXML
	void updateCredentials() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("updateCredential.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 509, 552);
		stage.setScene(scene);
		((updateCredentials) fxmlLoader.getController()).getStage(stage);
		stage.show();
	}

	@FXML
	void issueItem() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("issueEquipment.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 509, 552);
		stage.setScene(scene);
		((issueEquipment) fxmlLoader.getController()).getStage(stage);
		stage.show();
	}

	@FXML
	void returnItem() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("returnEquipment.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 509, 552);
		stage.setScene(scene);
		((returnEquipment) fxmlLoader.getController()).getStage(stage);
		stage.show();
	}


	@FXML
	void bookFootballfield() throws InterruptedException, IOException {
		if (Controller.bookFootballfield()) {
			FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("footballfieldBooked.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 509, 552);
			stage.setScene(scene);
			((message) fxmlLoader.getController()).getStage(stage);
			stage.show();
		}
		else {
			FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("footballfieldUnavailable.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 509, 552);
			stage.setScene(scene);
			((message) fxmlLoader.getController()).getStage(stage);
			stage.show();
		}
	}

	@FXML
	void bookCricketfield() throws InterruptedException, IOException {
		if (Controller.bookCricketfield()) {
			FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cricketfieldBooked.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 509, 552);
			stage.setScene(scene);
			((message) fxmlLoader.getController()).getStage(stage);
			stage.show();
		}
		else {
			FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cricketfieldUnavailable.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 509, 552);
			stage.setScene(scene);
			((message) fxmlLoader.getController()).getStage(stage);
			stage.show();
		}
	}

	@FXML
	void logs() throws IOException, InterruptedException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logs.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 509, 552);
		stage.setScene(scene);
		((logs) fxmlLoader.getController()).getStage(stage);
		stage.show();
	}


	@FXML
	protected void createAccount( ) throws IOException {
		name = fx_name.getText();

		if (name != null && dobDate != null) {
			Controller.updatePersonalInfo(name, dobDate.toString());

			//CALLING LOGIN SCREEN
			FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 509, 552);
			stage.setScene(scene);
			((login) fxmlLoader.getController()).getStage(stage);
			stage.show();
		}
		System.out.println("Name: " + name);
		System.out.println("DOB: " + dobDate.toString());
	}
}
