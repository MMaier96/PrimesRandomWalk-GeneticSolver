package application.gui;

import application.config.AppConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application{
	
	// TODO write tests
	// TODO: disable button while drawing
	
	private String[] arguments;
	private Stage primaryStage;
	private AppConfig config;
	private HBox root; 
	
	
	@Override
	public void start(Stage primaryStage){
		loadConfiguration();
		setPrimaryStage(primaryStage);
		loadApplicationWindow();
	}
	
	private void loadConfiguration(){
		config = AppConfig.instance;
	}
	
	private void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	private void loadApplicationWindow(){
		primaryStage.setTitle(config.applicationTitle);
		primaryStage.setResizable(false);
		
		try{
			root = FXMLLoader.load(getClass().getResource("model/ApplicationModel.fxml"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root, config.windowWidth, config.windowHeight);
		scene.getStylesheets().add(Application.class.getResource("stylesheets/style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void startApplication(){
		launch(arguments);
	}
	
	public void setArguments(String... args){
		this.arguments = args;
	}
}
