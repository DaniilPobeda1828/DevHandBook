import javax.swing.*;
import java.awt.*;

public class UIComponents {

    // Цвета для светлой темы
    public static class LightTheme {
        public static final Color BG_COLOR = new Color(248, 249, 250);
        public static final Color PANEL_COLOR = new Color(255, 255, 255);
        public static final Color TEXT_COLOR = new Color(33, 37, 41);
        public static final Color ACCENT_COLOR = new Color(13, 110, 253);
        public static final Color SEARCH_BG = new Color(255, 255, 255);
        public static final Color BUTTON_BG = new Color(156, 39, 176);
        public static final Color BUTTON_HOVER = new Color(171, 71, 188); // светлее фиолетовый
        public static final Color DOCS_BG = new Color(13, 110, 253);       // синий для документации
        public static final Color DOCS_HOVER = new Color(11, 94, 215);
        public static final Color DOWNLOAD_BG = new Color(16, 185, 129);   // зелёный для скачивания
        public static final Color DOWNLOAD_HOVER = new Color(5, 150, 105);
        public static final Color VERSION_BG = new Color(245, 158, 11);    // оранжевый для версии
        public static final Color VERSION_HOVER = new Color(217, 119, 6);
        public static final Color BORDER_COLOR = new Color(206, 212, 218);
        public static final Color HEADER_BG = new Color(33, 37, 41);
        public static final Color STATUS_BG = new Color(240, 240, 245);
    }

    // Цвета для тёмной темы
    public static class DarkTheme {
        public static final Color BG_COLOR = new Color(30, 30, 35);
        public static final Color PANEL_COLOR = new Color(43, 43, 48);
        public static final Color TEXT_COLOR = new Color(220, 220, 230);
        public static final Color ACCENT_COLOR = new Color(0, 150, 220);
        public static final Color SEARCH_BG = new Color(60, 60, 65);
        public static final Color BUTTON_BG = new Color(139, 92, 246);     // фиолетовый
        public static final Color BUTTON_HOVER = new Color(167, 139, 250);
        public static final Color DOCS_BG = new Color(0, 110, 200);         // синий
        public static final Color DOCS_HOVER = new Color(0, 130, 220);
        public static final Color DOWNLOAD_BG = new Color(5, 150, 105);     // зелёный
        public static final Color DOWNLOAD_HOVER = new Color(16, 185, 129);
        public static final Color VERSION_BG = new Color(217, 119, 6);      // оранжевый
        public static final Color VERSION_HOVER = new Color(245, 158, 11);
        public static final Color BORDER_COLOR = new Color(80, 80, 90);
        public static final Color HEADER_BG = new Color(20, 20, 25);
        public static final Color STATUS_BG = new Color(45, 45, 50);
    }

    // Текущие активные цвета
    public static Color BG_COLOR = LightTheme.BG_COLOR;
    public static Color PANEL_COLOR = LightTheme.PANEL_COLOR;
    public static Color TEXT_COLOR = LightTheme.TEXT_COLOR;
    public static Color ACCENT_COLOR = LightTheme.ACCENT_COLOR;
    public static Color SEARCH_BG = LightTheme.SEARCH_BG;
    public static Color BUTTON_BG = LightTheme.BUTTON_BG;
    public static Color BUTTON_HOVER = LightTheme.BUTTON_HOVER;
    public static Color DOCS_BG = LightTheme.DOCS_BG;
    public static Color DOCS_HOVER = LightTheme.DOCS_HOVER;
    public static Color DOWNLOAD_BG = LightTheme.DOWNLOAD_BG;
    public static Color DOWNLOAD_HOVER = LightTheme.DOWNLOAD_HOVER;
    public static Color VERSION_BG = LightTheme.VERSION_BG;
    public static Color VERSION_HOVER = LightTheme.VERSION_HOVER;
    public static Color BORDER_COLOR = LightTheme.BORDER_COLOR;
    public static Color HEADER_BG = LightTheme.HEADER_BG;
    public static Color STATUS_BG = LightTheme.STATUS_BG;

    public static boolean isDarkMode = false;

    public static void toggleTheme() {
        isDarkMode = !isDarkMode;
        if (isDarkMode) {
            BG_COLOR = DarkTheme.BG_COLOR;
            PANEL_COLOR = DarkTheme.PANEL_COLOR;
            TEXT_COLOR = DarkTheme.TEXT_COLOR;
            ACCENT_COLOR = DarkTheme.ACCENT_COLOR;
            SEARCH_BG = DarkTheme.SEARCH_BG;
            BUTTON_BG = DarkTheme.BUTTON_BG;
            BUTTON_HOVER = DarkTheme.BUTTON_HOVER;
            DOCS_BG = DarkTheme.DOCS_BG;
            DOCS_HOVER = DarkTheme.DOCS_HOVER;
            DOWNLOAD_BG = DarkTheme.DOWNLOAD_BG;
            DOWNLOAD_HOVER = DarkTheme.DOWNLOAD_HOVER;
            VERSION_BG = DarkTheme.VERSION_BG;
            VERSION_HOVER = DarkTheme.VERSION_HOVER;
            BORDER_COLOR = DarkTheme.BORDER_COLOR;
            HEADER_BG = DarkTheme.HEADER_BG;
            STATUS_BG = DarkTheme.STATUS_BG;
        } else {
            BG_COLOR = LightTheme.BG_COLOR;
            PANEL_COLOR = LightTheme.PANEL_COLOR;
            TEXT_COLOR = LightTheme.TEXT_COLOR;
            ACCENT_COLOR = LightTheme.ACCENT_COLOR;
            SEARCH_BG = LightTheme.SEARCH_BG;
            BUTTON_BG = LightTheme.BUTTON_BG;
            BUTTON_HOVER = LightTheme.BUTTON_HOVER;
            DOCS_BG = LightTheme.DOCS_BG;
            DOCS_HOVER = LightTheme.DOCS_HOVER;
            DOWNLOAD_BG = LightTheme.DOWNLOAD_BG;
            DOWNLOAD_HOVER = LightTheme.DOWNLOAD_HOVER;
            VERSION_BG = LightTheme.VERSION_BG;
            VERSION_HOVER = LightTheme.VERSION_HOVER;
            BORDER_COLOR = LightTheme.BORDER_COLOR;
            HEADER_BG = LightTheme.HEADER_BG;
            STATUS_BG = LightTheme.STATUS_BG;
        }
    }

    public static class RoundedPanel extends JPanel {
        private int radius;

        public RoundedPanel(int radius) {
            this.radius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
        }
    }

    public static JTextArea createStyledTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(PANEL_COLOR);
        textArea.setForeground(TEXT_COLOR);
        textArea.setCaretColor(ACCENT_COLOR);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(15, 15, 15, 15));
        return textArea;
    }

    public static JTextField createSearchField() {
        JTextField field = new JTextField(35);
        field.setBackground(SEARCH_BG);
        field.setForeground(TEXT_COLOR);
        field.setCaretColor(ACCENT_COLOR);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        return field;
    }

    // Кнопка "Скопировать всё" (фиолетовая)
    public static JButton createCopyAllButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(BUTTON_BG);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(BUTTON_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(BUTTON_BG);
            }
        });

        return button;
    }

    // Кнопка "Документация" (синяя)
    public static JButton createDocsButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(DOCS_BG);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(DOCS_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(DOCS_BG);
            }
        });

        return button;
    }

    // Кнопка "Скачать" (зелёная)
    public static JButton createDownloadButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(DOWNLOAD_BG);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(DOWNLOAD_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(DOWNLOAD_BG);
            }
        });

        return button;
    }

    // Кнопка "Проверить версию" (оранжевая)
    public static JButton createVersionButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(VERSION_BG);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(VERSION_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(VERSION_BG);
            }
        });

        return button;
    }

    public static JButton createThemeButton() {
        JButton button = new JButton(isDarkMode ? "Светлая тема" : "Тёмная тема");
        button.setBackground(new Color(100, 100, 110));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 11));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(6, 14, 6, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(120, 120, 130));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 100, 110));
            }
        });

        return button;
    }

    public static void updateThemeButton(JButton button) {
        button.setText(isDarkMode ? "Светлая тема" : "Тёмная тема");
    }
}