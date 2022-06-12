package beans;

import java.io.Serializable;

public class Bean01a_datenupdate implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String password;
	
	public Bean01a_datenupdate() {
	}
	
	public Bean01a_datenupdate(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
