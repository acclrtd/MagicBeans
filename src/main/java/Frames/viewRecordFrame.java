package Frames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class viewRecordFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField searchField;
    private JButton searchButton = null;
    private JTextArea displayArea = null;
    private JLabel nameLabel, departmentLabel, birthdateLabel, designationLabel;
    private JTextField nameField, departmentField, birthdateField, designationField;
    private List<String[]> employeeData;

    public viewRecordFrame() throws IOException {
        initComponents();
        loadEmployeeData(); // Load employee data from file
    }

    private void initComponents() {
        setLayout(new FlowLayout());

        searchField = new JTextField(20);
        add(searchField);

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField(20);
        add(nameField);

        departmentLabel = new JLabel("Department:");
        add(departmentLabel);
        departmentField = new JTextField(20);
        add(departmentField);

        birthdateLabel = new JLabel("Birthdate:");
        add(birthdateLabel);
        birthdateField = new JTextField(20);
        add(birthdateField);

        designationLabel = new JLabel("Designation:");
        add(designationLabel);
        designationField = new JTextField(20);
        add(designationField);

        searchButton = new JButton("Search");
        add(searchButton);

        displayArea = new JTextArea(10, 20);
        add(new JScrollPane(displayArea));

        searchButton.addActionListener((ActionEvent e) -> {
            String searchQuery = searchField.getText();
            searchRecord(searchQuery);
        });

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadEmployeeData() throws IOException {
        employeeData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Randy/OneDrive/Documents/Desktop/motorph/MotorPH Employee Data.csv"))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String[] parts = line.split(","); // Assuming data is comma-separated
                employeeData.add(parts);
            }
        } catch (IOException e) {
            displayArea.setText("Error loading employee data from file.");
            throw e; // Re-throw the exception to inform caller
        }
    }

    private void searchRecord(String query) {
        if (employeeData!= null &&!employeeData.isEmpty()) {
            for (String[] employee : employeeData) {
                if (employee.length > 0 && employee[0].equals(query)) {
                    nameField.setText(employee[1]);
                    departmentField.setText(employee[2]);
                    birthdateField.setText(employee[3]);
                    designationField.setText(employee[4]);
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
            // Create an instance of ViewRecordFrame
        });
    }
}