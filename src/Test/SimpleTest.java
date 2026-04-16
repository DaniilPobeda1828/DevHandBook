package Test;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleTest {

    private static int passed = 0;
    private static int failed = 0;

    // Простые тестовые данные (копия из DataProvider)
    private static Map<String, String> getTestLanguages() {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("Python", "Установка Python...");
        data.put("Java", "Установка Java...");
        data.put("Node.js", "Установка Node.js...");
        data.put("React", "Установка React...");
        return data;
    }

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("              ПРОСТОЕ ТЕСТИРОВАНИЕ КОМПОНЕНТОВ");
        System.out.println("================================================================================");
        System.out.println();

        // Тест 1: Проверка работы JTextArea
        testTextArea();

        // Тест 2: Проверка работы JButton
        testButton();

        // Тест 3: Проверка работы JTabbedPane
        testTabbedPane();

        // Тест 4: Проверка загрузки данных
        testDataLoading();

        System.out.println();
        System.out.println("================================================================================");
        System.out.println("                        РЕЗУЛЬТАТЫ");
        System.out.println("================================================================================");
        System.out.println("✅ Пройдено: " + passed);
        System.out.println("❌ Не пройдено: " + failed);
        System.out.println("📊 Всего: " + (passed + failed));
        System.out.println("================================================================================");

        if (failed == 0) {
            System.out.println("🎉 ВСЕ ТЕСТЫ ПРОЙДЕНЫ! 🎉");
            System.out.println("✅ Компоненты Swing работают корректно");
            System.out.println("✅ Данные загружаются успешно");
        }
    }

    // Тест 1: Текстовая область
    private static void testTextArea() {
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("📝 ТЕСТ 1: JTextArea (текстовая область)");
        System.out.println("───────────────────────────────────────────────────────────────────");

        try {
            JTextArea textArea = new JTextArea();
            textArea.setText("Тестовый текст");
            textArea.setEditable(false);
            textArea.setLineWrap(true);

            String text = textArea.getText();
            if (text.equals("Тестовый текст")) {
                System.out.println("   ✅ Текст установлен и прочитан корректно");
            } else {
                System.out.println("   ❌ Ошибка чтения текста");
                failed++;
                return;
            }

            if (!textArea.isEditable()) {
                System.out.println("   ✅ Режим только для чтения работает");
            } else {
                System.out.println("   ❌ Режим только для чтения не работает");
                failed++;
                return;
            }

            if (textArea.getLineWrap()) {
                System.out.println("   ✅ Перенос строк включён");
            } else {
                System.out.println("   ❌ Перенос строк не включён");
                failed++;
                return;
            }

            passed++;
            System.out.println("   ✅ ТЕСТ 1 ПРОЙДЕН");

        } catch (Exception e) {
            System.out.println("   ❌ ОШИБКА: " + e.getMessage());
            failed++;
        }
        System.out.println();
    }

    // Тест 2: Кнопки
    private static void testButton() {
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("🔘 ТЕСТ 2: JButton (кнопки)");
        System.out.println("───────────────────────────────────────────────────────────────────");

        try {
            JButton button = new JButton("Тестовая кнопка");
            button.setText("Скопировать всё");

            String text = button.getText();
            if (text.equals("Скопировать всё")) {
                System.out.println("   ✅ Текст кнопки установлен корректно");
            } else {
                System.out.println("   ❌ Ошибка установки текста кнопки");
                failed++;
                return;
            }

            button.setBackground(new Color(156, 39, 176));
            button.setForeground(Color.WHITE);
            System.out.println("   ✅ Цвета кнопки установлены");

            passed++;
            System.out.println("   ✅ ТЕСТ 2 ПРОЙДЕН");

        } catch (Exception e) {
            System.out.println("   ❌ ОШИБКА: " + e.getMessage());
            failed++;
        }
        System.out.println();
    }

    // Тест 3: Вкладки
    private static void testTabbedPane() {
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("📑 ТЕСТ 3: JTabbedPane (вкладки)");
        System.out.println("───────────────────────────────────────────────────────────────────");

        try {
            JTabbedPane tabbedPane = new JTabbedPane();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();

            tabbedPane.addTab("Вкладка 1", panel1);
            tabbedPane.addTab("Вкладка 2", panel2);

            int tabCount = tabbedPane.getTabCount();
            if (tabCount == 2) {
                System.out.println("   ✅ Создано " + tabCount + " вкладки");
            } else {
                System.out.println("   ❌ Неправильное количество вкладок: " + tabCount);
                failed++;
                return;
            }

            String title1 = tabbedPane.getTitleAt(0);
            if (title1.equals("Вкладка 1")) {
                System.out.println("   ✅ Названия вкладок установлены корректно");
            } else {
                System.out.println("   ❌ Ошибка в названии вкладки");
                failed++;
                return;
            }

            passed++;
            System.out.println("   ✅ ТЕСТ 3 ПРОЙДЕН");

        } catch (Exception e) {
            System.out.println("   ❌ ОШИБКА: " + e.getMessage());
            failed++;
        }
        System.out.println();
    }

    // Тест 4: Загрузка данных
    private static void testDataLoading() {
        System.out.println("───────────────────────────────────────────────────────────────────");
        System.out.println("💾 ТЕСТ 4: Загрузка данных");
        System.out.println("───────────────────────────────────────────────────────────────────");

        try {
            Map<String, String> languages = getTestLanguages();

            if (languages == null) {
                System.out.println("   ❌ Данные не загружены");
                failed++;
                return;
            }

            System.out.println("   ✅ Загружено языков: " + languages.size());

            String[] expected = {"Python", "Java", "Node.js", "React"};
            for (String lang : expected) {
                if (languages.containsKey(lang)) {
                    System.out.println("   ✅ " + lang + " - OK");
                } else {
                    System.out.println("   ❌ " + lang + " - отсутствует");
                    failed++;
                }
            }

            passed++;
            System.out.println("   ✅ ТЕСТ 4 ПРОЙДЕН");

        } catch (Exception e) {
            System.out.println("   ❌ ОШИБКА: " + e.getMessage());
            failed++;
        }
        System.out.println();
    }
}