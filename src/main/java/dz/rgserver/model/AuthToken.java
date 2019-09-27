package dz.rgserver.model;

public class AuthToken {

    private String token; 
    private String email;
    private String role; 
    
    //GETTERS AND SETTERS

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
    //CONSTRUCTORS

	public AuthToken(String token, String email, String role) {
		super();
		this.token = token;
		this.email = email;
		this.role = role;
	}

	public AuthToken(String token) {
        this.token = token;
    }

	public AuthToken(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public AuthToken() {
    }
   
}
