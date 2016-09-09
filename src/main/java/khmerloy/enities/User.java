package khmerloy.enities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_name;
	private String password;
	private String role;
	private String email;
	private int id;
	private boolean isenabled;
	
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<GrantedAuthority> role = new HashSet<>();
		role.add(new SimpleGrantedAuthority("ROLE_"+this.role.toUpperCase()));
		return role;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.isenabled;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.isenabled;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.isenabled;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isenabled;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	@Override
	public String toString() {
		return "username "+this.user_name+" password "+this.password+" role "+this.role;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	public boolean isIsenabled() {
		return isenabled;
	}
	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
	}
}
