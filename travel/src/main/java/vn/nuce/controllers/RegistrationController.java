package vn.nuce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.nuce.dto.UserDto;
import vn.nuce.service.impl.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class RegistrationController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/registration")
    public String showPageDefault(ModelMap modelMap) {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(
                           @RequestParam(name = "user_Name") String user_Name,
                           @RequestParam(name = "user_Password") String user_Password,
                           @RequestParam(name = "REuser_Password") String REuser_Password,
                           @RequestParam(name = "user_Role") Long user_Role,
                           @RequestParam(name = "user_Email") String user_Email,
                           @RequestParam(name = "user_Status") Long user_Status,
                           HttpSession session) {
        UserDto userDto = new UserDto();
            userDto.setUser_Name(user_Name);
            userDto.setUser_Password(user_Password);
            userDto.setUser_Email(user_Email);
            userDto.setUser_Status(user_Status);
            userDto.setUser_Role(user_Role);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            userDto.setUser_Createdate(timestamp);
            userDto.setUser_Lastupdate(timestamp);
            if (REuser_Password.equals(user_Password)){
                service.saveUser(userDto);
                session.setAttribute("status","success");
            } else {
                session.setAttribute("status","fail");
            }
        return "redirect:/login";

    }


}
