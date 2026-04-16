import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;

public class LanguageTab extends JPanel {
    private JTextArea textArea;
    private JTextField searchField;
    private String languageName;
    private String content;
    private String allText;
    private JLabel statusLabel;
    private JLabel resultCountLabel;
    private JScrollPane scrollPane;

    public LanguageTab(String languageName, String content, JLabel statusLabel) {
        this.languageName = languageName;
        this.content = content;
        this.statusLabel = statusLabel;
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(15, 15, 15, 15));

        buildAllText();
        setupUI();
    }

    private void buildAllText() {
        StringBuilder sb = new StringBuilder();
        int width = getWidth() > 0 ? getWidth() - 50 : 80;
        String separator = "=".repeat(Math.min(width, 80));

        sb.append(separator).append("\n");
        sb.append(languageName).append("\n");
        sb.append(separator).append("\n");
        sb.append(content).append("\n");
        sb.append("\n");

        allText = sb.toString();
    }

    private void setupUI() {
        setBackground(UIComponents.BG_COLOR);
        JPanel topPanel = new JPanel(new BorderLayout(10, 5));
        topPanel.setOpaque(false);
        topPanel.setBorder(new EmptyBorder(0, 0, 15, 0));

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        searchPanel.setOpaque(false);



        JLabel searchLabel = new JLabel("Поиск:");
        searchLabel.setForeground(UIComponents.TEXT_COLOR);
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        searchField = UIComponents.createSearchField();
        searchField.setPreferredSize(new Dimension(300, 38));
        searchField.setToolTipText("Поиск по тексту (Ctrl+F)");

        registerKeyboardAction(e -> searchField.requestFocusInWindow(),
                KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);

        resultCountLabel = new JLabel();
        resultCountLabel.setForeground(UIComponents.TEXT_COLOR);
        resultCountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        searchPanel.add(resultCountLabel);

        topPanel.add(searchPanel, BorderLayout.WEST);

        // ПАНЕЛЬ КНОПОК
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        JButton copyAllBtn = UIComponents.createCopyAllButton("Скопировать всё");
        copyAllBtn.setToolTipText("Скопировать всю информацию (Ctrl+Shift+C)");
        copyAllBtn.addActionListener(e -> copyAllText());

        JButton docsBtn = UIComponents.createDocsButton("Документация");
        docsBtn.setToolTipText("Открыть официальную документацию в браузере");
        docsBtn.addActionListener(e -> openDocumentation());


        buttonPanel.add(copyAllBtn);
        buttonPanel.add(docsBtn);

        topPanel.add(buttonPanel, BorderLayout.EAST);

        // Текстовая область
        textArea = UIComponents.createStyledTextArea();
        textArea.setText(allText);
        textArea.setCaretPosition(0);

        KeyStroke ctrlC = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
        textArea.getInputMap().put(ctrlC, "copy");
        textArea.getActionMap().put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                copySelectedText();
            }
        });

        KeyStroke ctrlShiftC = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
        textArea.getInputMap().put(ctrlShiftC, "copyAll");
        textArea.getActionMap().put("copyAll", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                copyAllText();
            }
        });

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(UIComponents.BORDER_COLOR, 1));
        scrollPane.getViewport().setBackground(UIComponents.PANEL_COLOR);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        javax.swing.Timer searchTimer = new javax.swing.Timer(300, e -> filterContent());
        searchTimer.setRepeats(false);

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTimer.restart();
            }
        });

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent e) {
                refreshContent();
            }
        });
    }

    public void refreshContent() {
        buildAllText();
        filterContent();
    }

    public void updateTheme() {
        setBackground(UIComponents.BG_COLOR);
        if (textArea != null) {
            textArea.setBackground(UIComponents.PANEL_COLOR);
            textArea.setForeground(UIComponents.TEXT_COLOR);
        }
        if (searchField != null) {
            searchField.setBackground(UIComponents.SEARCH_BG);
            searchField.setForeground(UIComponents.TEXT_COLOR);
        }
        if (scrollPane != null) {
            scrollPane.setBorder(BorderFactory.createLineBorder(UIComponents.BORDER_COLOR, 1));
            scrollPane.getViewport().setBackground(UIComponents.PANEL_COLOR);
        }
    }

    private void filterContent() {
        String query = searchField.getText().trim().toLowerCase();

        if (query.isEmpty()) {
            textArea.setText(allText);
            resultCountLabel.setText("");
            textArea.setCaretPosition(0);
            return;
        }

        StringBuilder filtered = new StringBuilder();
        int matchCount = 0;

        String[] lines = allText.split("\n");
        for (String line : lines) {
            if (line.toLowerCase().contains(query)) {
                matchCount++;
                filtered.append("→ ").append(line).append("\n");
            } else {
                filtered.append(line).append("\n");
            }
        }

        if (matchCount == 0) {
            textArea.setText("===============================================================\n" +
                    "                                     НИЧЕГО НЕ НАЙДЕНО\n" +
                    "===============================================================");
            resultCountLabel.setText("0 результатов");
        } else {
            textArea.setText(filtered.toString());
            resultCountLabel.setText(matchCount + " совпадений");
        }
        textArea.setCaretPosition(0);
    }

    private void copySelectedText() {
        String selected = textArea.getSelectedText();
        if (selected != null && !selected.isEmpty()) {
            copyToClipboard(selected);
            if (statusLabel != null) statusLabel.setText("✓ Скопировано выделение | Ctrl+V для вставки");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Выделите текст для копирования (Ctrl+C)\nЗажмите левую кнопку мыши и выделите нужный фрагмент",
                    "Информация",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void copyAllText() {
        copyToClipboard(allText);
        if (statusLabel != null) statusLabel.setText("✓ Скопирован весь текст | Ctrl+V для вставки");
    }

    private void copyToClipboard(String text) {
        java.awt.datatransfer.StringSelection stringSelection =
                new java.awt.datatransfer.StringSelection(text);
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Timer timer = new Timer(2500, e -> {
            if (statusLabel != null) statusLabel.setText("✓ Готов к работе");
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void openDocumentation() {
        String url = getDocumentationUrl();
        if (url != null) {
            try {
                Desktop.getDesktop().browse(URI.create(url));
                if (statusLabel != null) statusLabel.setText("✓ Открыта документация: " + url);
            } catch (IOException e) {
                if (statusLabel != null) statusLabel.setText("✗ Не удалось открыть браузер");
                JOptionPane.showMessageDialog(this,
                        "Не удалось открыть браузер.\nURL: " + url,
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (statusLabel != null) statusLabel.setText("✗ Документация не найдена для " + languageName);
        }
    }

    private String getDocumentationUrl() {
        String name = languageName.toLowerCase();
        if (name.contains("python")) return "https://docs.python.org/3/";
        if (name.contains("java")) return "https://docs.oracle.com/en/java/javase/21/";
        if (name.contains("node")) return "https://nodejs.org/en/docs/";
        if (name.contains("c/") || name.contains("c++")) return "https://en.cppreference.com/";
        if (name.contains("go")) return "https://go.dev/doc/";
        if (name.contains("rust")) return "https://doc.rust-lang.org/";
        if (name.contains("php")) return "https://www.php.net/docs.php";
        if (name.contains("react")) return "https://react.dev/";
        return null;
    }

    private String getVersionCommand() {
        String name = languageName.toLowerCase();
        if (name.contains("python")) return "python --version";
        if (name.contains("java")) return "java -version && javac -version";
        if (name.contains("node")) return "node --version && npm --version";
        if (name.contains("c/") || name.contains("c++")) return "gcc --version";
        if (name.contains("go")) return "go version";
        if (name.contains("rust")) return "rustc --version && cargo --version";
        if (name.contains("php")) return "php -v";
        if (name.contains("react")) return "npx create-react-app --version";
        return null;
    }
}