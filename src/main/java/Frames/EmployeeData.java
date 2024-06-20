package Frames;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmployeeData {
    private Map<String, String> employeeCredentials = new HashMap<>();

    @SuppressWarnings("null")
    public EmployeeData(String filePath) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        String[] line;
        boolean header = true; // skip the header
        try {
            while ((line = reader.readNext()) != null) {
                if (header) {
                    header = false; // skip the header
                    continue;
                }
                String employeeNumber = line[0]; // Assuming employee number is in the first column
                String password = line[1]; // Assuming password is in the second column

                employeeCredentials.put(employeeNumber, password);
            }
        } finally {
            if (null != reader) {
                reader.close(); // Call close() instead of clone()
            }
        }
    }

    public boolean validateCredentials(String employeeNumber, String password) {
        String storedPassword = employeeCredentials.get(employeeNumber);
        return storedPassword != null && storedPassword.equals(password);
    }
}