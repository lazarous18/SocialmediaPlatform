package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.User;
import View.Alert;

public class RemoveFriend {
	
	private User user, f;
	private Database database;
	
	public RemoveFriend(User user, Database database, User f) {
		this.user = user;
		this.f = f;
		this.database = database;
	}
	
	public boolean isRemoved() {
		boolean removed = false;
		String delete = "DELETE FROM `friends` WHERE `User` = "+user.getID()+
				" AND `Friend` = "+f.getID()+" ;";
		try {
			database.getStatement().execute(delete);
			removed = true;
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
			removed = false;
		}
		return removed;
	}

}
