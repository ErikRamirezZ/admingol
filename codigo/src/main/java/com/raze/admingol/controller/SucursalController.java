package com.raze.admingol.controller;
import com.raze.admingol.domain.Sucursal;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Sucursal.class)
@Controller
@RequestMapping("/sucursals")
@RooWebScaffold(path = "sucursals", formBackingObject = Sucursal.class)
@RooWebFinder
public class SucursalController {
}