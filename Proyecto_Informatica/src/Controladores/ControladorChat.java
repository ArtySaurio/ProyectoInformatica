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
import java.util.ResourceBundle;

import javax.xml.ws.Action;

import application.Main;
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

public class ControladorChat implements Initializable {

	ObservableList<String> eleccionremitente = FXCollections.observableArrayList("Usuario1","Usuario2","Usuario3");
	ObservableList<String> elecciondestinatario = FXCollections.observableArrayList("Usuario1","Usuario2","Usuario3","Admin1");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	LocalDate fechah = LocalDate.now();
	LocalTime horah = LocalTime.now();
	
	@FXML
	private AnchorPane cuadrogeneral;
	@FXML
	private Label textodestinatario;
	@FXML
	private Label textoremitente;
	@FXML
	private Button enviarmensaje;
	@FXML
	private ChoiceBox remitente;
	@FXML
	private ChoiceBox destinatario;
	@FXML
	private TextField mensaje;
	@FXML
	private Label bandejaentrada;
	@FXML
	private Label enviomensajes;
	@FXML
	private Pane cuadroazul;
	@FXML
	private Button back;
	@FXML
	private Label chat;
	@FXML
	private ImageView carta;
	@FXML
	private ImageView flecha;
	@FXML
	private TextArea entradamensajes;
	@FXML
	private Button botonrefresh;
	@FXML
	private ImageView imgrefresh;
	@FXML
	private Label estatus;
	@FXML
	private Button botoncasa;
	@FXML
	private Button botonperf;
	@FXML
	private ImageView logoperf;
	
	private String filePath = "src/Base_Datos/Chat.txt";
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		remitente.setItems(eleccionremitente);
		destinatario.setItems(elecciondestinatario);
		Usuario usuario = Main.getCurrentUser();
		remitente.setValue(usuario.getNick());
	}
	
	
	//FUNCION PARA LA ESCRITURA DEL MENSAJE
	public void enviar (ActionEvent event) {
		
		if ((remitente.getValue() == null) || (destinatario.getValue() == null) || ((remitente.getValue() == null) && (destinatario.getValue() == null))) {
			estatus.setText("Error");
		}else {
			try(FileWriter fileWriter = new FileWriter(filePath, true)) {
				BufferedWriter bw = new BufferedWriter(fileWriter);
			    PrintWriter out = new PrintWriter(bw);
				String fileContent = "(" + horah + ") " + remitente.getValue() + " a " 
			    + destinatario.getValue() +  ": " + mensaje.getText() + "\n";
			    fileWriter.write(fileContent);
			    estatus.setText(" ");
			    String text = "";
				try (FileReader reader = new FileReader("src/Base_Datos/Chat.txt");
			             BufferedReader br = new BufferedReader(reader)) {
			            String line;
			            while ((line = br.readLine()) != null) {
			            	text = text + line + "\n";
			            }
			        } catch (IOException e) {
			            System.err.format("IOException: %s%n", e);
			        }
				entradamensajes.setText(text);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//FUNCION PARA REFRESCAR LA ENTRADA
	public void refresh (ActionEvent event) {
		String text = "";
		try (FileReader reader = new FileReader("src/Base_Datos/Chat.txt");
	             BufferedReader br = new BufferedReader(reader)) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	text = text + line + "\n";
	            }
	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
		entradamensajes.setText(text);
	}
	
	
	//FUNCION VOLVER A LA PAGINA PRINCIPAL
	public void sigcasa (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_prin.fxml").toURI().toURL();
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

	//FUNCION PARA IR A LA VENTANA DE PERFIL
	public void sigperf (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_perfil.fxml").toURI().toURL();
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