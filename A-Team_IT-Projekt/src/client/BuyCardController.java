package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Player;
import common.SCircle;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;


//Klasse um zusätzliche Karten zu kaufen
public class BuyCardController implements Initializable {

	@FXML
	Label message;
	@FXML
	ChoiceBox<Integer> cb_BuyCard;
	@FXML
	Button b_Buy;
	ObservableList<Integer> cb_BuyCardList = (ObservableList<Integer>) FXCollections.observableArrayList(1,2,3,4,5);

	private Player currentPlayer;
	private ArrayList<ImageView> playerCardsNotVisible;

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		cb_BuyCard.setItems(cb_BuyCardList);
		currentPlayer = GameController.getCurrentPlayer();

	}
	//gewünschte Anzahl Karten werden dem Player hinzugefügt
	public void buyCard() throws InterruptedException{
		playerCardsNotVisible = GameController.getPlayerCardsNotVisible();
		int numOfCards = cb_BuyCard.getValue();
		int costs = numOfCards*2;
		int count = 5;

		if(currentPlayer.getScore() < costs){
			message.setVisible(true);
			message.setText("Du hast zu wenig Punkte um "+cb_BuyCard.getValue()+" zu kaufen!");
			message.setTextFill(Color.RED);
			message.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		}else if(numOfCards > playerCardsNotVisible.size()){
			message.setVisible(true);
			message.setText("Du kannst nicht "+numOfCards+ " kaufen!");
			message.setTextFill(Color.RED);
			message.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		}else{
			currentPlayer.subFromScore(costs);
			//count startet bei 5 weil die zusätzliche Karte 
			//ab moveCard6 hinzugefügt werden sollen
			for(int i = 0; i < numOfCards; i++){
				GameController.addMoveImage(count);
				count++;
			}
			
			GameController.setPlayerCardsNotVisible();
			GameController.scoreTable.getColumns().clear();
			GameController.userNameColumn.setText("SpielerName");
			GameController.scoreColumn.setText("Score");
			GameController.avatarColorColumn.setText("Spielfigur");
			GameController.userNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("userName"));
			GameController.scoreColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("score"));
			GameController.avatarColorColumn.setCellValueFactory(new PropertyValueFactory<Player, SCircle>("avatarColor"));
			GameController.scoreTable.setItems(GameController.playersData);
			GameController.scoreTable.getColumns().addAll(GameController.userNameColumn, GameController.scoreColumn, GameController.avatarColorColumn);
			

			//Fenster sobald die Karten gekauft wurden schliessen
			Stage stage = (Stage)b_Buy.getScene().getWindow();
			stage.close();

		}
	}
}


