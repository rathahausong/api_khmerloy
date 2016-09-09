package khmerloy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControlller {
	@RequestMapping(value={"/","/login"})
	public String login(){
		return "login";
	}
}
