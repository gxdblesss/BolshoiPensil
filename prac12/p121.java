package prac12;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p121 extends JFrame {
    private int cskaScore;
    private int borussiaScore;
    private Timer timer;
    private int gameTime;
    private JTextArea goalHistory;

    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;
    private JLabel timerLabel;

    public p121() {
        setTitle("Match Result: CSKA vs BorussiaDortmund");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton cskaButton = new JButton("CSKA");
        JButton borussiaButton = new JButton("BorussiaDortmund");
        JButton resetButton = new JButton("Reset");

        cskaScore = 0;
        borussiaScore = 0;
        gameTime = 90;

        resultLabel = new JLabel("Result: 0 X 0");
        lastScorerLabel = new JLabel("Last Scorer: N/A");
        winnerLabel = new JLabel("Winner: DRAW");
        timerLabel = new JLabel("Time left: " + gameTime + "s");
        goalHistory = new JTextArea(5, 30);
        goalHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(goalHistory);

        cskaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cskaScore++;
                updateLabels("CSKA");
                addGoalHistory("CSKA");
            }
        });

        borussiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borussiaScore++;
                updateLabels("BorussiaDortmund");
                addGoalHistory("BorussiaDortmund");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        add(cskaButton);
        add(borussiaButton);
        add(resetButton);
        add(resultLabel);
        add(lastScorerLabel);
        add(winnerLabel);
        add(timerLabel);
        add(scrollPane);

        startTimer();
    }

    private void updateLabels(String lastScorer) {
        resultLabel.setText("Result: " + cskaScore + " X " + borussiaScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);
        updateWinner();
    }

    private void updateWinner() {
        if (cskaScore > borussiaScore) {
            winnerLabel.setText("Winner: CSKA");
        } else if (borussiaScore > cskaScore) {
            winnerLabel.setText("Winner: BorussiaDortmund");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    private void addGoalHistory(String team) {
        goalHistory.append("Goal by " + team + " at " + (90 - gameTime) + "s\n");
    }

    private void resetGame() {
        cskaScore = 0;
        borussiaScore = 0;
        gameTime = 90;
        resultLabel.setText("Result: 0 X 0");
        lastScorerLabel.setText("Last Scorer: N/A");
        winnerLabel.setText("Winner: DRAW");
        timerLabel.setText("Time left: 90s");
        goalHistory.setText("");
        startTimer();
    }

    private void startTimer() {
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameTime > 0) {
                    gameTime--;
                    timerLabel.setText("Time left: " + gameTime + "s");
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Game Over! Final Result: " + resultLabel.getText());
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        p121 app = new p121();
        app.setVisible(true);
    }
}
