package petadoptionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;

public class PetPanel extends JPanel {
	public PetPanel() {
		setBackground(Color.decode("#efefda"));

		JPanel containerPanel = new JPanel(new BorderLayout());
		containerPanel.setBorder(new EmptyBorder(20, 50, 20, 50)); // spacing around edges
		containerPanel.setBackground(Color.decode("#efefda"));

		// 3 pets per row, with gaps
		JPanel petsPanel = new JPanel(new GridLayout(0, 3, 50, 50));
		petsPanel.setBackground(Color.decode("#efefda"));

		// Create 30 sample pets (you can replace paths and names)
		for (int i = 1; i <= 30; i++) {
			String petName = "Pet " + i;
			int age = (i % 10) + 1;
			String description = "This is " + petName + ", age " + age;

			// Placeholder image path (update to your actual image paths)
			String imagePath = "/pets/pet" + i + ".jpg";

			ImageIcon icon;
			try {
				icon = new ImageIcon(getClass().getResource(imagePath));
			} catch (Exception e) {
				icon = new ImageIcon(new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB));
			}
			Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);

			JButton petButton = new JButton(new ImageIcon(scaledImage));
			petButton.setPreferredSize(new Dimension(300, 300));
			petButton.setMargin(new Insets(0, 0, 0, 0));
			petButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			petButton.setBackground(Color.WHITE);
			petButton.setFocusPainted(false);
			petButton.setContentAreaFilled(false);

			final String petDesc = description;
			petButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, petDesc, "Pet Info", JOptionPane.INFORMATION_MESSAGE);
				}
			});

			petsPanel.add(petButton);
		}

		containerPanel.add(petsPanel, BorderLayout.CENTER);
		add(containerPanel);
	}
}
