package vn.nuce.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.AccommodationDto;
import vn.nuce.dto.UserDto;
import vn.nuce.service.impl.AccommodationServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AccommodationController {

    @Autowired
    AccommodationServiceImpl service;

    @GetMapping("/accommodation")
    public String showPage(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("accommodation") != null) {
            AccommodationDto dto = (AccommodationDto) session.getAttribute("accommodation");
            modelMap.addAttribute("dto", dto);
        }
        List<AccommodationDto> vehicleDtos = service.findAllAccommodation();
        modelMap.addAttribute("accommodations", vehicleDtos);
        if (session.getAttribute("status") != null) {
            modelMap.addAttribute("status",session.getAttribute("status"));
            session.removeAttribute("status");
        }
        return "/admin/accommodation";
    }

    @GetMapping("/accommodation/{id}")
    @ResponseBody
    public AccommodationDto getAccommodationDto(@PathVariable Long id) {
        return service.findOneAccommodation(id);
    }


    @PostMapping("/accommodation/{action}")
    public String insertVehicle(@PathVariable String action,
                                @RequestParam(name = "accommodation_Id") Long accommodation_Id,
                                @RequestParam(name = "accommodation_Name") String accommodation_Name,
                                @RequestParam(name = "accommodation_Owners") String accommodation_Owners,
                                @RequestParam(name = "accommodation_Price") Long accommodation_Price,
                                @RequestParam(name = "accommodation_Phone") String accommodation_Phone,
                                @RequestParam(name = "accommodation_Link") String accommodation_Link,
                                @RequestParam(name = "accommodation_Status") Long accommodation_Status,
                                HttpSession session) {
        AccommodationDto dto = new AccommodationDto();
        dto.setAccommodation_Id(accommodation_Id);
        dto.setAccommodation_Name(accommodation_Name);
        dto.setAccommodation_Owners(accommodation_Owners);
        dto.setAccommodation_Phone(accommodation_Phone);
        dto.setAccommodation_Price(accommodation_Price);
        dto.setAccommodation_Link(accommodation_Link);
        dto.setAccommodation_Status(accommodation_Status);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dto.setAccommodation_Time(timestamp);
        switch (action) {
            case "create":
                service.saveAccommodation(dto);
                session.setAttribute("status", "success");
                break;
            case "update":
                dto.setAccommodation_Id(accommodation_Id);
                service.updateAccommodations(dto);
                session.setAttribute("status", "success");
                break;
        }
        return "redirect:/admin/accommodation";
    }


//    @GetMapping("/qlphuongtien")
//    public String updatePhuongTien(@RequestParam(name = "action") String action,
//                             @RequestParam(name = "maPhuongTien") Long maPhuongTien,
//                             HttpSession session) {
//        if (action.equals("delete")) {
//            List<Long> ids = new ArrayList<>();
//            ids.add(maPhuongTien);
////            service.deleteUser(ids);
//            session.setAttribute("status","success");
//        }
//        return "redirect:/admin/qlphuongtien";
//    }

    private void setUser(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto = (UserDto) session.getAttribute("user");
            modelMap.addAttribute("dto", dto);
        }
    }

}
