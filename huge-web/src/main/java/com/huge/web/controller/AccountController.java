package com.huge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	@RequestMapping("user/account")
	public String goAccount(){
		return "account";
	}
}
