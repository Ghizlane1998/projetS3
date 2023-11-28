package entities;

public class Admin {
    private int idAdmin;
    private String email;
    private String password;
    private String role;
    public Admin() {
		// TODO Auto-generated constructor stub
	}
    public Admin (String email, String password ,String role ) {
        this.email = email;
        this.password = password;
        this.role=role;
	}

    // Getter and Setter for idAdmin
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

