package com.raze.admingol.controller;
import com.raze.admingol.domain.Cargo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Cargo.class)
@Controller
@RequestMapping("/cargoes")
@RooWebScaffold(path = "cargoes", formBackingObject = Cargo.class)
@RooWebFinder
public class CargoController {
}