package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagrammi;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	
    	//controllo input
    	String word = txtParola.getText();
    	
    	if(word.length()<2) {
    		txtCorretti.setText("Inserire una parola di almeno 2 lettere");
    		return;
    	} else if(word.length()>7) {
    		txtCorretti.setText("Inserire una parola di al massimo 7 lettere");
    		return;
    	}
    	
    	Set<String> anagrammi = model.anagrammi(word);
    	
    	for(String s : anagrammi) {
    		if(model.isCorrect(s)) {
    			txtCorretti.appendText(s+"\n");
    		} else {
    			txtErrati.appendText(s+"\n");
    		}
    	}
    	
    }

    @FXML
    void cancella(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();
    }
    
    public void setModel(Model m) {
    	this.model = m;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}