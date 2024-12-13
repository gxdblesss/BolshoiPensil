package prac22;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator {

    private JFrame frame;
    private JTextField textField;

    public Calculator() {
        // Создание окна
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Поле ввода
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        // Массив с названиями кнопок
        String[] buttonLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", ".", "=", "/",
                "C", "(", ")", " "
        };

        // Добавление кнопок на панель
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Отображение окна
        frame.setVisible(true);
    }

    // Обработчик событий кнопок
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "C":
                    textField.setText("");
                    break;
                case "=":
                    try {
                        String input = textField.getText();
                        double result = evaluateRPN(convertToRPN(input));
                        textField.setText(String.valueOf(result));
                    } catch (Exception ex) {
                        textField.setText("Ошибка");
                    }
                    break;
                default:
                    textField.setText(textField.getText() + command);
                    break;
            }
        }

        private String convertToRPN(String expression) {
            StringBuilder output = new StringBuilder();
            Stack<Character> operators = new Stack<>();
            for (char c : expression.toCharArray()) {
                if (Character.isDigit(c) || c == '.') {
                    output.append(c);
                } else {
                    output.append(' ');
                    if (c == '(') {
                        operators.push(c);
                    } else if (c == ')') {
                        while (!operators.isEmpty() && operators.peek() != '(') {
                            output.append(operators.pop()).append(' ');
                        }
                        operators.pop();
                    } else {
                        while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                            output.append(operators.pop()).append(' ');
                        }
                        operators.push(c);
                    }
                }
            }
            while (!operators.isEmpty()) {
                output.append(' ').append(operators.pop());
            }
            return output.toString();
        }

        private int precedence(char operator) {
            return switch (operator) {
                case '+', '-' -> 1;
                case '*', '/' -> 2;
                default -> -1; // Используем -1 для несуществующих операторов
            };
        }

        private double evaluateRPN(String rpn) {
            Stack<Double> stack = new Stack<>();
            for (String token : rpn.split(" ")) {
                if (token.isEmpty()) continue;
                if (token.matches("[-+]?\\d*\\.?\\d+")) {
                    stack.push(Double.parseDouble(token));
                } else {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(switch (token) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> a / b;
                        default -> throw new IllegalArgumentException("Неверный оператор: " + token);
                    });
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
