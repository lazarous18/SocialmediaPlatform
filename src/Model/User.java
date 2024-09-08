package Model;

import java.util.ArrayList;

public class User {
	
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private ArrayList<Integer> likesIDs;
	private ArrayList<Integer> friendsIDs;
	
	public User() {
		likesIDs = new ArrayList<>();
		friendsIDs = new ArrayList<>();
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Integer> getLikesIDs() {
		return likesIDs;
	}
	
	public void setLikesIDs(ArrayList<Integer> likesIDs) {
		this.likesIDs = likesIDs;
	}
	
	public boolean liked(Post p) {
		return likesIDs.contains(p.getID());
	}
	
	public void like(Post p) {
		likesIDs.add(p.getID());
	}
	
	public void dislike(Post p) {
		likesIDs.remove( (Integer) p.getID());
	}
	
	public void setFriends(ArrayList<User> friends) {
		friendsIDs = new ArrayList<>();
		for (User u : friends) {
			friendsIDs.add(u.getID());
		}
	}
	
	public void setFriendsIDs(ArrayList<Integer> friendsIDs) {
		this.friendsIDs = friendsIDs;
	}
	
	public ArrayList<Integer> getFriendsIDs() {
		return friendsIDs;
	}
	
	public boolean isFriend(User u) {
		return friendsIDs.contains(u.getID());
	}
	
	public void addFriend(User f) {
		friendsIDs.add(f.getID());
	}
	
	public void removeFriend(User f) {
		friendsIDs.remove((Integer) f.getID());
	}

}
