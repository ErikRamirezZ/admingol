package com.raze.admingol.controller;
import com.raze.admingol.catalog.Accion;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Accion.class)
@Controller
@RequestMapping("/accions")
@RooWebScaffold(path = "accions", formBackingObject = Accion.class)
@RooWebFinder
public class AccionController {
}
