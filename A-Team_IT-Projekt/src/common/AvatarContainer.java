package common;

import java.io.Serializable;
import java.util.ArrayList;

public class AvatarContainer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7738203829053147578L;

	private ArrayList<Avatar> avatars;
	private ArrayList<String> avatarColors;
	
	
	public AvatarContainer(){
		avatars = new ArrayList<Avatar>();
		avatarColors = new ArrayList<String>();
		
		SetColors();
		SetAvatars();
	}


	private void SetColors() {
		avatarColors.add("RED");
		avatarColors.add("BLUE");
		avatarColors.add("GREEN");
		avatarColors.add("YELLOW");
		
	}


	private void SetAvatars() {
		for(String color : avatarColors){
			for(int i = 0; i < 3; i++){
				Avatar avatar = new Avatar(color);
				avatars.add(avatar);
			}
		}
	}
	
	
	public ArrayList<Avatar> getAvatars() {
		return this.avatars;
	}


	public void setAvatars(ArrayList<Avatar> avatars) {
		this.avatars = avatars;
	}
	
	
	public ArrayList<String> getAvatarColors(){
		return this.avatarColors;
	}
}
