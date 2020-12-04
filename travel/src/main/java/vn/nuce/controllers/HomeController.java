package vn.nuce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.BookTourDto;
import vn.nuce.dto.TourDto;
import vn.nuce.dto.UserDto;
import vn.nuce.service.impl.BookTourServiceImpl;
import vn.nuce.service.impl.TourServiceImpl;
import vn.nuce.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    UserServiceImpl service;

    @Autowired
    TourServiceImpl tourService;

    @Autowired
    BookTourServiceImpl bookTourService;

    @GetMapping
    public String showPage(HttpSession session, ModelMap modelMap) {
        UserDto dto = null;
        if (session.getAttribute("user") != null) {
            dto = (UserDto) session.getAttribute("user");
        }
        if (dto != null) {
            modelMap.addAttribute("dto", dto);
        }
        return "home";
    }

    private void setUser(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto = (UserDto) session.getAttribute("user");
            modelMap.addAttribute("dto", dto);
        }
    }

    @GetMapping("/tourDetail")
    public String image(ModelMap modelMap) {
        modelMap.addAttribute("location", modelMap);
        return "/admin/tour_detail";
    }



}
