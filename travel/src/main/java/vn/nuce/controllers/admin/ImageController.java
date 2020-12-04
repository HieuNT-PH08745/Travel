package vn.nuce.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import vn.nuce.dto.UserDto;
import vn.nuce.dto.ImageDto;
import vn.nuce.service.impl.ImageServiceImpl;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class ImageController {

    @Autowired
    ImageServiceImpl service;

    @GetMapping("/image")
    public String showPage(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("image") != null) {
            ImageDto dto = (ImageDto) session.getAttribute("image");
            modelMap.addAttribute("dto", dto);
        }
        List<ImageDto> vehicleDtos = service.findAllImage();
        modelMap.addAttribute("images", vehicleDtos);
        if (session.getAttribute("status") != null) {
            modelMap.addAttribute("status",session.getAttribute("status"));
            session.removeAttribute("status");
        }
        return "/admin/image";
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    public ImageDto getImageDto(@PathVariable Long id) {
        return service.findOneImage(id);
    }


    @PostMapping("/image/{action}")
    public String insertImage(@PathVariable String action,
                                @RequestParam(name = "image_Id") Long image_Id,
                                @RequestParam(name = "image_Url") String image_Url,
                                HttpSession session) {
        ImageDto dto = new ImageDto();
        dto.setImage_Url(image_Url);

        switch (action) {
            case "create":
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                dto.setImage_Time(timestamp);
                service.saveImage(dto);
                session.setAttribute("status", "success");
                break;
            case "update":
                dto.setImage_Id(image_Id);
                Timestamp timestamps = new Timestamp(System.currentTimeMillis());
                dto.setImage_Time(timestamps);
                service.updateImages(dto);
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
