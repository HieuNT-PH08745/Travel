package vn.nuce.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.RestaurantDto;
import vn.nuce.dto.UserDto;
import vn.nuce.service.impl.RestaurantServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl service;

    @GetMapping("/restaurant")
    public String showPage(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("restaurant") != null) {
            RestaurantDto dto = (RestaurantDto) session.getAttribute("restaurant");
            modelMap.addAttribute("dto", dto);
        }
        List<RestaurantDto> vehicleDtos = service.findAllRestaurant();
        modelMap.addAttribute("restaurants", vehicleDtos);
        if (session.getAttribute("status") != null) {
            modelMap.addAttribute("status",session.getAttribute("status"));
            session.removeAttribute("status");
        }
        return "/admin/restaurant";
    }

    @GetMapping("/restaurant/{id}")
    @ResponseBody
    public RestaurantDto getRestaurantDto(@PathVariable Long id) {
        return service.findOneRestaurant(id);
    }


    @PostMapping("/restaurant/{action}")
    public String insertVehicle(@PathVariable String action,
                                @RequestParam(name = "restaurant_Id") Long restaurant_Id,
                                @RequestParam(name = "restaurant_Name") String restaurant_Name,
                                @RequestParam(name = "restaurant_Owners") String restaurant_Owners,
                                @RequestParam(name = "restaurant_Price") Long restaurant_Price,
                                @RequestParam(name = "restaurant_Phone") String restaurant_Phone,
                                @RequestParam(name = "restaurant_Link") String restaurant_Link,
                                @RequestParam(name = "restaurant_Status") Long restaurant_Status,
                                HttpSession session) {
        RestaurantDto dto = new RestaurantDto();
        dto.setRestaurant_Id(restaurant_Id);
        dto.setRestaurant_Name(restaurant_Name);
        dto.setRestaurant_Owners(restaurant_Owners);
        dto.setRestaurant_Phone(restaurant_Phone);
        dto.setRestaurant_Price(restaurant_Price);
        dto.setRestaurant_Link(restaurant_Link);
        dto.setRestaurant_Status(restaurant_Status);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dto.setRestaurant_Time(timestamp);
        switch (action) {
            case "create":
                service.saveRestaurant(dto);
                session.setAttribute("status", "success");
                break;
            case "update":
                dto.setRestaurant_Id(restaurant_Id);
                service.updateRestaurant(dto);
                session.setAttribute("status", "success");
                break;
        }
        return "redirect:/admin/restaurant";
    }

    private void setUser(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto = (UserDto) session.getAttribute("user");
            modelMap.addAttribute("dto", dto);
        }
    }
}
