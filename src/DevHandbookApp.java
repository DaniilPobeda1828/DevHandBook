import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class DevHandbookApp extends JFrame {
    private JLabel statusLabel;
    private JTabbedPane mainTabbedPane;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JButton themeButton;

    public DevHandbookApp() {
        initUI();
    }

    private void initUI() {
        setTitle("Справочник программиста");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 900);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1000, 700));
        setUndecorated(true);

        UIComponents.RoundedPanel mainPanel = new UIComponents.RoundedPanel(20);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(UIComponents.BG_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        mainPanel.add(createCustomTitleBar(), BorderLayout.NORTH);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(UIComponents.BG_COLOR);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        headerPanel = createHeader();
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // ГЛАВНЫЙ TABBED PANE С РАЗДЕЛАМИ
        mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setBackground(UIComponents.BG_COLOR);
        mainTabbedPane.setForeground(UIComponents.TEXT_COLOR);
        mainTabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 13));

        // Раздел 1: Установка языков (с вложенными вкладками для каждого языка)
        mainTabbedPane.addTab("Установка языков", createLanguagesSubTabs());

        // Раздел 2: Установка библиотек
        mainTabbedPane.addTab("Установка библиотек", createLibrariesSubTabs());

        // Раздел 3: Решение ошибок
        mainTabbedPane.addTab("Решение ошибок", createErrorsSubTabs());

        contentPanel.add(mainTabbedPane, BorderLayout.CENTER);

        mainTabbedPane.setBackgroundAt(0, new Color(156, 39, 176));  // Установка языков — фиолетовый
        mainTabbedPane.setBackgroundAt(1, new Color(13, 110, 253));   // Установка библиотек — синий
        mainTabbedPane.setBackgroundAt(2, new Color(245, 158, 11));   // Решение ошибок — оранжевый

        statusLabel = createStatusBar();
        contentPanel.add(statusLabel, BorderLayout.SOUTH);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);

        addWindowDragListener(mainPanel);
    }

    private JTabbedPane createLanguagesSubTabs() {
        JTabbedPane subTabs = new JTabbedPane();
        subTabs.setBackground(UIComponents.BG_COLOR);
        subTabs.setForeground(UIComponents.TEXT_COLOR);
        subTabs.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        Map<String, String> languages = DataProvider.getLanguagesData();
        for (Map.Entry<String, String> entry : languages.entrySet()) {
            LanguageTab tab = new LanguageTab(entry.getKey(), entry.getValue(), getStatusLabel());
            subTabs.addTab(entry.getKey(), tab);
        }
        // После цикла for, где добавляются вкладки, добавьте:
        for (int i = 0; i < subTabs.getTabCount(); i++) {
            subTabs.setBackgroundAt(i, new Color(100, 100, 200));  // или любой другой цвет
        }

        return subTabs;
    }

    private JTabbedPane createLibrariesSubTabs() {
        JTabbedPane subTabs = new JTabbedPane();
        subTabs.setBackground(UIComponents.BG_COLOR);
        subTabs.setForeground(UIComponents.TEXT_COLOR);
        subTabs.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        Map<String, String> libraries = DataProvider.getLibrariesData();
        for (Map.Entry<String, String> entry : libraries.entrySet()) {
            LanguageTab tab = new LanguageTab(entry.getKey(), entry.getValue(), getStatusLabel());
            subTabs.addTab(entry.getKey(), tab);
        }
        // После цикла for, где добавляются вкладки, добавьте:
        for (int i = 0; i < subTabs.getTabCount(); i++) {
            subTabs.setBackgroundAt(i, new Color(100, 100, 200));  // или любой другой цвет
        }

        return subTabs;
    }

    private JTabbedPane createErrorsSubTabs() {
        JTabbedPane subTabs = new JTabbedPane();
        subTabs.setBackground(UIComponents.BG_COLOR);
        subTabs.setForeground(UIComponents.TEXT_COLOR);
        subTabs.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        Map<String, String> errors = DataProvider.getErrorsData();
        for (Map.Entry<String, String> entry : errors.entrySet()) {
            LanguageTab tab = new LanguageTab(entry.getKey(), entry.getValue(), getStatusLabel());
            subTabs.addTab(entry.getKey(), tab);
        }
        // После цикла for, где добавляются вкладки, добавьте:
        for (int i = 0; i < subTabs.getTabCount(); i++) {
            subTabs.setBackgroundAt(i, new Color(100, 100, 200));  // или любой другой цвет
        }

        return subTabs;
    }

    private JPanel createCustomTitleBar() {
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBackground(UIComponents.HEADER_BG);
        titleBar.setPreferredSize(new Dimension(getWidth(), 35));
        titleBar.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));

        JLabel titleLabel = new JLabel("DevHandbook");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false);

        themeButton = UIComponents.createThemeButton();
        themeButton.addActionListener(e -> toggleTheme());

        JButton minimizeBtn = new JButton("_");
        minimizeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        minimizeBtn.setForeground(Color.WHITE);
        minimizeBtn.setBackground(UIComponents.HEADER_BG);
        minimizeBtn.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
        minimizeBtn.setFocusPainted(false);
        minimizeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeBtn.addActionListener(e -> setState(Frame.ICONIFIED));

        JButton closeBtn = new JButton("X");
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setBackground(UIComponents.HEADER_BG);
        closeBtn.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
        closeBtn.setFocusPainted(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> System.exit(0));

        buttonPanel.add(themeButton);
        buttonPanel.add(minimizeBtn);
        buttonPanel.add(closeBtn);

        titleBar.add(titleLabel, BorderLayout.WEST);
        titleBar.add(buttonPanel, BorderLayout.EAST);

        return titleBar;
    }

    private void toggleTheme() {
        UIComponents.toggleTheme();
        UIComponents.updateThemeButton(themeButton);

        ((JPanel)getContentPane()).setBackground(UIComponents.BG_COLOR);
        contentPanel.setBackground(UIComponents.BG_COLOR);
        headerPanel.setBackground(UIComponents.HEADER_BG);

        mainTabbedPane.setBackground(UIComponents.BG_COLOR);
        mainTabbedPane.setForeground(UIComponents.TEXT_COLOR);

        statusLabel.setBackground(UIComponents.STATUS_BG);
        statusLabel.setForeground(UIComponents.TEXT_COLOR);

        // Обновить все вложенные вкладки
        for (int i = 0; i < mainTabbedPane.getTabCount(); i++) {
            Component comp = mainTabbedPane.getComponentAt(i);
            if (comp instanceof JTabbedPane) {
                JTabbedPane subTabs = (JTabbedPane) comp;
                for (int j = 0; j < subTabs.getTabCount(); j++) {
                    Component tabComp = subTabs.getComponentAt(j);
                    if (tabComp instanceof LanguageTab) {
                        ((LanguageTab) tabComp).updateTheme();
                        ((LanguageTab) tabComp).refreshContent();
                    }
                }
            }
        }

        repaint();
    }

    private JButton createTitleButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(UIComponents.HEADER_BG);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(60, 60, 65));
                if (text.equals("✕")) btn.setBackground(new Color(200, 60, 60));
            }
            public void mouseExited(MouseEvent e) {
                btn.setBackground(UIComponents.HEADER_BG);
            }
        });
        return btn;
    }

    private void addWindowDragListener(JPanel mainPanel) {
        final Point[] mouseOffset = new Point[1];
        mainPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseOffset[0] = e.getPoint();
            }
        });
        mainPanel.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point newPoint = e.getLocationOnScreen();
                newPoint.translate(-mouseOffset[0].x, -mouseOffset[0].y);
                setLocation(newPoint);
            }
        });
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(UIComponents.HEADER_BG);
        header.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        JLabel title = new JLabel("Справочник программиста");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Установка языков | Менеджеры библиотек | Типичные ошибки и решения");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(new Color(200, 200, 210));

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false);
        textPanel.add(title, BorderLayout.NORTH);
        textPanel.add(subtitle, BorderLayout.SOUTH);

        header.add(textPanel, BorderLayout.WEST);

        return header;
    }

    private JLabel createStatusBar() {
        JLabel label = new JLabel("Готов к работе | Ctrl+F - поиск | Ctrl+C - копировать | Ctrl+Shift+C - копировать всё");
        label.setForeground(UIComponents.TEXT_COLOR);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        label.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        label.setBackground(UIComponents.STATUS_BG);
        label.setOpaque(true);
        return label;
    }

    private JLabel getStatusLabel() {
        return statusLabel;
    }
}