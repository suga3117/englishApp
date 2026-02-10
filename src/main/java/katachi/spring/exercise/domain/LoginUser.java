package katachi.spring.exercise.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {

	private final Integer id;
	private final String name;

	public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String name) {
		
		super(username, password, authorities);
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		
		return id;
	}

	public String getName() {
		
		return name;
	}
}