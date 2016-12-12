package client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;

import common.Card;
import common.Game;
import common.Player;
import common.Tile;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import common.SCircle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameController extends SCircle implements Initializable{


	// Elemente vom GUI definieren

	@FXML
	HBox tileBox1;
	@FXML
	HBox tileBox2;
	@FXML
	HBox tileBox3;
	@FXML
	HBox tileBox4;
	@FXML
	HBox tileBox5;
	@FXML
	HBox tileBox6;
	@FXML
	HBox tileBox7;
	@FXML
	HBox tileBox8;
	@FXML
	HBox tileBox9;
	@FXML
	HBox tileBox10;
	@FXML
	HBox tileBox11;
	@FXML
	HBox tileBox12;
	@FXML
	HBox tileBox13;
	@FXML
	HBox tileBox14;
	@FXML
	HBox tileBox15;
	@FXML
	HBox tileBox16;
	@FXML
	HBox tileBox17;
	@FXML
	HBox tileBox18;
	@FXML
	HBox tileBox19;
	@FXML
	HBox tileBox20;
	@FXML
	HBox tileBox21;
	@FXML
	HBox tileBox22;
	@FXML
	HBox tileBox23;
	@FXML
	HBox tileBox24;
	@FXML
	HBox tileBox25;
	@FXML
	HBox tileBox26;
	@FXML
	HBox tileBox27;
	@FXML
	HBox tileBox28;
	@FXML
	HBox tileBox29;
	@FXML
	HBox tileBox30;
	@FXML
	HBox tileBox31;
	@FXML
	HBox tileBox32;
	@FXML
	HBox tileBox33;
	@FXML
	HBox tileBox34;
	@FXML
	HBox tileBox35;
	@FXML
	HBox tileBox36;
	@FXML
	HBox tileBox37;
	@FXML
	HBox tileBox38;
	@FXML
	HBox tileBox39;
	@FXML
	HBox tileBox40;
	@FXML
	HBox tileBox41;
	@FXML
	HBox tileBox42;
	@FXML
	HBox tileBox43;
	@FXML
	HBox tileBox44;
	@FXML
	HBox tileBox45;
	@FXML
	HBox tileBox46;
	@FXML
	HBox tileBox47;
	@FXML
	HBox tileBox48;
	@FXML
	HBox tileBox49;	
	@FXML
	Pane rootPane;
	@FXML
	VBox startBox;
	@FXML
	VBox endBox;
	@FXML
	HBox sb_player1;
	@FXML
	HBox sb_player2;
	@FXML
	HBox sb_player3;
	@FXML
	HBox sb_player4;
	@FXML
	HBox eb_player1;
	@FXML
	HBox eb_player2;
	@FXML
	HBox eb_player3;
	@FXML
	HBox eb_player4;
	@FXML
	ImageView atlantis;
	@FXML
	ImageView land;
	@FXML
	Button finishButton;
	@FXML
	StackPane movementCards;	
	@FXML
	HBox moveCardsBox0;
	@FXML
	VBox vb_playerMoveCards;
	@FXML
	Button lobbyButton;
	@FXML
	Button b_BuyCard;
	@FXML
	ImageView tile1;
	@FXML
	ImageView tile2;
	@FXML
	ImageView tile3;
	@FXML
	ImageView tile4;
	@FXML
	ImageView tile5;
	@FXML
	ImageView tile6;
	@FXML
	ImageView tile7;
	@FXML
	ImageView tile8;
	@FXML
	ImageView tile9;
	@FXML
	ImageView tile10;
	@FXML
	ImageView tile11;
	@FXML
	ImageView tile12;
	@FXML
	ImageView tile13;
	@FXML
	ImageView tile14;
	@FXML
	ImageView tile15;
	@FXML
	ImageView tile16;
	@FXML
	ImageView tile17;
	@FXML
	ImageView tile18;
	@FXML
	ImageView tile19;
	@FXML
	ImageView tile20;
	@FXML
	ImageView tile21;
	@FXML
	ImageView tile22;
	@FXML
	ImageView tile23;
	@FXML
	ImageView tile24;
	@FXML
	ImageView tile25;
	@FXML
	ImageView tile26;
	@FXML
	ImageView tile27;
	@FXML
	ImageView tile28;
	@FXML
	ImageView tile29;
	@FXML
	ImageView tile30;
	@FXML
	ImageView tile31;
	@FXML
	ImageView tile32;
	@FXML
	ImageView tile33;
	@FXML
	ImageView tile34;
	@FXML
	ImageView tile35;
	@FXML
	ImageView tile36;
	@FXML
	ImageView tile37;
	@FXML
	ImageView tile38;
	@FXML
	ImageView tile39;
	@FXML
	ImageView tile40;
	@FXML
	ImageView tile41;
	@FXML
	ImageView tile42;
	@FXML
	ImageView tile43;
	@FXML
	ImageView tile44;
	@FXML
	ImageView tile45;
	@FXML
	ImageView tile46;
	@FXML
	ImageView tile47;
	@FXML
	ImageView tile48;
	@FXML
	ImageView tile49;
	@FXML
	ImageView moveCard1;
	@FXML
	ImageView moveCard2;
	@FXML
	ImageView moveCard3;
	@FXML
	ImageView moveCard4;
	@FXML
	ImageView moveCard5;
	@FXML
	HBox moveCardsBox1;
	@FXML
	ImageView moveCard6;
	@FXML
	ImageView moveCard7;
	@FXML
	ImageView moveCard8;
	@FXML
	ImageView moveCard9;
	@FXML
	ImageView moveCard10;

	//Bilder welche im Ordner resource abgelget sind instanziert als Image

	private Image blue1 = new Image(getClass().getResourceAsStream("/resource/blue_1.jpg"));
	private Image blue2 = new Image(getClass().getResourceAsStream("/resource/blue_2.jpg"));
	private Image blue3 = new Image(getClass().getResourceAsStream("/resource/blue_3.jpg"));
	private Image blue4 = new Image(getClass().getResourceAsStream("/resource/blue_4.jpg"));
	private Image blue5 = new Image(getClass().getResourceAsStream("/resource/blue_5.jpg"));
	private Image blue6 = new Image(getClass().getResourceAsStream("/resource/blue_6.jpg"));
	private Image blue7 = new Image(getClass().getResourceAsStream("/resource/blue_7.jpg"));
	private Image brown1 = new Image(getClass().getResourceAsStream("/resource/brown_1.jpg"));
	private Image brown2 = new Image(getClass().getResourceAsStream("/resource/brown_2.jpg"));
	private Image brown3 = new Image(getClass().getResourceAsStream("/resource/brown_3.jpg"));
	private Image brown4 = new Image(getClass().getResourceAsStream("/resource/brown_4.jpg"));
	private Image brown5 = new Image(getClass().getResourceAsStream("/resource/brown_5.jpg"));
	private Image brown6 = new Image(getClass().getResourceAsStream("/resource/brown_6.jpg"));
	private Image brown7 = new Image(getClass().getResourceAsStream("/resource/brown_7.jpg"));
	private Image green1 = new Image(getClass().getResourceAsStream("/resource/green_1.jpg"));
	private Image green2 = new Image(getClass().getResourceAsStream("/resource/green_2.jpg"));
	private Image green3 = new Image(getClass().getResourceAsStream("/resource/green_3.jpg"));
	private Image green4 = new Image(getClass().getResourceAsStream("/resource/green_4.jpg"));
	private Image green5 = new Image(getClass().getResourceAsStream("/resource/green_5.jpg"));
	private Image green6 = new Image(getClass().getResourceAsStream("/resource/green_6.jpg"));
	private Image green7 = new Image(getClass().getResourceAsStream("/resource/green_7.jpg"));
	private Image grey1 = new Image(getClass().getResourceAsStream("/resource/grey_1.jpg"));
	private Image grey2 = new Image(getClass().getResourceAsStream("/resource/grey_2.jpg"));
	private Image grey3 = new Image(getClass().getResourceAsStream("/resource/grey_3.jpg"));
	private Image grey4 = new Image(getClass().getResourceAsStream("/resource/grey_4.jpg"));
	private Image grey5 = new Image(getClass().getResourceAsStream("/resource/grey_5.jpg"));
	private Image grey6 = new Image(getClass().getResourceAsStream("/resource/grey_6.jpg"));
	private Image grey7 = new Image(getClass().getResourceAsStream("/resource/grey_7.jpg"));
	private Image pink1 = new Image(getClass().getResourceAsStream("/resource/pink_1.jpg"));
	private Image pink2 = new Image(getClass().getResourceAsStream("/resource/pink_2.jpg"));
	private Image pink3 = new Image(getClass().getResourceAsStream("/resource/pink_3.jpg"));
	private Image pink4 = new Image(getClass().getResourceAsStream("/resource/pink_4.jpg"));
	private Image pink5 = new Image(getClass().getResourceAsStream("/resource/pink_5.jpg"));
	private Image pink6 = new Image(getClass().getResourceAsStream("/resource/pink_6.jpg"));
	private Image pink7 = new Image(getClass().getResourceAsStream("/resource/pink_7.jpg"));
	private Image white1 = new Image(getClass().getResourceAsStream("/resource/white_1.jpg"));
	private Image white2 = new Image(getClass().getResourceAsStream("/resource/white_2.jpg"));
	private Image white3 = new Image(getClass().getResourceAsStream("/resource/white_3.jpg"));
	private Image white4 = new Image(getClass().getResourceAsStream("/resource/white_4.jpg"));
	private Image white5 = new Image(getClass().getResourceAsStream("/resource/white_5.jpg"));
	private Image white6 = new Image(getClass().getResourceAsStream("/resource/white_6.jpg"));
	private Image white7 = new Image(getClass().getResourceAsStream("/resource/white_7.jpg"));
	private Image yellow1 = new Image(getClass().getResourceAsStream("/resource/yellow_1.jpg"));
	private Image yellow2 = new Image(getClass().getResourceAsStream("/resource/yellow_2.jpg"));
	private Image yellow3 = new Image(getClass().getResourceAsStream("/resource/yellow_3.jpg"));
	private Image yellow4 = new Image(getClass().getResourceAsStream("/resource/yellow_4.jpg"));
	private Image yellow5 = new Image(getClass().getResourceAsStream("/resource/yellow_5.jpg"));
	private Image yellow6 = new Image(getClass().getResourceAsStream("/resource/yellow_6.jpg"));
	private Image yellow7 = new Image(getClass().getResourceAsStream("/resource/yellow_7.jpg"));
	private Image water = new Image(getClass().getResourceAsStream("/resource/wasser.JPG"));

	private Image moveCardBlue = new Image(getClass().getResourceAsStream("/resource/card_Blue.jpg"));
	private Image moveCardBrown = new Image(getClass().getResourceAsStream("/resource/card_Brown.jpg"));
	private Image moveCardGreen = new Image(getClass().getResourceAsStream("/resource/card_Green.jpg"));
	private Image moveCardGrey = new Image(getClass().getResourceAsStream("/resource/card_Grey.jpg"));
	private Image moveCardPink = new Image(getClass().getResourceAsStream("/resource/card_Pink.jpg"));
	private Image moveCardWhite = new Image(getClass().getResourceAsStream("/resource/card_White.jpg"));
	private Image moveCardYellow = new Image(getClass().getResourceAsStream("/resource/card_Yellow.jpg"));


	//Instanzvariablen ArrayListe welche alle Tile Objekte beinhaltet
	//und ImageView Array welche alle ImageView mit ID beinhaltet

	private static ArrayList<Tile> startBoard;
	private static ImageView[] tileImages;
	public static ArrayList<ImageView> moveImages;
	public static ArrayList<Card> cards;
	private static InnerShadow tileShadow;
	public static Label numOfDeck = new Label();
	Tile Water = new Tile(water, 0, "water");
	private static Color[] avatarColors = new Color[4];
	private static ArrayList<Player> players = new ArrayList<Player>(); 
	private static ArrayList<SCircle> avatars;
	private static Card selectetCard;
	private static ImageView selectetCardImageView;
	private static SCircle selectetAvatar;
	private static ArrayList<HBox> tileBox;
	private static ArrayList<Tile> proformaStartGameBoard;
	private static ArrayList<ImageView> possibleTilesArray;
	private static HBox currentAvatarPosition;
	private static HBox[] ebPlayer;
	public static Player currentPlayer;
	private static int currentPlayerPosition = 0;
	static TableView<Player> scoreTable;
	static ObservableList<Player> playersData = FXCollections.observableArrayList();
	static TableColumn<Player, String> userNameColumn = new TableColumn<Player, String>();
	static TableColumn<Player, Integer> scoreColumn = new TableColumn<Player, Integer>();
	static TableColumn<Player, SCircle> avatarColorColumn = new TableColumn<Player, SCircle>();
	private static Label message;
	private static ArrayList<ImageView> playerCardsNotVisible = new ArrayList<ImageView>();




	//initialize Methode instanziert eine startBoard Liste mit Tile Objekte welche zufällig
	//in der Liste gesetzt wurden.
	// mit initTileArray wird die Instanzvariable tileImages initialisiert um ein Array mit allen 
	//ImageViews zu haben
	// danach wird jedes ImageView mit einem Bild aus der startBoard Liste gesetzt.
	//somit haben wir ein visuelles GameBoard
	@Override
	public void initialize(URL location, ResourceBundle resources) {


		for(Player player : Game.getPlayers()){
			players.add(player);
		}


		//Label mit folgende Eigenschaften zur StackPane hinzufügen
		numOfDeck.setFont(Font.font("System", FontWeight.BOLD, 40));
		numOfDeck.setTextFill(Color.WHITE);
		numOfDeck.setAlignment(Pos.CENTER);
		movementCards.getChildren().add(numOfDeck);

		//start Plättchen aufs Board setzen
		startBoard = new ArrayList<Tile>(setStartTiles());
		initTileArray();
		int countTile = 0;
		for(int i = 0; i < startBoard.size(); i++){
			tileImages[countTile].setImage(startBoard.get(i).getImage());
			countTile++;
		}

		//Liste mit Bewegungskarte initialisieren
		cards = new ArrayList<Card>(setStartMoveCards());
		//proforma, playerCards muss beim Player Objekt instanziert werden
		//hier nur zu test Zwecken

		for(int x = 0; x < players.size(); x++){
			for(int i = 0; i < 5; i++){
				players.get(x).playerCards.add(cards.get(0));
				cards.remove(0);
			}
		}

		initMoveCardArray();
		int countMoveCard = 0;

		for(int i = 0; i < currentPlayer.playerCards.size(); i++){
			moveImages.get(countMoveCard).setImage(currentPlayer.playerCards.get(i).getImage());
			countMoveCard++;
		}

		//Anzahl Bewegungskarten im Deck anzeigen
		String numberOfDeck = String.valueOf(cards.size());
		numOfDeck.setText(numberOfDeck);


		// ------------------------------------------- provisorisch ab hier

		//avatar Farben instanziert und in einem array gespeichert
		avatarColors[0] = Color.RED;
		avatarColors[1] = Color.BLUE;
		avatarColors[2] = Color.GREEN;
		avatarColors[3] = Color.ORANGE;

		//proforma 4 Spieler instanziert und diese zur ArrayListe des Spiels hinzugefügt
//		Date date = new Date(1992, 12, 26);
//		Player player1 = new Player("muetter", "hallo", date, "muetter");
//		Player player2 = new Player("nanen", "hallo", date, "muetter");
//		Player player3 = new Player("hueresohn", "hallo", date, "muetter");
//		Player player4 = new Player("picka", "hallo", date, "muetter");
//
//
//		players.add(player1);
//		players.add(player2);
//		players.add(player3);
//		players.add(player4);


		currentPlayer = players.get(0);

		//die HBoxen der verschiedenen Player in einem Array gespeichert
		HBox[] sbPlayer = new HBox[4];
		sbPlayer[0] = sb_player1;
		sbPlayer[1] = sb_player2;
		sbPlayer[2] = sb_player3;
		sbPlayer[3] = sb_player4;

		ebPlayer = new HBox[4];
		ebPlayer[0] = eb_player1;
		ebPlayer[1] = eb_player2;
		ebPlayer[2] = eb_player3;
		ebPlayer[3] = eb_player4;


		//avatar Listen von den Player holen und in eine arrayListe speichern und diese Listen in eine gesamt Liste speichern
		//vielleicht geht es auch direkt noch nicht probiert
		ArrayList<SCircle> totalAvatars = new ArrayList<SCircle>();
		for(int i = 0; i <players.size(); i++){
			totalAvatars.addAll(players.get(i).getAvatar());
		}

		int count = 0;
		int count2 = 0;

		//den avatars die zuständige farbe zuteilen und in die entsprechenden Boxen zuteilen
		for(int x = 0; x < players.size(); x++){	
			for(int i = 0; i < players.get(x).getAvatar().size(); i++){
				totalAvatars.get(count2).setFill(avatarColors[count]);
				sbPlayer[count].getChildren().add(totalAvatars.get(count2));
				count2++;
			}
			players.get(x).setAvatarColor(avatarColors[count]);
			count++;
		}

		//handler für alle Avatars setzen, sobald ein Avatar gewählt wurde durch Click wird der Effekt gesetzt
		//der Player kann jeweils nur einen Avatar wählen in der StartBox

		for(int x = 0; x < players.size();x++){
			for(int i = 0; i < players.get(x).getAvatar().size(); i++){
				players.get(x).getAvatar().get(i).setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						handleSelectetAvatar(event);
					}
				});
			}
		}

		message = new Label();
		message.setLayoutX(800);
		message.setLayoutY(650);
		message.setVisible(false);
		rootPane.getChildren().add(message);

		scoreTable = new TableView<Player>();
		scoreTable.setLayoutX(913);
		scoreTable.setLayoutY(361);
		scoreTable.setPrefHeight(200);
		scoreTable.setPrefWidth(228);
		scoreTable.toFront();
		rootPane.getChildren().add(scoreTable);

		for(Player p : players){
			playersData.add(p);
		}

		userNameColumn.setText("SpielerName");
		scoreColumn.setText("Score");
		avatarColorColumn.setText("Spielfigur");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("userName"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("score"));
		avatarColorColumn.setCellValueFactory(new PropertyValueFactory<Player, SCircle>("avatarColor"));

		scoreTable.setItems(playersData);
		scoreTable.getColumns().clear();
		scoreTable.getColumns().addAll(userNameColumn, scoreColumn, avatarColorColumn);

		setMessage(currentPlayer.getUserName()+" ist dran!");
		for(ImageView notVisible : moveImages){
			if(!notVisible.isVisible()){
				playerCardsNotVisible.add(notVisible);
			}
		}


	}	

	// ---------------------------------------------------------- bis hier


	//initialisiert die Instanzvariable tileImages um ein Array mit allen ImageViews zu haben
	//damit wir darauf zugreiffen können um ein Bild zu setzen
	private void initTileArray(){	

		tileImages = new ImageView[49];

		tileImages[0] = tile1;
		tileImages[1] = tile2;
		tileImages[2] = tile3;
		tileImages[3] = tile4;
		tileImages[4] = tile5;
		tileImages[5] = tile6;
		tileImages[6] = tile7;
		tileImages[7] = tile8;
		tileImages[8] = tile9;
		tileImages[9] = tile10;
		tileImages[10] = tile11;
		tileImages[11] = tile12;
		tileImages[12] = tile13;
		tileImages[13] = tile14;
		tileImages[14] = tile15;
		tileImages[15] = tile16;
		tileImages[16] = tile17;
		tileImages[17] = tile18;
		tileImages[18] = tile19;
		tileImages[19] = tile20;
		tileImages[20] = tile21;
		tileImages[21] = tile22;
		tileImages[22] = tile23;
		tileImages[23] = tile24;
		tileImages[24] = tile25;
		tileImages[25] = tile26;
		tileImages[26] = tile27;
		tileImages[27] = tile28;
		tileImages[28] = tile29;
		tileImages[29] = tile30;
		tileImages[30] = tile31;
		tileImages[31] = tile32;
		tileImages[32] = tile33;
		tileImages[33] = tile34;
		tileImages[34] = tile35;
		tileImages[35] = tile36;
		tileImages[36] = tile37;
		tileImages[37] = tile38;
		tileImages[38] = tile39;
		tileImages[39] = tile40;
		tileImages[40] = tile41;
		tileImages[41] = tile42;
		tileImages[42] = tile43;
		tileImages[43] = tile44;
		tileImages[44] = tile45;
		tileImages[45] = tile46;
		tileImages[46] = tile47;
		tileImages[47] = tile48;
		tileImages[48] = tile49;

		tileBox = new ArrayList<HBox>();
		tileBox.add(tileBox1);
		tileBox.add(tileBox2);
		tileBox.add(tileBox3);
		tileBox.add(tileBox4);
		tileBox.add(tileBox5);
		tileBox.add(tileBox6);
		tileBox.add(tileBox7);
		tileBox.add(tileBox8);
		tileBox.add(tileBox9);
		tileBox.add(tileBox10);
		tileBox.add(tileBox11);
		tileBox.add(tileBox12);
		tileBox.add(tileBox13);
		tileBox.add(tileBox14);
		tileBox.add(tileBox15);
		tileBox.add(tileBox16);
		tileBox.add(tileBox17);
		tileBox.add(tileBox18);
		tileBox.add(tileBox19);
		tileBox.add(tileBox20);
		tileBox.add(tileBox21);
		tileBox.add(tileBox22);
		tileBox.add(tileBox23);
		tileBox.add(tileBox24);
		tileBox.add(tileBox25);
		tileBox.add(tileBox26);
		tileBox.add(tileBox27);
		tileBox.add(tileBox28);
		tileBox.add(tileBox29);
		tileBox.add(tileBox30);
		tileBox.add(tileBox31);
		tileBox.add(tileBox32);
		tileBox.add(tileBox33);
		tileBox.add(tileBox34);
		tileBox.add(tileBox35);
		tileBox.add(tileBox36);
		tileBox.add(tileBox37);
		tileBox.add(tileBox38);
		tileBox.add(tileBox39);
		tileBox.add(tileBox40);
		tileBox.add(tileBox41);
		tileBox.add(tileBox42);
		tileBox.add(tileBox43);
		tileBox.add(tileBox44);
		tileBox.add(tileBox45);
		tileBox.add(tileBox46);
		tileBox.add(tileBox47);
		tileBox.add(tileBox48);
		tileBox.add(tileBox49);


	}	

	//setStartTiles wird gebraucht um eine ArrayList zu haben welche zufällig mit Tile Images
	//gefüllt wurde
	public ArrayList<Tile> setStartTiles(){

		ArrayList<Tile> tileBoard = new ArrayList<Tile>(setTiles());
		ArrayList<Tile> proformaList = new ArrayList<Tile>(setTiles());

		Random rand = new Random();
		int count = 49;


		for (int i=0; i < tileBoard.size(); i++){
			int x = rand.nextInt(count);
			tileBoard.set(i, proformaList.get(x));
			proformaList.remove(x);
			count--;
		}



		return tileBoard;

	}



	//instanziert neue Tile Objekte und addet die Objekte einer Liste zu.
	//diese Liste ist nicht zufällig verteilt 
	//haben wir erstellt damit wir eine Liste mit allen Tile Objekte haben
	public ArrayList<Tile> setTiles(){

		ArrayList<Tile> startGameBoard = new ArrayList<Tile>();
		proformaStartGameBoard = new ArrayList<Tile>();

		Tile Blue1 = new Tile(blue1, 1, "blue");
		Tile Blue2 = new Tile(blue2, 2, "blue");
		Tile Blue3 = new Tile(blue3, 3, "blue");
		Tile Blue4 = new Tile(blue4, 4, "blue");
		Tile Blue5 = new Tile(blue5, 5, "blue");
		Tile Blue6 = new Tile(blue6, 6, "blue");
		Tile Blue7 = new Tile(blue7, 7, "blue");
		Tile Brown1 = new Tile(brown1, 1, "brown");
		Tile Brown2 = new Tile(brown2, 2, "brown");
		Tile Brown3 = new Tile(brown3, 3, "brown");
		Tile Brown4 = new Tile(brown4, 4, "brown");
		Tile Brown5 = new Tile(brown5, 5, "brown");
		Tile Brown6 = new Tile(brown6, 6, "brown");
		Tile Brown7 = new Tile(brown7, 7, "brown");
		Tile Grey1 = new Tile(grey1, 1, "grey");
		Tile Grey2 = new Tile(grey2, 2, "grey");
		Tile Grey3 = new Tile(grey3, 3, "grey");
		Tile Grey4 = new Tile(grey4, 4, "grey");
		Tile Grey5 = new Tile(grey5, 5, "grey");
		Tile Grey6 = new Tile(grey6, 6, "grey");
		Tile Grey7 = new Tile(grey7, 7, "grey");
		Tile Green1 = new Tile(green1, 1, "green");
		Tile Green2 = new Tile(green2, 2, "green");
		Tile Green3 = new Tile(green3, 3, "green");
		Tile Green4 = new Tile(green4, 4, "green");
		Tile Green5 = new Tile(green5, 5, "green");
		Tile Green6 = new Tile(green6, 6, "green");
		Tile Green7 = new Tile(green7, 7, "green");
		Tile Pink1 = new Tile(pink1, 1, "pink");
		Tile Pink2 = new Tile(pink2, 2, "pink");
		Tile Pink3 = new Tile(pink3, 3, "pink");
		Tile Pink4 = new Tile(pink4, 4, "pink");
		Tile Pink5 = new Tile(pink5, 5, "pink");
		Tile Pink6 = new Tile(pink6, 6, "pink");
		Tile Pink7 = new Tile(pink7, 7, "pink");
		Tile White1 = new Tile(white1, 1, "white");
		Tile White2 = new Tile(white2, 2, "white");
		Tile White3 = new Tile(white3, 3, "white");
		Tile White4 = new Tile(white4, 4, "white");
		Tile White5 = new Tile(white5, 5, "white");
		Tile White6 = new Tile(white6, 6, "white");
		Tile White7 = new Tile(white7, 7, "white");
		Tile Yellow1 = new Tile(yellow1, 1, "yellow");
		Tile Yellow2 = new Tile(yellow2, 2, "yellow");
		Tile Yellow3 = new Tile(yellow3, 3, "yellow");
		Tile Yellow4 = new Tile(yellow4, 4, "yellow");
		Tile Yellow5 = new Tile(yellow5, 5, "yellow");
		Tile Yellow6 = new Tile(yellow6, 6, "yellow");
		Tile Yellow7 = new Tile(yellow7, 7, "yellow");
		Tile Water = new Tile(water, 0, "water");

		proformaStartGameBoard.add(Water);

		startGameBoard.add(Blue1);
		startGameBoard.add(Blue2);
		startGameBoard.add(Blue3);
		startGameBoard.add(Blue4);
		startGameBoard.add(Blue5);
		startGameBoard.add(Blue6);
		startGameBoard.add(Blue7);
		startGameBoard.add(Brown1);
		startGameBoard.add(Brown2);
		startGameBoard.add(Brown3);
		startGameBoard.add(Brown4);
		startGameBoard.add(Brown5);
		startGameBoard.add(Brown6);
		startGameBoard.add(Brown7);
		startGameBoard.add(Grey1);
		startGameBoard.add(Grey2);
		startGameBoard.add(Grey3);
		startGameBoard.add(Grey4);
		startGameBoard.add(Grey5);
		startGameBoard.add(Grey6);
		startGameBoard.add(Grey7);
		startGameBoard.add(Green1);
		startGameBoard.add(Green2);
		startGameBoard.add(Green3);
		startGameBoard.add(Green4);
		startGameBoard.add(Green5);
		startGameBoard.add(Green6);
		startGameBoard.add(Green7);
		startGameBoard.add(Pink1);
		startGameBoard.add(Pink2);
		startGameBoard.add(Pink3);
		startGameBoard.add(Pink4);
		startGameBoard.add(Pink5);
		startGameBoard.add(Pink6);
		startGameBoard.add(Pink7);
		startGameBoard.add(White1);
		startGameBoard.add(White2);
		startGameBoard.add(White3);
		startGameBoard.add(White4);
		startGameBoard.add(White5);
		startGameBoard.add(White6);
		startGameBoard.add(White7);
		startGameBoard.add(Yellow1);
		startGameBoard.add(Yellow2);
		startGameBoard.add(Yellow3);
		startGameBoard.add(Yellow4);
		startGameBoard.add(Yellow5);
		startGameBoard.add(Yellow6);
		startGameBoard.add(Yellow7);


		return startGameBoard;
	}

	// Player beendet seinen spielzug und das Game Objekt wird an den Server gesendet
	// und vom Server zu den anderen Clients
	public void finishTurn(){
		setCurrentPlayerPosition();
		setCurrentPlayer();
		setMessage(currentPlayer.getUserName()+" ist dran!");

		//hier wird die methode sendToServer aufgerufen

	}	


	//wird ausgelöst wenn der Spieler sein Avatar auf eine entsprechendes Tile setzen will
	//die Methode ersetzt das vorherige Tile mit "Wasser" und gibt die Punktzahlt des Tiles zurück
	//um die Punktzahl danach dem Score vom Spieler zu summieren
	public static void collectTile(Tile selectetTile, int position){
		Image water = proformaStartGameBoard.get(0).getImage();
		Tile Water = new Tile (water, 0, "water");

		int points;
		int countPosition = 1;

		HBox collectBox = tileBox.get(position-countPosition);

		//somit wird verhindert dass der Player das Tile hinter ihm erhält, obwohl eine andere Figur
		//darauf steht
		while(!(collectBox.getChildren().isEmpty())){
			countPosition++;
			if(position-countPosition == -1){
				break;
			}else{
				collectBox = tileBox.get(position-countPosition);
			}
		}
		if(position-countPosition == -1){
		}else{
			Tile collectTile = startBoard.get(position-countPosition);
			points = collectTile.getPoints();

			//wenn das Tile Punkte hat wird es ersetzt durch "Wasser"
			//und dem Player werden die entsprechenden Punkte zum Score summiert
			if(points > 0){
				currentPlayer.addToScore(points);
				startBoard.set(position-countPosition, Water);
				tileImages[position-countPosition].setImage(startBoard.get(position-countPosition).getImage());
			}else{
				do{
					//falls das Tile keine Punkte hat, also "Wasser" ist
					//möchten wir natürlich, dass der Player ein Tile weiter hinten auf dem Board erhält mit Punkte
					countPosition++;
					//falls wir mit der Iteration am Start des Boards gelangen
					//hat es keine Tiles mehr mit Punkte, dann wird der Loop gebrochen und der Player 
					//kann keine Punkte sammeln
					if(position - countPosition == -1){
						break;
					}
					//hier wird wieder kontrolliert ob eine andere Figur auf dem entsprechendem Tile
					//drauf ist
					collectBox = tileBox.get(position-countPosition);
					while(!(collectBox.getChildren().isEmpty())){
						countPosition++;
						//falls wir wiederum am Start des Boards gelangen, dann wird der Loop gebrochen
						if(position-countPosition == -1){
							break;
						}
						collectBox = tileBox.get(position-countPosition);
					}
					//und der Player kann keine Punkte sammeln, da es keine freie Tiles gibt
					//mit Punkte
					if(position-countPosition == -1){
						break;
					}
					Tile selectTile1 = startBoard.get(position-countPosition);
					points = selectTile1.getPoints();
					currentPlayer.addToScore(points);
					startBoard.set(position-countPosition, Water);
					tileImages[position-countPosition].setImage(startBoard.get(position-countPosition).getImage());
				}while(points == 0);
			}
		}

		//die Score Tabelle wird aktualisiert mit den entsprechenden Punkten
		scoreTable.getColumns().clear();
		userNameColumn.setText("SpielerName");
		scoreColumn.setText("Score");
		avatarColorColumn.setText("Spielfigur");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("userName"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("score"));
		avatarColorColumn.setCellValueFactory(new PropertyValueFactory<Player, SCircle>("avatarColor"));

		scoreTable.setItems(playersData);
		scoreTable.getColumns().addAll(userNameColumn, scoreColumn, avatarColorColumn);
	}

	//collectLastTile() wird aufgerufen falls der Player aufs Land gelangt,
	//ihm wird das entsprechende letzte verfügbare Tile zugewiesen
	public static void collectLastTile(){
		Image water = proformaStartGameBoard.get(0).getImage();
		Tile Water = new Tile (water, 0, "water");
		int lastTilePosition = 48;

		int points;
		int countPosition = 0;

		HBox collectBox = tileBox.get(lastTilePosition);

		//somit wird verhindert dass der Player das Tile hinter ihm erhält, obwohl eine andere Figur
		//darauf steht
		while(!(collectBox.getChildren().isEmpty())){
			countPosition++;
			collectBox = tileBox.get(lastTilePosition-countPosition);
		}

		Tile collectTile = startBoard.get(lastTilePosition-countPosition);
		points = collectTile.getPoints();

		if(points > 0){	
			currentPlayer.addToScore(points);
			startBoard.set(lastTilePosition-countPosition, Water);
			tileImages[lastTilePosition-countPosition].setImage(startBoard.get(lastTilePosition-countPosition).getImage());
		}else{
			do{
				countPosition++;
				if(lastTilePosition - countPosition == -1){
					break;
				}
				collectBox = tileBox.get(lastTilePosition-countPosition);
				while(!(collectBox.getChildren().isEmpty())){
					countPosition++;
					if(lastTilePosition-countPosition == -1){
						break;
					}
					collectBox = tileBox.get(lastTilePosition-countPosition);
				}

				if(lastTilePosition-countPosition == -1){
					break;
				}

				Tile selectTile1 = startBoard.get(lastTilePosition-countPosition);
				points = selectTile1.getPoints();
				currentPlayer.addToScore(points);
			}while(points == 0);

			startBoard.set(lastTilePosition-countPosition, Water);
			tileImages[lastTilePosition-countPosition].setImage(startBoard.get(lastTilePosition-countPosition).getImage());
		}

		scoreTable.getColumns().clear();
		userNameColumn.setText("SpielerName");
		scoreColumn.setText("Score");
		avatarColorColumn.setText("Spielfigur");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("userName"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("score"));
		avatarColorColumn.setCellValueFactory(new PropertyValueFactory<Player, SCircle>("avatarColor"));

		scoreTable.setItems(playersData);
		scoreTable.getColumns().addAll(userNameColumn, scoreColumn, avatarColorColumn);

	}

	//gibt eine Liste zurück mit 105 Bewegungskarten jeweils 7 Arten à 15 Karten
	//die Karten sind nicht zufällig verteilt in der Liste
	public ArrayList<Card> initCardArray(){
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> tempCards = cardArrayToUse();

		int count = 0;


		for(int i = 0; i < tempCards.size(); i++){
			for(int f = 0; f <15; f++){
				cards.add((Card) tempCards.get(count));
			}
			count++;
		}
		return cards;

	}

	//instanziert Bewegeungskarten vom Typ Card und setzt diese in eine Liste damit wir auf alle 7 Bewegungskarten zugreifen können
	public ArrayList<Card> cardArrayToUse(){
		Card blue = new Card("blue", moveCardBlue);
		Card brown = new Card("brown", moveCardBrown);
		Card green = new Card("green", moveCardGreen);
		Card grey = new Card("grey", moveCardGrey);
		Card pink = new Card("pink", moveCardPink);
		Card white = new Card("white", moveCardWhite);
		Card yellow = new Card("yellow", moveCardYellow);

		ArrayList<Card> tempCards = new ArrayList<Card>();
		tempCards.add(blue);
		tempCards.add(brown);
		tempCards.add(green);
		tempCards.add(grey);
		tempCards.add(pink);
		tempCards.add(white);
		tempCards.add(yellow);

		return tempCards;
	}


	//gibt uns eine Liste zurück mit allen Bewegungskarten die zufällig verteilt sind
	//total haben wir 105 Karten, jeweils 7 verschiedene Arten à 15 Karten
	public ArrayList<Card> setStartMoveCards(){

		ArrayList<Card> startMoveCards = new ArrayList<Card>(initCardArray());
		ArrayList<Card> proformaCards = new ArrayList<Card>(initCardArray());

		Random rand = new Random();
		int count = 105;

		for (int i = 0; i < startMoveCards.size(); i++){
			int x = rand.nextInt(count);
			startMoveCards.set(i, proformaCards.get(x));
			proformaCards.remove(x);
			count--;
		}

		return startMoveCards;
	}

	//setzt ImageViews in einem Array damit wir auf diese zugreiffen können
	public void initMoveCardArray(){
		moveImages = new ArrayList<ImageView>();

		moveImages.add(moveCard1);
		moveImages.add(moveCard2);
		moveImages.add(moveCard3);
		moveImages.add(moveCard4);
		moveImages.add(moveCard5);
		moveImages.add(moveCard6);
		moveImages.add(moveCard7);
		moveImages.add(moveCard8);
		moveImages.add(moveCard9);
		moveImages.add(moveCard10);
	}

	//zusätzliche Bewegungskarten anzeigen in der zweiten moveCardBox
	public static void addMoveImage(int count){


		for(int i = count; i <= count; i++){
			if(moveImages.get(count).isVisible()){
				count++;
			}
		}


		moveImages.get(count).setVisible(true);
		int countCards = 0;

		currentPlayer.playerCards.add(cards.get(countCards));
		moveImages.get(count).setImage(cards.get(countCards).getImage());
		cards.remove(countCards);

		//Anzahl Bewegungskarten im Deck anzeigen
		String numberOfDeck = String.valueOf(cards.size());
		numOfDeck.setText(numberOfDeck);

		playerCardsNotVisible.clear();

		for(ImageView notVisible : moveImages){
			if(!notVisible.isVisible()){
				playerCardsNotVisible.add(notVisible);
			}
		}


	}



	//zeigt im Player seine mögliche Spielz�ge welche er machen kann
	//wenn sich die mouse über eine Bewegungskarte bewegt, dann wird diese highlightet sowie die 
	//passenden Tiles werden auch gehighlightet
	public void showPossibleMove(MouseEvent event){
		String selectetMoveCard = handleMoveCard(event);

		String subString = selectetMoveCard.substring(8);
		int moveCardPosition = Integer.parseInt(subString);

		Card selectMoveCard = currentPlayer.playerCards.get(moveCardPosition-1);

		ArrayList<Tile> possibleTiles = new ArrayList<Tile>();
		ArrayList<ImageView>possibleTilesArray = new ArrayList<ImageView>();

		for(int i = 0; i < startBoard.size(); i++){
			if(startBoard.get(i).getColor().equals(selectMoveCard.getColor())){
				possibleTiles.add(startBoard.get(i));
				possibleTilesArray.add(tileImages[i]);
			}
		}
		showPossibleTiles(possibleTilesArray);
	}

	//handle MouseEvent Methode welche die anvisierte Bewegungskarte Highlightet (onmouseentered) noch nicht
	//geklickt
	public String handleMoveCard(MouseEvent event){


		ImageView moveCard = (ImageView) event.getSource();
		String selectetMoveCard = moveCard.getId();
		InnerShadow iShadow = new InnerShadow();
		iShadow.setChoke(0.45);
		iShadow.setColor(Color.web("F7FF00"));
		iShadow.setHeight(29.9);
		iShadow.setWidth(29.9);
		iShadow.setRadius(14.45);
		moveCard.setEffect(iShadow);

		return selectetMoveCard;
	}

	//handle MouseEvent Methode welche den Highlight effekt wieder zur�cksetzt sobald die Bewegungskarte
	//mit der Mouse verlassen wird
	public void handleMouseExit(MouseEvent event){
		ImageView moveCard = (ImageView) event.getSource(); ;
		moveCard.setEffect(null);
		tileShadow.setChoke(0);
		tileShadow.setColor(null);
		tileShadow.setHeight(0);
		tileShadow.setWidth(0);
		tileShadow.setRadius(0);
	}

	//methode welche ausgeführt wird bei einem Click auf der Bewegungskarte
	//der Effekt "Highlight" bleibt auf der geklickten Karte mouseExit wird auf null gesetzt
	//das heisst der Effekt bei den dazugehörigen Tiles bleibt,
	//auf den anderen Karten bleibt der mousExit effekt
	//natürlich wenn zwei gleiche Bewegungskarte in der Hand sind, und der Player bei der 
	//nicht gewählten Karten drüber führt wird der mouseExit Effekt ausgelöst somit auch bei den Tiles
	public void moveCardClicked(MouseEvent event){
		ImageView moveCard = (ImageView) event.getSource();
		HBox currentMoveCardBox = (HBox) moveCard.getParent();
		String idCurrentMoveCardBox = currentMoveCardBox.getId();
		String moveCardId = moveCard.getId();
		int positionCurrentMoveCardBox = Integer.parseInt(idCurrentMoveCardBox.substring(12));
		HBox secondMoveCardBox;
		ArrayList<HBox> boxList = new ArrayList<HBox>();

		for(int i = 0; i < 2; i++){
			boxList.add((HBox) currentMoveCardBox.getParent().getChildrenUnmodifiable().get(i));
		}

		boxList.remove(positionCurrentMoveCardBox);
		secondMoveCardBox = boxList.get(0);

		InnerShadow iShadow = new InnerShadow();
		iShadow.setChoke(0.45);
		iShadow.setColor(Color.web("F7FF00"));
		iShadow.setHeight(29.9);
		iShadow.setWidth(29.9);
		iShadow.setRadius(14.45);
		moveCard.setOnMouseExited(null);

		for(int i = 0; i < currentMoveCardBox.getChildren().size(); i++){
			if(!(currentMoveCardBox.getChildren().get(i).getId().equals(moveCardId) || secondMoveCardBox.getChildren().get(i).getId().equals(moveCardId))){
				currentMoveCardBox.getChildren().get(i).setEffect(null);
				secondMoveCardBox.getChildren().get(i).setEffect(null);
				currentMoveCardBox.getChildren().get(i).setOnMouseExited(new EventHandler<MouseEvent>(){
					@Override
					public void handle(MouseEvent event) {
						handleMouseExit(event);		
					}
				});
				secondMoveCardBox.getChildren().get(i).setOnMouseExited(new EventHandler<MouseEvent>(){
					@Override
					public void handle(MouseEvent event) {
						handleMouseExit(event);		
					}
				});
			}
		}
		moveCard.setEffect(iShadow);
		selectetCard = currentPlayer.playerCards.get(Integer.parseInt(moveCardId.substring(8))-1);
		selectetCardImageView = moveCard;
		possibleTilesArray = new ArrayList<ImageView>();
		for(int i = 0; i < startBoard.size(); i++){
			if(startBoard.get(i).getColor().equals(selectetCard.getColor())){
				possibleTilesArray.add(tileImages[i]);
			}
		}
	}

	//effekt welcher bei den Tiles ausgelöst wird wenn eine Bewegungskarte ausgewählt wird
	public static void showPossibleTiles(ArrayList<ImageView> possibleTileArray){

		tileShadow = new InnerShadow();
		tileShadow.setChoke(0.5);
		tileShadow.setColor(Color.web("F7FF00"));
		tileShadow.setHeight(50);
		tileShadow.setWidth(50);
		tileShadow.setRadius(10);

		for(int i = 0 ; i < possibleTileArray.size(); i++){
			possibleTileArray.get(i).setEffect(tileShadow);
		}
	}

	//öffnet das GUI um Karte zu kaufen
	public void switchToBuyCard(){
		if(moveImages.get(moveImages.size()-1).isVisible()){
			setMessage("Du hast das Maximum an Karten!");
		}else{
			if(currentPlayer.getScore() < 2){
				setMessage("Du hast zu wenig Punkte \num Karten zu kaufen!");
			}else{
				try{
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("BuyCard.fxml"));
					Pane rootPane = (Pane) fxmlloader.load();
					Stage stage = new Stage();
					stage.setResizable(false);
					stage.setScene(new Scene(rootPane));
					stage.show();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	// öffnet das GUI um den Move zu bestätigen oder zu canceln
	//vorher wird geprüft ob ein Avatar und eine Karte gewählte wurde
	public void switchToMoveAvatar(){
		if(GameController.selectetAvatar == null || GameController.selectetCard == null){
			setMessage("Bitte Karte und Avatar wählen!");

		}else{
			if(message.isVisible() == true){
				message.setVisible(false);
			}
			try{
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("moveAvatar1.fxml"));
				Pane rootPane = (Pane) fxmlloader.load();
				Stage stage = new Stage();
				stage.setResizable(false);
				stage.setScene(new Scene(rootPane));
				stage.show();
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}

	//setzt den Effekt beim Avatar
	//in der Start Box kann jeweils nur ein Avatar gewählt werden
	//der Effekt wird nur bei einem gesetzt
	//Um während dem Spiel nur ein Avatar zu wählen muss noch ein Code geschrieben werden
	public static void handleSelectetAvatar(MouseEvent event){
		SCircle selectetAvatar = (SCircle) event.getSource();
		InnerShadow avatarShadow = new InnerShadow();
		avatarShadow.setChoke(0.5);
		avatarShadow.setColor(Color.web("F7FF00"));
		avatarShadow.setRadius(11);
		for(int i = 0; i < selectetAvatar.getParent().getChildrenUnmodifiable().size(); i++){
			if(!(selectetAvatar.getParent().getChildrenUnmodifiable().get(i).equals(event.getSource()))){
				selectetAvatar.getParent().getChildrenUnmodifiable().get(i).setEffect(null);
			}
		}
		selectetAvatar.setEffect(avatarShadow);

		GameController.selectetAvatar = selectetAvatar;
		GameController.currentAvatarPosition = (HBox) selectetAvatar.getParent();
	}

	public static Card getSelectetCard(){
		return GameController.selectetCard;
	}

	public static SCircle getSelectetAvatar(){
		return GameController.selectetAvatar;
	}

	public static ArrayList<Tile> getStartBoard(){
		return GameController.startBoard;
	}

	public static ImageView[] getTileImages(){
		return GameController.tileImages;
	}

	public static ArrayList<HBox> getTileBox(){
		return GameController.tileBox;
	}

	public static ImageView getSelectetCardImageView(){
		return GameController.selectetCardImageView;
	}

	public static InnerShadow getTileShadow(){
		return GameController.tileShadow;
	}

	public static void setSelectetAvatar(){
		GameController.selectetAvatar = null;
	}

	public static void setSelectetCard(){
		GameController.selectetCard = null;
	}
	public static ArrayList<ImageView> getPossibleTilesArray(){
		return GameController.possibleTilesArray;
	}

	public static HBox getCurrentAvatarPosition(){
		return GameController.currentAvatarPosition;
	}

	public static void setCurrentAvatarPosition(){
		GameController.currentAvatarPosition = null;
	}

	public static HBox[] getEbPlayer(){
		return GameController.ebPlayer;
	}

	public static ArrayList<Player> getPlayers(){
		return players;
	}

	public static Player getCurrentPlayer(){
		return GameController.currentPlayer;
	}

	public static void setCurrentPlayer(){
		GameController.currentPlayer = players.get(currentPlayerPosition);
	}

	//wird ausgeführt momentan beim MoveAvatar
	//sollte aber beim Spielzug beenden ausgeführt werden
	//damit der currentPlayer nach Spielzug auf den nächsten Player in der Liste
	//gesetzt wird
	public static void setCurrentPlayerPosition(){
		if(currentPlayerPosition == players.size()-1){
			currentPlayerPosition = 0;
		}else{
			currentPlayerPosition++;
		}
	}

	public static int getCurrentPlayerPosition(){
		return GameController.currentPlayerPosition;
	}

	public ObservableList<Player> getPlayersData(){
		return playersData;
	}

	public static void setMessage(String message){
		GameController.message.setText(message);
		GameController.message.setVisible(true);
		GameController.message.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		GameController.message.setTextFill(Color.RED);
		GameController.message.toFront();
	}

	public static ArrayList<ImageView> getPlayerCardsNotVisible() {
		return GameController.playerCardsNotVisible;
	}

	public static void setPlayerCardsNotVisible(){
		playerCardsNotVisible.clear();
		for(ImageView notVisible : moveImages){
			if(!notVisible.isVisible()){
				playerCardsNotVisible.add(notVisible);
			}
		}
	}
}
