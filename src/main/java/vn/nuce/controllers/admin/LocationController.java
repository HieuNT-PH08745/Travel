package vn.nuce.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.ProvincialDto;
import vn.nuce.dto.UserDto;
import vn.nuce.dto.ImageDto;
import vn.nuce.service.impl.ProvincialServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class LocationController {

    @Autowired
    ProvincialServiceImpl service;

    @GetMapping("/location")
    public String showPage(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("location") != null) {
            ProvincialDto dto = (ProvincialDto) session.getAttribute("location");
            modelMap.addAttribute("dto", dto);
        }
        List<ProvincialDto> vehicleDtos = service.findAllProvincial();
        modelMap.addAttribute("locations", vehicleDtos);
        if (session.getAttribute("status") != null) {
            modelMap.addAttribute("status",session.getAttribute("status"));
            session.removeAttribute("status");
        }
        return "/admin/location";
    }

    @GetMapping("/location/{id}")
    @ResponseBody
    public ProvincialDto getImageDto(@PathVariable Long id) {
        return service.findOneProvincial(id);
    }


    @PostMapping("/location/{action}")
    public String insertImage(@PathVariable String action,
                              @RequestParam(name = "image_Id") Long image_Id,
                              @RequestParam(name = "image_Url") String image_Url,
                              HttpSession session) {
        ProvincialDto dto = new ProvincialDto();
        dto.setProvincial_Name(image_Url);

        switch (action) {
            case "create":
                service.saveProvincial(dto);
                session.setAttribute("status", "success");
                break;
            case "update":
                dto.setProvincial_Id(image_Id);
                service.updateProvincial(dto);
                session.setAttribute("status", "success");
                break;
        }
        return "redirect:/admin/image";
    }

    private void setUser(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("user") != null) {
            UserDto dto = (UserDto) session.getAttribute("user");
            modelMap.addAttribute("dto", dto);
        }
    }
}
