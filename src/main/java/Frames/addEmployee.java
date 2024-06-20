package Frames;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class addEmployee {
    
    private final String employeeNumber;
    private final String firstName;
    private final String lastName;
    private final LocalDate bday;
    private final String address;
    private final String sssnum;
    private final String phnum;
    private final String tinnum;
    private final String pagibig;
    private final String status;
    private final String position;
    private final String supervisor;
    private final double basicSalary;
    private final double rice;
    private final String phone;
    private final double clothing;
    private final double semRate;
    private final double hourlyRate;
    
    public addEmployee(String employeeNumber, String firstName, String lastName, String bday, String address, String ssnum, String phnum, String tinnum, String pagibig, String status, String position, String supervisor, String basicSalary, String rice, String phone, String clothing, String semRate, String hourlyRate, String sssnum) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sssnum = sssnum;
        this.phnum = phnum;
        this.tinnum = tinnum;
        this.pagibig = pagibig;
        this.status = status;
        this.position = position;
        this.supervisor = supervisor;
        this.basicSalary = Double.parseDouble(basicSalary);
        this.rice = Double.parseDouble(rice);
        this.phone = phone;
        this.clothing = Double.parseDouble(clothing);
        this.semRate = Double.parseDouble(semRate);
        this.hourlyRate = Double.parseDouble(hourlyRate);
        
        // Parse the birthdate string to a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.bday = LocalDate.parse(bday, formatter);
    }
    
    public void addEmployee() {
        // Logic to add the employee
        System.out.println("Adding employee with employee number " + employeeNumber);
    }
    
    public boolean validateData() {
        // Logic to validate the data
        // For demonstration purposes, assume the data is valid if all fields are not null and not empty
        return employeeNumber != null && !employeeNumber.isEmpty()
            && firstName != null && !firstName.isEmpty()
            && lastName != null && !lastName.isEmpty()
            && bday != null
            && address != null && !address.isEmpty()
            && sssnum != null && !sssnum.isEmpty()
            && phnum != null && !phnum.isEmpty()
            && tinnum != null && !tinnum.isEmpty()
            && pagibig != null && !pagibig.isEmpty()
            && status != null && !status.isEmpty()
            && position != null && !position.isEmpty()
            && supervisor != null && !supervisor.isEmpty()
            && basicSalary > 0
            && rice > 0
            && phone != null && !phone.isEmpty()
            && clothing > 0
            && semRate > 0
            && hourlyRate > 0;
    }
}