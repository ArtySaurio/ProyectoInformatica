package Controladores;

import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ControladorLogin implements Initializable{

	@FXML
	private AnchorPane cuadrogeneral;
	@FXML
	private Pane cuadroazul;
	@FXML
	private Label titulo;
	@FXML
	private VBox cuadrousuario;
	@FXML
	private TextField usuario;
	@FXML
	private VBox cuadrocontrasena;
	@FXML
	private PasswordField contrasena;
	@FXML
	private Button botonlogin;
	@FXML
	private Label estatus;
	@FXML
	private ImageView logo;
	@FXML
	private ImageView gorro;
	@FXML
	private Label ezhouseapp;
	@FXML
	private Label copy;
	@FXML
	private Button botongit;
	@FXML
	private ImageView logogit;
	
	private Stage log ;
	public static List<Usuario> usuarios;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@SuppressWarnings("unchecked")
	
	public void login(ActionEvent event) {
		try {
			  usuarios = parseUsers();
			for (int i=0; i<usuarios.size(); i++) {
				Usuario aux=usuarios.get(i);
				if(aux.getNick().equals(usuario.getText()) && aux.getContasena().equals(contrasena.getText())) {
					estatus.setText("Login Success");
					Main.setCurrentUser(aux);
					if(aux.getAdmin()==true) {
						//PANTALLA ADMINISTRADOR
						URL url = new File ("src/Pantallas/pantalla_prin_admin.fxml").toURI().toURL();
						Parent root = FXMLLoader.load(url);
						Scene scene = new Scene(root,1024,640);
						Stage primaryStage = new Stage();
						primaryStage.setScene(scene);
						Stage log = (Stage) cuadrogeneral.getScene().getWindow();
						log.close();
						primaryStage.show();
					} else {
						//PANTALLA USUARIO
						URL url = new File ("src/Pantallas/pantalla_prin.fxml").toURI().toURL();
						Parent root = FXMLLoader.load(url);
						Scene scene = new Scene(root,1024,640);
						Stage primaryStage = new Stage();
						primaryStage.setScene(scene);
						Stage log = (Stage) cuadrogeneral.getScene().getWindow();
						log.close();
						primaryStage.show();
						
					}
					break;
				} else {
					estatus.setText("Login was unsuccessful");
				}
			}
		} catch(Exception e){
				e.printStackTrace();
		}
		
}

	private List<Usuario> parseUsers(){
	
		List<Usuario> userList = new ArrayList<>();
		
		try (FileReader reader = new FileReader("src/Base_Datos/Usuarios.json"))
    	{
        	//Read JSON file
        	JSONParser jsonParser=new JSONParser();
			Object obj = jsonParser.parse(reader);
        	JSONArray jsonArray= (JSONArray) obj;
        
        	jsonArray.forEach( emp -> userList.add(parseJsonUser( (JSONObject) emp )) );
        	return userList;
        
    	} catch (FileNotFoundException e) {
        	e.printStackTrace();
        	return null;
    	} catch (IOException e) {
        	e.printStackTrace();
        	return null;
    	} catch (ParseException e) {
        	e.printStackTrace();
        	return null;
    	}
	}

	private Usuario parseJsonUser(JSONObject user) {
		String nick=(String)user.get("Nickname");
		String contrasena=(String)user.get("Password");
		Boolean admin=(Boolean)user.get("PowerUser");
		return new Usuario(nick, contrasena, admin);
	}
}