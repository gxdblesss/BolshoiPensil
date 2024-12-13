package prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Класс App расширяет JFrame и является основным графическим интерфейсом приложения
class p152 extends JFrame {
    // Объявляем компоненты интерфейса
    private JFrame frame = this;
    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    private JTextField text;

    // Конструктор класса App, где инициализируются все компоненты и настраивается интерфейс
    p152() {
        // Устанавливаем заголовок окна
        this.setTitle("Application");
        // Устанавливаем действие по умолчанию при закрытии окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Устанавливаем шрифт для окна
        this.setFont(new Font("Times new roman", Font.BOLD, 18));
        // Устанавливаем менеджер компоновки GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();

        // Инициализируем меню
        this.menu = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.editMenu = new JMenu("Edit");
        this.helpMenu = new JMenu("Help");

        // Создаем элементы меню "File"
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        // Добавляем элементы в меню "File"
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Создаем элементы меню "Edit"
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");
        // Добавляем элементы в меню "Edit"
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        // Добавляем меню в строку меню
        menu.add(fileMenu);
        menu.add(editMenu);
        menu.add(helpMenu);
        // Устанавливаем строку меню для окна
        this.setJMenuBar(this.menu);

        // Инициализируем текстовое поле
        text = new JTextField("Input your message:");
        text.setHorizontalAlignment(JTextField.CENTER);
        layout.gridx = 0;
        layout.gridy = 0;
        layout.gridwidth = 3;
        layout.fill = GridBagConstraints.HORIZONTAL;
        // Добавляем текстовое поле в окно
        this.add(text, layout);

        // Создаем кнопки
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        layout.gridx = 0;
        layout.gridy = 1;
        layout.gridwidth = 1;
        layout.fill = GridBagConstraints.EAST;
        // Добавляем первую кнопку в окно
        this.add(button1, layout);
        layout.gridx = 2;
        layout.gridy = 1;
        layout.fill = GridBagConstraints.WEST;
        // Добавляем вторую кнопку в окно
        this.add(button2, layout);

        // Добавляем обработчик события для элемента меню "Exit"
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Завершаем приложение
                System.exit(0);
            }
        });

        // Добавляем обработчик события для элемента меню "Save"
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Открываем диалог выбора файла
                JFileChooser fileChooser = new JFileChooser();
                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    // Получаем выбранный файл
                    File fileToSave = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                        // Записываем текст из текстового поля в файл
                        writer.write(text.getText());
                        // Показываем сообщение об успешном сохранении
                        JOptionPane.showMessageDialog(frame, "File was successfully saved!", "Saved",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        // Показываем сообщение об ошибке при сохранении файла
                        JOptionPane.showMessageDialog(frame, "Error saving the file!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    // Метод для запуска приложения
    public void run() {
        // Устанавливаем размер окна
        this.setSize(400, 300);
        // Запрещаем изменение размера окна
        this.setResizable(false);
        // Отображаем окно
        this.setVisible(true);
    }
}

// Главный класс приложения
 class Main {
    // Главный метод запуска приложения
    public static void main(String[] args) {
        // Создаем экземпляр приложения
        p152 p152 = new p152();
        // Запускаем приложение
        p152.run();
    }
}