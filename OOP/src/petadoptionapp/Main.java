package petadoptionapp;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.setLocationRelativeTo(null); // Center the window on screen
			frame.setVisible(true);
		});
	}
}
