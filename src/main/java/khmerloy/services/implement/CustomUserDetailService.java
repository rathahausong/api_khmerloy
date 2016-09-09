package khmerloy.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import khmerloy.enities.User;

@Service
@Qualifier("customuser")
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	@Qualifier("userimplementservice")
	private UserImplementService userimplementservice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userimplementservice.findUserByUsername(username);
		if(user==null){
			System.out.println("Not found user ");
			throw new UsernameNotFoundException("Not Found User !");
		}
		return user;
	}

}
