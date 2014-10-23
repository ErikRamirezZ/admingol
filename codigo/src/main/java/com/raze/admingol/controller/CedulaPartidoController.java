package com.raze.admingol.controller;
import com.raze.admingol.domain.CedulaPartido;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = CedulaPartido.class)
@Controller
@RequestMapping("/cedulapartidoes")
@RooWebScaffold(path = "cedulapartidoes", formBackingObject = CedulaPartido.class)
@RooWebFinder
public class CedulaPartidoController {
}
