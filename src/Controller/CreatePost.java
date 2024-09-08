package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Post;
import View.Alert;

public class CreatePost {
	
	private Post post;
	private Database database;
	
	public CreatePost(Post post, Database database) {
		this.post = post;
		this.database = database;
	}
	
	public boolean posted() {
		boolean posted = false;
		String insert = "INSERT INTO `posts`(`Content`, `User`, `DateTime`) VALUES"
				+ " ('"+post.getContent()+"','"+post.getUser().getID()+"','"+
				post.getDateTimeToString()+"');";
		try {
			database.getStatement().execute(insert);
			posted = true;
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			posted = false;
		}
		return posted;
	}

}
