package StudentGradeTracker1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentTrackerGUI extends JFrame {

    private JTextField numSubjectsField;
    private JPanel inputPanel;
    private JButton submitButton;
    private JLabel resultLabel;
    private int totalMarks = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;

    public StudentTrackerGUI() {
        setTitle("Student Grade Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel to input number of subjects
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter number of subjects: "));
        numSubjectsField = new JTextField(5);
        topPanel.add(numSubjectsField);
        JButton enterButton = new JButton("Enter");
        topPanel.add(enterButton);
        add(topPanel, BorderLayout.NORTH);

        // Center panel to input marks
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        // Bottom panel for submit and results
        JPanel bottomPanel = new JPanel();
        submitButton = new JButton("Calculate");
        submitButton.setEnabled(false);
        resultLabel = new JLabel();
        bottomPanel.add(submitButton);
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action: After entering number of subjects
        enterButton.addActionListener(e -> {
            inputPanel.removeAll();
            try {
                int numSubjects = Integer.parseInt(numSubjectsField.getText());
                for (int i = 0; i < numSubjects; i++) {
                    JPanel markRow = new JPanel();
                    markRow.add(new JLabel("Subject " + (i + 1) + ": "));
                    JTextField markField = new JTextField(5);
                    markField.setName("mark" + i);
                    markRow.add(markField);
                    inputPanel.add(markRow);
                }
                submitButton.setEnabled(true);
                revalidate();
                repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        });

        // Action: Calculate results
        submitButton.addActionListener(e -> {
            totalMarks = 0;
            highest = Integer.MIN_VALUE;
            lowest = Integer.MAX_VALUE;

            Component[] components = inputPanel.getComponents();
            for (Component comp : components) {
                if (comp instanceof JPanel) {
                    JTextField field = (JTextField) ((JPanel) comp).getComponent(1);
                    try {
                        int mark = Integer.parseInt(field.getText());
                        totalMarks += mark;
                        highest = Math.max(highest, mark);
                        lowest = Math.min(lowest, mark);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid mark entered. Please enter integers only.");
                        return;
                    }
                }
            }

            int numSubjects = components.length;
            int average = numSubjects == 0 ? 0 : totalMarks / numSubjects;

            resultLabel.setText("<html>Average: " + average + "<br>Highest: " + highest + "<br>Lowest: " + lowest + "</html>");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentTrackerGUI().setVisible(true);
        });
    }
}