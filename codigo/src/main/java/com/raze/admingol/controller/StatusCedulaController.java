package com.raze.admingol.controller;
import com.raze.admingol.catalog.StatusCedula;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = StatusCedula.class)
@Controller
@RequestMapping("/statuscedulas")
@RooWebScaffold(path = "statuscedulas", formBackingObject = StatusCedula.class)
@RooWebFinder
public class StatusCedulaController {
}
