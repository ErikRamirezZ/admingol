package com.raze.admingol.controller;
import com.raze.admingol.catalog.Posicion;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Posicion.class)
@Controller
@RequestMapping("/posicions")
@RooWebScaffold(path = "posicions", formBackingObject = Posicion.class)
@RooWebFinder
public class PosicionController {
}
