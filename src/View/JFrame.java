package View;

@SuppressWarnings("serial")
public class JFrame extends javax.swing.JFrame {
	
	public JFrame() {
		super("Social Media Platform");
		getContentPane().setBackground(GUIConstants.background);
		setSize(900, 625);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
