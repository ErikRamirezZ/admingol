package com.raze.admingol.controller;
import com.raze.admingol.domain.Cancha;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Cancha.class)
@Controller
@RequestMapping("/canchas")
@RooWebScaffold(path = "canchas", formBackingObject = Cancha.class)
@RooWebFinder
public class CanchaController {
}
