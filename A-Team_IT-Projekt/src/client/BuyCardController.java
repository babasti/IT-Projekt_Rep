package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import common.Player;


//Klasse um zusätzliche Karten zu kaufen
public class BuyCardController implements Initializable{

	@FXML
	Label message;
	@FXML
	ChoiceBox<Integer> cb_BuyCard;
	@FXML
	Button b_Buy;
	ObservableList<Integer> cb_BuyCardList = (ObservableList<Integer>) FXCollections.observableArrayList(1,2,3,4,5);

	private Player currentPlayer;

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		cb_BuyCard.setItems(cb_BuyCardList);
		currentPlayer = GameController.getCurrentPlayer();

	}
	//gewünschte Anzahl Karten werden dem Player hinzugefügt
	public void buyCard() throws InterruptedException{
		int numOfCards = cb_BuyCard.getValue();
		int costs;
		costs = numOfCards*2;
		int count = 5;

		if(GameController.cards.size() < numOfCards){
			message.setText("Im Deck hat es weniger als "+numOfCards+" Karten");
			setMessageLayout();
		}else{
			if(currentPlayer.getScore() < costs){
				message.setText("Du hast zu wenig Punkte um "+numOfCards+" zu kaufen!");
				setMessageLayout();
			}else{
				currentPlayer.subFromScore(costs);
				//count startet bei 5 weil die zusätzliche Karte 
				//ab moveCard6 hinzugefügt werden sollen
				for(int i = 0; i < numOfCards; i++){
					GameController.addMoveImage(count);
					count++;
				}

				GameController.updateTableview();

				//Fenster sobald die Karten gekauft wurden schliessen
				Stage stage = (Stage)b_Buy.getScene().getWindow();
				stage.close();

			}
		}
	}

	public void setMessageLayout(){
		message.setVisible(true);
		message.setTextFill(Color.RED);
		message.setFont(Font.font(15));
	}

}
