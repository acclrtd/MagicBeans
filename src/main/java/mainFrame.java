public class mainFrame {
    
    private final String filename;
    
    public mainFrame(String filename) {
        this.filename = filename;
    }
    
    public void updateAndViewRecord() {
       //logic to update and view records
        System.out.println("Updating and viewing records from " + filename);
    }
    
    public void addNewPersonnelData() {
        //logic to add new personnel data
        System.out.println("Adding new personnel data to " + filename );
    }
    public void deleteEmployeesData() {
        // Logic to delete employees data
        System.out.println("Deleting employee data from " + filename);
    }
    public void applyLeave() {
        // Logic to apply leave
        System.out.println("Applying leave from " + filename);
    }
    public void printPaySlip() {
        // Logic to print pay slip
        System.out.println("Printing pay slip from " + filename);
    }

    public static void main(String[] args) {
        String filepath = "C:\\Users\\Randy\\OneDrive\\Documents\\Desktop\\motorph\\MotorPH Employee Data.csv";
        
        // Create a login instance
        Login login = new Login("admin", "password");
        
        if(login.validateCredentials()) {
            // Create an instance of mainFrame
            mainFrame mainFrame = new mainFrame(filepath);
            
            // Demonstrating the methods
            mainFrame.updateAndViewRecord();
            mainFrame.addNewPersonnelData();
            mainFrame.deleteEmployeesData();
            mainFrame.printPaySlip();
            mainFrame.applyLeave();
        } else {
            System.out.println("Invalid credentials");
        }
    }
}