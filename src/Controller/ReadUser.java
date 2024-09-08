package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.User;
import View.Alert;

public class ReadUser {
	
	private boolean loggedIn;
	private User user;
	
	public ReadUser(String email, String password, Database database) {
		String select = "SELECT * FROM `users` WHERE `Email` = '"+email+
				"' AND `Password` = '"+password+"';";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			loggedIn = rs.next();
			if (loggedIn) {
				user = new User();
				user.setID(rs.getInt("ID"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("Password"));
				
				String findFriends = "SELECT * FROM `friends` WHERE `User` = "
						+user.getID()+" ;";
				ResultSet rs2 = database.getStatement().executeQuery(findFriends);
				ArrayList<Integer> friendsIDs = new ArrayList<>();
				while (rs2.next()) {
					friendsIDs.add(rs2.getInt("Friend"));
				}
				user.setFriendsIDs(friendsIDs);
				
				String findLikedPosts = "SELECT * FROM `likes` WHERE `User` = "+
							user.getID()+" ;";
				ResultSet rs3 = database.getStatement().executeQuery(findLikedPosts);
				ArrayList<Integer> likedPostsIDs = new ArrayList<>();
				while (rs3.next()) {
					likedPostsIDs.add(rs3.getInt("Post"));
				}
				user.setLikesIDs(likedPostsIDs);
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
	}
	
	public boolean loggedIn() {
		return loggedIn;
	}
	
	public User getUser() {
		return user;
	}

}
