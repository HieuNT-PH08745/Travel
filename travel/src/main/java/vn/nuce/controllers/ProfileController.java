package vn.nuce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.TourDto;
import vn.nuce.dto.UserDto;
import vn.nuce.service.impl.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/home")
@Controller
public class ProfileController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/profile")
    public String showPageDefault(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto = (UserDto) session.getAttribute("user");
            modelMap.addAttribute("dto", dto);
        }
        List<UserDto> users = service.findAllUsers();
        modelMap.addAttribute("users", users);
        if (session.getAttribute("status") != null) {
            modelMap.addAttribute("status",session.getAttribute("status"));
            session.removeAttribute("status");
        }
        return "profile";
    }

//    private String checkRoleAccount(Long role) {
//        if (role == 0) {
//            return "redirect:/home";
//        } else if (role == 1) {
//            return "redirect:/admin/home";
//        } else if (role == 2) {
//            return "redirect:/admin/home";
//        }
//        return "redirect:/home";
//    }

    @GetMapping("/profile/{id}")
    @ResponseBody
    public UserDto getUserDto(@PathVariable Long id) {
        return service.findOneUser(id);
    }

    @GetMapping("/profiles")
    public String updateUser(@RequestParam(name = "action") String action,
                             @RequestParam(name = "user_Id") Long user_Id,
                             HttpSession session) {
        if (action.equals("delete")) {
            List<Long> ids = new ArrayList<>();
            ids.add(user_Id);
            service.deleteUser(ids);
            session.setAttribute("status","success");
        }
        return "redirect:profile";
    }

    @PostMapping("/profile/{action}")
    public String saveUser(@PathVariable String action,
                           @RequestParam(name = "user_Id") Long user_Id,
                           @RequestParam(name = "user_Fullname") String user_Fullname,
                           @RequestParam(name = "user_Name") String user_Name,
                           @RequestParam(name = "user_Password") String user_Password,
                           @RequestParam(name = "user_Role") Long user_Role,
                           @RequestParam(name = "user_Gender") Long user_Gender,
                           @RequestParam(name = "user_Phone") String user_Phone,
                           @RequestParam(name = "user_Email") String user_Email,
                           @RequestParam(name = "user_Status") Long user_Status,
                           HttpSession session) {
        UserDto userDto = new UserDto();
        userDto.setUser_Fullname(user_Fullname);
        userDto.setUser_Name(user_Name);
        userDto.setUser_Password(user_Password);
        userDto.setUser_Gender(user_Gender);
        userDto.setUser_Phone(user_Phone);
        userDto.setUser_Email(user_Email);
        userDto.setUser_Status(user_Status);
        userDto.setUser_Role(user_Role);
        switch (action) {
            case "create":
//                String encodePassword = Utils.encodePasswordMD5(user_Password);
//                userDto.setUser_Password(encodePassword);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                userDto.setUser_Createdate(timestamp);
                userDto.setUser_Lastupdate(timestamp);
                service.saveUser(userDto);
                session.setAttribute("status","success");
                break;
            case "update":
                userDto.setUser_Id(user_Id);
                userDto.setUser_Password(user_Password);
                Timestamp lasttimestamp = new Timestamp(System.currentTimeMillis());
                userDto.setUser_Lastupdate(lasttimestamp);
//                Timestamp createdDate = Timestamp.valueOf(request.getParameter("user_Createdate"));
//                userDto.setUser_Createdate(createdDate);
//                userDto.setUser_Lastupdate(createdDate);
                service.updateUser(userDto);
                session.setAttribute("status","success");
                break;
        }
        return "redirect:profile";
    }
}

