package petadoptionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

	public Font loadCustomFont(String fontFileName, float size) {
	    try {
	        Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/" + fontFileName));
	        return customFont.deriveFont(size);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new Font("SansSerif", Font.PLAIN, (int) size);
	    }
	}


    public MainFrame() {
        setTitle("FurGivers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setLocationRelativeTo(null);

        // === Background Panel ===
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bgImage = new ImageIcon(getClass().getResource("/homepagebg.png")).getImage();
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // === Top Wrapper with Logo and Navigation ===
        JPanel topWrapper = new JPanel(new BorderLayout());
        topWrapper.setOpaque(false);
        topWrapper.setBorder(BorderFactory.createEmptyBorder(25, 50, 50, 50));

        // === Logo ===
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/1.png"));
        Image scaledLogo = logoIcon.getImage().getScaledInstance(300, 80, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        topWrapper.add(logoLabel, BorderLayout.WEST);

        // === Navigation Buttons with Rounded Box ===
        JPanel navBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 60, 60);
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(0, 0, 128));
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 60, 60);
            }
        };
        navBox.setOpaque(false);
        navBox.setBackground(Color.decode("#efefda"));
        navBox.setLayout(new FlowLayout(FlowLayout.CENTER, 35, 5));

        Font navFont = loadCustomFont("Arial Nova Cond.ttf", 32f);
        String[] menuItems = { "Home", "About", "Find a Pet", "Donate", "Contact" };
        for (String item : menuItems) {
            MenuButton btn = new MenuButton(item, navFont);
            btn.addActionListener(e -> {
                PageWindow page = new PageWindow(item);
                page.setVisible(true);
            });
            navBox.add(btn);
        }

        JPanel navRightWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        navRightWrapper.setOpaque(false);
        navRightWrapper.add(navBox);
        topWrapper.add(navRightWrapper, BorderLayout.CENTER);

        backgroundPanel.add(topWrapper, BorderLayout.NORTH);

        // === Center Panel with Headings ===
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(80, 580, 20, 20));

        Font headingFont = loadCustomFont("Cubao Narrow.ttf", 100f);
        Font taglineFont = loadCustomFont("Arial Nova COnd.ttf", 35f);

        JLabel headingLabel = new JLabel("FURGIVERS:");
        headingLabel.setFont(headingFont);
        headingLabel.setForeground(new Color(0, 0, 128));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subline = new JLabel("Paws of Hope");
        subline.setFont(headingFont);
        subline.setForeground(new Color(0, 0, 128));
        subline.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagline = new JLabel("Compassion and Responsibility for Animals");
        tagline.setFont(taglineFont);
        tagline.setForeground(Color.BLACK);
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);

        infoPanel.add(headingLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(subline);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(tagline);

        backgroundPanel.add(infoPanel, BorderLayout.CENTER);

        // === Footer ===
        JLabel footerLabel = new JLabel("2025 FurGivers © All Rights Reserved");
        Font footer = loadCustomFont("Arial Nova Cond.ttf", 20f);
        footerLabel.setFont(footer);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setOpaque(false);
        footerPanel.add(footerLabel, BorderLayout.CENTER);
        backgroundPanel.add(footerPanel, BorderLayout.SOUTH);

        setContentPane(backgroundPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

class MenuButton extends JButton {
	   private boolean hovered = false;
	   private String labelText;
	   private Font customFont;
	   public MenuButton(String text, Font font) {
	        super(text);
	        this.labelText = text;
	        this.customFont = font;
	        setFocusPainted(false);
	        setContentAreaFilled(false);
	        setBorderPainted(false);
	        setFont(font);
	        setCursor(new Cursor(Cursor.HAND_CURSOR));
	        setForeground(new Color(0, 0, 128));
	        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	        setOpaque(false);
	        addMouseListener(new MouseAdapter() {
	           @Override
	           public void mouseEntered(MouseEvent e) {
	               hovered = true;
	               repaint();
	           }
	           @Override
	           public void mouseExited(MouseEvent e) {
	               hovered = false;
	               repaint();
	           }
	       });
	   }
	   
	   @Override
	   protected void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       if (hovered) {
	           Graphics2D g2 = (Graphics2D) g;
	           g2.setFont(customFont);
	           FontMetrics fm = g2.getFontMetrics();
	           int textWidth = fm.stringWidth(labelText);
	           int textHeight = fm.getAscent();
	           int x = (getWidth() - textWidth) / 2;
	           int y = (getHeight() + textHeight) / 2;
	           g2.setColor(getForeground());
	           g2.setStroke(new BasicStroke(2.5f)); // Thickness of underline
	           g2.drawLine(x, y + 2, x + textWidth, y + 2); // Draw underline below text
	       }
	   }
	}

