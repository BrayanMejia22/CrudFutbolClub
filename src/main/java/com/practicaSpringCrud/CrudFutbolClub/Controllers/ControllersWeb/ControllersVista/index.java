package com.practicaSpringCrud.CrudFutbolClub.Controllers.ControllersWeb.ControllersVista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {

    @GetMapping("/index")
    public String showIndexPage() {
        return "index/index";
    }

}
