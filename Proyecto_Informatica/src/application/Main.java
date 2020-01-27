package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import Controladores.*;
import Pantallas.*;

import java.io.File;
import java.net.URL;
import java.util.List;

import Base_Datos.*;
import Resources.*;




public class Main extends Application {
	
	private static Usuario currentUser;
	private static List<Casa> casas;
	private static List<Medicion> mediciones;
	
	public static void setCurrentUser(Usuario usuario) {
		currentUser=usuario;
	}
	
	public static Usuario getCurrentUser() {
		return currentUser;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/Pantallas/pantalla_login.fxml").toURI().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,1024,640);
			//String css = this.getClass().getResource("src/Resources/application.css").toExternalForm();
			//scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}