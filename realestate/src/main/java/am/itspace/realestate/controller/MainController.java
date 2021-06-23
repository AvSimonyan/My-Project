package am.itspace.realestate.controller;

import am.itspace.realestate.model.CurrentUser;
import am.itspace.realestate.model.User;
import am.itspace.realestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String main(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser){
     if (currentUser !=null) {
         modelMap.addAttribute("currentUser", currentUser.getUser());
     }
     return "index";
    }

    @GetMapping("/signIn")
    public String signIn(ModelMap modelMap,@AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser !=null) {
            modelMap.addAttribute("currentUser", currentUser.getUser());
        }
        return "signin";
    }
    @GetMapping("/register")
    public String registerGet(ModelMap modelMap,@AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser !=null) {
            modelMap.addAttribute("currentUser", currentUser.getUser());
        }
        return "register";
    }


    @PostMapping("/register")
    public String registerPost (@ModelAttribute User user){
      user.setPassword(passwordEncoder.encode(user.getPassword()));
   userRepository.save(user);
   return "redirect:/signIn";
    }
}
