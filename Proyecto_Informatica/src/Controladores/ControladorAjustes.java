package Controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.ws.Action;

import application.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControladorAjustes implements Initializable {
	
	@FXML
	private AnchorPane cuadrogeneral;
	@FXML
	private Pane cuadroazul;
	@FXML
	private Button botoncasa;
	@FXML
	private ImageView logocasa;
	@FXML
	private Button botonchat;
	@FXML
	private ImageView logochat;
	@FXML
	private Button botonajustes;
	@FXML
	private ImageView logoherramienta;
	@FXML
	private ImageView separador;
	@FXML
	private Label usasignados;
	@FXML
	private Pane panelgris;
	@FXML
	private TextArea textobasedatos;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Usuario> userList  = ControladorLogin.usuarios;
		StringBuilder myString = new StringBuilder();
		for(Usuario usuario : userList) {
			myString.append(usuario.getNick()+", ");
			myString.append(usuario.getContasena()+", ");
			myString.append("\n");
		}
		textobasedatos.setText(myString.toString());
	}
	
	//FUNCION ENTRAR EN LA ZONA DE CHAT
	public void sigchatad (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_chat_ad.fxml").toURI().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,1024,640);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			Stage log = (Stage) cuadrogeneral.getScene().getWindow();
			log.close();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//FUNCION ENTRAR EN LA ZONA DE CHAT
	public void sigcasa (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_prin_admin.fxml").toURI().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,1024,640);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			Stage log = (Stage) cuadrogeneral.getScene().getWindow();
			log.close();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}