package coders;

import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class GPA_Calculator {

    public static void main(String[] args) {
    	
    	//1 SUBJECT CALCULATOR LINK TO OTHER FILE
    	sub_avr sub = new sub_avr();
    	
    	//FRAME OR OVERALL WIDTH AND HEIGHT OF THE GUI
        JFrame frame = new JFrame();
        frame.setTitle("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.pink);
        frame.setSize(600, 850); // Adjusted frame size
        
        //PANEL OF CALCULATOR OR A DIV
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        panel1.setBounds(0, 0, 350, 600); // Extended panel height

        //7SUBJECT TEXT
        JLabel label = new JLabel("Subjects");
        label.setForeground(Color.black);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(20, 10, 500, 30);
        
        //JOMM WAPOOOO
        JLabel jomm = new JLabel("JOMM WAPO");
        jomm.setForeground(Color.black);
        jomm.setFont(new Font("Arial", Font.BOLD, 16));
        jomm.setBounds(200, 2, 500, 30);
        frame.add(jomm);
        
        //GRADE TEXT
        JLabel grade = new JLabel("Grade");
        grade.setForeground(Color.black);
        grade.setFont(new Font("Arial", Font.BOLD, 20));
        grade.setBounds(310, 10, 500, 30);
        
        //UNIT TEXT
        JLabel unit = new JLabel("Unit");
        unit.setForeground(Color.black);
        unit.setFont(new Font("Arial", Font.BOLD, 20));
        unit.setBounds(390, 10, 500, 30);
        
        

        
        //TEXT FIELD INPUT COLUMS AND ROWS
        JTextField[] subjectFields = new JTextField[10]; // Subjects
        JTextField[] gradeFields = new JTextField[10]; // Grades
        JTextField[] unitFields = new JTextField[10]; // Units

        //LOOP TO HAVE 10 COLUMS AND 3 ROWS TEXT FIELD
        for (int i = 0; i < 10; i++) {
            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(50, 60 + i * 50, 250, 30);//POSITION
            panel1.add(subjectFields[i]);

            gradeFields[i] = new JTextField();
            gradeFields[i].setBounds(320, 60 + i * 50, 50, 30); //pos
            panel1.add(gradeFields[i]);

            unitFields[i] = new JTextField();
            unitFields[i].setBounds(390, 60 + i * 50, 50, 30); //pos 
            panel1.add(unitFields[i]);
        }
        
        //avrg TEXTFIELD
        JTextField averageField = new JTextField();
        averageField.setEditable(false);
        averageField.setBounds(50, 567, 100, 30);
        panel1.add(averageField);
        
        //AVERAGE TEXT
        JLabel averageLabel = new JLabel("Average");
        averageLabel.setForeground(Color.black);
        averageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        averageLabel.setBounds(50, 540, 100, 30);
        panel1.add(averageLabel);
        
        
        //CALCULATE BUTTON
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(240, 550, 100, 50); 
        
        //CACULATE BUTTON FUNCTIONS
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	//GUI TO TEXT FILE
            	 StringBuilder data = new StringBuilder();
            	
            	int totalUnits = 0;
                double totalGradePoints = 0.0;
                
                //abcd
                
                
                
                //GET GUI INPUT TO TEXT FILE AND FORMULA TO CALCULATE AVERAGE
                for (int i = 0; i < 10; i++) {
                	 String subject = subjectFields[i].getText();
                	String gradeText = gradeFields[i].getText();
                    String unitText = unitFields[i].getText();
                    
                    if (!gradeText.isEmpty() && !unitText.isEmpty()) {
                    	
                        double grade = Double.parseDouble(gradeText);
                        double units = Integer.parseInt(unitText);
                        totalGradePoints += grade * units;
                        totalUnits += units;
                        data.append(subject).append(" : ").append(grade).append(" : ").append(units).append(" : ").append(averageField.getText()).append("\n");
                    }
                }
                
                //DISPLAY TO AVERAGE TEXT FIELD
                if (totalUnits > 0) {
                    double average = totalGradePoints / totalUnits;
                    averageField.setText(String.format("%.2f", average)); //set avrg to text field
                    data.append("Average: ").append(String.format("%.2f", average)).append("\n");
                } else {
                    averageField.setText("N/A");
                }
                //LOCATION OF TEXT FILE
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\Me\\eclipse-workspace\\Final_Project\\src\\coders\\GPA-GRADE.txt");
                    writer.write(data.toString()); // Write subjects, grades, units, and average to the file
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        //CLEAR BUTTON AND FUNCTIONS
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(345, 550, 100, 50); 
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    subjectFields[i].setText("");
                    gradeFields[i].setText("");
                    unitFields[i].setText("");
                }
            }
        });
        
      

        panel1.add(label);
        panel1.add(grade);
        panel1.add(unit);
        panel1.add(calculateButton);
        panel1.add(clearButton);

        frame.add(panel1);
        frame.setLayout(null);

        
        panel1.setBounds(75, 25, 450, 600); 

        frame.setVisible(true);
    }



		
				
				

		
	//CODE
    /*
public static double average(double gpa) {
				
	       
			
	        double totalGradePoints = 0;
	        double totalUnits = 0;

	        for (int i = 1; i <= subjects; i++) {
	           

	
	            double gradePoints = grade * units;


	            totalGradePoints += gradePoints;
	            totalUnits += units;
	        }

	 
	        gpa = totalGradePoints / totalUnits;

	        System.out.println("Your GPA is: " + gpa);

	        sc.close();  
	        */
}
	    
	    
		

