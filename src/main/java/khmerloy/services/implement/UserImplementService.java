package khmerloy.services.implement;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import khmerloy.enities.User;
import khmerloy.services.UserServcie;

@Service
@Qualifier("userimplementservice")
public class UserImplementService implements UserServcie {
	@Override
	public User findUserByUsername(String email) {
		User user = new User();
		user.setUser_name("sim ratha");
		user.setEmail("ratha@gmail.com");
		user.setPassword("12345");
		user.setRole("admin");
		user.setIsenabled(true);
		return user;
	}

}
