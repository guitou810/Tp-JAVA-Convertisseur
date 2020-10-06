package application;


import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueControlleur {

	private Double calcul;
	private ArrayList<Double> devise;
	private DecimalFormat df = new DecimalFormat("0.0000");
	
	@FXML
	private ImageView US;
	
	@FXML
	private Button BtnUS;
	
	@FXML
	private ImageView EU;
	
	@FXML
	private Button BtnEU;
	
	@FXML
	private ImageView UK;
	
	@FXML
	private Button BtnUK;
	
	@FXML
	private ImageView CN;
	
	@FXML
	private Button BtnCN;
	
	@FXML
	private ImageView FAV;
	
	@FXML
	private Label LabelUS;
	
	@FXML
	private Label LabelEU;
	
	@FXML
	private Label LabelUK;
	
	@FXML
	private Label LabelCN;
	
	@FXML
	private Label LabelFAV;
	
	@FXML
	private TextField TextFav;
	
	@FXML
	private Label PrixUS;
	
	@FXML
	private Label PrixUK;
	
	@FXML
	private Label PrixEU;
	
	@FXML
	private Label PrixCN;
	
	public ArrayList<Double> conversion(double prize,String str1, String str2) {
		ArrayList<Double> convert = new ArrayList<Double>();
		switch(str1) {
		case "UK":
				calcul = prize * 1.09682;//EU
				convert.add(calcul);
				calcul = prize * 1.29340;//US
				convert.add(calcul);
				calcul = prize * 8.80685;//CN
				convert.add(calcul);
		break;
		case "EU":
				calcul = prize * 0.911677;//UK
				convert.add(calcul);
				calcul = prize * 1.17933;//US
				convert.add(calcul);
				calcul = prize * 8.00876;//CN
				convert.add(calcul);
		break;
		case "US":
			calcul = prize * 0.848013;//EU
			System.out.println("pass");
			convert.add(5.0);
			System.out.println(convert);
			convert.add(calcul);
			calcul = prize * 0.773158;//UK
			convert.add(calcul);
			calcul = prize * 6.79129;//CN
			convert.add(calcul);
		break;
		case "CN":
			calcul = prize * 0.124863;//EU
			convert.add(calcul);
			calcul = prize * 0.113835;//UK
			convert.add(calcul);
			calcul = prize * 0.147247;//US
			convert.add(calcul);
		break;
		}
		return convert;
			
	}
	
	public void choiceFav(ActionEvent e) {
		String btn = e.getSource().toString();
		String num = btn.substring(btn.length()-3,btn.length()-1);
		this.searchBut(num);
	}
	
	public void choixprix(ActionEvent e) {
		String prize = TextFav.getText();
		switch(LabelFAV.getText()) {
		case "UK":
			devise = this.conversion(Double.parseDouble(prize), LabelFAV.getText(), LabelUK.getText());
				PrixEU.setText(df.format(devise.get(0)).toString());
				PrixUS.setText(df.format(devise.get(1)).toString());
				PrixCN.setText(df.format(devise.get(2)).toString());
				PrixUK.setText(df.format(Double.parseDouble(prize)).toString());

		break;
		case "EU":
			devise = this.conversion(Double.parseDouble(prize), LabelFAV.getText(), LabelEU.getText());
			PrixUK.setText(df.format(devise.get(0)).toString());
			PrixUS.setText(df.format(devise.get(1)).toString());
			PrixCN.setText(df.format(devise.get(2)).toString());
			PrixEU.setText(df.format(Double.parseDouble(prize)).toString());
		break;
		case "US":
			devise = this.conversion(Double.parseDouble(prize), LabelFAV.getText(), LabelUS.getText());
			PrixEU.setText(df.format(devise.get(0)).toString());
			PrixUK.setText(df.format(devise.get(1)).toString());
			PrixCN.setText(df.format(devise.get(2)).toString());
			PrixUS.setText(df.format(Double.parseDouble(prize)).toString());
		break;
		case "CN":
			devise = this.conversion(Double.parseDouble(prize), LabelFAV.getText(), LabelCN.getText());
			PrixEU.setText(df.format(devise.get(0)).toString());
			PrixUK.setText(df.format(devise.get(1)).toString());
			PrixUS.setText(df.format(devise.get(2)).toString());
			PrixCN.setText(df.format(Double.parseDouble(prize)).toString());
		break;
		}	
	}
	
	
	public void searchBut(String id) {
		switch(id) {
		case "UK":
			Image image = new Image("Image/Anglais.jpg");
	        FAV.setImage(image);
	        LabelFAV.setText("UK");
		break;
		case "EU":
			Image image4 = new Image("Image/EU.png");
	        FAV.setImage(image4);
	        LabelFAV.setText("EU");
		break;
		case "US":
			Image image2 = new Image("Image/USA.png");
	        FAV.setImage(image2);
	        LabelFAV.setText("US");
		break;
		case "CN":
			Image image3 = new Image("Image/Chine.jpg");
	        FAV.setImage(image3);
	        LabelFAV.setText("CN");
		break;
		}
	}

}
