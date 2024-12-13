package prac15;

//Разработайте программу выбора меню как на рис. 15.8 ниже. Вам
//        понадобится JComboBox

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

// Класс приложения, наследуемый от JFrame
class App extends JFrame {
    // Объявление переменных
    private JComboBox<String> menu; // Выпадающее меню
    private JFrame selfFrame = this; // Ссылка на текущее окно
    private Map<String, String> countryInfo; // Карта с информацией о странах

    // Конструктор класса приложения
    App() {
        // Установка заголовка окна
        this.setTitle("Country Information");
        // Установка действия при закрытии окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Установка менеджера компоновки
        this.setLayout(new FlowLayout());
        // Установка шрифта
        this.setFont(new Font("Times new roman", Font.BOLD, 18));

        // Инициализация информации о странах
        countryInfo = new HashMap<>();
        countryInfo.put("Australia", "Capital: Canberra\nPopulation: ~26 million\nContinent: Oceania\nOfficial Language: English");
        countryInfo.put("China", "Capital: Beijing\nPopulation: ~1.4 billion\nContinent: Asia\nOfficial Language: Standard Chinese");
        countryInfo.put("England", "Capital: London\nPopulation: ~56 million\nContinent: Europe\nOfficial Language: English");
        countryInfo.put("Russia", "Capital: Moscow\nPopulation: ~144 million\nContinent: Europe/Asia\nOfficial Language: Russian");

        // Получение массива стран из ключей карты
        String[] countries = countryInfo.keySet().toArray(new String[0]); // Use keys from the map

        // Создание выпадающего меню с названиями стран
        menu = new JComboBox<>(countries);
        this.add(menu); // Добавление меню в окно

        // Добавление слушателя событий для выпадающего меню
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получение выбранной страны
                String selectedCountry = (String) menu.getSelectedItem();
                // Получение информации о выбранной стране
                String info = countryInfo.get(selectedCountry);
                if (info != null) {
                    // Создание текстовой области для отображения информации
                    JTextArea textArea = new JTextArea(info, 5, 20); // Make text area scrollable
                    textArea.setEditable(false); // Запрет на редактирование текста
                    // Создание панели прокрутки для текстовой области
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    // Отображение диалогового окна с информацией о стране
                    JOptionPane.showMessageDialog(selfFrame, scrollPane, "Information about " + selectedCountry, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    // Метод для запуска приложения
    public void run() {
        // Установка размеров окна
        this.setSize(400, 300);
        // Запрет на изменение размеров окна
        this.setResizable(false);
        // Отображение окна
        this.setVisible(true);
    }
}

// Главный класс приложения
public class p151 {
    // Главный метод запуска приложения
    public static void main(String[] args) {
        // Создание экземпляра приложения
        App app = new App();
        // Запуск приложения
        app.run();
    }
}


