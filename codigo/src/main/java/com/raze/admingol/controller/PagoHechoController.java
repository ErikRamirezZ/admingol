package com.raze.admingol.controller;
import com.raze.admingol.domain.PagoHecho;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = PagoHecho.class)
@Controller
@RequestMapping("/pagohechoes")
@RooWebScaffold(path = "pagohechoes", formBackingObject = PagoHecho.class)
public class PagoHechoController {
}
