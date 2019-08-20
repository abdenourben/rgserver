package dz.rgserver.model;

import java.util.Set;

import dz.rgserver.model.Role;

public class AuthToken {

    private String token; 
    private String username;
    private String role; 
    
    

    
    


	public AuthToken(String token, String username, String role) {
		super();
		this.token = token;
		this.username = username;
		this.role = role;
	}

	public AuthToken(String token) {
        this.token = token;
    }

	public AuthToken(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public AuthToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

 

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
