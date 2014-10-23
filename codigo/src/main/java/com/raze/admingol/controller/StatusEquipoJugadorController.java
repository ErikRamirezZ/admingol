package com.raze.admingol.controller;
import com.raze.admingol.catalog.StatusEquipoJugador;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = StatusEquipoJugador.class)
@Controller
@RequestMapping("/statusequipojugadors")
@RooWebScaffold(path = "statusequipojugadors", formBackingObject = StatusEquipoJugador.class)
@RooWebFinder
public class StatusEquipoJugadorController {
}
