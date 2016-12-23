package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import common.Player;

public class ResultController implements Initializable{

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

		calculateWinner();
		
	}


	public void backToLobby(){

		Platform.exit();

	}


	public void calculateWinner(){
		players = GameController.getPlayers();
		score = 0;
		ebPlayer = MoveAvatarController.getEbPlayer();


		for(int i = 0; i < players.size(); i++){
			if(score <= players.get(i).getScore()){
				if(score == players.get(i).getScore()){
					if(ebPlayer[i].getChildren().containsAll(GameController.getPlayersAvatar())){
						score = players.get(i).getScore();
						winner = players.get(i);
					}
				}else{
					score = players.get(i).getScore();
					winner = players.get(i);
				}

			}
		}
		
		l_winner.setText(winner.getUserName() +" ist der Sieger mit\n"+ winner.getScore()+" Punkte\nGlückwunsch!");
		l_winner.setTextFill(Color.RED);
		l_winner.setFont(Font.font(25));
	}
}

