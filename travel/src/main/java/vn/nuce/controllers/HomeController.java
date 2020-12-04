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

    @GetMapping("/book/{id}")
    public String bookTourById(@PathVariable Long id,HttpSession httpSession, ModelMap modelMap) {
        setUser(httpSession, modelMap);
        List<TourDto> tourDtos = tourService.findAllTours();
//      pmodelMap.addAttribute("tours", tourDtos);
        TourDto tourDto = tourService.findOneTour(id);

        modelMap.addAttribute("tour", tourDto);
        return "book";
    }

    @PostMapping("/book/{id}")
    public String bookTour(@PathVariable Long id, @RequestParam(name = "name1") String name,
                           @RequestParam(name = "email1") String email,
                           @RequestParam(name = "address1") String address,
                           @RequestParam(name = "phone1") String phone,
                           @RequestParam(name = "note1") String note) {
        BookTourDto dto = new BookTourDto();
        dto.setId(id);
        dto.setName(name);
        dto.setEmail(email);
        dto.setAddress(address);
        dto.setPhone(phone);
        dto.setNote(note);
        dto.setTourId(id);

        try {
            bookTourService.save(dto);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "/success";
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
