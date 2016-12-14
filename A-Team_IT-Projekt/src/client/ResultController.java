package client;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ResultController implements Initializable, Serializable {

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
		l_winner.setFont(Font.font(25));

		System.out.println(players.get(0).getUserName()+" "+players.get(0).getScore());
		System.out.println(players.get(1).getUserName()+" "+players.get(1).getScore());
		System.out.println(players.get(2).getUserName()+" "+players.get(2).getScore());
		System.out.println(players.get(3).getUserName()+" "+players.get(3).getScore());
	}



	public void backToLobby(){


	}



}
