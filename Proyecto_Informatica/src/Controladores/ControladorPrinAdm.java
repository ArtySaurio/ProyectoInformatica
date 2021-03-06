package Controladores;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorPrinAdm implements Initializable {

	@FXML
	private AnchorPane cuadrogeneral;
	@FXML
	private Pane cuadroimagen;
	@FXML
	private ImageView imgcasa;
	@FXML
	private Pane cuadroazul;
	@FXML
	private Button botoncasa;
	@FXML
	private ImageView logocasa;
	@FXML
	private Button botonmensaje;
	@FXML
	private ImageView logocarta;
	@FXML
	private Button botonajustes;
	@FXML
	private ImageView logoherramienta;
	@FXML
	private ImageView separador;
	@FXML
	private Label titulologs;
	@FXML
	private LineChart<String, Number> graficotemp;
	@FXML
	private LineChart<String, Number> graficodb;
	@FXML
	private Label temp;
	@FXML
	private Label db;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("1 Enero", 20));
		series.getData().add(new XYChart.Data<String, Number>("2 Enero", 22));
		series.getData().add(new XYChart.Data<String, Number>("3 Enero", 25));
		series.getData().add(new XYChart.Data<String, Number>("4 Enero", 19));
		series.getData().add(new XYChart.Data<String, Number>("5 Enero", 21));
		series.getData().add(new XYChart.Data<String, Number>("6 Enero", 21));
		series.getData().add(new XYChart.Data<String, Number>("7 Enero", 24));
		series.getData().add(new XYChart.Data<String, Number>("8 Enero", 21));
		series.getData().add(new XYChart.Data<String, Number>("9 Enero", 22));
		series.getData().add(new XYChart.Data<String, Number>("10 Enero", 21));
		series.setName("Temperatura media diaria");
		graficotemp.getData().add(series);
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.getData().add(new XYChart.Data<String, Number>("1 Enero", 32));
		series2.getData().add(new XYChart.Data<String, Number>("2 Enero", 34));
		series2.getData().add(new XYChart.Data<String, Number>("3 Enero", 33));
		series2.getData().add(new XYChart.Data<String, Number>("4 Enero", 40));
		series2.getData().add(new XYChart.Data<String, Number>("5 Enero", 30));
		series2.getData().add(new XYChart.Data<String, Number>("6 Enero", 32));
		series2.getData().add(new XYChart.Data<String, Number>("7 Enero", 60));
		series2.getData().add(new XYChart.Data<String, Number>("8 Enero", 55));
		series2.getData().add(new XYChart.Data<String, Number>("9 Enero", 34));
		series2.getData().add(new XYChart.Data<String, Number>("10 Enero", 32));
		series2.setName("Decibelios medios diarios");
		graficodb.getData().add(series2);
	}

	//FUNCION ENTRAR EN LA ZONA DE AJUSTES
	public void sigajustes (ActionEvent event) {
		try {
			URL url = new File ("src/Pantallas/pantalla_herramienta_ad.fxml").toURI().toURL();
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
}
