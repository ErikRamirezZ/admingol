package com.raze.admingol.controller;
import com.raze.admingol.domain.TorneoEquipo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = TorneoEquipo.class)
@Controller
@RequestMapping("/torneoequipoes")
@RooWebScaffold(path = "torneoequipoes", formBackingObject = TorneoEquipo.class)
@RooWebFinder
public class TorneoEquipoController {
}
