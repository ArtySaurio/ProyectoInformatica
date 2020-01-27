package Controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorPerfil implements Initializable{

	@FXML
	private AnchorPane cuadro;
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
	private ImageView separador;
	@FXML
	private Button botonperf;
	@FXML
	private ImageView logoperf;
	@FXML
	private ImageView imagenperf;
	@FXML
	private GridPane panelinfo;
	@FXML
	private Label nickname;
	@FXML
	private Label poweruser;
	@FXML
	private Label contrasena;
	@FXML
	private Label nacionalidad;
	@FXML
	private ImageView espana;
	@FXML
	private Label nicknameinfo;
	@FXML
	private Label poweruserinfo;
	@FXML
	private Label contrasenainfo;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources){
		
		Image risitas = new Image ("/Resources/risitas.jpg");
		Image rivera = new Image ("/Resources/rivera.jpg");
		Image harambe = new Image ("/Resources/harambe.jpg");
		
		Usuario usuario = Main.getCurrentUser();
		nicknameinfo.setText(usuario.getNick());
		contrasenainfo.setText(usuario.getContasena());
		poweruserinfo.setText("No");
		//imagenperf.setImage(risitas);
		
		if (usuario.getNick().equals("Usuario1")) {
			imagenperf.setImage(risitas);
		}else if (usuario.getNick().equals("Usuario2")) {
			imagenperf.setImage(rivera);
		}else if(usuario.getNick().equals("Usuario3")) {
			imagenperf.setImage(harambe);
		}
		
	}
	
	
	//FUNCION PARA IR A LA VENTANA DE CHAT
	public void sigchat (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_chat.fxml").toURI().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,1024,640);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			Stage log = (Stage) cuadro.getScene().getWindow();
			log.close();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//FUNCION VOLVER A LA PAGINA PRINCIPAL
	public void sigcasa (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_prin.fxml").toURI().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,1024,640);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			Stage log = (Stage) cuadro.getScene().getWindow();
			log.close();
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
