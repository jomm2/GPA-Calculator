package coders;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sub_avr extends JFrame {

    public sub_avr() {
        this.setTitle("Subject Average Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640, 850);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        panel1.setBounds(0, 0, 350, 600);

        JLabel label = new JLabel("Exams/Quizzes/Ass");
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(20, 10, 500, 30);

        JLabel grade = new JLabel("Grade");
        grade.setForeground(Color.black);
        grade.setFont(new Font("Arial", Font.BOLD, 20));
        grade.setBounds(300, 10, 500, 30);

        JLabel unit = new JLabel("Weight");
        unit.setForeground(Color.black);
        unit.setFont(new Font("Arial", Font.BOLD, 20));
        unit.setBounds(370, 10, 500, 30);

        JTextField[] subjectFields = new JTextField[10];
        JTextField[] gradeFields = new JTextField[10];
        JTextField[] unitFields = new JTextField[10];

        for (int i = 0; i < 10; i++) {
            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(50, 60 + i * 50, 250, 30);
            panel1.add(subjectFields[i]);

            gradeFields[i] = new JTextField();
            gradeFields[i].setBounds(320, 60 + i * 50, 50, 30);
            panel1.add(gradeFields[i]);

            unitFields[i] = new JTextField();
            unitFields[i].setBounds(390, 60 + i * 50, 50, 30);
            panel1.add(unitFields[i]);
        }

        JTextField averageField = new JTextField();
        averageField.setEditable(false);
        averageField.setBounds(50, 567, 100, 30);
        panel1.add(averageField);

        JLabel averageLabel = new JLabel("Average");
        averageLabel.setForeground(Color.black);
        averageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        averageLabel.setBounds(50, 540, 100, 30);
        panel1.add(averageLabel);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(240, 550, 100, 50);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	StringBuilder data = new StringBuilder();
                int totalweight = 0;
                double totalGradePoints = 0.0;

                for (int i = 0; i < 10; i++) {
                	String subject = subjectFields[i].getText();
                    String gradeText = gradeFields[i].getText();
                    String unitText = unitFields[i].getText();
                    if (!gradeText.isEmpty() && !unitText.isEmpty()) {
                        double grade = Double.parseDouble(gradeText);
                        double weight = Integer.parseInt(unitText);
                        totalGradePoints += grade * weight;
                        totalweight += weight;
                        data.append(subject).append(" : ").append(grade).append(" : ").append(weight).append(" : ").append(averageField.getText()).append("\n");
                    }
                }

                if (totalweight > 0) {
                    double average = totalGradePoints / totalweight;
                    averageField.setText(String.format("%.2f", average));
                    data.append("Average: ").append(String.format("%.2f", average)).append("\n");
                } else {
                    averageField.setText("N/A");
                }
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\Me\\eclipse-workspace\\Final_Project\\src\\coders\\SUBJECT GRADE.txt");
                    writer.write(data.toString()); // Write subjects, grades, units, and average to the file
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(345, 550, 100, 50);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    subjectFields[i].setText("");
                    gradeFields[i].setText("");
                    unitFields[i].setText("");
                }
                averageField.setText("");
            }
        });

        panel1.add(label);
        panel1.add(grade);
        panel1.add(unit);
        panel1.add(calculateButton);
        panel1.add(clearButton);

        this.add(panel1);
        this.setLayout(null);

        panel1.setBounds(75, 25, 450, 600);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new sub_avr();
    }
}

	
	

