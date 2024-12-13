package prac16;

//Реализуйте программу на Джава с использованием JTextArea и двумя
//        следующего меню выбора:
//        a) Цвет: который имеет возможность выбора из три возможных:
//        синий, красный и черный
//        b) Шрифт: три вида: “Times New Roman”, “MS Sans Serif”, “Courier
//        New”.
//        Замечание. Вы должны написать программу, которая с помощью меню,
//        может изменять шрифт и цвет текста, написанного в JTextArea




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Класс app расширяет JFrame и представляет собой основное окно приложения
class App1 extends JFrame {
    private JTextArea textArea;

    public App1() {
        // Установка заголовка окна
        this.setTitle("Text redaction");
        // Настройка действия при закрытии окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Установка размера окна
        this.setSize(400, 300);
        // Центрирование окна на экране
        this.setLocationRelativeTo(null);
        // Создание меню
        this.createMenu();

        // Инициализация текстовой области с прокручиваемой панелью
        textArea = new JTextArea();
        this.getContentPane().add(new JScrollPane(textArea));
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Создание меню для выбора цвета текста
        JMenu colorMenu = new JMenu("Colour");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem redMenuItem = new JMenuItem("Red");
        JMenuItem blackMenuItem = new JMenuItem("Black");

        // Добавление обработчиков событий для элементов меню цвета
        blueMenuItem.addActionListener(new ColorMenuItemListener(Color.BLUE));
        redMenuItem.addActionListener(new ColorMenuItemListener(Color.RED));
        blackMenuItem.addActionListener(new ColorMenuItemListener(Color.BLACK));

        colorMenu.add(blueMenuItem);
        colorMenu.add(redMenuItem);
        colorMenu.add(blackMenuItem);

        // Создание меню для выбора шрифта текста
        JMenu fontMenu = new JMenu("Font");
        JMenuItem timesNewRomanMenuItem = new JMenuItem("Times New Roman");
        JMenuItem msSansSerifMenuItem = new JMenuItem("MS Sans Serif");
        JMenuItem courierNewMenuItem = new JMenuItem("Courier New");

        // Добавление обработчиков событий для элементов меню шрифта
        timesNewRomanMenuItem.addActionListener(new FontMenuItemListener("Times New Roman"));
        msSansSerifMenuItem.addActionListener(new FontMenuItemListener("MS Sans Serif"));
        courierNewMenuItem.addActionListener(new FontMenuItemListener("Courier New"));

        fontMenu.add(timesNewRomanMenuItem);
        fontMenu.add(msSansSerifMenuItem);
        fontMenu.add(courierNewMenuItem);

        // Создание меню для выбора размера текста
        JMenu sizeMenu = new JMenu("Size");
        for (int i = 0; i < 20; i += 2) {
            int size = 8 + i;
            JMenuItem sizeMenuItem = new JMenuItem(String.valueOf(size));
            sizeMenuItem.addActionListener(new SizeMenuItemListener(size));
            sizeMenu.add(sizeMenuItem);
        }

        // Создание меню для сохранения и открытия файла
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem openMenuItem = new JMenuItem("Open");

        // Добавление обработчиков событий для элементов меню файла
        saveMenuItem.addActionListener(new SaveMenuItemListener());
        openMenuItem.addActionListener(new OpenMenuItemListener());

        fileMenu.add(saveMenuItem);
        fileMenu.add(openMenuItem);

        // Добавление всех меню в строку меню
        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        menuBar.add(sizeMenu);
        menuBar.add(fileMenu);

        // Установка строки меню для окна
        setJMenuBar(menuBar);
    }

    // Внутренний класс для обработки событий выбора цвета текста
    private class ColorMenuItemListener implements ActionListener {
        private Color colour;

        public ColorMenuItemListener(Color colour) {
            this.colour = colour;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setForeground(colour);
        }
    }

    // Внутренний класс для обработки событий выбора шрифта текста
    private class FontMenuItemListener implements ActionListener {
        private String font;

        public FontMenuItemListener(String font) {
            this.font = font;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setFont(new Font(font, textArea.getFont().getStyle(), textArea.getFont().getSize()));
        }
    }

    // Внутренний класс для обработки событий выбора размера текста
    private class SizeMenuItemListener implements ActionListener {
        private int size;

        public SizeMenuItemListener(int size) {
            this.size = size;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), size));
        }
    }

    // Внутренний класс для обработки событий сохранения файла
    private class SaveMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Открываем диалог выбора файла для сохранения
            JFileChooser fileChooser = new JFileChooser();
            int userSelection = fileChooser.showSaveDialog(App1.this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (FileWriter writer = new FileWriter(fileToSave)) {
                    // Записываем содержимое текстовой области в файл
                    writer.write(textArea.getText());
                    JOptionPane.showMessageDialog(App1.this, "File was successfully saved!", "Saved",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    // Показываем сообщение об ошибке при сохранении файла
                    JOptionPane.showMessageDialog(App1.this, "Error saving the file!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Внутренний класс для обработки событий открытия файла
    private class OpenMenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Открываем диалог выбора файла для открытия
            JFileChooser fileChooser = new JFileChooser();
            int userSelection = fileChooser.showOpenDialog(App1.this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(fileToOpen))) {
                    // Читаем содержимое файла и отображаем его в текстовой области
                    textArea.read(reader, null);
                    JOptionPane.showMessageDialog(App1.this, "File was successfully opened!", "Opened",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    // Показываем сообщение об ошибке при открытии файла
                    JOptionPane.showMessageDialog(App1.this, "Error opening the file!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

// Главный класс, содержащий метод main для запуска приложения
 class Main {
    public static void main(String[] args) {
        // Запуск приложения в потоке событий AWT
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем экземпляр класса app и делаем его видимым
                var App1 = new App1();
                App1.setVisible(true);
            }
        });
    }
}