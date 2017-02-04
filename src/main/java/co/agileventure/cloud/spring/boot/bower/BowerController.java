/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.spring.boot.bower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DESARROLLO 13
 */
@Controller
public class BowerController {

    @RequestMapping("/hola")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name
    , @RequestParam(value = "descripcion", required = false, defaultValue = "Mira las estrellas") String descripcion) {
        model.addAttribute("name", name);
        model.addAttribute("descripcion", descripcion);
        return "hello";
    }
}
