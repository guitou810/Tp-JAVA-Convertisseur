package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		try {
		Parent rootFXML = FXMLLoader.load(getClass().getResource("Devises.fxml"));
		Scene sceneFXML = new Scene(rootFXML);
		
		arg0.setTitle("Convertisseur de devices");
		arg0.setScene(sceneFXML);
		arg0.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}      
	
    
	public static void main(String[] args) 
    {
        Application.launch(args);
    }
}
