package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.User;
import View.Alert;

public class ReadUserByID {
	
	private User user;
	
	public ReadUserByID(int ID, Database database) {
		String select = "SELECT * FROM `users` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			user = new User();
			user.setID(ID);
			user.setFirstName(rs.getString("FirstName"));
			user.setLastName(rs.getString("LastName"));
			user.setEmail(rs.getString("Email"));
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
	}
	
	public User getUser() {
		return user;
	}

}
