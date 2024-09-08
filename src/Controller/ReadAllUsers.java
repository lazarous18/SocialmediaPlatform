package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.User;
import View.Alert;

public class ReadAllUsers {
	
	private ArrayList<User> users;
	
	public ReadAllUsers(Database database, User user) {
		String select = "SELECT * FROM `users`;";
		users = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				User u = new User();
				u.setID(rs.getInt("ID"));
				u.setFirstName(rs.getString("FirstName"));
				u.setLastName(rs.getString("LastName"));
				u.setEmail(rs.getString("Email"));
				if (u.getID()!=user.getID()) users.add(u);
			}
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
	}
	
	public ArrayList<User> getList() {
		return users;
	}

}
