package client;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import common.SCircle;
import common.Card;
import common.Player;
import common.Tile;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//Diese Klasse wird benötigt um eine Spielfigur zu bewegen oder die Aktion
//abzubrechen damit der Spieler nochmals eine figur und eine Karte wählen kann

public class MoveAvatarController implements Initializable, Serializable {

	@FXML
	Button b_SpielzugBestätigen;
	@FXML
	Button b_SpielzugAbbruch;

	//alle Instanzvariablen welche benötigt werden definieren
	//so ziemlich alle aus der GameController Klasse welche hier aufgelistet sind
	private SCircle selectetAvatar;
	private Card selectetCard;
	private ImageView selectetCardImageView;
	private ArrayList<Tile> startBoard;
	private ArrayList<HBox> tileBox;
	private InnerShadow tileShadow;
	private ArrayList<ImageView> possibleTilesArray;
	private InnerShadow tileShadowMove;
	private ArrayList<ImageView> possibleTilesArrayMove;
	private HBox currentAvatarPosition;
	private static HBox[] ebPlayer;
	private int currentPlayerPosition;
	private ArrayList<SCircle> playersAvatar;
	private Player currentPlayer;




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	//Klasse um eine Spielfigur zu bewegen
	//alle Instanzvariablen werden aus der GameController Klasse "kopiert"
	public void moveAvatar(){
		selectetAvatar = GameController.getSelectetAvatar();
		selectetCard = GameController.getSelectetCard();
		startBoard = GameController.getStartBoard();
		tileBox = GameController.getTileBox();
		selectetCardImageView = GameController.getSelectetCardImageView();
		currentAvatarPosition = GameController.getCurrentAvatarPosition();
		ebPlayer = GameController.getEbPlayer();
		currentPlayerPosition = GameController.getCurrentPlayerPosition();
		currentPlayer = GameController.getCurrentPlayer();
		playersAvatar = currentPlayer.getAvatar();
		int count = 0;

		if(currentAvatarPosition.getId().contains("sb_player")){
			//die Figur wird auf das erste Tile aus der startBoard Liste gesetzt
			//welches mit der ausgewählten Bewegungskarte übereinstimmt
			for(int i = 0; i < startBoard.size(); i++){
				if(startBoard.get(i).getColor().equals(selectetCard.getColor())){
					if(tileBox.get(i).getChildren().isEmpty()){
						tileBox.get(i).getChildren().add(selectetAvatar);
						tileBox.get(i).setVisible(true);
						tileBox.get(i).toFront();
						if(i != 0){
							GameController.collectTile(startBoard.get(i), i);
							break;
						}
					}else{
						tileBox.get(i).getChildren().add(selectetAvatar);
						tileBox.get(i).setVisible(true);
						tileBox.get(i).toFront();
						GameController.setMessage("Spiel eine weitere Karte!");
					}
					break;
				}
			}
		}else{
			int x = Integer.parseInt(currentAvatarPosition.getId().substring(7));
			if(x == 49){
				ebPlayer[currentPlayerPosition].getChildren().add(selectetAvatar);
				ebPlayer[currentPlayerPosition].setVisible(true);
				ebPlayer[currentPlayerPosition].toFront();
				GameController.collectLastTile();
				if(ebPlayer[currentPlayerPosition].getChildren().containsAll(playersAvatar)){
					switchToResult();
				}
			}else{
				for(int i = Integer.parseInt(currentAvatarPosition.getId().substring(7)); i <= startBoard.size(); i++){
					count = i;
					if(count == 49){
						ebPlayer[currentPlayerPosition].getChildren().add(selectetAvatar);
						ebPlayer[currentPlayerPosition].setVisible(true);
						ebPlayer[currentPlayerPosition].toFront();
						GameController.collectLastTile();
						if(ebPlayer[currentPlayerPosition].getChildren().containsAll(playersAvatar)){
							switchToResult();
						}
						break;
					}
					if(startBoard.get(i).getColor().equals(selectetCard.getColor())){
						if(tileBox.get(i).getChildren().isEmpty()){
							tileBox.get(i).getChildren().add(selectetAvatar);
							tileBox.get(i).setVisible(true);
							tileBox.get(i).toFront();
							GameController.collectTile(startBoard.get(i), i);
							break;
						}else{
							tileBox.get(i).getChildren().add(selectetAvatar);
							tileBox.get(i).setVisible(true);
							tileBox.get(i).toFront();
							GameController.setMessage("Spiel eine weitere Karte!");
							break;
						}
					}
				}
			}
		}


		//sobald die Figur gesetzt wurde, werden sämtliche Effekte zurückgesetzt
		tileShadowMove = GameController.getTileShadow();
		possibleTilesArrayMove = GameController.getPossibleTilesArray();
		tileShadowMove.setChoke(0);
		tileShadowMove.setColor(null);
		tileShadowMove.setHeight(0);
		tileShadowMove.setWidth(0);
		tileShadowMove.setRadius(0);
		for(int i = 0 ; i < possibleTilesArrayMove.size(); i++){
			possibleTilesArrayMove.get(i).setEffect(tileShadowMove);
		}
		selectetAvatar.setEffect(null);
		selectetCardImageView.setEffect(null);
		selectetCardImageView.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				handleMouseExit(event);		
			}
		});


		//gespielte Bewegungskarte vom Player Array löschen und eine neue Karte aus dem Deck ziehen
		//die neue Karte wird an der Position der gespielten Karte gesetzt
		GameController.currentPlayer.playerCards.set(Integer.parseInt(selectetCardImageView.getId().substring(8))-1, GameController.cards.get(0));
		GameController.moveImages.get(Integer.parseInt(selectetCardImageView.getId().substring(8))-1).setImage(GameController.cards.get(0).getImage());
		GameController.cards.remove(0);

		GameController.numOfDeck.setText(String.valueOf(GameController.cards.size()));



		//damit wir weitere aktionen durchführen können, müssen die selectetAvatar
		//und selectetCard auf null gesetzt werden
		//somit haben wir eine Sicherheit bei der Abfrage ob wir einen Spielzug
		//tätigen können


		GameController.setSelectetAvatar();
		GameController.setSelectetCard();


		Stage stage = (Stage)b_SpielzugBestätigen.getScene().getWindow();
		stage.close();
	}

	//cancelAction ist dafür da um alle Variablen und Effekten zurück zu setzen
	public void cancelAction(){
		tileShadow = GameController.getTileShadow();
		selectetAvatar = GameController.getSelectetAvatar();
		selectetCardImageView = GameController.getSelectetCardImageView();
		possibleTilesArray = GameController.getPossibleTilesArray();

		tileShadow.setChoke(0);
		tileShadow.setColor(null);
		tileShadow.setHeight(0);
		tileShadow.setWidth(0);
		tileShadow.setRadius(0);

		for(int i = 0 ; i < possibleTilesArray.size(); i++){
			possibleTilesArray.get(i).setEffect(tileShadow);
		}

		selectetAvatar.setEffect(null);
		selectetCardImageView.setEffect(null);
		selectetCardImageView.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				handleMouseExit(event);		
			}
		});
		GameController.setSelectetAvatar();
		GameController.setSelectetCard();


		Stage stage = (Stage)b_SpielzugAbbruch.getScene().getWindow();
		stage.close();
	}

	//der onMouseExit effekt wurde übernommen aus der GameController Klasse
	//ist dafür da, damit wir den gewünschten effekt beim verlassen der Bewegungskarte
	//ausgeführt wird
	public void handleMouseExit(MouseEvent event){
		selectetCardImageView.setEffect(null);
		tileShadow = GameController.getTileShadow();
		tileShadow.setChoke(0);
		tileShadow.setColor(null);
		tileShadow.setHeight(0);
		tileShadow.setWidth(0);
		tileShadow.setRadius(0);

	}

	public void switchToResult(){
		try{
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Result.fxml"));
			Pane rootPane = (Pane) fxmlloader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(rootPane));
			stage.show();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static HBox[] getEbPlayer(){
		return ebPlayer;
	}

}
