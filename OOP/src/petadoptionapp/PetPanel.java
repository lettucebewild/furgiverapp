package petadoptionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class PetPanel extends JPanel {
	public PetPanel() {
		// Set the background color of the pet panel to white
		setBackground(Color.decode("#efefda"));

		// Create a panel with BorderLayout to add gaps on the sides
		JPanel containerPanel = new JPanel(new BorderLayout());
		containerPanel.setBorder(new EmptyBorder(0, 10, 0, 10)); // Top, left, bottom, right gaps
		containerPanel.setBackground(Color.decode("#efefda")); // Set background to white

		// Create a panel for the pets with GridLayout
		JPanel petsPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // Horizontal and vertical gaps of 10 pixels
		petsPanel.setBackground(Color.decode("#efefda")); // Set background to white

		// Example pets
		Pet[] pets = { new Cat("Whiskers", 2, "Friendly cat", "path/to/cat.jpg"),
				new Dog("Buddy", 3, "Playful dog", "path/to/dog.jpg"),
				new Cat("Mittens", 1, "Cute and cuddly", "path/to/cat2.jpg"),
				new Dog("Max", 4, "Loyal companion", "path/to/dog2.jpg"),
				new Cat("Whiskers", 2, "Friendly cat", "path/to/cat3.jpg.jpg"),
				new Dog("Buddy", 3, "Playful dog", "path/to/dog3.jpg"),
				new Cat("Mittens", 1, "Cute and cuddly", "path/to/cat4.jpg"),
				new Dog("Max", 4, "Loyal companion", "path/to/dog4.jpg"),
				// Add more pets as needed
		};

		for (Pet pet : pets) {
			JButton petButton = new JButton(new ImageIcon(pet.getImagePath()));
			petButton.setPreferredSize(new Dimension(150, 150)); // Set smaller button size

			// Add margin around the button
			petButton.setMargin(new Insets(10, 10, 10, 10)); // Top, left, bottom, right margins

			petButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Show details panel
					JOptionPane.showMessageDialog(null, pet.getDescription());
				}
			});
			petsPanel.add(petButton);
		}

		// Add the pets panel to the container panel
		containerPanel.add(petsPanel, BorderLayout.CENTER);
		add(containerPanel);
	}
}