package com.raze.admingol.controller;
import com.raze.admingol.catalog.Rol;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Rol.class)
@Controller
@RequestMapping("/rols")
@RooWebScaffold(path = "rols", formBackingObject = Rol.class)
@RooWebFinder
public class RolController {
}
