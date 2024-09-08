package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controller.DislikePost;
import Controller.LikePost;
import Controller.ReadPostComments;
import Controller.ReadPostLikes;
import Model.Database;
import Model.User;

@SuppressWarnings("serial")
public class Post extends JPanel {
	
	private JLabel likesCounter;
	private Model.Post post;
	private Database database;
	
	public Post(User u, Model.Post post, Database database, JFrame f) {
		this.post = post;
		this.database = database;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(GUIConstants.white);
		setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 25));
		
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(null);
		
		JLabel author = new JLabel(post.getUser().getName(), 20, GUIConstants.post,
						Font.BOLD);
		header.add(author, BorderLayout.WEST);
		
		JLabel date = new JLabel(post.getDateToString(), 15, GUIConstants.post, Font.PLAIN);
		header.add(date, BorderLayout.EAST);
		
		add(header);
		add(Box.createVerticalStrut(7));
		
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEADING));
		center.setBackground(null);
		JTextArea content = new JTextArea(post.getContent(), 18,
				GUIConstants.post, Font.PLAIN);
		center.add(content);
		add(center);
		add(Box.createVerticalStrut(7));
		
		JPanel bottom = new JPanel(new BorderLayout());
		bottom.setBackground(null);
		
		JPanel likes = new JPanel(new FlowLayout(FlowLayout.LEFT, 13, 13));
		likes.setBackground(null);
		
		javax.swing.JLabel like = new javax.swing.JLabel(new ImageIcon("pics/like.png"));
		like.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (u.liked(post)) {
			like.setIcon(new ImageIcon("pics/liked.png"));
		} else {
			like.setIcon(new ImageIcon("pics/like.png"));
		}
		like.addMouseListener(new MouseListener() {
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
				if (!u.liked(post)) {
					if (new LikePost(u, post, database).isLiked()) {
						like.setIcon(new ImageIcon("pics/liked.png"));
						u.like(post);
					}
				} else {
					if (new DislikePost(u, post, database).isDisiked()) {
						like.setIcon(new ImageIcon("pics/like.png"));
						u.dislike(post);
					}
				}
				refreshLikesCounter();
			}
		});
		likes.add(like);
		
		likesCounter = new JLabel("", 15, GUIConstants.textFieldHint, Font.BOLD);
		refreshLikesCounter();
		likes.add(likesCounter);
		bottom.add(likes, BorderLayout.WEST);
		
		int commentsCount = new ReadPostComments(post, database).getCommentsCount();
		JLabel comments = new JLabel("", 15, GUIConstants.textFieldHint,
				Font.BOLD);
		comments.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (commentsCount<2) {
			comments.setText(commentsCount+" Comment");
		} else {
			comments.setText(commentsCount+" Comments");
		}
		comments.addMouseListener(new MouseListener() {	
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
				new Comments(u, post, database);
				f.dispose();
			}
		});
		bottom.add(comments, BorderLayout.EAST);
		add(bottom);
		
		int height = (int) (115+content.getPreferredSize().getHeight());
		
		Dimension dimension = new Dimension(500, height);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
	}
	
	private void refreshLikesCounter() {
		int likesCount = new ReadPostLikes(post, database).getLikesCount();
		if (likesCount<2) {
			likesCounter.setText(likesCount + " Like");
		} else {
			likesCounter.setText(likesCount + " Likes");
		}
	}

}
