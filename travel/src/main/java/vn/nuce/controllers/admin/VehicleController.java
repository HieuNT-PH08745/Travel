package vn.nuce.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.PhuongTienDto;
import vn.nuce.dto.UserDto;
import vn.nuce.dto.VehicleDto;
import vn.nuce.service.impl.PhuongTienServiceImpl;
import vn.nuce.service.impl.VehicleServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class VehicleController {
    @Autowired
    VehicleServiceImpl service;

    @GetMapping("/vehicle")
    public String showPage(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("vehicle") != null) {
            VehicleDto dto = (VehicleDto) session.getAttribute("vehicle");
            modelMap.addAttribute("dto", dto);
        }
        List<VehicleDto> vehicleDtos = service.findAllVehicle();
        modelMap.addAttribute("vehicles", vehicleDtos);
        if (session.getAttribute("status") != null) {
            modelMap.addAttribute("status",session.getAttribute("status"));
            session.removeAttribute("status");
        }
        return "/admin/vehicle";
    }

    @GetMapping("/vehicle/{id}")
    @ResponseBody
    public VehicleDto getVehicleDto(@PathVariable Long id) {
        return service.findOneVehicle(id);
    }


    @PostMapping("/vehicle/{action}")
    public String insertVehicle(@PathVariable String action,
                                   @RequestParam(name = "vehicle_Id") Long vehicle_Id,
                                   @RequestParam(name = "vehicle_Name") String vehicle_Name,
                                   @RequestParam(name = "vehicle_Types") Long vehicle_Types,
                                   @RequestParam(name = "vehicle_Seats") Long vehicle_Seats,
                                   @RequestParam(name = "vehicle_Price") Long vehicle_Price,
                                   @RequestParam(name = "vehicle_Phone") String vehicle_Phone,
                                   @RequestParam(name = "vehicle_Deliverytime") Long vehicle_Deliverytime,
                                   @RequestParam(name = "vehicle_Status") Long vehicle_Status,
                                   HttpSession session) {
        VehicleDto dto = new VehicleDto();
        dto.setVehicle_Name(vehicle_Name);
        dto.setVehicle_Types(vehicle_Types);
        dto.setVehicle_Seats(vehicle_Seats);
        dto.setVehicle_Price(vehicle_Price);
        dto.setVehicle_Phone(vehicle_Phone);
        dto.setVehicle_Deliverytime(vehicle_Deliverytime);
        dto.setVehicle_Status(vehicle_Status);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dto.setVehicle_Time(timestamp);
        switch (action) {
            case "create":
                service.saveVehicle(dto);
                session.setAttribute("status", "success");
                break;
            case "update":
                dto.setVehicle_Id(vehicle_Id);
                service.updateVehicles(dto);
                session.setAttribute("status", "success");
                break;
        }
        return "redirect:/admin/vehicle";
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
