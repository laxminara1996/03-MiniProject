package in.laxmi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.laxmi.binding.RegisterForm;
import in.laxmi.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
    @GetMapping("/")
	public String indexPage(Model model) {
    	model.addAttribute("form", new RegisterForm());
		return "index";
	}
    
    @GetMapping("/register")
   	public String registerPage(Model model) {
       	model.addAttribute("form", new RegisterForm());
   		return "register";
   	}
    
    @GetMapping("/login")
   	public String loginrPage(Model model) {
       	model.addAttribute("form", new RegisterForm());
   		return "login";
   	}
    
    @PostMapping("/login")
    public String login(@ModelAttribute("form") RegisterForm form,Model model) {
    	boolean status = service.getUser(form);
    	if(status) {
    		model.addAttribute("MSG", "user Login");
    	}else {
    		model.addAttribute("err", "user Login failed");
    	}
    	return "redirect:dashboard";
    }
    @GetMapping("/dashboard")
    public String dashBoardPage(Model model) {
    	return "dashboard";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute("form") RegisterForm form,Model model) {
    	boolean status = service.saveUser(form);
    	if(status) {
    		model.addAttribute("msg", "user Registerd success fully");
    	}else {
    		model.addAttribute("err", "user Registration failed");

    	}
    	return "register";
    }
	
}
