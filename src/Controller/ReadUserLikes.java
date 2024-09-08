package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Post;
import Model.User;
import View.Alert;

public class ReadUserLikes {
	
	private ArrayList<Post> posts;
	
	public ReadUserLikes(User u, Database database) {
		posts = new ArrayList<>();
		String select = "SELECT * FROM `likes` WHERE `User` = "+u.getID()+" ;";
		ArrayList<Integer> postsIDs = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				postsIDs.add(rs.getInt("Post"));
			}
			for (int i=0;i<postsIDs.size();i++) {
				posts.add(new ReadPostByID(postsIDs.get(i), database).getPost());
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
	}
	
	public ArrayList<Post> getPosts() {
		return posts;
	}

}
