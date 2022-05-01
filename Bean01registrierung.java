package beans;

import java.io.Serializable;

public class Bean01registrierung implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String password;
	private String anmerkung;
	
	public Bean01registrierung() {
	}
	
	public Bean01registrierung(String email, String password, String anmerkung) {
		super();
		this.email = email;
		this.password = password;
		this.anmerkung = anmerkung;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getAnmerkung() {
		return anmerkung;
	}
	public void setAnmerkung(String anmerkung) {
		this.anmerkung = anmerkung;
	}
}
