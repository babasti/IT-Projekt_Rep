package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ResultController implements Initializable {

	@FXML
	Label l_winner;
	@FXML
	Button b_BackToLobby;
	private ArrayList<Player> players;
	private Player winner;
	private int score;
	private HBox[] ebPlayer;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		players = GameController.getPlayers();
		score = 0;
		ebPlayer = MoveAvatarController.getEbPlayer();


		for(int i = 0; i < players.size(); i++){
			if(score <= players.get(i).getScore()){
				if(score == players.get(i).getScore()){
					if(ebPlayer[i].getChildren().containsAll(players.get(i).getAvatar())){
						score = players.get(i).getScore();
						winner = players.get(i);
					}
				}else{
					score = players.get(i).getScore();
					winner = players.get(i);
				}

			}
		}
		
		l_winner.setText(winner.getUserName() +" ist der Sieger mit\n"+ winner.getScore()+" Punkte\nGlückwunsch Brate!");
		l_winner.setTextFill(Color.RED);
		l_winner.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
	}

	public void backToLobby(){
		
		try{
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Lobby.fxml"));
			Pane rootPane = (Pane) fxmlloader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(rootPane));
			stage.show();
			
		
			Stage result = (Stage)b_BackToLobby.getScene().getWindow();
			result.close();
			Stage game = (Stage) GameController.scoreTable.getScene().getWindow();
			game.close();
		}catch (Exception e){
			e.printStackTrace();
		}

	}



}
