package Frames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class viewRecordFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField searchField;
    private final JButton searchButton;
    private final JTextArea displayArea;
    private List<String[]> employeeNumber;

    public viewRecordFrame() throws IOException {
        setLayout(new FlowLayout());

        searchField = new JTextField(20);
        add(searchField);

        loademployeeNumber(); // Load employee data from file

        searchButton = new JButton("Search");
        add(searchButton);

        displayArea = new JTextArea(10, 20);
        add(new JScrollPane(displayArea));

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchField.getText();
                searchRecord(searchQuery);
            }
        });

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loademployeeNumber() throws IOException {
        employeeNumber = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Randy/OneDrive/Documents/Desktop/motorph/MotorPH Employee Data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming data is comma-separated
                employeeNumber.add(parts);
            }
        } catch (IOException e) {
            displayArea.setText("Error loading employee data from file.");
            throw e; // Re-throw the exception to inform caller
        }
    }

    private void searchRecord(String query) {
        if (employeeNumber != null && !employeeNumber.isEmpty()) {
            for (String[] employee : employeeNumber) {
                if (employee.length > 0 && employee[0].equals(query)) {
                    displayArea.setText("Employee Number: " + employee[0] + "\n"
                            + "Name: " + employee[1] + "\n"
                            + "Department: " + employee[2] + "\n"
                            + "Designation: " + employee[3]);
                    return;
                }
            }
            displayArea.setText("No employee found with employee number " + query);
        } else {
            displayArea.setText("No Data Found");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        });
    }
}