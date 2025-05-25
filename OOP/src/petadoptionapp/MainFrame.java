package petadoptionapp;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("FurGivers");
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Set background
		getContentPane().setBackground(Color.decode("#efefda"));

		// Logo label (outside nav box)
		ImageIcon logoIcon = new ImageIcon(MainFrame.class.getResource("/Logo.png"));
		Image scaledLogo = logoIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));

		// Panel for logo and navBox
		JPanel topWrapper = new JPanel(new BorderLayout());
		topWrapper.setBackground(Color.decode("#efefda"));
		topWrapper.add(logoLabel, BorderLayout.WEST);

		// Navigation buttons container with rounded border
		JPanel navBox = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(getBackground());
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
			}

			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(1));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
			}
		};
		navBox.setOpaque(false);
		navBox.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		navBox.setBackground(Color.decode("#efefda"));

		// Add menu buttons using custom MenuButton class
		String[] menuItems = { "Adopt", "Donate", "Contact" };
		for (String item : menuItems) {
			navBox.add(new MenuButton(item));
		}

		JPanel navRightWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
		navRightWrapper.setOpaque(false);
		navRightWrapper.add(navBox);

		topWrapper.add(navRightWrapper, BorderLayout.CENTER);
		topWrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		add(topWrapper, BorderLayout.NORTH);

		// Info section below nav - keep unchanged
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setBackground(Color.decode("#efefda"));
		infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // Padding

		// Heading
		JLabel headingLabel = new JLabel("FurGivers");
		headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		headingLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 35)); // Arial Narrow bold 26
		headingLabel.setForeground(new Color(0, 0, 128)); // Navy Blue

		// Paragraph as JTextArea for proper multiline wrapping
		JTextArea paragraphArea = new JTextArea(
				"is a platform that connects kind individuals with cats and dogs in local shelters. Adopters can fill out a form to start the screening process.\n\n"
						+ "We aim to make it easier to find pets in need. You can adopt or donate to help improve their lives.\n\n"
						+ "Every pet deserves a second chance\nand every home deserves a little more love.\n\n"
						+ "Be a FurGiver!");

		paragraphArea.setEditable(false);
		paragraphArea.setLineWrap(true);
		paragraphArea.setWrapStyleWord(true);
		paragraphArea.setOpaque(false);
		paragraphArea.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		paragraphArea.setForeground(Color.BLACK);
		paragraphArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		paragraphArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		paragraphArea.setMaximumSize(new Dimension(360, Short.MAX_VALUE));

		// Container for the paragraph
		JPanel paragraphContainer = new JPanel();
		paragraphContainer.setLayout(new BoxLayout(paragraphContainer, BoxLayout.Y_AXIS));
		paragraphContainer.setBackground(Color.decode("#efefda"));
		paragraphContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		paragraphContainer.add(paragraphArea);

		// Add heading and paragraph container to infoPanel
		infoPanel.add(headingLabel);
		infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		infoPanel.add(paragraphContainer);

		// Pet panel (scrollable content after the paragraph)
		PetPanel petPanel = new PetPanel();
		petPanel.setBackground(Color.decode("#efefda")); // ensure PetPanel also matches

		// Create a new panel that holds infoPanel + petPanel vertically for scrolling
		JPanel scrollContent = new JPanel();
		scrollContent.setLayout(new BoxLayout(scrollContent, BoxLayout.Y_AXIS));
		scrollContent.setBackground(Color.decode("#efefda"));
		scrollContent.add(infoPanel);
		scrollContent.add(Box.createRigidArea(new Dimension(0, 30)));
		scrollContent.add(petPanel);

		// JScrollPane contains the whole content starting from heading + paragraph +
		// petPanel
		JScrollPane scrollPane = new JScrollPane(scrollContent);
		scrollPane.setBackground(Color.decode("#efefda"));
		scrollPane.getViewport().setBackground(Color.decode("#efefda")); // fixes inside scroll area
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));

		add(scrollPane, BorderLayout.CENTER);

		// Footer
		JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				setOpaque(false); // Fully transparent background
			}

			@Override
			protected void paintBorder(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(0.5f)); // Thinnest border
				int width = getWidth();
				int height = getHeight();
				g2.drawRect(0, 0, width - 1, height - 1); // All 4 sides
			}
		};
		footerPanel.setOpaque(false);
		footerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Vertical padding only

		JLabel footerLabel = new JLabel("2025 FurGivers © All Rights Reserved ");
		footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		footerLabel.setForeground(new Color(0, 0, 128)); // Navy blue text
		footerPanel.add(footerLabel);

		add(footerPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}

class MenuButton extends JButton {
	public MenuButton(String text) {
		super(text);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setForeground(new Color(0, 0, 128)); // Navy Blue
		setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		setOpaque(false);
	}
}
