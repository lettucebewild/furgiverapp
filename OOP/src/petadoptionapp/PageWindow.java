package petadoptionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PageWindow extends JFrame {
    public PageWindow(String title) {
        setTitle(title);
        setSize(400, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes only this window
        setLayout(new BorderLayout());

        // Main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.decode("#efefda"));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Page heading
        JLabel headingLabel = new JLabel(title);
        headingLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 30));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headingLabel.setForeground(new Color(0, 0, 128));

        // Paragraph content
        JTextArea paragraph = new JTextArea();
        paragraph.setEditable(false);
        paragraph.setLineWrap(true);
        paragraph.setWrapStyleWord(true);
        paragraph.setOpaque(false);
        paragraph.setFont(new Font("Arial Narrow", Font.PLAIN, 18));

        // Link label
        JLabel linkLabel = new JLabel();
        linkLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        linkLabel.setForeground(Color.BLUE);
        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Fill content based on title
        if (title.equalsIgnoreCase("Adopt")) {
            paragraph.setText("Adopting a pet from a shelter gives animals a second chance at life. Our platform makes it easier to find your new best friend. "
                    + "By filling out our form, you're taking the first step toward a loving companionship.");
            linkLabel.setText("<html><a href=''>Fill out the Adoption Form</a></html>");
        } else if (title.equalsIgnoreCase("Donate")) {
            paragraph.setText("Your donation helps us feed, shelter, and provide medical care for rescue animals. Every contribution makes a big difference. "
                    + "Support FurGivers and make the world a better place for our furry friends.");
            linkLabel.setText("<html><a href=''>Go to the Donation Form</a></html>");
        } else if (title.equalsIgnoreCase("Contact")) {
            paragraph.setText("We’d love to hear from you!\n\n"
                    + "📍 Address: 123 Pet Street, Paw City\n"
                    + "📞 Contact Number: (123) 456-7890\n"
                    + "📧 Email: hello@furgivers.org\n"
                    + "🐾 Facebook: fb.com/furgivers\n"
                    + "🐾 Instagram: @furgiversapp");
            linkLabel.setText(""); // No form
        }

        JButton backButton = new JButton("← Back to Main") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 0)); // Transparent fill
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            }
        };

        backButton.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setOpaque(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setForeground(Color.BLACK);

        // Action to close the page
        backButton.addActionListener(e -> dispose());


        // Add components to content panel
        contentPanel.add(headingLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPanel.add(paragraph);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        if (!title.equalsIgnoreCase("Contact")) contentPanel.add(linkLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        contentPanel.add(backButton);

        add(contentPanel, BorderLayout.CENTER);
    }
}
