package dz.rgserver.model;


import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	
	//public static final String Admin = "ADMIN"; 
	//public static final String User = "USER"; 
	
	 	@Id
	    private String name;
	    private String description;
	    
	    @OneToMany(mappedBy = "role")
		@JsonIgnore
	    private Collection<User> user; 
	    
	    //GETTERS AND SETTERS
	    public Role() {
			super();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Collection<User> getUser() {
			return user;
		}
		public void setUser(Collection<User> user) {
			this.user = user;
		}
		public Role(String name, String description, Collection<User> user) {
			super();
			this.name = name;
			this.description = description;
			this.user = user;
		}
		
		

}

    
    
    


