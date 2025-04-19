package model;

public class Pengelola {
    private final String username;
    private String password; 

    public Pengelola(String username, String password) {
        this.username = "admin";
        this.password = "admin123456"; 
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() >= 6) { 
            this.password = password;
        } else {
            System.out.println("⚠️ Password harus minimal 6 karakter!");
        }
    }

    protected void resetPassword() {
        this.password = "default123"; 
    }

}