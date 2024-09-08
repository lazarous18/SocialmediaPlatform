package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Post;
import Model.User;
import View.Alert;

public class DislikePost {
	
	private User u;
	private Post p;
	private Database database;
	
	public DislikePost(User u, Post p, Database database) {
		this.u = u;
		this.p = p;
		this.database = database;
	}
	
	public boolean isDisiked() {
		boolean disliked = false;
		String delete = "DELETE FROM `likes` WHERE `User` = "+u.getID()
				+" AND `Post` = "+p.getID()+" ;";
		try {
			database.getStatement().execute(delete);
			disliked = true;
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			disliked = false;
		}
		return disliked;
	}

}
