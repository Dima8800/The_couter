package NewYear;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Счетчик до Нового года");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 600);
        frame.setLayout(new BorderLayout());

        JLabel countdownLabel = new JLabel();
        countdownLabel.setHorizontalAlignment(JLabel.CENTER);
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(countdownLabel, BorderLayout.CENTER);

        frame.setVisible(true);

        while (true) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime newYear = LocalDateTime.of(now.getYear() + 1, 1, 1, 0, 0, 0);

            Duration duration = Duration.between(now, newYear);

            long days = duration.toDays();
            long hours = duration.minusDays(days).toHours();
            long minutes = duration.minusDays(days).minusHours(hours).toMinutes();
            long seconds = duration.minusDays(days).minusHours(hours).minusMinutes(minutes).getSeconds();

            String countdownText = "<html><h1>До Нового года осталось:</h1><br>"
                    + "<h2>Дней: " + days + "</h2>"
                    + "<h2>Часов: " + hours + "</h2>"
                    + "<h2>Минут: " + minutes + "</h2>"
                    + "<h2>Секукнд: " + seconds + "</h2>" + "</html>";
            countdownLabel.setText(countdownText);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}