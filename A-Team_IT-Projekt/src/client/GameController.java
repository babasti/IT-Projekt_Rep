package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import common.Avatar;
import common.AvatarContainer;
import common.Card;
import common.Game;
import common.ImageContainer;
import common.Player;
import common.Tile;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameController implements Initializable{


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



	//Instanzvariablen ArrayListe welche alle Tile Objekte beinhaltet
	//und ImageView Array welche alle ImageView mit ID beinhaltet


	private AvatarContainer avatarContainer;
	private ImageContainer imageContainer;
	private static ArrayList<Tile> startBoard;
	private static ImageView[] tileImages;
	public static ArrayList<ImageView> moveImages;
	public static ArrayList<Card> cards;
	private static InnerShadow tileShadow;
	public static Label numOfDeck;
	Tile Water;
	private static ArrayList<Player> players; 
	private static Card selectetCard;
	private static ImageView selectetCardImageView;
	private static Circle selectetAvatar;
	private static ArrayList<HBox> tileBox;
	private static ArrayList<Tile> proformaStartGameBoard;
	private static ArrayList<ImageView> possibleTilesArray;
	private static HBox currentAvatarPosition;
	private static  HBox[] ebPlayer;
	private HBox[] sbPlayer;
	public static Player currentPlayer;
	private static int currentPlayerPosition = 0;
	static TableView<Player> scoreTable;
	static ObservableList<Player> playersData = FXCollections.observableArrayList();
	static TableColumn<Player, String> userNameColumn = new TableColumn<Player, String>();
	static TableColumn<Player, Integer> scoreColumn = new TableColumn<Player, Integer>();
	static TableColumn<Player, Circle> avatarColorColumn = new TableColumn<Player, Circle>();
	private static Label message;
	private static ArrayList<ImageView> playerCardsNotVisible = new ArrayList<ImageView>();
	private static Game game;
	private static ArrayList<Circle> playerAvatars;
	private static Player myClient;
	private int myClientPosition;



	//initialize Methode instanziert eine startBoard Liste mit Tile Objekte welche zufällig
	//in der Liste gesetzt wurden.
	// mit initTileArray wird die Instanzvariable tileImages initialisiert um ein Array mit allen 
	//ImageViews zu haben
	// danach wird jedes ImageView mit einem Bild aus der startBoard Liste gesetzt.
	//somit haben wir ein visuelles GameBoard
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		imageContainer = new ImageContainer();
		Water = imageContainer.getWater();
		avatarContainer = new AvatarContainer();
		myClient = Player.getPlayerID(ClientThread.getId());


		game = ClientThread.getGame();

		initTileArray();
		initStartBox();
		initEndBox();
		initPlayers();
		initCurrentPlayer();
		initCards();
		initTotalAvatars();
		initNumOfDeck();
		initStartBoard();
		initMoveCardArray();
		initPlayerMoveCards();
		initPlayerAvatars();


		initScoreTable();
		initMessage();

		for(Player player : players){
			if(myClient.getClientID() == player.getClientID()){
				myClientPosition = players.indexOf(player);
			}
		}
	}	

	private void initStartBox(){

		sbPlayer = new HBox[4];
		sbPlayer[0] = sb_player1;
		sbPlayer[1] = sb_player2;
		sbPlayer[2] = sb_player3;
		sbPlayer[3] = sb_player4;

	}

	public void initEndBox(){
		ebPlayer = new HBox[4];
		ebPlayer[0] = eb_player1;
		ebPlayer[1] = eb_player2;
		ebPlayer[2] = eb_player3;
		ebPlayer[3] = eb_player4;
	}

	//avatar Listen von den Player holen und in eine arrayListe speichern und diese Listen in eine gesamt Liste speichern
	//vielleicht geht es auch direkt noch nicht probiert
	public void initTotalAvatars(){
		new ArrayList<Avatar>();
		avatarContainer.getAvatars();
	}

	public void initNumOfDeck(){
		numOfDeck = new Label();
		//Label mit folgende Eigenschaften zur StackPane hinzufügen
		numOfDeck.setFont(Font.font("System", FontWeight.BOLD, 40));
		numOfDeck.setTextFill(Color.WHITE);
		numOfDeck.setAlignment(Pos.CENTER);
		movementCards.getChildren().add(numOfDeck);

		//Anzahl Bewegungskarten im Deck anzeigen
		String numberOfDeck = String.valueOf(cards.size());
		numOfDeck.setText(numberOfDeck);
	}

	public void initCards(){
		cards = new ArrayList<Card>(game.getCards());
	}

	public void initStartBoard(){
		startBoard = new ArrayList<Tile>(game.getStartBoard());
		int countTile = 0;
		for(int i = 0; i < startBoard.size(); i++){
			Image img = new Image(FileProvider.getFileProvider().getFile(startBoard.get(i).getImage().getimagePath()));
			tileImages[countTile].setImage(img);
			countTile++;
		}
		proformaStartGameBoard = game.getProformaStartGameBoard();
	}

	public void initCurrentPlayer(){
		currentPlayer = game.getCurrentPlayer();
	}

	public void initScoreTable(){
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
		
		avatarColorColumn.setCellValueFactory(new PropertyValueFactory<Player, Circle>("avatarCircle"));


		scoreTable.setItems(playersData);
		scoreTable.getColumns().clear();
		scoreTable.getColumns().addAll(userNameColumn, scoreColumn, avatarColorColumn);
	}

	public void initMessage(){
		message = new Label();
		message.setLayoutX(800);
		message.setLayoutY(650);
		message.setVisible(false);
		rootPane.getChildren().add(message);

		if(myClient.getClientID() == currentPlayer.getClientID()){
			setMessage("Du bist dran!");
		}else{
			setMessage(currentPlayer.getUserName()+" ist dran!");
		}
	}

	public void initPlayers(){
		players = new ArrayList<Player>();
		for(int i = 0; i < game.getSession().getPlayers().length; i++){
			players.add(game.getSession().getPlayers()[i]);
		}
	}

	public void initPlayerAvatars(){

		playerAvatars = new ArrayList<Circle>();
		//den avatars die zuständige farbe zuteilen und in die entsprechenden Boxen zuteilen
		Circle circle;

		for(int y = 0; y < players.size(); y++){
			for(int i = 0; i < 3; i++){
				sbPlayer[y].getChildren().add(circle = CreateCircle.getCreateCircle().createCircle(players.get(y).getPlayerAvatars().get(i)));
				sbPlayer[y].setVisible(true);
				sbPlayer[y].toFront();
				if(y == myClientPosition){
					playerAvatars.add(circle);
				}
			}

		}


		//handler für alle Avatars setzen, sobald ein Avatar gewählt wurde durch Click wird der Effekt gesetzt
		//der Player kann jeweils nur einen Avatar wählen in der StartBox


		for(int i = 0; i < 3; i++){
			sbPlayer[myClientPosition].getChildren().get(i).setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					handleSelectetAvatar(event);
				}
			});
		}
	}

	public void initPlayerMoveCards(){

		for(Player player : players){
			if(myClient.getClientID() == player.getClientID()){
				myClient.setPlayerCards(player.getPlayerCards());
			}
		}

		int countMoveCard = 0;
		for(int i = 0; i < myClient.getPlayerCards().size(); i++){			
			moveImages.get(countMoveCard).setImage(new Image(FileProvider.getFileProvider().getFile(myClient.getPlayerCards().get(i).getImage().getimagePath())));
			countMoveCard++;
		}

		for(ImageView notVisible : moveImages){
			if(!notVisible.isVisible()){
				playerCardsNotVisible.add(notVisible);
			}
		}
	}


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

		for(Tile tile : imageContainer.getTiles().values()){
			startGameBoard.add(tile);
		}

		proformaStartGameBoard.add(Water);

		return startGameBoard;
	}

	// Player beendet seinen spielzug und das Game Objekt wird an den Server gesendet
	// und vom Server zu den anderen Clients
	public void finishTurn(){
		setCurrentPlayerPosition();
		setCurrentPlayer();
		setMessage(currentPlayer.getUserName()+" ist dran!");
		game.setStartBoard(startBoard);
		game.setCurrentPlayer(currentPlayer);
		game.setCurrentPlayerPosition(currentPlayerPosition);
		game.setCards(cards);
		game.setPlayers(players);
		game.setWhat("spielzugBeendet");


		ClientThread.sendToServer(game);
		//hier wird die methode sendToServer aufgerufen

	}	


	//wird ausgelöst wenn der Spieler sein Avatar auf eine entsprechendes Tile setzen will
	//die Methode ersetzt das vorherige Tile mit "Wasser" und gibt die Punktzahlt des Tiles zurück
	//um die Punktzahl danach dem Score vom Spieler zu summieren
	public static void collectTile(Tile selectetTile, int position){
		ImageContainer imgContainer = new ImageContainer();		
		Tile Water = imgContainer.getWater();

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
				tileImages[position-countPosition].setImage(new Image(FileProvider.getFileProvider().getFile(startBoard.get(position-countPosition).getImage().getimagePath())));
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
					tileImages[position-countPosition].setImage(new Image(FileProvider.getFileProvider().getFile(startBoard.get(position-countPosition).getImage().getimagePath())));
				}while(points == 0);
			}
		}

		//die Score Tabelle wird aktualisiert mit den entsprechenden Punkten
		updateTableview();
	}

	//collectLastTile() wird aufgerufen falls der Player aufs Land gelangt,
	//ihm wird das entsprechende letzte verfügbare Tile zugewiesen
	public static void collectLastTile(){
		ImageContainer container = new ImageContainer();
		Tile Water = container.getWater();
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
			tileImages[lastTilePosition-countPosition].setImage(new Image(FileProvider.getFileProvider().getFile(startBoard.get(lastTilePosition-countPosition).getImage().getimagePath())));
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
			tileImages[lastTilePosition-countPosition].setImage(new Image(FileProvider.getFileProvider().getFile(startBoard.get(lastTilePosition-countPosition).getImage().getimagePath())));
		}

		updateTableview();

	}

	//gibt eine Liste zurück mit 105 Bewegungskarten jeweils 7 Arten à  15 Karten
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
		ArrayList<Card> cards = new ArrayList<Card>();
		for(Card card : imageContainer.getCards()) {
			cards.add(card);
		}
		return cards;
	}


	//gibt uns eine Liste zurück mit allen Bewegungskarten die zufällig verteilt sind
	//total haben wir 105 Karten, jeweils 7 verschiedene Arten à  15 Karten
	public  ArrayList<Card> setStartMoveCards(){

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

		currentPlayer.getPlayerCards().add(cards.get(countCards));

		Image img = new Image(FileProvider.getFileProvider().getFile(cards.get(countCards).getImage().getimagePath()));
		moveImages.get(count).setImage(img);

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



	//zeigt im Player seine mögliche Spielzüge welche er machen kann
	//wenn sich die mouse über eine Bewegungskarte bewegt, dann wird diese highlightet sowie die 
	//passenden Tiles werden auch gehighlightet
	public void showPossibleMove(MouseEvent event){
		String selectetMoveCard = handleMoveCard(event);

		String subString = selectetMoveCard.substring(8);
		int moveCardPosition = Integer.parseInt(subString);

		Card selectMoveCard = myClient.getPlayerCards().get(moveCardPosition-1);

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

	//handle MouseEvent Methode welche den Highlight effekt wieder zurücksetzt sobald die Bewegungskarte
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
		selectetCard = currentPlayer.getPlayerCards().get(Integer.parseInt(moveCardId.substring(8))-1);
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
		if(game.getCards().size() == 1){
			setMessage("Karte kaufen ist nicht möglich!");
		}else{
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
		Circle selectetAvatar = (Circle) event.getSource();
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

	public static Circle getSelectetAvatar(){
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
		return ebPlayer;
	}

	public static ArrayList<Player> getPlayers(){
		return players;
	}

	public static Player getCurrentPlayer(){
		return GameController.currentPlayer;
	}

	public void setCurrentPlayer(){
		currentPlayer = players.get(currentPlayerPosition);
	}


	//damit der currentPlayer nach Spielzug auf den nächsten Player in der Liste
	//gesetzt wird
	public void setCurrentPlayerPosition(){
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

	public static ArrayList<Circle> getPlayersAvatar(){
		return playerAvatars;
	}

	public static void showGame(){
		Platform.runLater(new Runnable(){
			public void run(){
				Client.loadGame();
			}
		});	
	}


	public static void updateGame(Game game){
		GameController.game = game;
		for(int i = 0; i < GameController.game.getPlayers().length; i++){
			players.set(i, GameController.game.getPlayers()[i]);
		}
		//update Tiles
		startBoard = game.getStartBoard();
		//update cards (Deck)
		cards = game.getCards();
		//update currentPlayer
		currentPlayer = game.getCurrentPlayer();
		
		Platform.runLater(new Runnable(){
			public void run(){
				//Tiles von startBoard Liste setzen
				int countTile = 0;
				for(int i = 0; i < startBoard.size(); i++){
					Image img = new Image(FileProvider.getFileProvider().getFile(startBoard.get(i).getImage().getimagePath()));
					tileImages[countTile].setImage(img);
					countTile++;
				}


				//update numOfDeck
				String numberOfDeck = String.valueOf(cards.size());
				numOfDeck.setText(numberOfDeck);

				//update Message
				updateMessage();

				//die Score Tabelle wird aktualisiert mit den entsprechenden Punkten
				updateTableview();

			}
		});
	}

	protected static void updateTableview() {
		scoreTable.getColumns().clear();
		userNameColumn.setText("SpielerName");
		scoreColumn.setText("Score");
		avatarColorColumn.setText("Spielfigur");
		userNameColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("userName"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("score"));
		avatarColorColumn.setCellValueFactory(new PropertyValueFactory<Player, Circle>("avatarCircle"));

		scoreTable.setItems(playersData);
		scoreTable.getColumns().addAll(userNameColumn, scoreColumn, avatarColorColumn);
		
	}

	public static void setGame(Game game){
		GameController.game = game;
	}

	public static void updateMessage(){
		if(myClient.getClientID() == currentPlayer.getClientID()){
			setMessage("Du bist dran!");
		}else{
			setMessage(currentPlayer.getUserName()+" ist dran!");
		}
	}
	
}
