package vn.nuce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.nuce.dto.BookTourDto;
import vn.nuce.dto.TourDto;
import vn.nuce.dto.UserDto;
import vn.nuce.service.BookTourService;
import vn.nuce.service.TourService;
import vn.nuce.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RequestMapping("/home")
@Controller
public class UserInfoController {

    @Autowired
    TourService tourService;

    @Autowired
    BookTourService bookTourService;

    @Autowired
    UserService userService;

    @GetMapping("/user_info")
    public String showUserInfo(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto1 = (UserDto) session.getAttribute("user");
            UserDto dto = userService.findOneUser(dto1.getUser_Id());
            dto.setBase64Image(Base64.getEncoder().encodeToString(dto.getImage()));
            List<BookTourDto> bookTourDtos = userService.findBookTourByUserId(dto.getUser_Id());
            List<BookTourDto> bookTourDtos1 = userService.findBookTourWaitByUserId(dto.getUser_Id());
            modelMap.addAttribute("listBookTourWait", bookTourDtos1);
            modelMap.addAttribute("listBookTour", bookTourDtos);
            modelMap.addAttribute("dto", dto);
        }
        return "user_info";
    }


    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "action") String action, @RequestParam(name = "id") Long id, HttpSession httpSession) {
        if (action.equals("delete")) {
            List<Long> ids = new ArrayList<>();
            ids.add(id);
            bookTourService.remove(ids);
        }

        return "redirect:/home/user_info";
    }

    @GetMapping("/user_info/update")
    public String showUpdateUser(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto1 = (UserDto) session.getAttribute("user");
            UserDto dto = userService.findOneUser(dto1.getUser_Id());
            dto.setBase64Image(Base64.getEncoder().encodeToString(dto.getImage()));
            modelMap.addAttribute("dto", dto);
            List<UserDto> userDtos = userService.findAllUsers();
            List<String> emails = new ArrayList<>();
            List<String> phones = new ArrayList<>();
            for (UserDto userDto : userDtos) {
                if (userDto.getUser_Id() != dto.getUser_Id()) {
                    emails.add(userDto.getUser_Email());
                    phones.add(userDto.getUser_Phone());
                }
            }
            modelMap.addAttribute("listEmail", emails);
            modelMap.addAttribute("listPhone", phones);
        }
        return "update_user";
    }

    @PostMapping("/user_info/update")
    public String updateUser(@ModelAttribute("dto") UserDto userDto, @RequestParam(name = "file") MultipartFile image) {
        try {
            if (!image.getOriginalFilename().isEmpty()) {
                userDto.setImage(image.getBytes());
            }
            userDto.setUser_Lastupdate(Timestamp.valueOf(LocalDateTime.now()));
            userDto.setBase64Image(Base64.getEncoder().encodeToString(userDto.getImage()));
            userService.updateUser(userDto);
            return "redirect:/home/user_info";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/user_info/change_password")
    public String showChangePassword(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto1 = (UserDto) session.getAttribute("user");
            UserDto dto = userService.findOneUser(dto1.getUser_Id());
            dto.setBase64Image(Base64.getEncoder().encodeToString(dto.getImage()));
            modelMap.addAttribute("dto", dto);
        }
        return "change-password";
    }

    @PostMapping("/user_info/change_password")
    public String changePassword(@ModelAttribute("dto") UserDto userDto, @RequestParam(name = "newPass") String password) {
        userDto.setUser_Password(password);
        userDto.setUser_Lastupdate(Timestamp.valueOf(LocalDateTime.now()));
        userDto.setBase64Image(Base64.getEncoder().encodeToString(userDto.getImage()));
        userService.updateUser(userDto);

        return "redirect:/home/user_info";
    }

}
