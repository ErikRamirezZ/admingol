package com.raze.admingol.controller;
import com.raze.admingol.domain.Estadisticas;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Estadisticas.class)
@Controller
@RequestMapping("/estadisticases")
@RooWebScaffold(path = "estadisticases", formBackingObject = Estadisticas.class)
@RooWebFinder
public class EstadisticasController {
}
