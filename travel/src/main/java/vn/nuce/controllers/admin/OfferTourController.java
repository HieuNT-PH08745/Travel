package vn.nuce.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class OfferTourController {

    @GetMapping("/offertour")
    public String image(ModelMap modelMap) {
        modelMap.addAttribute("offertour", modelMap);
        return "/admin/offertour";
    }
}
