package Frames;

public class Login {
	 private String username;
	    private String password;
	    
	    public Login(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }
	    
	    public boolean validateCredentials() {
	        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
	    }
	}