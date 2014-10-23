package com.raze.admingol.controller;
import com.raze.admingol.catalog.StatusPartido;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = StatusPartido.class)
@Controller
@RequestMapping("/statuspartidoes")
@RooWebScaffold(path = "statuspartidoes", formBackingObject = StatusPartido.class)
@RooWebFinder
public class StatusPartidoController {
}
