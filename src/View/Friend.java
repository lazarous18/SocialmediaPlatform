package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Controller.AddFriend;
import Controller.RemoveFriend;
import Model.Database;
import Model.User;


@SuppressWarnings("serial")
public class Friend extends JPanel {
	
	public Friend(User mainUser, Database database, User u) {
		setLayout(new BorderLayout());
		setBackground(GUIConstants.white);
		setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
		
		JLabel author = new JLabel(u.getName(), 20, GUIConstants.post, Font.BOLD);
		add(author, BorderLayout.WEST);
		
		JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		right.setBackground(null);
		
		JButton addFriend = new JButton("Follow", 35, 16);
		addFriend.setPreferredSize(new Dimension(81, 37));
		addFriend.setVisible(false);
		right.add(addFriend);
		
		JLabel remove = new JLabel("Unfollow", 16, GUIConstants.blue, Font.BOLD);
		remove.setCursor(new Cursor(Cursor.HAND_CURSOR));
		remove.setVisible(false);
		remove.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		remove.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new RemoveFriend(mainUser, database, u).isRemoved()) {
					mainUser.removeFriend(u);
					remove.setVisible(false);
					addFriend.setVisible(true);
				}
			}
		});
		right.add(remove);
		
		if (mainUser.isFriend(u)) {
			addFriend.setVisible(false);
			remove.setVisible(true);
		} else {
			addFriend.setVisible(true);
			remove.setVisible(false);
		}
		
		addFriend.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new AddFriend(mainUser, database, u).isAdded()) {
					mainUser.addFriend(u);
					addFriend.setVisible(false);
					remove.setVisible(true);
				}
			}
		});
		
		add(right);
		
		Dimension dimension = new Dimension(500, 67);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
	}

}
