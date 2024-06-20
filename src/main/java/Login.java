class Login {
    private final String admin;
    private final String password;

    Login(String admin, String password) {
        this.admin = admin;
        this.password = password;
    }

    boolean validateCredentials() {
        // Add your credential validation logic here
        return "admin".equals(admin) && "password".equals(password); // Example validation
    }
}
