package prac5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p52 extends JFrame {
    private int cskaScore;
    private int borussiaScore;
    // GUI компоненты
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public p52() {
        // Инициализация JFrame
        setTitle("Match Result: CSKA vs BorussiaDortmund");
        setSize(400, 200); // Устанавливаем размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // Устанавливаем менеджер компоновки

        // Создание кнопок
        JButton cskaButton = new JButton("CSKA");
        JButton borussiaButton = new JButton("BorussiaDortmund");

        // Инициализация счетчиков
        cskaScore = 0;
        borussiaScore = 0;

        // Инициализация меток
        resultLabel = new JLabel("Result: 0 X 0");
        lastScorerLabel = new JLabel("Last Scorer: N/A");
        winnerLabel = new JLabel("Winner: DRAW");

        // Добавляем обработчики событий на кнопки
        cskaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cskaScore++;
                updateLabels("CSKA"); // Обновляем метки
            }
        });

        borussiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borussiaScore++; // Увеличиваем счет для Real Madrid
                updateLabels("BorussiaDortmund"); // Обновляем метки
            }
        });

        // Добавление компонентов в окно
        add(cskaButton);
        add(borussiaButton);
        add(resultLabel);
        add(lastScorerLabel);
        add(winnerLabel);
    }

    // Метод для обновления меток
    private void updateLabels(String lastScorer) {
        // Обновляем текст счета
        resultLabel.setText("Result: " + cskaScore + " X " + borussiaScore);
        // Обновляем текст последнего забившего
        lastScorerLabel.setText("Last Scorer: " + lastScorer);
        // Обновляем текст победителя
        updateWinner();
    }

    // Метод для обновления информации о победителе
    private void updateWinner() {
        if (cskaScore > borussiaScore) {
            winnerLabel.setText("Winner: CSKA");
        } else if (borussiaScore > cskaScore) {
            winnerLabel.setText("Winner: BorussiaDortmund");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        // Создание экземпляра приложения
        p52 app = new p52();
        app.setVisible(true); // Делаем окно видимым
    }
}