package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Model.Database;
import Model.User;

public class ChangePassword {
	
	public ChangePassword(User user, Database database) {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(83, 99, 175, 99));
		panel.add(new JLabel("Change Password", 40, GUIConstants.blue, Font.BOLD),
				BorderLayout.NORTH);
		
		JPanel center = new JPanel(new GridLayout(4, 1, 10, 10));
		center.setBackground(null);
		center.setBorder(BorderFactory.createEmptyBorder(58, 216, 0, 216));
		
		JTextField oldPassword = new JTextField("Old Password");
		center.add(oldPassword);
		JTextField newPassword = new JTextField("New Password");
		center.add(newPassword);
		JTextField confirmPassword = new JTextField("Confirm Password");
		center.add(confirmPassword);
		JButton submit = new JButton("Submit", 45, 20);
		submit.addMouseListener(new MouseListener() {
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
				if (oldPassword.isEmpty()) {
					new Alert("Please enter your old password", frame);
					return;
				}
				if (!oldPassword.getText().equals(user.getPassword())) {
					new Alert("Old password doesn't match", frame);
					return;
				}
				if (newPassword.isEmpty()) {
					new Alert("Please enter new password", frame);
					return;
				}
				if (newPassword.getText().length()<6) {
					new Alert("Password must contains at least 6 characters", frame);
					return;
				}
				if (confirmPassword.isEmpty()) {
					new Alert("Please confirm password", frame);
					return;
				}
				if (!newPassword.getText().equals(confirmPassword.getText())) {
					new Alert("Password doesn't match", frame);
					return;
				}
				Controller.ChangePassword change = new Controller.ChangePassword(
						newPassword.getText(), user.getID(), database);
				if (change.change()) {
					new Home(user, database);
					new Alert("Password changed successfully", frame);
					frame.dispose();
				}
				
			}
		});
		center.add(submit);
		
		panel.add(center, BorderLayout.CENTER);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.requestFocus();
	}

}
