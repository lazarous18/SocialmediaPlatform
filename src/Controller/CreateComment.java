package Controller;

import java.sql.SQLException;

import Model.Comment;
import Model.Database;
import Model.Post;
import Model.User;
import View.Alert;

public class CreateComment {
	
	private Comment c;
	private Post p;
	private User u;
	private Database database;
	
	public CreateComment(Comment c, Post p, User u, Database database) {
		this.c = c;
		this.p = p;
		this.u = u;
		this.database = database;
	}
	
	public boolean commented() {
		boolean commented = false;
		String insert = "INSERT INTO `comments`(`Content`, `Post`, `User`, `DateTime`)"
				+ " VALUES ('"+c.getContent()+"','"+p.getID()+"','"+u.getID()+"','"
				+c.getDateTimeToString()+"');";
		try {
			database.getStatement().execute(insert);
			commented = true;
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			commented = false;
		}
		return commented;
	}

}
