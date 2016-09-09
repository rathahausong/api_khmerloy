package khmerloy.configuration.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("ajaxAuthenticationSucessHandler")
public class AjaxAuthenticationSucessHandler  implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpservletrequest, HttpServletResponse httpservletrespone, Authentication authorication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub\
		String url = this.determineTargetURL(authorication);
		System.out.println("Principal "+authorication.getPrincipal());
		httpservletrespone.sendRedirect(url);
		
	}
	
	private String determineTargetURL(Authentication authorication){
		
		System.out.println("Authori "+authorication.getPrincipal());
		
		Collection<? extends GrantedAuthority> athories = authorication.getAuthorities();
		
		List<String> role = new ArrayList<>();
		
		for(GrantedAuthority aths : athories){
			role.add(aths.getAuthority());
		}
		
		if(role.contains("ROLE_ADMIN")){
			
			return "/swagger-ui.html";
		}
		return "/login";
	}

}
