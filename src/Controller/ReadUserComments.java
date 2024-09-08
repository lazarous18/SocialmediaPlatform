package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import Model.Comment;
import Model.Database;
import Model.User;
import View.Alert;
import View.JFrame;
import View.Post;

public class ReadUserComments {
	
	private ArrayList<JPanel> panels;
	
	public ReadUserComments(User u, Database database, JFrame f) {
		panels = new ArrayList<>();
		String select = "SELECT * FROM `comments` WHERE `User` = "+u.getID()+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			ArrayList<Comment> comments = new ArrayList<>();
			ArrayList<Integer> postIDs = new ArrayList<>();
			while (rs.next()) {
				Comment p = new Comment();
				p.setID(rs.getInt("ID"));
				p.setContent(rs.getString("Content"));
				p.setUser(u);
				p.setDateTimeFromString(rs.getString("DateTime"));
				comments.add(p);
				postIDs.add(rs.getInt("Post"));
			}
			for (int i=0;i<comments.size();i++) {
				Model.Post post = new ReadPostByID(postIDs.get(i), database).getPost();
				panels.add(new Post(u, post, database, f));
				panels.add(new View.Comment(comments.get(i)));
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
	}
	
	public ArrayList<JPanel> getPostsWithComments() {
		return panels;
	}

}
